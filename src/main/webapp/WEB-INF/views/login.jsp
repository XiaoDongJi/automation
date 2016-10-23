<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
	<title>欢迎登录自动化生产管理系统</title>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
	<link rel="shortcut icon" href="${basePath }/resources/images/favicon.ico"/>
	<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/style.css" media="all" />
	<script type="text/javascript">
		if (window != top)  
        top.location.href = location.href;
	</script>
</head>
<body style="background-color: #1c77ac; background-image: url(${basePath }/resources/images/light.png); background-repeat: no-repeat; background-position: center top; overflow: hidden;">
	<div id="mainBody">
		<div id="cloud1" class="cloud"></div>
		<div id="cloud2" class="cloud"></div>
	</div>
	<div class="logintop">
		<span>欢迎登录后台管理界面平台</span>
		<ul>
			<li><a href="#">帮助</a></li>
			<li><a href="#">关于</a></li>
		</ul>
	</div>

	<div class="loginbody">
		<span class="systemlogo"></span>
		<div class="loginbox">
			<ul>
				<li><input name="userNo" id="userNo" placeholder="请输入用户名" type="text" class="loginuser"  /></li>
				<li><input name="userPassword" id="userPassword" placeholder="请输入密码" type="password" class="loginpwd" /></li>
				<li>
					<input type="button" class="loginbtn" id="loginbtn" value="登录"/>
					<label><input name="" type="checkbox" value="" checked="checked" />记住密码</label><label><a href="#">忘记密码？</a></label>
				</li>
			</ul>
		</div>
	</div>

	<div class="loginbm">
		版权所有 2013 <a target="_blank" href="http://www.citichma.com/(S(04jpkd45gtxrip55fgau3355))/web/Index.aspx">中重自动化</a>
	</div>
	<script type="text/javascript" src="${basePath }/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath }/resources/js/cloud.js"></script>
	<script type="text/javascript" src="${basePath }/resources/js/layer/layer.js"></script>
	<script type="text/javascript">
		$(function() {
			$('.loginbox').css({
				'position' : 'absolute',
				'left' : ($(window).width() - 692) / 2
			});
			$(window).resize(function() {
				$('.loginbox').css({
					'position' : 'absolute',
					'left' : ($(window).width() - 692) / 2
				});
			})
			
			
			$("#loginbtn").click(function(){
				var userNo = $("#userNo").val();
				var pass= $("#userPassword").val();
				if(userNo == ""){
					return;
				}
				if(pass == ""){
					return;
				}
				$.getJSON("${basePath}/loginCheck",{userNo:userNo,userPassword:pass},function(data){
					if(data.status == 200){
						layer.msg('登陆成功', {icon: 6});
						window.location.href = "${basePath}/menu/main";
					}else{
						layer.msg(data.msg, {icon: 5});
					}
				});
				
			});
		});
	</script>
</body>
</html>