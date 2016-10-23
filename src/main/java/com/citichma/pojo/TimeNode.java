package com.citichma.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class TimeNode {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 关联编号
     */
    private Integer planId;

    /**
     * 节点名称
     */
    private String nodeName;

    /**
     * 节点类型 1=采购节点 2=原件发放 3=装配节点 4=检验及调试 5=入库节点
     */
    private Integer nodeType;
    
    /**
     * 节点负责人
     */
    private String nodeLeader;

    /**
     * 计划完成时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date planFinishTime;

    /**
     * 计划完成天数
     */
    private Integer planDayNum;

    /**
     * 实际完成时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date actualFinishTime;
    
    /**
     * 备注
     */
    private String remark;
    
    /**
     * 倒计时
     */
    private Long countDay;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date lastModifyTime;
    

    /**
     * 是否删除 0=未删除 1=删除
     */
    private Integer isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPlanId() {
        return planId;
    }

    public void setPlanId(Integer planId) {
        this.planId = planId;
    }

    public String getNodeName() {
        return nodeName;
    }

    public void setNodeName(String nodeName) {
        this.nodeName = nodeName == null ? null : nodeName.trim();
    }

    public Integer getNodeType() {
        return nodeType;
    }

    public void setNodeType(Integer nodeType) {
        this.nodeType = nodeType;
    }

    public Date getPlanFinishTime() {
        return planFinishTime;
    }

    public void setPlanFinishTime(Date planFinishTime) {
        this.planFinishTime = planFinishTime;
    }

    public Integer getPlanDayNum() {
        return planDayNum;
    }

    public void setPlanDayNum(Integer planDayNum) {
        this.planDayNum = planDayNum;
    }

    public Date getActualFinishTime() {
        return actualFinishTime;
    }

    public void setActualFinishTime(Date actualFinishTime) {
        this.actualFinishTime = actualFinishTime;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getLastModifyTime() {
        return lastModifyTime;
    }

    public void setLastModifyTime(Date lastModifyTime) {
        this.lastModifyTime = lastModifyTime;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

	public Long getCountDay() {
		return countDay;
	}

	public void setCountDay(Long countDay) {
		this.countDay = countDay;
	}

	public String getRemark() {
		return remark;
	}

	public void setRemark(String remark) {
		this.remark = remark;
	}

	public String getNodeLeader() {
		return nodeLeader;
	}

	public void setNodeLeader(String nodeLeader) {
		this.nodeLeader = nodeLeader;
	}
    
}