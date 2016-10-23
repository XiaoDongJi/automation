package com.citichma.service;

import com.citichma.pojo.TUserRole;

/**
 * 
 * @Description: 用户与角色关联
 * @author JIXD 
 * @date 2016年7月5日 下午10:37:29  
 *
 */
public interface UserRoleService {

	int saveUserRole(TUserRole userRole);
	
	int updateUserRole(TUserRole userRole);
	
	TUserRole findUserRole(Integer userId);
}
