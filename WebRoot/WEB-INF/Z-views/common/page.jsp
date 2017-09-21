<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@taglib prefix="s" uri="/struts-tags"%>
第
<span style="color: red">${pageList.begin}</span>
到
<span style="color: red">${pageList.end}</span>
条/总共
<span style="color: red">${pageList.totalCount}</span>
条记录
<br />
每页
<s:select list="{5,10,20,50}" name="baseQuery.pageSize"
	onchange='$("#domainForm").submit();' style="width:40px;" />
条/第
<!--s:textfield 默认提交值使用name属性，显示值是value，如果没有value默认使用name -->
<!--value里面使用ognl表达式，以%{}开头 -->
<s:textfield id="pageNo" name="baseQuery.currentPage"
	value="%{pageList.currentPage}" size="1" />
页
<button class="" type="submit">Go</button>
<br />
${pageList.page}
