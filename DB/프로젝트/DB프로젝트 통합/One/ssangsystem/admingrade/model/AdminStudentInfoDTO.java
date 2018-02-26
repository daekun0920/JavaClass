package admingrade.model;

public class AdminStudentInfoDTO { 
	/*
	 AdminGradeClass
	 - student_grade_list() 교육생 개인별 성적 출력
	 
	 AdminGradeDAO
	 - student_grade_list()
	 */
	private String student_seq;
	private String student_name;
	private String student_ssn;
	private String course_name;
	private String course_start_date;
	private String course_end_date;
	private String course_classroom;
	public String getStudent_seq() {
		return student_seq;
	}
	public void setStudent_seq(String student_seq) {
		this.student_seq = student_seq;
	}
	public String getStudent_name() {
		return student_name;
	}
	public void setStudent_name(String student_name) {
		this.student_name = student_name;
	}
	public String getStudent_ssn() {
		return student_ssn;
	}
	public void setStudent_ssn(String student_ssn) {
		this.student_ssn = student_ssn;
	}
	public String getCourse_name() {
		return course_name;
	}
	public void setCourse_name(String course_name) {
		this.course_name = course_name;
	}
	public String getCourse_start_date() {
		return course_start_date;
	}
	public void setCourse_start_date(String course_start_date) {
		this.course_start_date = course_start_date;
	}
	public String getCourse_end_date() {
		return course_end_date;
	}
	public void setCourse_end_date(String course_end_date) {
		this.course_end_date = course_end_date;
	}
	public String getCourse_classroom() {
		return course_classroom;
	}
	public void setCourse_classroom(String course_classroom) {
		this.course_classroom = course_classroom;
	}
	
	
	
}
