package com.enter.management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/management/addoffer.do")
public class AddOffer extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		
		check.authcheck("staff", req, resp);
		
		String seq = req.getParameter("art_seq");
		String type = req.getParameter("type");
		
		// "/" -> WebContent
		req.setAttribute("art_seq", seq);
		req.setAttribute("type", type);
		
		req.getSession().setAttribute("auth", "1"); // 테스트 용
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/management/addoffer.jsp");
		dispatcher.forward(req, resp);

	}

}
