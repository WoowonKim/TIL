<%@page import="com.ssafy.board.Board"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	// 공유데이터 꺼내기
	Board b = (Board)request.getAttribute("detail");
%>  
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글번호 <%=b.getNo() %></h2>
	<h2>제목 : <%=b.getTitle() %></h2>
	<h2>글쓴이 : <%=b.getWriter() %></h2>
	<hr>
	<div>
	<h2>내용</h2>
	<%=b.getContent() %>
	</div>
</body>
</html>