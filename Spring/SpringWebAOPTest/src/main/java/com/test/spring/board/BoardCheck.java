package com.test.spring.board;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class BoardCheck {
	
	@Autowired
	private IBoardDAO dao; // 원래는 보조업무용 DAO를 따로 구현해야됨
	
	
	// 포인트 컷(글쓰기, 내용 보기)
	@Pointcut("execution(public String BoardController.add(..)) || execution(public String BoardController.view(..)) || execution(public String BoardController.del(..))") // 같은 패키지 안에 있을시 패키지 경로 생략 가능
	public void pc1() {}
	
	// 포인트 컷 -> 목록보기, 글 쓰기, 내용보기 등...
	@Pointcut("execution(public String BoardController.*(..))") // 같은 패키지 안에 있을시 패키지 경로 생략 가능
	public void pc2() {}
	
	
	// 보조 업무 구현
	@Before("pc1()")
	public void authCheck(JoinPoint joinpoint) {
		// System.out.println("보조 업무 실행");
		
		// 반드시 주 업무에서 사용중인 session 객체가 필요한 보조업무
		// 포인트컷 메소드의 매개변수를 보조업무에서 가져올 수 있다.
		
		Object[] args = joinpoint.getArgs();
		
		HttpSession session = (HttpSession) args[2];
		HttpServletResponse resp = (HttpServletResponse) args[1];
		
		
		//System.out.println(session.getAttribute("auth"));
		
		StringBuilder sb = new StringBuilder();
		
		sb.append("<html>");
		sb.append("<head>");
		sb.append("<meta charset='utf-8'>");
		sb.append("</head>");
		sb.append("<body>");
		sb.append("<script>");
		sb.append("alert('회원 전용임ㅋ'); location.href = '/spring/board/list.aop';");
		sb.append("</script>");
		sb.append("</body>");
		sb.append("</html>");
		
		try {
			
			resp.setCharacterEncoding("UTF-8");
			resp.getWriter().print(sb.toString());
			resp.getWriter().close();
			
			// resp.sendRedirect(url);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@After("pc2()")
	public void log(JoinPoint joinpoint) {
		
		// System.out.println("로그");
		
		// 어떤 유저가? 언제? 어떤 페이지?(어떤 상품?)
		Object[] args = joinpoint.getArgs();
		
		HttpSession session = (HttpSession) args[2]; // 어떤 유저가?
		HttpServletRequest req = (HttpServletRequest) args[0]; // 어떤 페이지?
		
		String id = session.getAttribute("auth") == null ? "guest" : (String)session.getAttribute("auth");
		String page = req.getRequestURI().substring(req.getRequestURI().lastIndexOf("/") + 1);			
		
		System.out.println(id);
		System.out.println(page);
		
		LogDTO dto = new LogDTO();
		
		dto.setId(id);
		dto.setPage(page);
		
		dao.log(dto);
		
	}
}
