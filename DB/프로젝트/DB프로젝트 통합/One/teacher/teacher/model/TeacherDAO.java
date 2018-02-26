package teacher.model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

import model.DBAccess;
import model.DataSource;
import oracle.jdbc.internal.OracleTypes;

public class TeacherDAO {

	private Connection conn;
	private DataSource ds;
	
	public TeacherDAO() {
		try {
			ds = new DataSource();
			conn = DBAccess.open();
		} catch (Exception e) {
			System.out.println("TeacherDAO.Constructor : " + e.toString());
		}
	}
	
	
	public ArrayList<TeacherScheduleListDTO> Schedulelist(String seq){
		//교사 본인의 전체 스케쥴을 조회
		
		PreparedStatement stat = null;
		
		try {

			stat = conn.prepareStatement(ds.get("Teacher.Schedulelist"));
			stat.setString(1, seq);
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<TeacherScheduleListDTO> list = new ArrayList<>();
			
			while (rs.next()) {
				TeacherScheduleListDTO dto = new TeacherScheduleListDTO();
				
				dto.setSubjectStatus(rs.getString("강의일정"));		//1
				dto.setSubjectSeq(rs.getString("과목번호"));		//2
				dto.setSubjectName(rs.getString("과목명"));			//3
				dto.setSubjectStartDate(rs.getString("과목시작일"));//4
				dto.setSubjectEndDate(rs.getString("과목종료일"));	//5
				dto.setCourseName(rs.getString("과정명"));			//6
				dto.setCourseStartDate(rs.getString("과정시작일"));	//7
				dto.setCourseEndDate(rs.getString("과정종료일"));	//8
				dto.setClassroomName(rs.getString("강의실명"));		//9
				dto.setBookName(rs.getString("교재명"));			//10
				dto.setStudentEnrollNum(rs.getString("교육생등록인원"));//11
				
				list.add(dto);
			}
			rs.close();
			
			return list;	
			
		} catch (Exception e) {
			System.out.println("TeacherDAO.list : " + e.toString());
		}
		
		return null;
	}

