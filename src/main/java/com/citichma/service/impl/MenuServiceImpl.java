package com.citichma.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citichma.common.vo.EUDataGridResult;
import com.citichma.common.vo.EUTreeCBNode;
import com.citichma.common.vo.EUTreeGridNode;
import com.citichma.common.vo.EUTreeNode;
import com.citichma.mapper.TMenuInfoMapper;
import com.citichma.pojo.TMenuInfo;
import com.citichma.pojo.TMenuInfoExample;
import com.citichma.pojo.TMenuInfoExample.Criteria;
import com.citichma.service.MenuService;
import com.citichma.valenum.IsDelEnum;
/**
 * 
 * @Description: 菜单相关
 * @author JIXD 
 * @date 2016年7月5日 下午9:58:46  
 *
 */
@Service
public class MenuServiceImpl implements MenuService {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuServiceImpl.class);
	
	@Autowired
	private TMenuInfoMapper menuInfoMapper;
	
	@Override
	public int saveMenu(TMenuInfo menuInfo) {
		return menuInfoMapper.insertSelective(menuInfo);
	}

	@Override
	public int updateMenu(TMenuInfo menuInfo) {
		return menuInfoMapper.updateByPrimaryKeySelective(menuInfo);
	}

	@Override
	public TMenuInfo findMenuById(int id) {
		return menuInfoMapper.selectByPrimaryKey(id);
	}

	@Override
	public EUDataGridResult getMenuList() {
		TMenuInfoExample tMenuInfoExample = new TMenuInfoExample();
		Criteria criteria = tMenuInfoExample.createCriteria();
		criteria.andIsDelEqualTo(IsDelEnum.NO_DEL.getCode());
		List<TMenuInfo> menuList = menuInfoMapper.selectByExample(tMenuInfoExample);
		List<EUTreeGridNode> treeNodeList = new ArrayList<EUTreeGridNode>();
		for(TMenuInfo menuInfo : menuList){
			EUTreeGridNode node = new EUTreeGridNode();
			node.setId(menuInfo.getId());
			node.set_parentId(menuInfo.getParentId() == 0?null:menuInfo.getParentId());
			node.setMenuOrder(menuInfo.getMenuOrder());
			node.setName(menuInfo.getMenuName());
			node.setState(menuInfo.getIsParent()==1?"closed":null);
			node.setMenuUrl(menuInfo.getMenuUrl());
			node.setMenuType(menuInfo.getMenuType());
			treeNodeList.add(node);
		}
		EUDataGridResult gridResult = new EUDataGridResult();
		gridResult.setTotal(treeNodeList.size());
		gridResult.setRows(treeNodeList);
		return gridResult;
	}

	@Override
	public int getChildMenuCount(Integer paretnId) {
		TMenuInfoExample tMenuInfoExample = new TMenuInfoExample();
		Criteria criteria = tMenuInfoExample.createCriteria();
		criteria.andParentIdEqualTo(paretnId);
		criteria.andIsDelEqualTo(IsDelEnum.NO_DEL.getCode());
		return menuInfoMapper.countByExample(tMenuInfoExample);
	}

	@Override
	public List<EUTreeCBNode> getChildMenu(Integer parentId) {
		TMenuInfoExample tMenuInfoExample = new TMenuInfoExample();
		Criteria criteria = tMenuInfoExample.createCriteria();
		criteria.andParentIdEqualTo(parentId);
		criteria.andIsDelEqualTo(IsDelEnum.NO_DEL.getCode());
		List<TMenuInfo> list = menuInfoMapper.selectByExample(tMenuInfoExample);
		List<EUTreeCBNode> resultList = new ArrayList<EUTreeCBNode>();
		for(TMenuInfo menu:list){
			EUTreeCBNode treeNode = new EUTreeCBNode();
			treeNode.setId(menu.getId());
			treeNode.setText(menu.getMenuName());
			treeNode.setState(menu.getIsParent() == 1?"closed":"open");
			resultList.add(treeNode);
		}
		return resultList;
	}
	
}
