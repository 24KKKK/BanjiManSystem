function update(data) {
	// 获取当前tr对象
	var tr = $(data).parent().parent();
	//获取信息数组
	var alltd = [];
	tr.find('td').each(function(i, td) {
		if ($(td).find('a').length == 0) {
			alltd.push($(td).html());
		}
	});
	//成绩 获取
	var ccj = $(data).parent().prev().find("input").val();
	//课程Id获取
	var kid = alltd[1];
	//学生学号获取
	var sid = alltd[3];
	$.ajax({
		url : "chengji_save.action?kid=" + kid + "&sid=" + sid
				+ "&ccj=" + ccj,
		type : "post",
		dataType : "json",
		success : function(data) {
			if (data.success) {
				alert(data.msg);
			} else {
				alert(data.msg);
			}
		}
	});
}
/*$(function() {
	$("#btnallsave").click(
			function() {
				var tableId = document.getElementById("sample-table-1");
				for ( var i = 1; i < tableId.rows.length; i++) {
					var ccj = document.getElementById(i - 1).value;
					var kid = tableId.rows[i].cells[1].innerHTML;
					var sid = tableId.rows[i].cells[3].innerHTML;
					$
							.ajax({
								url : "score_save.action?kid=" + kid
										+ "&sid=" + sid + "&ccj="
										+ ccj,
								type : "post",
								dataType : "json",
								success : function(data) {
								}
							});
				}
				alert("保存成功");
			});
});*/