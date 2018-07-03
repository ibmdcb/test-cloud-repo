<!DOCTYPE HTML>
<%@page language="java"
	contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<h1>自字库</h1>

<table border CELLPADDING="8" CELLSPACING="2" bgcolor="#99CCFF">
<tr>
<td colspan="6">家长</td>
<td colspan="6">KIDS</td>
</tr>
<tr>
<td><b>写</b></td>
<td><a href="${pageContext.request.contextPath}/articlelist.jsp">可写文章</a></td>
<td><a href="${pageContext.request.contextPath}/hanzi.jsp?status=2">已写汉字</a></td>
<td><b>读</b></td>
<td><a href="${pageContext.request.contextPath}/fandulist.jsp">可读文章</a></td>
<td><a href="${pageContext.request.contextPath}/hanzi.jsp?status=1">已读汉字</a></td>

<td><b>写</b></td>
<td><a href="${pageContext.request.contextPath}/articlelist.jsp">抄写文章</a></td>
<td><a href="${pageContext.request.contextPath}/articlelist.jsp">练习写字</a></td>
<td><b>读</b></td>
<td><a href="${pageContext.request.contextPath}/fandulist.jsp">阅读文章</a></td>
<td><a href="${pageContext.request.contextPath}/articlelist.jsp">练习认字</a></td>
</tr>
</table>

<br>


