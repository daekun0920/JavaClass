<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page import="java.net.URLEncoder"%>
<%@ page import="java.security.SecureRandom"%>
<%@ page import="java.math.BigInteger"%>


<html>
<head>

<style>
	
	#container {
	
		margin:0px auto;
		text-align:center;
		width:800px;
		
	}
	
	#banner {
	
		min-height:500px;
		font-size:3em;
	
	}
	
	
	body, html {
	
		margin:0;
		padding:0;
		
	
	}
	
	body {
	
		background-image:url("images/seoul.jpg");
		background-size: 100%;
		background-attachment: fixed;
	
	}
</style>
<title>네이버로그인</title>

<link rel="stylesheet" href="css/bootstrap.css">
<script src="js/jquery-1.12.4.js"></script>
<script src="js/header.js"></script>
<script src="js/bootstrap.js"></script>
</head>	
<body>
	<%
		String clientId = "gH_dcSHGR5xb9dChEsbE";//애플리케이션 클라이언트 아이디값";
		String redirectURI = URLEncoder.encode("http://localhost:8090/APITest/callback/callback.jsp", "UTF-8");
		SecureRandom random = new SecureRandom();
		String state = new BigInteger(130, random).toString();
		String apiURL = "https://nid.naver.com/oauth2.0/authorize?response_type=code";
		apiURL += "&client_id=" + clientId;
		apiURL += "&redirect_uri=" + redirectURI;
		apiURL += "&state=" + state;
		session.setAttribute("state", state);
	%>
	<div id="container">
		<div id = "banner">
			Welcome to SeoulMate!
		</div>
		<a href="<%=apiURL%>"><img height="50"
			src="http://static.nid.naver.com/oauth/small_g_in.PNG" /></a>
	</div>
</body>
</html>
