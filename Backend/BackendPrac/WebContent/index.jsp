<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<c:if test="${empty loginEmp}">
		<form action="main?action=login" method="POST">
			<label>사원번호 : </label><input type="text" name="empno">
			<label>이름 : </label><input type="text" name="ename">
			<input type="submit" value="로그인">
		</form>
	</c:if>
	<c:if test="${!empty loginEmp }">
		<h2>반갑습니다. ${loginEmp.ename }님</h2>
		<form action="main?action=logout" method="POST">
			<input type="submit" value="로그아웃">
		</form>
		<div>
		<a href="${pageContext.request.contextPath }/main?action=board">게시판이동하기</a>
		</div>
		<div>
		<a href="${pageContext.request.contextPath }/main?action=emplist">직원목록 조회하기</a>
		</div>
	</c:if>
</body>
</html>