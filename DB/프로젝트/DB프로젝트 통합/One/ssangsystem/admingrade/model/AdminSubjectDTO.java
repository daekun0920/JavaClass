package admingrade.model;

public class AdminSubjectDTO { // 모든 과목
	/*
	 AdminGradeClass
	 - subject_grade_list() 과목별 성적 출력
	 
	 AdminGradeDAO
	 - subject_grade_list()
	  
	 */
	private String subject_seq;
	private String subject_name;
	private String subject_book;
	private String subject_classroom;
	private String subject_teacher;
	private String course_name;
	private String course_start_date;
	private String course_end_date;
	public String getSubject_seq() {
		return subject_seq;
	}
	public void setSubject_seq(String subject_seq) {
		this.subject_seq = subject_seq;
	}
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSubject_book() {
		return subject_book;
	}
	public void setSubject_book(String subject_book) {
		this.subject_book = subject_book;
	}
	public String getSubject_classroom() {
		return subject_classroom;
	}
	public void setSubject_classroom(String subject_classroom) {
		this.subject_classroom = subject_classroom;
	}
	public String getSubject_teacher() {
		return subject_teacher;
	}
	public void setSubject_teacher(String subject_teacher) {
		this.subject_teacher = subject_teacher;
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
	
	
}
