<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

// 한글 인코딩
request.setCharacterEncoding("UTF-8");


// 1. 데이터 가져오기
String width = request.getParameter("width");
String height = request.getParameter("height");
String txt = request.getParameter("txt");
String forecolor = request.getParameter("forecolor");
String backgroundcolor = request.getParameter("backgroundcolor");
String fontsize = request.getParameter("fontsize");
String isBorder = request.getParameter("isborder");

String borderwidth = request.getParameter("borderwidth");
String bordercolor = request.getParameter("bordercolor");
String borderstyle = request.getParameter("borderstyle");
String borderradius = request.getParameter("borderradius");
int count = Integer.parseInt(request.getParameter("count"));

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
	body {
		padding:30px;
	}
	
	.buttons {
		width:<%= width %>px;
		height:<%= height %>px;
		color:<%= forecolor %>;
		background-color:<%= backgroundcolor %>;
		font-size:<%= fontsize %>px;
		
		<% if(isBorder.equals("n")) { %>
			border: 0px;
		<% } else { %>
			border:<%= borderwidth %>px <%= borderstyle%> <%= bordercolor %>;
			border-radius:<%= borderradius %>%;
			
		<% } %>
		
		margin:15px;
		
	}
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
	<h1>결과</h1>
	
	
	<% for (int i = 0; i < count; i++) { %>
		<button type = "button" class = "buttons"><%= txt %></button>
	<% } %>
</body>
</html>