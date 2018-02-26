package actor;

import java.util.ArrayList;
import java.util.Scanner;

public class BoardList {
	static final String strAdmin;
	static final String strBasicMember;
	static final String strOwner;
	static final String strAnony;
	static {
		
		strAdmin = "관리자";
		strBasicMember = "회원";
		strOwner = "점주";
		strAnony = "비회원";
	}
	
	public static void pageView(ArrayList<String> list
						      , ArrayList<String> listNames, Member m) { // 검색 페이징
	
		//메소드 실행시 50개씩 보여주고 페이지 이동하게 해줌
		paging(list, listNames, m);
		
	}

	private static int paging(ArrayList<String> list, ArrayList<String> listNames, Member e) {
		// TODO Auto-generated method stub
		//TODO 게시물이 하나도 없는 경우.
				//처음 최신 10개 보여준다, 종료 or 인덱스 입력//
				// 시작페이지 [1] - 마지막 페이지[10], "종료" 입력시 이전 화면으로 돌아갑니다.
				// 10 개의 게시물이 한 페이지면, 1~10 까지는 1페이지.
				// 게시물 전체를 10으로 나눈 몫 + 나머지> 0 인 경우 + 1 을 마지막 페이지로 한다.
				
				Scanner sc = new Scanner(System.in);
				int fullPageCnt = list.size()/10; //게시글이 가득찬 페이지 수
				int restPage = list.size()%10; //남는 게시글의 수
				
				if(restPage > 0) {
					//풀페이지 하고 여분의 게시물이 남으면
					restPage = 1;
				} else {
					restPage = 0;
				}
				fullPageCnt += restPage; //총 페이지 수
				
				int pageNum = 0;
				int start = list.size() - 1; //마지막 게시물에서 시작
				
				boolean flag = true;
				String page = "1";
				while(flag) {
					
					try {
						System.out.println("===================================================================================================================================================================================맛집 검색=========================================================================================================================================");
						System.out.printf("[번호][상호명]\t\t\t\t\t\t\t[주소]\t\t\t\t\t\t[종류]\t\t   [전화번호]\t\t   [위시리스트]\t\t\t[태그]\t\t\t\t\t\t\t\t\t[메뉴]\t\n");
						
						for(int i=start-(pageNum*10); i>start-(pageNum*10+10); i--) {
							
								String[] temp = list.get(i).split("/");
								
								System.out.printf("%-30.25s \t\t\t\t%-30.12s \t%-18.10s %-30.24s %-5s %-40.30s %-40s"
												 , temp[0]
												 , temp[1]
												 , temp[2]
												 , temp[3]
												 , temp[4]
												 , temp[5]
												 , temp[6]
												 );
								System.out.println();
							if(i == 0) {
								break;
							} //마지막 페이지에 남은 게시물을 출력하고 멈추기 위해서.
						}
					} catch (IndexOutOfBoundsException i) {
						System.out.println("   해당 정보가 존재하지 않습니다.");
					}
					String input = "";
					
					System.out.printf(" \n(첫 페이지 [1] - 현재 페이지[%s] - 끝 페이지[%s]) \n", page, fullPageCnt);
					if (e.getMemberType().equals(strBasicMember)) {
					System.out.print("[명령어 : 예약, 위시리스트, 페이지 이동, 종료]\n" 
									 + " 예) \"예약, 1\" or \"페이지 이동, 3\"\n");
					} else {
						System.out.println("[명령어 : 페이지 이동, 종료]\n"
										+ "예) \"페이지 이동, 3\" or \"종료\"");
					}
					System.out.print("원하시는 명령어와 숫자를 입력해주세요 : ");
					
					String order = sc.nextLine();
					String[] orderlist = order.split(", ");
					Business.clearScreen();
					if (orderlist[0].equals("페이지 이동")) {
						page = orderlist[1];
						input = orderlist[1];
					} else if (orderlist[0].equals("종료")) {
						input = orderlist[0];
					} else if (e.getMemberType().equals(strBasicMember)) {
						BasicMember.wishReservePage(list, listNames, e, order);
						return 0;
					} 
					while(flag) {
						boolean ck = true;
						ck = isNum(input);
						
						if(ck == false) {
							//문자열 선택
							if(input.equals("종료")) {
								Business.clearScreen();
								
								System.out.println("종료합니다.");
								return 0;
							} else {
								System.out.print("잘못된 문자열을 입력하셨습니다");
								paging(list, listNames, e);
							}
						} else {
							//범위내 페이지 이동
							if(Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= fullPageCnt) {
								pageNum = Integer.parseInt(input)-1;
								break;
							} else {
								System.out.print("존재하지 않는 페이지 입니다. 재입력해주세요.");
								break;
							}
						}
						// 가능한 이동 범위는 1 ~ fullPagecnt 까지
					}
			}
				return 0;
			
	}
	private static boolean isNum(String input) {
		if(input == null || input.equals("")) {
			//유효성 검사 : 입력값이 null 이거나 빈 문자열인 경우
			return false;
		}
		for(int i=0; i<input.length(); i++) {
			//문자열이 숫자가 맞으면 true 아니면 false
			char ch = input.charAt(i);
			
			if(ch<'0' || ch > '9') {
				return false;
			}
		}
		return true;
	}			
}
