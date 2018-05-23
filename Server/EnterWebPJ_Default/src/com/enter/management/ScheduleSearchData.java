package com.enter.management;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

import com.enter.management.model.ArtistDTO;
import com.enter.management.model.ManagementDAO;


@WebServlet("/management/ScheduleSearchData.do")
public class ScheduleSearchData extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String keyword = req.getParameter("keyword");
		String type = req.getParameter("type");
		
		ManagementDAO dao = new ManagementDAO();
		
		ArrayList<ArtistDTO> list = dao.searchartists(keyword, type);
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("utf-8");
		
		
		
		// list -> JSONArray 출력
		JSONArray array = new JSONArray();
				
		for (ArtistDTO dto : list) {
		// 레코드 1개 -> DTO -> JSONObject 1개
			JSONObject obj = new JSONObject();
						
			obj.put("name", dto.getName()); // highchart에 바로 쓰기 위해서
			obj.put("artist_seq", dto.getArtist_seq());
					
			array.add(obj);
		}
				
		resp.getWriter().println(array);
		resp.getWriter().close();
		
	}

}
