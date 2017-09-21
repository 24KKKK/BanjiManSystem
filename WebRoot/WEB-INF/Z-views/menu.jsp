<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>班级信息管理系统</title>
<%@include file="/WEB-INF/Z-views/common/head.jsp"%>
<%--  <script type="text/javascript" src="/js/jquery1.js"></script> --%>
<script type="text/javascript">
	$(document).ready(
			function() {
				$(".div2").click(
						function() {
							$(this).next("div").slideToggle("slow").siblings(
									".div3:visible").slideUp("slow");
						});
			});
	function openurl(url) {
		var rframe = parent.document.getElementById("rightFrame");
		rframe.src = url;
	}
</script>
<style type="text/css">
body {
	margin: 0;
	font-family: 微软雅黑;
	background-image: url(images/.jpg);
	background-repeat: no-repea;
	background-size: cover;
	background-attachment: fixed;
}

.top1 {
	position: absolute;
	top: 0px;
	width: 100%;
	height: 20px;
	text-align: center;
	color: black;
	font-size: 17px;
	font-height: 20px;
	font-family: 楷体;
}

.title {
	float: left;
	margin: -32px 20px;
	font-size: 35px;
	color: black;
	font-height: 30px;
	font-family: 隶书;
}

.top2 {
	position: absolute;
	top: 20px;
	width: 100%;
	height: 77px;
	text-align: center;
	color: #ccffff;
}

.left {
	position: absolute;
	left: 0px;
	top: 97px;
	width: 200px;
	height: 85%;
	border-right: 1px solid #9370DB;
	color: #000000;
	font-size: 20px;
	text-align: center;
}

.right {
	position: absolute;
	left: 200px;
	top: 97px;
	width: 85.2%;
	height: 85%;
	border-top: 0px solid #484860;
	font-size: 14px;
	text-align: center;
}

.end {
	position: absolute;
	bottom: 0px;
	width: 100%;
	height: 30px;
	text-align: center;
	color: #556B2F;
	font-size: 17px;
	font-height: 20px;
	font-family: 楷体;
	background-color: ABD6E0
}

.div1 {
	text-align: center;
	width: 200px;
	padding-top: 10px;
}

.div2 {
	height: 40px;
	line-height: 40px;
	cursor: pointer;
	font-size: 18px;
	position: relative;
	border-bottom: #ccc 0px dotted;
}

.div3 {
	display: none;
	cursor: pointer;
	font-size: 15px;
}

.div3 ul {
	margin: 0;
	padding: 0;
}

.div3 li {
	height: 30px;
	line-height: 30px;
	list-style: none;
	border-bottom: #ccc 1px dotted;
	text-align: center;
}

.a {
	text-decoration: none;
	color: #000000;
	font-size: 15px;
}

.a1 {
	text-decoration: none;
	color: #000000;
	font-size: 18px;
}
</style>
</head>

<body>

	<div class="top1">
		<marquee scrollAmount=2 width=300>欢迎使用该系统！</marquee>
	</div>
	<div class="top2">
		<div class="title">
			<br /> <span style="size:18px">&nbsp;班级信息管理系统</span> <br />
		</div>
		<div class="fr top-links" align="right">
			<br /> <br /> <a href="javascript:void(0);"
				onClick="openurl('help');"> <i class="ti-user"></i> <span
				style="color: black">登录用户：DeathGhost</span>
			</a>
		</div>
	</div>

	<div class="left">
		<div class="div1">
			<a class="a" href="javascript:void(0);"
				onClick="openurl('student_Studentlist.action');">
				<div class="div2">
					<i class="ti-user"></i> 学生信息
				</div> </a> <a class="a" href="javascript:void(0);"
				onClick="openurl('banji_Banlist.action');">
				<div class="div2">
					<i class="ti-view-list-alt"></i> 班级信息
				</div> </a> <a class="a" href="javascript:void(0);"
				onClick="openurl('kecheng_KeChenglist.action');">
				<div class="div2">
					<i class="ti-text"></i> 课程信息
				</div> </a> <a class="a" href="javascript:void(0);"
				onClick="openurl('score_ChengJilist.action');">
				<div class="div2">
					<i class="ti-pencil-alt2"></i> <span>成绩录入</span>
				</div> </a> <a class="a" href="javascript:void(0);"
				onClick="openurl('tongji');">
				<div class="div2">
					<i class="ti-map"></i> 统计查询
				</div> </a> <a class="a" href="javascript:void(0);"
				onClick="openurl('help.action');">
				<div class="div2">
					<i class="ti-bell"></i> 系统信息
				</div> </a> <a class="a" href="login.action" onclick="Exit_onclick()">
				<div class="div2">
					<i class="ti-export"></i> 退出系统
				</div> </a>
		</div>
	</div>

	<div class="right">
		<iframe id="rightFrame" name="rightFrame" width="100%" height="100%"
			scrolling="auto" marginheight="0" marginwidth="0" align="top"
			style="border: 0px solid #CCC; margin: 0; padding: 0;"> </iframe>
		<div class="copyright pull-right">
			<p style="color:black">
				班级信息管理系统 <a href="http://www.stdu.edu.cn/" target="_blank"
					title="铁大官网">&nbsp;&nbsp;&nbsp;</a>
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
