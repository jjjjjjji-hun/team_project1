package kr.co.ict;

public class BookVO {

	// 책 변수
	private int bnum;
	private String bname;
	private String bwriter;
	private String bpub;
	private String bcategory;
	private boolean check_out;
	
	// 책 생성자
	public BookVO(int bnum, String bname, String bwriter, String bpub, String bcategory, boolean check_out) {
		super();
		this.bnum = bnum;
		this.bname = bname;
		this.bwriter = bwriter;
		this.bpub = bpub;
		this.bcategory = bcategory;
		this.check_out = check_out;
	}

	// getter / setter
	public int getBnum() {
		return bnum;
	}

	public void setBnum(int bnum) {
		this.bnum = bnum;
	}

	public String getBname() {
		return bname;
	}

	public void setBname(String bname) {
		this.bname = bname;
	}

	public String getBwriter() {
		return bwriter;
	}

	public void setBwriter(String bwriter) {
		this.bwriter = bwriter;
	}

	public String getBpub() {
		return bpub;
	}

	public void setBpub(String bpub) {
		this.bpub = bpub;
	}

	public String getBcategory() {
		return bcategory;
	}

	public void setBcategory(String bcategory) {
		this.bcategory = bcategory;
	}

	public boolean isCheck_out() {
		return check_out;
	}

	public void setCheck_out(boolean check_out) {
		this.check_out = check_out;
	}

	// toString
	@Override
	public String toString() {
		return "BookVO [bnum=" + bnum + ", bname=" + bname + ", bwriter=" + bwriter + ", bpub=" + bpub + ", bcategory="
				+ bcategory + ", check_out=" + check_out + "]";
	}
	
	
	
	
}
