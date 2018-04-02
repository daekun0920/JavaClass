package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex03_Receive extends HttpServlet {
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		
		// 데이터 수신
		String id = req.getParameter("id"); // <input type = "text" name = "id">
		String age = req.getParameter("age"); // <input type = "text" name = "age">
		
		
		PrintWriter writer = resp.getWriter();
		
		writer.println("<html>");
		writer.println("<body>");
		writer.println("<h1>ID</h1>");
		writer.println(id);
		writer.println("<h1>Age</h1>");
		writer.println(age);
		writer.println("</body>");
		writer.println("</html>");
		
		
		
	}
	
	
}
