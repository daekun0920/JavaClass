package admingrade.model;

public class AdminStuSubGradeDTO { // proc_stu_sub_grade
/*
 AdminGradeClass
 - substu_grade_list() 과목별 성적 출력
  
 AdminGradeDAO
 - student_grade_list() 
 */
	private String student_name;
	private String student_ssn;
	private String student_attendance;
	private String student_writing;
	private String student_practical;
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
