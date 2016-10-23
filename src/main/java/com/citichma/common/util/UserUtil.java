package com.citichma.common.util;

import javax.servlet.http.HttpServletRequest;

import org.joda.time.DateTime;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.citichma.common.vo.UserInfoVo;

public class UserUtil {
	
	/**
	 * 
	 * 获取当前用户 
	 * @param   
	 * @return 
	 * @date 2016年8月9日 下午10:04:40  
	 * @throws
	 */
	public static UserInfoVo getCurrentUser(){
		HttpServletRequest request = ((ServletRequestAttributes)RequestContextHolder.getRequestAttributes()).getRequest();
		return (UserInfoVo) request.getSession().getAttribute("userVo");
	}
	
	
}
