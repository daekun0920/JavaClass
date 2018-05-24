package com.enter.management;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Check {

	public void authcheck(String key, HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int result = 0;
		
		if (key.equals("staff")) {
				if (req.getSession().getAttribute("staff_seq") != null) {
					
				return;
					
				}
				result = 0;
		} else if (key.equals("member")) {
			if (req.getSession().getAttribute("auth") != null) {
				
				return;
					
				}
				result = 0;
		}
		
		
		
		
		
		if (result == 0) {
			
			RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/company/check.jsp");
			dispatcher.forward(req, resp);
			return;
		}
		
	}

}
