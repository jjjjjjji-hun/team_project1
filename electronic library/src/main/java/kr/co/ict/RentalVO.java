package kr.co.ict;

import java.sql.Date;
// 렌트 테이블 + 리턴 테이블
public class RentalVO {

	// rental 변수
		private int rentNum;     // 번호
		private Date rentDate;   // 대여일
		private Date returnDate;     // 반납일
		private Date returnSchedule;  // 반납 예정일
		private int bNum;     
		private String bName;
		private String uId;
		private Boolean checkOut;     // 대출/반납 여부 디폴트 false(0)
		// (false => 대출이 가능한 상태(마지막이 반납이였을 때) , true => 대출 불가능한 상태(마지막이 대출이였을 때))
		private Boolean overdue;      // 연체 유무 디폴트 false(0)
		// (false => 연체 이력 없음,   true => 연체 이력 있음) 추가로 true이면 패널티 받게(어떻게..?)
		
		// 생성자
		public RentalVO(int rentNum, Date rentDate, Date returnDate, Date returnSchedule, int bNum, String bName, String uId,
				Boolean checkOut, Boolean overdue) {
			super();
			this.rentNum = rentNum;
			this.rentDate = rentDate;
			this.returnDate = returnDate;
			this.returnSchedule = returnSchedule;
			this.bNum = bNum;
			this.bName = bName;
			this.uId = uId;
			this.checkOut = checkOut;
			this.overdue = overdue;
		}

		
		
		// getter / setter
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

		public Date getReturnDate() {
			return returnDate;
		}

		public void setReturnDate(Date returnDate) {
			this.returnDate = returnDate;
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

		public String getbName() {
			return bName;
		}

		public void setbName(String bName) {
			this.bName = bName;
		}

		public String getuId() {
			return uId;
		}

		public void setuId(String uId) {
			this.uId = uId;
		}

		public Boolean getCheckOut() {
			return checkOut;
		}

		public void setCheckOut(Boolean checkOut) {
			this.checkOut = checkOut;
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
			return "RentalVO [rentNum=" + rentNum + ", rentDate=" + rentDate + ", returnDate=" + returnDate
					+ ", returnSchedule=" + returnSchedule + ", bNum=" + bNum + ", bName=" + bName + ", uId=" + uId
					+ ", checkOut=" + checkOut + ", overdue=" + overdue + "]";
		}
}