package teacher.model;

public class TeacherGradingtblDTO {

	/*
	 * 배점 입출력
	 * 
	 * 배점 테이블에 update 시 사용하는 DTO
	 */
	
	private int gradingStandardSeq;
	private String gradingAttance;
	private String gradingWriting;
	private String gradingPractical;
	private String examDate;
	
	public TeacherGradingtblDTO() {
		super();
	}
	public TeacherGradingtblDTO(int gradingStandardSeq, String gradingAttance, String gradingWriting,
			String gradingPractical, String examDate) {
		this.gradingStandardSeq = gradingStandardSeq;
		this.gradingAttance = gradingAttance;
		this.gradingWriting = gradingWriting;
		this.gradingPractical = gradingPractical;
		this.examDate = examDate;
	}
	public int getGradingStandardSeq() {
		return gradingStandardSeq;
	}
	public void setGradingStandardSeq(int gradingStandardSeq) {
		this.gradingStandardSeq = gradingStandardSeq;
	}
	public String getGradingAttance() {
		return gradingAttance;
	}
	public void setGradingAttance(String gradingAttance) {
		this.gradingAttance = gradingAttance;
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
	
	@Override
	public String toString() {
		return "TeacherGradingtblDTO [gradingStandardSeq=" + gradingStandardSeq + ", gradingAttance=" + gradingAttance
				+ ", gradingWriting=" + gradingWriting + ", gradingPractical=" + gradingPractical + ", examDate="
				+ examDate + "]";
	}
	
	
	
	
}
