package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Ex04_Send extends HttpServlet {

	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
		throws ServletException, IOException {
		
		resp.setCharacterEncoding("UTF-8"); // 인코딩 변환
		
		// 사용자로부터 고양이 마릿수를 입력
		PrintWriter writer = resp.getWriter();
		
		writer.println("<!DOCTYPE html>\r\n" + 
					" <html>\r\n" + 
					" <head>\r\n" + 
					" <meta charset='UTF-8'>\r\n" + 
					" <title>Insert title here</title>\r\n" + 
					" </head>\r\n" + 
					" <body>\r\n" + 
					" 	<h1>고양이</h1>\r\n" + 
					" 	\r\n" + 
					" 	<form method = 'post' action = '/ServletTest/ex04_receive.do'>\r\n" + 
					" 		<div>\r\n" + 
					" 			<label>종류 : </label>\r\n" + 
					" 			<select name = 'type'>\r\n" + 
					" 				<option value = 'catty01.png'>타입1</option>\r\n" + 
					" 				<option value = 'catty02.png'>타입2</option>\r\n" + 
					" 				<option value = 'catty03.png'>타입3</option>\r\n" + 
					" 				<option value = 'catty04.png'>타입4</option>\r\n" + 
					" 				<option value = 'catty05.png'>타입5</option>\r\n" + 
					" 			</select>\r\n" + 
					" 		</div>\r\n" + 
					" 		<div>\r\n" + 
					" 			<lable>마리 : </lable>\r\n" + 
					" 			<input type = 'number' name = 'count' min = '1' max = '10' required>\r\n" + 
					" 		</div>\r\n" + 
					" 		<div>   \r\n" + 
					" 			<input type = 'submit' value = '고양이 분양받기'>\r\n" + 
					" 		</div>   \r\n" + 
					" 	</form>\r\n" + 
					" </body>\r\n" + 
					" </html>                   ");
		
		writer.close();
				
	}
	
	
}
