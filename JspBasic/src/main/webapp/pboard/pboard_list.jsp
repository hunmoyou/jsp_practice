<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>


	<h3>게시글 목록</h3>
	<table border="1">
		<tr>
			<th>번호</th>
			<th>작성자</th>
			<th>제목</th>
			<th>작성일</th>
			<th>비고</th>
		</tr>
		
		<c:forEach var="p" items="${pboardList}" varStatus="status">
			<tr>
				<td>${status.count}</td>
				<td>${p.writer}</td>
				<td>
				<a href="/JspBasic/content.pboard?bid=${status.count}">${p.title}</a>
				</td>
				<td>
				<fmt:parseDate value="${p.regDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parseDateTime" type="both"/>
				<fmt:formatDate value="${parseDateTime}" pattern="yyyy년 MM월 dd일"/>
				</td>
				<td>[삭제]</td>
			</tr>
		</c:forEach>		
	</table>
	
	<br>
	
	<a href="/JspBasic/write.pboard">새 글 작성하세용가리</a>
	
	
</body>
</html>


























