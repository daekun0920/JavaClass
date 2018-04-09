<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<%

/*

웹 페이지 이동
1. HTML
	- <a> 사용
	- 브라우저 사용자가 직접 클릭
	
2. JavaScript
	- location.href 사용
	- 브라우저 사용자의 행동을 통해서 실행
	- 프로그램 제어를 통해서 실행
	- 클라이언트측 이동
	- 서버측에서 읽을수 없는 언어기 때문에 라운드 트립(요청과 응답)이 2번 일어난다.
	
3. JSP/Servlet
	- response.sendRedirect(url) 사용
	- 서버측 이동
	- 프로그램 제어를 통해서 실행
	- 서버측에서 읽다가 읽을 수 있는리다이렉트를 만나면 뒤에 상관없이 무조건 중단하고 2페이지로 이동
	- 기존 출력버퍼(임시 HTML)을 날리고 이동한 페이지의 임시 HTML을 새로 만든다
*/

response.sendRedirect("ex10_response_two.jsp");

// response 는 내부 컬렉션이 없다.
// response.setAttribute();
// response.getAttribute();
	
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
		//location.href = "ex10_response_two.jsp";
	});
</script>
</head>
<body>
	<!--  -->

</body>
</html>