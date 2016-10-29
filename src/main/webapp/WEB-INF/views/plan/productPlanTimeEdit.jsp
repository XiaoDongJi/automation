<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="auth" uri="http://www.citichmc.com/"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
	    <form id="ff" class="easyui-form"  method="post" data-options="novalidate:true">
	    	<input type="hidden" id="planId" name="id" value="${detailVo.id }"/>
	    	<div style="margin-left: 10px;margin-top: 20px;">
		    	<table class="tb_basic" style="width: 95%;">
		    		<caption class="tb_title">
		    			基本信息
		    		</caption>
		    		<tr>
		    			<td>工作令号:</td>
		    			<td><input class="easyui-textbox" type="text" name="workSn" data-options="required:true" value="${detailVo.workSn }" disabled="disabled"></input></td>
		    			
		    			<td>合同号:</td>
		    			<td><input class="easyui-textbox" type="text" name="contractSn" value="${detailVo.contractSn }" disabled="disabled"></input></td>
		    			
		    			<td>产品图号:</td>
		    			<td><input class="easyui-textbox" type="text" name="chartSn" value="${detailVo.chartSn}" disabled="disabled"></input></td>
		    			
		    			<td>产品名称及规格:</td>
		    			<td><input class="easyui-textbox" type="text" name="productName" value="${detailVo.productName}" disabled="disabled"></input></td>
		    		</tr>
		    		<tr>
		    			<td>数量:</td>
		    			<td><input class="easyui-textbox" type="text" name="productNum" value="${detailVo.productNum}" disabled="disabled"></input></td>
		    			<td>合同交货期:</td>
		    			<td><input class="easyui-datebox" type="text" name="deliveryDate" disabled="disabled" value="<fmt:formatDate value="${detailVo.deliveryDate}" type="date" dateStyle="medium"/>" ></input></td>
		    			
		    			<td>产品种类:</td>
		    			<td>
	    					<select class="easyui-combobox" id="productType" name="productType" disabled="disabled">
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
		    				<select class="easyui-combobox" id="orderCompany" name="orderCompany" disabled="disabled">
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
		    			<td><input class="easyui-textbox" type="text" name="orderUser" value="${detailVo.orderUser}" disabled="disabled"></input></td>
		    			
		    			<td>设计:</td>
		    			<td><input class="easyui-textbox" type="text" name="designer" value="${detailVo.designer}" disabled="disabled"></input></td>
		    			
		    			<td>设计部门:</td>
		    			<td>
		    				<select class="easyui-combobox" id="designCompany" name="designCompany" disabled="disabled">
		    					<option value="1">自动化</option>
		    					<option value="2">工程公司</option>
		    					<option value="3">其他</option>
		    				</select>
		    			</td>
		    			<td>编制:</td>
		    			<td>
		    				<select class="easyui-combobox" id="organizer" name="organizer" disabled="disabled">
		    					<option value="杨攀攀">杨攀攀</option>
		    				</select>
		    			</td>
		    			
		    			
		    		</tr>
		    		<tr>
		    			<td>批准:</td>
		    			<td>
		    				<select class="easyui-combobox" id="approver" name="approver" disabled="disabled">
		    					<option value="李建明">李建明</option>
		    				</select>
		    			</td>
		    			
		    			<td>下令日期:</td>
		    			<td><input class="easyui-datebox" type="text" name="orderDate" readonly value="<fmt:formatDate value="${detailVo.orderDate}" type="date" dateStyle="medium"/>"></input></td>
		    			
		    			<td>类别:</td>
		    			<td>
		    				<select class="easyui-combobox" id="orderType" name="orderType" disabled="disabled">
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
		    			<td><input class="easyui-datebox" type="text" name="adjustDeliverDate" disabled="disabled" value="<fmt:formatDate value="${detailVo.adjustDeliverDate}" type="date" dateStyle="medium"/>"></input></td>
		    		</tr>
		    		<tr>
		    			<td>试车节点:</td>
		    			<td><input class="easyui-datebox" type="text" name="trycarDate" value="<fmt:formatDate value="${detailVo.trycarDate}" type="date" dateStyle="medium"/>" disabled="disabled" /></td>
		    			
		    			<td>重要程度:</td>
		    			<td>
		    				<select class="easyui-combobox" id="importanceDegree" name="importanceDegree" disabled="disabled">
	    						<option value="1">A</option>
	    						<option value="2">B</option>
	    						<option value="3">C</option>
	    					</select>
		    			</td>
		    			
		    			<td>柜数:</td>
		    			<td><input class="easyui-numberbox" maxlength="3" type="text" name="cupboardNum" disabled="disabled" value="${detailVo.cupboardNum}" data-options="min:0,max:1000,precision:0"></input></td></td>
		    			
		    			<td>箱数:</td>
		    			<td><input class="easyui-numberbox" maxlength="3" type="text" name="boxNum" disabled="disabled" value="${detailVo.boxNum}" data-options="min:0,max:1000,precision:0"></input></td></td>
		    			
		    		</tr>
		    		<tr>
		    			<td>项目人:</td>
		    			<td><input class="easyui-textbox" type="text" name="projectLeader" disabled="disabled" value="${detailVo.projectLeader}"></input></td>
		    		
		    			<td>状态:</td>
		    			<td>
		    				<select class="easyui-combobox" id="projectStatus" name="projectStatus" disabled="disabled" style="width: 145px;">
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
		    	
		    	<table class="tb_date" style="width: 96%;margin-top: 30px;">
		    		<caption class="tb_title">
		    			时间节点
		    		</caption>
		    		<thead>
		    			<tr>
		    				<th style="width: 15%;">生产节点</th>
		    				<th style="width: 13%;">应完成日期</th>
		    				<th style="width: 13%;">周期</th>
		    				<th style="width: 13%;">完成日期</th>
		    				<th style="width: 13%;">节点负责人</th>
		    				<th style="width: 13%;">倒计时</th>
		    				<th style="width: 20%;">备注</th>
		    			</tr>
		    		</thead>
		    		<tbody id="dt_body">
		    			<tr>
		    				<td>采购元件节点</td>
		    				<td>
			    				<input type="hidden" id="cgyjId" name="cgyj.id" value="${cgyj.id }"/>
			    				<input type="hidden" name="cgyj.nodeType" value="1" />
			    				<input class="easyui-datebox" type="text" name="cgyj.planFinishTime" 
			    					value="<fmt:formatDate value="${cgyj.planFinishTime}" type="date" dateStyle="medium"/>" readonly/>
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" maxlength="3" type="text" name="cgyj.planDayNum"
		    						value="${cgyj.planDayNum }" data-options="min:0,max:1000,precision:0" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-datebox" type="text" name="cgyj.actualFinishTime" 
		    						value="<fmt:formatDate value="${cgyj.actualFinishTime}" type="date" dateStyle="medium"/>" <auth:permission privilege="/node/cgyj">readonly</auth:permission> />
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="cgyj.nodeLeader" value="${cgyj.nodeLeader }" <auth:permission privilege="/node/cgyj">disabled="disabled"</auth:permission> ></input>
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" type="text" value="${cgyj.countDay }" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="cgyj.remark" value="${cgyj.remark }" data-options="multiline:true" style="height:50px;width: 100%;"/>
		    				</td>
		    			</tr>
		    			
		    			<tr>
		    				<td>采购柜体节点</td>
		    				<td>
			    				<input type="hidden" id="cggtId" name="cggt.id" value="${cggt.id }"/>
			    				<input type="hidden" name="cggt.nodeType" value="2" />
			    				<input class="easyui-datebox" type="text" name="cggt.planFinishTime" 
			    					value="<fmt:formatDate value="${cggt.planFinishTime}" type="date" dateStyle="medium"/>" readonly/>
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" maxlength="3" type="text" name="cggt.planDayNum"
		    						value="${cggt.planDayNum }" data-options="min:0,max:1000,precision:0" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-datebox" type="text" name="cggt.actualFinishTime" 
		    						value="<fmt:formatDate value="${cggt.actualFinishTime}" type="date" dateStyle="medium"/>" <auth:permission privilege="/node/cggt">readonly</auth:permission>/>
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="cggt.nodeLeader" value="${cggt.nodeLeader }" <auth:permission privilege="/node/cggt">disabled="disabled"</auth:permission>></input>
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" type="text" value="${cggt.countDay }" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="cggt.remark" value="${cggt.remark }" data-options="multiline:true" style="height:50px;width: 100%;"/>
		    				</td>
		    			</tr>
		    			<tr>
		    				<td>元件发放</td>
		    				<td>
			    				<input type="hidden" id="yjffId" name="yjff.id" value="${yjff.id }"/>
			    				<input type="hidden" name="yjff.nodeType" value="3" />
			    				<input class="easyui-datebox" type="text" name="yjff.planFinishTime" 
			    					value="<fmt:formatDate value="${yjff.planFinishTime}" type="date" dateStyle="medium"/>" readonly/>
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" maxlength="3" type="text" name="yjff.planDayNum"
		    						value="${yjff.planDayNum }" data-options="min:0,max:1000,precision:0" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-datebox" type="text" name="yjff.actualFinishTime" 
		    						value="<fmt:formatDate value="${yjff.actualFinishTime}" type="date" dateStyle="medium"/>" <auth:permission privilege="/node/yjff">readonly</auth:permission>/>
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="yjff.nodeLeader" value="${yjff.nodeLeader }" <auth:permission privilege="/node/yjff">disabled="disabled"</auth:permission> />
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" type="text" value="${yjff.countDay }" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="yjff.remark" value="${yjff.remark }" data-options="multiline:true" style="height:50px;width: 100%;"/>
		    				</td>
		    			</tr>
		    			
		    			<tr>
		    				<td>装配节点</td>
		    				<td>
			    				<input type="hidden" id="zpId" name="zp.id" value="${zp.id }"/>
			    				<input type="hidden" name="zp.nodeType" value="4" />
			    				<input class="easyui-datebox" type="text" name="zp.planFinishTime" 
			    					value="<fmt:formatDate value="${zp.planFinishTime}" type="date" dateStyle="medium"/>" readonly/>
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" maxlength="3" type="text" name="zp.planDayNum"
		    						value="${zp.planDayNum }" data-options="min:0,max:1000,precision:0" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-datebox" type="text" name="zp.actualFinishTime" 
		    						value="<fmt:formatDate value="${zp.actualFinishTime}" type="date" dateStyle="medium"/>" <auth:permission privilege="/node/zp">readonly</auth:permission>/>
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="zp.nodeLeader" value="${zp.nodeLeader }" <auth:permission privilege="/node/zp">disabled="disabled"</auth:permission>/>
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" type="text" value="${zp.countDay }" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="zp.remark" value="${zp.remark }" data-options="multiline:true" style="height:50px;width: 100%;"/>
		    				</td>
		    			</tr>
		    			
		    			<tr>
		    				<td>检验节点</td>
		    				<td>
			    				<input type="hidden" id="jyId" name="jy.id" value="${jy.id }"/>
			    				<input type="hidden" name="jy.nodeType" value="5" />
			    				<input class="easyui-datebox" type="text" name="jy.planFinishTime" 
			    					value="<fmt:formatDate value="${jy.planFinishTime}" type="date" dateStyle="medium"/>" readonly/>
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" maxlength="3" type="text" name="jy.planDayNum"
		    						value="${jy.planDayNum }" data-options="min:0,max:1000,precision:0" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-datebox" type="text" name="jy.actualFinishTime" 
		    						value="<fmt:formatDate value="${jy.actualFinishTime}" type="date" dateStyle="medium"/>" <auth:permission privilege="/node/jy">readonly</auth:permission> />
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="jy.nodeLeader" value="${jy.nodeLeader }" <auth:permission privilege="/node/jy">disabled="disabled"</auth:permission> />
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" type="text" value="${jy.countDay }" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="jy.remark" value="${jy.remark }" data-options="multiline:true" style="height:50px;width: 100%;"/>
		    				</td>
		    			</tr>
		    			
		    			<tr>
		    				<td>调试节点</td>
		    				<td>
			    				<input type="hidden" id="tsId" name="ts.id" value="${ts.id }"/>
			    				<input type="hidden" name="ts.nodeType" value="6" />
			    				<input class="easyui-datebox" type="text" name="ts.planFinishTime" 
			    					value="<fmt:formatDate value="${ts.planFinishTime}" type="date" dateStyle="medium"/>" readonly/>
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" maxlength="3" type="text" name="ts.planDayNum"
		    						value="${ts.planDayNum }" data-options="min:0,max:1000,precision:0" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-datebox" type="text" name="ts.actualFinishTime" 
		    						value="<fmt:formatDate value="${ts.actualFinishTime}" type="date" dateStyle="medium"/>" <auth:permission privilege="/node/ts">readonly</auth:permission> />
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="ts.nodeLeader" value="${ts.nodeLeader }" <auth:permission privilege="/node/ts">disabled="disabled"</auth:permission>></input>
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" type="text" value="${ts.countDay }" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="ts.remark" value="${ts.remark }" data-options="multiline:true" style="height:50px;width: 100%;"/>
		    				</td>
		    			</tr>
		    			
		    			<tr>
		    				<td>包装入库节点</td>
		    				<td>
			    				<input type="hidden" id=rkId name="rk.id" value="${rk.id }"/>
			    				<input type="hidden" name="rk.nodeType" value="7" />
			    				<input class="easyui-datebox" type="text" name="rk.planFinishTime" 
			    					value="<fmt:formatDate value="${rk.planFinishTime}" type="date" dateStyle="medium"/>" readonly/>
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" maxlength="3" type="text" name="rk.planDayNum"
		    						value="${rk.planDayNum }" data-options="min:0,max:1000,precision:0" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-datebox" type="text" name="rk.actualFinishTime" 
		    						value="<fmt:formatDate value="${rk.actualFinishTime}" type="date" dateStyle="medium"/>" <auth:permission privilege="/node/rk">readonly</auth:permission> />
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="rk.nodeLeader" value="${rk.nodeLeader }" <auth:permission privilege="/node/rk">disabled="disabled"</auth:permission>/>
		    				</td>
		    				<td>
		    					<input class="easyui-numberbox" type="text" value="${rk.countDay }" disabled="disabled"/>
		    				</td>
		    				<td>
		    					<input class="easyui-textbox" type="text" name="rk.remark" value="${rk.remark }" data-options="multiline:true" style="height:50px;width: 100%;"/>
		    				</td>
		    			</tr>
			    		<tr>
		    				<td colspan="7">
		    				<div style="width: 100%;border: 1px solid gray;"></div>
		    				</td>
		    			</tr>	
		    			<tr>
		    				<td>附件上传</td>
		    				<td><input type="file" id="uploadFile" name="uploadFile"/></td>
		    			</tr>
		    			<c:forEach var="file" items="${detailVo.fileList }">
			    			<tr>
			    				<td><a href="${file.fileUrl }">${file.fileName}</a></td>
			    				<td>${file.fileSize/1024}K</td>
			    				<td><a href="javascript:void(0)" onclick="delFile('${file.id}')">删除</a></td>
			    			</tr>
		    			</c:forEach>
		    		</tbody>
		    	</table>
		    	
		    	<table class="tb_last" style="width: 93%;margin-top: 40px;">
	    			<tr>
	    				<td>出库时间</td>
	    				<td><input class="easyui-datebox" type="text" name="outDate" value="<fmt:formatDate value="${detailVo.outDate }" type="date" dateStyle="medium"/>" disabled="disabled" /></td>
	    				<td>直发件数量</td>
	    				<td><input type="text" class="easyui-numberbox" name="zfjNum" value="${detailVo.zfjNum }" disabled="disabled"/></td>
	    				
	    				<td>直发件已完成数量</td>
	    				<td><input type="text" class="easyui-numberbox" name="zfjFinishNum" value="${detailVo.zfjFinishNum }" disabled="disabled"/></td>
	    				
	    				<td>直发件最终完成日期</td>
	    				<td><input class="easyui-datebox" type="text" name="zfjFinishDate" value="<fmt:formatDate value="${detailVo.zfjFinishDate }" type="date" dateStyle="medium"/>" disabled="disabled" /></td>
	    				<td></td>
	    			</tr>
	    			<tr>
	    				<td>发货报告</td>
	    				<td colspan="2"><input class="easyui-textbox" name="deliveryReport" data-options="multiline:true" style="height: 100px;width: 80%;" value="${detailVo.deliveryReport }" disabled="disabled" /></td>
	    				
	    				<td>详细进度1</td>
	    				<td colspan="2">
	    					<input class="easyui-textbox" name="remark1" data-options="multiline:true" style="height:100px;width: 80%;" value="${detailVo.remark1 }" disabled="disabled" />
	    				</td>
	    				<td>详细进度2</td>
	    				<td colspan="2">
	    					<input class="easyui-textbox" name="remark2" data-options="multiline:true" style="height:100px;width: 80%;" value="${detailVo.remark2 }" disabled="disabled" />
	    				</td>
	    			</tr>
	    			<tr>
	    				<td>详情进度3</td>
	    				<td colspan="2"><input class="easyui-textbox" name="remark3" data-options="multiline:true" style="height:100px;width: 80%;" value="${detailVo.remark3 }" disabled="disabled" /></td>
	    				<td>详细进度4</td>
	    				<td colspan="2">
	    					<input class="easyui-textbox" name="remark4" data-options="multiline:true" style="height:100px;width: 80%;" value="${detailVo.remark4 }" disabled="disabled" />
	    				</td>
	    				<td>详细进度5</td>
	    				<td colspan="2">
	    					<input class="easyui-textbox" name="remark" data-options="multiline:true" style="height:100px;width: 80%;" value="${detailVo.remark }" disabled="disabled" />
	    				</td>
	    			</tr>
		    	</table>
	    	</div>
	    </form>
	    <div style="text-align:center;padding:5px;margin-top: 50px;">
	    	<a href="javascript:void(0)" class="easyui-linkbutton" onclick="submitForm()">提   交</a>
	    </div>
	<script type="text/javascript">
	$(function(){
		chooseSelect('productType','${detailVo.productType}');
		chooseSelect('orderType','${detailVo.orderType}');
		chooseSelect('projectStatus','${detailVo.projectStatus}');
		chooseSelect('importanceDegree','${detailVo.importanceDegree}');
		chooseSelect('organizer','${detailVo.organizer}');
		chooseSelect('approver','${detailVo.approver}');
		chooseSelect('orderCompany','${detailVo.orderCompany}');
		chooseSelect('designCompany','${detailVo.designCompany}');
		
	})
	
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
					CITI.closeCurrentWindow();
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
	function chooseSelect(id,value){
		$("#"+id).find("option[value='"+value+"']").attr("selected",true); 
	}
	
	</script>
</body>
</html>