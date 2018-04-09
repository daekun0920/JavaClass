<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.util.*" %>
<% 

// 페이지의 출력 내용 직접적인 관계없는 코드는 HTML 상단/하단으로 분리
Calendar c = Calendar.getInstance();
String txt = String.format("%tF %tT", c, c);

String name = "홍길동"; // select name from ...
String age = "<input type = 'text' name = 'age' value = '20'>";
String color = "blue";

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

	p {
		color:<%= color %>;
	}

</style>
<script>
	//$(document).ready(function() {
	//	
	//});
	
	// 줄임 표현
	$(function() {
		alert("<%= name %>님 안녕하세요.");
	});
</script>
</head>
<body>
	<!-- ex04_scriptlet.jsp -->
	
	<%
	
	// 자바 영역
	int a = 10;
	int b = 20;
	
	%>

	<p>a : <%= a %></p> <!-- System.out.println(a); -->
	<p>b : <%= b %></p> <!-- System.out.println(b); -->
	<p><%= txt %></p>
	
	<h1>구구단</h1>
	<% for (int i = 1; i <= 9; i++) { %>
		<div>9 x <%= i %> = <%= i * 9 %></div>
	<% } %>
	
	<h1 style = "border:1px solid gray;color:<%= color %>;text-decoration:underline;">표현식</h1>
	
	<p>이름 : <%= name %> </p> <!-- 변수를 HTML PCDATA 영역에 출력 -->
	<p>나이 : <%= age %> </p> <!-- 동적 태그 생성 -->
</body>
</html>


	<%
	
	// 출력할 내용(X)
	// 자원 해제 코드(O)
	// 로그 남기는 작업..
	
	%>