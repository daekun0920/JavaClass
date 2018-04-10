<%@page import="com.test.jsp.address.DBUtil"%>
<%@page import="java.sql.*"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


// 1. 데이터 가져오기(seq)
// 2. DB 작업(select .. where seq = 10)
// 3. 결과를 각각의 컨트롤에 기본값으로 출력

// 1. 
String seq = request.getParameter("seq");


// 2.
Connection conn = null;
Statement stat = null;
ResultSet rs = null;

conn = DBUtil.open();
stat = conn.createStatement();

String sql = "SELECT * FROM tbladdress WHERE seq = " + seq;

rs = stat.executeQuery(sql);


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
		init();
	});

	function init() {
		<% if (rs.next()) { %>
			$("#name").val("<%= rs.getString("name") %>");
			$("#age").val("<%= rs.getString("age") %>");
			$("#gender").val("<%= rs.getString("gender") %>");
			$("#tel").val("<%= rs.getString("tel") %>");
			$("#address").val("<%= rs.getString("address") %>");
		<% } %>
	}
</script>
</head>
<body>
	<!--  -->
	<div id = "main">
		<%@ include file = "inc/header.jsp" %>
		<section id = "section">
			
			<h2>주소록 수정하기</h2>
			
			<hr>
			<form method = "post" action = "editok.jsp">
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
						수정하기
					</button>
					
				</div>
				
				<input type = "hidden" name = "seq" value = "<%= seq %>">
			</form>
		</section>
		<%@ include file = "inc/footer.jsp" %>
	</div>
</body>
</html>


<%

rs.close();
stat.close();
conn.close();

%>