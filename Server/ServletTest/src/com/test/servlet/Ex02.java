package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// 1.
public class Ex02 extends HttpServlet {
	
	// 2.
//	public void doGet(HttpServletRequest request, HttpServletResponse response) 
//		throws IOException, ServletException{
//		
//		// 3.
//		PrintWriter writer = response.getWriter();
//		
//		
//		
//		
//	}
	
	// 2.
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>구구단</title>");
		writer.println("<meta charset='UTF-8'");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>구구단 - 5단</h1>");
		
		for (int i = 1; i <= 9; i++) {
			writer.printf("<div>5 x %d = %d</div>\n", i, 5 * i);
		}
		
		writer.println("</body>");
		writer.println("</html>");
		
		writer.close();
		
		
		System.out.println("doGet() 호출");
		
	}
	
	@Override
	public void init() throws ServletException {
		super.init();
		System.out.println("init() 호출");
	}
	
	@Override
	protected void service(HttpServletRequest arg0, HttpServletResponse arg1) 
		throws ServletException, IOException {
		System.out.println("service() 호출전");
		super.service(arg0, arg1);
		System.out.println("service() 호출후");
	}
	
}
