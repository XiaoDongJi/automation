package com.citichma.common.tag;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.jsp.JspException;
import javax.servlet.jsp.tagext.TagSupport;

import com.citichma.common.vo.UserInfoVo;
import com.citichma.pojo.TMenuInfo;
/**
 * 
 * 权限标签
 * @author JIXD 
 * @date 2016年8月4日 下午8:59:24  
 *
 */
public class PermissionTag extends TagSupport {
	
	/**
	 * 序列id
	 */
	private static final long serialVersionUID = 4270060488558340015L;
	/**
	 * 权限url
	 */
	private String privilege;
	

	public String getPrivilege() {
		return privilege;
	}

	public void setPrivilege(String privilege) {
		this.privilege = privilege;
	}

	
	@Override
	public int doStartTag() throws JspException {
		boolean result = true;
		
		HttpServletRequest request = (HttpServletRequest) this.pageContext.getRequest();
		 
		UserInfoVo userInfoVo = (UserInfoVo) request.getSession().getAttribute("userVo");
		 
		List<TMenuInfo> menuList = userInfoVo.getMenuList();
		
		for(TMenuInfo menu : menuList){
			if(menu.getMenuUrl().equals(privilege)){
				result = false;
				break;
			}
		}
		return result?EVAL_BODY_INCLUDE:SKIP_BODY;
	}

}
