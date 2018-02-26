package teacher.model;

public class TeacherStudentAttendanceListDTO {

	/*
	 * 출결 관리 및 출결 조회
	 * 
	 * 교사가 강의한 과목의 모든 교육생들의 출결을 조회하기 위한 DTO
	 * 
	 * 학생이름,
	 * 학생출근시간,
	 * 학생퇴근시간,
	 * 학생근태,
	 *
	 */
	
	private String studentName;
	private String studentAttIn;
	private String studentAttOut;
	private String StudentattStatus;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentAttIn() {
		return studentAttIn;
	}
	public void setStudentAttIn(String studentAttIn) {
		this.studentAttIn = studentAttIn;
	}
	public String getStudentAttOut() {
		return studentAttOut;
	}
	public void setStudentAttOut(String studentAttOut) {
		this.studentAttOut = studentAttOut;
	}
	public String getStudentattStatus() {
		return StudentattStatus;
	}
	public void setStudentattStatus(String studentattStatus) {
		StudentattStatus = studentattStatus;
	}
	@Override
	public String toString() {
		return String.format(
				"TeacherStudentAttendanceListDTO [studentName=%s, studentAttIn=%s, studentAttOut=%s, StudentattStatus=%s]",
				studentName, studentAttIn, studentAttOut, StudentattStatus);
	}
	
	
}
