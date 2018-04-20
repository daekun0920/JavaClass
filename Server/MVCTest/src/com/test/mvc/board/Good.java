package com.test.mvc.board;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/board/good.do")
public class Good extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		// 1. 데이터 가져오기(state, seq)
		
		//2. dao 위임(INSERT)
		
		// 3. jsp 호출하기
		
		
		// 1. 
		String state = req.getParameter("state");
		String seq = req.getParameter("seq");
		
		// 2.
		GoodDTO dto = new GoodDTO();
		dto.setState(state);
		dto.setBseq(seq);
		dto.setId(req.getSession().getAttribute("auth").toString());
	
		
		BoardDAO dao = new BoardDAO();
		
		
		
		int result = -1;
		
		GoodDTO gdto = dao.checkGood(dto); // id - bseq
		
		if (gdto == null) {
		// 1. 한번도 누르지 않은 경우 > INSERT
		
		result = dao.addGood(dto);
	
		} else {
		
					
			if (gdto.getState().equals(state)) {
				// 3. 같은 버튼을 또 누르는 경우 
				result = 1;
				dao.delgood(gdto.getSeq());
				
			} else {
				// 2. 반대편 버튼을 누르는 경우(좋아요 <-> 싫어요) > UPDATE
				result = dao.editGood(dto);
			}
			
				
		}
		
		
		req.setAttribute("result", result);
		req.setAttribute("seq", seq);
		
		RequestDispatcher dispatcher = req.getRequestDispatcher("/board/good.jsp");
		dispatcher.forward(req, resp);

	}

}
