package com.enter.management;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.enter.management.model.ManagementDAO;

@WebServlet("/management/scheduleaccept.do")
public class ScheduleAccept extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.authcheck("staff", req, resp);
		
		
		String seq = req.getParameter("seq");
		String type = req.getParameter("type");
		String star = req.getParameter("star");
		ManagementDAO dao = new ManagementDAO();
		
		int result = dao.acptSchedule(seq, type, star);
		System.out.println("리절트 " + result);
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("utf-8");
		
		
		JSONObject job = new JSONObject();
		
		job.put("result", result);
		
		resp.getWriter().print(job);
		resp.getWriter().close();
	}

}
