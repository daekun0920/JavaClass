package teacher;

import java.util.ArrayList;
import java.util.Scanner;

import member.auth.Auth;
import teacher.model.FinishedSubjectListDTO;
import teacher.model.TeacherDAO;
import teacher.model.TeacherEditGradingDTO;
import teacher.model.TeacherGradingtblDTO;
import teacher.model.TeacherScheduleListDTO;
import teacher.model.TeacherStudentAttendanceListDTO;
import teacher.model.TeacherStudentScoreListDTO;
import teacher.view.TeacherView;

public class TeacherClass {

	private TeacherDAO dao;
	private TeacherView view;
	private Auth auth;
	private Scanner scan;

	public TeacherClass() {
		dao = new TeacherDAO();
		view = new TeacherView();
		auth = new Auth();
		scan = new Scanner(System.in);
	}
	
	public void start(Auth auth) {
		
		this.auth = auth;
		boolean loop = true;
		while (loop) {
			view.menu();
			
			int input = scan.nextInt();
			scan.skip("\r\n");
			switch(input) {
				case 1: TeacherScheduleList(Auth.mseq); break;				// 교사 본인의 강의 스케쥴 조회
				case 2: TeacherEditGrading(Auth.mseq); break;				// 교사 배점 입력
				case 3: TeacherSubjectGrade(Auth.mseq); break;				// 교사 성적 관리
				case 4: TeacherStudentAttenceList(Auth.mseq); break;		// 교사 자신 교육생 출결 조회
				default: loop = false; break;
			}
		}
	}

	private void TeacherStudentAttenceList(String mseq) {
		view.commentStartForListAtt("학생 출결 조회를 시작합니다.");
		
		ArrayList<TeacherStudentAttendanceListDTO> list = dao.listForStudentAttendance(mseq);
		
		for(TeacherStudentAttendanceListDTO dto : list) {
			System.out.println("[학생이름]\t: " + dto.getStudentName());
			System.out.println("[학생출근시간]\t: " + dto.getStudentAttIn());
			System.out.println("[학생퇴근시간]\t: " + dto.getStudentAttOut());
			System.out.println("[학생근태]\t: " + dto.getStudentattStatus());
			view.endFor();
		}
	}

	private void TeacherSubjectGrade(String mseq) {
		//성적 입력 이전, 종료된 과목을 보여주는 메소드
		
		ArrayList<FinishedSubjectListDTO> list = dao.finishedSubjectList(mseq);
		
		for(FinishedSubjectListDTO dto : list) {
			System.out.println("[과목번호]\t: " + dto.getSubjectSeq());
			System.out.println("[과목시작일]\t: " + dto.getSubjectStartDate());
			System.out.println("[과목종료일]\t: " + dto.getSubjectEndDate());
			System.out.println("[과정명]\t: " + dto.getCourseName());
			System.out.println("[과정시작일]\t: " + dto.getCourseStartDate());
			System.out.println("[과정종료일]\t: " + dto.getCourseEndDate());
			System.out.println("[강의실명]\t: " + dto.getClassroomName());
			System.out.println("[교재명]\t: " + dto.getBookName());
			System.out.println("[출결배점]\t: " + dto.getGradingAttendance());
			System.out.println("[필기배점]\t: " + dto.getGradingWriting());
			System.out.println("[실기배점]\t: " + dto.getGradingPractical());
			System.out.println("[성적등록여부]\t: " + dto.getCheckInputScore());
			
			view.endFor();
		}
		System.out.printf(">>>>>>> 총 [%d] 개의 종료된 과목을 조회했습니다. \n", list.size());
		
		System.out.println("=============================================================");
		System.out.print(">> 성적입력하실 과목번호를 입력하세요. \n"
				+ ">> 종료를 입력하시면 이전 메뉴로 돌아갑니다. : ");
		
		String inputSubjectNum = scan.nextLine();
		//입력받은 과목번호를 수강 중인 교육생 정보 출력
		
		if(inputSubjectNum.equals("종료")) {
			view.closeScore();
			return;
		}
		
		ArrayList<TeacherStudentScoreListDTO> studentList = dao.teacherStudentList(inputSubjectNum);
		
		System.out.println("=====================[교육생 정보]========================");
		for(TeacherStudentScoreListDTO dto : studentList) {
			System.out.println("[학생번호]\t: " + dto.getStudentSeq() + "\r\n");
			System.out.println("[학생이름]\t: " + dto.getStudentName());
			System.out.println("[학생전화번호]\t: " + dto.getStudentTel());
			System.out.println("[출결점수]\t: " + dto.getStudentGradeAttendance());
			System.out.println("[필기점수]\t: " + dto.getStudentGradeWriting());
			System.out.println("[실기점수]\t: " + dto.getStudentGradePractical());
			System.out.println("[중도탈락여부]\t: " + dto.getStudentDropout());
			System.out.println("[중도탈락날짜]\t: " + dto.getStudentDropoutDate());
			System.out.println();
			System.out.println("=============================================================");
		}
		System.out.printf(">>>>>>> 총 [%d] 명의 교육생을 조회했습니다. \n", studentList.size());
		
		System.out.println("=============================================================");
		
		//출력된 학생번호를 선택하면 해당 학생 성적을 갱신해준다. 출결 / 필기 / 실기 점수.
		//성적테이블에 넣을 번호 존재, 해당
		
		System.out.print(">> 성적을 입력하실 학생번호를 입력하세요 : ");
		String inputStudentNum = scan.nextLine();
		
		for(TeacherStudentScoreListDTO dto : studentList) {
			if(dto.getStudentSeq() == Integer.parseInt(inputStudentNum)) {

				System.out.printf("[%s] 학생의 성적을 입력을 시작합니다.", dto.getStudentName());
				System.out.println();
				
				System.out.print(">> 출결 점수를 입력하세요 : ");
				String attScore = scan.nextLine();
				
				System.out.print(">> 필기 점수를 입력하세요 : ");
				String writingScore = scan.nextLine();
				
				System.out.print(">> 실기 점수를 입력하세요 : ");
				String practicalScore = scan.nextLine();
				
				dto.setStudentGradeAttendance(attScore);
				dto.setStudentGradeWriting(writingScore);
				dto.setStudentGradePractical(practicalScore);
				
				int result = dao.updateStudentGrade(dto);
				
				if(result == 1) {
					System.out.println(">> 성적 입력에 성공하셨습니다.");
				} else {
					System.out.println(">> 성적 입력 실패!!!");
				}
			}
		}
		view.closeScore();
		
	}

