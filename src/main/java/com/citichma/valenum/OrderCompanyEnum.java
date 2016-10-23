package com.citichma.valenum;
/**
 * 
 * 订单公司枚举
 * @author JIXD 
 * @date 2016年8月7日 上午11:07:40  
 *
 */
public enum OrderCompanyEnum {
	ZDH(1,"自动化"),
	KYY(2,"矿研院"),
	XSGS(3,"销售公司"),
	GJYWB(4,"国际业务部"),
	BPXS(5,"变频销售"),
	JQRXS(6,"机器人销售"),
	OTHER(7,"其他");
	
	private int code;
	private String name;
	
	OrderCompanyEnum(int code,String name){
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
	
	public static OrderCompanyEnum getProductTypeEnumByCode(int code){
		for(final OrderCompanyEnum type : OrderCompanyEnum.values()){
			if(type.code == code){
				return type;
			}
		}
		return null;
	}
}
