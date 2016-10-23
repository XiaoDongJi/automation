package com.citichma.common.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 
 * 时间工具类
 * @author JIXD 
 * @date 2016年8月11日 下午10:44:22  
 *
 */
public class DateUtil {
	
	public static final String DATE_FORMATE_SHORT = "yyyy-MM-dd";
	/**
	 * 
	 * 获取两个日期间隔天数 
	 * @param   
	 * @return 
	 * @date 2016年8月11日 下午10:45:28  
	 * @throws
	 */
	public static long getDateIntervalNum(Date start,Date end){
		long m = start.getTime() - end.getTime();
		return m/(24*60*60*1000);
	}
	
	public static String formatDateStr(Date date){
		if(date == null){
			return "";
		}
		SimpleDateFormat myFmt=new SimpleDateFormat(DATE_FORMATE_SHORT);
		return myFmt.format(date);
	}
}
