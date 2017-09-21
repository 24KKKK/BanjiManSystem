<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>班级信息管理界面</title>
<%@include file="/WEB-INF/Z-views/common/head.jsp"%>
</head>
<body>
	<s:debug></s:debug>
	<br />
	<br />
	<center>
		<s:form id="domainForm" action="banji_Banlist.action" theme="simple">
                       名称: <s:textfield name="baseQuery.bname"
				placeholder="名称" />&nbsp;&nbsp;
			<a href="javascript:;" onclick="go(1);" class="add">搜索 </a>&nbsp;&nbsp;
			<a href="banji_input.action" class="add">添加</a>
			<br />
			<br />
			<table border="1">
				<tr style="background-color: ;">
					<th width="20%"><span><strong>编&nbsp;号</strong>
					</span>
					</th>
					<th width="40%"><span><strong>名&nbsp;称</strong>
					</span>
					</th>
					<th colspan="2" width="20%"><span><strong>操作</strong>
					</span>
					</th>
				</tr>
				<s:iterator value="pageList.rows" var="st">
					<tr style="background-color: white;">
						<th><s:property value='bid' /></th>
						<th><s:property value='bname' />
						</th>
						<td><button type="button" class=""
								onclick="updateDomain('banji_actionUpdate.action?bid=<s:property value='bid'/>');">编辑</button>
						</td>
						<td><button type="button" class=""
								onclick="deleteDomain('banji_delete.action?bid=<s:property value='bid'/>');">删除</button>
						</td>
					</tr>
				</s:iterator>
			</table>
			<%@include file="/WEB-INF/Z-views/common/page.jsp"%>
		</s:form>
	</center>
</body>
<%-- <%@include file="/WEB-INF/Z-views/common/tail.jsp"%> --%>
<center></center>
</html>
