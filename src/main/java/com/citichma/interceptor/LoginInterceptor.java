package com.citichma.interceptor;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.citichma.common.exception.AuthorizationException;
import com.citichma.common.util.Check;
import com.citichma.common.vo.UserInfoVo;
/**
 * 
 * 登陆拦截器
 * @author JIXD 
 * @date 2016年7月16日 下午1:17:57  
 *
 */
public class LoginInterceptor extends HandlerInterceptorAdapter{

	private List<String> excludedUrls;

    public void setExcludedUrls(List<String> excludedUrls) {
        this.excludedUrls = excludedUrls;
    }
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
		
		UserInfoVo userInfo = (UserInfoVo) request.getSession().getAttribute("userVo");
		String requestUri = request.getRequestURI();
		for (String url : excludedUrls) {
            if (requestUri.endsWith(url)) {
                return true;
            }
        }
		if(Check.NuNObj(userInfo)){
			 response.sendRedirect(request.getContextPath()+"/login");
		}
		return true;
	}
}
