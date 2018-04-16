package com.test.mvc.address;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Add extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
	
		
		// 1. 업무 없음
		
		// 2. JSP 호출하기 
		// "/" : WebContent 폴더
		
		// do 404 오류 -> web.xml 
		// jsp 404 오류 -> 서블릿 RequestDispatcher 문제
		RequestDispatcher dispatcher = req.getRequestDispatcher("/address/add.jsp");
		dispatcher.forward(req, resp);
		
	}
	
}
