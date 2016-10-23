package com.citichma.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.alibaba.fastjson.JSONObject;
import com.citichma.common.request.ProductPlanParam;
import com.citichma.common.util.Check;
import com.citichma.common.util.DateUtil;
import com.citichma.common.vo.EUDataGridResult;
import com.citichma.common.vo.ProductPlanDetailVo;
import com.citichma.common.vo.ProductPlanItemVo;
import com.citichma.common.vo.ProductPlanWithTimeNode;
import com.citichma.mapper.ProductPlanMapper;
import com.citichma.mapper.TimeNodeMapper;
import com.citichma.pojo.ProductPlan;
import com.citichma.pojo.ProductPlanExample;
import com.citichma.pojo.ProductPlanExample.Criteria;
import com.citichma.pojo.TimeNode;
import com.citichma.pojo.TimeNodeExample;
import com.citichma.service.ProductPlanService;
import com.citichma.valenum.IsDelEnum;
import com.citichma.valenum.NodeTypeEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 
 * 生产计划服务类
 * @author JIXD 
 * @date 2016年8月7日 上午11:35:14  
 *
 */
@Service
public class ProductPlanServiceImpl implements ProductPlanService {

	@Autowired
	private ProductPlanMapper productPlanMapper;
	
	@Autowired
	private TimeNodeMapper timeNodeMapper;
	
	@Override
	public int saveProductPlan(ProductPlan productPlan) {
		return productPlanMapper.insertSelective(productPlan);
	}

	@Override
	public int updateProductPlan(ProductPlan productPlan) {
		return productPlanMapper.updateByPrimaryKeySelective(productPlan);
	}

	@Override
	public EUDataGridResult findProductPlan(ProductPlanParam request) {
		ProductPlanExample planExample = new ProductPlanExample();
		Criteria criteria = planExample.createCriteria();
		criteria.andIsDelEqualTo(IsDelEnum.NO_DEL.getCode());
		if(!Check.NuNStr(request.getWorkSn())){
			criteria.andWorkSnLike("%"+request.getWorkSn()+"%");
		}
		if(!Check.NuNStr(request.getProductName())){
			criteria.andProductNameLike("%"+request.getProductName()+"%");
		}
		if(!Check.NuNObj(request.getStartadjustDeliverDate()) && !Check.NuNObj(request.getEndadjustDeliverDate())){
			criteria.andAdjustDeliverDateBetween(request.getStartadjustDeliverDate(), request.getEndadjustDeliverDate());
		}
		if(!Check.NuNStr(request.getProjectLeader())){
			criteria.andProjectLeaderLike("%"+request.getProjectLeader()+"%");
		}
		/*if(!Check.NuNObj(request.getProjectStatus())){
			criteria.andProjectStatusEqualTo(request.getProjectStatus());
		}*/
		if(!Check.NuNStr(request.getProjectStatusList())){
			List<Integer> statusList = JSONObject.parseArray(request.getProjectStatusList(), Integer.class);
			if(!Check.NuNCollection(statusList)){
				criteria.andProjectStatusIn(statusList);
			}
		}
		if(!Check.NuNStr(request.getChartSn())){
			criteria.andChartSnLike("%"+request.getChartSn()+"%");
		}
		
		planExample.setOrderByClause("last_modify_time desc");
		PageHelper.startPage(request.getPage(), request.getRows());
		List<ProductPlan> planList = productPlanMapper.selectByExample(planExample);
		List<ProductPlanItemVo> voList = new ArrayList<>();
		for(ProductPlan plan : planList){
			ProductPlanItemVo item = new ProductPlanItemVo();
			TimeNodeExample timeNodeExample = new TimeNodeExample();
			com.citichma.pojo.TimeNodeExample.Criteria criteria2 = timeNodeExample.createCriteria();
			criteria2.andPlanIdEqualTo(plan.getId());
			criteria2.andNodeTypeEqualTo(NodeTypeEnum.RKJD.getCode());
			List<TimeNode> timeNodeList = timeNodeMapper.selectByExample(timeNodeExample);
			BeanUtils.copyProperties(plan, item);
			if(!Check.NuNCollection(timeNodeList)){
				TimeNode timeNode = timeNodeList.get(0);
				item.setRkPlanDate(timeNode.getPlanFinishTime());
				item.setRkDate(timeNode.getActualFinishTime());
				if(timeNode.getActualFinishTime() == null){
					item.setCountdown(DateUtil.getDateIntervalNum(timeNode.getPlanFinishTime(), new Date()));
				}
			}
			voList.add(item);
		}
		
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(voList);
		PageInfo<ProductPlan> pageInfo = new PageInfo<>(planList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public int saveOrUpdateProductPlan(ProductPlan productPlan) {
		int count = 0;
		if(Check.NuNObj(productPlan.getId())){
			count =productPlanMapper.insertSelective(productPlan);
		}else{
			count =productPlanMapper.updateByPrimaryKeySelective(productPlan);
		}
		return count;
	}

	@Override
	public ProductPlanDetailVo findProductPlanDetailById(Integer id) {
		return productPlanMapper.findProductPlanDetailById(id);
	}

	@Override
	public List<ProductPlanWithTimeNode> findProductPlanWithNodeAll() {
		return productPlanMapper.findProductPlanWithNodeAll();
	}

}
