<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<style>
	
<c:if test="${result == 1}">
	body {background: cornflowerblue;}
</c:if>
	
</style>
</head>
<body>
	<!-- result.jsp -->
	<h2>결과</h2>
	
	<p> sum : ${sum}</p>
	
	<p> dto : ${dto} </p>
	
	<p> list : ${list } </p>
	
		
</body>
</html>


























    