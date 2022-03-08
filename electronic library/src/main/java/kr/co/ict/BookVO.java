package kr.co.ict;

public class BookVO {

	// 책 변수
	private int bNum;
	private String bName;
	private String bWriter;
	private String bPub;
	private String bCategory;
<<<<<<< HEAD
	private boolean checkOut;
	
	
	// 책 생성자
	public BookVO(int bNum, String bName, String bWriter, String bPub, String bCategory, boolean checkOut) {
=======
	private boolean check_out;
	
	// 책 생성자
	public BookVO(int bNum, String bName, String bWriter, String bPub, String bCategory, boolean check_out) {
>>>>>>> 13ae9103b41653ac080358bd79b9fc182c79003e
		super();
		this.bNum = bNum;
		this.bName = bName;
		this.bWriter = bWriter;
		this.bPub = bPub;
		this.bCategory = bCategory;
<<<<<<< HEAD
		this.checkOut = checkOut;
=======
		this.check_out = check_out;
>>>>>>> 13ae9103b41653ac080358bd79b9fc182c79003e
	}
	
	
	
	

	
	// getter / setter
	public int getbNum() {
		return bNum;
	}

<<<<<<< HEAD




=======
>>>>>>> 13ae9103b41653ac080358bd79b9fc182c79003e
	public void setbNum(int bNum) {
		this.bNum = bNum;
	}

<<<<<<< HEAD




=======
>>>>>>> 13ae9103b41653ac080358bd79b9fc182c79003e
	public String getbName() {
		return bName;
	}

<<<<<<< HEAD




=======
>>>>>>> 13ae9103b41653ac080358bd79b9fc182c79003e
	public void setbName(String bName) {
		this.bName = bName;
	}

<<<<<<< HEAD




=======
>>>>>>> 13ae9103b41653ac080358bd79b9fc182c79003e
	public String getbWriter() {
		return bWriter;
	}

<<<<<<< HEAD




=======
>>>>>>> 13ae9103b41653ac080358bd79b9fc182c79003e
	public void setbWriter(String bWriter) {
		this.bWriter = bWriter;
	}

<<<<<<< HEAD




=======
>>>>>>> 13ae9103b41653ac080358bd79b9fc182c79003e
	public String getbPub() {
		return bPub;
	}

<<<<<<< HEAD




=======
>>>>>>> 13ae9103b41653ac080358bd79b9fc182c79003e
	public void setbPub(String bPub) {
		this.bPub = bPub;
	}

<<<<<<< HEAD




=======
>>>>>>> 13ae9103b41653ac080358bd79b9fc182c79003e
	public String getbCategory() {
		return bCategory;
	}

<<<<<<< HEAD




=======
>>>>>>> 13ae9103b41653ac080358bd79b9fc182c79003e
	public void setbCategory(String bCategory) {
		this.bCategory = bCategory;
	}





	public boolean isCheckOut() {
		return checkOut;
	}





	public void setCheckOut(boolean checkOut) {
		this.checkOut = checkOut;
	}


<<<<<<< HEAD
	
	

	// toString
	@Override
	public String toString() {
		return "BookVO [bNum=" + bNum + ", bName=" + bName + ", bWriter=" + bWriter + ", bPub=" + bPub + ", bCategory="
				+ bCategory + ", checkOut=" + checkOut + "]";
	}
	





	
	
	
	
=======
	@Override
	public String toString() {
		return "BookVO [bNum=" + bNum + ", bName=" + bName + ", bWriter=" + bWriter + ", bPub=" + bPub + ", bCategory="
				+ bCategory + ", check_out=" + check_out + "]";
	}
	

>>>>>>> 13ae9103b41653ac080358bd79b9fc182c79003e
	
}
