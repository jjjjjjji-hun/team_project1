package kr.co.ict;

import java.sql.Date;

public class RentVO {
	
	// rent 변수
	private int rentNum;
	private Date rentDate;        // 대여일
	private Date returnSchedule;  // 반납 예정일
	private int bNum;             
	private String uId;
	private Boolean overdue;      // 연체 유무
	
	
	
	
	// rent 생성자
	public RentVO(int rentNum, Date rentDate, Date returnSchedule, int bNum, String uId, Boolean overdue) {
		super();
		this.rentNum = rentNum;
		this.rentDate = rentDate;
		this.returnSchedule = returnSchedule;
		this.bNum = bNum;
		this.uId = uId;
		this.overdue = overdue;
	}



	// getter/setter
	public int getRentNum() {
		return rentNum;
	}



	public void setRentNum(int rentNum) {
		this.rentNum = rentNum;
	}



	public Date getRentDate() {
		return rentDate;
	}



	public void setRentDate(Date rentDate) {
		this.rentDate = rentDate;
	}



	public Date getReturnSchedule() {
		return returnSchedule;
	}



	public void setReturnSchedule(Date returnSchedule) {
		this.returnSchedule = returnSchedule;
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



	public Boolean getOverdue() {
		return overdue;
	}



	public void setOverdue(Boolean overdue) {
		this.overdue = overdue;
	}



	// toString
	@Override
	public String toString() {
		return "RentVO [rentNum=" + rentNum + ", rentDate=" + rentDate + ", returnSchedule=" + returnSchedule
				+ ", bNum=" + bNum + ", uId=" + uId + ", overdue=" + overdue + "]";
	}
	


	
	

	
	
	
	
	
	
	
	
	

}
