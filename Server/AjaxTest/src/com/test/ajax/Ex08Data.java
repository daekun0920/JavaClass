package com.test.ajax;

import java.io.IOException;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex08data.do")
public class Ex08Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
	
		process(req, resp);
		
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		process(req, resp);
			
	}
	
	private void process(HttpServletRequest req, HttpServletResponse resp)  throws ServletException, IOException  {
		// TODO Auto-generated method stub
		String id = req.getParameter("id");
		String age = req.getParameter("age");
		String name = req.getParameter("name");
		String tel = req.getParameter("tel");
		String intro = req.getParameter("intro");
		
		
		Random rnd = new Random();
		
		System.out.println(id);
		System.out.println(age);
		System.out.println(name);
		System.out.println(tel);
		System.out.println(intro);
		
		
		//resp.getWriter().print(rnd.nextInt(100) + id + age);
		resp.getWriter().print(1);
		
		resp.getWriter().close();
	}
}
