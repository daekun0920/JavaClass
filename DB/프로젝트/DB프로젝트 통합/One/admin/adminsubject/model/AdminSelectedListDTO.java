package adminsubject.model;

//5. 개설과목 선택 조회 subject_selected_list()
public class AdminSelectedListDTO {

	private String courseseq;
	private String coursename;
	private String coursestart;
	private String courseend;
	private String classroom;
	private String subjectname;
	private String subjectstart;
	private String subjectend;
	private String basicbook;
	private String teaname;

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

	public String getClassroom() {
		return classroom;
	}

	public void setClassroom(String classroom) {
		this.classroom = classroom;
	}

	public String getSubjectname() {
		return subjectname;
	}

	public void setSubjectname(String subjectname) {
		this.subjectname = subjectname;
	}

	public String getSubjectstart() {
		return subjectstart;
	}

	public void setSubjectstart(String subjectstart) {
		this.subjectstart = subjectstart;
	}

	public String getSubjectend() {
		return subjectend;
	}

	public void setSubjectend(String subjectend) {
		this.subjectend = subjectend;
	}

	public String getBasicbook() {
		return basicbook;
	}

	public void setBasicbook(String basicbook) {
		this.basicbook = basicbook;
	}

	public String getTeaname() {
		return teaname;
	}

	public void setTeaname(String teaname) {
		this.teaname = teaname;
	}

	

}
