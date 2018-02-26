package admincourse.model;
//4.개설과정 조회 course_list()
public class AdminCourseListDTO {

	private String courseseq;
	private String coursename;
	private String coursestart;
	private String courseend;
	private String basicclassroom;
	private String yesno;
	private String people;

	public String getYesno() {
		return yesno;
	}

	public void setYesno(String yesno) {
		this.yesno = yesno;
	}

	public String getPeople() {
		return people;
	}

	public void setPeople(String people) {
		this.people = people;
	}

	public String getCourseseq() {
		return courseseq;
	}

	public void setCourseseq(String courseseq) {
		this.courseseq = courseseq;
	}

	public String getCoursename() {
		return coursename;
	}

	public void setCoursename(String coursename) {
		this.coursename = coursename;
	}

	public String getCoursestart() {
		return coursestart;
	}

	public void setCoursestart(String coursestart) {
		this.coursestart = coursestart;
	}

	public String getCourseend() {
		return courseend;
	}

	public void setCourseend(String courseend) {
		this.courseend = courseend;
	}

	public String getBasicclassroom() {
		return basicclassroom;
	}

	public void setBasicclassroom(String basicclassroom) {
		this.basicclassroom = basicclassroom;
	}



	

}
