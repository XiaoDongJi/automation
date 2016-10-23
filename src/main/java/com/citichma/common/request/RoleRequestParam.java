package com.citichma.common.request;

import com.citichma.common.base.BasePage;
/**
 * 
 * 角色请求参数
 * @author JIXD 
 * @date 2016年7月18日 下午10:47:07  
 *
 */
public class RoleRequestParam extends BasePage {
	/**
	 * 员工号
	 */
	private String roleName;

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}
	
}
