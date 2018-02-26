package actor;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import dataTable.Board;
import dataTable.MemberTable;

/*
 * 1. 메소드
 * public static void boardLoad 글 스택에 불러오기
 * public static void boardSave 글 목록 테이블에 저장
 * public static void pageView 게시글 50 개씩 보기
 * 
 * boardAdd 일반회원의 게시글 작성
 */

public class BoardList {
	public static ArrayList<Board> boardList;		//게시판 테이블을 저장할 변수
	static final String boardPath;
	
	static final String strAdmin;
	static final String strBasicMember;
	static final String strOwner;
	
	static {
		boardList = new ArrayList<>();
		boardPath = "./src/게시글.txt";
		
		strAdmin = "관리자";
		strBasicMember = "회원";
		strOwner = "점주";
	}
	
	public static void pageView(ArrayList<String> list, ArrayList<String> listNames, Member m) { // 검색 페이징
		BasicMember e = (BasicMember)m;
	
		//메소드 실행시 50개씩 보여주고 페이지 이동하게 해줌
		paging(list, listNames, e);
		
	}
	
	public static <T> void pageView(ArrayList<T> list) { // 게시판 페이징
		paging(list);
	}
	
	public static void pageViewExt(ArrayList<String> list) { // 순수 페이징 (비회원 검색)
		pagingExt(list);
	}
	
	private static void paging(ArrayList<String> list   //  검색 페이징
							 , ArrayList<String> listNames
							 , BasicMember e) {
	
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
				for(int i=start-(pageNum*10); i>start-(pageNum*10+10); i--) {
					
					System.out.println(list.get(i));
					
					if(i == 0) {
						break;
					} //마지막 페이지에 남은 게시물을 출력하고 멈추기 위해서.
				}
			} catch (IndexOutOfBoundsException i) {
				System.out.println("   게시글이 존재하지 않습니다.");
			}
			String input = "";
			
			System.out.printf(" \n(첫 페이지 [1] - 현재 페이지[%s] - 끝 페이지[%s]) \n", page, fullPageCnt);
			System.out.print("[명령어 : 예약, 위시리스트, 페이지 이동, 종료]\n" 
							 + " 예) \"예약, 1\" or \"페이지 이동, 3\"\n"
							 + "원하시는 명령어와 숫자를 입력해주세요 : ");
			
