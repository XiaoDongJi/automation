package com.citichma.service;

import java.util.List;

import com.citichma.common.request.RoleRequestParam;
import com.citichma.common.vo.EUDataGridResult;
import com.citichma.pojo.TRole;

/**
 * 
 * @Description: 角色相关
 * @author JIXD 
 * @date 2016年7月5日 下午9:38:28  
 *
 */
public interface RoleService {
	/**
	 * 
	 * @Description: 保存角色
	 * @param @param role
	 * @param @return    
	 * @return int  
	 * @throws
	 */
	int saveRole(TRole role);
	/**
	 * 
	 * @Description: 更新角色 
	 * @param @param role
	 * @param @return    
	 * @return int  
	 * @throws
	 */
	int updateRole(TRole role);
	/**
	 * 
	 * @Description: 根据id查找角色 
	 * @param @param id
	 * @param @return    
	 * @return TRole  
	 * @throws
	 */
	TRole findRoleById(int id);
	
	/**
	 * 
	 * 查询所有角色 
	 * @param   
	 * @return 
	 * @date 2016年7月24日 下午12:53:34  
	 * @throws
	 */
	List<TRole> findAllRole();
	
	/**
	 * 
	 * 分页查询用户角色 
	 * @param   
	 * @return 
	 * @date 2016年7月19日 下午9:16:28  
	 * @throws
	 */
	EUDataGridResult findRoleByPage(RoleRequestParam roleParam);
}
