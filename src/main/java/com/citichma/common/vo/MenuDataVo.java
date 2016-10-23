package com.citichma.common.vo;

import java.util.List;

import com.citichma.pojo.TMenuInfo;

/**
 * 
 * 展示菜单需要的数据载体,直只到二级菜单
 * @author JIXD 
 * @date 2016年8月2日 下午9:58:31  
 *
 */
public class MenuDataVo {
	
	private Integer id;
	private String name;
	
	private List<TMenuInfo> children;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public List<TMenuInfo> getChildren() {
		return children;
	}

	public void setChildren(List<TMenuInfo> children) {
		this.children = children;
	}
	
	
}
