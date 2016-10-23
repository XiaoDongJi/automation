package com.citichma.common.vo;
/**
 * 
 * 手工任务完工率
 * @author JIXD 
 * @date 2016年8月19日 下午1:26:51  
 *
 */
public class NodeRateItem {

	private String jdName;
	/**
	 * 应按期
	 */
	private Integer yinganqi;
	/**
	 * 按期
	 */
	private Integer anqi;
	/**
	 * 按期完成率
	 */
	private String anqiRate;
	/**
	 * 拖期
	 */
	private Integer tuoqi;
	/**
	 * 拖期完成率
	 */
	private String tuoqiRate;
	/**
	 * 到期未完成
	 */
	private Integer unFinish;
	/**
	 * 未到期项
	 */
	private Integer unReachDate;
	/**
	 * 汇总
	 */
	private Integer total;
	public String getJdName() {
		return jdName;
	}
	public void setJdName(String jdName) {
		this.jdName = jdName;
	}
	public Integer getYinganqi() {
		return yinganqi;
	}
	public void setYinganqi(Integer yinganqi) {
		this.yinganqi = yinganqi;
	}
	public Integer getAnqi() {
		return anqi;
	}
	public void setAnqi(Integer anqi) {
		this.anqi = anqi;
	}
	public String getAnqiRate() {
		return anqiRate;
	}
	public void setAnqiRate(String anqiRate) {
		this.anqiRate = anqiRate;
	}
	public Integer getTuoqi() {
		return tuoqi;
	}
	public void setTuoqi(Integer tuoqi) {
		this.tuoqi = tuoqi;
	}
	public String getTuoqiRate() {
		return tuoqiRate;
	}
	public void setTuoqiRate(String tuoqiRate) {
		this.tuoqiRate = tuoqiRate;
	}
	public Integer getUnFinish() {
		return unFinish;
	}
	public void setUnFinish(Integer unFinish) {
		this.unFinish = unFinish;
	}
	public Integer getUnReachDate() {
		return unReachDate;
	}
	public void setUnReachDate(Integer unReachDate) {
		this.unReachDate = unReachDate;
	}
	public Integer getTotal() {
		return total;
	}
	public void setTotal(Integer total) {
		this.total = total;
	}
	
}
