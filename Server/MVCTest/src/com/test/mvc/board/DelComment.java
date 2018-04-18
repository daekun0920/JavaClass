package com.test.mvc.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/delcomment.do")
public class DelComment extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 데이터 가져오기(seq, pseq)
		// 2. DAO 위임(DELETE)
		// 3. JSP 호출하기
		
		// 1. 
		String seq = req.getParameter("seq");
		String pseq = req.getParameter("pseq");
		
		
		// 2. 
		BoardDAO dao = new BoardDAO();
		
		
		
		int result = -1;
		
		String id = dao.getCommentId(seq);
		
		if (id.equals(req.getSession().getAttribute("auth").toString())) { // 댓글 작성자인지?
			result = dao.delcomment(seq);
		} else {
			result = 2;
		}
		
		
		req.setAttribute("result", result);
		req.setAttribute("pseq", pseq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/delcomment.jsp");
		dispatcher.forward(req, resp);

	}

}
