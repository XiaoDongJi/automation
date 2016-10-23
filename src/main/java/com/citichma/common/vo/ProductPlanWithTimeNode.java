package com.citichma.common.vo;

import java.util.List;

import com.citichma.pojo.ProductPlan;
import com.citichma.pojo.TimeNode;

/**
 * 
 * 计划详情
 * @author JIXD 
 * @date 2016年8月13日 下午2:52:23  
 *
 */
public class ProductPlanWithTimeNode extends ProductPlan{

	/**
	 * 时间节点列表
	 */
	private List<TimeNode> timeNodeList;
	
	public List<TimeNode> getTimeNodeList() {
		return timeNodeList;
	}
	public void setTimeNodeList(List<TimeNode> timeNodeList) {
		this.timeNodeList = timeNodeList;
	}
	
}
