package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/main.do")
public class Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.check(req, resp);

		// "/" -> WebContent
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/main.jsp");
		dispatcher.forward(req, resp);

	}

}
