package kr.co.ict;

import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class UserDAO {

	
	private DataSource ds = null;
	
	private static UserDAO dao = new UserDAO();
	
	
	// 생성자
	private UserDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 다른 파일에서 사용하게 해주는 메서드
	public static UserDAO getInstance() {
		if(dao == null) {
			dao = new UserDAO();
		}
		return dao;
	}
	
	
	// DB에 유저 정보 적재
	public void insertUserData(String fId, String fPw, String fName, String fEmail) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO userinfo VALUES(?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, fId);
			pstmt.setString(2, fPw);
			pstmt.setString(3, fName);
			pstmt.setString(4, fEmail);
			
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
	
	
}
