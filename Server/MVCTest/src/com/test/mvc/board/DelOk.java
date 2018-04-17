package com.test.mvc.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/delok.do")
public class DelOk extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// delok.do?seq=5
		// 1. 데이터 가져오기(seq)
		
		// 2. 권한이 있는지?
		
		// 3. DAO 위임(DELETE)
		
		// 4. JSP 호출하기
		
		
		// 1.
		// delok.do?seq=5&id=dog
		String seq = req.getParameter("seq");
		//String id = req.getParameter("id");
		BoardDAO dao = new BoardDAO();
		String id = dao.get(seq).getId(); 
		
		// 2.
		int result = -1;
		
		if (id.equals((String)req.getSession().getAttribute("auth"))) {
			result = dao.del(seq);
		} else {
			result = 2;
		}
		
		// 3.
		req.setAttribute("result", result);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/delok.jsp");
		dispatcher.forward(req, resp);
		
	}

}
