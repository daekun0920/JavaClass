<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" errorPage = "error.jsp" buffer = "16kb" %>
<%@ page import = "java.util.Random, java.util.Calendar" %>      <!-- import java.util.Random; -->
<%@ page import = "java.util.Calendar" %>

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
	<!-- ex02.jsp -->
	<!-- 톰캣은 Java와 JSP 밖에 읽지 못한다. 모르는 구문은 옮겨 적어놓았다가 그 구문만 브라우저에게 돌려준다 -->
	<!-- 아는 건 실행 모르는건 적어놓았다가 브라우저에게 주기 -->
	<%
	
		int num = 10;
		num *= 2;	
		
		Random rnd = new Random();
		
		num = 0;
		int result = 100 / num; // 서버 에러
		
		
		// 버퍼 테스트
		for (int i = 0; i < 1000000; i++) {
			Thread.sleep(10); // 이 라인에서 10ms 만큼 멈춰라.
		
		
	%>
		<p>안녕하세요</p> <%= i %> <!-- 안녕하세요가 100만번이 찍힌다. 톰캣은 모르는 구문은 옮겨 놓는다. 맨 밑 괄호를 만나면 다시 올라간다.-->		
	<%
	
		}
	
	%>
	
	<p>num : <%= num %></p> <!-- 알고 있는 구문만 실행하고 끝 -->
	<p><%= rnd.nextInt() %></p>
	
</body>
</html>