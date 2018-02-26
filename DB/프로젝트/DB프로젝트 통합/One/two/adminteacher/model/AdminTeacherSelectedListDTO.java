package adminteacher.model;
/*
관리자 - 3. 교사계정관리
AdminTeacherClass
selected_list()에 쓰임

*/
public class AdminTeacherSelectedListDTO {

	private String seq; //교사번호
	private String name;
	private String subjectName;
	private String subjectDate;
	private String courseName;
	private String courseDate;
	private String classroom;
	private String book;
	private String status; //강의진행여부
	
	public String getSeq() {
		return seq;
	}
	public void setSeq(String seq) {
		this.seq = seq;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSubjectName() {
		return subjectName;
	}
	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}
	public String getSubjectDate() {
		return subjectDate;
	}
	public void setSubjectDate(String subjectDate) {
		this.subjectDate = subjectDate;
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
	public String getBook() {
		return book;
	}
	public void setBook(String book) {
		this.book = book;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	
	
	
	
	
}
