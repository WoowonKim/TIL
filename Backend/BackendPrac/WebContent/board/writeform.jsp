<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>글작성</title>
</head>
<body>
	<div>
		<h2>글 작성</h2>
		<form action="${pageContext.request.contextPath }/main" method="POST">
			<input type="hidden" name="action" value="writeboard">
			<div>
			  <label for="title">글제목</label>
			  <input type="text" id="title" name="title">
			</div>
			<div>
			  <label for="writer" >글쓴이</label>
			  <input type="text" id="writer" name="writer" readonly="readonly" value="${loginEmp.ename}">
			</div>
			<div>
			  <label for="content">글내용</label>
			  <textarea id="content" name="content" rows="10"></textarea>
			</div>
			<button>등록</button>
		</form>
	</div>
</body>
</html>