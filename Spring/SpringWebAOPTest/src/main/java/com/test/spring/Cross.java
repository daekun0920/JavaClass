package com.test.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

//AOP
// - 보조 업무는 주업무에 개입을 절대 하지 않고 독립적으로 구현

@Aspect
@Component //@Serivce, @Repository
public class Cross {
	
	//포인트 컷 지정하기
	// - 주업무의 특정 메소드 지정하기 -> aspectj 사용
	@Pointcut("execution(public int com.test.spring.Core.getCount())")
	public void pc1() {} //이름 자유, 형식 자유, 본문 없음
	
	
	//보조업무 구현 및 위빙(주업무 <-> 보조업무)
	@Before("pc1()")
	public void m1() {
		System.out.println("보조업무가 실행되었습니다.");
	}
	
	
}















