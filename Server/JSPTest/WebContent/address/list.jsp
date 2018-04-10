<%@page import="java.sql.ResultSet"%>
<%@page import="com.test.jsp.address.DBUtil"%>
<%@page import="java.sql.Connection"%>
<%@page import="java.sql.Statement"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// list.jsp
// 1. DB 작업 -> SELECT 실행
// 2. 결과 출력(테이블 형식)

// 1. 
Connection conn = null;
Statement stat = null;
ResultSet rs = null;

conn = DBUtil.open();
stat = conn.createStatement();

String sql = "SELECT * FROM tbladdress ORDER BY name asc";

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
	.item {
		width:550px;
		margin:30px auto;
		border-collapse:separate;
	}
	
	.item tr:nth-child(1) td:nth-child(1) {
		width:150px;
		text-align:center;
		vertical-align:middle;
	}
	.item tr:nth-child(1) td:nth-child(2) {
		width:400px;
	
	}
	
	.item .btnspan {
		float:right;
		margin:0px 2px;
		color:#999;
		font-size:13px;
		cursor:pointer;
	}	
	
	.item .btnspan:hover {
		color:#444;
	}
</style>
<script>
	//$(document).ready(function() {
	//	
	//});
	
	// 줄임 표현
	$(function() {
		
	});

	//수정하기 버튼을 눌렀을때
	function edit(seq) {
		location.href = "edit.jsp?seq=" + seq;
	}

	//삭제하기 버튼을 눌렀을때
	function del(seq) {
		if (confirm("ㄹㅇ 삭제하시겠습니까?")) {
			location.href = "delok.jsp?seq=" + seq;
		}
	}
	
</script>
</head>
<body>
	<!-- list.jsp -->
	<div id = "main">
		<%@ include file = "inc/header.jsp" %>
		<section id = "section">
			
			<h2 class = "page-header">주소록 목록보기</h2>
			
			<!-- 1. 1명당 행 1개씩 -->
			
			<!-- 2. 1명당 테이블 1개씩 -->
		<%-- 	
		<table class = "table table-bordered">
				<tr>
					<th>이름</th>
					<th>나이</th>
					<th>성별</th>
					<th>전화번호</th>
					<th>주소</th>
				</tr>
				<% while(rs.next()) {%>	
					<tr>
						<td><%= rs.getString("name") %></td>
						<td><%= rs.getString("age") %></td>
						<td><%= rs.getString("gender") %></td>
						<td><%= rs.getString("tel") %></td>
						<td><%= rs.getString("address") %></td>
					</tr>
				<% } %>
		</table> 
		--%>
		<% while (rs.next()) { %>
		<table class = "item table table-bordered">
			<tr>
				<td rowspan ="4"><img src = "images/gender_<%= rs.getString("gender") %>.png"></td>
				<td><%= rs.getString("name") %>
					<span class = "btnspan" onclick = "del(<%= rs.getString("seq") %>);">[del]</span>
					<span class = "btnspan" onclick = "edit(<%= rs.getString("seq") %>);">[edit]</span>
				</td>
				
			</tr>
			<tr>
				<td><%= rs.getString("age") %></td>
			</tr>
			<tr>
				<td><%= rs.getString("tel") %></td>
			</tr>
			<tr>
				<td><%= rs.getString("address") %></td>
			</tr>
		</table>
		<% } %>
		
		
		<div id = "btns">
			<button type = "button" class = "btn btn-default" onclick = "location.href = 'add.jsp';">
				<span style = "color:#444;" class = "glyphicon glyphicon-pencil"></span>
				추가하기
			</button>
		</div>
		
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