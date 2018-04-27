package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex11data.do")
public class Ex11Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String page = req.getParameter("page");
		
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<BoardDTO> list = dao.listBoard(page);
		
		
		
		// list -> JSON 변환 반환
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("UTF-8");
		
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for (BoardDTO dto : list) {
			sb.append("{");
			sb.append(String.format("\"seq\":\"%s\",", dto.getSeq()));
			sb.append(String.format("\"id\":\"%s\",", dto.getId()));
			sb.append(String.format("\"subject\":\"%s\",", dto.getSubject()));
			sb.append(String.format("\"regdate\":\"%s\",", dto.getRegdate()));
			sb.append(String.format("\"readcount\":\"%s\"", dto.getReadcount()));
			sb.append("},");
		}
		sb.append("]");
		
		sb.deleteCharAt(sb.lastIndexOf(",")); // 마지막 ',' 삭제
		
	
			resp.getWriter().print(sb); // 쌍따옴표만 가능
			resp.getWriter().close();
		
	}

}
