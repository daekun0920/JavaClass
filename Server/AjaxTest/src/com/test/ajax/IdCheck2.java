package com.test.ajax;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
@WebServlet("/idcheck2.do")
public class IdCheck2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		//아이디 중복검사
		String id = req.getParameter("id");
		
		AjaxDAO dao = new AjaxDAO();
		
		int result = dao.getIdCheck(id);
		
		req.setAttribute("result", result);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/ajax/idcheck2.jsp");
		dispatcher.forward(req, resp);

	}
	

}







