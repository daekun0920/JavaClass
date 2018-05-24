package com.enter;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.enter.auth.model.ChartDTO;
import com.enter.auth.model.MemberDAO;
import com.enter.management.model.ScheduleDTO;

@WebServlet("/schedulechart.do")
public class ScheduleChart extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		MemberDAO dao = new MemberDAO();
		
		ArrayList<ChartDTO> list = dao.getSchedules();
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("utf-8");
		
		
		
		JSONArray array = new JSONArray();
		try {
			for (ChartDTO dto : list) {
				JSONObject obj = new JSONObject();
			
				obj.put("star_name", dto.getStar_name()); // highchart에 바로 쓰기 위해서
				obj.put("times", dto.getTimes());
				
				array.add(obj);
			}
		
		resp.getWriter().println(array);
		resp.getWriter().close();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
