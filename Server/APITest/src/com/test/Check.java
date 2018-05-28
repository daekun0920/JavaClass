package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Check {
	
		public void check(HttpServletRequest req, HttpServletResponse resp) {

		if (req.getSession().getAttribute("id") == null) {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/index.jsp");
			try {
				dispatcher.forward(req, resp);
			} catch (ServletException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		} 	
	}

}
