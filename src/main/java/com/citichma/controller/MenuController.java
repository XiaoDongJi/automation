package com.citichma.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citichma.common.constant.MessageConstant;
import com.citichma.common.util.Check;
import com.citichma.common.vo.DataResult;
import com.citichma.common.vo.EUDataGridResult;
import com.citichma.common.vo.EUTreeCBNode;
import com.citichma.common.vo.EUTreeGridNode;
import com.citichma.pojo.TMenuInfo;
import com.citichma.pojo.TRolePermission;
import com.citichma.service.MenuService;
import com.citichma.service.RolePermissionService;
import com.citichma.valenum.IsDelEnum;
import com.citichma.valenum.IsParentNode;

/**
 * 
 * 菜单控制
 * @author JIXD 
 * @date 2016年7月16日 下午1:56:20  
 *
 */
@RequestMapping("/menu")
@Controller
public class MenuController {

	private static final Logger LOGGER = LoggerFactory.getLogger(MenuController.class);
	
	@Autowired
	private MenuService menuService;
	
	@Autowired
	private RolePermissionService permissionService;
	
	/**
	 * 
	 * 显示左侧菜单
	 * @param @return    
	 * @return String
	 * @date 2016年7月16日 下午1:57:42  
	 * @throws
	 */
	@RequestMapping("/left")
	public String menuLeft(){
		return "/commons/left";
	}
	
	/**
	 * 
	 * 头部显示
	 * @param @return    
	 * @return String
	 * @date 2016年7月16日 下午1:59:40  
	 * @throws
	 */
	@RequestMapping("/top")
	public String menuTop(){
		return "/commons/top";
	}
	
	/**
	 * 
	 * 主面板
	 * @param   
	 * @return 
	 * @date 2016年7月16日 下午2:05:44  
	 * @throws
	 */
	@RequestMapping("/main")
	public String menuMain(){
		return "main";
	}
	
	/**
	 * 
	 * 主页
	 * @param   
	 * @return 
	 * @date 2016年8月1日 下午11:02:42  
	 * @throws
	 */
	@RequestMapping("/index")
	public String menuIndex(){
		return "index";
	}
	
	/**
	 * 
	 * 跳转树状表格列表 
	 * @param   
	 * @return 
	 * @date 2016年7月20日 下午9:34:26  
	 * @throws
	 */
	@RequestMapping("/list")
	public String showList(){
		return "/menu/menuList";
	}
	
	/**
	 * 获取树状表格列表
	 * @param   
	 * @return 
	 * @date 2016年7月20日 下午9:34:04  
	 * @throws
	 */
	@RequestMapping("/treeList")
	@ResponseBody
	public EUDataGridResult treeGridList(){
		return menuService.getMenuList();
	}
	
	/**
	 * 
	 * 更新菜单 
	 * @param   
	 * @return 
	 * @date 2016年7月21日 下午10:28:01  
	 * @throws
	 */
	@RequestMapping("/update")
	@ResponseBody
	public DataResult updateMenu(EUTreeGridNode node){
		DataResult dataResult = null;
		try{
			if(Check.NuNObj(node)){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.PARAM_NULL);
			}
			if(Check.NuNObj(node.getId())){
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.ID_NULL);
			}
			TMenuInfo menu = new TMenuInfo();
			menu.setId(node.getId());
			menu.setMenuName(node.getName());
			menu.setMenuOrder(node.getMenuOrder());
			menu.setMenuUrl(node.getMenuUrl());
			menu.setMenuType(node.getMenuType());
			menu.setParentId(node.get_parentId());
			int result = menuService.updateMenu(menu);
			if(result>0){
				dataResult = DataResult.ok();
			}else{
				dataResult = DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.UPDATE_ERROR);
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			dataResult = DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SERVER_ERROR);
		}
		
		return dataResult;
	}
	
	/**
	 * 
	 * 创建菜单
	 * @param   
	 * @return 
	 * @date 2016年7月23日 上午11:07:08  
	 * @throws
	 */
	@RequestMapping("/create")
	@ResponseBody
	public DataResult createMenu(TMenuInfo menu){
		if(Check.NuNObj(menu)){
			return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.PARAM_NULL);
		}
		try{
			int count = menuService.saveMenu(menu);
			if(count > 0){
				TMenuInfo parentNode = menuService.findMenuById(menu.getParentId());
				if(!Check.NuNObj(parentNode)){
					parentNode.setIsParent(IsParentNode.PARENT.getCode());
					menuService.updateMenu(parentNode);
				}
			}else{
				return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.SAVE_ERROR);
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			return DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SERVER_ERROR);
		}
		
		return DataResult.ok(menu);
	}
	
	/**
	 * 
	 * 删除菜单
	 * @param   
	 * @return 
	 * @date 2016年7月23日 上午11:53:20  
	 * @throws
	 */
	@RequestMapping("/remove")
	@ResponseBody
	public DataResult removeMenu(Integer id,Integer parentId){
		if(Check.NuNObj(id)){
			return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.ID_NULL);
		}
		if(Check.NuNObj(parentId)){
			return DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.ID_NULL);
		}
		try{
			TMenuInfo menu = menuService.findMenuById(id);
			menu.setIsDel(IsDelEnum.DEL.getCode());
			int delResult = menuService.updateMenu(menu);
			if(delResult > 0){
				if(menuService.getChildMenuCount(parentId)<1){
					TMenuInfo parentMenu = menuService.findMenuById(parentId);
					parentMenu.setIsParent(IsParentNode.CHILDE.getCode());
					menuService.updateMenu(parentMenu);
				}
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			return DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SERVER_ERROR);
		}
		
		return DataResult.ok();
	}
	
	/**
	 * 
	 * 显示可选择的树状列表
	 * @param   
	 * @return 
	 * @date 2016年7月23日 下午3:12:27  
	 * @throws
	 */
	@RequestMapping("/cbTree")
	public String showCbTree(Integer roleId,Model model){
		model.addAttribute("roleId", roleId);
		return "menu/menuTree";
	}
	
	/**
	 * 
	 * 菜单列表
	 * @param   
	 * @return 
	 * @date 2016年7月23日 下午3:02:40  
	 * @throws
	 */
	@RequestMapping("/treeCbList")
	@ResponseBody
	public List<EUTreeCBNode> treeCbList(@RequestParam(value="id",defaultValue="0") Integer parentId,Integer roleId){
		List<EUTreeCBNode> menuList = menuService.getChildMenu(parentId);
		if(!Check.NuNObj(roleId)){
			List<TRolePermission> rolePermissions = permissionService.findMenuIdList(roleId);
			for(EUTreeCBNode node : menuList){
				for(TRolePermission per : rolePermissions){
					if(node.getId() == per.getMenuId()){
						node.setChecked(true);
						break;
					}
				}
			}
			
		}
		return menuList;
	}
}