<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>
	
	.item { margin: 10px; padding: 5px; text-align: right; 
				border-left: 7px solid #ccc; padding-right: 10px;
				border-top-right-radius: 10px; border-bottom-right-radius: 10px; }
	
</style>
<script>
	
	window.onload = function() {
		
		//서버로부터 설문 데이터를 달라고 요청 x 5초마다 반복 + 페이지 새로 고침 없이
		
		setInterval(data, 5000);
		data();
		
	}
	
	function data() {
		
		var ajax = new XMLHttpRequest();
		
		ajax.onreadystatechange = function() {
			if (this.readyState == 4 && this.status == 200) {
				var result = this.responseText;
				//alert(result);
				var temp = result.split(",");
				
				$("#question").text(temp[0]); //설문 제목
				$("#item1 span").eq(0).text(temp[1]); //항목
				$("#item2 span").eq(0).text(temp[2]); //항목
				$("#item3 span").eq(0).text(temp[3]); //항목
				$("#item4 span").eq(0).text(temp[4]); //항목
				$("#item1 span").eq(1).text(temp[5]); //카운트
				$("#item2 span").eq(1).text(temp[6]); //카운트
				$("#item3 span").eq(1).text(temp[7]); //카운트
				$("#item4 span").eq(1).text(temp[8]); //카운트
				$("#item1").css("width", temp[5] * 15 + "px");
				$("#item2").css("width", temp[6] * 15 + "px");
				$("#item3").css("width", temp[7] * 15 + "px");
				$("#item4").css("width", temp[8] * 15 + "px");
				
			}
		};
		
		ajax.open("GET", "/ajax/ex05data.do", true);
		ajax.send();
		
	}
		
</script>
</head>
<body>
	<!-- ex02.jsp -> ex05.jsp -->
	
	<div class="container">
	
		<h2 class="page-header">설문 조사</h2>
		
		<div class="panel panel-default">
			<div class="panel-heading" id="question"></div>
			<div class="panel-body">
				<div class="item bg-info" id="item1"><span></span> <span class="badge"></span></div>
				<div class="item bg-success" id="item2"><span></span> <span class="badge"></span></div>
				<div class="item bg-warning" id="item3"><span></span> <span class="badge"></span></div>
				<div class="item bg-danger" id="item4"><span></span> <span class="badge"></span></div>
			</div>
		</div>
		
		<hr>
		
		<h2 class="page-header">추가 내용</h2>
		<input type="text" class="form-control">
	
	</div>
	
	
</body>
</html>


























    