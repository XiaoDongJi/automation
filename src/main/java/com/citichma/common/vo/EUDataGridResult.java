package com.citichma.common.vo;

import java.util.List;
/**
 * 
 * easyUi表格返回结构
 * @author JIXD 
 * @date 2016年7月19日 下午10:48:55  
 *
 */
public class EUDataGridResult {

	private long total;
	private List<?> rows;
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<?> getRows() {
		return rows;
	}
	public void setRows(List<?> rows) {
		this.rows = rows;
	}
	
	
}
