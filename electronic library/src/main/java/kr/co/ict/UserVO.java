package kr.co.ict;

public class UserVO {
	
	// 변수
	private String uId;
	private String uName;
	private String uPw;
	private String uPnum;
	private String uEmail;
	private boolean uType; // 사용자0, 관리자1
	private int counting;  // 도서 대여 권 수
	
	
	
	// 생성자
	public UserVO(String uId, String uName, String uPw, String uPnum, String uEmail, boolean uType, int counting) {
		super();
		this.uId = uId;
		this.uName = uName;
		this.uPw = uPw;
		this.uPnum = uPnum;
		this.uEmail = uEmail;
		this.uType = uType;
		this.counting = counting;
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




	public String getuPnum() {
		return uPnum;
	}




	public void setuPnum(String uPnum) {
		this.uPnum = uPnum;
	}




	public String getuEmail() {
		return uEmail;
	}




	public void setuEmail(String uEmail) {
		this.uEmail = uEmail;
	}




	public boolean isuType() {
		return uType;
	}




	public void setuType(boolean uType) {
		this.uType = uType;
	}




	public int getCounting() {
		return counting;
	}




	public void setCounting(int counting) {
		this.counting = counting;
	}



	// toString
	@Override
	public String toString() {
		return "UserVO [uId=" + uId + ", uName=" + uName + ", uPw=" + uPw + ", uPnum=" + uPnum + ", uEmail=" + uEmail
				+ ", uType=" + uType + ", counting=" + counting + "]";
	}	
	

}