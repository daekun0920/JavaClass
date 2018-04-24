package com.test.mvc.board;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class Check {
	
	public void isauth(HttpServletRequest req, HttpServletResponse resp) throws IOException {
		
		// 현재 접속중인 유저의 session 객체가 필요?
		HttpSession session = req.getSession();
		
		if (session.getAttribute("auth") == null) {
			//resp.sendRedirect("/mvc/index.do");
			resp.getWriter().println("<script>location.href='/index.do';</script>");
			resp.getWriter().close();
		}
		
	}
	
}
