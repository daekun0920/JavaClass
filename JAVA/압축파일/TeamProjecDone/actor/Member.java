package actor;
public class Member {
	private String memberId;
	private String memberPw;
	private String memberType;
	
	Member(String memberId, String memberPw, String memberType) {
		this.memberId = memberId;
		this.memberPw = memberPw;
		this.memberType = memberType;
		
	}

	public String getMemberType() {
		return memberType;
	}

	public void setMemberType(String memberType) {
		this.memberType = memberType;
	}

	public String getMemberId() {
		return memberId;
	}

	public void setMemberId(String memberId) {
		this.memberId = memberId;
	}

	public String getMemberPw() {
		return memberPw;
	}

	public void setMemberPw(String memberPw) {
		this.memberPw = memberPw;
	}

	
	
	
	
}
