package com.citichma.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 * 
 * 公共参数设置
 * @author JIXD 
 * @date 2016年7月16日 上午9:34:54  
 *
 */
public class ParamsInterceptor extends HandlerInterceptorAdapter {

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		String serverHost = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort();
		String basePath = serverHost + request.getContextPath();
		request.setAttribute("basePath", basePath);
		return super.preHandle(request, response, handler);
	}
}
