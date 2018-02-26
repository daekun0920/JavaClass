package teacher.model;

public class FinishedSubjectListDTO {

	/*
	 * 성적 입출력
	 * 
	 * 교사에게 보여주는 종료된 과목 관련 정보를 위한 DTO
	 * 
	 */
	
	private int subjectSeq;				//과목번호
	private String subjectStartDate;	//과목시작일
	private String subjectEndDate;		//과목종료일
	private String courseName;			//과정명
	private String courseStartDate;		//과정시작일
	private String courseEndDate;		//과정종료일
	private String classroomName;		//강의실명
	private String bookName;			//교재명
	private String gradingAttendance;	//출결배점
	private String gradingWriting;		//필기배점
	private String gradingPractical;	//실기배점
	private String checkInputScore; 	//성적등록여부
	
	public int getSubjectSeq() {
		return subjectSeq;
	}
	public void setSubjectSeq(int subjectSeq) {
		this.subjectSeq = subjectSeq;
	}
	public String getSubjectStartDate() {
		return subjectStartDate;
	}
	public void setSubjectStartDate(String subjectStartDate) {
		this.subjectStartDate = subjectStartDate;
	}
	public String getSubjectEndDate() {
		return subjectEndDate;
	}
	public void setSubjectEndDate(String subjectEndDate) {
		this.subjectEndDate = subjectEndDate;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseStartDate() {
		return courseStartDate;
	}
	public void setCourseStartDate(String courseStartDate) {
		this.courseStartDate = courseStartDate;
	}
	public String getCourseEndDate() {
		return courseEndDate;
	}
	public void setCourseEndDate(String courseEndDate) {
		this.courseEndDate = courseEndDate;
	}
	public String getClassroomName() {
		return classroomName;
	}
	public void setClassroomName(String classroomName) {
		this.classroomName = classroomName;
	}
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public String getGradingAttendance() {
		return gradingAttendance;
	}
	public void setGradingAttendance(String gradingAttendance) {
		this.gradingAttendance = gradingAttendance;
	}
	public String getGradingWriting() {
		return gradingWriting;
	}
	public void setGradingWriting(String gradingWriting) {
		this.gradingWriting = gradingWriting;
	}
	public String getGradingPractical() {
		return gradingPractical;
	}
	public void setGradingPractical(String gradingPractical) {
		this.gradingPractical = gradingPractical;
	}
	public String getCheckInputScore() {
		return checkInputScore;
	}
	public void setCheckInputScore(String checkInputScore) {
		this.checkInputScore = checkInputScore;
	}
	@Override
	public String toString() {
		return String.format(
				"FinishedSubjectListDTO [subjectSeq=%s, subjectStartDate=%s, subjectEndDate=%s, courseName=%s, courseStartDate=%s, courseEndDate=%s, classroomName=%s, bookName=%s, gradingAttendance=%s, gradingWriting=%s, gradingPractical=%s, checkInputScore=%s]",
				subjectSeq, subjectStartDate, subjectEndDate, courseName, courseStartDate, courseEndDate, classroomName,
				bookName, gradingAttendance, gradingWriting, gradingPractical, checkInputScore);
	}
	
	
	
}
