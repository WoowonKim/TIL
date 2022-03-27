<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %> 
   
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>게시판</title>
</head>
<body>
	<div>
		<h2>자유 게시판</h2>
		<hr>
		<div>
			<table>
				<tr>
					<th>번호</th>
					<th>제목</th>
					<th>글쓴이</th>
					<th>조회수</th>
					<th>등록일</th>
				</tr>
				<c:forEach items="${list }" var="board">
					<tr>
						<td>${board.no}</td>
						<td>
							<a href="main?action=detail&no=${board.no }">${board.title}</a>
						</td>
						<td>${board.writer}</td>
						<td>${board.viewCnt}</td>
						<td>${board.regDate}</td>
					</tr>
				</c:forEach>
			</table>
			<div>
				<a href="board/writeform.jsp">등록</a>
			</div>
			<div>
				<a href="${pageContext.request.contextPath }">메인 화면</a>
			</div>
		</div>
	</div>
</body>
</html>