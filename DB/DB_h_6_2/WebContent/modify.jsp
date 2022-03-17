<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
<meta charset="UTF-8">
<title>사용자정보사이트</title>
<style>
	label {
		display: inline-block;
		width: 80px;
	}
</style>
</head>
<body>
<%@ include file="/include/header.jsp"%>
	<h1>SSAFY 사용자 관리</h1>
	<form method="post" action="main">
		<fieldset>
		<legend>사용자 정보 입력</legend>
		<!-- front-controller pattern에서 요청을 구분하기 위한 parameter -->
		<label for="id">아이디</label>
		<input type="hidden" name="action" value="modify">
		<input readonly type="text" id="id" name="id" value="${user.id }"><br>
		<label for="password">비밀번호</label>
		<input type="password" id="password" name="password"><br>
		<label for="name">이름</label>
		<input type="text" id="name" name="name" value="${user.name }"><br>
		<label for="email">이메일</label>
		<input type="email" id="email" name="email" value="${user.email }"><br>
		<label for="age">나이</label>
		<input type="number" id="age" name="age" value="${user.age }"><br>
		<input type="submit" value="수정">
		</fieldset>
	</form>
</body>
</html>