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
	
	
	
	// DB에 대여 책 목록 적재 
		// 번호 AI, 대여일/반납일/반납예정일/대출,반납여부/연체여부(디폴트값)
	public void insertRentTestBookData(int bnum, String uid){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO renttest(rentdate, returnschedule, bnum, uid) VALUES (now(), DATE_ADD(NOW(), INTERVAL 14 DAY), ?, ?)";
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
					if(returnDate.compareTo(returnSchedule) > 0 ) {
						System.out.println("연체");
					}else if(returnDate.compareTo(returnSchedule) <= 0 ) {
						System.out.println("미연체");
					}
					
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
		public void UpdateRentBookData(Boolean checkOut, int rentnum){
				
			Connection con = null;
			PreparedStatement pstmt = null;
				
			try {
					
				con = ds.getConnection();
					
				String sql = "UPDATE renttest SET rentdate = now(), returnschedule = DATE_ADD(NOW(), INTERVAL 14 DAY), check_out = ? WHERE rentnum = ?";
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
	// 도서 반납 시 업데이트 쿼리문 
		// 번호 AI, 도서번호, 유저아이디(수정필요 없음), 대여일, 반납예정일(null값), 연체여부(디폴트값)
		public void UpdateReturnBookData(Boolean checkOut, int rentnum){
						
			Connection con = null;
			PreparedStatement pstmt = null;
						
			try {
							
				con = ds.getConnection();
							
				String sql = "UPDATE renttest SET rentdate = null, returndate = now(), returnschedule = null, check_out = ? WHERE rentnum = ?";
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

	// 도서 미반납 시 연체 여부 업데이트 쿼리문 
		
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
	
	// 대출 여부 확인하는 쿼리문
		// check_out이 1 이면 대여 가능(한 번도 대여가 안 된 도서거나, 반납이 된 상태)
		// check_out이 0 이면 대여 불가능(대여 중인 상태)
		public RentTestVO getCheckOutData(int b_Num) {

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			RentTestVO book = null;
			try {

				con = ds.getConnection();
				String sql = "SELECT check_out FROM renttest WHERE bnum = ? ORDER BY rentdate DESC limit 0, 1;";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, b_Num);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					int rentNum = rs.getInt("rentnum");
					Date rentDate = rs.getDate("rentdate");
					Date returnDate = rs.getDate("returndate");
					Date returnschedule = rs.getDate("returnschedule");
					int bNum = rs.getInt("bnum");
					String uId = rs.getString("uid");
					boolean checkOut = rs.getBoolean("check_out");
					boolean overdue = rs.getBoolean("overdue");
					book = new RentTestVO(rentNum, rentDate, returnDate, returnschedule, bNum, uId, checkOut, overdue);
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
}
