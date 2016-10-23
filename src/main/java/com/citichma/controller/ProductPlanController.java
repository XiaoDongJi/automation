package com.citichma.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;
import com.citichma.common.constant.MessageConstant;
import com.citichma.common.request.ProductPlanParam;
import com.citichma.common.request.TimeNodeListParam;
import com.citichma.common.util.Check;
import com.citichma.common.util.DateUtil;
import com.citichma.common.util.ExcelExportUtil;
import com.citichma.common.util.UserUtil;
import com.citichma.common.vo.DataResult;
import com.citichma.common.vo.EUDataGridResult;
import com.citichma.common.vo.ProductPlanDetailVo;
import com.citichma.common.vo.ProductPlanSUVo;
import com.citichma.common.vo.ProductPlanWithTimeNode;
import com.citichma.common.vo.UserInfoVo;
import com.citichma.pojo.FileUpload;
import com.citichma.pojo.ProductPlan;
import com.citichma.pojo.TimeNode;
import com.citichma.service.ProductPlanService;
import com.citichma.service.TimeNodeService;
import com.citichma.valenum.DesignCompanyEnum;
import com.citichma.valenum.NodeTypeEnum;
import com.citichma.valenum.OrderCompanyEnum;
import com.citichma.valenum.OrderTypeEnum;
import com.citichma.valenum.ProductTypeEnum;
import com.citichma.valenum.ProjectStatusEnum;
/**
 * 
 * 生产计划控制类
 * @author JIXD 
 * @date 2016年8月7日 下午2:02:49  
 *
 */
