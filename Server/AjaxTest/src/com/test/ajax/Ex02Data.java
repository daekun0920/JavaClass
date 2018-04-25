package com.test.ajax;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex02data.do")
public class Ex02Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//설문 조사 결과 가져오기
		AjaxDAO dao = new AjaxDAO();
		
		String seq = "1";
		ResearchDTO dto = dao.getResearch(seq);
		
		req.setAttribute("dto", dto);	

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/ajax/ex02data.jsp");
		dispatcher.forward(req, resp);

	}

}

