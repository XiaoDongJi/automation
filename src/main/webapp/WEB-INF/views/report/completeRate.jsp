<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>自动化生产管理系统-玩工率分析</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/easyui/easyui.css" media="all" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/easyui/icon.css" media="all" />
</head>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">首页</a></li>
		    <li><a href="#">统计报表</a></li>
		    <li><a href="#">完工率</a></li>
	    </ul>
    </div>
    <div class="rightinfo">
	    <table id="dg" title="完工率" style="width:100%;height:500px" 
	    	data-options="rownnumbers:true,
	    				url:'${basePath}/completeRate/getData',
	    				method:'get',
	    				singleSelect:true,
	    				striped:true"
		    			>
			<thead>
				<tr>
					<th data-options="field:'jdName',width:'10%'">节点</th>
					<th data-options="field:'yinganqi',width:'10%'">应按期完成项目</th>
					<th data-options="field:'anqi',width:'10%'">按期完成</th>
					<th data-options="field:'anqiRate',width:'10%'">按期完成率</th>
					<th data-options="field:'tuoqi',width:'10%'">拖期完成</th>
					<th data-options="field:'tuoqiRate',width:'10%'">拖期完成率</th>
					<th data-options="field:'unFinish',width:'10%'">到期未完成</th>
					<th data-options="field:'unReachDate',width:'10%'">未到期项</th>
					<th data-options="field:'total',width:'10%'">汇总</th>
				</tr>
			</thead>
		</table>
    </div>
	
 	<script type="text/javascript" src="${basePath }/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath }/resources/js/jquery.easyui.min.js"></script>
 	<script type="text/javascript" src="${basePath }/resources/js/layer/layer.js"></script>
 	<script type="text/javascript" src="${basePath }/resources/js/common/common.js"></script>
	<script type="text/javascript">
		$(function(){
			var dg = $('#dg').datagrid();
		})
	</script>
</body>
</html>