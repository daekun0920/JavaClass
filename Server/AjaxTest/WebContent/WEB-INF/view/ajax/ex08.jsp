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


		$("#btn1").click(function() {


			// jQuery 사용해서 ajax 요청 ~ 응답
			$.ajax({
				type:"GET", // 메소드 방식
				url:"/ajax/ex08data.do", // 요청 URL
				dataType:"text",
				success: function(result) {
					
					$("#result").text(result);
					
				}, // 성공 콜백 함수
				error: function() {
					alert("error");
				} // 실패 콜백 함수(try catch 문)
			});
	
		});

		$("#btn2").click(function() {


			// jQuery 사용해서 ajax 요청 ~ 응답
			$.ajax({
				type : "GET",
				url: "/ajax/ex08data.do",
				success: function(result) {

					$("#result").text(result);

				}
			});
	
		});

		$("#btn3").click(function() {


			// jQuery 사용해서 ajax 요청 ~ 응답
			$.ajax({
				type : "POST",
				url: "/ajax/ex08data.do",
				success: function(result) {

					$("#result").text(result);

				}
			});
	
		});


		
		$("#btn4").click(function() {


			// jQuery 사용해서 ajax 요청 ~ 응답
			$.ajax({
				type : "GET",
				url: "/ajax/ex08data.do",
				data: "id=hong&age=20",
				success: function(result) {

					$("#result").text(result);

				}
			});
	
		});

		
		$("#btn5").click(function() {


			// jQuery 사용해서 ajax 요청 ~ 응답
			$.ajax({
				type : "POST",
				url: "/ajax/ex08data.do",
				data:"id=test&age=25",
				success: function(result) {

					$("#result").text(result);

				}
			});
	
		});


		$("#btnSend").click(function() {

			// 폼 전송(X) -> Ajax 전송(O)
			
			// var data = "name=" + $("#name").val() + "&id=" + $("#id").val() + "&age=" + $("#age").val() + "&tel=" + $("#tel").val() + "&intro=" + $("#intro").val();
			
			
			// 반드시 <form> 태그 존재 <- jQuery 기능
			var data = $("#form1").serialize(); // 직렬화 (name이 있는 것들만)
			///////////////////////////////////
			
			alert(data);
			
			//alert(data);
			
			$.ajax ({
				type:"POST",
				url:"/ajax/ex08data.do",
				data: data,
				success: function(result) {
					if (result == "1") {
						alert("가입 성공");
					} else {
						alert("가입 실패");
					}
				}

			});
				

		});
		
	});
	
</script>
</head>
<body>
	<div class = "container">
		<h2 class = "page-header">페이지 요청</h2>
		<input type = "button" value = "jQuery 방식" id = "btn1" class = "btn btn-default">
		<input type = "button" value = "1. GET 요청" id = "btn2" class = "btn btn-default">
		<input type = "button" value = "2. POST 요청" id = "btn3" class = "btn btn-default">
		
		<input type = "button" value = "3. GET 요청 + 데이터 전송" id = "btn4" class = "btn btn-default">
		<input type = "button" value = "4. POST 요청 + 데이터 전송" id = "btn5" class = "btn btn-default">
				
		<hr>
		<div id = "result" class = "well">결과</div>
		
		<h2 class = "page-header">회원 가입</h2>
		
		<form id = "form1">
			<table class = "table table-bordered">
				<tr>
					<th>이름</th>
					<td><input type = "text" name = "name" id = "name" class = "form-control"></td>
				</tr>
				<tr>
					<th>아이디</th>
					<td><input type = "text" name = "id" id = "id" class = "form-control"></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type = "text" name = "age" id = "age" class = "form-control"></td>
				</tr>
				<tr>
					<th>전화번호</th>
					<td><input type = "text" name = "tel" id = "tel" class = "form-control"></td>
				</tr>
				<tr>
					<th>자기소개</th>
					<td><input type = "text" name = "intro" id = "intro" class = "form-control"></td>
				</tr>
			</table>
			<input type = "button" id = "btnSend" value = "가입하기" class = "btn btn-default">
		</form>
		
	</div>
</body>
</html>