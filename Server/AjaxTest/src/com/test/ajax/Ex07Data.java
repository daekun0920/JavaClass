package com.test.ajax;

import java.io.IOException;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex07data.do")
public class Ex07Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		Calendar now = Calendar.getInstance();
		// Calendar temp = null;
		
		String id = req.getParameter("id");
		String num = req.getParameter("num");
		
		// 잠시 5초동안 작업 중지
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		resp.getWriter().print(String.format("%tF %tT %s %s", now, now, id, num));
		resp.getWriter().close();
		
			
	}

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		/*
		Calendar now = Calendar.getInstance();
		
		String color = req.getParameter("color");
		String size = req.getParameter("size");
		
		
		resp.getWriter().print(String.format("%tF %tT %s, %s", now, now, color, size));
		resp.getWriter().close();*/
		
		AjaxDAO dao = new AjaxDAO();
		
		ResearchDTO dto = dao.getResearch("1");
		
		resp.setContentType("text/xml");
		resp.setHeader("Content-type", "application/xhtml+xml");
		resp.setCharacterEncoding("UTF-8");
		
		StringBuilder str = new StringBuilder();
		
		str.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
		str.append("<research>");
		str.append("<question>" + dto.getQuestion() + "</question>");
		str.append("<item><text>" + dto.getAnswer1() + "</text><count>" + dto.getCnt1() + "</count></item>");
		str.append("<item><text>" + dto.getAnswer2() + "</text><count>" + dto.getCnt2() + "</count></item>");
		str.append("<item><text>" + dto.getAnswer3() + "</text><count>" + dto.getCnt3() + "</count></item>");
		str.append("<item><text>" + dto.getAnswer4() + "</text><count>" + dto.getCnt4() + "</count></item>");
		str.append("</research>");
		
		resp.getWriter().println(str.toString());
		resp.getWriter().close();
		
		/*
		 
		<?xml version="1.0" encoding="utf-8"?> 
		<research>
			<item>
				<text>Java</text>
				<count>17</count>
			</item>
			<item>
				<text>Oracle</text>
				<count>10</count>
			</item>
		</research>
		*/
		
	}
}
