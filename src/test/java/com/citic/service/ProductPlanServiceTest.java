package com.citic.service;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.citic.base.BaseTest;
import com.citichma.common.request.ProductPlanParam;
import com.citichma.common.util.MD5Util;
import com.citichma.common.vo.EUDataGridResult;
import com.citichma.common.vo.ProductPlanDetailVo;
import com.citichma.common.vo.UserInfoVo;
import com.citichma.pojo.TUser;
import com.citichma.service.ProductPlanService;
import com.citichma.service.UserService;
/**
 * 
 * 用户测试类
 * @author JIXD 
 * @date 2016年7月16日 下午3:05:08  
 *
 */
public class ProductPlanServiceTest extends BaseTest{
	
	@Autowired
	private ProductPlanService planService;
	
	@Test
	public void testfindProductPlan(){
		ProductPlanParam request = new ProductPlanParam();
		request.setPage(1);
		request.setRows(5);
		EUDataGridResult findProductPlan = planService.findProductPlan(request);
	}
	
	@Test
	public void testfindProductPlanDetailById(){
		ProductPlanDetailVo findProductPlanDetailById = planService.findProductPlanDetailById(1);
		System.out.println(1);
	}
}
