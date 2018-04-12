package com.test.mvc.address;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class List extends HttpServlet {

	//location.href = "list.do";
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) 
			throws ServletException, IOException {
		
		// 1. DAO 위임
		
		// 2. 결과 값 반환 -> 3으로 ..
		
		// 3. 2의 결과 -> JSP 호출하기
		
		// 1.
		
		AddressDAO dao = new AddressDAO();
		ArrayList<AddressDTO> list = dao.list();
	
		// 2. + 3.
		req.setAttribute("list", list);
		
		// 3.
		RequestDispatcher dispatcher = req.getRequestDispatcher("/address/list.jsp");
		dispatcher.forward(req, resp);
		

		
	}
	
}
