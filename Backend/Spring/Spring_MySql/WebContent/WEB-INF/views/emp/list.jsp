<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>사원 정보 목록</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>empno</th>
				<th>ename</th>
				<th>deptno</th>
				<th>dname</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="emp" items="${list}">
				<tr>
					<td>${emp.empno}</td>
					<td>${emp.ename}</td>
					<td>${emp.deptno}</td>
					<td>${emp.dname}</td>
				</tr>			
			</c:forEach>
		</tbody>
	</table>
</body>
</html>