package com.test.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Calendar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/*
1. 서블릿 클래스 선언
a. javax.servelet.Servlet 인터페이스를 구현해야 된다.(상속)
	- 복잡함. 모든 내용을 직접 구현
b. javax.servlet.http.HttpServlet 클래스를 상속받아야 한다.(상속)
	- 간편함. 대부분의 코드를 미리 구현해놨기 때문
*/
public class Ex01 extends HttpServlet {
	
	// 2. doGet/doPost 메소드 선언
	// a. 매개변수 작성
	// - javax.servlet.http.HttpServletRequest
	// - javax.servlet.http.HttpServletResponse
	
	// b. 예외 미루기(처리)
	// - throws java.io.IOEXception
	// - throws javax.servlet.ServletException
	
	public void doGet(HttpServletRequest request, HttpServletResponse response) 
		throws IOException, ServletException {
		
//		3. 메소드 내부 구현
//		- 동적으로 HTML 작성하는 업무를 구현
		PrintWriter writer = response.getWriter();
		
		// writer.print();
		// writer.println();
		// writer.printf(format, args);
		
		writer.println("<html>");
		writer.println("<head>");
		writer.println("<title>Hello Page</title>");
		writer.println("</head>");
		writer.println("<body>");
		writer.println("<h1>Hello</h1>");
		writer.println("<p>Servlet Page..</p>");
		
		Calendar c = Calendar.getInstance();
		writer.printf("%tF %tT", c, c);
		
		writer.println("</body>");
		writer.println("</html>");
		  
		writer.close(); // 동적으로 HTML 페이지 작성 완료
		
		// http://localhost:8090/ServletTest/servlet/com.test.servlet.Ex01
		// - 브라우저가 서버를 통해서 클래스를 호출 -> 클래스는 웹 기반 요소가 아니다. -> 웹을 통해서 클래스를 접근 가능한 가상 주소 -> 가상 호출
		
//		- HttpServletResponse 객체의 getWrite() 호출 -> PrintWriter 반환 
//		- PrintWriter == BufferedWriter 와 유사
//		- PrintWriter 객체의 printXXX()를 사용해서 HTML 코드를 작성
		
		
	}
	
}
