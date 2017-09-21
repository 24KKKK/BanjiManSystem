<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
<title>My JSP 'banji_input.jsp' starting page</title>
<%@include file="/WEB-INF/Z-views/common/head.jsp"%>
<body>
	<s:debug />
	<s:form action="chengji_save" id="chengji_inputForm" theme="simple">
		<table align="center">
			<tr>
				<td width="180px;" align="center"><strong>成绩信息操作</strong>
				</td>
				<td><font color="red" size="1px;"></font>
				</td>
			</tr>
		</table>
		<br />
		<table align="center" border="1">

			<tr>
				<td width="200px;">班级编号</td>
				<td><s:textfield id="btable.bid" name="btable.bid"
						placeholder="班级编号" />
				</td>
			</tr>
			<tr>
				<td width="200px;">班级名称：</td>
				<td><s:textfield id="btable.bname" name="btable.bname"
						placeholder="班级名称" />
				</td>
			</tr>
		</table>
		<br />
		<table align="center">
			<tr>
				<td style="text-align: center;" colspan="3"><s:submit
						id="btnsave" class="btn" value="保存" onclick="return Check11()" />
					<button id="cancelBtn" type="button">取消</button>
				</td>
				<td width="5%"></td>
			</tr>
		</table>
	</s:form>
	<script type="text/javascript">
	function Check11() {
		var reg = /^[0-9a-zA-Z]+$/; //数字和字母
		var bname = document.getElementById("bname").value;
		var bid=document.getElementById("bid").value;
		alert("www"+bname);
		alert("wwid"+bid);
		if (bname == "") {
			alert("班级名称不能为空");
			return false;
		} else if (bname.length > 50) {
			alert("角色名称过长");
			return false;
		} else {
			document.getElementById("banji_inputForm").submit();
		}
	}
</script>
</body>

</html>
