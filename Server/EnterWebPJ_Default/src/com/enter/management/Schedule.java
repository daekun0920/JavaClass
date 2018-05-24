package com.enter.management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.enter.management.model.ArtistDTO;
import com.enter.management.model.ManagementDAO;
import com.enter.management.model.ScheduleDTO;

@WebServlet("/management/schedule.do")
public class Schedule extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Check check = new Check();
		check.authcheck("staff", req, resp);
		
		String art_seq = req.getParameter("art_seq");
		String name = req.getParameter("name");
		
		ManagementDAO dao = new ManagementDAO();
		
		ArrayList<ScheduleDTO> list = dao.getSchedule(art_seq);
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("utf-8");
		
		
		
		// list -> JSONArray 출력
		JSONArray array = new JSONArray();
		try {
			for (ScheduleDTO dto : list) {
			// 레코드 1개 -> DTO -> JSONObject 1개
				JSONObject obj = new JSONObject();
				
				int index = dto.getSchedule_start().lastIndexOf("-") + 1;
				
				/*
				if (dto.getSchedule_start().substring(index).startsWith("0")) {
					dto.setSchedule_start(dto.getSchedule_start().substring(0, index) + dto.getSchedule_start().charAt(dto.getSchedule_start().length()));
				}
				*/	
				
				
				obj.put("name", dto.getName()); // highchart에 바로 쓰기 위해서
				obj.put("art_seq", dto.getArt_seq());
				obj.put("schedule_start", dto.getSchedule_start());
				obj.put("schedule_end", dto.getSchedule_end());
				obj.put("schedule_pay", dto.getSchedule_pay());
				obj.put("member_name", dto.getMember_name());
				obj.put("schedule_place", dto.getSchedule_place());
				obj.put("schedule_type_name", dto.getSchedule_type_name());
				obj.put("schedule_seq", dto.getSchedule_seq());
				
				array.add(obj);
			}
			resp.getWriter().println(array);
			resp.getWriter().close();
		} catch(Exception e) {
			e.printStackTrace();
			
		}
	}

}

