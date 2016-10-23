package com.citichma.valenum;
/**
 * 
 * 产品种类枚举
 * @author JIXD 
 * @date 2016年8月7日 上午11:07:40  
 *
 */
public enum ProductTypeEnum {
	DK(1,"电控"),
	YY(2,"液压"),
	JQR(3,"机器人"),
	MJ(4,"磨机"),
	LM(5,"立磨"),
	GYJ(6,"辊压机"),
	PSJ(7,"破碎机"),
	YAO(8,"窑"),
	TSJ(9,"提升机"),
	YRFD(10,"余热发电"),
	PD(11,"配电"),
	BPQ(12,"变频器"),
	JZJ(13,"矫直机"),
	ZK(14,"闸控"),
	HJS(15,"恒减速"),
	ZFJ(16,"直发件"),
	ZKJ(17,"转口件"),
	DCS(18,"DCS"),
	CARBLQ(19,"汽车变流器"),
	OTHER(20,"其他");
	
	private int code;
	private String name;
	ProductTypeEnum(int code,String name){
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
	
	public static ProductTypeEnum getProductTypeEnumByCode(int code){
		for(final ProductTypeEnum type : ProductTypeEnum.values()){
			if(type.code == code){
				return type;
			}
		}
		return null;
	}
}
