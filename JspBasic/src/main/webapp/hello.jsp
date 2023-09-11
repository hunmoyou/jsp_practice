<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<% for(int i=1; i<=5; i++){%>
	<h2>이클립스 내부에서 html 문서 작성하기!</h2>
	<p>
		안녕하세요! 오늘은 9월 8일 목요일입니다. <br> 
		지금은 html 문서를 작성중입니다~
	</p>
	<% }%>
	
	<hr>
	
	<!-- HTML 주석입니다. -->
	<%-- Jsp 주석입니다. --%>
	
	<h2>구구단 4단</h2>
	<% for(int hang = 1; hang<=9; hang++){ %>
		4 x <%= hang %> = <%= 4*hang %> <br>
	<% }%>
	
</body>
</html>