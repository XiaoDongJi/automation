package com.citichma.common.base;
/**
 * 
 * 分页参数
 * @author JIXD 
 * @date 2016年7月18日 下午10:43:32  
 *
 */
public class BasePage {
	/**
	 * 页数
	 */
	private Integer page;
	/**
	 * 每页条数
	 */
	private Integer rows;
	
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
	
	
}