@RequestMapping("/plan")
@Controller
public class ProductPlanController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ProductPlanController.class);
	
	@Autowired
	private ProductPlanService productPlanService;
	
	@Autowired
	private TimeNodeService timeNodeService;

	@Value("${FILE_BASE_URL}")
	private String FILE_BASE_URL;
	
	/**
	 * 
	 * 跳转到新增页面 
	 * @param   
	 * @return 
	 * @date 2016年8月7日 下午1:04:08  
	 * @throws
	 */
	@RequestMapping("/add")
	public String goProductPlanAdd(){
		return "plan/productPlanAdd";
	}
	
	/**
	 * 
	 * 修改生产计划 
	 * @param   
	 * @return 
	 * @date 2016年8月13日 下午2:28:42  
	 * @throws
	 */
	@RequestMapping("/edit")
	public String goProductPlanEdit(HttpServletRequest request){
		String id = request.getParameter("planId");
		String type = request.getParameter("type");
		if(Check.NuNStr(id)){
			//出错异常，跳404页
		}
		ProductPlanDetailVo detailVo = productPlanService.findProductPlanDetailById(Integer.parseInt(id));
		List<TimeNode> timeNodeList = detailVo.getTimeNodeList();
		
		if(!Check.NuNCollection(timeNodeList)){
			
			for(TimeNode node : timeNodeList){
				if(Check.NuNObj(node.getPlanFinishTime())){
					node.setCountDay(0l);
				}
				if(!Check.NuNObj(node.getPlanFinishTime()) && Check.NuNObj(node.getActualFinishTime())){
					node.setCountDay(DateUtil.getDateIntervalNum(node.getPlanFinishTime(), new Date()));
				}
				
				if(!Check.NuNObj(node.getPlanFinishTime()) && !Check.NuNObj(node.getActualFinishTime())){
					node.setCountDay(DateUtil.getDateIntervalNum(node.getPlanFinishTime(),node.getActualFinishTime()));
				}
				if(node.getNodeType() == NodeTypeEnum.CGYJ.getCode()){
					request.setAttribute("cgyj", node);
				}
				if(node.getNodeType() == NodeTypeEnum.CGGT.getCode()){
					request.setAttribute("cggt", node);
				}
				if(node.getNodeType() == NodeTypeEnum.YJFF.getCode()){
					request.setAttribute("yjff", node);
				}
				if(node.getNodeType() == NodeTypeEnum.ZPJD.getCode()){
					request.setAttribute("zp", node);
				}
				if(node.getNodeType() == NodeTypeEnum.JYJD.getCode()){
					request.setAttribute("jy", node);
				}
				if(node.getNodeType() == NodeTypeEnum.TSJD.getCode()){
					request.setAttribute("ts", node);
				}
				if(node.getNodeType() == NodeTypeEnum.RKJD.getCode()){
					request.setAttribute("rk", node);
				}
			}
		}
		List<FileUpload> fileList = detailVo.getFileList();
		for(FileUpload file : fileList){
			String url = file.getFileUrl();
			url = url.replace("\\", "/");
			file.setFileUrl(FILE_BASE_URL + "/" + url);
		}
		
		request.setAttribute("detailVo", detailVo);
		if(!Check.NuNStr(type) && "time".equals(type)){
			return "plan/productPlanTimeEdit";
		}
		return "plan/productPlanEdit";
	}
	
	/**
	 * 
	 * 增加生产计划 
	 * @param   
	 * @return 
	 * @date 2016年8月7日 下午2:01:29  
	 * @throws
	 */
	@RequestMapping("/doAdd")
	@ResponseBody
	public String productPlanAdd(ProductPlan productPlan,TimeNodeListParam nodeList){
		if(Check.NuNObj(productPlan.getId())){
			if(Check.NuNStr(productPlan.getWorkSn())){
				return JSONObject.toJSONString(DataResult.build(HttpStatus.BAD_REQUEST.value(), MessageConstant.WORK_SN));
			}
		}
		
		UserInfoVo currentUser = UserUtil.getCurrentUser();
		productPlan.setCreateId(currentUser.getUserId());
		ProductPlanSUVo suVo = new ProductPlanSUVo();
		try{
			int resultCount = productPlanService.saveOrUpdateProductPlan(productPlan);
			if(resultCount > 0){
				suVo.setPlanId(productPlan.getId());
			}
			TimeNode cgyj = nodeList.getCgyj();
			TimeNode cggt = nodeList.getCggt();
			TimeNode rk = nodeList.getRk();
			TimeNode yjff = nodeList.getYjff();
			TimeNode jy = nodeList.getJy();
			TimeNode ts = nodeList.getTs();
			TimeNode zp = nodeList.getZp();
			
			List<TimeNode> tlist = new ArrayList<>();
			tlist.add(cgyj);
			tlist.add(cggt);
			tlist.add(rk);
			tlist.add(yjff);
			tlist.add(jy);
			tlist.add(ts);
			tlist.add(zp);
			
			for(TimeNode node : tlist){
				if(!Check.NuNObj(node)){
					if((Check.NuNObj(node.getId()) && !Check.NuNObj(node.getPlanFinishTime()) && !Check.NuNObj(node.getPlanDayNum())) || !Check.NuNObj(node.getId())){
						node.setPlanId(suVo.getPlanId());
						node.setNodeName(NodeTypeEnum.getnNodeTypeEnumByCode(node.getNodeType()).getName());
						if(timeNodeService.saveOrUpdateTimeNode(node) > 0){
							Integer id = node.getId();
							switch (node.getNodeType()){
							case 1:
								suVo.setCgyjId(id);
								break;
							case 2:
								suVo.setCggtId(id);
								break;
							case 3:
								suVo.setYjffId(id);;
								break;
							case 4:
								suVo.setZpId(id);;
								break;
							case 5:
								suVo.setJyId(id);
								break;
							case 6:
								suVo.setTsId(id);
								break;
							case 7:
								suVo.setRkId(id);
								break;
							}
						}
					}
				}
			}
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			return JSONObject.toJSONString(DataResult.build(HttpStatus.INTERNAL_SERVER_ERROR.value(), MessageConstant.SERVER_ERROR));
		}
		return JSONObject.toJSONString(DataResult.ok(suVo));
	}
	
	/**
	 * 
	 * 更新时间节点 
	 * @param   
	 * @return 
	 * @date 2016年8月14日 下午4:26:11  
	 * @throws
	 */
	@RequestMapping("/update/timeNode")
	@ResponseBody
	public DataResult doUpdateTimeNode(TimeNode timeNode){
		if(Check.NuNObj(timeNode)){
			return DataResult.build(HttpStatus.BAD_REQUEST.value(),MessageConstant.PARAM_NULL);
		}
		if(Check.NuNObj(timeNode.getId())){
			return DataResult.build(HttpStatus.BAD_REQUEST.value(),MessageConstant.ID_NULL);
		}
		if(Check.NuNObj(timeNode.getActualFinishTime())){
			return DataResult.build(HttpStatus.BAD_REQUEST.value(),MessageConstant.PARAM_NULL);
		}
		int count = timeNodeService.updateTimeNode(timeNode);
		if(count > 0){
			return DataResult.ok();
		}else{
			return DataResult.build(HttpStatus.SERVICE_UNAVAILABLE.value(), MessageConstant.UPDATE_ERROR);
		}
	}
	
	/**
	 * 
	 * 计划列表 
	 * @param   
	 * @return 
	 * @date 2016年8月9日 下午10:41:08  
	 * @throws
	 */
	@RequestMapping("/timelist")
	public String planList(ProductPlanParam request){
		
		return "plan/planTimeList";
	}
	/**
	 * 
	 * 生产计划列表时间节点修改 
	 * @param   
	 * @return 
	 * @date 2016年8月14日 下午3:24:28  
	 * @throws
	 */
	@RequestMapping("/list")
	public String planTimeList(ProductPlanParam request){
		
		return "plan/planList";
	}
	/**
	 * 
	 * 表格数据 
	 * @param   
	 * @return 
	 * @date 2016年8月12日 下午9:04:16  
	 * @throws
	 */
	@RequestMapping("/dataList")
	@ResponseBody
	public EUDataGridResult dataPlanList(ProductPlanParam request){
		EUDataGridResult resutlData = null;
		if(Check.NuNObj(request)){
			return new EUDataGridResult();
		}
		try{
			resutlData = productPlanService.findProductPlan(request);
		}catch(Exception e){
			LOGGER.error(e.getMessage());
			return new EUDataGridResult();
		}
		return resutlData;
	}
	
	/**
	 * 
	 * 导出excel表格 
	 * @param   
	 * @return 
	 * @date 2016年9月17日 下午10:41:14  
	 * @throws
	 */
	@RequestMapping("/export")
	public void exportExcel(HttpServletResponse response){
		response.setContentType("APPLICATION/vnd.ms-excel"); 
		response.setContentType("application/x-download;charset=GBK");
        response.setHeader("Content-Disposition", "attachment;filename=PLAN_"+System.currentTimeMillis()+".xls"); 
        
		List<ProductPlanWithTimeNode> planlist = productPlanService.findProductPlanWithNodeAll();
		// 创建一个workbook 对应一个excel应用文件  
        XSSFWorkbook book = new XSSFWorkbook();
        XSSFSheet sheet = book.createSheet("生产计划");
        ExcelExportUtil exportUtil = new ExcelExportUtil(book, sheet);
        
        XSSFCellStyle headStyle = exportUtil.getHeadStyle();
        XSSFCellStyle bodyStyle = exportUtil.getBodyStyle();
        XSSFCellStyle bodyDateStyle = exportUtil.getBodyDateStyle();
        //创建头
        XSSFRow headRow = sheet.createRow(0);
        String[] titles = new String[]{"序号","工号","合同号","产品图号","产品名称及规格","产品数量","合同交货期","试车节点时间","产品种类","订货单位",
        		"用户","设计师","设计公司","编制","批准","下令日期","调整交货期","项目负责人","合同类型","重要程度","柜子数","箱子数","状态","直发件数量",
        		"直发件完成数量","直发件完成日期","出库时间","发货报告","备注1","备注2","备注3","备注4","备注5","采购元件应完成日期","采购元件周期","采购元件完成日期",
        		"采购元件应完成日期","采购元件周期","采购元件完成日期","采购元件负责人","采购元件备注",
        		"采购柜体应完成日期","采购柜体周期","采购柜体完成日期","采购柜体负责人","采购柜体备注",
        		"元件发放应完成日期","元件发放周期","元件发放完成日期","元件发放负责人","元件发放备注",
        		"装配节点应完成日期","装配节点周期","采装配节点完成日期","装配节点负责人","装配节点备注",
        		"检验节点应完成日期","检验节点周期","检验节点完成日期","检验节点负责人","检验节点备注",
        		"调试节点应完成日期","调试节点周期","调试节点完成日期","调试节点负责人","调试节点备注",
        		"包装入库应完成日期","包装入库周期","包装入库完成日期","包装入库负责人","包装入库备注"};
        for(int i = 0;i<titles.length;i++){
        	XSSFCell cell = headRow.createCell(i);
        	cell.setCellStyle(headStyle);
        	cell.setCellValue(titles[i]);
        }
        
        for(int i = 0;i<planlist.size();i++){
        	ProductPlanWithTimeNode plan = planlist.get(i);
        	XSSFRow bodyRow = sheet.createRow(i+1);
        	
        	XSSFCell cell_0 = bodyRow.createCell(0);
        	cell_0.setCellValue(i+1);
        	cell_0.setCellStyle(bodyStyle);
        	
        	XSSFCell cell_1 = bodyRow.createCell(1);
        	cell_1.setCellValue(plan.getWorkSn());
        	cell_1.setCellStyle(bodyStyle);
        	
        	XSSFCell cell_2 = bodyRow.createCell(2);
        	cell_2.setCellStyle(bodyStyle);
			if (plan.getContractSn() != null){
        		cell_2.setCellValue(plan.getContractSn());
			}

        	XSSFCell cell_3 = bodyRow.createCell(3);
        	cell_3.setCellStyle(bodyStyle);
			if (plan.getChartSn() != null){
        		cell_3.setCellValue(plan.getChartSn());
			}

        	XSSFCell cell_4 = bodyRow.createCell(4);
        	cell_4.setCellStyle(bodyStyle);
			if (plan.getProductName() != null){
        		cell_4.setCellValue(plan.getProductName());
			}

        	XSSFCell cell_5 = bodyRow.createCell(5);
        	cell_5.setCellStyle(bodyStyle);
        	if(plan.getProductNum() != null){
        		cell_5.setCellValue(plan.getProductNum());
        	}
        	
        	XSSFCell cell_6 = bodyRow.createCell(6);
        	cell_6.setCellStyle(bodyDateStyle);
        	if(plan.getDeliveryDate() != null){
        		cell_6.setCellValue(plan.getDeliveryDate());
        	}
        	
        	XSSFCell cell_7 = bodyRow.createCell(7);
        	cell_7.setCellStyle(bodyDateStyle);
        	if(plan.getTrycarDate() != null){
        		cell_7.setCellValue(plan.getTrycarDate());
        	}
        	
        	
        	XSSFCell cell_8 = bodyRow.createCell(8);
        	cell_8.setCellStyle(bodyStyle);
			if (plan.getProductType() != null){
        		cell_8.setCellValue(ProductTypeEnum.getProductTypeEnumByCode(plan.getProductType()).getName());
			}

        	XSSFCell cell_9 = bodyRow.createCell(9);
        	cell_9.setCellStyle(bodyStyle);
			if (plan.getOrderCompany() != null){
        		cell_9.setCellValue(OrderCompanyEnum.getProductTypeEnumByCode(plan.getOrderCompany()).getName());
			}

        	XSSFCell cell_10 = bodyRow.createCell(10);
        	cell_10.setCellStyle(bodyStyle);
			if (plan.getOrderUser() != null){
        		cell_10.setCellValue(plan.getOrderUser());
			}

        	XSSFCell cell_11 = bodyRow.createCell(11);
        	cell_11.setCellStyle(bodyStyle);
			if (plan.getDesigner() != null){
        		cell_11.setCellValue(plan.getDesigner());
			}

        	XSSFCell cell_12 = bodyRow.createCell(12);
        	cell_12.setCellStyle(bodyStyle);
			if (plan.getDesignCompany() != null){
        		cell_12.setCellValue(DesignCompanyEnum.getProductTypeEnumByCode(plan.getDesignCompany()).getName());
			}

        	
        	XSSFCell cell_13 = bodyRow.createCell(13);
        	cell_13.setCellStyle(bodyStyle);
			if (plan.getOrganizer() != null){
        		cell_13.setCellValue(plan.getOrganizer());
			}

        	XSSFCell cell_14 = bodyRow.createCell(14);
        	cell_14.setCellStyle(bodyStyle);
			if (plan.getApprover() !=null){
        		cell_14.setCellValue(plan.getApprover());
			}

        	XSSFCell cell_15 = bodyRow.createCell(15);
        	cell_15.setCellStyle(bodyDateStyle);
        	if(plan.getOrderDate() != null){
        		cell_15.setCellValue(plan.getOrderDate());
        	}
        	
        	XSSFCell cell_16 = bodyRow.createCell(16);
        	cell_16.setCellStyle(bodyDateStyle);
        	if(plan.getAdjustDeliverDate() != null){
        		cell_16.setCellValue(plan.getAdjustDeliverDate());
        	}
        	
        	XSSFCell cell_17 = bodyRow.createCell(17);
        	cell_17.setCellStyle(bodyStyle);
			if (plan.getProjectLeader() != null){
        		cell_17.setCellValue(plan.getProjectLeader());
			}

        	XSSFCell cell_18 = bodyRow.createCell(18);
        	cell_18.setCellStyle(bodyStyle);
			if (plan.getOrderType() != null){
        		cell_18.setCellValue(OrderTypeEnum.getProductTypeEnumByCode(plan.getOrderType()).getName());
			}

        	XSSFCell cell_19 = bodyRow.createCell(19);
        	cell_19.setCellValue(plan.getImportanceDegree());
        	cell_19.setCellStyle(bodyStyle);
        	
        	XSSFCell cell_20 = bodyRow.createCell(20);
        	cell_20.setCellStyle(bodyStyle);
        	if(plan.getCupboardNum() != null){
        		cell_20.setCellValue(plan.getCupboardNum());
        	}
        	
        	
        	XSSFCell cell_21 = bodyRow.createCell(21);
        	cell_21.setCellStyle(bodyStyle);
        	if(plan.getBoxNum() != null){
        		cell_21.setCellValue(plan.getBoxNum());
        	}
        	
        	XSSFCell cell_22 = bodyRow.createCell(22);
        	cell_22.setCellStyle(bodyStyle);
			if(plan.getProjectStatus() != null){
        		cell_22.setCellValue(ProjectStatusEnum.getProjectStatusEnumByCode(plan.getProjectStatus()).getName());
			}

        	XSSFCell cell_23 = bodyRow.createCell(23);
        	cell_23.setCellStyle(bodyStyle);
        	if(plan.getZfjNum() != null){
        		cell_23.setCellValue(plan.getZfjNum());
        	}
        	
        	XSSFCell cell_24 = bodyRow.createCell(24);
        	cell_24.setCellStyle(bodyStyle);
        	if(plan.getZfjFinishNum() != null){
        		cell_24.setCellValue(plan.getZfjFinishNum());
        	}
        	
        	XSSFCell cell_25 = bodyRow.createCell(25);
        	cell_25.setCellStyle(bodyDateStyle);
        	if(plan.getZfjFinishDate() != null){
        		cell_25.setCellValue(plan.getZfjFinishDate());
        	}
        	
        	XSSFCell cell_26 = bodyRow.createCell(26);
        	cell_26.setCellStyle(bodyDateStyle);
        	if(plan.getOutDate() != null){
        		cell_26.setCellValue(plan.getOutDate());
        	}
        	
        	XSSFCell cell_27 = bodyRow.createCell(27);
        	cell_27.setCellValue(plan.getDeliveryReport());
        	cell_27.setCellStyle(bodyStyle);
        	
        	XSSFCell cell_28 = bodyRow.createCell(28);
        	cell_28.setCellValue(plan.getRemark1());
        	cell_28.setCellStyle(bodyStyle);
        	
        	XSSFCell cell_29 = bodyRow.createCell(29);
        	cell_29.setCellValue(plan.getRemark2());
        	cell_29.setCellStyle(bodyStyle);
        	
        	XSSFCell cell_30 = bodyRow.createCell(30);
        	cell_30.setCellValue(plan.getRemark3());
        	cell_30.setCellStyle(bodyStyle);
        	
        	XSSFCell cell_31 = bodyRow.createCell(31);
        	cell_31.setCellValue(plan.getRemark4());
        	cell_31.setCellStyle(bodyStyle);
        	
        	XSSFCell cell_32 = bodyRow.createCell(32);
        	cell_32.setCellValue(plan.getRemark());
        	cell_32.setCellStyle(bodyStyle);
        	
        	
        	List<TimeNode> timeNodeList = plan.getTimeNodeList();
        	for(int j = 0;j<timeNodeList.size();j++){
        		TimeNode timeNode = timeNodeList.get(j);
        		if(timeNode.getNodeType() == NodeTypeEnum.CGYJ.getCode()){
        			XSSFCell cell_33 = bodyRow.createCell(33);
        			cell_33.setCellStyle(bodyDateStyle);
        			if(timeNode.getPlanFinishTime() != null){
        				cell_33.setCellValue(timeNode.getPlanFinishTime());
        			}
        			
        			XSSFCell cell_34 = bodyRow.createCell(34);
        			cell_34.setCellStyle(bodyStyle);
        			if(timeNode.getPlanDayNum()!= null){
        				cell_34.setCellValue(timeNode.getPlanDayNum());
        			}
        			
        			XSSFCell cell_35 = bodyRow.createCell(35);
        			cell_35.setCellStyle(bodyDateStyle);
        			if(timeNode.getActualFinishTime() != null){
        				cell_35.setCellValue(timeNode.getActualFinishTime());
        			}
        			
        			XSSFCell cell_36 = bodyRow.createCell(36);
        			cell_36.setCellValue(timeNode.getNodeLeader());
        			cell_36.setCellStyle(bodyStyle);
        			
        			XSSFCell cell_37 = bodyRow.createCell(37);
        			cell_37.setCellValue(timeNode.getRemark());
        			cell_37.setCellStyle(bodyStyle);
        		}
        		
        		if(timeNode.getNodeType() == NodeTypeEnum.CGGT.getCode()){
        			XSSFCell cell_38 = bodyRow.createCell(38);
        			cell_38.setCellStyle(bodyDateStyle);
        			if(timeNode.getPlanFinishTime() != null){
        				cell_38.setCellValue(timeNode.getPlanFinishTime());
        			}
        			
        			XSSFCell cell_39 = bodyRow.createCell(39);
        			cell_39.setCellStyle(bodyStyle);
        			if(timeNode.getPlanDayNum() != null){
        				cell_39.setCellValue(timeNode.getPlanDayNum());
        			}
        			
        			XSSFCell cell_40 = bodyRow.createCell(40);
        			cell_40.setCellStyle(bodyDateStyle);
        			if(timeNode.getActualFinishTime() != null){
        				cell_40.setCellValue(timeNode.getActualFinishTime());
        			}
        			
        			XSSFCell cell_41 = bodyRow.createCell(41);
        			cell_41.setCellValue(timeNode.getNodeLeader());
        			cell_41.setCellStyle(bodyStyle);
        			
        			XSSFCell cell_42 = bodyRow.createCell(42);
        			cell_42.setCellValue(timeNode.getRemark());
        			cell_42.setCellStyle(bodyStyle);
        		}
        		
        		
        		if(timeNode.getNodeType() == NodeTypeEnum.YJFF.getCode()){
        			XSSFCell cell_43 = bodyRow.createCell(43);
        			cell_43.setCellStyle(bodyDateStyle);
        			if(timeNode.getPlanFinishTime() != null){
        				cell_43.setCellValue(timeNode.getPlanFinishTime());
        			}
        			
        			XSSFCell cell_44 = bodyRow.createCell(44);
        			cell_44.setCellStyle(bodyStyle);
        			if(timeNode.getPlanDayNum() != null){
        				cell_44.setCellValue(timeNode.getPlanDayNum());
        			}
        			
        			XSSFCell cell_45 = bodyRow.createCell(45);
        			cell_45.setCellStyle(bodyDateStyle);
        			if(timeNode.getActualFinishTime() != null){
        				cell_45.setCellValue(timeNode.getActualFinishTime());
        			}
        			
        			XSSFCell cell_46 = bodyRow.createCell(46);
        			cell_46.setCellValue(timeNode.getNodeLeader());
        			cell_46.setCellStyle(bodyStyle);
        			
        			XSSFCell cell_47 = bodyRow.createCell(47);
        			cell_47.setCellValue(timeNode.getRemark());
        			cell_47.setCellStyle(bodyStyle);
        		}
        		
        		
        		if(timeNode.getNodeType() == NodeTypeEnum.ZPJD.getCode()){
        			XSSFCell cell_48 = bodyRow.createCell(48);
        			cell_48.setCellStyle(bodyDateStyle);
        			if(timeNode.getPlanFinishTime() != null){
        				cell_48.setCellValue(timeNode.getPlanFinishTime());
        			}
        			
        			XSSFCell cell_49 = bodyRow.createCell(49);
        			cell_49.setCellStyle(bodyStyle);
        			if(timeNode.getPlanDayNum() != null){
        				cell_49.setCellValue(timeNode.getPlanDayNum());
        			}
        			XSSFCell cell_50 = bodyRow.createCell(50);
        			cell_50.setCellStyle(bodyDateStyle);
        			if(timeNode.getActualFinishTime()!=null){
        				cell_50.setCellValue(timeNode.getActualFinishTime());
        			}
        			
        			XSSFCell cell_51 = bodyRow.createCell(51);
        			cell_51.setCellValue(timeNode.getNodeLeader());
        			cell_51.setCellStyle(bodyStyle);
        			
        			XSSFCell cell_52 = bodyRow.createCell(52);
        			cell_52.setCellValue(timeNode.getRemark());
        			cell_52.setCellStyle(bodyStyle);
        		}
        		
        		
        		if(timeNode.getNodeType() == NodeTypeEnum.JYJD.getCode()){
        			
        			XSSFCell cell_53 = bodyRow.createCell(53);
        			cell_53.setCellStyle(bodyDateStyle);
        			if(timeNode.getPlanFinishTime() != null){
        				cell_53.setCellValue(timeNode.getPlanFinishTime());
        			}
        			
        			XSSFCell cell_54 = bodyRow.createCell(54);
        			cell_54.setCellStyle(bodyStyle);
        			if(timeNode.getPlanDayNum() != null){
        				cell_54.setCellValue(timeNode.getPlanDayNum());
        			}
        			
        			XSSFCell cell_55 = bodyRow.createCell(55);
        			cell_55.setCellStyle(bodyDateStyle);
        			if(timeNode.getActualFinishTime() != null){
        				cell_55.setCellValue(timeNode.getActualFinishTime());
        			}
        			
        			XSSFCell cell_56 = bodyRow.createCell(56);
        			cell_56.setCellValue(timeNode.getNodeLeader());
        			cell_56.setCellStyle(bodyStyle);
        			
        			XSSFCell cell_57 = bodyRow.createCell(57);
        			cell_57.setCellValue(timeNode.getRemark());
        			cell_57.setCellStyle(bodyStyle);
        		}
        		
        		
        		if(timeNode.getNodeType() == NodeTypeEnum.TSJD.getCode()){
        			XSSFCell cell_58 = bodyRow.createCell(58);
        			cell_58.setCellStyle(bodyDateStyle);
        			if(timeNode.getPlanFinishTime() != null){
        				cell_58.setCellValue(timeNode.getPlanFinishTime());
        			}
        			
        			XSSFCell cell_59 = bodyRow.createCell(59);
        			cell_59.setCellStyle(bodyStyle);
        			if(timeNode.getPlanDayNum() != null){
        				cell_59.setCellValue(timeNode.getPlanDayNum());
        			}
        			
        			XSSFCell cell_60 = bodyRow.createCell(60);
        			cell_60.setCellStyle(bodyDateStyle);
        			if(timeNode.getActualFinishTime() != null){
        				cell_60.setCellValue(timeNode.getActualFinishTime());
        			}
        			
        			XSSFCell cell_61 = bodyRow.createCell(61);
        			cell_61.setCellValue(timeNode.getNodeLeader());
        			cell_61.setCellStyle(bodyStyle);
        			
        			XSSFCell cell_62 = bodyRow.createCell(62);
        			cell_62.setCellValue(timeNode.getRemark());
        			cell_62.setCellStyle(bodyStyle);
        		}
        		
        		
        		if(timeNode.getNodeType() == NodeTypeEnum.RKJD.getCode()){
        			XSSFCell cell_63 = bodyRow.createCell(63);
        			cell_63.setCellStyle(bodyDateStyle);
        			if(timeNode.getPlanFinishTime() != null){
        				cell_63.setCellValue(timeNode.getPlanFinishTime());
        			}
        			
        			XSSFCell cell_64 = bodyRow.createCell(64);
        			cell_64.setCellStyle(bodyStyle);
        			if(timeNode.getPlanDayNum() != null){
        				cell_64.setCellValue(timeNode.getPlanDayNum());
        			}
        			
        			XSSFCell cell_65 = bodyRow.createCell(65);
        			cell_65.setCellStyle(bodyDateStyle);
        			if(timeNode.getActualFinishTime() != null){
        				cell_65.setCellValue(timeNode.getActualFinishTime());
        			}
        			
        			XSSFCell cell_66 = bodyRow.createCell(66);
        			cell_66.setCellValue(timeNode.getNodeLeader());
        			cell_66.setCellStyle(bodyStyle);
        			
        			XSSFCell cell_67 = bodyRow.createCell(67);
        			cell_67.setCellValue(timeNode.getRemark());
        			cell_67.setCellStyle(bodyStyle);
        		}
        		
        		
        	}
        	
        }
        ServletOutputStream outputStream = null;
        try{
        	outputStream = response.getOutputStream();
        	book.write(response.getOutputStream());
        	outputStream.flush();
        	outputStream.close();
        }catch(Exception e){
        	
        }finally {
			if(outputStream!=null){
				try {
					outputStream.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
	}
	
}
