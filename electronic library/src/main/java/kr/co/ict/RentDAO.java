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

public class RentDAO {
	
	
	private DataSource ds = null;
	
	private static RentDAO dao = new RentDAO();
	
	
	// 생성자
	private RentDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	
	// 다른 파일에서 사용하게 해주는 메서드
	public static RentDAO getInstance() {
		if(dao == null) {
			dao = new RentDAO();
		}
		return dao;
	}
	
	
	
	// DB에 대여 책 목록 적재 (소괄호 안의 데이터들은 고민좀 해봐야)
		// 대여번호 AI, 대여일/대여예정일/overdue(디폴트값)
	public void insertRentBookData(int bnum, String uid){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO rent VALUES (?, ?)";
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
	
		public List<RentVO> getAllRentBookList(){
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			List<RentVO> rentBookList = new ArrayList<>();
			
			try {
				con = ds.getConnection();
				
				String sql = "SELECT * FROM rent";
				pstmt = con.prepareStatement(sql);
			
				rs = pstmt.executeQuery();
			
				
				if(rs.next() == false) {
					System.out.println("rent 테이블에 데이터가 없습니다.");
				}
				
				while(rs.next()) {
					
					
					int rentNum = rs.getInt("rentnum");
					Date rentDate = rs.getDate("rentdate");
					Date returnSchedule = rs.getDate("returnschedule");
					int bNum = rs.getInt("bnum");
					String uId = rs.getString("uid");
					Boolean overdue = rs.getBoolean("overdue");
					
					RentVO BookData = new RentVO(rentNum, rentDate, returnSchedule, bNum, uId, overdue);
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
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
