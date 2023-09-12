<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>   
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>

	<%--
        jstl choose 태그와 el을 활용하여
        100점이 넘어가면 "점수를 잘못 입력하셨습니다."
        90점이 넘으면 조건을 한번 더 검사해서,
        95 ~ 100은 A+, 94 ~ 90은 A0,
        80점이 넘으면 B, 70점이 넘으면 C, 60점대는 D
        나머지는 모두 F처리하시면 됩니다.
    --%>
    
   <c:set var="p" value="${param.score}"/>
   
   # 이름: ${param.name}<br>
   # 점수: ${score}<br>
   
   당신의 점수는: <strong>${p}점</strong>
   
   <c:choose>
   	<c:when test="${p>100 }">
   		<h4>점수를 잘못 입력하셨습니다.</h4>
   	</c:when>
   </c:choose>
   
   

</body>
</html>