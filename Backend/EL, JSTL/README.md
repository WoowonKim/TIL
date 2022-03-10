# EL, JSTL을 이용한 게시판 기능으로 변경

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
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
```

