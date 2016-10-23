package com.citichma.service;

import java.util.List;

import com.citichma.pojo.TRolePermission;

/**
 * 
 * @Description: 角色权限关系
 * @author JIXD 
 * @date 2016年7月5日 下午10:47:11  
 *
 */
public interface RolePermissionService {
	/**
	 * 
	 * @Description: 增加新权限 
	 * @param @param permission
	 * @param @return    
	 * @return int  
	 * @throws
	 */
	int saveRolePermission(TRolePermission permission);
	/**
	 * 
	 * @Description: 删除角色某一个权限 
	 * @param @param permission
	 * @param @return    
	 * @return int  
	 * @throws
	 */
	int delRolePermission(int id);
	
	/**
	 * 
	 * 逻辑删除该角色所拥有的菜单
	 * @param   
	 * @return 
	 * @date 2016年7月23日 下午5:18:51  
	 * @throws
	 */
	int delRoleAllPermission(Integer roleId);
	
	/**
	 * 
	 * 查询角色菜单
	 * @param   
	 * @return 
	 * @date 2016年7月23日 下午5:00:50  
	 * @throws
	 */
	List<TRolePermission> findMenuIdList(Integer roleId);
}
