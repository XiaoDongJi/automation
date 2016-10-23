package com.citichma.common.request;

import com.citichma.pojo.TimeNode;
/**
 * 
 * 节点接收类
 * @author JIXD 
 * @date 2016年8月7日 下午11:49:49  
 *
 */
public class TimeNodeListParam {
	/**
	 * 采购元件节点
	 */
	private TimeNode cgyj;
	/**
	 * 采购柜体节点
	 */
	private TimeNode cggt;
	/**
	 * 元件发放节点
	 */
	private TimeNode yjff;
	/**
	 * 装配节点
	 */
	private TimeNode zp;
	/**
	 * 检验节点
	 */
	private TimeNode jy;
	/**
	 * 调试节点
	 */
	private TimeNode ts;
	/**
	 * 入库节点
	 */
	private TimeNode rk;
	public TimeNode getCgyj() {
		return cgyj;
	}
	public void setCgyj(TimeNode cgyj) {
		this.cgyj = cgyj;
	}
	public TimeNode getCggt() {
		return cggt;
	}
	public void setCggt(TimeNode cggt) {
		this.cggt = cggt;
	}
	public TimeNode getYjff() {
		return yjff;
	}
	public void setYjff(TimeNode yjff) {
		this.yjff = yjff;
	}
	public TimeNode getZp() {
		return zp;
	}
	public void setZp(TimeNode zp) {
		this.zp = zp;
	}
	public TimeNode getJy() {
		return jy;
	}
	public void setJy(TimeNode jy) {
		this.jy = jy;
	}
	public TimeNode getTs() {
		return ts;
	}
	public void setTs(TimeNode ts) {
		this.ts = ts;
	}
	public TimeNode getRk() {
		return rk;
	}
	public void setRk(TimeNode rk) {
		this.rk = rk;
	}


	
}
