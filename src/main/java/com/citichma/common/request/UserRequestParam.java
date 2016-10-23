package com.citichma.common.request;

import com.citichma.common.base.BasePage;
/**
 * 
 * 用户请求参数
 * @author JIXD 
 * @date 2016年7月18日 下午10:47:07  
 *
 */
public class UserRequestParam extends BasePage {
	/**
	 * 员工号
	 */
	private String userNo;
	/**
	 * 员工姓名
	 */
	private String userName;
	
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
	
	
}
