package com.enter.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.company.model.CompanyDAO;
import com.enter.management.Check;

@WebServlet("/company/delnotice.do")
public class DelNotice extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.authcheck("staff", req, resp);
		
		
		String seq = req.getParameter("seq");
		String staff = req.getParameter("staff_seq");
		
		CompanyDAO dao = new CompanyDAO();
		
		int result = 0;
		
		if (req.getSession().getAttribute("staff_seq").equals(staff)) {
			result = dao.delNotice(seq);
		} else {
			result = 0;
		}
		
		req.setAttribute("result", result);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/company/delnotice.jsp");
		dispatcher.forward(req, resp);

	}

}
