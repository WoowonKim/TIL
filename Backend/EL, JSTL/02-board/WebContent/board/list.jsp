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
	<h2>대전 싸피 게시판</h2>
	<table>
		<tr>
			<th>번호</th>
			<th>제목</th>
			<th>글쓴이</th>
			<th>조회수</th>
		</tr>
		<c:forEach var="b" items="${list}">
		<tr>
			<td>${b.no}</td>
			<td><a href="detail?no=${b.no}"><c:out value="${b.title}"/></a></td>
			<td><c:out value="${b.writer}"/></td>
			<td>${b.viewCnt}</td>
		</tr>
		</c:forEach>
		<c:if test="${empty list}">
			<tr>
				<td colspan="4">데이터가 없습니다.</td>
			</tr>
		</c:if>
	</table>
	<div>
		<a href="write">글쓰기</a>
	</div>
</body>
</html>