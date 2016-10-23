package com.citichma.common.vo;

import java.util.List;

import com.citichma.pojo.FileUpload;
import com.citichma.pojo.ProductPlan;
import com.citichma.pojo.TimeNode;

/**
 * 
 * 计划详情
 * @author JIXD 
 * @date 2016年8月13日 下午2:52:23  
 *
 */
public class ProductPlanDetailVo extends ProductPlan{

	/**
	 * 时间节点列表
	 */
	private List<TimeNode> timeNodeList;
	/**
	 * 文件列表
	 */
	private List<FileUpload> fileList;
	
	public List<TimeNode> getTimeNodeList() {
		return timeNodeList;
	}
	public void setTimeNodeList(List<TimeNode> timeNodeList) {
		this.timeNodeList = timeNodeList;
	}
	public List<FileUpload> getFileList() {
		return fileList;
	}
	public void setFileList(List<FileUpload> fileList) {
		this.fileList = fileList;
	}
	
	
}
