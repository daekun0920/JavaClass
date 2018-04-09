<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 현재 상황
// - 요청 ~ 응답 과정 중에 지속적으로(***) 특정 데이터를 계속 유지해야 하는 상황
// - one -> (자원 유지) -> two -> (자원 유지) -> three

// 1. 지역 변수 사용
int a = 10;

// 3. pageContext 사용
pageContext.setAttribute("c", 30);

// 4. request 사용
request.setAttribute("d", 40);

// 5. session 사용
session.setAttribute("e", 50);

// 6. application 사용
application.setAttribute("f", 60);

%>


<%!

// 2. 멤버 변수 사용
int b = 20;

%>
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
	//$(document).ready(function() {
	//	
	//});
	
	// 줄임 표현
	$(function() {
		
	});
</script>
</head>
<body>
	<!-- ex16_scope.one.jsp -->
	<h1>첫번째 페이지</h1>
	
	<h2>결과</h2>
	
	<!-- 웹은 실시간 연결이 아닌 실시간 비연결 이다.  -->
	<!-- http 프로토콜은 비연결 지향이다. -->
	<!-- 필요한 데이터만 받고 연결을 끊어버린다. -->
	<!-- 세션은 사이트를 나가도 유지되고 일정시간이 지나면 자동 소멸된다(오랫동안 가만히 있으면 로그인 풀릴때) -->
	<!-- 세션은 서버 기준으로 생긴다. -->
	<p>a = <%= a %></p> <!-- 지역 변수 -->
	<p>b = <%= b %></p> <!-- 멤버 변수 -->
	<p>c = <%= pageContext.getAttribute("c") %></p> <!-- 현재 : 다른 페이지로 가면 새로 만들어진다  -->
	<p>d = <%= request.getAttribute("d") %></p> <!-- 요청 -->
	<p>e = <%= session.getAttribute("e") %></p> <!-- 개인 : 손님이 들어오면 생성되고 나가면 죽는다 -->
	<p>f = <%= application.getAttribute("f") %></p> <!-- 공용 : 사이트가 운영중일때는 계속 살아있다 - 마지막 손님이 나가면 죽음 -->
	
	<!-- 두번째 페이지로 이동하기 : 페이지를 이동할 수 있는 수단들? -->
	<a href = "ex16_scope_two.jsp">두번째 페이지</a>
	<br>
	<input type = "button" value = "두번째 페이지" onclick = "location.href='ex16_scope_two.jsp';">
	
	<%
	
	//response.sendRedirect("ex16_scope_two.jsp");
	pageContext.forward("ex16_scope_two.jsp");
	
	
	%>
	
</body>
</html>