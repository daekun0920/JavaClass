package com.enter.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.management.Check;

@WebServlet("/company/addnotice.do")
public class AddNotice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		
		Check check = new Check();
		check.authcheck("staff", req, resp);
		
		
		

		// "/" -> WebContent
		
		req.setAttribute("seq", req.getSession().getAttribute("staff_seq"));
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/company/addnotice.jsp");
		dispatcher.forward(req, resp);

	}

}
