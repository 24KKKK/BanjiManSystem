<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<base href="<%=basePath%>">

<title>班级信息管理系统登陆界面</title>

<meta http-equiv="pragma" content="no-cache">
<meta http-equiv="cache-control" content="no-cache">
<meta http-equiv="expires" content="0">
<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
<meta http-equiv="description" content="This is my page">
<link rel="stylesheet" type="text/css" href="styles.css">
<link href="/Wopop_files/style_log.css" rel="stylesheet" type="text/css">
<link rel="stylesheet" type="text/css" href="/Wopop_files/style.css">
<link rel="stylesheet" type="text/css" href="/Wopop_files/userpanel.css">
<link rel="stylesheet" type="text/css"
	href="/Wopop_files/jquery.ui.all.css">
<script src="/Wopop_files/login.js"></script>
<script src="/Wopop_files/JQuery.cookie.js"></script>
<script src="/Wopop_files/google_jquery.min.js"></script>
<script src="/Wopop_files/google_jquery-ui.min.js"></script>
<script language="JavaScript">
 
function chkvalue(txt) {
   if(txt.value=="") alert("文本框里必须填写内容!");
}
 
</script>
</head>
<body class="login" id="myform" method="post">
	<div class="login_m">
		<div class="login_logo">
			<h1>
				<strong>班级信息管理系统</strong>
			</h1>
		</div>
		<div class="login_boder">
			<div class="login_padding" id="login_model">

				<h2>用户名</h2>
				<label> <input type="text" id="username" name="username"
					class="txt_input txt_input2"
					onfocus="if(this.value=='请输入用户名'){this.value='';}"
					onblur="if(this.value==''){this.value='请输入用户名';}" value="请输入用户名"
					value="${sid}"> </label>
				<h2>密码</h2>
				<label> <input type="password" name="password" id="password"
					class="txt_input"
					onfocus="if(this.value=='*******'){this.value='';}"
					onblur="if(this.value==''){this.value='*******';}" value="*******"
					value="${spassword}"> </label> <font size="3px;" style="color: red">
					${msg} </font>

				<div class="rem_sub">
					<div class="rem_sub_l">
						<p class="pull-left" align="right">
							<a id="iforget" href="register.action">&nbsp;注册</a>
						</p>
					</div>
					<p class="forgot">
						<a id="iforget" href="../index.jsp">忘记密码
							?&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;</a>
					</p>
				</div>
				<div class="rem_sub">
					<div class="rem_sub_l">
						<input type="checkbox" name="checkbox" id="save_me"> <label
							for="checkbox">记住用户信息</label>
					</div>
					<label> <input type="submit" class="sub_button"
						name="button" id="button" value="登 录" style="opacity: 0.7;"
						onClick="IMG1_onclick2()"> </label>
				</div>
			</div>

			<div id="forget_model" class="login_padding" style="display:none">
				<br>
				<h1>Forgot password</h1>
				<br>
				<div class="forget_model_h2">(Please enter your registered
					email below and the system will automatically reset users’ password
					and send it to user’s registered email address.)</div>
				<label> <input type="text" id="usrmail"
					class="txt_input txt_input2"> </label>
				<div class="rem_sub">
					<div class="rem_sub_l"></div>
					<label> <input type="submit" class="sub_buttons"
						name="button" id="Retrievenow" value="Retrieve now"
						style="opacity: 0.7;"> <input type="submit"
						class="sub_button" name="button" id="denglou" value="Return"
						style="opacity: 0.7;"> </label>
				</div>
			</div>



			<!--login_padding  Sign up end-->
		</div>
		<!--login_boder end-->
	</div>
	<!--login_m end-->
	<br>
	<br>
	<p align="center">
		班级信息管理系统 <a href="http://www.stdu.edu.cn/" target="_blank"
			title="铁大官网"></a> - Made by <a>陈鹏</a>
	</p>
</body>
<script type="text/javascript">
	function IMG1_onclick2() {
		var sid = document.getElementById("username");
		var spassword = document.getElementById("password");
		var url = "login_check.action?sid=" + escape(sid.value) + "&spassword="
				+ escape(spassword.value);
		if (sid.value == "") {
			alert("用户名不能为空");
			
		} else if (spassword.value == "") {
			alert("密码不能为空");
			
		} else if (sid.value.length > 20 ||sid.value.length < 6) {
			alert("用户名小于6位或大于20位");

		} else if (spassword.value.length > 20 || spassword.value.length < 6) {
			alert("密码小于6位或大于20位");

		} else if (spassword.value=="******"||sid.value == "请输入用户名") {
			alert("请输入正确的用户信息");
		} 
		else if (CheckCode(sid.value) && CheckCode(sid.value)
					) {
				alert("有特殊字符请重新填写！");
				sid.value = "";
				spassword.value = "";
		}else {
		        /* alert(0); */
				window.location.href = url;
		}	
	}
	function CheckCode(s) //有特殊字符为true  
	{
		var containSpecial = RegExp(/[(\ )(\~)(\!)(\#)(\$)(\%)(\^)(\&)(\*)(\()(\))(\-)(\_)(\+)(\=)(\[)(\])(\{)(\})(\|)(\\)(\;)(\:)(\')(\")(\,)(\.)(\/)(\<)(\>)(\?)(\)]+/);
		return (containSpecial.test(s));
	}
</script>
</html>