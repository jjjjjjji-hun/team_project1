package kr.co.ict;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class ReviewDAO {
	
	private DataSource ds = null;
	private static ReviewDAO dao = new ReviewDAO();
	
	
	// 생성자
	private ReviewDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// getInstance()
	public static ReviewDAO getInstance() {
		if(dao == null) {
			ReviewDAO dao = new ReviewDAO();
		}
		
		return dao;
	}
	
	
	// 전체 리뷰 리스트
	
	public List<ReviewVO> getAllReviewList(){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewVO> allReviewList = new ArrayList<>();
		
		try {
			
			con = ds.getConnection();
			
			String sql = "SELECT * FROM review";
			
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			
			while(rs.next()) {
				int revNum = rs.getInt("revnum");
				int bNum = rs.getInt("bnum");
				String bName = rs.getString("bname");
				String uId = rs.getString("uid");
				String revTitle = rs.getString("revtitle");
				String revContent = rs.getString("revcontent");
				Date revDate = rs.getDate("revdate");
				Date revMDate = rs.getDate("revmdate");
				
				ReviewVO review = new ReviewVO(revNum, bNum, bName, uId, revTitle, revContent, revDate, revMDate);
				allReviewList.add(review);
				
			}
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
		
		return allReviewList;
		
	}
	
	
	
	
	
	// 상세 리뷰
		// 리뷰 번호를 입력 받음.
	public ReviewVO getDetailReview(int rev_num) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ReviewVO detailReview = null;
		
		
		try {
			
			con = ds.getConnection();
			
			String sql = "SELECT * FROM review WHERE revnum = ?";
			pstmt = con.prepareStatement(sql);
				System.out.println("DAO에서 받은 리뷰 넘버 : " + rev_num);
			pstmt.setInt(1, rev_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int revNum = rs.getInt("revnum");
				int bNum = rs.getInt("bnum");
				String bName = rs.getString("bname");
				String uId = rs.getString("uid");
				String revTitle = rs.getString("revtitle");
				String revContent = rs.getString("revcontent");
				Date revDate = rs.getDate("revdate");
				Date revMDate = rs.getDate("revmdate");
				
				detailReview = new ReviewVO(revNum, bNum, bName, uId, revTitle, revContent, revDate, revMDate);
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
				rs.close();
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		return detailReview;
		
	}
	
	
	// 리뷰 삭제
	public void deleteReview(int reviewNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "DELETE FROM review WHERE revnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reviewNum);
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
	}
	
	
	
	// 리뷰 수정
	public void updateReview(String title, String content, int reviewNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "UPDATE review SET revtitle=?, revcontent=?, revmdate=now() WHERE revnum=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, title);
			pstmt.setString(2, content);
			pstmt.setInt(3, reviewNum);
			
			pstmt.executeUpdate();		
			
			
		}catch(Exception e) {
			
		}finally {
			try {
				con.close();
				pstmt.close();
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		
		
	}
	
	
	
	
	
	
}
