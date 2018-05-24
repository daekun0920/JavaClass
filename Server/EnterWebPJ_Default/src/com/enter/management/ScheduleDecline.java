package com.enter.management;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONException;
import org.json.JSONObject;

import com.enter.management.model.ManagementDAO;

@WebServlet("/management/scheduledecline.do")
public class ScheduleDecline extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.authcheck("staff", req, resp);
		
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("utf-8");
		
		String seq = req.getParameter("seq");
		
		
		ManagementDAO dao = new ManagementDAO();
		
		JSONObject job = new JSONObject();
		
		
		try {
			job.put("result", dao.delSchedule(seq));
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		resp.getWriter().print(job);
		resp.getWriter().close();
		
	}

}
