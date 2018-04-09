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
	<div id = "main">
		<%@ include file = "inc/header.jsp" %>
		<section id = "section">
			
			<h2>주소록 추가하기</h2>
			
			<table id = "tbl1" class = "table table-bordered">
				<tr>
					<th>이름</th>
					<td><input type = "text" name = "name" id = "name" class = "form-control" required></td>
				</tr>
				<tr>
					<th>나이</th>
					<td><input type = "number" name = "age" id = "age" class = "form-control" required></td>
				</tr>
				<tr>
					<th>성별</th>
					<td>
						<select name = "gender" id = "gender" class = "form-control">
							<option value = "m">남자</option>
							<option value = "f">여자</option>
						</select>
					</td>
				</tr>
				<tr>
					<th>전화</th>
					<td>
						<input type = "text" name = "tel" id = "tel" class = "form-control" required>
					</td>
				</tr>
				<tr>
					<th>주소</th>
					<td>
						<input type = "text" name = "address" id = "address" class = "form-control" required>
					</td>
				</tr>
			</table>
			
		</section>
		<%@ include file = "inc/footer.jsp" %>
	</div>
</body>
</html>