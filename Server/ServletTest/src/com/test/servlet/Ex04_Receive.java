package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex04_Receive extends HttpServlet {
	
	// 이 서블릿을 부른 페이지가 
	// method = "get" -> doGet
	// method = "post" -> doPost()
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {

		// 1. 넘어온 데이터를 가져오기
		String type = req.getParameter("type");
		int count = Integer.parseInt(req.getParameter("count"));
		
		// 2. 위의 데이터를 사용해서 동적으로 이미지가 들어있는 페이지 생성
		resp.setCharacterEncoding("UTF-8");
		PrintWriter writer = resp.getWriter();
		
		writer.println("<!DOCTYPE html>\r\n" + 
				" <html>\r\n" + 
				" <head>\r\n" + 
				" <meta charset='UTF-8'>\r\n" + 
				" <title>Insert title here</title>\r\n" + 
				" <style>\r\n" + 
				" 	#box {\r\n" + 
				" 		border:10px solid yellow;\r\n" + 
				" 		padding:20px;\r\n" + 
				" 	}\r\n" + 
				" 	\r\n" + 
				" 	#box img {\r\n" + 
				" 		display:inline-block; margin:10px;\r\n" + 
				" 	}\r\n" + 
				" </style>\r\n" + 
				" </head>\r\n" + 
				" <body>\r\n" + 
				"	<h1>고양이 분양</h1>\r\n" + 
				"	\r\n" + 
				"	<div id = \"box\">\r\n");
				
				for (int i = 0; i < count; i++) {
		
					writer.printf("<img src=\"/ServletTest/images/%s\">\r\n", type); 
		
				}
				writer.println("</div>\r\n" + 
				"	\r\n" + 
				" </body>\r\n" + 
				" </html>");
		
		writer.close();
	}

}
