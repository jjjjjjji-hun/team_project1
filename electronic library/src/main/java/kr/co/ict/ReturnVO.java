package kr.co.ict;

import java.sql.Date;

public class ReturnVO {
	
	// 반납 변수
	private int returnNum; // 반납 번호
	private Date rentDate; // 대여 일자
	private Date returnDate; // 반납 일자
	private int bNum; // 책 번호
	private String uId; // 유저 아이디
	
	// 생성자
	public ReturnVO(int returnNum, Date rentDate, Date returnDate, int bNum, String uId) {
		super();
		this.returnNum = returnNum;
		this.rentDate = rentDate;
		this.returnDate = returnDate;
		this.bNum = bNum;
		this.uId = uId;
	}
	
	// getter, setter
	public int getReturnNum() {
		return returnNum;
	}

	public void setReturnNum(int returnNum) {
		this.returnNum = returnNum;
	}

	public Date getRentDate() {
		return rentDate;
	}

	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
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
	
	// toString
	@Override
	public String toString() {
		return "ReturnVO [returnNum=" + returnNum + ", rentDate=" + rentDate + ", returnDate=" + returnDate + ", bNum="
				+ bNum + ", uId=" + uId + "]";
	}
	
	
}
