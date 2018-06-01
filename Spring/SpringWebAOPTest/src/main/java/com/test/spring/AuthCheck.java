package com.test.spring;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//또 다른 보조 업무 객체
@Aspect
@Component
public class AuthCheck {

	//PointCut
	@Pointcut("execution(public String AOPController.m*(..))")
	public void pc1() {}
	
	@Before("pc1()")
	public void check(JoinPoint joinPoint) {
		
		//현재 접속자가 인증받은 사용자인지?
		//System.out.println("로그인 확인");
		
		//joinPoint : 주업무 객체의 프록시 객체 -> AOPController 객체
		Object[] args = joinPoint.getArgs(); //주업무 메소드의 인자값을 가져오는 명령어
		
		HttpSession session = (HttpSession)args[0];
		HttpServletResponse resp = (HttpServletResponse)args[1];
		
		System.out.println("보조 업무쪽에서 인증 티켓 확인 : " + session.getAttribute("auth"));
		
		if (session.getAttribute("auth") == null || session.getAttribute("auth") == "") {
			//퇴거!!!!!
			
			//페이지 작성 -> response 객체 필요
			resp.setCharacterEncoding("UTF-8");
			
			try {
				
				PrintWriter writer = resp.getWriter();
				
				writer.println("<html>");
				writer.println("<head>");
				writer.println("<meta charset='UTF-8'>");
				writer.println("</head>");
				writer.println("<body>");
				writer.println("<script>");
				writer.println("alert('회원 전용!!!');");
				writer.println("history.back();");
				writer.println("</script>");
				writer.println("</body>");
				writer.println("</html>");
				
				writer.close();
				
			} catch (IOException e) {
				e.printStackTrace();
			}
			
			
			
		}
		
		
		
	}
	
}

























