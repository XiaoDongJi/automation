package com.citichma.common.vo;
/**
 * 
 * 菜单树状结构
 * @author JIXD 
 * @date 2016年7月20日 下午9:19:34  
 *
 */
public class EUTreeGridNode {
	/**
	 * 菜单ID
	 */
	private Integer id;
	/**
	 * 菜单名称
	 */
	private String name;
	/**
	 * 父菜单ID
	 */
	private Integer _parentId;
    /**
     * 菜单访问路径
     */
    private String menuUrl;
    /**
     * 节点状态
     */
    private String state;

    /**
     * 菜单类型 1=菜单 2=按钮
     */
    private Integer menuType;

    /**
     * 菜单顺序
     */
    private Integer menuOrder;

    
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer get_parentId() {
		return _parentId;
	}

	public void set_parentId(Integer _parentId) {
		this._parentId = _parentId;
	}

	public String getMenuUrl() {
		return menuUrl;
	}

	public void setMenuUrl(String menuUrl) {
		this.menuUrl = menuUrl;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public Integer getMenuType() {
		return menuType;
	}

	public void setMenuType(Integer menuType) {
		this.menuType = menuType;
	}

	public Integer getMenuOrder() {
		return menuOrder;
	}

	public void setMenuOrder(Integer menuOrder) {
		this.menuOrder = menuOrder;
	}

    
}
