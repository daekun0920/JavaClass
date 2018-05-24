package com.enter.management;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.management.model.ManagementDAO;

@WebServlet("/management/delschedule.do")
public class DelSchedule extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.authcheck("staff", req, resp);
		
		String seq = req.getParameter("seq");
		System.out.println(seq);
		ManagementDAO dao = new ManagementDAO();
		
		int result = dao.delSchedule(seq);
		
		resp.getWriter().println(result);
		resp.getWriter().close();

	}

}
