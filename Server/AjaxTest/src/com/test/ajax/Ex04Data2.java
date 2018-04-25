package com.test.ajax;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex04data2.do")
public class Ex04Data2 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		//DB 작업 완료
		Random rnd = new Random();//select count(*)..
		
		PrintWriter writer = resp.getWriter();
		writer.print(rnd.nextInt(100) + 1);
		writer.close();

	}

}








