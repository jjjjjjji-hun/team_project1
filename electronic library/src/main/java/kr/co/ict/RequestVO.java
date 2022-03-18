package kr.co.ict;

import java.sql.Date;

public class RequestVO {

	
		// 도서 신청 변수
		private int reqNum;          // 글 번호
		private String country;      // 국가(폼에서 클릭하여 선택)
		private String reqTitle;     // 글 제목
		private String bName; 		 // 책 이름
		private String bWriter;		 // 책 저자
		private String bPub;		 // 출판사
		private String bCategory;	 // 카테고리
		private String reqContent;	 // 글 내용
		private Boolean reqStatus; 	 // 신청 상태(대기중, 구매 완료)
		private Date reqDate;		 // 작성일
		private Date reqmDate;		 // 수정일
		private int hit;			 // 조회수
		
		
		
	
		// 생성자
		public RequestVO(int reqNum, String country, String reqTitle, String bName, String bWriter, String bPub,
				String bCategory, String reqContent, Boolean reqStatus, Date reqDate, Date reqmDate, int hit) {
			super();
			this.reqNum = reqNum;
			this.country = country;
			this.reqTitle = reqTitle;
			this.bName = bName;
			this.bWriter = bWriter;
			this.bPub = bPub;
			this.bCategory = bCategory;
			this.reqContent = reqContent;
			this.reqStatus = reqStatus;
			this.reqDate = reqDate;
			this.reqmDate = reqmDate;
			this.hit = hit;
		}



		
		
		// getter / setter
		public int getReqNum() {
			return reqNum;
		}




		public void setReqNum(int reqNum) {
			this.reqNum = reqNum;
		}




		public String getCountry() {
			return country;
		}




		public void setCountry(String country) {
			this.country = country;
		}




		public String getReqTitle() {
			return reqTitle;
		}




		public void setReqTitle(String reqTitle) {
			this.reqTitle = reqTitle;
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




		public String getReqContent() {
			return reqContent;
		}




		public void setReqContent(String reqContent) {
			this.reqContent = reqContent;
		}




		public Boolean getReqStatus() {
			return reqStatus;
		}




		public void setReqStatus(Boolean reqStatus) {
			this.reqStatus = reqStatus;
		}




		public Date getReqDate() {
			return reqDate;
		}




		public void setReqDate(Date reqDate) {
			this.reqDate = reqDate;
		}




		public Date getReqmDate() {
			return reqmDate;
		}




		public void setReqmDate(Date reqmDate) {
			this.reqmDate = reqmDate;
		}




		public int getHit() {
			return hit;
		}




		public void setHit(int hit) {
			this.hit = hit;
		}




		// toString
		@Override
		public String toString() {
			return "RequestVO [reqNum=" + reqNum + ", country=" + country + ", reqTitle=" + reqTitle + ", bName="
					+ bName + ", bWriter=" + bWriter + ", bPub=" + bPub + ", bCategory=" + bCategory + ", reqContent="
					+ reqContent + ", reqStatus=" + reqStatus + ", reqDate=" + reqDate + ", reqmDate=" + reqmDate
					+ ", hit=" + hit + "]";
		}
		
		
		
		
		
		
	
	
	
}
