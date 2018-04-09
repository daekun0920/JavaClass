<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
    

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
<style>
	body {
		padding:30px;
	}
</style>
<script>
	//$(document).ready(function() {
	//	
	//});
	
	// 줄임 표현
	$(function() {
		$("#border").hide();

		$("#isborder").change(function() {
			if ($(this).val() == "n") {
				$("#border").hide();
			} else {
				$("#border").show();
			}
				
		});
		
	});
</script>
</head>
<body>
	<!--  -->
	<h1>버튼 만들기</h1>
	
	<form method = "post" action = "<%= request.getContextPath() %>/ex08_request_process.jsp"> <!-- 실무에선 이렇게 절대경로 작성 -> 컨텍스트 패스가 바뀌어도 자동 적용 된다. (웹 경로이지 파일 경로 아님) -->
		<table style = "width:400px;" class = "table table-striped">
			<tr>
				<th style = "width:100px;">버튼 너비</th>
				<td style = "width:300px;"><input type = "number" name = "width" min = "100" max = "1000" step = "10" value = "100" required>px</td>
			</tr>
			<tr>
				<th style = "width:100px;">버튼 높이</th>
				<td style = "width:300px;"><input type = "range" name = "height" min = "25" max = "500" value = "25" required></td>
			</tr>
			<tr>
				<th style = "width:100px;">버튼 텍스트</th>
				<td style = "width:300px;"><input type = "text" name = "txt" value = "Button"></td>
			</tr>
			<tr>
				<th style = "width:100px;">글자색</th>
				<td style = "width:300px;"><input type = "color" name = "forecolor"></td>
			</tr>
			<tr>
				<th style = "width:100px;">배경색</th>
				<td style = "width:300px;"><input type = "color" name = "backgroundcolor"></td>
			</tr>
			<tr>
				<th style = "width:100px;">글자 크기</th>
				<td style = "width:300px;"><input type = "number" name = "fontsize" max = "100" value = "9"></td>
			</tr>
			<tr>
				<th style = "width:100px;">테두리</th>
				<td style = "width:300px;">
					<select name = "isborder" id = "isborder">
						<option value = "n">hidden</option>
						<option value = "y">visible</option>
					</select>
				</td>
			</tr>
			<tr id = "border">
				<th style = "width:100px;">테두리 설정</th>
				<td style = "width:300px;">
					<div>
						두께 : <input type = "number" name = "borderwidth" min = "1" max = "100" value = "1">
					</div>
					<div>
						색상 : <input type = "color" name = "bordercolor" value = "#000000">
					</div>
					<div>
						스타일 :
						<select name = "borderstyle">
							<option value = "solid">실선</option>
							<option value = "dashed">쇄선</option>
							<option value = "dotted">점선</option>
							<option value = "inset">인셋</option>
							<option value = "outset">아웃셋</option>
						</select>
					</div>
					<div>
						모서리 : <input type = "number" name = "borderradius" min = "0" max = "50">
					</div>
				
				</td>
			</tr>
			<tr>
				<th style = "width:100px;">버튼 갯수</th>
				<td style = "width:300px;">
					<input type = "number" name = "count" min = "1" max = "100" value = "1"> 개 
				</td>
			</tr>
		</table>
		<hr style = "width:400px;" align = "left">
		<input type = "submit" value = "만들기" class = "btn btn-default">
	</form>
	
</body>
</html>