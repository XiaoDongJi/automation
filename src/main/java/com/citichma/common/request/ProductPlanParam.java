package com.citichma.common.request;

import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import com.citichma.common.base.BasePage;

public class ProductPlanParam extends BasePage{

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
    private Date deliveryDate;

    /**
     * 产品种类 1=电控 2=液压 3=其他
     */
    private Integer productType;

    /**
     * 订货单位
     */
    private String orderCompany;

    /**
     * 用户
     */
    private String orderUser;

    /**
     * 设计师
     */
    private String designer;

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
    private Date orderDate;


    /**
     * 项目负责人
     */
    private String projectLeader;

    /**
     * 合同类型 1=纵向 2=自揽 3=技改 4=其他
     */
    private Integer orderType;

    /**
     * 重要程度
     */
    private Integer importanceDegree;


    /**
     * 状态 1=撤销 2=待包装 3=在包装 4=待采购 5=在采购 6=待装配 7=在装配 8=在制缺件 9=暂停 10=在制收尾 11=在检验 12=在调试 13=待入库 14=已入库 15=待安装 
     */
    private Integer projectStatus;
    
    /**
     * 状态列表
     */
    private String projectStatusList;

    /**
     * 调整交货期开始时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date startadjustDeliverDate;
    /**
     * 调整交货期结束时间
     */
    @DateTimeFormat(pattern="yyyy-MM-dd") 
    private Date endadjustDeliverDate;

	private List<String> sort;

	private List<String> order;

	public String getWorkSn() {
		return workSn;
	}


	public void setWorkSn(String workSn) {
		this.workSn = workSn;
	}


	public String getContractSn() {
		return contractSn;
	}


	public void setContractSn(String contractSn) {
		this.contractSn = contractSn;
	}


	public String getChartSn() {
		return chartSn;
	}


	public void setChartSn(String chartSn) {
		this.chartSn = chartSn;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
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


	public Integer getProductType() {
		return productType;
	}


	public void setProductType(Integer productType) {
		this.productType = productType;
	}


	public String getOrderCompany() {
		return orderCompany;
	}


	public void setOrderCompany(String orderCompany) {
		this.orderCompany = orderCompany;
	}


	public String getOrderUser() {
		return orderUser;
	}


	public void setOrderUser(String orderUser) {
		this.orderUser = orderUser;
	}


	public String getDesigner() {
		return designer;
	}


	public void setDesigner(String designer) {
		this.designer = designer;
	}


	public String getOrganizer() {
		return organizer;
	}


	public void setOrganizer(String organizer) {
		this.organizer = organizer;
	}


	public String getApprover() {
		return approver;
	}


	public void setApprover(String approver) {
		this.approver = approver;
	}


	public Date getOrderDate() {
		return orderDate;
	}


	public void setOrderDate(Date orderDate) {
		this.orderDate = orderDate;
	}


	public String getProjectLeader() {
		return projectLeader;
	}


	public void setProjectLeader(String projectLeader) {
		this.projectLeader = projectLeader;
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


	public Integer getProjectStatus() {
		return projectStatus;
	}


	public void setProjectStatus(Integer projectStatus) {
		this.projectStatus = projectStatus;
	}


	public Date getStartadjustDeliverDate() {
		return startadjustDeliverDate;
	}


	public void setStartadjustDeliverDate(Date startadjustDeliverDate) {
		this.startadjustDeliverDate = startadjustDeliverDate;
	}


	public Date getEndadjustDeliverDate() {
		return endadjustDeliverDate;
	}


	public void setEndadjustDeliverDate(Date endadjustDeliverDate) {
		this.endadjustDeliverDate = endadjustDeliverDate;
	}


	public String getProjectStatusList() {
		return projectStatusList;
	}


	public void setProjectStatusList(String projectStatusList) {
		this.projectStatusList = projectStatusList;
	}

	public List<String> getSort() {
		return sort;
	}

	public void setSort(List<String> sort) {
		this.sort = sort;
	}

	public List<String> getOrder() {
		return order;
	}

	public void setOrder(List<String> order) {
		this.order = order;
	}
}
