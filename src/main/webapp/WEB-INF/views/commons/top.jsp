<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>高端电液基地生产管理系统</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/style.css" media="all" />
</head>
<body style="background:url(${basePath }/resources/images/topbg.gif) repeat-x;">
	<div class="topleft">
    	<a href="javascript:;" target="_parent"><img src="${basePath }/resources/images/logo.png" title="系统首页" /></a>
    </div>
    <ul class="nav">
	    <li><a href="${basePath }/menu/main" target="rightFrame" class="selected"><img src="${basePath }/resources/images/icon01.png" title="工作台" /><h2>工作台</h2></a></li>
    </ul>
    <div class="topright">    
	    <ul>
		    <li><span><img src="${basePath }/resources/images/help.png" title="帮助"  class="helpimg"/></span><a href="javascript:;">帮助</a></li>
		    <li><a href="javascript:;">关于</a></li>
		    <li><a href="${basePath }/loginOut" target="_parent">退出</a></li>
	    </ul>
	    <div class="user">
		    <span>${userVo.userName}</span>
	    </div>    
    </div>
	<script type="text/javascript" src="${basePath }/resources/js/jquery.min.js"></script>
	<script type="text/javascript">
	$(function(){	
		//顶部导航切换
		$(".nav li a").click(function(){
			$(".nav li a.selected").removeClass("selected")
			$(this).addClass("selected");
		})	
	})	
</script>
</body>
</html>
