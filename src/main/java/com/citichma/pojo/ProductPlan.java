package com.citichma.pojo;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class ProductPlan {
    /**
     * 主键
     */
    private Integer id;

    /**
     * 工号
     */
    private String workSn;

    /**
     * 合同号
     */
    private String contractSn;

    /**
     * 产品图号
     */
    private String chartSn;

    /**
     * 产品名称及规格
     */
    private String productName;

    /**
     * 产品数量
     */
    private Integer productNum;

    /**
     * 合同交货期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date deliveryDate;

    /**
     * 试车节点时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date trycarDate;

    /**
     * 产品种类 1=电控 2=液压 3=其他
     */
    private Integer productType;

    /**
     * 订货单位 1=自动化、2=矿研院、3=销售公司、4=国际业务部，5=变频销售、6=机器人销售
     */
    private Integer orderCompany;

    /**
     * 用户
     */
    private String orderUser;

    /**
     * 设计师
     */
    private String designer;

    /**
     * 1=自动化公司 2=工程公司 3=其他
     */
    private Integer designCompany;

    /**
     * 编制
     */
    private String organizer;

    /**
     * 批准
     */
    private String approver;

    /**
     * 下令日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date orderDate;

    /**
     * 调整交货期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date adjustDeliverDate;

    /**
     * 项目负责人
     */
    private String projectLeader;

    /**
     * 合同类型 1=纵向 2=自揽 3=技改 4=科研 5=三包 6=返修 7=备件 8=其他
     */
    private Integer orderType;

    /**
     * 重要程度
     */
    private Integer importanceDegree;

    /**
     * 柜子数
     */
    private Integer cupboardNum;

    /**
     * 箱子数
     */
    private Integer boxNum;

    /**
     * 状态 1=撤销 2=待包装 3=在包装 4=待采购 5=在采购 6=待装配 7=在装配 8=在制缺件 9=暂停 10=在制收尾 11=在检验 12=在调试 13=待入库 14=已入库 15=待安装 
     */
    private Integer projectStatus;

    /**
     * 直发件完成日期
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date zfjFinishDate;

    /**
     * 直发件完成数量
     */
    private Integer zfjFinishNum;
    
    /**
     * 直发件数量
     */
    private Integer zfjNum;

    /**
     * 出库时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date outDate;

    /**
     * 发货报告
     */
    private String deliveryReport;
    /**
     * 备注1
     */
    private String remark1;

    /**
     * 备注2
     */
    private String remark2;

    /**
     * 备注3
     */
    private String remark3;

    /**
     * 备注4
     */
    private String remark4;
    /**
     * 备注
     */
    private String remark;

    /**
     * 创建人id
     */
    private Integer createId;

    /**
     * 创建时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd")
    private Date createTime;

    /**
     * 最后修改时间
     */
    private Date lastModifyTime;

    /**
     * 修改人id
     */
    private Integer modifyId;

    /**
     * 是否删除
     */
    private Integer isDel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getWorkSn() {
        return workSn;
    }

    public void setWorkSn(String workSn) {
        this.workSn = workSn == null ? null : workSn.trim();
    }

    public String getContractSn() {
        return contractSn;
    }

    public void setContractSn(String contractSn) {
        this.contractSn = contractSn == null ? null : contractSn.trim();
    }

    public String getChartSn() {
        return chartSn;
    }

    public void setChartSn(String chartSn) {
        this.chartSn = chartSn == null ? null : chartSn.trim();
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName == null ? null : productName.trim();
    }

    public Integer getProductNum() {
        return productNum;
    }

    public void setProductNum(Integer productNum) {
        this.productNum = productNum;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Date getTrycarDate() {
        return trycarDate;
    }

    public void setTrycarDate(Date trycarDate) {
        this.trycarDate = trycarDate;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getOrderCompany() {
        return orderCompany;
    }

    public void setOrderCompany(Integer orderCompany) {
        this.orderCompany = orderCompany;
    }

    public String getOrderUser() {
        return orderUser;
    }

    public void setOrderUser(String orderUser) {
        this.orderUser = orderUser == null ? null : orderUser.trim();
    }

    public String getDesigner() {
        return designer;
    }

    public void setDesigner(String designer) {
        this.designer = designer == null ? null : designer.trim();
    }

    public Integer getDesignCompany() {
        return designCompany;
    }

    public void setDesignCompany(Integer designCompany) {
        this.designCompany = designCompany;
    }

    public String getOrganizer() {
        return organizer;
    }

    public void setOrganizer(String organizer) {
        this.organizer = organizer == null ? null : organizer.trim();
    }

    public String getApprover() {
        return approver;
    }

    public void setApprover(String approver) {
        this.approver = approver == null ? null : approver.trim();
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }

    public Date getAdjustDeliverDate() {
        return adjustDeliverDate;
    }

    public void setAdjustDeliverDate(Date adjustDeliverDate) {
        this.adjustDeliverDate = adjustDeliverDate;
    }

    public String getProjectLeader() {
        return projectLeader;
    }

    public void setProjectLeader(String projectLeader) {
        this.projectLeader = projectLeader == null ? null : projectLeader.trim();
    }

    public Integer getOrderType() {
        return orderType;
    }

    public void setOrderType(Integer orderType) {
        this.orderType = orderType;
    }

    public Integer getImportanceDegree() {
        return importanceDegree;
    }

    public void setImportanceDegree(Integer importanceDegree) {
        this.importanceDegree = importanceDegree;
    }

    public Integer getCupboardNum() {
        return cupboardNum;
    }

    public void setCupboardNum(Integer cupboardNum) {
        this.cupboardNum = cupboardNum;
    }

    public Integer getBoxNum() {
        return boxNum;
    }

    public void setBoxNum(Integer boxNum) {
        this.boxNum = boxNum;
    }

    public Integer getProjectStatus() {
        return projectStatus;
    }

    public void setProjectStatus(Integer projectStatus) {
        this.projectStatus = projectStatus;
    }

    public Integer getZfjNum() {
        return zfjNum;
    }

    public void setZfjNum(Integer zfjNum) {
        this.zfjNum = zfjNum;
    }

    public Date getOutDate() {
        return outDate;
    }

    public void setOutDate(Date outDate) {
        this.outDate = outDate;
    }

    public String getDeliveryReport() {
        return deliveryReport;
    }

    public void setDeliveryReport(String deliveryReport) {
        this.deliveryReport = deliveryReport == null ? null : deliveryReport.trim();
    }
    
    public String getRemark1() {
		return remark1;
	}

	public void setRemark1(String remark1) {
		this.remark1 = remark1;
	}

	public String getRemark2() {
		return remark2;
	}

	public void setRemark2(String remark2) {
		this.remark2 = remark2;
	}

	public String getRemark3() {
		return remark3;
	}

	public void setRemark3(String remark3) {
		this.remark3 = remark3;
	}

	public String getRemark4() {
		return remark4;
	}

	public void setRemark4(String remark4) {
		this.remark4 = remark4;
	}

	public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    public Integer getCreateId() {
        return createId;
    }

    public void setCreateId(Integer createId) {
        this.createId = createId;
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

    public Integer getModifyId() {
        return modifyId;
    }

    public void setModifyId(Integer modifyId) {
        this.modifyId = modifyId;
    }

    public Integer getIsDel() {
        return isDel;
    }

    public void setIsDel(Integer isDel) {
        this.isDel = isDel;
    }

	public Date getZfjFinishDate() {
		return zfjFinishDate;
	}

	public void setZfjFinishDate(Date zfjFinishDate) {
		this.zfjFinishDate = zfjFinishDate;
	}

	public Integer getZfjFinishNum() {
		return zfjFinishNum;
	}

	public void setZfjFinishNum(Integer zfjFinishNum) {
		this.zfjFinishNum = zfjFinishNum;
	}
    
}