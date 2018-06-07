<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "tiles" uri = "http://tiles.apache.org/tags-tiles" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title></title>

<%-- <%@ include file="/WEB-INF/views/inc/asset.jsp" %> --%>
<tiles:insertAttribute name = "asset"></tiles:insertAttribute>

</head>
<body>
	<!-- info.jsp -->

	<div class="container">

		<%-- <%@ include file="/WEB-INF/views/inc/mainmenu.jsp" %> --%>
		<tiles:insertAttribute name = "mainmenu"></tiles:insertAttribute>

		<%-- <%@ include file="/WEB-INF/views/inc/membersubmenu.jsp" %> --%>
		<tiles:insertAttribute name = "membersubmenu"></tiles:insertAttribute>

		<!-- 	<div id="content">
			<h2 class="page-header">회원 > 자기 정보</h2>
		
		</div> 
		-->
		<tiles:insertAttribute name = "info"></tiles:insertAttribute>
		
		<div style="clear: both;"></div>
	</div>
	<!-- containter -->

</body>
</html>


























