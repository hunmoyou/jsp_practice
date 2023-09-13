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
	
		<h2>게시글 목록</h2>
		<table border="1">
			<tr>
				<th>번호</th>
				<th>작성자</th>
				<th>제목</th>
				<th>작성일</th>
				<th>비고</th>
			</tr>
			<%-- c:forEach의 속성인  varStatus를 활용하면
				현재 사용중인 반복문의 여러가지 속성을 사용할 수 있습니다.
				${status.count}: 1부터의 순서
				${status.index}: 0부터의 순서
				${status.current}: 현재 아이템	
			 --%>
			<c:forEach var="b" items="${boardList}" varStatus="status">
				<tr>
					<td>${status.count}</td>
					<td>${b.writer}</td>
					<td>
					<a href="/JspBasic/content.board?bid=${status.count}">${b.title}</a>
					</td>
					<td>
						<fmt:parseDate value="${b.regDate}" pattern="yyyy-MM-dd'T'HH:mm:ss" var="parsedDateTime" type="both" />
						<fmt:formatDate value="${parsedDateTime}" pattern="yyyy년 MM월 dd일 HH시 mm분" />
					</td>
					<td>[삭제]</td>
				</tr>	
			</c:forEach>			
		</table>
		
		<br>
		
		
		<a href="/JspBasic/write.board">새 글 작성하기</a>
	
	
	
</body>
</html>





















