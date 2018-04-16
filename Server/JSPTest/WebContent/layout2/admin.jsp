<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@ include file = "inc/asset.jsp" %>
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
	<!-- admin.jsp -->
	<div class = "container">
	<%-- 
	<%
		String title = "Admin";
	%>
	 --%>
	<%-- <%@ include file = "inc/header.jsp" %> --%>
	
	<jsp:include page = "inc/header.jsp">
			<jsp:param value = "2" name = "mode" />
	</jsp:include>		
	<!-- jsp 액션태그로 할때는 이 페이지에서 선언한 지역 변수 사용 불가 -> 서로 따로 컴파일 하고 include 한 jsp 페이지를 잠깐 들렸다 가기 때문 -> iframe 과 같음(안과 밖 자원 서로 통용 불가) -->
	
	<h3>Lorem ipsum dolor.</h3>
	<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Minus voluptas inventore quos quis dolorem mollitia ipsa quam magni ullam placeat.</p>
	
	
	<!-- 미디어 오브젝트 : 이미지, 동영상 태그 배치 -->
	<div class = "media">
		<div class = "media-left">
			<img src = "images/job01.png" style = "width:100px">
		</div>
		<div class = "media-body">
			<h4 class = "media-padding">Administrator <small><i>hong@gmail.com</i></small></h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quae nam amet at soluta officiis nemo ex delectus tempora saepe consequuntur quia nobis architecto deleniti distinctio ut dolor veniam eligendi natus.</p>
		</div>
	
	<hr>
	
			<div class = "media-left">
			<img src = "images/job02.png" style = "width:100px">
		</div>
		<div class = "media-body">
			<h4 class = "media-padding">System Engineer <small><i>amugae@gmail.com</i></small></h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quae nam amet at soluta officiis nemo ex delectus tempora saepe consequuntur quia nobis architecto deleniti distinctio ut dolor veniam eligendi natus.</p>
		</div>
	
	<hr>
	
		<div class = "media-left">
			<img src = "images/job03.png" style = "width:100px">
		</div>
		<div class = "media-body">
			<h4 class = "media-padding">Tax Manager <small><i>mm0011@gmail.com</i></small></h4>
			<p>Lorem ipsum dolor sit amet, consectetur adipisicing elit. Quae nam amet at soluta officiis nemo ex delectus tempora saepe consequuntur quia nobis architecto deleniti distinctio ut dolor veniam eligendi natus.</p>
		</div>
	
	
	
	</div>
	</div>
</body>
</html>