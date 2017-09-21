<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'banji_input.jsp' starting page</title>
<%@include file="/WEB-INF/Z-views/common/head.jsp"%>
<script type="text/javascript">
	function Check11() {
		var reg = /^[0-9a-zA-Z]+$/; //数字和字母
		var sname = document.getElementById("stable.sname").value;
		var spassword = document.getElementById("stable.spassword").value;
		var slxdh = document.getElementById("stable.slxdh").value;
		var sjtzz = document.getElementById("stable.sjtzz").value;
		if (sname == "") {
			alert("学生姓名不能为空");
			return false;
		} else if (sname.length > 20) {
			alert("学生姓名过长");
			return false;
		} else if (spassword=="") {
			alert("密码不能为空");
			return false;
		} else if (slxdh=="") {
			alert("联系电话不能为空");
			return false;
		} else if (sjtzz=="") {
			alert("家庭住址不能为空");
			return false;
		} 
		else {
			document.getElementById("student_inputForm").submit();
		}
	}
	
</script>
<body>
	<s:debug />
	<s:form action="student_update" id="student_inputForm" theme="simple">
		<table align="center">
			<tr>
				<td width="180px;" align="center"><strong>学生信息操作</strong></td>
				<td><font color="red" size="1px;"></font></td>
			</tr>
		</table>
		<br />
		<table align="center" border="1">
			<tr>
				<td width="200px;">学号：</td>
				<td><s:textfield id="stable.sid" name="stable.sid"
						placeholder="学号" readonly="true" /></td>
			</tr>
			<tr>
				<td width="200px;">姓名：</td>
				<td><s:textfield id="stable.sname" name="stable.sname"
						placeholder="姓名" /></td>
			</tr>
			<tr>
				<td width="200px;">性别：</td>
				<td><s:radio id="stable.ssex" name="stable.ssex"
						list="#{'男':'男','女':'女'}" /></td>
			</tr>
			<tr>
				<td width="200px;">密码：</td>
				<td><s:textfield id="stable.spassword" name="stable.spassword"
						placeholder="密码" /></td>
			</tr>
			<tr>
				<td width="200px;">联系电话：</td>
				<td><s:textfield id="stable.slxdh" name="stable.slxdh"
						placeholder="联系电话" /></td>
			</tr>
			<tr>
				<td width="200px;">家庭住址：</td>
				<td><s:textfield id="stable.sjtzz" name="stable.sjtzz"
						placeholder="联系电话" /></td>
			</tr>
			<%-- <tr>
				<td  width="200px;">所属班级：</td>
				 <td>
				    <s:property value="stable.BTable.bname"/>
				 </td>
			</tr> --%>
			<tr>
				<td width="200px;">班级：</td>
				<td><s:select list="#btablelist" listValue="bname"
						listKey="bid" name="stable.BTable.bid" headerKey="-1"
						cssStyle="width:100%" />
				</td>
			</tr>
		</table>
		<br />
		<table align="center">
			<tr>
				<td style="text-align: center;" colspan="3"><s:submit
						id="btnsave" class="btn" value="保存" onclick="return Check11()" />
					<button id="cancelBtn" type="button">取消</button></td>
				<td width="5%"></td>
			</tr>
		</table>
	</s:form>
</body>
</html>
