<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<div id="header">
	<ul>
		<li>Home</li>
		<li><a href="../auth/login.jsp">Auth</a></li>
		<!-- 절대경로 -->
		<li><a href="../code/index.jsp">Code</a></li>
		<li>
		<% if(session.getAttribute("auth")==null) {%>
		Guest
		<%}else{ %>
		<%= session.getAttribute("name") %>(<%= session.getAttribute("auth") %>)
		<%} %>
		</li>
	</ul>
</div>