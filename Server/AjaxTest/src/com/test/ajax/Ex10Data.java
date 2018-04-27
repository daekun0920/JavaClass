package com.test.ajax;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/ex10data.do")
public class Ex10Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		

			String m = req.getParameter("m");
			
			if (m.equals("1")) m1(req, resp);
			else if (m.equals("2")) m2(req, resp);
			else if (m.equals("3")) m3(req, resp);
		

	}

	private void m1(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
		// 단일값
		AjaxDAO dao = new AjaxDAO();
		
		String name = dao.getName();
		
		// name을 JSON 형태로 돌려주기
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("UTF-8");
		
		/*
		 JSON, JavaScript Simple Object Notation
		 	- 자바 스크립트로 객체를 표기하는 방법 
		 
		 JavaScript Object 표기법
		 {
		 	name:"홍길동",
		 	age:20,
		 	gender:"남자"
		 }
		  
		 JSON 표기법
		 {
		 	"name":"홍길동",
		 	"age":"20",
		 	"gender":"남자"
		 }
		  
		 */
		
		resp.getWriter().printf("{\"name\":\"%s\"}", name); // 쌍따옴표만 가능
		resp.getWriter().close();
		
	}

	private void m2(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
		
		String id = req.getParameter("id");
		
		AjaxDAO dao = new AjaxDAO();
		
		MemberDTO dto = dao.getMember(id);
		
		
		// 위의 dto를 JSON 형태로 돌려주기
		
		/*
		{
		
		 "id":"hong",
		 "name":"홍길동",
		 "pw":"1111",
		 "lv":"1"
		
		}
		*/
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("UTF-8");
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("{");
		sb.append("\"id\":\"hong\",");
		sb.append("\"name\":\"홍길동\",");
		sb.append("\"pw\":\"1111\",");
		sb.append("\"lv\":\"1\"");
		sb.append("}");
		
		
		resp.getWriter().print(sb); // 쌍따옴표만 가능
		resp.getWriter().close();
		
	}
	private void m3(HttpServletRequest req, HttpServletResponse resp) throws  ServletException, IOException {
		AjaxDAO dao = new AjaxDAO();
		
		
		ArrayList<MemberDTO> list = dao.listMember();
		
		resp.setHeader("Content-type", "application/json");
		resp.setCharacterEncoding("UTF-8");
		
		// 위의 list를 JSON 형태의 목록으로 변환해서 돌려주기
		/*
		
		{
			"name":"홍길동",
			"id":"hong"
		}
		
		[
			{
				"name":"홍길동",
				"id":"hong"
			},
			
			{
				"name":"홍길동",
				"id":"hong"
			},
			
			{
				"name":"홍길동",
				"id":"hong"
			}
		
		
		]
		
		*/
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("[");
		for (MemberDTO dto : list) {
			sb.append("{");
			sb.append(String.format("\"id\":\"%s\",", dto.getId()));
			sb.append(String.format("\"name\":\"%s\",", dto.getName()));
			sb.append(String.format("\"lv\":\"%s\",", dto.getLv()));
			sb.append(String.format("\"pw\":\"%s\"", dto.getPw()));
			sb.append("},");
		}
		sb.append("]");
		
		sb.deleteCharAt(sb.lastIndexOf(",")); // 마지막 ',' 삭제
		
		resp.getWriter().print(sb); // 쌍따옴표만 가능
		resp.getWriter().close();
		
	}


}
