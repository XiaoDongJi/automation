<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<div class="easyui-panel" style="padding:5px;height: 300px;">
	<select id="roleSelect" class="easyui-combobox" name="state" style="width:200px;">
		${option}
	</select>
</div>
	
<div style="padding:5px">
	<input type="hidden" id="hidUserId" value="${userId }">
    <a href="javascript:void(0)" class="easyui-linkbutton" id="treeSaveBtn">确认</a>
</div>
<script type="text/javascript">
	$(function(){
		console.log(1);
		$("#treeSaveBtn").click(function(){
			var userId = $("#hidUserId").val();
			if(userId){
				var roleId = $("#roleSelect").combobox("getValue");
				
				$.post("${basePath}/user/bindRole",{userId:userId,roleId:roleId},function(data){
					if(data.status == 200){
						layer.msg('保存成功', {icon: 6});
						CITI.closeCurrentWindow();
					}else{
						layer.msg(data.msg, {icon: 5});
					}
				});
			}
		});
	})
</script>
