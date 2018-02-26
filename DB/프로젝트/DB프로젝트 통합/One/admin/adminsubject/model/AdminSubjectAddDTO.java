package adminsubject.model;
//5. 개설과목 등록 subject_add()
public class AdminSubjectAddDTO {
	
	private String course_seq;
	private String subjectseq;
	private String subjectstart;
	private String subjectend;
	private String baiscsubjectseq;
	private String basicbook;
	private String teaseq;
	public String getCourse_seq() {
		return course_seq;
	}
	public void setCourse_seq(String course_seq) {
		this.course_seq = course_seq;
	}
	public String getSubjectseq() {
		return subjectseq;
	}
	public void setSubjectseq(String subjectseq) {
		this.subjectseq = subjectseq;
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
	public String getBaiscsubjectseq() {
		return baiscsubjectseq;
	}
	public void setBaiscsubjectseq(String baiscsubjectseq) {
		this.baiscsubjectseq = baiscsubjectseq;
	}
	public String getBasicbook() {
		return basicbook;
	}
	public void setBasicbook(String basicbook) {
		this.basicbook = basicbook;
	}
	public String getTeaseq() {
		return teaseq;
	}
	public void setTeaseq(String teaseq) {
		this.teaseq = teaseq;
	}
	

}
