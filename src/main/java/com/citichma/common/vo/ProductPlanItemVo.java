package com.citichma.common.vo;

import java.util.Date;

import com.citichma.pojo.ProductPlan;
/**
 * 
 * 列表显示数据
 * @author JIXD 
 * @date 2016年8月11日 下午10:29:02  
 *
 */
public class ProductPlanItemVo extends ProductPlan{
	/**
	 * 入库计划日期
	 */
	private Date rkPlanDate;
	/**
	 * 入库时间
	 */
	private Date rkDate;
	/**
	 * 倒计时
	 */
	private Long countdown;
	/**
	 * 状态名称
	 */
	private String statusName;
	
	public Date getRkPlanDate() {
		return rkPlanDate;
	}
	public void setRkPlanDate(Date rkPlanDate) {
		this.rkPlanDate = rkPlanDate;
	}
	public Date getRkDate() {
		return rkDate;
	}
	public void setRkDate(Date rkDate) {
		this.rkDate = rkDate;
	}
	public String getStatusName() {
		return statusName;
	}
	public void setStatusName(String statusName) {
		this.statusName = statusName;
	}
	public Long getCountdown() {
		return countdown;
	}
	public void setCountdown(Long countdown) {
		this.countdown = countdown;
	}
	
}
