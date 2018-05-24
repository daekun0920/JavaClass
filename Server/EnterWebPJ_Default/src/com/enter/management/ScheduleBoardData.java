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

@WebServlet("/management/scheduleboarddata.do")
public class ScheduleBoardData extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.authcheck("staff", req, resp);
		
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("utf-8");
		
		
		String seq = req.getParameter("seq");
		String type =req.getParameter("type");
		
		ManagementDAO dao = new ManagementDAO();
		
		ScheduleDTO dto = dao.getScheduleInfo(seq, type);
		
		
		JSONObject job = new JSONObject();
		
		job.put("schedule_name", dto.getName());
		job.put("star_name", dto.getStar_name());
		job.put("member_name", dto.getMember_name());
		job.put("schedule_place", dto.getSchedule_place());
		job.put("schedule_start", dto.getSchedule_start());
		job.put("schedule_end", dto.getSchedule_end());
		job.put("schedule_pay", dto.getSchedule_pay());
		job.put("schedule_type_name", dto.getSchedule_type_name());
		job.put("schedule_seq", dto.getSchedule_seq());
		
		
		resp.getWriter().println(job);
		resp.getWriter().close();
		

	}

}

