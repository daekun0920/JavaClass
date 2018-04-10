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
	<!-- index.jsp -->
	<h1>시작 페이지</h1>
	
	<h2>인증</h2>
	
	<%
	
	// 로그인 상태인지 확인
	if (session.getAttribute("auth") == null) {
	
	%>
		<div><a href = "login.jsp">로그인하기</a></div>
	<% 
	
	} else {
	
	%>
	
		<div class = "panel panel-default">
			<div class = "panel-heading">고객 정보</div>
			<div class = "panel-body">
				<div>ID : <%= session.getAttribute("auth") %></div>
				<div>이름 : <%= session.getAttribute("name") %></div>
				<div>등급 : 
				<%= session.getAttribute("lv") %>
				</div>
			</div>
		</div>
		
		
		<div><a href = "logout.jsp">로그아웃하기</a></div>	
	<%
	
	}
	
	%>
	
	<h2>회원 전용 페이지</h2>
	<% if (session.getAttribute("auth") != null) { %>
		<div>
			<a href = "member/member.jsp">
				회원 전용 페이지로 이동하기
			</a>
		</div>
	<% } else { %>
		<div>
			<a href = "#" onclick = "event.preventDefault(); alert('비회원은 사용하실 수 없습니다.');">
				회원 전용 페이지로 이동하기
			</a>
		</div>
	<% } %>
	
	<h2>관리자 전용 페이지</h2>
	
	<% if (session.getAttribute("auth") != null && (int)session.getAttribute("lv") >= 2) { %>
		<div><a href = "admin/admin.jsp">관리자 전용페이지</a></div>
	<% } %>
	
</body>
</html>