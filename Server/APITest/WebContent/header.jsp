 <%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
 <div id = "header">
		<div id = "menu_head">
			<span class = "opts"><a class ="opt" href = "/APITest/main.do">Home</a></span>
			<span class = "opts"><a class ="opt" href = "/APITest/board.do">Board</a></span>
			<span class = "opts"><a class ="opt" href = "/APITest/chat.do">Chat</a></span>
		</div>
	 	<div style = "position:absolute;right:0;top:0;display:inline-block;margin-top:25px;">${name} 님 환영합니다. <a href = "/APITest/logout.do" class = "btn btn-danger" style = "font-size:10px;margin-right:10px;">로그아웃</a></div>
</div>