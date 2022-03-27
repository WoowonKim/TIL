<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글 수정</title>
</head>
<body>
	<div>
		<h2>글 수정</h2>
		<form action="${pageContext.request.contextPath }/main" method="POST">
			<input type="hidden" name="action" value="updateboard">
			<input type="hidden" name="no" value="${board.no }">
			<div>
			  <label for="title">글제목</label>
			  <input type="text" id="title" name="title" value="${board.title}">
			</div>
			<div>
			  <label for="writer" >글쓴이</label>
			  <input type="text" id="writer" name="writer" readonly="readonly" value="${board.writer}">
			</div>
			<div>
			  <label for="content">글내용</label>
			  <textarea id="content" name="content" rows="10" placeholder="${board.content }"></textarea>
			</div>
			<button>수정</button>
		</form>
	</div>
</body>
</html>