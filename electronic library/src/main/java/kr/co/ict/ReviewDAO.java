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
	
	public List<ReviewVO> getAllReviewList(int pageNum){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		List<ReviewVO> allReviewList = new ArrayList<>();
		
		try {
			
			con = ds.getConnection();
			int limitNum = ((pageNum-1) * 10);
			String sql = "SELECT * FROM review ORDER BY revnum DESC limit ?, 10";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, limitNum);
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
	

	// 리뷰 적재 ( 리뷰쓰기 버튼 구현 이후 수정 필요, 제목/내용/아이디만 받게 )
	public void insertReview(int bNum, String bName, String sId, String title, String content) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO review(bnum, bname, uid, revtitle, revcontent) VALUES(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, bNum);
			pstmt.setString(2, bName);
			pstmt.setString(3, sId);
			pstmt.setString(4, title);
			pstmt.setString(5, content);
			
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
	
	
	// 이미 작성한 리뷰인지 확인하는 메서드 (ReviewInsertFormService 에서 사용)
	
			public List<ReviewVO> getMyReviewInfo(String userId) {
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				List<ReviewVO> testVOList = new ArrayList<>();
				
				try {
					
					con = ds.getConnection();
					
					String sql = "SELECT * FROM review WHERE uid =? ";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, userId);
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
						
						ReviewVO testVO = new ReviewVO(revNum, bNum, bName, uId, revTitle, revContent, revDate, revMDate);
						testVOList.add(testVO);
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
				
				
				return testVOList;
			}
	
	
			
		// 03.17 	
		
			public List<ReviewVO> getSearchReviewList(String searchTitle){
				System.out.println("(메서드) getSearchReviewList()로 " + searchTitle + "를 가지고 진입");
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				List<ReviewVO> reviewList = new ArrayList<>();
				try {
					con = ds.getConnection();
						
					String sql = "SELECT * FROM review WHERE revtitle like ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, ("%" + searchTitle + "%"));
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
						reviewList.add(review);
					}
					
					System.out.println("(메서드) getSearchReviewList() 안에서 찾은 리스트 ->" + reviewList);
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
				return reviewList;
			}
			
			
			public List<ReviewVO> getSearchReviewList(String option, String searchKeyword){
				System.out.println("(메서드) getSearchReviewList2()로 " + option +", " +searchKeyword+ "를 가지고 진입");
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				List<ReviewVO> reviewList = new ArrayList<>();
				String sql = "SELECT * FROM review WHERE " + option.trim();
				try {
					con = ds.getConnection();
					
					if(searchKeyword != null && !searchKeyword.equals("")) {
						sql += " LIKE '%" + searchKeyword.trim() + "%'";
					}
					
					pstmt = con.prepareStatement(sql);
					//pstmt.setString(1, searchKeyword);
					//pstmt.setString(1, option);
					//pstmt.setString(2, ("%" + searchKeyword + "%"));
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
						reviewList.add(review);
					}
				
					System.out.println("(메서드) getSearchReviewList2() 안에서 찾은 리스트 ->" + reviewList);
					
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
				return reviewList;
			}
			
	// 페이징 처리를 위해 리뷰글 전체 개수를 구하기
	// 쿼리문은 SELECT COUNT(*) FROM review;
	public int getPageNum() {
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		int pageNum = 0;
		try {
			con = ds.getConnection();
					
			String sql = "SELECT COUNT(*) FROM review";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				pageNum = rs.getInt(1);		
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
		return pageNum;
	}

}

