package kr.co.ict;

import java.sql.Date;

public class ReviewVO {
	
	
	// 리뷰 변수
	private int revNum;
	private int bNum;
	private String uId;
	private String revTitle;
	private String revContent;
	private Date revDate;
	
	
	// 생성자
	public ReviewVO(int revNum, int bNum, String uId, String revTitle, String revContent, Date revDate) {
		super();
		this.revNum = revNum;
		this.bNum = bNum;
		this.uId = uId;
		this.revTitle = revTitle;
		this.revContent = revContent;
		this.revDate = revDate;
	}

	
	// getter / setter
	
	public int getRevNum() {
		return revNum;
	}


	public void setRevNum(int revNum) {
		this.revNum = revNum;
	}


	public int getbNum() {
		return bNum;
	}


	public void setbNum(int bNum) {
		this.bNum = bNum;
	}


	public String getuId() {
		return uId;
	}


	public void setuId(String uId) {
		this.uId = uId;
	}


	public String getRevTitle() {
		return revTitle;
	}


	public void setRevTitle(String revTitle) {
		this.revTitle = revTitle;
	}


	public String getRevContent() {
		return revContent;
	}


	public void setRevContent(String revContent) {
		this.revContent = revContent;
	}


	public Date getRevDate() {
		return revDate;
	}


	public void setRevDate(Date revDate) {
		this.revDate = revDate;
	}


	// toString
	@Override
	public String toString() {
		return "ReviewVO [revNum=" + revNum + ", bNum=" + bNum + ", uId=" + uId + ", revTitle=" + revTitle
				+ ", revContent=" + revContent + ", revDate=" + revDate + "]";
	}
	
	
	

}
