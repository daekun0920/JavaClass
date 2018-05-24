package com.test.spring.aop;

public class Memo implements IMemo{

	/*@Override
	public void add(String memo) {
		
		//보조업무 추가
		long start = System.currentTimeMillis();
		System.out.println("[log] 시간 기록 시작합니다.");
		
		//1. 메모 쓰기
		System.out.printf("메모 쓰기 : %s\n", memo);
		
		
		//보조업무 추가
		long end = System.currentTimeMillis();
		System.out.println("[log] 시간 기록 종료합니다.");
		System.out.printf("[log]주업무 실행 소요 시간 : %s\n", end - start + "ms");
	}*/
	
	@Override
	public void add(String memo) {
		
		//1. 메모 쓰기
		System.out.printf("메모 쓰기 : %s\n", memo);
		
	}
	
	@Override
	public void edit(String memo) {
	
		//2. 메모 수정 - 주업무
		System.out.printf("메모 수정 : %s\n", memo);
	}

	@Override
	public void edit(String memo, String name) {
		
		System.out.println("edit(String memo, String name)");
	}

	@Override
	public void editName(String name) {
		System.out.println("editName(String name)");
		
	}

	@Override
	public void checkName() {
		System.out.println("checkName()");
		
	}

	@Override
	public void read(int seq) throws Exception{
		
		if(seq <= 0) {
			//에러..
			throw new Exception("해당 번호는 유효하지 않습니다.");
		}
		
		System.out.printf("메모 읽기 : %d 메모를 읽습니다.\n", seq);
	
	
	}
	
	@Override
	public int search(String word) {
		
		//주업무 : 키워드 -> 검색된 글번호 반환
		if(word.indexOf("자바") > -1) {
			return 3; //3번 메모
		} else if(word.indexOf("오라클") > -1) {
			return 5; //5번 메모
		} else {
			return -1;
		}
	}
	
}
