package admingrade.model;

public class AdminStudentGradeDTO {
	/*
	 AdminGradeClass
	 - private_grade_list()
	 
	 AdminGradeDAO
	 - private_grade_list()
	 
	 */
	private String subject_name;
	private String subject_start_date;
	private String subject_end_date;
	private String subject_teacher;
	private String student_attendance;
	private String student_writing;
	private String student_practical;
	public String getSubject_name() {
		return subject_name;
	}
	public void setSubject_name(String subject_name) {
		this.subject_name = subject_name;
	}
	public String getSubject_start_date() {
		return subject_start_date;
	}
	public void setSubject_start_date(String subject_start_date) {
		this.subject_start_date = subject_start_date;
	}
	public String getSubject_end_date() {
		return subject_end_date;
	}
	public void setSubject_end_date(String subject_end_date) {
		this.subject_end_date = subject_end_date;
	}
	public String getSubject_teacher() {
		return subject_teacher;
	}
	public void setSubject_teacher(String subject_teacher) {
		this.subject_teacher = subject_teacher;
	}
	public String getStudent_attendance() {
		return student_attendance;
	}
	public void setStudent_attendance(String student_attendance) {
		this.student_attendance = student_attendance;
	}
	public String getStudent_writing() {
		return student_writing;
	}
	public void setStudent_writing(String student_writing) {
		this.student_writing = student_writing;
	}
	public String getStudent_practical() {
		return student_practical;
	}
	public void setStudent_practical(String student_practical) {
		this.student_practical = student_practical;
	}
	
	
}
