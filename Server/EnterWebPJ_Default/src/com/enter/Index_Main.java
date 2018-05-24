package com.enter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.enter.company.model.CompanyDAO;
import com.enter.company.model.NoticeDTO;

@WebServlet("/index_main.do")
public class Index_Main extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		CompanyDAO dao = new CompanyDAO();
		
		ArrayList<NoticeDTO> list = dao.getIndexNotice();
		
		
		
		req.setAttribute("list", list);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/index_main.jsp");
		dispatcher.forward(req, resp);

	}

}
