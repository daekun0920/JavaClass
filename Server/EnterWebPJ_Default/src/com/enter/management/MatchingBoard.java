package com.enter.management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.management.model.ManagementDAO;
import com.enter.management.model.StaffDTO;

@WebServlet("/management/matchingboard.do")
public class MatchingBoard extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.authcheck("staff", req, resp);
		
		String star = req.getParameter("star");
		String type = req.getParameter("type");

		
		ManagementDAO dao = new ManagementDAO();
		
		ArrayList<StaffDTO> list = dao.getStaffs();
		
		
		req.setAttribute("star", star);
		req.setAttribute("type", type);
		req.setAttribute("list", list);
		
		
		// "/" -> WebContent
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/management/matchingboard.jsp");
		dispatcher.forward(req, resp);

	}

}
