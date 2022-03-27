<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>직원 목록</title>
</head>
<body>
	<h2>직원 목록</h2>
	<table>
		<tr>
			<th>empno</th>
			<th>ename</th>
			<th>job</th>
			<th>deptno</th>
			<th>dname</th>
		</tr>
		<c:forEach items="${list}" var="e">
			<tr>
				<td>${e.empno}</td>
				<td>${e.ename}</td>
				<td>${e.job}</td>
				<td>${e.deptno}</td>
				<td>${e.dname}</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<a href="${pageContext.request.contextPath }">메인 화면</a>
	</div>
</body>
</html>