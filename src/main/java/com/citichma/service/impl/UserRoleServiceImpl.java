package com.citichma.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citichma.common.util.Check;
import com.citichma.mapper.TUserRoleMapper;
import com.citichma.pojo.TUserRole;
import com.citichma.pojo.TUserRoleExample;
import com.citichma.pojo.TUserRoleExample.Criteria;
import com.citichma.service.UserRoleService;
import com.citichma.valenum.IsDelEnum;
/**
 * 
 * @Description: 用户角色关联
 * @author JIXD 
 * @date 2016年7月5日 下午10:45:30  
 *
 */
@Service
public class UserRoleServiceImpl implements UserRoleService {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserRoleServiceImpl.class);

	@Autowired
	private TUserRoleMapper userRoleMapper;
	
	@Override
	public int saveUserRole(TUserRole userRole) {
		return userRoleMapper.insertSelective(userRole);
	}

	@Override
	public int updateUserRole(TUserRole userRole) {
		return userRoleMapper.updateByPrimaryKey(userRole);
	}

	@Override
	public TUserRole findUserRole(Integer userId) {
		TUserRoleExample example = new TUserRoleExample();
		Criteria criteria = example.createCriteria();
		criteria.andIsDelEqualTo(IsDelEnum.NO_DEL.getCode());
		criteria.andUserIdEqualTo(userId);
		List<TUserRole> list = userRoleMapper.selectByExample(example);
		if(Check.NuNCollection(list)){
			return null;
		}
		return list.get(0);
	}

}
