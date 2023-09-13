<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	<h2>게시글 등록 페이지지</h2>
	<form action="/JspBasic/regist.pboard" method="post">
		<input type="text" name="writer" placeholder="작성자는"> <br>
		<input type="text" name="title" placeholder="글 제목은"> <br>
		<textarea rows="10" cols="50" placeholder="게시글 내용을 입력하세요"></textarea>
		<button type="submit" onclick="return confirm('등록하시겠습니까?')">등록</button>
	</form>
	
</body>
</html>