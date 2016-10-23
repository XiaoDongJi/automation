<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<div class="easyui-panel" style="padding:5px;height: 300px;">
	<ul id="menuTree" class="easyui-tree" data-options="url:'${basePath }/menu/treeCbList?roleId=${roleId}',
														method:'get',animate:true,checkbox:true,cascadeCheck:false">
	</ul>
</div>
	
<div style="padding:5px">
	<input id="roleId" type="hidden" value="${roleId}"/>
    <a href="javascript:void(0)" class="easyui-linkbutton" id="treeSaveBtn">提交</a>
    <a href="javascript:void(0)" class="easyui-linkbutton" id="treeRsetBtn">重置</a>
</div>
<script type="text/javascript">
 $(function(){
	 //保存菜单树之间关系
	$("#treeSaveBtn").click(function(){
		var nodes = $('#menuTree').tree('getChecked');
		//console.log(nodes);
		var ids = [];
		for(var i = 0; i<nodes.length; i++){
			ids.push(nodes[i].id);
		}
		if(ids.length == 0){
			return;
		}
		ids = ids.join(",");
		//console.log(ids);
		$.post("${basePath}/role/bindMenu",{ids:ids,roleId:'${roleId}'},function(data){
			if(data.status == 200){
				layer.msg("保存成功", {icon: 6});
				CITI.closeCurrentWindow();
			}else{
				layer.msg(data.msg, {icon: 5});
			}
		},'json');
	});
	//重置树
	$("#treeRsetBtn").click(function(){
		$("#menuTree").tree('reload');
	});
});
</script>
