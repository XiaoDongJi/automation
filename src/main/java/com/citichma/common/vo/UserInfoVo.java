package com.citichma.common.vo;

import java.util.List;

import com.citichma.pojo.TMenuInfo;

/**
 * 
 * session存放的用户信息
 * @author JIXD 
 * @date 2016年7月24日 下午2:20:55  
 *
 */
public class UserInfoVo {
	/**
	 * 用户UId
	 */
	private Integer userId;
	/**
	 * 用户员工号
	 */
	private String userNo;
	/**
	 * 用户名字
	 */
	private String userName;
	/**
	 * 角色ID
	 */
	private Integer roleId;
	/**
	 * 角色名称
	 */
	private String roleName;
	/**
	 * 菜单列表
	 */
	private List<TMenuInfo> menuList;
	
	
	public Integer getUserId() {
		return userId;
	}
	public void setUserId(Integer userId) {
		this.userId = userId;
	}
	public String getUserNo() {
		return userNo;
	}
	public void setUserNo(String userNo) {
		this.userNo = userNo;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getRoleName() {
		return roleName;
	}
	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	public List<TMenuInfo> getMenuList() {
		return menuList;
	}
	public void setMenuList(List<TMenuInfo> menuList) {
		this.menuList = menuList;
	}
	public Integer getRoleId() {
		return roleId;
	}
	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}
}
