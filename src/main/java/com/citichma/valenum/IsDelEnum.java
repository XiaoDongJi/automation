package com.citichma.valenum;

/**
 * 
 * 删除枚举
 * @author JIXD 
 * @date 2016年7月16日 下午1:28:47  
 *
 */
public enum IsDelEnum {
	DEL(1,"删除"),
	NO_DEL(0,"不删除");
	
	private int code;
	private String name;
	
	IsDelEnum(int code,String name){
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
