<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

// 세션값 저장하기
session.setAttribute("data", "홍길동");
session.setAttribute("result", true);

String[] list = {"하나", "둘", "셋"};
session.setAttribute("list", list);

%>

<script>
	alert("세션값 저장 완료!");
	location.href = "ex26_session.jsp";
</script>

<%

//response.sendRedirect("ex26_session.jsp");

%>