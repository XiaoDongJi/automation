package com.citichma.common.vo;

/**
 * easyUI树形控件节点格式
 * <p>Title: EUTreeNode</p>
 * <p>Description: </p>
 * @author	jixd
 * @date	2015年9月4日上午9:13:14
 * @version 1.0
 */
public class EUTreeNode {

	private Integer id;
	private String text;
	private String state;
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
}
