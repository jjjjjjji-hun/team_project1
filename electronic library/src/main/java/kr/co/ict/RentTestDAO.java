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

public class RentTestDAO {

private DataSource ds = null;
	
	private static RentTestDAO dao = new RentTestDAO();
	
	
	// 생성자
	private RentTestDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 다른 파일에서 사용하게 해주는 메서드
	public static RentTestDAO getInstance() {
		if(dao == null) {
			dao = new RentTestDAO();
		}
		return dao;
	}
	
	
	
	// DB에 대여 책 목록 적재 (필요 없을 수도)
		// 번호 AI, 대여일/반납일/반납예정일/대출,반납여부/연체여부(디폴트값)
	public void insertRentTestBookData(int bnum, String uid){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO renttest(bnum, uid) VALUES (?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bnum);
			pstmt.setString(2, uid);
			
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
	
	
		
	// 전체 대여 도서 목록 가져오기
		public List<RentTestVO> getAllRentTestBookList(){
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			List<RentTestVO> rentBookList = new ArrayList<>();
			
			try {
				con = ds.getConnection();
				
				String sql = "SELECT * FROM renttest";
				pstmt = con.prepareStatement(sql);
			
				rs = pstmt.executeQuery();
			
				
				if(rs.next() == false) {
					System.out.println("renttest 테이블에 데이터가 없습니다.");
				}
				
				while(rs.next()) {
					int rentNum = rs.getInt("rentnum");
					Date rentDate = rs.getDate("rentdate");
					Date returnDate = rs.getDate("returndate");
					Date returnSchedule = rs.getDate("returnschedule");
					int bNum = rs.getInt("bnum");
					String uId = rs.getString("uid");
					Boolean checkOut = rs.getBoolean("check_out");
					Boolean overdue = rs.getBoolean("overdue");
					
					RentTestVO BookData = new RentTestVO(rentNum, rentDate, returnDate, returnSchedule, bNum, uId, checkOut, overdue);
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
		
	// 도서 대여 시 업데이트 쿼리문 
		// 번호 AI, 도서번호, 유저아이디(수정필요 없음), 반납일(null값), 연체여부(디폴트값)
		public void UpdateRentBookData(Date rentdate, Date returnschedule, Boolean checkOut, int rentnum){
				
			Connection con = null;
			PreparedStatement pstmt = null;
				
			try {
					
				con = ds.getConnection();
					
				String sql = "UPDATE renttest SET rentdate = ?, returnschedule = ?, check_out = ? WHERE rentnum = ?";
				pstmt = con.prepareStatement(sql);
					
				pstmt.setDate(1, rentdate);
				pstmt.setDate(2, returnschedule);
				pstmt.setBoolean(3, false);
				pstmt.setInt(4, rentnum);
					
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
	// 도서 반납 시 업데이트 쿼리문 
		// 번호 AI, 도서번호, 유저아이디(수정필요 없음), 대여일, 반납예정일(null값), 연체여부(디폴트값)
		public void UpdateReturnBookData(Date rentdate, Date returndate, Date returnschedule, Boolean checkOut, int rentnum){
						
			Connection con = null;
			PreparedStatement pstmt = null;
						
			try {
							
				con = ds.getConnection();
							
				String sql = "UPDATE renttest SET rentdate = ?, returndate = ?, returnschedule = ?, check_out = ? WHERE rentnum = ?";
				pstmt = con.prepareStatement(sql);
							
				pstmt.setDate(1, rentdate);
				pstmt.setDate(2, returndate);
				pstmt.setDate(3, returnschedule);
				pstmt.setBoolean(4, true);
				pstmt.setInt(5, rentnum);
							
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

	// 도서 미반납 시 연체 여부 업데이트 쿼리문 
		// 번호 AI, 도서번호, 유저아이디(수정필요 없음), 대여일, 반납예정일(null값), 연체여부(디폴트값)
		public void UpdateOverdueOnBookData(Boolean overdue, int rentnum){
								
			Connection con = null;
			PreparedStatement pstmt = null;
								
			try {
									
				con = ds.getConnection();
									
				String sql = "UPDATE renttest SET overdue = ? WHERE rentnum = ?";
				pstmt = con.prepareStatement(sql);
									
				pstmt.setBoolean(1, true);
				pstmt.setInt(2, rentnum);
									
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

	// 연체 여부 false로 되돌리는 업데이트 쿼리문 
		// 번호 AI, 도서번호, 유저아이디(수정필요 없음), 대여일, 반납예정일(null값), 연체여부(디폴트값)
		public void UpdateOverdueOffBookData(Boolean overdue, int rentnum){
										
			Connection con = null;
			PreparedStatement pstmt = null;
										
			try {
											
				con = ds.getConnection();
											
				String sql = "UPDATE renttest SET overdue = ? WHERE rentnum = ?";
				pstmt = con.prepareStatement(sql);
											
				pstmt.setBoolean(1, false);
				pstmt.setInt(2, rentnum);
											
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
}