	private void TeacherEditGrading(String mseq) {
		
		//1. 교사번호를 전달받음
		//2. 해당값을 통해 과목 목록을 출력하는 메소드 호출
		//3. 특정 과목을 입력받는다.
		//4. 해당 과목의 배점을 입력받는다. 출결, 필기, 실기
		//5. update 쿼리 실행
		
		ArrayList<TeacherEditGradingDTO> list = dao.gradingList(mseq);

		System.out.println("=====================[종료된 강의 목록]========================");
		
		for(TeacherEditGradingDTO dto : list) {
			System.out.println("[과목번호]\t: " + dto.getSubjectSeq());
			System.out.println("[과목명]\t: " + dto.getSubjectName());
			System.out.println("[과목시작일]\t: " + dto.getSubjectStartDate().substring(0, 10));
			System.out.println("[과목종료일]\t: " + dto.getSubjectEndDate().substring(0, 10));
			System.out.println("[과정명]\t: " + dto.getCourseName());
			System.out.println("[과정시작일]\t: " + dto.getCourseStartDate().substring(0, 10));
			System.out.println("[과정종료일]\t: " + dto.getCourseEndDate().substring(0, 10));
			System.out.println("[강의실명]\t: " + dto.getClassroomName());
			System.out.println("[교재명]\t: " + dto.getBookName());
			System.out.println("[출결배점]\t: " + dto.getGradingAttendance());
			System.out.println("[필기배점]\t: " + dto.getGradingWriting());
			System.out.println("[실기배점]\t: " + dto.getGradingPractical());
			System.out.println("[시험날짜]\t: " + dto.getExamDate().substring(0, 10));
			
			System.out.println("=============================================================");
		}
		System.out.printf(">>>>>>> 총 [%d] 개의 종료된 강의을 조회했습니다. \n", list.size());
		
		view.inputRequest();
		String subjectSeq = scan.nextLine();
		
		if(subjectSeq.equals("종료")) {
			
			view.closeGrading();
			return;
		}
		
		//이후 해당 메소드는 넘겨받은 dto 에서 출결, 필기, 실기, 시험날짜 을 입력받아 저장 (유효성 검사 총점 100점)
		//저장한 dto 를 실제로 저장하기 위해 dao 메소드를 호출한다.
		
		
		TeacherGradingtblDTO tmp = new TeacherGradingtblDTO();
		for(TeacherEditGradingDTO dto : list) {
			if(dto.getSubjectSeq() == Integer.parseInt(subjectSeq)) {
				tmp.setGradingStandardSeq(dto.getGradingStandardSeq());
				tmp.setGradingAttance(dto.getGradingAttendance());
				tmp.setGradingWriting(dto.getGradingWriting());
				tmp.setGradingPractical(dto.getGradingPractical());
				tmp.setExamDate(dto.getExamDate());
			}
		}//
		gradingInputCheck(tmp);
		//tbl_grading_standard 에 update 할 dto 완성
		//dao 에 tmp 를 전달하여 db 에 tmp update
		dao.updateGrading(tmp);
		
	}
	private void gradingInputCheck(TeacherGradingtblDTO tmp) {
		
		boolean loop = true;
		String grading_Att_input = "";
		String grading_writing_input = "";
		String grading_prac_input = "";
		String examDate_input = "";
		
		while(loop) {
			System.out.print(">> 출결 배점을 입력하세요 : ");
			grading_Att_input = scan.nextLine();
	
			
			System.out.print(">> 필기 배점을 입력하세요 : ");
			grading_writing_input = scan.nextLine();
			
			
			System.out.print(">> 실기 배점을 입력하세요 : ");
			grading_prac_input = scan.nextLine();
			
			int total = Integer.parseInt(grading_Att_input) + Integer.parseInt(grading_writing_input) + Integer.parseInt(grading_prac_input);
			
			if( total != 100) {
				//배점총점이 100 점이 아니면 잘못된 입력값으로 재입력을 받는다.
				System.out.printf("입력하신 총점은 [ %d ] 점 입니다. 총점은 100 점이어야 합니다. 재입력해주세요. \n", total);
				continue;
			
			} else {
				//총점이 100 점으로 올바른 경우 시험날짜를 입력받는다.
				
				while(loop) {
					
					System.out.println("시험 날짜를 입력하세요. [ex] 2022-01-01");
					examDate_input = scan.nextLine();
					
					String pattern = "^[0-9][0-9][0-9][0-9]\\-[0-9][0-9]\\-[0-9][0-9]$"; // ^시작,$끝
			    
					if (!examDate_input.matches(pattern)) {// (년도-월-일) 의 패턴으로 넘어오는지 체크 
				        System.out.println("년월일의 패턴이 아닙니다.");
				        continue;
				        //else 아래에서 루프 돌아서 날짜를 재입력받는다.
				    } else {
				    	//날짜 형식이 올바르므로 루프를 끝낸다.
				    	loop = false;
				    }
				}
			}
		}//End while
		//유효한 값들을 tmp 에 저장한다.
		
		tmp.setGradingAttance(grading_Att_input);
		tmp.setGradingWriting(grading_writing_input);
		tmp.setGradingPractical(grading_prac_input);
		tmp.setExamDate(examDate_input);
	}
	

