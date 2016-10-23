<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>自动化生产管理系统-用户列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/style.css" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/easyui/easyui.css" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/easyui/icon.css" />
<style type="text/css">
	.tb_title{
		font-size: 15px;
		font-weight: bold;
	}
	
	.tb_basic td{
		padding: 5px;
		text-align: right;
	}
	.tb_date td,th{
		text-align: center;
		padding: 2px;
	}
	.tb_last td{
		text-align: center;
		padding: 5px;
		width: 10%;
	}
	.easyui-combobox{
		width: 145px;
	}
</style>
</head>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">首页</a></li>
		    <li><a href="#">数据表</a></li>
		    <li><a href="#">计划列表</a></li>
	    </ul>
    </div>
    <div class="rightinfo">
	    <table id="dg" title="计划列表" style="width:100%;height:500px" 
	    	data-options="rownnumbers:true,
	    					singleSelect:true,
	    					toolbar:'#tb',
	    					striped:true,
	    					remoteSort:false,
	    					collapsible:true,
							multiSort:true,
							url:'${basePath}/plan/dataList',
							pagination:true,
							rownumbers:10,
							pageNumber:1,
							onDblClickRow:dbclickRow
							pageSize:10">
			<thead>
				<tr>
					<th data-options="field:'workSn',align:'center',width:'9%'">工作令号</th>
					<th data-options="field:'productName',align:'center',width:'13%'">项目名称</th>
					<th data-options="field:'productNum',align:'center',width:'3%'">数量</th>
					<th data-options="field:'chartSn',align:'center',width:'5%'">产品图号</th>
					<th data-options="field:'orderUser',align:'center',width:'6%'">用户</th>
					<th data-options="field:'orderDate',align:'center',width:'5%',formatter:function(value,row){
														if(value == null){
															return;
														}
														return new Date(value).format('yyyy-MM-dd');
													}">下令日期</th>
					<th data-options="field:'adjustDeliverDate',width:'8%',
											formatter:function(value,row){
														if(value == null){
															return;
														}
														return new Date(value).format('yyyy-MM-dd');
													},align:'center',sortable:true,">调整交货期</th>
					<th data-options="field:'rkDate',align:'center',width:'5%',
										formatter:function(value,row){
														if(value == null){
															return;
														}
														return new Date(value).format('yyyy-MM-dd');
													}">入库时间</th>
					<th data-options="field:'countdown',align:'center',width:'3%'" >倒计时</th>
					<th data-options="field:'cupboardNum',align:'center',width:'3%'">柜数</th>
					<th data-options="field:'boxNum',align:'center',width:'3%'" >箱数</th>
					<th data-options="field:'projectStatus',align:'center',width:'3%',
												formatter:function(value,row){
														return showStatus(value);
													}">状态</th>
					<th data-options="field:'projectLeader',align:'center',width:'3%'">项目人</th>
					<th data-options="field:'remark',align:'center',width:'30%'" >备注</th>
				</tr>
			</thead>
		</table>
    </div>
    
    <div id="tb" style="padding:2px 5px;">
    	<form id="search_form">
			工作令号：<input class="easyui-textbox" type="text" id="search_workSn" name="search_workSn" />&nbsp;
			项目名称：<input class="easyui-textbox" type="text" id="search_productName" name="search_productName" />&nbsp;
			产品图号：<input class="easyui-textbox" type="text" id="search_chartSn" name="search_chartSn" />&nbsp;
			项目名人：<input class="easyui-textbox" type="text" id="search_projectLeader" name="search_projectLeader" />&nbsp;
			交货期时间：<input class="easyui-datebox" type="text" id="search_startDate" name="search_startDate" />
			- <input class="easyui-datebox" type="text" id="search_endDate" name="search_endDate" />&nbsp;
			状态：<select class="easyui-combobox" id="search_projectStatus" data-options="multiple:true,multiline:true" name="search_projectStatus" 
									style="width: 300px;height: 40px;">
								<option value="">--</option>
	    						<option value="1">撤销</option>
	    						<option value="2">待包装</option>
	    						<option value="3">在包装</option>
	    						<option value="4">待采购</option>
	    						<option value="5">在采购</option>
	    						<option value="6">待装配</option>
	    						<option value="7">在装配</option>
	    						<option value="8">在制缺件</option>
	    						<option value="9">暂停</option>
	    						<option value="10">在制收尾</option>
	    						<option value="11">在检验</option>
	    						<option value="12">在调试</option>
	    						<option value="13">待入库</option>
	    						<option value="14">已入库</option>
	    						<option value="15">待安装</option>
	    					</select>
			<a href="javascript:;" id="searchBtn" class="easyui-linkbutton" iconCls="icon-search">查找</a>
    	</form>
	</div>
	
 	<script type="text/javascript" src="${basePath }/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath }/resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${basePath }/resources/js/easyui-lang-zh_CN.js"></script>
 	<script type="text/javascript" src="${basePath }/resources/js/layer/layer.js"></script>
 	<script type="text/javascript" src="${basePath }/resources/js/common/common.js"></script>
 	<script type="text/javascript" src="${basePath }/resources/js/jquery.ajaxfileupload.js?01"></script>
	<script type="text/javascript">
		$(function(){
			var oper = {};
			oper.edit = function(){
				var row = $('#dg').datagrid('getSelected');
				if(!row){
					layer.msg('请选择一条记录', {icon: 0});
					return;
				}
				CITI.createWindow({
					url : "${basePath}/plan/edit?planId="+row.id,
					title:"计划修改",
					height:800
				});    	
			}
			oper.del = function(){
				var row = $('#dg').datagrid('getSelected');
				if (row){
				}else{
					layer.msg('请选择一条记录', {icon: 0});
				}
			}
			oper.exp = function(){
				window.location.href = "${basePath}/plan/export";
			}
			//在分页栏放操作工具
			var pager = $('#dg').datagrid().datagrid('getPager');
			pager.pagination({
				beforePageText: '第',//页数文本框前显示的汉字 
		        afterPageText: '页    共 {pages} 页', 
		        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
				buttons:[{
					text:'修改',
					iconCls:'icon-edit',
					handler:function(){
						oper.edit();
					}
				},{
					text:'删除',					
					iconCls:'icon-remove',
					handler:function(){
						oper.del();
					}
				},{
					text:'导出',					
					iconCls:'icon-redo',
					handler:function(){
						oper.exp();
					}
				}]
				
			});			
			
			//查询
			$("#searchBtn").click(function(){
				var statusList = [];
				var objs = $("input[name='search_projectStatus']");
				for(var i = 1;i<objs.length;i++){
					//if($(objs[i]).val() != "")continue;
					statusList.push(parseInt($(objs[i]).val()));
				}
				$('#dg').datagrid("options").queryParams={
					workSn:$("#search_workSn").val(),
					productName:$("#search_productName").val(),
					startadjustDeliverDate:$("#search_startDate").datebox('getValue'),
					endadjustDeliverDate:$("#search_endDate").datebox('getValue'),
					projectStatusList:JSON.stringify(statusList),
					projectLeader:$("#search_projectLeader").val(),
					chartSn:$("#search_chartSn").val()
				};
				$('#dg').datagrid('reload');
			});
		});
		
		function showStatus(status){
				var name = "";
				switch(status){
					case 1:name="撤销";break;
					case 2:name="待包装";break;
					case 3:name="在包装";break;
					case 4:name="待采购";break;
					case 5:name="在采购";break;
					case 6:name="待装配";break;
					case 7:name="在装配";break;
					case 8:name="在制缺件";break;
					case 9:name="暂停";break;
					case 10:name="在制收尾";break;
					case 11:name="在检验";break;
					case 12:name="在调试";break;
					case 13:name="待入库";break;
					case 14:name="已入库";break;
					case 15:name="待安装";break;
					case 16:name="其他";break;
				}
				return name;
			}
		function dbclickRow(row){
			CITI.createWindow({
				url : "${basePath}/plan/edit?planId="+row.id,
				title:"计划查看",
				height:800
			});
		}
	</script>
</body>
</html>