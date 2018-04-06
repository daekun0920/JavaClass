<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%


// 세션내의 속성값 삭제(모든 내장 객체 동일)
// - removeAttribute()

session.removeAttribute("data");
session.removeAttribute("result");
session.removeAttribute("list");


%>


<script>
	alert("세션 데이터 삭제!");
	location.href = "ex26_session.jsp";
	// history.back(); /* 새로운 페이지 요청이아니라 아까 보았던 페이지를 그대로 다시 보여주는것 */
	
</script>