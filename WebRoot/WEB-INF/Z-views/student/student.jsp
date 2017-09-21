<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>学生信息管理界面</title>
<%@include file="/WEB-INF/Z-views/common/head.jsp"%>
</head>
<body>
	<s:debug />
	<br />
	<br />
	<center>
		<s:form id="domainForm" action="student_Studentlist" theme="simple">
                       名称: <s:textfield name="baseQuery.sname"
				placeholder="名称" />&nbsp;&nbsp;
			<a href="javascript:;" onclick="go(1);" class="add">搜索 </a>&nbsp;&nbsp;
			<a href="student_input.action" class="add">添加</a>
			<br />
			<br />
			<table border="1" align="center">
				<tr style="background-color: PowderBlue;">
					<!--style="background-color: DodgerBlue;"  -->
					<th width="15%"><span><strong>学&nbsp;号</strong> </span></th>
					<th width="15%"><span><strong>姓名</strong> </span></th>
					<th width="12%"><span><strong>性别</strong> </span></th>
					<th width="15%"><span><strong>密码</strong> </span></th>
					<th width="11%"><span><strong>联系电话</strong> </span></th>
					<th width="11%"><span><strong>家庭住址</strong> </span></th>
					<th colspan="2" width="11%" align="center"><span><strong>操作</strong>
					</span></th>
				</tr>
				<s:iterator value="pageList.rows" var="t">
					<tr style="background-color: white;">
						<td><s:property value='sid' /></td>
						<td><s:property value='sname' /></td>
						<td><s:property value='ssex' /></td>
						<td><s:property value='spassword' /></td>
						<td><s:property value='slxdh' /></td>
						<td><s:property value='sjtzz' /></td>
						<td><button type="button" class="btn1"
								onclick="updateDomain('student_updateAction.action?sid=<s:property value='sid'/>');">编辑</button>
						</td>
						<td><button type="button" class="btn1"
								onclick="deleteDomain('student_delete.action?sid=<s:property value='sid'/>');">删除</button>
						</td>
					</tr>
				</s:iterator>
			</table>
			<%@include file="/WEB-INF/Z-views/common/page.jsp"%>
		</s:form>
	</center>
</body>
<%-- <%@include file="/WEB-INF/Z-views/common/tail.jsp"%> --%>
</html>
