package com.test.mvc.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/addcomment.do")
public class AddComment extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 데이터 가져오기
		// 2. DAO 위임(INSERT)
		// 3. JSP 호출하기
		
		
		// 1. 
		req.setCharacterEncoding("UTF-8");
		
		String content = req.getParameter("ccontent");
		String pseq = req.getParameter("pseq");
		String id = (String)req.getSession().getAttribute("auth");
		
		// 2. 
		CommentDTO dto = new CommentDTO();
		
		dto.setContent(content);
		dto.setId(id);
		dto.setPseq(pseq);
		
		BoardDAO dao = new BoardDAO();
		int result = dao.addcomment(dto);
		
		// 3. 
		
		req.setAttribute("result", result);
		req.setAttribute("pseq", dto.getPseq());
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/addcomment.jsp");
		dispatcher.forward(req, resp);

	}

}
