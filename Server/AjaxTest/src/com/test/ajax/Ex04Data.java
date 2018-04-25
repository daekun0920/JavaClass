package com.test.ajax;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex04data.do")
public class Ex04Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//DB 작업 완료
		Random rnd = new Random();//select count(*)..
		
		req.setAttribute("num", rnd.nextInt(100) + 1);

		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/ajax/ex04data.jsp");
		dispatcher.forward(req, resp);

	}

}




