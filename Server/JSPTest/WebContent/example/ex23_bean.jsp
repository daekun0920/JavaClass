<%@page import="com.test.jsp.Student"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 현재 페이지 목적 : Student 객체 생성 + 사용
Student s1 = new Student();

s1.setName("홍길동");
s1.setAge(20);
s1.setKor(42);
s1.setEng(50);
s1.setMath(29);

Student s2 = new Student();

s2.setName("아무개");
s2.setAge(30);
s2.setKor(52);
s2.setEng(60);
s2.setMath(89);


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
	<!-- ex23_bean.jsp -->
	<h1>학생 정보</h1>
	
	<h2><%= s1.getName() %></h2>
	<ul>
		<li>나이 : <%= s1.getAge() %></li>
		<li>국어 : <%= s1.getKor() %></li>
		<li>영어 : <%= s1.getEng() %></li>
		<li>수학 : <%= s1.getMath() %></li>
	</ul>
	
	<h2><%= s2.getName() %></h2>
	<ul>
		<li>나이 : <%= s2.getAge() %></li>
		<li>국어 : <%= s2.getKor() %></li>
		<li>영어 : <%= s2.getEng() %></li>
		<li>수학 : <%= s2.getMath() %></li>
	</ul>
	
	
	<!-- 세번째 학생 객체 생성 : Student s3 = new Student(); -->
	<jsp:useBean id = "s3" class = "com.test.jsp.Student"></jsp:useBean>
	
	<!-- setter() 값 대입 -->
	<jsp:setProperty property = "name" name = "s3" value = "하하하"/> <!-- 실제로는 setter 이름을 적은것 이다. -->
	<jsp:setProperty property = "age" name = "s3" value = "18"/> <!-- 실제로는 setter 이름을 적은것 이다. -->
	<jsp:setProperty property = "kor" name = "s3" value = "99"/> <!-- 실제로는 setter 이름을 적은것 이다. -->
	<jsp:setProperty property = "eng" name = "s3" value = "77"/> <!-- 실제로는 setter 이름을 적은것 이다. -->
	<jsp:setProperty property = "math" name = "s3" value = "77"/> <!-- 실제로는 setter 이름을 적은것 이다. -->
	
	
	<h2><jsp:getProperty property = "name" name = "s3"></jsp:getProperty></h2>
	<ul>
		<li>나이 : <jsp:getProperty property = "age" name = "s3"></jsp:getProperty></li>
		<li>국어 : <jsp:getProperty property = "kor" name = "s3"></jsp:getProperty></li>
		<li>영어 : <jsp:getProperty property = "eng" name = "s3"></jsp:getProperty></li>
		<li>수학 : <jsp:getProperty property = "math" name = "s3"></jsp:getProperty></li>
	</ul>
	
	
	
	
	
</body>
</html>