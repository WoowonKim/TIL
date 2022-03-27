<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>글번호 ${board.no}</h2>
	<h2>제목 : ${board.title}</h2>
	<h2>글쓴이 : ${board.writer}</h2>
	<hr>
	<div>
	<h2>내용</h2>
	${board.content}
	</div>
	<button onclick="location.href='main?action=update&no=${board.no}'">수정</button>
	<button onclick="location.href='main?action=del&no=${board.no}'">삭제</button>
	<button onclick="location.href='main?action=board'" >목록</button>
</body>
</html>