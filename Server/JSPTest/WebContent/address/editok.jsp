<%@page import="com.test.jsp.address.DBUtil"%>
<%@page import="java.sql.PreparedStatement"%>
<%@page import="java.sql.Connection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// editok.jsp
// 1. 데이터 가져오기
// 2. DB 연결 + UPDATE 작업 // JDBC 작업
// 3. 결과 출력 


// 1. 데이터 가져오기 -> post + 한글
request.setCharacterEncoding("UTF-8");

String seq = request.getParameter("seq");
String name = request.getParameter("name");
String age = request.getParameter("age");
String gender = request.getParameter("gender");
String tel = request.getParameter("tel");
String address = request.getParameter("address");


// 2. DB 연결 + insert 작업
Connection conn = null;

PreparedStatement stat = null;

int result = 0;

try {
conn = DBUtil.open(); // DB 접속 -> JSP에서 DB 예외 던지기를 해준다(try/catch 필요없음)

String sql = "UPDATE tbladdress SET name = ?, age = ?, gender = ?, tel = ?, address = ? WHERE seq = ?";

stat = conn.prepareStatement(sql);

stat.setString(1, name);
stat.setString(2, age);
stat.setString(3, gender);
stat.setString(4, tel);
stat.setString(5, address);
stat.setString(6, seq);		

	result = stat.executeUpdate(); // 결과(0, 1)

stat.close();
conn.close();
		
} catch (Exception e) {
	
	result = 0;
	
}
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
	<%-- 	
		<% if (result == 1) { %>
			alert("등록이 완료 되었습니다.");
			location.href = "list.jsp";
		<% } else {%>
			alert("등록을 실패했습니다.");
			history.back();
		<% } %> 
	--%>
	});
</script>
</head>
<body>
	<!-- editok.jsp -->
	<div id = "main">
		<%@ include file = "inc/header.jsp" %>
		<section id = "section">
			<div class = "panel panel-default">
				<div class = "panel-heading">결과</div>
				<div class = "panel-body">
				<% if (result == 1) {%>
					<div>수정이 완료되었습니다.</div>
					<div><a href = "list.jsp">목록으로 이동하기</a></div>
				<% } else {%>
					<div>수정을 실패하였습니다.</div>
					<div><a href = "#" onclick = "history.back();">이전 페이지로 돌아가기</a></div>
				<% }%>
				</div>
			</div>
		</section>
		<%@ include file = "inc/footer.jsp" %>
	</div>
</body>
</html>