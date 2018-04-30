package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

@WebServlet("/ex12data.do")
public class Ex12Data extends HttpServlet {

	@SuppressWarnings("unchecked")
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String id = req.getParameter("id");
		
		AjaxDAO dao = new AjaxDAO();
		ArrayList<ChartDTO> list = dao.listChart(id);
		
		// list -> JSON 출력
		
		// 레코드 1개 -> 객체 1개 -> JSON 객체 1개
		/*	
	 	[
		{
			"cnt":"10",
			"salary":"2000"
		},
		
		{
			"cnt":"10",
			"salary":"2000"
		}
		*/
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("utf-8");
		
		/*
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		
		for (ChartDTO dto : list) {
			sb.append("{");
			sb.append(String.format("\"cnt\":\"%d\",", dto.getCnt()));
			sb.append(String.format("\"salary\":\"%d\"", dto.getSalary()));
			sb.append("},");
		}
		
		sb.deleteCharAt(sb.lastIndexOf(","));
		
		sb.append("]");
		
		resp.getWriter().print(sb.toString());
		*/
		
		/*
		{
		  	"name":"홍길동"
		} 
		
		이 작업 조금더 편하게 해주는 객체 -> JSONObject
		*/
		
		/*JSONObject obj = new JSONObject();
		obj.put("name", "홍길동");
		obj.put("age", "20");
		obj.put("address", "서울시");
		
		JSONObject obj2 = new JSONObject();
		obj2.put("name", "홍길동");
		obj2.put("age", "20");
		obj2.put("address", "서울시");
		
		JSONObject obj3 = new JSONObject();
		obj3.put("name", "홍길동");
		obj3.put("age", "20");
		obj3.put("address", "서울시");
		
		JSONArray list2 = new JSONArray();
		
		list2.add(obj);
		list2.add(obj2);
		list2.add(obj3);
		
		
		
		resp.getWriter().println(list2);
		*/
		
		// list -> JSONArray 출력
		JSONArray array = new JSONArray();
		
		for (ChartDTO dto : list) {
			// 레코드 1개 -> DTO -> JSONObject 1개
			JSONObject obj = new JSONObject();
			
			obj.put("y", dto.getCnt()); // highchart에 바로 쓰기 위해서
			obj.put("name", dto.getSalary());
			
			array.add(obj);
		}
		
		resp.getWriter().println(array);
		resp.getWriter().close();
		
	}

}

