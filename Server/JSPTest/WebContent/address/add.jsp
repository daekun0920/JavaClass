<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%





%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>주소록</title>
<%@ include file = "inc/asset.jsp" %>
<%-- <jsp:include page = "inc/asset.jsp"></jsp:include> --%>
<style>
	
	#tbl1 {
		width:550px;
		margin:0px auto;
	}
	
	#tbl1 th {
		width:150px;
		background:#eee;
	}
	
	#tbl1 td {
		width:400px;
	}
	
	.short {
		width:120px;
	}
	
	.middle {
		width:250px;
	}
	
</style>
<script>
	//$(document).ready(function() {
	//	
	//});
	
	// 줄임 표현
	$(function() {
		dummy();
	});

	function dummy() {
		$("#name").val("홍길동");
		$("#age").val("20");
		$("#gender").val("m");
		$("#tel").val("010-2020-2020");
		$("#address").val("서울시 강남구 역삼동");
		
	}
</script>
</head>
<body>
	<!--  -->
	<div id = "main">
		<%@ include file = "inc/header.jsp" %>
		<section id = "section">
			
			<h2>주소록 추가하기</h2>
			
			<hr>
			<form method = "post" action = "addok.jsp">
				<table id = "tbl1" class = "table table-bordered">
					<tr>
						<th>이름</th>
						<td><input type = "text" name = "name" id = "name" class = "form-control short" required></td>
					</tr>
					<tr>
						<th>나이</th>
						<td><input type = "number" name = "age" id = "age" class = "form-control short" required></td>
					</tr>
					<tr>
						<th>성별</th>
						<td>
							<select name = "gender" id = "gender" class = "form-control short">
								<option value = "m">남자</option>
								<option value = "f">여자</option>
							</select>
						</td>
					</tr>
					<tr>
						<th>전화</th>
						<td>
							<input type = "text" name = "tel" id = "tel" class = "form-control middle" required>
						</td>
					</tr>
					<tr>
						<th>주소</th>
						<td>
							<input type = "text" name = "address" id = "address" class = "form-control" required>
						</td>
					</tr>
				</table>
				<div id = "btns">
					<button type = "button" class = "btn btn-default" onclick = "location.href = 'list.jsp';">
						<span style = "color:#444;" class = "glyphicon glyphicon-pencil"></span>
						돌아가기
					</button>
					<button type = "submit" class = "btn btn-primary">
						<span class = "glyphicon glyphicon-pencil"></span>
						추가하기
					</button>
					
				</div>
			</form>
		</section>
		<%@ include file = "inc/footer.jsp" %>
	</div>
</body>
</html>