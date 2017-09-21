<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>课程信息管理界面</title>
<%@include file="/WEB-INF/Z-views/common/head.jsp"%>
</head>
<body>
	<center>
		<s:form id="domainForm" action="kecheng_KeChenglist" theme="simple">
                       名称: <s:textfield name="baseQuery.kname"
				placeholder="名称" />&nbsp;&nbsp;
			<a href="javascript:;" onclick="go(1);" class="add">搜索 </a>&nbsp;&nbsp;
			<a href="kecheng_input.action" class="add">添加</a>
			<br />
			<br />
			<table border="1">
				<tr style="background-color: PowderBlue;">
					<th width="20%"><span><strong>课程编号</strong> </span></th>
					<th width="20%"><span><strong>课程名称</strong> </span></th>
					<th width="20%"><span><strong>课程性质</strong> </span></th>
					<th width="20%"><span><strong>课程学分</strong> </span></th>
					<th colspan="2" width="20%"><span><strong>操作</strong> </span>
					</th>
				</tr>
				<s:iterator value="pageList.rows" status="st">
					<tr style="background-color: white;">
						<td><s:property value='kid' /></td>
						<td><s:property value='kname' /></td>
						<td><s:property value='knature' /></td>
						<td><s:property value='kxf' /></td>
						<td><button type="button" class="btn1"
								onclick="updateDomain('kecheng_actionUpdate.action?kid=<s:property value='kid'/>');">编辑</button>
						</td>
						<td><button type="button" class="btn1"
								onclick="deleteDomain('kecheng_delete.action?kid=<s:property value='kid'/>');">删除</button>
						</td>
					</tr>
				</s:iterator>
			</table>
			<%@include file="/WEB-INF/Z-views/common/page.jsp"%>
		</s:form>
	</center>
</body>
<%@include file="/WEB-INF/Z-views/common/tail.jsp"%>
</html>
