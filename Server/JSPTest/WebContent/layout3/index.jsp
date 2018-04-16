<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// index.jsp
// index.jsp?mode=1

String mode = request.getParameter("mode");


if (mode == null || mode == "") {
	mode = "0";
}

String url = "";
String title = "";

if (mode.equals("0")) {
	url = "home.jsp";
	title = "Home";
	
}  else if (mode.equals("1")) {
	url = "board.jsp";
	title = "Board";
	
} else if (mode.equals("2")) {
	url = "admin.jsp";
	title = "Admin";
	
}


%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/js/bootstrap.min.js"></script>
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
	<!-- index.jsp -->
	<div class = "container">
	<header>
		<nav class = "navbar navbar-default">
			<div class = "container-fluid">
				<div class = "navbar-header">
					<a class = "navbar-brand" href = "#">
						<span class = "glyphicon glyphicon-blackboard"></span>
						Code Project
					</a>
				</div>
				<ul class = "nav navbar-nav">
					<li><a href = "index.jsp?mode=0">Home</a></li>
					<li><a href = "index.jsp?mode=1">Board</a></li>
					<li><a href = "index.jsp?mode=2">Administrator</a></li>
					<li><a href = "#">Info</a></li>
				</ul>
			</div>
		</nav>
	</header>
	

	
	<h2 class = "page-header"><%= title %> <small><i>This is <%= title %> page</i></small></h2>
	
	<jsp:include page = '<%= "content/" + url %>'></jsp:include>
	
	</div>
	
</body>
</html>