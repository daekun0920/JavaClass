<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

if(session.getAttribute("auth")==null){
%>
<script>
	alert("회원만 접근 가능합니다.");
	location.href="index.jsp";
</script>	
<%
	//페이지 작성 작업을 여기서 중단
	out.close();
}
%>