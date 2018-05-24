package com.enter.company;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.company.model.CompanyDAO;
import com.enter.company.model.NoticeDTO;
import com.enter.management.Check;

@WebServlet("/company/view.do")
public class View extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		
		check.authcheck("member", req, resp);
		
		String seq = req.getParameter("seq");
		
		
		CompanyDAO dao = new CompanyDAO();
		
		dao.visitcount(seq);
		
		NoticeDTO dto = dao.getView(seq);
		
		
		
		
		// "/" -> WebContent
		
		req.setAttribute("view", dto);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/company/view.jsp");
		dispatcher.forward(req, resp);

	}

}
