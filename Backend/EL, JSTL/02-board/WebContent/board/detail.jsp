<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%  %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글번호 ${detail.no}</h2>
	<h2>제목 : <c:out value="${detail.title}"/></h2>
	<h2>글쓴이 : <c:out value="${detail.writer}"/></h2>
	<hr>
	<div>
	<h2>내용</h2>
	<c:out value="${detail.content}"/>
	</div>
</body>
</html>