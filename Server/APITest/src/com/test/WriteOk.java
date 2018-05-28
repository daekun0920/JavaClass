package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.TestDAO;

@WebServlet("/writeok.do")
public class WriteOk extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.check(req, resp);
		
		req.setCharacterEncoding("UTF-8");
		
		String title = req.getParameter("title");
		String content = req.getParameter("content");
		
		TestDAO dao = new TestDAO();
		
		Integer seq = (Integer) req.getSession().getAttribute("naver_seq");
		
		int result = dao.write(title, content, seq);
		
		

		// "/" -> WebContent
		
		req.setAttribute("result", result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/writeok.jsp");
		dispatcher.forward(req, resp);

	}

}
