package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex09data.do")
public class Ex09Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String buseo = req.getParameter("buseo");
		
		AjaxDAO dao = new AjaxDAO();
		
		ArrayList<InsaDTO> list = dao.list(buseo);
		
		
		// ajax 객체 반환 -> Text, XML, JSON
		
		/*
		 <?xml version = "1.0" encoding = "UTF-8"?>
		 <list>
		 	<item>
		 		<num></num>
		 		<name></name>
		 		<jikwi></jikwi>
		 		<tel></tel>
		 	</item>
		 </list>
		*/
		
		resp.setContentType("text/xml");
		resp.setHeader("Content-type", "application/xhtml+xml");
		resp.setCharacterEncoding("UTF-8");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<?xml version = \"1.0\" encoding = \"UTF-8\"?>");
		sb.append("<list>");
		for (InsaDTO dto : list) {
			sb.append("<item>");
				sb.append(String.format("<num>%s</num>", dto.getNum()));
				sb.append(String.format("<name>%s</name>", dto.getName()));
				sb.append(String.format("<jikwi>%s</jikwi>", dto.getJikwi()));
				sb.append(String.format("<tel>%s</tel>", dto.getTel()));
			sb.append("</item>");
		}
		sb.append("</list>");
		
		resp.getWriter().print(sb.toString());
		resp.getWriter().close();

		
	}

}
