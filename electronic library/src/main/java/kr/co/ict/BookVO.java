package kr.co.ict;

public class BookVO {

    // 책 변수
    private int bNum;
    private String bName;
    private String bWriter;
    private String bPub;
    private String bCategory;
    private boolean checkOut;

    // 책 생성자
    public BookVO(int bNum, String bName, String bWriter, String bPub, String bCategory, boolean checkOut) {
        super();
        this.bNum = bNum;
        this.bName = bName;
        this.bWriter = bWriter;
        this.bPub = bPub;
        this.bCategory = bCategory;
        this.checkOut = checkOut;
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

    public boolean isCheckOut() {
        return checkOut;
    }

    public void setCheckOut(boolean checkOut) {
        this.checkOut = checkOut;
    }

    @Override
    public String toString() {
        return "BookVO [bNum=" + bNum + ", bName=" + bName + ", bWriter=" + bWriter + ", bPub=" + bPub + ", bCategory="
                + bCategory + ", checkOut=" + checkOut + "]";
    }




}