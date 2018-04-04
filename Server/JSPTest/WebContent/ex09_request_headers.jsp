<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<% 

// request 를 비롯한 거의 대다수의 내장 객체
// - 내장 객체들은 자신의 내부에 사용자 정의 데이터를 관리하기 위한 컬렉션을 내장하고 있다.
// - Map 계열의 컬렉션 보유
// - getter / setter 제공


/* 
request.setAttribute(arg0, arg1);
request.getAttribute(arg0);
*/

request.setAttribute("name", "홍길동");

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
	<!-- ex09_request_headers.jsp -->
	<h1>HTTP 요청 메시지 헤더 정보</h1>
	
	<table class = "table">
		<tr>
			<th>헤더명</th>
			<th>헤더값</td>
		</tr>
		<%
		
		Enumeration<String> e = request.getHeaderNames();
		
		while (e.hasMoreElements()) {
			String headerName = (String)e.nextElement();
			//request.getHeader("host");
			
		%>
		<tr>
			<td><%= headerName %></td>
			<td><%= request.getHeader(headerName) %></td>
		</tr>
		
		<%
		}
		%>
	</table>
	
	<hr>
	
	<p>서버 도메인명 : <%= request.getServerName() %></p>
	<p>서버 포트 : <%= request.getServerPort() %> </p>
	<p>요청 URL : <%= request.getRequestURL() %> </p>
	<p>요청 쿼리 : <%= request.getQueryString() %> </p> <!-- 넘긴 데이터 -->
	<p>클라이언트 호스트 : <%= request.getRemoteHost() %> </p>
	<p>클라이언트 IP : <%= request.getRemoteAddr() %> </p>
	<p>프로토콜 : <%= request.getProtocol() %> </p>
	<p>요청 방식 : <%= request.getMethod() %> </p>
	<p>컨텍스트 경로 : <%= request.getContextPath() %> </p>
	
	<hr>
	
	request 내장 객체에 넣어둔 사용자 데이터 : <%= request.getAttribute("name") %>
	
</body>
</html>