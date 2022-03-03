package kr.co.ict;

public class UserVO {
	
	// 변수
	private String uId;
	private String uPw;
	private String uName;
	private String uEmail;
	
	
	
	// 생성자
	public UserVO(String uId, String uPw, String uName, String uEmail) {
		super();
		this.uId = uId;
		this.uPw = uPw;
		this.uName = uName;
		this.uEmail = uEmail;
	}


	
	// getter / setter
	public String getuId() {
		return uId;
	}

	public void setuId(String uId) {
		this.uId = uId;
	}

	public String getuPw() {
		return uPw;
	}

	public void setuPw(String uPw) {
		this.uPw = uPw;
	}

	public String getuName() {
		return uName;
	}

	public void setuName(String uName) {
		this.uName = uName;
	}

	public String getuEmail() {
		return uEmail;
	}

	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}



	// toString
	@Override
	public String toString() {
		return "UserVO [uId=" + uId + ", uPw=" + uPw + ", uName=" + uName + ", uEmail=" + uEmail + "]";
	}





	
	
	
	
	
	
	
	
	
	
	
	
	

}
