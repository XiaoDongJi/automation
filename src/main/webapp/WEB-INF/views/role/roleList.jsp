<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="auth" uri="http://www.citichmc.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>自动化生产管理系统-用户列表</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/style.css" media="all" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/easyui/easyui.css" media="all" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/easyui/icon.css" media="all" />
</head>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">系统菜单</a></li>
		    <li><a href="#">系统管理</a></li>
		    <li><a href="#">角色管理</a></li>
	    </ul>
    </div>
    <div class="rightinfo">
	    <table id="dg" title="员工列表" style="width:100%;height:500px" 
	    	data-options="rownnumbers:true,
	    				 url:'${basePath}/role/dataList',
		    			singleSelect:true,
		    			toolbar:'#tb',
		    			striped:true,
	    				pagination:true,
	    				rownumbers:10,
	    				pageNumber:1,
	    				pageSize:10
	    				">
			<thead>
				<tr>
					<th data-options="field:'roleName',width:'30%'">角色名称</th>
					<th data-options="field:'roleDesc',width:'30%'">角色描述</th>
					<th data-options="field:'createTime',width:'37%',
										formatter:function(value,row){
														if(value == null){
															return;
														}
														return new Date(value).format('yyyy-MM-dd');
													}">创建时间</th>
				</tr>
			</thead>
		</table>
    </div>
    
    <div id="tb" style="padding:2px 5px;">
    	<form id="search_form">
			角色名称：<input class="easyui-textbox" type="text" id="search_roleName" name="search_userNo" />
			<a href="javascript:;" id="searchBtn" class="easyui-linkbutton" iconCls="icon-search">查找</a>
    	</form>
	</div>
	
	<div id="dlg" class="easyui-dialog" title="用户信息" data-options="iconCls:'icon-save'" style="width:400px;height:200px;padding:10px;">
			<div style="padding:10px 60px 20px 60px">
	    	<input type="hidden" id="openType" />
		    <form id="ff" method="post">
	    		<input type="hidden" name="roleId" id="roleId"/>
		    	<table cellpadding="6">
		    		<tr>
		    			<td>角色名称：</td>
		    			<td><input class="easyui-textbox" type="text" id="roleName" name="roleName"></input></td>
		    		</tr>
		    		<tr>
		    			<td>角色描述：</td>
		    			<td><input class="easyui-textbox" type="text" id="roleDesc" name="roleDesc"></input></td>
		    		</tr>
		    	</table>
		    </form>
		    <div style="text-align:center;padding:5px">
		    	<a href="javascript:void(0);" id="saveBtn" class="easyui-linkbutton" >保存</a>
		    	<a href="javascript:void(0);" id="clearBtn" class="easyui-linkbutton" >清除</a>
		    </div>
		    </div>
		</div>
	
 	<script type="text/javascript" src="${basePath }/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath }/resources/js/jquery.easyui.min.js"></script>
 	<script type="text/javascript" src="${basePath }/resources/js/layer/layer.js"></script>
 	<script type="text/javascript" src="${basePath }/resources/js/common/common.js"></script>
	<script type="text/javascript">
		$(function(){
			//关闭对话框
			$('#dlg').dialog('close');
			
			var oper = {};
			oper.add = function(){
				$("#openType").val(1);
				$("#roleId").val("");
				$("#roleName").textbox('setValue',"");
				$("#roleDesc").textbox('setValue',"");
				$('#dlg').dialog('open');
			}
			
			oper.addAuth = function(){
				var row = $('#dg').datagrid('getSelected');
				if(!row){
					layer.msg('请选择一条记录', {icon: 0});
					return;
				}
				CITI.createWindow({
					url : "${basePath}/menu/cbTree?roleId="+row.roleId,
					title:"角色菜单"
				});    	
			}
			
			oper.edit = function(){
				var row = $('#dg').datagrid('getSelected');
				if (row){
					$("#openType").val(2);
					$("#roleId").val(row.roleId);
					$("#roleName").textbox('setValue',row.roleName);
					$("#roleDesc").textbox('setValue',row.roleDesc);
					$('#dlg').dialog('open');
				}else{
					layer.msg('请选择一条记录', {icon: 0});
				}
			}
			oper.del = function(){
				var row = $('#dg').datagrid('getSelected');
				if (row){
					layer.confirm('你确定要删除这个记录？', {
						  btn: ['确认','取消'] //按钮
						}, function(){
							$.post('${basePath}/role/del',{id:row.roleId},function(data){
								if(data.status == 200){
									layer.msg('删除成功', {icon: 1});
									$('#dg').datagrid('reload');
								}else{
									layer.msg(data.msg, {icon: 5});
								}
							},'json');
						});
				}else{
					layer.msg('请选择一条记录', {icon: 0});
				}
			}
			
			//在分页栏放操作工具
			var pager = $('#dg').datagrid().datagrid('getPager');
			pager.pagination({
				beforePageText: '第',//页数文本框前显示的汉字 
		        afterPageText: '页    共 {pages} 页', 
		        displayMsg: '当前显示 {from} - {to} 条记录   共 {total} 条记录', 
				buttons:[{
					text:'添加角色',
					iconCls:'icon-add',
					handler:function(){
						oper.add();
					}
				},{
					text:'添加权限',
					iconCls:'icon-man',
					handler:function(){
						oper.addAuth();
					}
				},{
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
				}]
				
			});			
			//保存
			$("#saveBtn").click(function(){
				var openType = $("#openType").val();
				if(openType == 1){
					$.post('${basePath}/role/add',$("#ff").serialize(),function(data){
						//console.log(data);
						if(data.status == 200){
							$('#dlg').dialog('close');
							$('#dg').datagrid('reload');
							layer.msg("保存成功", {icon: 1});
						}else{
							layer.alert(data.msg, {icon: 5});
						}
					},'json');
				}else{
					$.post('${basePath}/role/update',$("#ff").serialize(),function(data){
						//console.log(data);
						if(data.status == 200){
							$('#dlg').dialog('close');
							$('#dg').datagrid('reload');
							layer.msg("修改成功", {icon: 1});
						}else{
							layer.alert(data.msg, {icon: 5});
						}
					},'json');
				}
				
			});
			
			//查询
			$("#searchBtn").click(function(){
				$('#dg').datagrid("options").queryParams={
					roleName:$("#search_roleName").val()
				};
				$('#dg').datagrid('reload');
			});
		});
	</script>
</body>
</html>