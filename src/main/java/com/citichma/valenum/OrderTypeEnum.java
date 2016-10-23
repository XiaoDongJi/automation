package com.citichma.valenum;
/**
 * 
 * 订单类型枚举
 * @author JIXD 
 * @date 2016年8月7日 上午11:07:40  
 *
 */
public enum OrderTypeEnum {
	
	ZX(1,"纵向"),
	ZL(2,"自揽"),
	JG(3,"技改"),
	KY(4,"科研"),
	SB(5,"三包"),
	FX(6,"返修"),
	BJ(7,"备件"),
	OTHER(8,"其他");
	
	private int code;
	private String name;
	
	OrderTypeEnum(int code,String name){
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
	
	public static OrderTypeEnum getProductTypeEnumByCode(int code){
		for(final OrderTypeEnum type : OrderTypeEnum.values()){
			if(type.code == code){
				return type;
			}
		}
		return null;
	}
}
