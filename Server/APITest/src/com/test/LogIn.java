package com.test;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.TestDAO;

@WebServlet("/login.do")
public class LogIn extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String id = (String)req.getSession().getAttribute("id");
		String name = (String)req.getSession().getAttribute("name");
		System.out.println(id + name + "login!!");
		TestDAO dao = new TestDAO();
		
		int result = dao.checknpush(id, name);
		
		
		
		
		// "/" -> WebContent
		
		req.setAttribute("id", id);
		req.setAttribute("name", name);
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/main.jsp");
		dispatcher.forward(req, resp);

	}

}
