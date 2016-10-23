package com.citic.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.alibaba.fastjson.JSONObject;
import com.citic.base.BaseTest;
import com.citichma.common.util.MD5Util;
import com.citichma.common.vo.EUDataGridResult;
import com.citichma.common.vo.UserInfoVo;
import com.citichma.pojo.TUser;
import com.citichma.service.UserService;
/**
 * 
 * 用户测试类
 * @author JIXD 
 * @date 2016年7月16日 下午3:05:08  
 *
 */
public class UserServiceTest extends BaseTest{
	
	@Autowired
	private UserService userService;
	
	@Test
	public void testSaveUser(){
		for(int i = 1;i<100;i++){
			TUser user = new TUser();
			user.setUserId(i);
			user.setIsDel(0);
			user.setUserNo(String.valueOf(2000+i));
			user.setUserName("王梦思"+i);
			user.setUserPassword(MD5Util.MD5Encode("000000"));
			int count = userService.saveUser(user);
			System.out.println("count:"+i);
		}
	}
	
	@Test
	public void testgetUserList(){
		/*EUDataGridResult list = userService.findUserByPage(1,10);
		System.out.println(JSONObject.toJSONString(list));*/
	}
	
	@Test
	public void testfindUserVoByUid(){
		UserInfoVo findUserVoByUid = userService.findUserVoByUid(1);
	}
}
