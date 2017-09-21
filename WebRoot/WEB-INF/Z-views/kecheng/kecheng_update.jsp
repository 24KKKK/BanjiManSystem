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
		var kname = document.getElementById("ktable.kname").value;
		var knature = document.getElementById("ktable.knature").value;
		var kxf = document.getElementById("ktable.kxf").value;
		if (kname == "") {
			alert("课程名称不能为空");
			return false;
		} else if (kname.length > 40) {
			alert("课程名称过长");
			return false;
		} else if (knature=="") {
			alert("课程性质不能为空");
			return false;
		} else if (kxf=="") {
			alert("课程学分不能为空");
			return false;
		}
		else {
			document.getElementById("kecheng_inputForm").submit();
		}
	}
	
</script>
<body>
	<s:debug />
	<s:form action="kecheng_update" id="kecheng_inputForm" theme="simple">
		<table align="center">
			<tr>
				<td width="180px;" align="center"><strong>课程信息操作</strong>
				</td>
				<td><font color="red" size="1px;"></font>
				</td>
			</tr>
		</table>
		<br />
		<table align="center" border="1">
			<tr>
				<td width="200px;">课程编号：</td>
				<td><s:textfield id="ktable.kid" name="ktable.kid"
						placeholder="课程编号" readonly="true" />
				</td>
				<!-- readonly="true" -->
			</tr>
			<tr>
				<td width="200px;">课程名称：</td>
				<td><s:textfield id="ktable.kname" name="ktable.kname"
						placeholder="课程名称" />
				</td>
			</tr>
			<tr>
				<td width="200px;">课程性质：</td>
				<td><s:select cssStyle="width:100%" id="ktable.knature"
						name="ktable.knature"
						list="#{'学位':'学位','选修':'选修','必修':'必修','限选':'限选'}" required="true" />
				</td>
			</tr>
			<tr>
				<td width="200px;">学分：</td>
				<td><s:textfield id="ktable.kxf" name="ktable.kxf"
						placeholder="学分" />
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
</body>
</html>
