package com.citichma.service;

import java.util.List;

import com.citichma.common.request.ProductPlanParam;
import com.citichma.common.vo.EUDataGridResult;
import com.citichma.common.vo.ProductPlanDetailVo;
import com.citichma.common.vo.ProductPlanWithTimeNode;
import com.citichma.pojo.ProductPlan;

/**
 * 
 * 生产计划服务层
 * @author JIXD 
 * @date 2016年8月7日 上午10:56:57  
 *
 */
public interface ProductPlanService {

	/**
	 * 
	 * 新增生产计划 
	 * @param   
	 * @return 
	 * @date 2016年8月7日 上午10:59:07  
	 * @throws
	 */
	int saveProductPlan(ProductPlan productPlan);
	/**
	 * 
	 * 更新生产计划 
	 * @param   
	 * @return 
	 * @date 2016年8月7日 上午10:59:54  
	 * @throws
	 */
	int updateProductPlan(ProductPlan productPlan);
	
	/**
	 * 
	 * 新增或更新生产计划 
	 * @param   
	 * @return 
	 * @date 2016年8月9日 下午9:18:16  
	 * @throws
	 */
	int saveOrUpdateProductPlan(ProductPlan productPlan);
	
	/**
	 * 
	 * 条件查询生产计划 
	 * @param   
	 * @return 
	 * @date 2016年8月7日 上午11:05:16  
	 * @throws
	 */
	EUDataGridResult findProductPlan(ProductPlanParam request);
	
	/**
	 * 
	 * 查询生产计划详情 
	 * @param   
	 * @return 
	 * @date 2016年8月13日 下午3:28:06  
	 * @throws
	 */
	ProductPlanDetailVo findProductPlanDetailById(Integer id);
	
	/**
	 * 
	 * 查询所有生产计划列表 
	 * @param   
	 * @return 
	 * @date 2016年9月17日 下午10:38:58  
	 * @throws
	 */
	List<ProductPlanWithTimeNode> findProductPlanWithNodeAll();
}
