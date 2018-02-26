package adminstudent.model;

/*
관리자 - 6. 교육생계정관리
AdminStudentClass
selected_list()에 쓰임

*/
public class AdminStudentSelectedListDTO {

	private String seq; //교육생번호
	private String name; 
	private String courseName;
	private String courseDate;
	private String classroom;
	private String status;
	private String statusDate;
	
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
	@Override
	public String toString() {
		return String.format(
				"AdminStudentSelectedListDTO [seq=%s, name=%s, courseName=%s, courseDate=%s, classroom=%s, status=%s, statusDate=%s]",
				seq, name, courseName, courseDate, classroom, status, statusDate);
	}
	
	
	
}
