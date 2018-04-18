package com.test.mvc.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/editcomment.do")
public class EditComment extends HttpServlet {

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 데이터 가져오기
		// 2. DAO 위임(UPDATE)
		// 3. JSP 호출하기
		
		// 1. 
		req.setCharacterEncoding("UTF-8");
		
		String content = req.getParameter("ccontent");
		String seq = req.getParameter("seq");
		String pseq = req.getParameter("pseq");
		
		CommentDTO dto = new CommentDTO();
		dto.setSeq(seq);
		dto.setContent(content);
		
		BoardDAO dao = new BoardDAO();
		
		int result = -1;
		
		if (dao.getCommentId(seq).equals(req.getSession().getAttribute("auth").toString())) {
			
			result = dao.editcomment(dto);
		
		} else {
			result = 2;
		}
		
		
		// 3. 
		req.setAttribute("result", result);
		req.setAttribute("pseq", pseq);
		
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/editcomment.jsp");
		dispatcher.forward(req, resp);

	}

}
