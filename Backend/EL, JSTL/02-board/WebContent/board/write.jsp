<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>대전싸피 게시판</h2>
	<form method="post" action="/02-board/board/write"> 
		<div>
			<label>제목</label>
			<input type="text" name="title" />
		</div>
		<div>
			<label>글쓴이</label>
			<input type="text" name="writer" />
		</div>
		<div>
			<textarea name="content" rows="7" cols="80"></textarea>
		</div>
		<div>
			<button>등록</button>
		</div>
	</form>
</body>
</html>




