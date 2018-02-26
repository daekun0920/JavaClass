package teacher.model;

public class TeacherScheduleListDTO {

	/*
	 * 강의 스케쥴 조회
	 * 
	 * 강의 스케쥴 정보를 가져오기 위한 DTO
	 */
	
	private String subjectStatus; 		//강의 예정 / 강의 중/ 강의 종료
	private String subjectSeq;			//과목번호
	private String subjectName;			//과목명
	private String subjectStartDate;	//과목시작일
	private String subjectEndDate;		//과목종료일
	private String courseName;			//과정명
	private String courseStartDate;		//과정시작일
	private String courseEndDate;		//과정종료일
	private String classroomName;		//강의실명
	private String bookName;			//교재명
	private String studentEnrollNum;;	//교육생등록인원
	
	
	public String getSubjectStatus() {
		return subjectStatus;
	}
	public void setSubjectStatus(String subjectStatus) {
		this.subjectStatus = subjectStatus;
	}
	public String getSubjectSeq() {
		return subjectSeq;
	}
	public void setSubjectSeq(String subjectSeq) {
		this.subjectSeq = subjectSeq;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
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
	public String getStudentEnrollNum() {
		return studentEnrollNum;
	}
	public void setStudentEnrollNum(String studentEnrollNum) {
		this.studentEnrollNum = studentEnrollNum;
	}	
	
}
