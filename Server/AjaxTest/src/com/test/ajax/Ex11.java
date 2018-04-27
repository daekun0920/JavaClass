package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex11.do")
public class Ex11 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// ex11.do?page=1
		// ex11.do
		String page = req.getParameter("page");
		
		if (page == null) {
			page = "1";
		}
		
		
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<BoardDTO> list = dao.listBoard(page);
		
		
		req.setAttribute("list", list);
		req.setAttribute("page", page);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/ajax/ex11.jsp");
		dispatcher.forward(req, resp);

	}

}
