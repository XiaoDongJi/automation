package com.citichma.controller;

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
import com.citichma.common.request.RoleRequestParam;
import com.citichma.common.util.Check;
import com.citichma.common.vo.DataResult;
import com.citichma.common.vo.EUDataGridResult;
import com.citichma.pojo.TRole;
import com.citichma.pojo.TRolePermission;
import com.citichma.pojo.TUserRole;
import com.citichma.service.RolePermissionService;
import com.citichma.service.RoleService;
import com.citichma.service.UserRoleService;
import com.citichma.valenum.IsDelEnum;
/**
 * 
 * 角色控制
 * @author JIXD 
 * @date 2016年7月19日 下午9:06:53  
 *
 */
@RequestMapping("/role")
@Controller
public class RoleController {

	private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private RoleService roleService;
	
	@Autowired
	private RolePermissionService rolePerService;
	
	@Autowired
	private UserRoleService userRoleService;
	
	@RequestMapping("/list")
	public String showList(){
		return "role/roleList";
	}
	
	/**
	 * 
	 * 数据请求 
	 * @param   
	 * @return 
	 * @date 2016年7月19日 下午9:09:01  
	 * @throws
	 */
	@RequestMapping("/dataList")
	@ResponseBody
	public EUDataGridResult dataList(RoleRequestParam roleParam){
		EUDataGridResult resutlData = null;
		try{
			if(Check.NuNObj(roleParam)){
				return new EUDataGridResult();
			}
			resutlData = roleService.findRoleByPage(roleParam);
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			resutlData = new EUDataGridResult();
		}
		return resutlData;
	}
	
	/**
	 * 添加角色
	 * @param   
	 * @return 
	 * @date 2016年7月17日 下午2:11:19  
	 * @throws
	 */
	@RequestMapping("/add")
	@ResponseBody
	public DataResult addRole(TRole role){
		DataResult dataResult = null;
		try{
			if(role == null){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.PARAM_NULL);
			}
			if(Check.NuNStr(role.getRoleName())){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.NAME_NULL);
			}
			int result = roleService.saveRole(role);
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
	 * 更新角色
	 * @param   
	 * @return 
	 * @date 2016年7月17日 下午2:19:56  
	 * @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public DataResult updateRole(TRole role){
		DataResult dataResult = null;
		try{
			if(role == null){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.PARAM_NULL);
			}
			if(Check.NuNObj(role.getRoleId())){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.ID_NULL);
			}
			if(Check.NuNStr(role.getRoleName())){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.NAME_NULL);
			}
			int result = roleService.updateRole(role);
			if(result < 1){
				dataResult = DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.UPDATE_ERROR);
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
	 * 删除角色
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
			TRole role = roleService.findRoleById(id);
			if(Check.NuNObj(role)){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.ROLE_NULL);
			}
			role.setIsDel(IsDelEnum.DEL.getCode());
			int result = roleService.updateRole(role);
			if(result < 1){
				dataResult = DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.UPDATE_ERROR);
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
	 * 绑定角色菜单
	 * @param   
	 * @return 
	 * @date 2016年7月23日 下午4:41:55  
	 * @throws
	 */
	@RequestMapping("/bindMenu")
	@ResponseBody
	public DataResult bindMenu(String ids,Integer roleId){
		if(Check.NuNStr(ids)){
			return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.PARAM_NULL);
		}
		if(Check.NuNObj(roleId)){
			return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.PARAM_NULL);
		}
		try{
			//先删除所有菜单在增加
			rolePerService.delRoleAllPermission(roleId);
			String[] idArr = ids.split(",");
			for(String menuId : idArr){
				TRolePermission rolePermission = new TRolePermission();
				rolePermission.setMenuId(Integer.parseInt(menuId));
				rolePermission.setRoleId(roleId);
				rolePerService.saveRolePermission(rolePermission);
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			return DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SERVER_ERROR);
		}
		return DataResult.ok();
	}
	
	
	/**
	 * 
	 * 显示选择列表
	 * @param   
	 * @return 
	 * @date 2016年7月23日 下午6:43:36  
	 * @throws
	 */
	@RequestMapping("/select")
	public String selectRole(HttpServletRequest request){
		StringBuilder sb = new StringBuilder();
		String userId = request.getParameter("userId");
		try{
			TUserRole userRole = null;
			if(!Check.NuNStr(userId)){
				userRole = userRoleService.findUserRole(Integer.parseInt(userId));
			}
			List<TRole> list = roleService.findAllRole();
			for(TRole role : list){
				if(!Check.NuNObj(userRole) && userRole.getRoleId() == role.getRoleId()){
					sb.append("<option selected='selected' value='"+role.getRoleId()+"'>"+role.getRoleName()+"</option>");
				}else{
					sb.append("<option value='"+role.getRoleId()+"'>"+role.getRoleName()+"</option>");
				}
			}
			request.setAttribute("option", sb.toString());
			request.setAttribute("userId", userId);
		}catch(Exception e){
			LOGGER.error(e.getMessage());
		}
		return "role/roleSelect";
	}
}
