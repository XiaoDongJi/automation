package com.citichma.valenum;
/**
 * 1=采购节点 2=原件发放 3=装配节点 4=检验及调试 5=入库节点
 * 
 * 节点类型枚举
 * @author JIXD 
 * @date 2016年8月7日 上午11:07:40  
 *
 */
public enum NodeTypeEnum {
	
	CGYJ(1,"采购元件节点"),
	CGGT(2,"采购柜体节点"),
	YJFF(3,"原件发放"),
	ZPJD(4,"装配节点"),
	JYJD(5,"检验节点"),
	TSJD(6,"调试节点"),
	RKJD(7,"入库节点");
	
	private int code;
	private String name;
	
	NodeTypeEnum(int code,String name){
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
	
	public static NodeTypeEnum getnNodeTypeEnumByCode(int code){
		for(final NodeTypeEnum node : NodeTypeEnum.values()){
			if(node.code == code){
				return node;
			}
		}
		return null;
	}
}
