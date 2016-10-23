package com.citichma.service;

import java.util.List;

import com.citichma.common.vo.EUDataGridResult;
import com.citichma.common.vo.EUTreeCBNode;
import com.citichma.pojo.TMenuInfo;

/**
 * 
 * @Description: 菜单操作相关
 * @author JIXD 
 * @date 2016年7月5日 下午9:47:42  
 *
 */
public interface MenuService {
	/**
	 * 
	 * @Description: 保存菜单 
	 * @param @param menuInfo
	 * @param @return    
	 * @return int  
	 * @throws
	 */
	int saveMenu(TMenuInfo menuInfo);
	/**
	 * 
	 * @Description:更新菜单 
	 * @param @param menuInfo
	 * @param @return    
	 * @return int  
	 * @throws
	 */
	int updateMenu(TMenuInfo menuInfo);
	/**
	 * 
	 * @Description: 查找菜单
	 * @param @param id
	 * @param @return    
	 * @return TMenuInfo  
	 * @throws
	 */
	TMenuInfo findMenuById(int id);
	
	/**
	 * 
	 * 获取菜单列表 
	 * @param   
	 * @return 
	 * @date 2016年7月20日 下午9:21:13  
	 * @throws
	 */
	EUDataGridResult getMenuList();
	
	/**
	 * 
	 * 获取子菜单数量 
	 * @param   
	 * @return 
	 * @date 2016年7月23日 下午1:42:05  
	 * @throws
	 */
	int getChildMenuCount(Integer parentId);
	/**
	 * 
	 * 树形菜单子项 
	 * @param   
	 * @return 
	 * @date 2016年7月23日 下午2:59:17  
	 * @throws
	 */
	List<EUTreeCBNode> getChildMenu(Integer parentId);
}
