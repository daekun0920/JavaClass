<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="/ajax/css/bootstrap.css">
<script src="/ajax/js/jquery-1.12.4.js"></script>
<script src="/ajax/js/bootstrap.js"></script>
<style>

</style>
<script>

	$(function() {

		// 1. 단일값
		$("#btn1").click(function() {

			$.ajax({
				type:"GET",
				url:"/ajax/ex10data.do",
				data:"m=1",
				dataType:"json", // text|xml|json
				success: function(result) {
					
					// $("#result").text(result);
					$("#result").text(result.name);
					
				},
				error:function(a, b, c) {
					alert("오류 발생!" + a + "," + b + "," + c);

				}
				
			});
			

		});

		$("#btn2").click(function() {

			$.ajax({
				type:"GET",
				url:"/ajax/ex10data.do",
				data:"m=2&id=hong",
				dataType:"json",
				success: function(result) {
					/* 
					var result = {
						
						 "id":"hong",
						 "name":"홍길동",
						 "pw":"1111",
						 "lv":"1"
						
					} 
					*/
					$("#result").text(result.id + "," + result.name + "," + result.lv + "," + result.pw);
					
				}
					
			});
			
		});
		
		$("#btn3").click(function() {

			$.ajax({
				type:"GET",
				url:"/ajax/ex10data.do",
				data:"m=3",
				dataType:"json",
				success: function(result) {
					// alert(result.length);
					/* 
					for (var i = 0; i < result.length; i++) {
						result[i]

					}
 					*/
 					
					$(result).each(function (index, item) {
						// item -> 레코드 1줄 -> DTO -> JSON 객체 1개 -> 회원 1명
						$("#result").append(item.id + "," + item.name + "," + item.lv + "," + item.pw + "<br>");
						
					});

				}

			});
			
		});
		

		
		// $("#btn1").click(function() {});
	});
	

</script>
</head>
<body>
	<!--  -->
	<div class = "container">
		<h2 class = "page-header">jQuery Ajax -> (요청) -> 서버 -> (응답) -> JSON</h2>
		
		<div class = "well">
			<input type = "button" id = "btn1" value = "단일값" class = "btn btn-default">
			<input type = "button" id = "btn2" value = "레코드 1줄(DTO)" class = "btn btn-default">
			<input type = "button" id = "btn3" value = "다중 레코드(TABLE)" class = "btn btn-default">
		</div>
		
		<hr>
		
		<div class = "panel panel-default">
			<div class = "panel-heading">결과</div>
			<div class = "panel-body" id = "result"></div>
		</div>
		
	</div>
</body>
</html>