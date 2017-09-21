<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>111学生成绩信息管理界面</title>
<%@include file="/WEB-INF/Z-views/common/head.jsp"%>
<script type="text/javascript" src="/js/model/score.js"></script>
</head>
<body>
	<s:debug></s:debug>
	<br />
	<br />
	<center>
		<s:form id="domainForm" action="score_ChengJilist.action"
			theme="simple">
                       学生学号:<s:textfield name="baseQuery.sid"
				placeholder=" 学生学号" />&nbsp;&nbsp;&nbsp;&nbsp;
			课程名称: <s:select onchange='$("#domainForm").submit();'
				style="height:23px;" list="#allCnames" name="baseQuery.kid"
				listValue="kname" listKey="kid" headerKey="-1 "
				headerValue="------------请选择------------" />&nbsp;
			<a href="javascript:;" onclick="go(1);"
				style="position: relative; left: 3%">搜索 </a>&nbsp;&nbsp;
			<br />
			<br />
			<table border="1">
				<tr style="background-color: PowderBlue;">
					<th width="18%"><span><strong>学生学号</strong> </span></th>
					<th width="18%"><span><strong>学生姓名</strong> </span></th>
					<th width="18%"><span><strong>学生班级</strong> </span></th>
					<th width="25%"><span><strong>所选课程</strong> </span></th>
					<th width="10%"><span><strong>课程成绩</strong> </span></th>
					<th colspan="2" width="5%"><span><strong>操作</strong> </span></th>
				</tr>
				<s:iterator value="pageList.rows">
					<!--  var="t" -->
					<tr style="background-color: white;">
						<td><s:property value="STable.sid" /></td>
						<td><s:property value="STable.sname" /></td>
						<td><s:property value="STable.BTable.bname" /></td>
						<td><s:property value="KTable.kname" /></td>
						<td>
							<!-- <s:property value='ccj'/> --> <input name="ccj" id="ccj"
							value="${ccj}" />
						</td>
						<td><a onclick="update(this)"><button type="button">保存
								</button> </a></td>
					</tr>
				</s:iterator>
			</table>
			<%@include file="/WEB-INF/Z-views/common/page.jsp"%>
		</s:form>
	</center>
</body>
</html>