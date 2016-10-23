package com.citichma.controller;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citichma.common.constant.MessageConstant;
import com.citichma.common.util.Check;
import com.citichma.common.util.MD5Util;
import com.citichma.common.vo.DataResult;
import com.citichma.common.vo.MenuDataVo;
import com.citichma.common.vo.UserInfoVo;
import com.citichma.pojo.TMenuInfo;
import com.citichma.pojo.TUser;
import com.citichma.service.UserService;
import com.citichma.valenum.IsParentNode;

/**
 * 
 * @Description: 登陆
 * @author JIXD 
 * @date 2016年7月15日 下午9:58:47  
 *
 */
@RequestMapping("/")
@Controller
public class LoginController {
	private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);

	@Autowired
	private UserService userservice;

	@RequestMapping("/")
	public String index(){
		return "login";
	}

	/**
	 * 
	 * 跳转登陆页 
	 * @param @return    
	 * @return String  
	 * @throws
	 */
	@RequestMapping("/login")
	public String toLogin(){		
		return "login";
	}
	
	/**
	 * 
	 * 登陆检查 
	 * @param   
	 * @return 
	 * @date 2016年7月24日 下午2:27:12  
	 * @throws
	 */
	@RequestMapping("/loginCheck")
	@ResponseBody
	public DataResult doLogin(HttpServletRequest request){
		String userNo = request.getParameter("userNo");
		String pass = request.getParameter("userPassword");
		if(Check.NuNStr(userNo)){
			return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.LOGIN_NAME_NULL);
		}
		if(Check.NuNStr(pass)){
			return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.LOGIN_PASS_NULL);
		}
		try{
			TUser tUser = userservice.findUserByNo(userNo);
			if(Check.NuNObj(tUser)){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.LOGIN_ERROR);
			}
			if(tUser.getUserPassword().equals(MD5Util.MD5Encode(pass))){
				UserInfoVo userInfoVo = userservice.findUserVoByUid(tUser.getUserId());
				List<TMenuInfo> hasMenuList = userInfoVo.getMenuList();
				List<MenuDataVo> menuDataList = new ArrayList<>();
				
				if(!Check.NuNCollection(hasMenuList)){
					//一级菜单赋值
					for(TMenuInfo menu:hasMenuList){
						
						if(menu.getIsParent() == IsParentNode.PARENT.getCode() && menu.getParentId()==1){
							MenuDataVo menuData = new MenuDataVo();
							menuData.setId(menu.getId());
							menuData.setName(menu.getMenuName());
							menuDataList.add(menuData);
						}
					}
					//二级菜单赋值
					for(MenuDataVo data : menuDataList){
						List<TMenuInfo> childrenList = new ArrayList<>(); 
						for(TMenuInfo menu:hasMenuList){
							if(menu.getParentId() == data.getId()){
								childrenList.add(menu);
							}
						}
						data.setChildren(childrenList);
					}
				}
				request.getSession().setAttribute("menuList", menuDataList);
				request.getSession().setAttribute("userVo", userInfoVo);
			}else{
				return DataResult.build(HttpStatus.BAD_REQUEST.value(),  MessageConstant.LOGIN_ERROR);
			}
		}catch(Exception e){
			LOGGER.error("【登陆异常】",e);
			return DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(),  MessageConstant.SERVER_ERROR);
		}
		return DataResult.ok();
	}
	
	/**
	 * 
	 * 退出登录 
	 * @param   
	 * @return 
	 * @date 2016年7月24日 下午1:59:46  
	 * @throws
	 */
	@RequestMapping("/loginOut")
	public String LoginOut(HttpServletRequest request){
		request.getSession().removeAttribute("userVo");
		return "redirect:login";
	}
}
