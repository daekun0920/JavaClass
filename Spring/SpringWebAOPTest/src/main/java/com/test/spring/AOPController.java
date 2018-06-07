package com.test.spring;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AOPController {

	@Autowired
	private ICore core; //주 업무 객체
	
	@RequestMapping(method={RequestMethod.GET}, value="/index.aop")
	public String index(HttpServletRequest req) {
		
		//AOP
		// - 주업무와 보조업무를 분리시켜서 관리/적용하지
		// - 분리 : 집중, 분업, 재사용 등..
		// - Point Cut : 주업무 지정(어느 패키지의 어떤 클래스의 어떤 메소드 지정 - aspectj 표현)
		// - Advice : 보조 업무를 적용하는 형태(Before, After, Around..)
		// - Weaving : 특정 Point Cut + 특정 Advice = 적용하는 행동
		// - XML 적용(지난 수업), Annotation 적용(이번 수업)
		
		//현재 상황
		// Controller <-> 주업무객체(core) <-> 하위업무객체(dao) <-> mybatis객체(template)
		// + 보조업무객체(cross)
		
		//메모 갯수
		int count = core.getCount();
		
		req.setAttribute("count", count);
		
		return "aop";		
	}
	
	
	@RequestMapping(value="/login.aop")
	public String login(HttpSession session, String id) {
		
		//login.aop?id=hong
		//login.aop?id=lee
		//login.aop?id=test
		
		session.setAttribute("auth", id); //로그인 성공
		
		return "redirect:/index.aop";
		
	}
	
	@RequestMapping(value="/logout.aop")
	public String logout(HttpSession session) {
		
		session.removeAttribute("auth"); //로그아웃 성공
		
		return "redirect:/index.aop";
		
	}
	
	
	
	
	
	@RequestMapping(value="/member/list.aop")
	public String mlist(HttpSession session, HttpServletResponse resp) {
		
//		if (session.getAttribute("auth") == null) {
//			쫒아내기 ..
//		}
		
		System.out.println("회원 전용 목록 페이지");
		
		return "member/list"; //WEB-INF/views/member/list.jsp
		
	}
	
	@RequestMapping(value="/member/info.aop")
	public String minfo(HttpSession session,  HttpServletResponse resp) {
		
		System.out.println("회원 전용 정보 페이지");
		
		return "member/info"; //WEB-INF/views/member/list.jsp
		
	}
	
	
	
}


























