package adminattendance;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import adminattendance.model.AdminAttendanceDAO;
import adminattendance.model.AdminAttendanceDTO;
import adminattendance.view.AdminAttendanceView;
import admingrade.model.AdminCourseDTO;
import admingrade.model.AdminGradeDAO;
import admingrade.model.AdminStudentInfoDTO;

public class AdminAttendanceClass {
	Scanner scan = new Scanner(System.in);
	AdminAttendanceView view = new AdminAttendanceView();	
	
	public void start() {
		boolean loop = true;
		
		while (loop) {
			view.menu();
			String sel = scan.nextLine();
			
			switch(sel) {
				case "1" :
					// 전체 출결 조회
					clearScreen();
					total_attendance_list();
					break;
				case "2" :
					// 출결 상태 수정
					clearScreen();
					attendance_students();
					break;
				default :
					loop = false;
			}
		}
	}

	private void attendance_students() { // 먼저 과거 & 현재 학생 목록 출력하여 학생 선택
		boolean loop = true;
		AdminGradeDAO dao = new AdminGradeDAO();
		ArrayList<AdminStudentInfoDTO> list = dao.student_grade_list();
		int rec = 5;
		int num = 1;
		
		while (loop) {
			
			
				int minus = 0;
				if (rec > list.size()) {
				    minus = rec - list.size();
				}
				System.out.println("-=-=-=-=-=-=-=-=-={학생 출결 조회}=-=-=-=-=-=-=-=-=-");
				for (int i = rec - 5; i < rec - minus; i++) {
					AdminStudentInfoDTO dto = list.get(i);
					
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
									   "[회원번호]   : " + dto.getStudent_seq() + "\n" +
								       "[학생이름]   : " + dto.getStudent_name() + "\n" +
									   "[주민번호]   : " + dto.getStudent_ssn() + "\n" +
								       "[과정명]     : " + dto.getCourse_name() + "\n" +
									   "[과정시작일] : " + dto.getCourse_start_date() + "\n" +
								       "[과정종료일] : " + dto.getCourse_end_date() + "\n" +
									   "[강의실명]   : " + dto.getCourse_classroom());
					
				}
				int page;
				
				if (list.size() % 5 == 0) {
					page = list.size() / 5;
				} else {
					page = (list.size() / 5) + 1;
				}
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
				System.out.printf("   현재 페이지[%d] - 총 페이지[%d]\n", num, page);
				System.out.println("옵션을 입력해주세요.\n예) \"페이지\" or \"학생\" or (돌아가기 : 0)");
				System.out.print("[입력 해주세요] : ");
				String order = scan.nextLine();
				
				if (order.equals("0")) {
					clearScreen();
					break;
				} else if (!order.equals("페이지") && !order.equals("학생")) {
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
					rec = num * 5;
					clearScreen();
				} else if (order.startsWith("학생")) {
					if (num > list.size()) {
						clearScreen();
						System.out.println("범위를 넘어섰습니다.");
						num = tempo;
						continue;
					}
					
					AdminAttendanceDAO dao_2 = new AdminAttendanceDAO();
					clearScreen();
					personal_attendance(dao_2.personal_attendance(num));
					
				} else {
					clearScreen();
					System.out.println("올바르지 않습니다.");
				}
				
		}
		
	}

	private void total_attendance_list() {
		AdminGradeDAO dao = new AdminGradeDAO();
		boolean loop = true;
		ArrayList<AdminCourseDTO> list = dao.course_list();
		int rec = 5;
		int num = 1;
		
		while(loop) {
			int minus = 0;
			if (rec > list.size()) {
			    minus = rec - list.size();
			}
			System.out.println("-=-=-=-=-=-=-=-={과정별 출결 조회}=-=-=-=-=-=-=-=-=-");
			for (int i = rec - 5; i < rec - minus; i++) {
				AdminCourseDTO dto = list.get(i);
				
				
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
								 "[번호]       : " + dto.getCourse_seq() + "\n" +
								 "[과정명]     : " + dto.getCourse_name() + "\n" +
								 "[과정시작일] : " +  dto.getCourse_start_date() + "\n" +
								 "[과정종료일] : " + dto.getCourse_end_date() + "\n" +
								 "[인원]       : " + dto.getCourse_stu_num());
			}
			// dao, datasource, view 
			int page;
			
			if (list.size() % 5 == 0) {
				page = list.size() / 5;
			} else {
				page = (list.size() / 5) + 1;
			}
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
			System.out.printf("   현재 페이지[%d] - 총 페이지[%d]\n", num, page);
			System.out.println("옵션을 입력해주세요.\n예) \"페이지\" or \"과정\" or (돌아가기 : 0)");
			System.out.print("[입력 해주세요] : ");
			String order = scan.nextLine();
			
			if (order.equals("0")) {
				clearScreen();
				break;
			} else if (!order.equals("페이지") && !order.equals("과정")) {
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
				rec = num * 5;
				clearScreen();
				continue;
			} else if (order.startsWith("과정")) {
				if (num > list.size()) {
					clearScreen();
					System.out.println("범위를 넘어섰습니다.");
					num = tempo;
					continue;
				}
			} else {
				clearScreen();
				System.out.println("올바르지 않습니다.");
				continue;
			}
			
			clearScreen();
			
			String year;
			
			while (true) {
				System.out.println("시작 연도를 입력해주세요. 예) 2016");
				System.out.print("[입력 해주세요] : ");
				year = scan.nextLine();
				 
				Pattern p = Pattern.compile("^[0-9]{4}$");
				Matcher m = p.matcher(year);
				
				if (m.find()) {
					if (1000 < Integer.parseInt(year) && Integer.parseInt(year) < 3000) {
						break;
					} else {
						System.out.println("올바른 년도를 입력해주세요.");
					}
				} else {
					clearScreen();
					System.out.println("올바르지 않은 값입니다.");
				}
			}
			clearScreen();
			
			String month;
			
			while (true) {
				System.out.println("달을 입력해주세요. 예) 4");
				System.out.print("[입력 해주세요] : ");
				month = scan.nextLine();
				
				Pattern p = Pattern.compile("^[0-9]{1,2}$");
				Matcher m = p.matcher(month);
				
				if (m.find()) {
					if (Integer.parseInt(month) > 0 && Integer.parseInt(month) < 13) {
						break;
					} else {
						System.out.println("올바른 월을 입력해주세요.");
					}
				} else {
					clearScreen();
					System.out.println("올바르지 않은 값입니다.");
				}
			}
			clearScreen();
			
			String day;
			
			while(true) {
				System.out.println("일을 입력해주세요. 예) 11");
				System.out.print("[입력 해주세요] : ");
				day = scan.nextLine();
				
				Pattern p = Pattern.compile("^[0-9]{1,2}$");
				Matcher m = p.matcher(day);
				
				if (m.find()) {
				
					boolean pass = false;
					
					pass = checkDayPass(year, month, day);
					
					if (pass) {
						break;
					} else {
						clearScreen();
						System.out.println("올바른 일을 입력해주세요.");
					}
				} else {
					clearScreen();
					System.out.println("올바르지 않은 값입니다.");
				}
			}
			clearScreen();
			
			String startdate = year + "-" + month + "-" + day;
			
			String endYear;
			
			while (true) {
				System.out.println("종료 연도를 입력해주세요. 예) 2017");
				System.out.print("[입력 해주세요] : ");
				endYear = scan.nextLine();
				
				Pattern p = Pattern.compile("^[0-9]{4}$");
				Matcher m = p.matcher(endYear);
				if (m.find()) {
					if ((1000 < Integer.parseInt(endYear) && Integer.parseInt(endYear) < 3000) 
						&& Integer.parseInt(endYear) >= Integer.parseInt(year)) {
						break;
					} else {
						System.out.println("올바른 년도를 입력해주세요.");
					}
				} else {
					clearScreen();
					System.out.println("올바른 값을 입력해주세요.");
				}
			}
			clearScreen();
			
			String endMonth;
			
			while (true) {
				System.out.println("달을 입력해주세요. 예) 5");
				System.out.print("[입력 해주세요] : ");
				endMonth = scan.nextLine();
				
				Pattern p = Pattern.compile("^[0-9]{1,2}$");
				Matcher m = p.matcher(endMonth);
				
				if (m.find()) {
			
					if ((Integer.parseInt(year) == Integer.parseInt(endYear)) 
					 && (Integer.parseInt(endMonth) >= Integer.parseInt(month) 
					 && Integer.parseInt(month) < 13)) {
						break;
					} else if ((Integer.parseInt(year) < Integer.parseInt(endYear)) 
						     && (Integer.parseInt(month) < 13 && 0 < Integer.parseInt(endMonth))) {
						System.out.println("올바른 월을 입력해주세요.");
					}
				} else {
					clearScreen();
					System.out.println("올바른 값을 입력해주세요.");
				}
			}
			clearScreen();
			
			String dayEnd;
			
			while (true) {
				System.out.println("일을 입력해주세요. 예) 22");
				System.out.print("[입력 해주세요] : ");
				dayEnd = scan.nextLine();
				
				Pattern p = Pattern.compile("^[0-9]{1,2}$");
				Matcher m = p.matcher(dayEnd);
				
				if (m.find()) {
					
					boolean pass = false;
				
					if ((Integer.parseInt(year) == Integer.parseInt(endYear)) 
				    && (Integer.parseInt(month) == Integer.parseInt(endMonth))) {
						if (endMonth.equals("1") 
								 || endMonth.equals("3") 
								 || endMonth.equals("5") 
								 || endMonth.equals("7")
								 || endMonth.equals("8")
								 || endMonth.equals("10")
								 || endMonth.equals("12") 
								 && (Integer.parseInt(dayEnd) > Integer.parseInt(day) && Integer.parseInt(dayEnd) < 32)) {
									pass = true;
								} else if ((endMonth.equals("2") && leapYear(endYear))
										&& (Integer.parseInt(dayEnd) > Integer.parseInt(day) 
										&& Integer.parseInt(dayEnd) < 29)) {
									pass = true;
								} else if ((endMonth.equals("2") && !leapYear(endYear)) 
										&& (Integer.parseInt(dayEnd) > Integer.parseInt(day) 
										&&  Integer.parseInt(dayEnd) < 28)) {
									pass = true;
								} else if ((endMonth.equals("4") 
										 || endMonth.equals("6")
										 || endMonth.equals("9")
										 || endMonth.equals("11")) 
										 && (Integer.parseInt(dayEnd) > Integer.parseInt(day) 
										 &&  Integer.parseInt(dayEnd) < 31)) {
								}
						
					} else {
						pass = checkDayPass(endYear, endMonth, dayEnd);
					}
				
					
					if (pass) {
						break;
					} else {
						System.out.println("올바른 일을 입력해주세요.");
						continue;
					}
				
				} else {
					clearScreen();
					System.out.println("올바르지 않은 값입니다.");
				}
			} 
			String enddate = endYear + "-" + endMonth + "-" + dayEnd;
			
			AdminAttendanceDAO dao_2 = new AdminAttendanceDAO();
			clearScreen();
			course_attendance(dao_2.course_attendance(num, startdate, enddate));
		
		}
	
	}

	private boolean checkDayPass(String year, String month, String day) {
		int dayInt = Integer.parseInt(day);
		boolean pass = false;
				if ((month.equals("1") 
				 || month.equals("3") 
				 || month.equals("5") 
				 || month.equals("7")
				 || month.equals("8")
				 || month.equals("10")
				 || month.equals("12")) && (dayInt < 32 && dayInt > 0)) {
			    	pass = true;
				} else if ((month.equals("2") && leapYear(year)) 
						&& (dayInt < 30 && dayInt > 0)) {
					pass = true;
				} else if ((month.equals("2") && !leapYear(year)) 
						&& (dayInt < 29 && dayInt > 0)) {
					pass = true;
				} else if ((month.equals("4") 
						 || month.equals("6")
						 || month.equals("9")
						 || month.equals("11")) && (dayInt > 0 && dayInt < 31)) {

				} else {
					pass = false;
				}
		return pass;
	}


	private boolean leapYear(String year) {
		int leapYear = Integer.parseInt(year);
		return ((leapYear % 4 == 0 && leapYear % 100 != 0) || leapYear % 400 == 0);
	}

	private void course_attendance(ArrayList<AdminAttendanceDTO> list) {
		boolean loop = true;
		
		int rec = 5;
		int num = 1;
		
		while(loop) {
			int minus = 0;
			if (rec > list.size()) {
			    minus = rec - list.size();
			}
			    System.out.println("-=-=-=-=-=-=-=-=-=-=-={출결 현황}=-=-=-=-=-=-=-=-=-=-");
			for (int i = rec - 5; i < rec - minus; i++) {
				AdminAttendanceDTO dto = list.get(i);
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
				System.out.println("[회원번호] : " + dto.getSeq() + "\n"  + 
						           "[학생명]   : " + dto.getName() + "\n" +
						           "[전화번호] : " + dto.getTel() + "\n"  +
						           "[등원시간] : " + dto.getInTime() + "\n" +
						           "[하원시간] : " + dto.getOutTime() + "\n" +
						           "[근태상황] : " + dto.getStatus());
			}
			
			int page;
			
			if (list.size() % 5 == 0) {
				page = list.size() / 5;
			} else {
				page = (list.size() / 5) + 1;
			}
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
			System.out.printf("------------------------현재 페이지[%d] - 총 페이지[%d]------------------\n", num, page);
			System.out.println("옵션을 입력해주세요.\n예) \"페이지\" or \"학생\" or (돌아가기 : 0)");
			System.out.print("[입력 해주세요] : ");
			String order = scan.nextLine();
			
			if (order.equals("0")) {
				clearScreen();
				break;
			} else if (!order.equals("페이지") && !order.equals("학생")) {
				clearScreen();
				System.out.println("올바르지 않은 옵션입니다.");
				continue;
			}
			
			System.out.println("번호를 입력해주세요.");
			System.out.print("[입력 해주세요] : ");
			String temp = scan.nextLine();
			int tempo = num;
			num = Integer.parseInt(temp);
	
			if (order.equals("페이지")) {
				if (num > page) {
					clearScreen();
					System.out.println("범위를 넘어섰습니다.");
					num = tempo;
					continue;
				}
				rec = num * 5;
				clearScreen();
			} else if (order.startsWith("학생")) {
				if (num > list.size()) {
					clearScreen();
					System.out.println("범위를 넘어섰습니다.");
					num = tempo;
					continue;
				}
				AdminAttendanceDAO dao = new AdminAttendanceDAO();
				clearScreen();
				personal_attendance(dao.personal_attendance(num));
			} else {
				clearScreen();
				num = tempo;
				System.out.println("올바르지 않습니다.");
			}
			
		}
	
	}

	private void personal_attendance(ArrayList<AdminAttendanceDTO> list) {
		boolean loop = true;
		int rec = 5;
		int num = 1;

		while (loop) {
			
			
				int minus = 0;
				if (rec > list.size()) {
				    minus = rec - list.size();
				}
					System.out.println("-=-=-=-=-=-=-=-=-=-={개인 출결 현황}=-=-=-=-=-=-=-=-=-");
				for (int i = rec - 5; i < rec - minus; i++) {
					AdminAttendanceDTO dto = list.get(i);
					
					System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n" +
									"[출결번호] : " + dto.getSeq() + "\n" +
									"[학생명]   : " + dto.getName() + "\n" +
									"[과정명]   : " + dto.getCourse_name() + "\n" +
									"[등원시간] : " + dto.getInTime() + "\n" +
									"[하원시간] : " + dto.getOutTime() + "\n" +
									"[근태상황] : " + dto.getStatus());
				}
				int page;
				
				if (list.size() % 5 == 0) {
					page = list.size() / 5;
				} else {
					page = (list.size() / 5) + 1;
				}
				System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-");
				System.out.printf("------------------------현재 페이지[%d] - 총 페이지[%d]------------------\n", num, page);
				System.out.println("옵션을 입력해주세요.\n 예) \'페이지\' or \'수정\' or \'종료(0)\'");
				System.out.print("[입력 해주세요] : ");
				String order = scan.nextLine(); 
				
				if (order.equals("0")) { 
					clearScreen();
					break; 
				} else if (!order.equals("페이지") && !order.equals("수정")) {
					clearScreen();
					System.out.println("올바르지 않은 옵션입니다.");
					continue;
				}
				System.out.println("번호를 입력해주세요.");
				System.out.print("[입력 해주세요] : ");
				int temp = num;
				num = scan.nextInt();
				scan.skip("\r\n");
				
				if (order.equals("페이지")) {
					if (num > page) {
						clearScreen();
						System.out.println("범위를 넘어섰습니다.");
						continue;
					}
					rec = num * 5;
					clearScreen();
				} else if (order.equals("수정")) {
					if (seqValidCheck(list, num)) {
						clearScreen();
						fix_attendance_status(num);	
						return;
					} else {
						clearScreen();
						System.out.println("올바르지 않은 숫자입니다.");
						num = temp;
						continue;
					}
					
				}
		}
		
	}

	private boolean seqValidCheck(ArrayList<AdminAttendanceDTO> list, int num) {
		int count = 0;
		for (AdminAttendanceDTO dto : list) {
			if (Integer.parseInt(dto.getSeq()) == num) {
				count++;
			}
		}
		
		if (count > 0) {
			return true;
		} else {
			return false;
		}
	}

	private void fix_attendance_status(int num) {
		AdminAttendanceDAO dao = new AdminAttendanceDAO();
		boolean loop = true;
		
		while (loop) {
			System.out.println("-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-=-\n");
			System.out.println("            {수정할 상태를 입력해주세요}");
			System.out.println("              예) \'병가\', \'외출\'");
			System.out.print("                         입력 : ");
			String sel = scan.nextLine();
			
			int result = dao.fix_attendance_status(num, sel);
			
			if (result == 1) {
				clearScreen();
				System.out.println("성공적으로 상태가 변경되었습니다.");
				loop = false;
			} else { 
				clearScreen();
				System.out.println("오류가 발생했습니다.");
				continue;
			}
		}
	}

	private static void clearScreen() {
		for (int i = 0; i < 50; i++) {
			System.out.println();
		}
	}
}
