package com.enter.management;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONObject;

import com.enter.management.model.ManagementDAO;
import com.enter.management.model.ScheduleDTO;

@WebServlet("/management/detailschedule.do")
public class DetailSchedule extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String schedule = req.getParameter("schedule_seq");
		String type = req.getParameter("type");
		
		ManagementDAO dao = new ManagementDAO();
		
		ScheduleDTO dto = dao.getScheduleInfo(schedule, type); 
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("utf-8");
		
		

		JSONObject obj = new JSONObject();
		
		
		obj.put("name", dto.getName()); 
		obj.put("art_seq", dto.getArt_seq());
		obj.put("schedule_start", dto.getSchedule_start());
		obj.put("schedule_end", dto.getSchedule_end());
		obj.put("schedule_pay", dto.getSchedule_pay());
		obj.put("member_name", dto.getMember_name());
		obj.put("schedule_place", dto.getSchedule_place());
		obj.put("schedule_type_name", dto.getSchedule_type_name());
		obj.put("schedule_seq", dto.getSchedule_seq());
		
		
		resp.getWriter().println(obj);
		resp.getWriter().close();
	}

}