	public ArrayList<TeacherEditGradingDTO> gradingList(String mseq) {
		// 배점 변경할 과목 목록을 보여주는 메소드
		PreparedStatement stat = null;
		
		try {
			
			stat = conn.prepareStatement(ds.get("Teacher.gradingList"));
			stat.setString(1, mseq);
			
			ResultSet rs = stat.executeQuery();
			
			ArrayList<TeacherEditGradingDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				TeacherEditGradingDTO dto = new TeacherEditGradingDTO();
				
				dto.setSubjectSeq(rs.getInt("과목번호"));
				dto.setSubjectName(rs.getString("과목명"));
				dto.setSubjectStartDate(rs.getString("과목시작일"));
				dto.setSubjectEndDate(rs.getString("과목종료일"));
				dto.setCourseName(rs.getString("과정명"));
				dto.setCourseStartDate(rs.getString("과정시작일"));
				dto.setCourseEndDate(rs.getString("과정종료일"));
				dto.setClassroomName(rs.getString("강의실명"));
				dto.setBookName(rs.getString("교재명"));
				dto.setGradingAttendance(rs.getString("출결배점"));
				dto.setGradingWriting(rs.getString("필기배점"));
				dto.setGradingPractical(rs.getString("실기배점"));
				dto.setExamDate(rs.getString("시험날짜"));
				dto.setGradingStandardSeq(rs.getInt("배점번호"));
			
				list.add(dto);
			}
			rs.close();
			
			return list;
			
		} catch (Exception e) {
			System.out.println("TeacherDAO.gradingList : " + e.toString());
		}
		
		
		return null;
	}

	public void updateGrading(TeacherGradingtblDTO tmp) {		
		
		try {
			
			PreparedStatement stat = conn.prepareStatement(ds.get("Teacher.updateGrading"));
			stat.setString(1, tmp.getGradingAttance());
			stat.setString(2, tmp.getGradingWriting());
			stat.setString(3, tmp.getGradingPractical());
			stat.setDate(4, java.sql.Date.valueOf(tmp.getExamDate()));
			stat.setInt(5, tmp.getGradingStandardSeq());
			
			stat.executeUpdate();
			
		} catch (Exception e) {
			System.out.println("TeacherDAO.updateGrading : " + e.toString());
		}
	}

	public ArrayList<FinishedSubjectListDTO> finishedSubjectList(String mseq) {
		
		PreparedStatement pstat = null;
		
		try {
			pstat = conn.prepareStatement(ds.get("Teacher.finishedSubjectList"));
			
			pstat.setString(1, mseq); // 쿼리에 교사 본인의 회원번호를 패치한다.
			
			ResultSet rs = pstat.executeQuery();
			
			ArrayList<FinishedSubjectListDTO> list = new ArrayList<>();
			
			while(rs.next()) {
				FinishedSubjectListDTO dto = new FinishedSubjectListDTO();
				dto.setSubjectSeq(rs.getInt("과목번호"));
				dto.setSubjectStartDate(rs.getString("과목시작일"));
				dto.setSubjectEndDate(rs.getString("과목종료일"));
				dto.setCourseName(rs.getString("과정명"));
				dto.setCourseStartDate(rs.getString("과정시작일"));
				dto.setCourseEndDate(rs.getString("과정종료일"));
				dto.setClassroomName(rs.getString("강의실명"));
				dto.setBookName(rs.getString("교재명"));
				dto.setGradingAttendance(rs.getString("출결배점"));
				dto.setGradingWriting(rs.getString("필기배점"));
				dto.setGradingPractical(rs.getString("실기배점"));
				dto.setCheckInputScore(rs.getString("성적등록여부"));
				
				list.add(dto);
				//DB 에서 가져온 레코드 한개(dto) 를 list 에 저장.
			}
			rs.close();
			
			return list;
			
		} catch (Exception e) {
			
			System.out.println("TeacherDAO.FinishedSubjectList : " + e.toString());
		}
		
		return null;
	}

	public ArrayList<TeacherStudentScoreListDTO> teacherStudentList(String input) {
		
		PreparedStatement pstat = null;
		ArrayList<TeacherStudentScoreListDTO> list = new ArrayList<>();
		
		try {
			pstat = conn.prepareStatement(ds.get("Teacher.teacherStudentList"));
			pstat.setString(1, input);
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				TeacherStudentScoreListDTO dto = new TeacherStudentScoreListDTO();
				dto.setStudentSeq(rs.getInt("학생번호"));
				dto.setStudentName(rs.getString("학생이름"));
				dto.setStudentTel(rs.getString("학생전화번호"));
				dto.setStudentGradeAttendance(rs.getString("출결점수"));
				dto.setStudentGradeWriting(rs.getString("필기점수"));
				dto.setStudentGradePractical(rs.getString("실기점수"));
				dto.setStudentDropout(rs.getString("중도탈락여부"));
				dto.setStudentDropoutDate(rs.getString("중도탈락날짜"));
				dto.setStudentGradeSeq(rs.getInt("학생성적번호"));
				
				list.add(dto);
			}
			
			rs.close();
			return list;
			
		} catch (Exception e) {
			System.out.println("TeacherStudentList : " + e.toString());
		}
		return null;
	}


	public int updateStudentGrade(TeacherStudentScoreListDTO dto) {
		//넘겨받은 학생성적정보를 DB에 업데이트 해준다.
		CallableStatement stat = null;
		
		try {
			
			stat = conn.prepareCall(ds.get("Teacher.updateStudentGrade"));
			
			stat.setString(1, dto.getStudentGradeAttendance());
			stat.setString(2, dto.getStudentGradeWriting());
			stat.setString(3, dto.getStudentGradePractical());
			stat.setInt(4, dto.getStudentGradeSeq());
			stat.registerOutParameter(5, OracleTypes.NUMBER);
			
			stat.executeUpdate();
			
			return stat.getInt(5);
			
		} catch (Exception e) {
			System.out.println("TeacherDAO.updateStudentGrade : " + e.toString());
		}
		return 0;
	}


	public ArrayList<TeacherStudentAttendanceListDTO> listForStudentAttendance(String mseq) {
		//교사 번호를 토대로 학생들의 출결 조회하는 메소드
		/*
		 *학생이름
		 *학생출근시간
		 *학생퇴근시간
		 *학생근태
		 *교사번호 <- 조건만 주고 출력은 X
		 */
		PreparedStatement pstat = null;
		ArrayList<TeacherStudentAttendanceListDTO> list = new ArrayList<>();
		
		try {
			pstat = conn.prepareStatement(ds.get("Teacher.listForStudentAttendance"));
			pstat.setString(1, mseq); //교사번호를 매칭
			
			ResultSet rs = pstat.executeQuery();
			
			while(rs.next()) {
				TeacherStudentAttendanceListDTO dto = new TeacherStudentAttendanceListDTO();
				
				dto.setStudentName(rs.getString("학생이름"));
				dto.setStudentAttIn(rs.getString("학생출근시간"));
				dto.setStudentAttOut(rs.getString("학생퇴근시간"));
				dto.setStudentattStatus(rs.getString("학생근태"));
				
				list.add(dto);
			}
			rs.close();
			return list;
			
			
		} catch (Exception e) {
			
			System.out.println("TeacherDAO.listForStudentAttendance : " + e.toString());
		}
		
		return null;
	}
	
}
