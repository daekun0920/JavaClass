<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <% 
 
 /* <jsp:param name = "mode" value = "0"> */
 String mode = request.getParameter("mode");
 String title = "";
 
 
 if (mode.equals("0")) title = "Home";
 else if (mode.equals("1")) title = "Board";
 else if (mode.equals("2")) title = "Administrator";
 
 
 %>
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
					<li><a href = "index.jsp">Home</a></li>
					<li><a href = "board.jsp">Board</a></li>
					<li><a href = "admin.jsp">Administrator</a></li>
					<li><a href = "#">Info</a></li>
				</ul>
			</div>
		</nav>
	</header>
	
	<h2 class = "page-header"><%= title %> <small><i>This is <%= title %> page</i></small></h2>
	
	<script>

	$(".nav.navbar-nav li").eq(<%= mode %>).addClass("active");
	
	</script>