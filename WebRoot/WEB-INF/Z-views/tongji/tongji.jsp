<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>课程信息管理界面</title>
<%@include file="/WEB-INF/Z-views/common/head.jsp"%>
</head>
<body>
	<br />
	<s:form>

		<table border="1" align="center">
			<tr>
				<!--style="background-color: DodgerBlue;"  -->
				<th width="11%"><span><strong>学&nbsp;号</strong> </span></th>
				<th width="11%"><span><strong>姓名</strong> </span></th>
				<th width="8%"><span><strong>性别</strong> </span></th>
				<th width="11%"><span><strong>出生日期</strong> </span></th>
				<th width="11%"><span><strong>密码</strong> </span></th>
				<th width="11%"><span><strong>联系电话</strong> </span></th>
				<th width="11%"><span><strong>家庭住址</strong> </span></th>
				<th width="11%"><span><strong>班级编号</strong> </span></th>
				<th colspan="2" width="11%"><span><strong>操作</strong> </span></th>
			</tr>
			<s:iterator value="pageList.rows" status="st">
				<tr style="background-color: white;">
					<td>${sid}</td>
					<td>${sname}</td>
					<td>${ssex}</td>
					<td>${spassword}</td>
					<td>${slxdh}</td>
					<td>${sjtzz}</td>
					<td>${sName}</td>
					<td><button type="button" class="btn1"
							onclick="updateDomain('role_input.action?roleId=${roleId}');">编辑</button>
					</td>
					<td><button type="button" class="btn1"
							onclick="deleteDomain('role_delete.action?roleId=${roleId}');">删除</button>
					</td>
				</tr>
			</s:iterator>
		</table>
	</s:form>

</body>
<%@include file="/WEB-INF/Z-views/common/tail.jsp"%>
</html>
