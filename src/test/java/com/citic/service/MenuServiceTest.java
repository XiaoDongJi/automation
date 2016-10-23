package com.citic.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;

import com.citic.base.BaseTest;
import com.citichma.pojo.TMenuInfo;
import com.citichma.service.MenuService;
import com.citichma.valenum.MenuTypeEnum;

public class MenuServiceTest extends BaseTest{

	@Autowired
	private MenuService menuService;
	@Value("${FTP_ADDRESS}")
	private String FTP_ADDRESS;
	@Value("${FTP_PORT}")
	private Integer FTP_PORT;
	
	@Test
	public void testsaveMenu(){
		TMenuInfo menu = new TMenuInfo();
		menu.setIsParent(0);
		menu.setMenuName("用户管理");
		menu.setMenuType(MenuTypeEnum.MENU.getCode());
		menu.setMenuOrder(1);
		menu.setParentId(1);
		menu.setMenuUrl("/user");
		int saveMenu = menuService.saveMenu(menu);
		System.out.println(menu.getId());
	}
	@Test
	public void testgetChildMenuCount(){
		int count = menuService.getChildMenuCount(4);
		System.out.println(count);
	}
	
	@Test
	public void testConf(){
		System.out.println(FTP_ADDRESS);
		System.out.println(FTP_PORT);
	}
}
