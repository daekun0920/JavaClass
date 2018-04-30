package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex12.do")
public class Ex12 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//hr.emplyees, hr.deparments 출력
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<DepartmentDTO> list = dao.listDepartment();
		
		req.setAttribute("list", list);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/ajax/ex12.jsp");
		dispatcher.forward(req, resp);

	}

}


