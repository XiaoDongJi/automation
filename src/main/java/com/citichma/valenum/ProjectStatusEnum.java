package com.citichma.valenum;
/**
 * 1=撤销 2=待包装 3=在包装 4=待采购 5=在采购 6=待装配 7=在装配 8=在制缺件 9=暂停 10=在制收尾 11=在检验 12=在调试 13=待入库 14=已入库 15=待安装 
 * 
 * 项目状态枚举
 * @author JIXD 
 * @date 2016年8月7日 上午11:07:40  
 *
 */
public enum ProjectStatusEnum {
	
	CX(1,"撤销"),
	DBZ(2,"待包装"),
	ZBZ(3,"在包装"),
	DCG(4,"待采购"),
	ZCG(5,"在采购"),
	DZP(6,"待装配"),
	ZZP(7,"在装配"),
	ZZQJ(8,"在制缺件"),
	ZT(9,"暂停"),
	ZZSW(10,"在制收尾"),
	ZJY(11,"在检验"),
	ZTS(12,"在调试"),
	DRK(13,"待入库"),
	YRK(14,"已入库"),
	DAZ(15,"待安装"),
	OTHER(16,"其他");
	
	private int code;
	private String name;
	
	ProjectStatusEnum(int code,String name){
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
	
	public static ProjectStatusEnum getProjectStatusEnumByCode(int code){
		for(final ProjectStatusEnum status : ProjectStatusEnum.values()){
			if(status.code == code){
				return status;
			}
		}
		return null;
	}
}
