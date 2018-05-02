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

@WebServlet("/ex14data.do")
public class Ex14Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String query = req.getParameter("query");
		
		AjaxDAO dao = new AjaxDAO();
		ArrayList<String> list = dao.query(query);
		
		// list -> JSONArray 변환 출력
		//for (String word : list) {
		//	System.out.println(word);
		//}
		
		JSONArray array = new JSONArray();
		
		
		for (String word : list) {
			/*
			{
				"word":"aaa"
			}
			*/
			
			JSONObject obj = new JSONObject();
			obj.put("word", word);
			array.add(obj);
		}
		
		System.out.println(array);
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("UTF-8");
		
		resp.getWriter().print(array);
		resp.getWriter().close();
		
	}

}
