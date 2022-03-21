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

public class RentalDAO {

private DataSource ds = null;
	
	private static RentalDAO dao = new RentalDAO();
	
	
	// 생성자
	private RentalDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 다른 파일에서 사용하게 해주는 메서드
	public static RentalDAO getInstance() {
		if(dao == null) {
			dao = new RentalDAO();
		}
		return dao;
	}
	
	// 전체 대여 도서 목록 가져오기
			public List<RentalVO> getAllRentalBookList(int pageNum){
				
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				List<RentalVO> rentBookList = new ArrayList<>();
				
				try {
					con = ds.getConnection();
					int limitNum = ((pageNum-1) * 10);
					String sql = "SELECT * FROM rental ORDER BY rentnum DESC limit ?, 10";
					pstmt = con.prepareStatement(sql);
					pstmt.setInt(1, limitNum);
					rs = pstmt.executeQuery();
					
					while(rs.next()) {
						int rentNum = rs.getInt("rentnum");
						Date rentDate = rs.getDate("rentdate");
						Date returnDate = rs.getDate("returndate");
						Date returnSchedule = rs.getDate("returnschedule");
						int bNum = rs.getInt("bnum");
						String bName = rs.getString("bname");
						String uId = rs.getString("uid");
						Boolean checkOut = rs.getBoolean("check_out");
						Boolean overdue = rs.getBoolean("overdue");
						
						RentalVO BookData = new RentalVO(rentNum, rentDate, returnDate, returnSchedule, bNum, bName, uId, checkOut, overdue);
						rentBookList.add(BookData);
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
				return rentBookList;
			}
	
		// 사용자가 대여한 전체 도서 목록 가져오기
			// sId 세션 아이디
			public List<RentalVO> getAllRentalInfoBookList(String sId){
							
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;

				List<RentalVO> rentInfoBookList = new ArrayList<>();
							
				try {
					con = ds.getConnection();
								
					String sql = "SELECT * FROM rental WHERE uid = ?";
					pstmt = con.prepareStatement(sql);
					pstmt.setString(1, sId);
					rs = pstmt.executeQuery();
								
					while(rs.next()) {
						int rentNum = rs.getInt("rentnum");
						Date rentDate = rs.getDate("rentdate");
						Date returnDate = rs.getDate("returndate");
						Date returnSchedule = rs.getDate("returnschedule");
						int bNum = rs.getInt("bnum");
						String bName = rs.getString("bname");
						String uId = rs.getString("uid");
						Boolean checkOut = rs.getBoolean("check_out");
						Boolean overdue = rs.getBoolean("overdue");
									
						RentalVO BookData = new RentalVO(rentNum, rentDate, returnDate, returnSchedule, bNum, bName, uId, checkOut, overdue);
						rentInfoBookList.add(BookData);
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
				return rentInfoBookList;
	  }
			
	// 대여 버튼 클릭 시 DB에 대여 책 목록 적재 
		// 대여 시 bnum과 uid 값을 얻어와 쿼리문 실행
	public void insertRentalBookData(int bnum, String bname, String uid){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO rental(rentdate, returnschedule, bnum, bname, uid, check_out) VALUES (now(), DATE_ADD(NOW(), INTERVAL 14 DAY), ?, ?, ?, true)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bnum);
			pstmt.setString(2, bname);
			pstmt.setString(3, uid);
			
			pstmt.executeUpdate();
			
			
		}catch(Exception e) {
			e.printStackTrace();
			
		}finally {
			try {
				
			}catch(Exception e) {
				e.printStackTrace();
			}
		}
	}
	
		
	// 반납 버튼 클릭 시 DB에 대출여부 업데이트 쿼리문 
		// 반납 시 대여 현황 목록에서 번호를 받아와 쿼리문 실행
		public void UpdateRentalBookData(int rentnum){
						
			Connection con = null;
			PreparedStatement pstmt = null;
						
			try {
							
				con = ds.getConnection();
							
				String sql = "UPDATE rental SET returndate = now(), check_out = false WHERE rentnum = ?";
				// DATE_ADD(NOW(), INTERVAL 15 DAY)
				pstmt = con.prepareStatement(sql);
							
				pstmt.setInt(1, rentnum);
							
				pstmt.executeUpdate();
			
							
			}catch(Exception e) {
				e.printStackTrace();
							
			}finally {
				try {
							
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}

	// 연체 여부 쿼리문,  overdue에 false가 들어오면 연체X, true가 들어오면 연체O
		
		public void UpdateOverdue(Boolean overdue, int bNum){
								
			Connection con = null;
			PreparedStatement pstmt = null;
								
			try {
									
				con = ds.getConnection();
									
				String sql = "UPDATE rental SET overdue = ? WHERE bnum = ?";
				pstmt = con.prepareStatement(sql);
									
				pstmt.setBoolean(1, overdue);
				pstmt.setInt(2, bNum);
									
				pstmt.executeUpdate();
									
									
			}catch(Exception e) {
				e.printStackTrace();
									
			}finally {
				try {
									
				}catch(Exception e) {
					e.printStackTrace();
				}
			}
		}

	
	// 대출 여부 확인하는 쿼리문
		// check_out이 0 이면 대여 가능(한 번도 대여가 안 된 도서거나, 반납이 된 상태)
		// check_out이 1 이면 대여 불가능(대여 중인 상태)
		public RentalVO getCheckOutData(int b_Num) {

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			RentalVO book = null;
			try {

				con = ds.getConnection();
				String sql = "SELECT check_out FROM rental WHERE bnum = ? ORDER BY rentdate DESC limit 0, 1;";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, b_Num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					int rentNum = rs.getInt("rentnum");
					Date rentDate = rs.getDate("rentdate");
					Date returnDate = rs.getDate("returndate");
					Date returnschedule = rs.getDate("returnschedule");
					int bNum = rs.getInt("bnum");
					String bName = rs.getNString("bname");
					String uId = rs.getString("uid");
					boolean checkOut = rs.getBoolean("check_out");
					boolean overdue = rs.getBoolean("overdue");
					book = new RentalVO(rentNum, rentDate, returnDate, returnschedule, bNum, bName, uId, checkOut, overdue);
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
			return book;
		}
		
		
	
		// 사용자가 본인이 대여-반납하지 않은 책을 쓰려고 리뷰 insert 폼으로 이동하지 못하게하는 메서드
	
		public RentalVO checkRentalExistence(int bnum, String sId) {
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			RentalVO rental = null;
			
			try {
				
				con = ds.getConnection();
				String sql = "SELECT * FROM rental WHERE uid=? AND bnum=?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, sId);
				pstmt.setInt(2, bnum);
				
				rs = pstmt.executeQuery();
				
				if(rs.next()) {
					int rentNum = rs.getInt("rentnum");
					Date rentDate = rs.getDate("rentdate");
					Date returnDate = rs.getDate("returndate");
					Date returnschedule = rs.getDate("returnschedule");
					int bNum = rs.getInt("bnum");
					String bName = rs.getNString("bname");
					String uId = rs.getString("uid");
					boolean checkOut = rs.getBoolean("check_out");
					boolean overdue = rs.getBoolean("overdue");
					
					rental = new RentalVO(rentNum, rentDate, returnDate, returnschedule, bNum, bName, uId, checkOut, overdue);
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
			
			
			return rental;
		}
		
		
		// 페이징 처리를 위해 게시글 전체 개수를 구하기
		// 쿼리문은 SELECT COUNT(*) FROM review;
			public int getPageNum() {
				Connection con = null;
				PreparedStatement pstmt = null;
				ResultSet rs = null;
				int pageNum = 0;
				try {
					con = ds.getConnection();
							
					String sql = "SELECT COUNT(*) FROM rental";
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
		
		/*public RentalVO getReturnDateData(int b_Num) {

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			RentalVO book = null;
			try {

				con = ds.getConnection();
				String sql = "SELECT returndate FROM rental WHERE bnum = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, b_Num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					int rentNum = rs.getInt("rentnum");
					Date rentDate = rs.getDate("rentdate");
					Date returnDate = rs.getDate("returndate");
					Date returnschedule = rs.getDate("returnschedule");
					int bNum = rs.getInt("bnum");
					String bName = rs.getNString("bname");
					String uId = rs.getString("uid");
					boolean checkOut = rs.getBoolean("check_out");
					boolean overdue = rs.getBoolean("overdue");
					book = new RentalVO(rentNum, rentDate, returnDate, returnschedule, bNum, bName, uId, checkOut, overdue);
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
			return book;
		}*/
		
		
		
		
}
