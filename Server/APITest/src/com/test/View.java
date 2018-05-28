package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.BoardDTO;
import com.test.model.TestDAO;

@WebServlet("/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.check(req, resp);
		
		String seq = req.getParameter("seq");
		
		TestDAO dao = new TestDAO();
		
		BoardDTO dto = dao.getView(seq);
		
		
		req.setAttribute("dto", dto);

		// "/" -> WebContent
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/view.jsp");
		dispatcher.forward(req, resp);

	}

}

