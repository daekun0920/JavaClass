package com.test.mvc.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/add.do")
public class Add extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		Check check = new Check();
		check.isauth(req, resp);
		// 서블릿 작업 없음 > 나중에 생김
		
		// 자신을 새글쓰기? 답변글 쓰기?
		String mode = req.getParameter("mode");
		String thread = req.getParameter("thread");
		String depth = req.getParameter("depth");
				
		
		req.setAttribute("mode", mode);
		req.setAttribute("thread", thread);
		req.setAttribute("depth", depth);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/add.jsp");
		dispatcher.forward(req, resp);

	}

}
