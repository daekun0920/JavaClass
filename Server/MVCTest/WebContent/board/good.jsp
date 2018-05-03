<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<jsp:include page = "/inc/asset.jsp">
	<jsp:param value="1" name="board"/>
</jsp:include>
<style>
</style>
<script>

	<c:if test="${result == 1}">
	location.href="/mvc/board/view.do?seq=${seq}";
	</c:if>

	<c:if test="${result == 0}">
	alert("따봉을 실패했습니다");
	history.back();
	</c:if>

	<c:if test="${result == 2}">
	alert("이미 좋아요/싫어요 하셨습니다.");
	history.back();
	</c:if>
	
</script>
</head>
<body>
	<!--  -->
	<div class="container">
	
	<jsp:include page="/inc/header.jsp"></jsp:include>
	
	
	<h2 class = "page-header">게시판 <small>글 쓰기</small></h2>
	
		<%-- ${result} --%>
			
	</div>
</body>
</html>