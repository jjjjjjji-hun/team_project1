package kr.co.ict;

import java.sql.Date;

public class ReviewVO {
	
	
	// 리뷰 변수
	private int revNum;
	private int bNum;
	private String bName;
	private String uId;
	private String revTitle;
	private String revContent;
	private Date revDate;      // 작성일
	private Date revMDate;     // 수정일
	
	
	
	// 생성자

	public ReviewVO(int revNum, int bNum, String bName, String uId, String revTitle, String revContent, Date revDate,
			Date revMDate) {
		super();
		this.revNum = revNum;
		this.bNum = bNum;
		this.bName = bName;
		this.uId = uId;
		this.revTitle = revTitle;
		this.revContent = revContent;
		this.revDate = revDate;
		this.revMDate = revMDate;
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




		public Date getRevMDate() {
			return revMDate;
		}




		public void setRevMDate(Date revMDate) {
			this.revMDate = revMDate;
		}


		
		//toString
		
		@Override
		public String toString() {
			return "ReviewVO [revNum=" + revNum + ", bNum=" + bNum + ", bName=" + bName + ", uId=" + uId + ", revTitle="
					+ revTitle + ", revContent=" + revContent + ", revDate=" + revDate + ", revMDate=" + revMDate + "]";
		}
	
	
	

	
	
	
	






	
	
	
	
}
