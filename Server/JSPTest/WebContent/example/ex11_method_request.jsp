<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
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
	<!-- ex11_method_request.jsp -->
	<h1>두번째 페이지를 부르는 역할(서버에게 페이지 주세요.. 요청)</h1>
	
	
	<h2>GET 요청</h2>
	<ul>
		<li>브라우저 주소창에 직접 입력하는 경우</li>
		<li>링크를 통해 이동하는 경우</li>
		<li>새로고침을 하는 경우</li>
		<li>자바스크립트로 이동하는 경우(location.href)</li>
		<li>폼 태그의 method = "get" 로 전송하는 경우</li>
	</ul>
	
	<div><a href = "ex11_method_response.jsp">두번째 페이지</a></div>
	<script>
		//location.href = "ex11_method_response.jsp";
	</script>
	<form method = "get" action = "ex11_method_response.jsp">
		<input type = "submit" value = "보내기">
	</form>
	
	<h2>POST 요청</h2>
	
	<ul>
		<li>폼 태그 method = "post" 로 전송하는 경우</li>
	</ul>
	
	<form method = "post" action = "ex11_method_response.jsp">	
		<input type = "submit" value = "보내기">
	</form>
	
	
</body>
</html>