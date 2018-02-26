package teacher.model;

public class TeacherStudentScoreListDTO {

	
	/*
	 * 성적 입출력 -> 특정과목 선택 -> 교육생 정보 저장 DTO
	 * 
	 * 학생번호,
	 * 학생이름,
	 * 학생전화번호,
	 * 출결점수,
	 * 필기점수,
	 * 실기점수
	 * 중도탈락여부
	 * 중도탈락날짜
	 * 과목번호
	 * 학생성적시퀀스
	 */
	
	private int studentSeq;
	private String studentName;
	private String studentTel;
	private String studentGradeAttendance;
	private String studentGradeWriting;
	private String studentGradePractical;
	private String studentDropout;
	private String studentDropoutDate;
	private String subjectSeq;
	private int studentGradeSeq;
	
	
	public int getStudentSeq() {
		return studentSeq;
	}
	public void setStudentSeq(int studentSeq) {
		this.studentSeq = studentSeq;
	}
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getStudentTel() {
		return studentTel;
	}
	public void setStudentTel(String studentTel) {
		this.studentTel = studentTel;
	}
	public String getStudentGradeAttendance() {
		return studentGradeAttendance;
	}
	public void setStudentGradeAttendance(String studentGradeAttendance) {
		this.studentGradeAttendance = studentGradeAttendance;
	}
	public String getStudentGradeWriting() {
		return studentGradeWriting;
	}
	public void setStudentGradeWriting(String studentGradeWriting) {
		this.studentGradeWriting = studentGradeWriting;
	}
	public String getStudentGradePractical() {
		return studentGradePractical;
	}
	public void setStudentGradePractical(String studentGradePractical) {
		this.studentGradePractical = studentGradePractical;
	}
	public String getStudentDropout() {
		return studentDropout;
	}
	public void setStudentDropout(String studentDropout) {
		this.studentDropout = studentDropout;
	}
	public String getStudentDropoutDate() {
		return studentDropoutDate;
	}
	public void setStudentDropoutDate(String studentDropoutDate) {
		this.studentDropoutDate = studentDropoutDate;
	}
	public String getSubjectSeq() {
		return subjectSeq;
	}
	public void setSubjectSeq(String subjectSeq) {
		this.subjectSeq = subjectSeq;
	}
	
	@Override
	public String toString() {
		return String.format(
				"TeacherStudentListDTO [studentSeq=%s, studentName=%s, studentTel=%s, studentGradeAttendance=%s, studentGradeWriting=%s, studentGradePractical=%s, studentDropout=%s, studentDropoutDate=%s, subjectSeq=%s]",
				studentSeq, studentName, studentTel, studentGradeAttendance, studentGradeWriting, studentGradePractical,
				studentDropout, studentDropoutDate, subjectSeq);
	}
	public int getStudentGradeSeq() {
		return studentGradeSeq;
	}
	public void setStudentGradeSeq(int studentGradeSeq) {
		this.studentGradeSeq = studentGradeSeq;
	}
	
	
	
	
	
}
