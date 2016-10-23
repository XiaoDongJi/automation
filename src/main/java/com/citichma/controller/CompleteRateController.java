package com.citichma.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.citichma.common.vo.EUDataGridResult;
import com.citichma.common.vo.NodeRateItem;

/**
 * 
 * 完工率统计
 * @author JIXD 
 * @date 2016年8月19日 下午1:09:52  
 *
 */
@RequestMapping("/completeRate")
@Controller
public class CompleteRateController {
	
	/**
	 * 
	 * 展示页面 
	 * @param   
	 * @return 
	 * @date 2016年8月19日 下午1:14:13  
	 * @throws
	 */
	@RequestMapping("/show")
	public String toCompleteRatePage(){
		return "report/completeRate";
	}
	
	/**
	 * 
	 * 获取数据 
	 * @param   
	 * @return 
	 * @date 2016年8月19日 下午1:14:06  
	 * @throws
	 */
	@RequestMapping("/getData")
	@ResponseBody
	public EUDataGridResult getRateData(){
		List<NodeRateItem> list = new ArrayList<>();
		for(int i = 0;i<4;i++){
			NodeRateItem item = new NodeRateItem();
			item.setAnqi(4);
			item.setAnqiRate("30%");
			item.setJdName("采购"+i);
			item.setTuoqi(5);
			item.setTuoqiRate("30%");
			item.setUnFinish(20);
			item.setUnReachDate(40);
			item.setYinganqi(90);
			
			list.add(item);
		}
		EUDataGridResult result = new EUDataGridResult();
		result.setTotal(list.size());
		result.setRows(list);
		return result;
	}
}
