<%@page import="com.test.jsp.Address"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%

// 현재 페이지의 목적 : 입력 데이터 수신 -> 객체화(DTO, Bean) -> 업무 적용

request.setCharacterEncoding("UTF-8");

/* 
String name = request.getParameter("name");
String age = request.getParameter("age");
String gender = request.getParameter("gender");
String tel = request.getParameter("tel");
String address = request.getParameter("address");
*/

/*
Address addr = new Address();

addr.setName(name);
addr.setAge(Integer.parseInt(age));
addr.setGender(gender);
addr.setTel(tel);
addr.setAddress(address);
*/

/* HTML 태그 name 값 == 자바빈의 멤버 변수명 == DTO의 멤버 변수명 == 오라클 테이블의 컬럼명 */

%>

<jsp:useBean id = "addr" class = "com.test.jsp.Address"></jsp:useBean>

<%-- 
<jsp:setProperty name = "addr" property = "name" value = "<%= name %>"></jsp:setProperty>
<jsp:setProperty name = "addr" property = "age" value = <%= Integer.parseInt(request.getParameter("age")) %>></jsp:setProperty>
<jsp:setProperty name = "addr" property = "gender" value = <%= Integer.parseInt(request.getParameter("gender")) %>></jsp:setProperty>
--%>

<!-- form 에서 넘어오는 각 input 의 name과 멤버 변수명이 같아야 한다. -->
<jsp:setProperty name = "addr" property = "*"></jsp:setProperty> <!-- 자동으로 다 됨 -->

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
	<h1>결과</h1>
	
	<p>이름 : <%= addr.getName() %></p>
	<%-- <p>이름 : <jsp:getProperty property="age" name="addr"/></p> --%>
	<p>나이 : <%= addr.getAge() %></p>
	<p>성별 : <%= addr.getGender() %></p>
	<p>전화 : <%= addr.getTel() %></p>
	<p>주소 : <%= addr.getAddress() %></p>
	
	
</body>
</html>