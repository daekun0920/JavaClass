<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%

// 페이지 방문 카운트

// 초기화
// System.out.println(session.getAttribute("count") == null);
  
if (request.getAttribute("count") == null) 
request.setAttribute("count", 0);

if (session.getAttribute("count") == null) 
session.setAttribute("count", 0);

if (application.getAttribute("count") == null) 
application.setAttribute("count", 0);

// 방문 카운트 누적 + 1
request.setAttribute("count", (int)request.getAttribute("count") + 1); // count = count + 1;
session.setAttribute("count", (int)session.getAttribute("count") + 1); // count = count + 1;
application.setAttribute("count", (int)application.getAttribute("count") + 1); // count = count + 1;


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
	<!--  -->
	<!-- application이 죽을때는 마지막 접속자가 브라우저를 닫을때가 아닌 마지막 접속자의 session이 끝날때다 -->
	<h1>Count</h1>
	
	<p>카운트(request) : <%= request.getAttribute("count") %></p>
	<p>카운트(session) : <%= session.getAttribute("count") %></p>
	<p>카운트(application) : <%= application.getAttribute("count") %></p>
	
	
</body>
</html>