	private void TeacherScheduleList(String mseq) {

		ArrayList<TeacherScheduleListDTO> list = dao.Schedulelist(mseq);
		
		System.out.println("[강의 스케쥴 조회]");
		
		
		for(TeacherScheduleListDTO dto : list) {
			System.out.println("[강의일정]\t: "+ dto.getSubjectStatus());
			System.out.println("[과목번호]\t: "+ dto.getSubjectSeq());
			System.out.println("[과목명]\t: "+ dto.getSubjectName());
			System.out.println("[과목시작일]\t: "+ dto.getSubjectStartDate());
			System.out.println("[과목종료일]\t: "+ dto.getSubjectEndDate());
			System.out.println("[과정명]\t: "+ dto.getCourseName());
			System.out.println("[과정시작일]\t: "+ dto.getCourseStartDate());
			System.out.println("[과정종료일]\t: "+ dto.getCourseEndDate());
			System.out.println("[강의실명]\t: "+ dto.getClassroomName());
			System.out.println("[교재명]\t: "+ dto.getBookName());
			System.out.println("[교육생등록인원]: "+ dto.getStudentEnrollNum() + "명");
			
			System.out.println("=============================================================");
		}
		System.out.printf(">>>>>>> 총 [%d] 개의 강의 스케쥴을 조회했습니다. \n", list.size());
		
		System.out.println("=============================================================");
		
		System.out.println();
		System.out.println("============================[강의 스케쥴 조회 완료]============================");
	}

	
}
