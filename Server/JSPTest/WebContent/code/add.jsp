<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page import = "java.sql.*" %>
<%@ page import = "com.test.jsp.code.DBUtil" %>
<%@ include file = "inc/auth.jsp" %>
<%

// add.jsp
// 1. DB 작업(SELECT)
// 2. 1의 결과를 사용해서 <option> 태그 만들기

Connection conn = null;
Statement stat = null;
ResultSet rs = null;

conn = DBUtil.open();
stat = conn.createStatement();

String sql = "SELECT * FROM tblCategory ORDER BY name ASC";

rs = stat.executeQuery(sql);

%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>코드</title>
<%@ include file = "inc/asset.jsp" %>
<style>
	#category {
		width:200px;
	}

	#content, #code {
		height:200px;
		resize:none;
	}
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
	<!-- add.jsp -->
	<div id = "main">
		<%@ include file = "inc/header.jsp" %>
		<div id = "container">
			<h2 class = "page-header">코드 쓰기</h2>
			<form method = "post" action = "addok.jsp" enctype = "multipart/form-data">
				<table id = "tbl1" class = "table table-striped">
					<tr>
						<td>
							<select name = "category" id = "category" class = "form-control">
								<% while (rs.next()) { %>
								
									<option value = "<%= rs.getString("seq") %>">
										<%= rs.getString("name") %>
									</option>
									
								<% } %>
							</select>
						</td>
					</tr>
					<tr>
						<td><input type = "text" name = "subject" id = "subject" class = "form-control" required placeholder = "제목을 입력하세요."></td>
					</tr>
					<tr>
						<td><textarea name = "content" id = "content" class = "form-control" required placeholder = "설명을 작성하세요."></textarea></td>
					</tr>
					<tr>
						<td><textarea name = "code" id = "code" class = "form-control" required placeholder = "코드를 작성하세요."></textarea></td>
					</tr>
					
					<tr>
						<td><input type = "file" name = "attach" id = "attach" class = "form-control"></td>
					</tr>
				</table>
				<div id = "btns">
					<input type = "button" value = "돌아가기" class = "btn btn-default" onclick = "location.href='list.jsp';">
					<input type = "submit" value = "등록하기" class = "btn btn-primary">	
				</div>
			</form>
		</div>
		<%@ include file = "inc/footer.jsp" %>
	</div>
	
	
	
</body>
</html>

<%


rs.close();
stat.close();
conn.close();


%>