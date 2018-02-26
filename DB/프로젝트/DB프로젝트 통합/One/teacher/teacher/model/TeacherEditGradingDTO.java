package teacher.model;

public class TeacherEditGradingDTO {

	/*
	 * 배점 입출력
	 * 
	 * 강의를 마친 과목 및 관련 정보를 위한 DTO
	 */
	
	private int subjectSeq;
	private String subjectName;
	private String subjectStartDate;
	private String subjectEndDate;
	private String courseName;
	private String courseStartDate;
	private String courseEndDate;
	private String classroomName;
	private String bookName;
	private String gradingAttendance;
	private String gradingWriting;
	private String gradingPractical;
	private String examDate;
	private int gradingStandardSeq;
	
	
	public int getSubjectSeq() {
		return subjectSeq;
	}
	public void setSubjectSeq(int subjectSeq) {
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
	public String getExamDate() {
		return examDate;
	}
	public void setExamDate(String examDate) {
		this.examDate = examDate;
	}
	
	public int getGradingStandardSeq() {
		return gradingStandardSeq;
	}
	public void setGradingStandardSeq(int gradingStandardSeq) {
		this.gradingStandardSeq = gradingStandardSeq;
	}
	@Override
	public String toString() {
		return "TeacherEditGradingDTO [subjectSeq=" + subjectSeq + ", subjectName=" + subjectName
				+ ", subjectStartDate=" + subjectStartDate + ", subjectEndDate=" + subjectEndDate + ", courseName="
				+ courseName + ", courseStartDate=" + courseStartDate + ", courseEndDate=" + courseEndDate
				+ ", classroomName=" + classroomName + ", bookName=" + bookName + ", gradingAttendance="
				+ gradingAttendance + ", gradingWriting=" + gradingWriting + ", gradingPractical=" + gradingPractical
				+ ", examDate=" + examDate + ", gradingStandardSeq=" + gradingStandardSeq + "]";
	}
	
	
	
	
	
	
}
