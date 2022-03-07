package kr.co.ict;

public class BookVO {

	// 책 변수
	private int bNum;
	private String bName;
	private String bWriter;
	private String bPub;
	private String bCategory;
	private boolean check_out;
	
	// 책 생성자
	public BookVO(int bNum, String bName, String bWriter, String bPub, String bCategory, boolean check_out) {
		super();
		this.bNum = bNum;
		this.bName = bName;
		this.bWriter = bWriter;
		this.bPub = bPub;
		this.bCategory = bCategory;
		this.check_out = check_out;
	}

	
	// getter / setter

	public int getbNum() {
		return bNum;
	}


	public void setbNum(int bNum) {
		this.bNum = bNum;
	}


	public String getbName() {
		return bName;
	}


	public void setbName(String bName) {
		this.bName = bName;
	}


	public String getbWriter() {
		return bWriter;
	}


	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}


	public String getbPub() {
		return bPub;
	}


	public void setbPub(String bPub) {
		this.bPub = bPub;
	}


	public String getbCategory() {
		return bCategory;
	}


	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}


	public boolean isCheck_out() {
		return check_out;
	}


	public void setCheck_out(boolean check_out) {
		this.check_out = check_out;
	}
	
	@Override
	public String toString() {
		return "BookVO [bNum=" + bNum + ", bName=" + bName + ", bWriter=" + bWriter + ", bPub=" + bPub + ", bCategory="
				+ bCategory + ", check_out=" + check_out + "]";
	}
	
}
