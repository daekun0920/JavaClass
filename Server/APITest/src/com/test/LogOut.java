package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/logout.do")
public class LogOut extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.check(req, resp);
		
		req.getSession().setAttribute("id", null);
		req.getSession().setAttribute("name", null);
		req.getSession().setAttribute("naver_seq", null);

		// "/" -> WebContent
		RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
		dispatcher.forward(req, resp);

	}

}

