package adminreview;

import java.util.ArrayList;
import java.util.Scanner;

import adminreview.model.AdminReviewDAO;
import adminreview.model.AdminReviewListDTO;
import adminreview.view.AdminReviewView;

public class AdminReviewClass {
	Scanner scan;
	AdminReviewView view;
	AdminReviewDAO dao;
	
	public AdminReviewClass() {
		scan = new Scanner(System.in);
		view = new AdminReviewView();
		dao = new AdminReviewDAO();
	}



	public void start() {
		boolean loop = true;
		
		while (loop) {
			view.menu();
			String sel = scan.nextLine();
			
			switch(sel) {
				case "1" :
					clearScreen();
					review_list();
					break;
				default :
					loop = false;
					clearScreen();
			}
			
		} // while
	}



	private void review_list() {
		boolean loop = true;
		ArrayList<AdminReviewListDTO> list = dao.review_list();
		
		int rec = 1;
		int num = 1;
		
		while (loop) {
			
				int minus = 0;
				if (rec > list.size()) {
				    minus = rec - list.size();
				}
				
				System.out.println("-=-=-=-=-=-=-=-=-=-=-={수강평}=-=-=-=-=-=-=-=-=-=-=-=-");
				for (int i = rec - 1; i < rec - minus; i++) {
					AdminReviewListDTO dto = list.get(i);
					
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
										"[수강번호] : " +
									   dto.getSeq() + "\n" +
									    "[과정명]   : " +
									   dto.getName() + "\n" +
									    "[수강평]   : " +
									   fix_review(dto.getReview()));
				}
				int page;
				
				if (list.size() % 1 == 0) {
					page = list.size() / 1;
				} else {
					page = (list.size() / 1) + 1;
				}
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
				System.out.printf("   현재 페이지[%d] - 총 페이지[%d]\n", num, page);
				System.out.println("옵션을 입력해주세요.\n예) \"페이지\" or \"삭제\" or (돌아가기 : 0)");
				System.out.print("[입력 해주세요] : ");
				String order = scan.nextLine();
				
				if (order.equals("0")) {
					clearScreen();
					break;
				} else if (!order.equals("페이지") && !order.equals("삭제")) {
					clearScreen();
					System.out.println("올바르지 않은 옵션입니다.");
					continue;
				}
				
				System.out.println("번호를 입력해주세요.");
				System.out.print("[입력 해주세요] : ");
				int tempo = num;
				String temp = scan.nextLine();
				num = Integer.parseInt(temp);
			
				if (order.equals("페이지")) {
					if (num > page) {
						clearScreen();
						System.out.println("범위를 넘어섰습니다.");
						num = tempo;
						continue;
					}
					rec = num;
					clearScreen();
				} else if (order.startsWith("삭제")) {
					if (num > list.size()) {
						clearScreen();
						System.out.println("범위를 넘어섰습니다.");
						num = tempo;
						continue;
					}
					clearScreen();
					review_del(num);
					return;
				} else {
					clearScreen();
					System.out.println("올바르지 않습니다.");
				}
				
		}
	}



	private String fix_review(String review) {
		String newReview = "";
		
		if (review.length() % 8 == 0) {
			for (int i = 0; i < review.length(); i = i + 8) {
				newReview = newReview + review.substring(i, i + 8) + "\n" + "             ";
			}
		} else if (review.length() % 9 == 0) {
				for (int i = 0; i < review.length(); i = i + 9) {
					newReview = newReview + review.substring(i, i + 9) + "\n" + "             ";
				}
		} else if (review.length() % 10 == 0) {
			for (int i = 0; i < review.length(); i = i + 10) { 
				newReview = newReview + review.substring(i, i + 10) + "\n" + "             ";
			}
		} else if (review.length() % 11 == 0){
			for (int i = 0; i < review.length(); i = i + 11) {
				newReview = newReview + review.substring(i, i + 11) + "\n" + "             ";
			}
		} else if (review.length() % 12 == 0) {
			for (int i = 0; i < review.length(); i = i + 12) {
				newReview = newReview + review.substring(i, i + 12) + "\n" + "             ";
			}
		} else if (review.length() % 13 == 0) {
			for (int i = 0; i < review.length(); i = i + 13) {
				newReview = newReview + review.substring(i, i + 13) + "\n" + "             ";
			}
		} else if (review.length() % 14 == 0) {
			for (int i = 0; i < review.length(); i = i + 14) {
				newReview = newReview + review.substring(i, i + 14) + "\n" + "             ";
			}
		} else if (review.length() % 15 == 0) {
			for (int i = 0; i < review.length(); i = i + 15) {
				newReview = newReview + review.substring(i, i + 15) + "\n" + "             ";
			}
		} else if (review.length() % 16 == 0) {
			for (int i = 0; i < review.length(); i = i + 16) {
				newReview = newReview + review.substring(i, i + 16) + "\n" + "             ";
			}
		} else if (review.length() % 17 == 0) {
			for (int i = 0; i < review.length(); i = i + 17) {
				newReview = newReview + review.substring(i, i + 17) + "\n" + "             ";
			}
		} else {
			newReview = review;
		}
		
		return newReview;
	}



	private void review_del(int num) { // 수강평 삭제
		int result = dao.review_del(num);
		
		if (result == 1) {
			System.out.println("성공적으로 삭제를 완료 하였습니다.");
		} else if (result == 0 || result == 2) {
			System.out.println("삭제에 실패하였습니다.");
		}
		
		
	}
	private static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
}
