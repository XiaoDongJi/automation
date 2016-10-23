package com.citichma.service;

import com.citichma.common.request.UserRequestParam;
import com.citichma.common.vo.EUDataGridResult;
import com.citichma.common.vo.UserInfoVo;
import com.citichma.pojo.TUser;

/**
 * 用户接口
 * @author JIXD
 *
 */
public interface UserService {
	/**
	 * 
	 * @Title: saveUser  
	 * @Description: 新增用户
	 * @param @return    
	 * @return int  
	 * @throws
	 */
	int saveUser(TUser user);
	
	/**
	 * 
	 * @Title: updateUser  
	 * @Description: 更新用户
	 * @param @param user
	 * @param @return    
	 * @return int  
	 * @throws
	 */
	int updateUser(TUser user);
	/**
	 * 
	 * @Title: findUserById  
	 * @Description: 查找用户根据id 
	 * @param @param id
	 * @param @return    
	 * @return int  
	 * @throws
	 */
	TUser findUserById(int id);
	/**
	 * 
	 * 根据员工编号获取用户信息 
	 * @param   
	 * @return 
	 * @date 2016年7月24日 下午2:40:51  
	 * @throws
	 */
	TUser findUserByNo(String userNo);
	/**
	 * 
	 * 分页查询用户
	 * @param   
	 * @return 
	 * @date 2016年7月16日 下午2:51:45  
	 * @throws
	 */
	EUDataGridResult findUserByPage(UserRequestParam userParam);
	/**
	 * 
	 * 根据UID查询用户详细信息
	 * @param   
	 * @return 
	 * @date 2016年7月24日 下午3:27:14  
	 * @throws
	 */
	UserInfoVo findUserVoByUid(Integer userId);
}
