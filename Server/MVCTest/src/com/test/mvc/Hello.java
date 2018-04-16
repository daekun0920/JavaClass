package com.test.mvc;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Hello extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 예전 서블릿
		// 1. 업무 처리
		// 2. PrintWriter
		// 3. HTML 코드 작성
		
		// MVC 서블릿
		// 1. 업무 처리
		// 2. JSP 호출하기
		
		// 서블릿 -> JSP 호출하기
		// : 경로를 항상 절대 경로로 표기한다.(권장)
		// resp.sendRedirect("hello.jsp"); // jsp 호출
		// pageContext.forward("hello.jsp");
		
		// 표준 도구 : MVC 패턴에서 서블릿이 JSP를 호출하는 용도
		// request에 값을 담아서 보냄
		RequestDispatcher dispatcher
			= req.getRequestDispatcher("hello.jsp");
		
		dispatcher.forward(req, resp); // pageContext.forward()와 동일한 역할
		
	}
	
	
}
