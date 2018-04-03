<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@page import="com.test.jsp.MyUtil"%>

<% 
	// 변수 : 멤버 변수? 지역 변수?
	int a = 10;	
	
	MyUtil util = new MyUtil(); /* 외부 클래스 */

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<!-- ex05.jsp -->
	<!-- 실행시 서블릿으로 변환후 실행한다. JSP -> 서블릿 -->
	<h1>구구단</h1>
	
	<% for (int i = 1; i <= 9; i++) { %>
	
		<div>9 x <%= i %> = <%= i * 9 %></div>
		
	<% } %>
	
	<p><%= util.run() %></p> <!-- 외부 객체 메소드 -->
	
</body>
</html>



<%

	int b = a;
	
	/*
	
	public void test() {
		
	}
	
	*/
	
%>

<%!

	int c = 10;

	public void test() {
		
	}

%>

