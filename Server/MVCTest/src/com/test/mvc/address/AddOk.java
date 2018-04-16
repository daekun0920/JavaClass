package com.test.mvc.address;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

// method = "post" action = "addok.do"
// Controller

public class AddOk extends HttpServlet {
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// Model 1
		// Model 2(=MVC)
		
		// MVC
		// 1. Model : DTO(DAO)
		// 2. View : JSP
		// 3. Controller : Servlet
		
		// 1. 데이터 가져오기
		
		// 2. DAO 위임(INSERT)
		
		// 3. JSP 호출하기
		
		// 1. 
		req.setCharacterEncoding("UTF-8");
		
		String name = req.getParameter("name");
		String age = req.getParameter("age");
		String gender = req.getParameter("gender");
		String tel = req.getParameter("tel");
		String address = req.getParameter("address");
		
		
		// 2. 
		AddressDTO dto = new AddressDTO();
		
		dto.setName(name);
		dto.setAge(age);
		dto.setGender(gender);
		dto.setTel(tel);
		dto.setAddress(address);
		
		AddressDAO dao = new AddressDAO();
		int result = dao.add(dto);

		// JSP 페이지에게 전달하기 위해서...
		req.setAttribute("result", result);
		
		// 3.
		RequestDispatcher dispatcher = req.getRequestDispatcher("/address/addok.jsp");
		dispatcher.forward(req, resp);
		
		
	}
	
}
