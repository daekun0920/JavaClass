package com.test.ajax;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

@WebServlet("/ex13data.do")
public class Ex13Data extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		String left = req.getParameter("left");
		String top = req.getParameter("top");
		
		// System.out.println(id);
		// System.out.println(left);
		// System.out.println(top);
		
		// cat1의 레코드 있는지 확인
		// - 없으면 INSERT
		// - 있으면 UPDATE
		
		CatDTO dto = new CatDTO();
		dto.setId(id);
		dto.setLeft(left);
		dto.setTop(top);
		
		AjaxDAO dao = new AjaxDAO();
		int result = -1;
		
		if (dao.check(id)) {
			result = dao.updatePosition(dto);
		} else {
			result = dao.insertPosition(dto);
		}
		
		try {
			dao.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("UTF-8");
		
		JSONObject obj = new JSONObject();
		obj.put("result", result);
		
		resp.getWriter().print(obj);
		resp.getWriter().close();
		
	}

}