			String order = sc.nextLine();
			String[] orderlist = order.split(", ");
			Business.clearScreen();
			if (orderlist[0].equals("페이지 이동")) {
				page = orderlist[1];
				input = orderlist[1];
			} else if (orderlist[0].equals("종료")) {
				input = orderlist[0];
			} else {
				BasicMember.wishReservePage(list, listNames, e, order);
				break;
			}
			while(flag) {
				boolean ck = true;
				ck = isNum(input);
				
				if(ck == false) {
					//문자열 선택
					if(input.equals("종료")) {
						Business.clearScreen();
						
						System.out.println("종료합니다.");
						Business.memberMenu();
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
					}
				}
				// 가능한 이동 범위는 1 ~ fullPagecnt 까지
			}
		}
		
	} // paging(ArrayList<Board> listBoard, ArrayList<String> list, ArrayList<String> listNames , Member e)

	/**
	 * @param id 일반회원의 아이디
	 * @param pw 일반회원의 비밀번호
	 */

	//TODO 게시판 기능을 회원객체를 받아서 내부처리하는 것으로 변경할 것, 
	//TODO 익명 게시글 추가, 관리자 게시글 삭제
	//글 작성은 회원, 점주 vs 비회원
	public static void myBoardWrite(Member m) {
		Scanner sc = new Scanner(System.in);
		
		System.out.println("게시글 내용을 입력하세요");
		String input = sc.nextLine();
		
		Date now = new Date();
		SimpleDateFormat sdf = new SimpleDateFormat("YYYY년MM월dd일hh시mm분");
		String formatTime = sdf.format(now);
		
		String index = boardList.get(boardList.size()-1).getBoardIndex();
		
		index = (Integer.parseInt(index)+1)+"";
		
		Board tmp = new Board(index, m.getMemberId(), m.getMemberPw(), input, formatTime);
		boardList.add(tmp);
		
		
	}
	
	//게시글 삭제 기능은 관리자 vs 기본회원, 점주
	public static void myBoardDelete(Member m) {
		System.out.println("삭제할 게시글 번호를 입력하세요");
		String input = Business.scan.nextLine();
		
		boolean ch = isNum(input);
		
		if(ch == true) {
			 //입력값이 숫자인 경우
			 for(int i=0; i<boardList.size(); i++) {
				 String index = boardList.get(i).getBoardIndex();
				 String boardId = boardList.get(i).getBoardId();
				 
				 if(m.getMemberType().equals(strAdmin)) {
					 //관리자는 존재하는 모든 게시물을 삭제할 수 있다.
					 if(input.equals(index)) {
						 boardList.remove(i);
						 System.out.printf("%s 번 게시물이 삭제되었습니다. \n", input);
					 }
				 } else {
					 //관리자 외 일반회원, 점주는 입력한 인덱스와 아이디가 모두 일치해야 삭제할 수 있다.
					 if(input.equals(index) && m.getMemberId().equals(boardId)) {
						 //돌면서 입력받은 index 와 게시물의 index가 일치하고 아이디가 같으면
						 boardList.remove(i);
						 System.out.printf("%s 번 게시물이 삭제되었습니다. \n", input);
						 break;
						 
					 }
				 }
					 
				 if(i == boardList.size()-1) {
					 System.out.println("삭제할 게시물이 존재하지 않거나 본인이 작성한 게시물이 아닙니다.");
					
					 Business.toBoard();
					 
				 }
			 }
			 
		 } else {
			 //숫자가 아닌 경우
			 System.out.println("잘못된 입력입니다, 이전 메뉴로 돌아갑니다.");
		 }
		 
	}
	
	public static void myBoardView(String id) {
		ArrayList<Board> tmp = new ArrayList<>();
		
		for(int i=0; i<boardList.size(); i++) {
			 if(boardList.get(i).getBoardId().equals(id)) {
				 tmp.add(boardList.get(i));
			 }
		}	
		paging(tmp);
	}
	private static <T> void paging(ArrayList<T> list) { // 순수 게시판 페이징 

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
		int start = list.size()-1; //마지막 게시물에서 시작
		
		boolean flag = true;
		String input = "1";
		while(flag) {
			try {
				Business.clearScreen();

				if (list.get(0) instanceof MemberTable) {
					System.out.println("=====================================회원 목록===================================");
					System.out.println("[아이디] / [비밀번호] / [등급] / [이름] / [생년월일] / [전화번호] / [회원 이메일]\r\n");
				}
				
				for(int i = start - (pageNum * 10); i > start - (pageNum * 10 + 10); i--) {
					if (list.get(0) instanceof Board) {
						
						System.out.printf("%s\t%s\t%s\t%s\n", ((Board) list.get(i)).getBoardIndex()
															, ((Board) list.get(i)).getBoardId()
															, ((Board) list.get(i)).getWritingTime()
															, ((Board) list.get(i)).getBoardContent()
															);
					}  else if (list.get(0) instanceof MemberTable) {
						System.out.println(list.get(i));
					}
					if(i == 0) {
						break;
					} //마지막 페이지에 남은 게시물을 출력하고 멈추기 위해서.
				}

				System.out.print("이동할 페이지 번호를 입력하시거나 [종료] 입력시 이전 화면으로 돌아갑니다.\n");
				System.out.printf("첫페이지 [1] - 현재 페이지[%s] - 끝페이지[%s]\n", input, fullPageCnt);
				System.out.print("입력 : ");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println(e.getMessage() + e.toString());
			}
			
			
			while(flag) {
				
				input = sc.nextLine();
				
				boolean ck = true;
				ck = isNum(input);
				
				if(ck == false) {
					//문자열 선택
					if(input.equals("종료")) {
						
						if (list.get(0) instanceof MemberTable) {
							flag = false;
							Business.clearScreen();
							System.out.println("종료합니다.");
							if (Business.m.getMemberType().equals("회원")) {
								Business.memberMenu();
							} else if (Business.m.getMemberType().equals("비회원")) {
								Business.searchList();
							} else if (Business.m.getMemberType().equals("관리자")) {
								Admin.adminScreen();
							}
						} else if (list.get(0) instanceof Board) {
							Business.clearScreen();
							System.out.println("종료합니다.");
							if (Business.m.getMemberType().equals("회원")) {
								Business.memberMenu();
							} else if (Business.m.getMemberType().equals("비회원")) {
								Business.searchList();
							} else if (Business.m.getMemberType().equals("관리자")) {
								Admin.adminScreen();
							}
							
							
						}
					} else {
						System.out.print("잘못된 문자열 입력하셨네요, 재입력해주세요.");
					}
				} else {
					//범위내 페이지 이동
					if(Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= fullPageCnt) {
						pageNum = Integer.parseInt(input)-1;
						break;
					} else {
						System.out.print("존재하지 않는 페이지 입니다. 재입력해주세요.");
					}
				}
				// 가능한 이동 범위는 1 ~ fullPagecnt 까지
				 
			}
		}
		sc.close();
	}
	
	private static void pagingExt(ArrayList<String> list) { // 게시판 제외 페이징 (비회원 검색 조회)

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
		String input = "1";
		
		while(flag) {
			try {
				for(int i = start - (pageNum * 10); i > start - (pageNum * 10 + 10); i--) {
					
					System.out.printf(list.get(i));
					System.out.println();
					if(i == 0) {
						break;
					} //마지막 페이지에 남은 게시물을 출력하고 멈추기 위해서.
				}

				System.out.print("이동할 페이지 번호를 입력하시거나 [종료] 입력시 이전 화면으로 돌아갑니다.\n");
				System.out.printf("첫페이지 [1] - 현재 페이지[%s] - 끝페이지[%s]\n", input, fullPageCnt);
				System.out.print("입력 : ");
			} catch (Exception e) {
				// TODO: handle exception
				System.out.println("     게시글이 존재하지 않습니다.");
				Business.searchList();
			}
			
			
			while(flag) {
				input = sc.nextLine();
				Business.clearScreen();
				boolean ck = true;
				ck = isNum(input);
				
				if(ck == false) {
					//문자열 선택
					if(input.equals("종료")) {
						flag = false;
						System.out.println("종료합니다.");
						Business.searchList();
					} else {
						System.out.print("잘못된 문자열 입력하셨네요, 재입력해주세요.");
					}
				} else {
					//범위내 페이지 이동
					if(Integer.parseInt(input) >= 1 && Integer.parseInt(input) <= fullPageCnt) {
						pageNum = Integer.parseInt(input)-1;
						break;
					} else {
						System.out.print("존재하지 않는 페이지 입니다. 재입력해주세요.");
					}
				}
				// 가능한 이동 범위는 1 ~ fullPagecnt 까지
				 
			}
		}
		sc.close();
	}
	public static void myBoardModify(String id) {
		System.out.println("게시번호\t아이디\t본문\t작성일");
		for(Board b : boardList) {
			if(id.equals(b.getBoardId())) {
				System.out.println(b.toString());
			}
		}
		System.out.println();
		System.out.println("수정할 게시물의 번호를 입력하세요.");
		
		String input = Business.scan.nextLine();
		
		boolean ch = isNum(input);
		
		if(ch == true) {
			//숫자 이므로 제대로 입력받았으나 해당 게시물이 존재하는지 체크해야됨.
			for(int i=0; i<boardList.size(); i++) {
				
				 String index = boardList.get(i).getBoardIndex();
				 String boardId = boardList.get(i).getBoardId();
				 if(input.equals(index) && id.equals(boardId)) {
					 //돌면서 입력받은 index 와 게시물의 index가 일치하고 아이디가 같으면

					 //수정할 부분은 게시물 내용
					 System.out.println("수정할 본문 내용을 입력하세요.");
					 String newContent = Business.scan.nextLine();

					 boardList.get(i).setBoardContent(newContent);
					 Business.clearScreen();
					 System.out.println("게시물이 수정되었습니다.");
					 
					 Business.toBoard();
					 break;
				 }
				 if(i == boardList.size()-1) {
					 System.out.println("수정할 게시물이 존재하지 않습니다.");
				 }
			 }
			
		} else {
			//숫자가 아니므로 메소드가 종료
			System.out.println("잘못된 입력입니다.");
		}
	}
	
	
	/**
	 * 
	 * @param input : 사용자가 입력한 값
	 * @return : 숫자면 true 문자면 false
	 */
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
