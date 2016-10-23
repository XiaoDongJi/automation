package com.citichma.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citichma.common.constant.MessageConstant;
import com.citichma.common.request.UserRequestParam;
import com.citichma.common.util.Check;
import com.citichma.common.util.MD5Util;
import com.citichma.common.vo.DataResult;
import com.citichma.common.vo.EUDataGridResult;
import com.citichma.pojo.TUser;
import com.citichma.pojo.TUserRole;
import com.citichma.service.UserRoleService;
import com.citichma.service.UserService;
import com.citichma.valenum.IsDelEnum;

/**
 * 
 * 用户管理
 * @author JIXD 
 * @date 2016年7月16日 下午2:15:33  
 *
 */
@RequestMapping("/user")
@Controller
public class UserController {
	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@Value("${default_password}")
	private String defaultPassword;
	
	@RequestMapping("/list")
	public String showList(){
		return "user/userList";
	}
	
	
	/**
	 * 
	 * 用户列表
	 * @param   
	 * @return 
	 * @date 2016年7月16日 下午2:16:24  
	 * @throws
	 */
	@RequestMapping("/dataList")
	@ResponseBody
	public EUDataGridResult dataList(UserRequestParam userParam){
		EUDataGridResult resutlData = null;
		try{
			if(Check.NuNObj(userParam)){
				return new EUDataGridResult();
			}
			resutlData = userService.findUserByPage(userParam);
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			resutlData = new EUDataGridResult();
		}
		return resutlData;
	}
	
	/**
	 * 添加用户 
	 * @param   
	 * @return 
	 * @date 2016年7月17日 下午2:11:19  
	 * @throws
	 */
	@RequestMapping("/add")
	@ResponseBody
	public DataResult addUser(TUser user){
		DataResult dataResult = null;
		try{
			if(user == null){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.PARAM_NULL);
			}
			if(Check.NuNStr(user.getUserNo())){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.CODE_NULL);
			}
			if(Check.NuNStr(user.getUserName())){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.NAME_NULL);
			}
			if(Check.NuNObj(user.getUserPassword())){
				//密码经m5d加密
				user.setUserPassword(MD5Util.MD5Encode(defaultPassword));
			}else{
				user.setUserPassword(MD5Util.MD5Encode(user.getUserPassword()));
			}
			int result = userService.saveUser(user);
			if(result < 1){
				dataResult = DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SAVE_ERROR);
			}else{
				dataResult = DataResult.ok();
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			dataResult = DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SERVER_ERROR);
		}
		return dataResult;
	}
	
	
	/**
	 * 
	 * 更新用户
	 * @param   
	 * @return 
	 * @date 2016年7月17日 下午2:19:56  
	 * @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public DataResult updateUser(TUser user){
		DataResult dataResult = null;
		try{
			if(user == null){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.PARAM_NULL);
			}
			if(Check.NuNObj(user.getUserId())){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.ID_NULL);
			}
			if(Check.NuNStr(user.getUserNo())){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.CODE_NULL);
			}
			if(Check.NuNStr(user.getUserName())){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.NAME_NULL);
			}
			if(!Check.NuNStr(user.getUserPassword())){
				user.setUserPassword(MD5Util.MD5Encode(user.getUserPassword()));
			}
			int result = userService.updateUser(user);
			if(result < 1){
				dataResult = DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SAVE_ERROR);
			}else{
				dataResult = DataResult.ok();
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			dataResult = DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SERVER_ERROR);
		}
		return dataResult;
	}
	
	/**
	 * 
	 * 删除用户 
	 * @param   
	 * @return 
	 * @date 2016年7月17日 下午2:22:50  
	 * @throws
	 */
	@RequestMapping("/del")
	@ResponseBody
	public DataResult delUser(Integer id){
		DataResult dataResult = null;
		try{
			if(Check.NuNObj(id)){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.ID_NULL);
			}
			TUser user = userService.findUserById(id);
			if(Check.NuNObj(user)){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.NAME_NULL);
			}
			user.setIsDel(IsDelEnum.DEL.getCode());
			int result = userService.updateUser(user);
			if(result < 1){
				dataResult = DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SAVE_ERROR);
			}else{
				dataResult = DataResult.ok();
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			dataResult = DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SERVER_ERROR);
		}
		return dataResult;
	}
	
	/**
	 * 
	 * 用户绑定角色 
	 * @param   
	 * @return 
	 * @date 2016年7月24日 下午1:47:13  
	 * @throws
	 */
	@RequestMapping("/bindRole")
	@ResponseBody
	public DataResult bindRole(TUserRole userRole){
		try{
			if(Check.NuNObj(userRole)){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.PARAM_NULL);
			}
			if(Check.NuNObj(userRole.getUserId())){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.ID_NULL);
			}
			if(Check.NuNObj(userRole.getRoleId())){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.ID_NULL);
			}
			TUserRole findUserRole = userRoleService.findUserRole(userRole.getUserId());
			int result = 0;
			if(Check.NuNObj(findUserRole)){
				result = userRoleService.saveUserRole(userRole);
			}else{
				findUserRole.setRoleId(userRole.getRoleId());
				result = userRoleService.updateUserRole(findUserRole);
			}
			if(result > 0){
				return DataResult.ok();
			}else{
				return DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SAVE_ERROR);
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			return DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SERVER_ERROR);
		}
	}
	
	/**
	 * 
	 * 个人中心 
	 * @param   
	 * @return 
	 * @date 2016年8月12日 下午10:40:25  
	 * @throws
	 */
	@RequestMapping("/center")
	public String userCenter(){
		return "user/userCenter";
	}
	
	
	
}
