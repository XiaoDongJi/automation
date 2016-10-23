<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="auth" uri="http://www.citichmc.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
<head>
<title>自动化生产管理系统-新增生产计划</title>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/style.css" />
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/easyui/easyui.css"/>
<link rel="stylesheet" type="text/css" href="${basePath }/resources/css/easyui/icon.css" />
<style type="text/css">
	.tb_title{
		font-size: 15px;
		font-weight: bold;
	}
	.tb_date td,th{
		text-align: center;
		padding: 5px;
	}
	.tb_basic td{
		padding: 5px;
		text-align: right;
	}
	.easyui-combobox{
		width: 145px;
	}
	.tb_last td{
		text-align: center;
		padding: 5px;
		width: 10%;
	}
</style>
</head>
<body>
	<div class="place">
	    <span>位置：</span>
	    <ul class="placeul">
		    <li><a href="#">系统菜单</a></li>
		    <li><a href="#">生产计划</a></li>
		    <li><a href="#">新增计划</a></li>
	    </ul>
    </div>
    <div class="rightinfo">
    <div class="easyui-panel" title="新增计划" style="width:100%">
	    <form id="ff" class="easyui-form"  method="post" data-options="novalidate:true">
	    	<input type="hidden" id="planId" name="id" />
	    	<div style="margin-left: 10px;margin-top: 20px;">
		    	<table class="tb_basic" style="width: 95%;">
		    		<caption class="tb_title">
		    			基本信息
		    		</caption>
		    		<tr>
		    			<td>工作令号:</td>
		    			<td><input class="easyui-textbox" type="text" name="workSn" data-options="required:true"></input></td>
		    			
		    			<td>合同号:</td>
		    			<td><input class="easyui-textbox" type="text" name="contractSn"></input></td>
		    			
		    			<td>产品图号:</td>
		    			<td><input class="easyui-textbox" type="text" name="chartSn"></input></td>
		    			
		    			<td>产品名称及规格:</td>
		    			<td><input class="easyui-textbox" type="text" name="productName"></input></td>
		    		</tr>
		    		<tr>
		    			<td>数量:</td>
		    			<td><input class="easyui-textbox" type="text" name="productNum"></input></td>
		    			<td>合同交货期:</td>
		    			<td><input class="easyui-datebox" type="text" name="deliveryDate"></input></td>
		    			
		    			<td>产品种类:</td>
		    			<td>
	    					<select class="easyui-combobox" name="productType">
	    						<option value="1">电控</option>
	    						<option value="3">机器人</option>
	    						<option value="4">磨机</option>
	    						<option value="5">立磨</option>
	    						<option value="6">辊压机</option>
	    						<option value="7">破碎机</option>
	    						<option value="8">窑</option>
	    						<option value="9">提升机</option>
	    						<option value="10">余热发电</option>
	    						<option value="11">配电</option>
	    						<option value="12">变频器</option>
	    						<option value="13">矫直机</option>
	    						<option value="14">闸控</option>
	    						<option value="15">恒减速</option>
	    						<option value="16">直发件</option>
	    						<option value="17">转口件</option>
	    						<option value="18">DCS</option>
	    						<option value="19">汽车变流器</option>
	    						<option value="20">其他</option>
	    					</select>
		    			</td>
		    			
		    			<td>订货单位:</td>
		    			<td>
		    				<select class="easyui-combobox" name="orderCompany">
		    					<option value="1">自动化</option>
		    					<option value="2">矿研院</option>
		    					<option value="3">销售公司</option>
		    					<option value="4">国际业务部</option>
		    					<option value="5">变频销售</option>
		    					<option value="6">机器人销售</option>
		    					<option value="7">其他</option>
		    				</select>
		    			</td>
		    			
		    			
		    		</tr>
		    		<tr>
		    			<td>用户:</td>
		    			<td><input class="easyui-textbox" type="text" name="orderUser"></input></td>
		    			
		    			<td>设计:</td>
		    			<td><input class="easyui-textbox" type="text" name="designer"></input></td>
		    			
		    			<td>设计部门:</td>
		    			<td>
		    				<select class="easyui-combobox" name="designCompany">
		    					<option value="1">自动化</option>
		    					<option value="2">工程公司</option>
		    					<option value="3">其他</option>
		    				</select>
		    			</td>
		    			
		    			<td>编制:</td>
		    			<td>
		    				<select class="easyui-combobox" name="organizer">
		    					<option value="杨攀攀">杨攀攀</option>
		    				</select>
		    			</td>
		    		</tr>
		    		<tr>
		    			<td>批准:</td>
		    			<td>
		    				<select class="easyui-combobox" name="approver">
		    					<option value="李建明">李建明</option>
		    				</select>
		    			</td>
		    			
		    			<td>下令日期:</td>
		    			<td><input class="easyui-datebox" type="text" name="orderDate"></input></td>
		    			
		    			<td>类别:</td>
		    			<td>
		    				<select class="easyui-combobox" name="orderType">
	    						<option value="1">纵向</option>
	    						<option value="2">自揽</option>
	    						<option value="3">技改</option>
	    						<option value="4">科研</option>
	    						<option value="5">三包</option>
	    						<option value="6">返修</option>
	    						<option value="7">备件</option>
	    						<option value="8">其他</option>
	    					</select>
		    			</td>
		    			
		    			<td>调整交货期:</td>
		    			<td><input class="easyui-datebox" type="text" name="adjustDeliverDate"></input></td>
		    			
		    		</tr>
		    		<tr>
		    			<td>试车节点:</td>
		    			<td><input class="easyui-datebox" type="text" name="trycarDate"></input></td>
		    			
		    			<td>重要程度:</td>
		    			<td>
		    				<select class="easyui-combobox" name="importanceDegree">
	    						<option value="1">A</option>
	    						<option value="2">B</option>
	    						<option value="3">C</option>
	    					</select>
		    			</td>
		    			
		    			<td>柜数:</td>
		    			<td><input class="easyui-numberbox" maxlength="3" type="text" name="cupboardNum" value="0" data-options="min:0,max:1000,precision:0"></input></td></td>
		    			
		    			<td>箱数:</td>
		    			<td><input class="easyui-numberbox" maxlength="3" type="text" name="boxNum" value="0" data-options="min:0,max:1000,precision:0"></input></td></td>
		    			
		    		</tr>
		    		<tr>
		    			<td>项目人:</td>
		    			<td><input class="easyui-textbox" type="text" name="projectLeader"></input></td>
		    			<td>状态:</td>
		    			<td>
		    				<select class="easyui-combobox" name="projectStatus" style="width: 145px;">
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
		    			</td>
		    		</tr>
		    	</table>
		    	
		    	<table class="tb_date" style="width: 93%;margin-top: 40px;">
		    		<caption class="tb_title">
		    			时间节点
		    		</caption>
		    		<thead>
		    			<tr>
		    				<th style="width: 13%;">生产节点</th>
		    				<th style="width: 13%;">应完成日期</th>
		    				<th style="width: 13%;">周期</th>
		    				<th style="width: 13%;">完成日期</th>
		    				<th style="width: 13%;">节点负责人</th>
		    				<th style="width: 35%;">备注</th>
		    			</tr>
		    		</thead>
		    		<tbody>
		    			<tr>
		    				<td>采购元件节点</td>
		    				<td><input type="hidden" id="cgyjId" name="cgyj.id" /><input type="hidden" name="cgyj.nodeType" value="1" /><input class="easyui-datebox" type="text" name="cgyj.planFinishTime"></input></td>
		    				<td><input class="easyui-numberbox" maxlength="3" type="text" name="cgyj.planDayNum" data-options="min:0,max:1000,precision:0"></input></td>
		    				<td><input class="easyui-datebox" type="text" name="cgyj.actualFinishTime"></input></td>
		    				<td><input class="easyui-textbox" type="text" name="cgyj.nodeLeader"></input></td>
		    				<td><input class="easyui-textbox" name="cgyj.remark" data-options="multiline:true" style="height:50px;width: 100%;"></input></td>
		    			</tr>
		    			<tr>
		    				<td>采购柜体节点</td>
		    				<td><input type="hidden" id="cggtId" name="cggt.id" /><input type="hidden" name="cggt.nodeType" value="2" /><input class="easyui-datebox" type="text" name="cggt.planFinishTime"></input></td>
		    				<td><input class="easyui-numberbox" maxlength="3" type="text" name="cggt.planDayNum" data-options="min:0,max:1000,precision:0"></input></td>
		    				<td><input class="easyui-datebox" type="text" name="cggt.actualFinishTime"></input></td>
		    				<td><input class="easyui-textbox" type="text" name="cggt.nodeLeader"></input></td>
		    				<td><input class="easyui-textbox" name="cggt.remark" data-options="multiline:true" style="height:50px;width: 100%;"></input></td>
		    			</tr>
		    			<tr>
		    				<td>元件发放</td>
		    				<td><input type="hidden" id="yjffId" name="yjff.id" /><input type="hidden" name="yjff.nodeType" value="3" /><input class="easyui-datebox" type="text" name="yjff.planFinishTime"></input></td>
		    				<td><input class="easyui-numberbox" maxlength="3" type="text" name="yjff.planDayNum" data-options="min:0,max:1000,precision:0"></input></td>
		    				<td><input class="easyui-datebox" type="text" name="yjff.actualFinishTime"></input></td>
		    				<td><input class="easyui-textbox" type="text" name="yjff.nodeLeader"></input></td>
		    				<td><input class="easyui-textbox" name="yjff.remark" data-options="multiline:true" style="height:50px;width: 100%;"></input></td>
		    			</tr>
		    			<tr>
		    				<td>装配节点</td>
		    				<td><input type="hidden" id="zpId" name="zp.id" /><input type="hidden" name="zp.nodeType" value="4" /><input class="easyui-datebox" type="text" name="zp.planFinishTime"></input></td>
		    				<td><input class="easyui-numberbox" maxlength="3" type="text" name="zp.planDayNum"  data-options="min:0,max:1000,precision:0"></input></td>
		    				<td><input class="easyui-datebox" type="text" name="zp.actualFinishTime"></input></td>
		    				<td><input class="easyui-textbox" type="text" name="zp.nodeLeader"></input></td>
		    				<td><input class="easyui-textbox" name="zp.remark" data-options="multiline:true" style="height:50px;width: 100%;"></input></td>
		    			</tr>
		    			<tr>
		    				<td>检验节点</td>
		    				<td><input type="hidden" id="jyId" name="jy.id" /><input type="hidden" name="jy.nodeType" value="5" /><input class="easyui-datebox" type="text" name="jy.planFinishTime"></input></td>
		    				<td><input class="easyui-numberbox" maxlength="3" type="text" name="jy.planDayNum"  data-options="min:0,max:1000,precision:0"></input></td>
		    				<td><input class="easyui-datebox" type="text" name="jy.actualFinishTime"></input></td>
		    				<td><input class="easyui-textbox" type="text" name="jy.nodeLeader"></input></td>
		    				<td><input class="easyui-textbox" name="jy.remark" data-options="multiline:true" style="height:50px;width: 100%;"></input></td>
		    			</tr>
		    			<tr>
		    				<td>调试节点</td>
		    				<td><input type="hidden" id="tsId" name="ts.id" /><input type="hidden" name="ts.nodeType" value="6" /><input class="easyui-datebox" type="text" name="ts.planFinishTime"></input></td>
		    				<td><input class="easyui-numberbox" maxlength="3" type="text" name="ts.planDayNum"  data-options="min:0,max:1000,precision:0"></input></td>
		    				<td><input class="easyui-datebox" type="text" name="ts.actualFinishTime"></input></td>
		    				<td><input class="easyui-textbox" type="text" name="ts.nodeLeader"></input></td>
		    				<td><input class="easyui-textbox" name="ts.remark" data-options="multiline:true" style="height:50px;width: 100%;"></input></td>
		    			</tr>
		    			<tr>
		    				<td>包装入库节点</td>
		    				<td><input type="hidden" id="rkId" name="rk.id" /><input type="hidden" name="rk.nodeType" value="7" /><input class="easyui-datebox" type="text" name="rk.planFinishTime"></input></td>
		    				<td><input class="easyui-numberbox" maxlength="3" type="text" name="rk.planDayNum" data-options="min:0,max:1000,precision:0"></input></td>
		    				<td><input class="easyui-datebox" type="text" name="rk.actualFinishTime"></input></td>
		    				<td><input class="easyui-textbox" type="text" name="rk.nodeLeader"></input></td>
		    				<td><input class="easyui-textbox" name="rk.remark" data-options="multiline:true" style="height:50px;width: 100%;"></input></td>
		    			</tr>
		    			
		    			<tr>
		    				<td colspan="6">
		    				<div style="width: 100%;border: 1px solid gray;"></div>
		    				</td>
		    			</tr>
		    		</tbody>
		    	</table>
		    	
		    	<table class="tb_last" style="width: 93%;margin-top: 40px;">
	    			<tr>
	    				<td>出库时间</td>
	    				<td><input class="easyui-datebox" type="text" name="outDate"></input></td>
	    				<td>直发件数量</td>
	    				<td><input type="text" class="easyui-numberbox" name="zfjNum"/></td>
	    				
	    				<td>直发件已完成数量</td>
	    				<td><input type="text" class="easyui-numberbox" name="zfjFinishNum"/></td>
	    				
	    				<td>直发件最终完成日期</td>
	    				<td><input class="easyui-datebox" type="text" name="zfjFinishDate"></input></td>
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td>发货报告</td>
	    				<td colspan="2"><input class="easyui-textbox" name="deliveryReport" data-options="multiline:true" style="height:100px;width: 80%;"></input></td>
	    				
	    				<td>详细进度1</td>
	    				<td colspan="2">
	    					<input class="easyui-textbox" name="remark1" data-options="multiline:true" style="height:100px;width: 80%;" ></input>
	    				</td>
	    				<td>详细进度2</td>
	    				<td colspan="2">
	    					<input class="easyui-textbox" name="remark2" data-options="multiline:true" style="height:100px;width: 80%;"></input>
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>详情进度3</td>
	    				<td colspan="2"><input class="easyui-textbox" name="remark3" data-options="multiline:true" style="height:100px;width: 80%;"></input></td>
	    				<td>详细进度4</td>
	    				<td colspan="2">
	    					<input class="easyui-textbox" name="remark4" data-options="multiline:true" style="height:100px;width: 80%;"></input>
	    				</td>
	    				<td>详细进度5</td>
	    				<td colspan="2">
	    					<input class="easyui-textbox" name="remark" data-options="multiline:true" style="height:100px;width: 80%;"></input>
	    				</td>
	    			</tr>
		    	</table>
	    	</div>
	    </form>
	    <div style="text-align:center;padding:5px;margin-top: 50px;">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提   交</a>
	    	&nbsp;&nbsp;
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="clearForm()">清   除</a>
	    </div>
	</div>
	</div>
 	<script type="text/javascript" src="${basePath }/resources/js/jquery.min.js"></script>
	<script type="text/javascript" src="${basePath }/resources/js/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${basePath }/resources/js/easyui-lang-zh_CN.js"></script>
 	<script type="text/javascript" src="${basePath }/resources/js/layer/layer.js"></script>
 	<script type="text/javascript" src="${basePath }/resources/js/common/common.js"></script>
 	<script type="text/javascript" src="${basePath }/resources/js/jquery.ajaxfileupload.js?01"></script>
	<script>
		function submitForm(){
			//提示层，方式重复提交
			var ll;
			$('#ff').form('submit',{
				url:"${basePath }/plan/doAdd",
				dataType:'text',
				onSubmit:function(){
					var flag = $("#ff").form('enableValidation').form('validate');
					if(flag){
						ll = layer.load(1, {
							  shade: [0.5,'#fff'] //0.1透明度的白色背景
							});
					}
					return flag;
				},
				success:function(data){
					layer.close(ll);
					var result = $.parseJSON(data);
					if(result.status == 200){
						//关闭提示框
						layer.msg("保存成功", {icon: 6});
						var ids = result.data;
						if(ids.planId != 0){
							$("#planId").val(ids.planId);
						}
						if(ids.cgyjId != 0){
							$("#cgyjId").val(ids.cgyjId);
						}
						if(ids.cggtId != 0){
							$("#cggtId").val(ids.cggtId);
						}
						if(ids.yjffId != 0){
							$("#yjffId").val(ids.yjffId);
						}
						if(ids.zpId != 0){
							$("#zpId").val(ids.zpId);
						}
						if(ids.jyId != 0){
							$("#jyId").val(ids.jyId);
						}
						if(ids.tsId != 0){
							$("#tsId").val(ids.tsId);
						}
						if(ids.rkId != 0){
							$("#rkId").val(ids.rkId);
						}
					}else{
						layer.alert(data.msg, {icon: 5});
					}
				},
				onLoadError:function(){
					layer.close(ll);
					layer.msg("操作失败", {icon: 5});
				}
			});
			
		}
		//清除表单
		function clearForm(){
			$('#ff').form('clear');
		}
		
	</script>
	
</body>
</html>