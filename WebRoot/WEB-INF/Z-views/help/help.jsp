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
	<div class="content">
		<div class="container-fluid">
			<p align="left">
				<strong>功能要求</strong><br /> （1）登录<br /> （2）班级信息的CRUD<br />
				（3）学生信息的CRUD<br /> （4）课程信息的CRUD<br /> （5）成绩的录入<br />
				（6）统计某一个学生的所修课程的信息、汇总出学分、不及格课程（标红）<br /> （7）统计每一门课程的最高分、最低分和平均分<br />
			</p>
		</div>
		<div class="container-fluid">
			<p align="left">
				<strong>技术要求</strong><br /> （1）采用struts2<br /> （2）采用Hibernate<br />
				（3）采用SqlServer2008R2<br /> （4）语言采用java<br /> （5）web容器采用Tomcat <br />
			</p>
		</div>
	</div>
</body>
<!-- 退出系统的验证 -->
<script language="JavaScript">
  function Exit_onclick() {
  if (confirm("确定退出系统吗?")) {
   return true;
  }
  else{
   return false;
			}
  }
  </script>

</html>
