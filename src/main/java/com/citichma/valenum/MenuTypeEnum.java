package com.citichma.valenum;
/**
 * 
 * 菜单类型枚举
 * @author JIXD 
 * @date 2016年7月16日 下午1:37:32  
 *
 */
public enum MenuTypeEnum {
	MENU(1,"菜单"),
	BUTTON(2,"按钮");
	
	private int code;
	private String name;
	MenuTypeEnum(int code,String name){
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
	
	public static MenuTypeEnum getMenuTypeEnumByCode(int code){
		for(final MenuTypeEnum menu : MenuTypeEnum.values()){
			if(menu.code == code){
				return menu;
			}
		}
		return null;
	}
	
}
