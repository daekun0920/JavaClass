<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>

</style>
<script>
   $(function() {
      
   });
</script>
</head>
<body>
	<h1>JSTL, Jsp Standard Tag Library</h1>
<!-- 	JSTL로 만든 변수는 자바 지역 변수가 아니라
	pageContext.setAttribute("변수명")컬렉션 값이 된다. 
	->JSTL로 만든 변수는 EL로 취급할 수 있다. (*****)
	-->
	<h1>변수 생성</h1>
	<c:set var = "n1" value="100"></c:set>
	<%-- <div>n1 : <%= n1 %></div> --%>
	<div>n1 : ${n1}</div>
	<div>n1 : <%= pageContext.getAttribute("n1") %></div>
	<div>n1 : <%= request.getAttribute("n1") %></div>
	<div>n1 : <%= session.getAttribute("n1") %></div>
	<div>n1 : <%= application.getAttribute("n1") %></div>
	
	<h1>변수 수정</h1>
	<c:set var = "n1" value="200"/>
	<div>n1 : ${n1}</div>
	
	<h1>변수값 누적</h1>
	<c:set var = "n1" value="n1 + 50"/>
	<div>n1 : ${n1}</div>
	
	<h1>변수 복사</h1>
	<c:set var = "n2" value="${n1}"/>
	<div>n2 : ${empty n2}</div>
	
	<h1>변수 삭제</h1>
	<c:remove var = "n2" />
	<div>n2 : ${empty n2}</div>
	
	<h1>제어문</h1>
	<c:set var = "num" value="-10"/>
	
	<c:if test="${num > 0 }">
	양수입니다.
	</c:if>
	
	<c:if test="${num < 0 }">
	음수입니다.
	</c:if>
	
	<!-- switch문보다는 다중if문에 가깝다. -->
	<c:choose>
		<c:when test="${num > 0 }">양수</c:when><%-- <c:if test=""> --%>
		<c:when test="${num < 0 }">음수</c:when>
		<%-- <c:when test="${num == 0 }"></c:when> --%>
		<c:otherwise>0</c:otherwise>
	</c:choose>
	
	<h1>반복문(for 문 + 향상된 for문)</h1>
	<ul>
		<% for (int i=1; i<=5; i++){ %>
		<li>항목 <%= i %></li>
		<% } %>
	</ul>
	
	<ul>
		<c:forEach var="i" begin="1" end="5" step="1">
		<li>항목</li>
		</c:forEach>
	</ul>
	
		<%
		String[] names = {"홍길동","아무개","하하하","호호호","후후후"};
		request.setAttribute("names", names);
		%>
		
		<h1>회원목록</h1>
		<ul>
			<% for (String name : names){ %>
			<li><%= name %></li>
			<%} %>
		</ul>
		
		<ul>
			<c:forEach var = "name" items="${names}">
			<li>${name}</li>
			</c:forEach>
		</ul>
		
	
</body>
</html>









