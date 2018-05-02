package com.test.api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.json.JSONObject;
import org.json.XML;


@WebServlet("/api/ex02data.do")
public class Ex02Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		String query = req.getParameter("query"); // 구직 검색어

		// DB -> 사람인 Open API 호출
	
		try {
			// 검색어
			String text = URLEncoder.encode(query, "UTF-8");
			
			// 요청 URL & 오픈 API 주소
			String apiURL = "http://api.saramin.co.kr/job-search?keywords=" + text; // json 결과
			// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
			// // xml 결과
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
		
			int responseCode = con.getResponseCode();
			
			BufferedReader br;
			
			if (responseCode == 200) { // 정상 호출
				br = new BufferedReader(new InputStreamReader(con.getInputStream()));
			} else { // 에러 발생
				br = new BufferedReader(new InputStreamReader(con.getErrorStream()));
			}
			
			String inputLine;
			StringBuffer response = new StringBuffer();
			
			while ((inputLine = br.readLine()) != null) {
				response.append(inputLine);
			}
			
			br.close();
			
			// System.out.println(response.toString());
			
			// XML -> JSON 변환
			
			// XML 형식을 가지는 문자열을 가지고 JSONObject 객체를 생성
			JSONObject obj = XML.toJSONObject(response.toString()); // org.json.jsonobjectw
			//System.out.println(obj.toString());
			
			resp.setHeader("Content-type", "application/json");
			resp.setCharacterEncoding("UTF-8");
			
			resp.getWriter().write(obj.toString());
			resp.getWriter().close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

		

	}

}

