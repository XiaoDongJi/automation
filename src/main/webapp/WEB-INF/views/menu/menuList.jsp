<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>高端电液基地生产管理系统-用户列表</title>
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
		    <li><a href="#">数据表</a></li>
		    <li><a href="#">菜单列表</a></li>
	    </ul>
    </div>
   	<div class="rightinfo">
		
		<table id="tg" class="easyui-treegrid" title="菜单列表" style="width:100%;height:500px"
				data-options="
					rownumbers: true,
					animate: true,
					collapsible: true,
					fitColumns: true,
					url: '${basePath }/menu/treeList',
					method: 'get',
					idField: 'id',
					treeField: 'name',
					showFooter: true,
					onContextMenu: onContextMenu,
					onClickRow:clickRow,
					onDblClickRow:dbclickRow,
					onBeforeEdit:beforEditRow,
					onAfterEdit:afterEdit
				">
			<thead>
				<tr>
					<th data-options="field:'name',width:180,editor:'text'">菜单树</th>
					<th data-options="field:'menuType',width:60,editor:'numberbox'">菜单类型</th>
					<th data-options="field:'menuOrder',width:80,editor:'numberbox'">菜单顺序</th>
					<th data-options="field:'menuUrl',width:80,editor:'text'">菜单路径</th>
				</tr>
			</thead>
		</table>
		
		<div id="mm" class="easyui-menu" style="width:120px;">
			<div onclick="append()" data-options="iconCls:'icon-add'">添加</div>
			<div onclick="removeIt()" data-options="iconCls:'icon-remove'">删除</div>
			<div class="menu-sep"></div>
			<div onclick="collapse()">折叠</div>
			<div onclick="expand()">展开</div>
		</div>
   	</div>
	
 	<script type="text/javascript" src="${basePath }/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath }/resources/js/jquery.easyui.min.js"></script>
 	<script type="text/javascript" src="${basePath }/resources/js/layer/layer.js"></script>
	<script type="text/javascript">
	//显示右键菜单
	function onContextMenu(e,row){
		if (row){
			e.preventDefault();
			$(this).treegrid('select', row.id);
			$('#mm').menu('show',{
				left: e.pageX,
				top: e.pageY
			});				
		}
	}
	var lastIndex;
	//双击编辑
	function dbclickRow(row){
		var rowIndex = row.id;
		if (lastIndex != rowIndex){
			$('#tg').treegrid('endEdit', lastIndex);
			$('#tg').treegrid('beginEdit', rowIndex); 
			lastIndex = rowIndex;  
		} 
	}
	//单击关闭
	function clickRow(row){
		var rowIndex = row.id;
		if(lastIndex != rowIndex){
			 $('#tg').treegrid('endEdit', lastIndex);
		}
	}
	//编辑之前
	function beforEditRow(row){
		
	}
	
	//编辑后请求
	function afterEdit(row,change){
		$.post('${basePath}/menu/update',row,function(data){
			console.log(data);
		},'json');
	}
	//添加菜单项
	function append(item){
		var node = $('#tg').treegrid('getSelected');
		var newNode = {
			parentId:node.id,
			menuName: '菜单名称',
			menuType: 1,
			menuOrder: 1,
			isParent:0,
			menuUrl: '/menu'
		};
		$.post("${basePath}/menu/create",newNode,function(data){
			if(data.status == 200){
				console.log(data);
				$('#tg').treegrid('append',{
					parent: node.id,
					data: [{
						id:data.data.id,
						name: '菜单名称',
						menuType: 1,
						menuOrder: 1,
						menuUrl: '/menu/other'
					}]
				})
			}else{
				layer.msg(data.msg, {icon: 5});
			}
		},'json');
		
		
	}
	//删除菜单
	function removeIt(){
		var node = $('#tg').treegrid('getSelected');
		if (node){
			$.post("${basePath}/menu/remove",{id:node.id,parentId:node._parentId},function(data){
				if(data.status == 200){
					$('#tg').treegrid('remove', node.id);
				}else{
					layer.msg(data.msg, {icon: 5});
				}
			},'json');
		}
	}
	//收起菜单
	function collapse(){
		var node = $('#tg').treegrid('getSelected');
		if (node){
			$('#tg').treegrid('collapse', node.id);
		}
	}
	//展开菜单
	function expand(){
		var node = $('#tg').treegrid('getSelected');
		if (node){
			$('#tg').treegrid('expand', node.id);
		}
	}
</script>
</body>
</html>