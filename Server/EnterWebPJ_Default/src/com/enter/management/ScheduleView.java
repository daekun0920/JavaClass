package com.enter.management;

import java.io.IOException;


import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/management/scheduleview.do")
public class ScheduleView extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.authcheck("staff", req, resp);
		
		
		String art_seq = req.getParameter("art_seq");
		String name = req.getParameter("name");
		String type = req.getParameter("type");
			
		
		req.setAttribute("art_seq", art_seq);
		req.setAttribute("name", name);
		req.setAttribute("type", type);
		
		// "/" -> WebContent
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/management/schedule_view.jsp");
		dispatcher.forward(req, resp);

	}

}
