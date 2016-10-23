package com.citichma.service.impl;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.citichma.mapper.TRolePermissionMapper;
import com.citichma.pojo.TRolePermission;
import com.citichma.pojo.TRolePermissionExample;
import com.citichma.pojo.TRolePermissionExample.Criteria;
import com.citichma.service.RolePermissionService;
import com.citichma.valenum.IsDelEnum;
/**
 * 
 * @Description: 角色与菜单关联
 * @author JIXD 
 * @date 2016年7月5日 下午10:52:43  
 *
 */
@Service
public class RolePermissionServiceImpl implements RolePermissionService {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(RoleServiceImpl.class);

	@Autowired
	private TRolePermissionMapper permissionMapper;
	
	@Override
	public int saveRolePermission(TRolePermission permission) {
		TRolePermissionExample permissionExample = new TRolePermissionExample();
		Criteria criteria = permissionExample.createCriteria();
		criteria.andRoleIdEqualTo(permission.getRoleId());
		criteria.andMenuIdEqualTo(permission.getMenuId());
		criteria.andIsDelEqualTo(IsDelEnum.NO_DEL.getCode());
		int count = permissionMapper.countByExample(permissionExample);
		if(count > 0){
			return 0;
		}
		return permissionMapper.insertSelective(permission);
	}

	@Override
	public int delRolePermission(int id) {
		return permissionMapper.deleteByPrimaryKey(id);
	}

	@Override
	public List<TRolePermission> findMenuIdList(Integer roleId) {
		TRolePermissionExample permissionExample = new TRolePermissionExample();
		Criteria criteria = permissionExample.createCriteria();
		criteria.andIsDelEqualTo(IsDelEnum.NO_DEL.getCode());
		criteria.andRoleIdEqualTo(roleId);
		return permissionMapper.selectByExample(permissionExample);
	}

	@Override
	public int delRoleAllPermission(Integer roleId) {
		TRolePermissionExample permissionExample = new TRolePermissionExample();
		Criteria criteria = permissionExample.createCriteria();
		criteria.andRoleIdEqualTo(roleId);
		return permissionMapper.deleteByExample(permissionExample);
	}

}
