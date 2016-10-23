package com.citichma.valenum;

/**
 * 
 * 删除枚举
 * @author JIXD 
 * @date 2016年7月16日 下午1:28:47  
 *
 */
public enum IsParentNode {
	PARENT(1,"父菜单"),
	CHILDE(0,"子菜单");
	
	private int code;
	private String name;
	
	IsParentNode(int code,String name){
		this.code = code;
		this.name = name;
	}

	public int getCode() {
		return code;
	}

	public void setCode(int code) {
		this.code = code;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	
	
}
