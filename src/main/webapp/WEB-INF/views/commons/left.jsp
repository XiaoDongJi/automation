<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>高端电液基地生产管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/style.css" />
</head>
<body style="background:#f0f9fd;">
	<div class="lefttop"><span></span>系统菜单</div>
    <dl class="leftmenu">
	    <c:forEach var="menu" items="${menuList}">
	    	<dd>
			    <div class="title">
			    	<span><img src="${basePath}/resources/images/leftico01.png" /></span>${menu.name}
			    </div>
		    	<ul class="menuson">
		    		<c:forEach var="child" items="${menu.children }">
				        <li><cite></cite><a href="${basePath }${child.menuUrl}" target="rightFrame">${child.menuName }</a><i></i></li>
		    		</c:forEach>
		        </ul>    
		    </dd>
	    </c:forEach>
    </dl>
	<script type="text/javascript" src="${basePath }/resources/js/jquery.min.js"></script>
	<script type="text/javascript">
	$(function(){	
		//导航切换
		$(".menuson li").click(function(){
			$(".menuson li.active").removeClass("active")
			$(this).addClass("active");
		});
		
		$('.title').click(function(){
			var $ul = $(this).next('ul');
			$('dd').find('ul').slideUp();
			if($ul.is(':visible')){
				$(this).next('ul').slideUp();
			}else{
				$(this).next('ul').slideDown();
			}
		});
	})	
</script>
</body>
</html>