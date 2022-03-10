<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import="java.util.List" %>  
<%@ page import="com.ssafy.board.Board" %>    
<%
	// 공유데이터 꺼내기
	List<Board> list = (List<Board>)request.getAttribute("list");
%>    
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
		<%
		for (Board b : list) {
		%>
		<tr>
			<td><%=b.getNo() %></td>
			<td><%=b.getTitle() %></td>
			<td><%=b.getWriter() %></td>
			<td><%=b.getViewCnt() %></td>
		</tr>
		<%
		}
		%>
	</table>
	<div>
<!-- 		<a href="/02-board/board/write">글쓰기</a> -->
		<a href="write">글쓰기</a>
	</div>
</body>
</html>