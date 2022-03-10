# 게시판 상세기능

## list.jsp

```jsp
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
			<td><a href="detail?no=<%=b.getNo() %>"><%=b.getTitle() %></a></td>
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
```



## DetailBoardServlet

```java
package com.ssafy.board;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/detail")
public class DetailBoardServlet extends HttpServlet{
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) 
			throws ServletException, IOException{
		int no =  Integer.parseInt(req.getParameter("no"));
		Board board = BoardDAO.getInstance().selectBoard().get(no-1);
		board.setViewCnt(board.getViewCnt()+1);
		req.setAttribute("detail", board);
		req.getRequestDispatcher("detail.jsp").forward(req, res);
	}
}

```

## detail.jsp

```jsp
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
```

