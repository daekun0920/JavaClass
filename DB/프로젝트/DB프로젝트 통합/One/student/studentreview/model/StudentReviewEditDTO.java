package studentreview.model;

public class StudentReviewEditDTO {

	/*
	 * 
	 *  리뷰 수정 DTO
	 * 
	 *  본인이 쓴 수강평을 수정 DTO 
	 * 
	 */
	private String student_enrollment_seq;
	private String course_review;
	
	public String getStudent_enrollment_seq() {
		return student_enrollment_seq;
	}
	public void setStudent_enrollment_seq(String student_enrollment_seq) {
		this.student_enrollment_seq = student_enrollment_seq;
	}
	public String getCourse_review() {
		return course_review;
	}
	public void setCourse_review(String course_review) {
		this.course_review = course_review;
	}
}
