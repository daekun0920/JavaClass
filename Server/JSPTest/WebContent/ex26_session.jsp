<%@page import="java.util.Arrays"%>
<%@page import="java.util.Date"%>
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
	<!--  -->
	
	<%
	
	Date ctime = new Date(session.getCreationTime());
	
	String data = "";
	
	if (session.getAttribute("data") != null) {
		data = (String)session.getAttribute("data");
		data += "<br>" + (Boolean)session.getAttribute("result");
		data += "<br>" + Arrays.toString((String[])session.getAttribute("list"));
	} else {
		data = "세션 데이터 없음";
	}
	
	%>
	<h1>세션</h1>
	
	<div>세션 생성 시간 : <%= session.getCreationTime() %></div>
	<div>세션 생성 시간 : <%= String.format("%tF %tT", ctime, ctime) %></div>
	<div>세션 아이디 : <%= session.getId() %></div>
	<div>세션 만료 시간 : <%= session.getMaxInactiveInterval() %></div>
	<div>세션 생성 유무 : <%= session.isNew() %></div>
	<div>세션 데이터 : <%= data %></div>
	
	<h2>세션 제어</h2>
	
	<a href = "ex26_session_set.jsp">세션값 저장하기</a><br>
	<a href = "ex26_session_del.jsp">세션값 삭제하기</a><br>
	<a href = "ex26_session_reset.jsp">세션 초기화</a><br>
	<a href = "ex26_session_interval.jsp">세션 만료 시간 지정하기</a><br>
		
	
</body>
</html>