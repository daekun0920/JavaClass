package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex13.do")
public class Ex13 extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		// 페이지 시작 -> 고양이의 처음 위치 지정
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<CatDTO> list = dao.listCat();

		
		req.setAttribute("list", list);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/WEB-INF/view/ajax/ex13.jsp");
		dispatcher.forward(req, resp);

	}

}
