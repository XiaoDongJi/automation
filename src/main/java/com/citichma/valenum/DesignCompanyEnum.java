package com.citichma.valenum;
/**
 * 
 * 设计公司枚举
 * @author JIXD 
 * @date 2016年8月7日 上午11:07:40  
 *
 */
public enum DesignCompanyEnum {
	ZDH(1,"自动化"),
	KYY(2,"工程公司"),
	OTHER(3,"其他");
	
	private int code;
	private String name;
	
	DesignCompanyEnum(int code,String name){
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
	
	public static DesignCompanyEnum getProductTypeEnumByCode(int code){
		for(final DesignCompanyEnum type : DesignCompanyEnum.values()){
			if(type.code == code){
				return type;
			}
		}
		return null;
	}
}
