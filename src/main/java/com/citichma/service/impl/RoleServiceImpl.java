package com.citichma.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citichma.common.request.RoleRequestParam;
import com.citichma.common.util.Check;
import com.citichma.common.vo.EUDataGridResult;
import com.citichma.mapper.TRoleMapper;
import com.citichma.pojo.TRole;
import com.citichma.pojo.TRoleExample;
import com.citichma.pojo.TRoleExample.Criteria;
import com.citichma.pojo.TUser;
import com.citichma.pojo.TUserExample;
import com.citichma.service.RoleService;
import com.citichma.valenum.IsDelEnum;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
/**
 * 
 * @Description: 角色相关类
 * @author JIXD 
 * @date 2016年7月5日 下午9:42:31  
 *
 */
@Service
public class RoleServiceImpl implements RoleService {
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);
	
	@Autowired
	private TRoleMapper roleMapper;
	
	@Override
	public int saveRole(TRole role) {
		return roleMapper.insertSelective(role);
	}

	@Override
	public int updateRole(TRole role) {
		return roleMapper.updateByPrimaryKeySelective(role);
	}

	@Override
	public TRole findRoleById(int id) {
		return roleMapper.selectByPrimaryKey(id);
	}

	@Override
	public EUDataGridResult findRoleByPage(RoleRequestParam roleParam) {
		TRoleExample tRoleExample = new TRoleExample();
		Criteria criteria = tRoleExample.createCriteria();
		criteria.andIsDelEqualTo(IsDelEnum.NO_DEL.getCode());
		if(!Check.NuNStr(roleParam.getRoleName())){
			criteria.andRoleNameEqualTo(roleParam.getRoleName());
		}
		PageHelper.startPage(roleParam.getPage(), roleParam.getRows());
		List<TRole> roleList = roleMapper.selectByExample(tRoleExample);
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(roleList);
		PageInfo<TRole> pageInfo = new PageInfo<>(roleList);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public List<TRole> findAllRole() {
		TRoleExample tRoleExample = new TRoleExample();
		Criteria criteria = tRoleExample.createCriteria();
		criteria.andIsDelEqualTo(IsDelEnum.NO_DEL.getCode());
		List<TRole> roleList = roleMapper.selectByExample(tRoleExample);
		return roleList;
	}

}
