package com.enter.management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/management/schedulesearch.do")
public class ScheduleSearch extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.authcheck("staff", req, resp);
		

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/management/schedule_search.jsp");
		dispatcher.forward(req, resp);

	}

}
