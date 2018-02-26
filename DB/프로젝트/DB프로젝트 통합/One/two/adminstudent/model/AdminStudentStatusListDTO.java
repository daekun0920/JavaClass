package adminstudent.model;


/*
관리자 - 6. 교육생계정관리
AdminStudentClass
status_list()에 쓰임

*/
public class AdminStudentStatusListDTO {

	private String seq; //교육생번호
	private String eseq;//수강현황번호
	private String name; //교육생명
	private String courseName;//과정명
	private String courseDate;//과정기간
	private String classroom; //강의실
	private String status;//수강현황
	private String statusDate;// 수강날짜
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getEseq() {
		return eseq;
	}
	public void setEseq(String eseq) {
		this.eseq = eseq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDate() {
		return courseDate;
	}
	public void setCourseDate(String courseDate) {
		this.courseDate = courseDate;
	}
	public String getClassroom() {
		return classroom;
	}
	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusDate() {
		return statusDate;
	}
	public void setStatusDate(String statusDate) {
		this.statusDate = statusDate;
	}
	
	
}
