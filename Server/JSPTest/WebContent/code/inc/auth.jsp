<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%

	if (session.getAttribute("auth") == null) {
		

%>
<script>
	alert("회원만 접근 가능합니다.");
	location.href = "index.jsp";
</script>
<%
	
	// 페이지 작성 작업을 여기서 중단(위에서 alert이 떴을때 동시에 엔터와 ESC를 누르면 작업이 중단되고 회원만 보는페이지를 볼 수 있어서)
	out.close();
}

%>