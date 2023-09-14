<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

		<h2>${boardNo}번 게시물 내용</h2>

		<p>
		 # 작성자 : ${content.writer} <br>
		 # 제목 : ${content.title} <br>
		 # 내용 : <textarea rows="5" readonly>${content.content}</textarea>
		</p>

	<a href="/JspBasic/list.board">글 목록 보기</a>
	<a href="/JspBasic/modify.board?bId=${boardNo}">글 수정하기</a>

</body>
</html>