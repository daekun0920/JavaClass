<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h1>게시판 - 목록보기</h1>
	
	<p>
		<c:if test = "${empty auth }">게스트</c:if>
		<c:if test = "${!empty auth }">아이디 : ${auth }</c:if>
	</p>
	
	<h2>로그인</h2>
	<a href = "/spring/login.aop?id=hong">홍길동</a>
	<a href = "/spring/login.aop?id=test">홍길동</a>
	<a href = "/spring/login.aop?id=aaa">홍길동</a>
	
	<h2>로그아웃</h2>
	<a href = "/spring/logout.aop">로그아웃</a>
	
	<p>
		<a href = "/spring/board/list.aop">목록보기</a>
		<a href = "/spring/board/add.aop">글쓰기</a>
		<a href = "/spring/board/view.aop">내용보기</a>
	</p>
</body>
</html>