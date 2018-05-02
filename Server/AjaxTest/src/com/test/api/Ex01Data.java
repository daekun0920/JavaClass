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

@WebServlet("/api/ex01data.do")
public class Ex01Data extends HttpServlet {

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String query = req.getParameter("query");

		// DB -> Naver Open API 호출
		String clientId = "LLUVfFXpZz3kwc6_sxHB";// 애플리케이션 클라이언트 아이디값";
		String clientSecret = "kxA9LRuNPj";// 애플리케이션 클라이언트 시크릿값";
		try {
			// 검색어
			String text = URLEncoder.encode(query, "UTF-8");
			
			// 요청 URL & 오픈 API 주소
			String apiURL = "https://openapi.naver.com/v1/search/book?query=" + text; // json 결과
			// String apiURL = "https://openapi.naver.com/v1/search/blog.xml?query="+ text;
			// // xml 결과
			URL url = new URL(apiURL);
			HttpURLConnection con = (HttpURLConnection) url.openConnection();
			con.setRequestMethod("GET");
			con.setRequestProperty("X-Naver-Client-Id", clientId);
			con.setRequestProperty("X-Naver-Client-Secret", clientSecret);
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
			
			resp.setHeader("Content-type", "application/json");
			resp.setCharacterEncoding("UTF-8");
			
			resp.getWriter().write(response.toString());
			resp.getWriter().close();
			
		} catch (Exception e) {
			System.out.println(e);
		}

	}

}
