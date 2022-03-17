package kr.co.ict;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class BookDAO {

	private DataSource ds = null;
	
	private static BookDAO dao = new BookDAO();
	
	
	// 생성자
	private BookDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 다른 파일에서 사용하게 해주는 메서드
	public static BookDAO getInstance() {
		if(dao == null) {
			dao = new BookDAO();
		}
		return dao;
	}
	
	/* 책 정보 관련 메서드*/
	// DB에 책 정보 적재
	public void insertBookData(int bNum, String bName, String bWriter,
			 		String bPub, String bCategory, boolean checkOut) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO book VALUES(?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setInt(1, bNum);
			pstmt.setString(2, bName);
			pstmt.setString(3, bWriter);
			pstmt.setString(4, bPub);
			pstmt.setString(5, bCategory);
			pstmt.setBoolean(6, checkOut);
			
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
	
	
	// DB에 책 정보 삭제
	public void deleteBookData(String bName) {
		
		// 수업때는 유저 정보를 삭제하는 로직으로 세션아이디를 받아왔는데..
		// 책 정보도 세션을 줘야할지 그냥 갈지..
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "DELETE FROM book WHERE bname = ?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, bName);
			
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

	// DB 내 모든 책 정보 조회 

	public List<BookVO> getAllBookList(){
			
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;

		List<BookVO> BookList = new ArrayList<>();
		try {
			con = ds.getConnection();
				
			String sql = "SELECT * FROM book";
			pstmt = con.prepareStatement(sql);

			rs = pstmt.executeQuery();
		
				
			while(rs.next()) {
				int bNum = rs.getInt("bnum");
				String bName = rs.getString("bname");
				String bWriter = rs.getString("bwriter");
				String bPub = rs.getString("bpub");
				String bCategory = rs.getString("bcategory");
				boolean checkOut = rs.getBoolean("check_out");
					
				BookVO BookData = new BookVO(bNum, bName, bWriter, bPub, bCategory, checkOut);
				BookList.add(BookData);
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
		return BookList;
	}
		
		
	// DB 내 특정 책 정보 조회
	// 메인 페이지에서 카테고리나 모든 도서 목록에서 사용할 때
		public BookVO getBookData(String b_Name) {

			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			BookVO book = null;
			try {

				con = ds.getConnection();
				String sql = "SELECT * FROM book WHERE bname = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, b_Name);
				rs = pstmt.executeQuery();
				if(rs.next()) {
					int bNum = rs.getInt("bnum");
					String bName = rs.getString("bname");
					String bWriter = rs.getString("bwriter");
					String bPub = rs.getString("bpub");
					String bCategory = rs.getString("bcategory");
					boolean checkOut = rs.getBoolean("check_out");
					book = new BookVO(bNum, bName, bWriter, bPub, bCategory, checkOut);
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


		// 도서 검색할 때 사용
		// booksearch 할때도 사용
		public List<BookVO> getSearchBookList(String b_Name){
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			List<BookVO> BookList = new ArrayList<>();
			try {
				con = ds.getConnection();
					
				String sql = "SELECT * FROM book WHERE bname like ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setString(1, ("%" + b_Name + "%"));
				rs = pstmt.executeQuery();
			
					
				while(rs.next()) {
					int bNum = rs.getInt("bnum");
					String bName = rs.getString("bname");
					String bWriter = rs.getString("bwriter");
					String bPub = rs.getString("bpub");
					String bCategory = rs.getString("bcategory");
					boolean checkOut = rs.getBoolean("check_out");
						
					BookVO BookData = new BookVO(bNum, bName, bWriter, bPub, bCategory, checkOut);
					BookList.add(BookData);
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
			return BookList;
		}
		
	// 03.17 새로운 검색창과 연결되는 메서드	
		
		public List<BookVO> getSearchBookList2(String option, String searchKeyword){
			System.out.println("(메서드) getSearchBookList2()로 " + option +", " +searchKeyword+ "를 가지고 진입");
			
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;

			List<BookVO> BookList = new ArrayList<>();
			
			String sql = "SELECT * FROM book WHERE " + option.trim();
			
			try {
				con = ds.getConnection();
				
				if(searchKeyword != null && !searchKeyword.equals("")) {
					sql += " LIKE '%" + searchKeyword.trim() + "%'";
				}

				pstmt = con.prepareStatement(sql);

				rs = pstmt.executeQuery();
			
					
				while(rs.next()) {
					int bNum = rs.getInt("bnum");
					String bName = rs.getString("bname");
					String bWriter = rs.getString("bwriter");
					String bPub = rs.getString("bpub");
					String bCategory = rs.getString("bcategory");
					boolean checkOut = rs.getBoolean("check_out");
						
					BookVO BookData = new BookVO(bNum, bName, bWriter, bPub, bCategory, checkOut);
					BookList.add(BookData);
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
			return BookList;
		}
		
		
		
		
		
	/* 책 대여 및 반납 시 메서드*/
	// 대여 버튼 클릭 시 대출중인 상태로 만드는 메서드(0 -->1)
		// date관련은 RentalDAO에서 호출 / rentnum, overdue는 디폴트값
		public void CheckOutOn(int bNum) {
			Connection con = null;
			PreparedStatement pstmt = null;
			
			try {
				con = ds.getConnection();
				String sql = "UPDATE book SET check_out = true WHERE bnum = ?";
				pstmt = con.prepareStatement(sql);
				pstmt.setInt(1, bNum);
				
				pstmt.executeUpdate();
			}catch (Exception e) {
				e.printStackTrace();
			}finally {
				try {
					con.close();
					pstmt.close();
				}catch (Exception e) {
					e.printStackTrace();
				}
			}
		}
		
		// 반납 버튼 클릭 시 대출 가능 상태로 만드는 메서드(1 -->0)
				public void CheckOutOff(int bNum) {
					Connection con = null;
					PreparedStatement pstmt = null;
					
					try {
						con = ds.getConnection();
						String sql = "UPDATE book SET check_out = false WHERE bnum = ?";
						pstmt = con.prepareStatement(sql);
						pstmt.setInt(1, bNum);
						
						pstmt.executeUpdate();
					}catch (Exception e) {
						e.printStackTrace();
					}finally {
						try {
							con.close();
							pstmt.close();
						}catch (Exception e) {
							e.printStackTrace();
						}
					}
				}
				
	// 
}

