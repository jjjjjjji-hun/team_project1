package kr.co.ict;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

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
	
	
	
	
	// ■ DB에 유저 정보 적재 ■
	public void insertUserData(String fId, String fPw, String fName, String fPnum, String fEmail) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO userinfo VALUES(?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, fId);
			pstmt.setString(2, fName);
			pstmt.setString(3, fPw);
			pstmt.setString(4, fPnum);
			pstmt.setString(5, fEmail);
			
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
	
	
	
	// ■ 모든 유저 리스트 가져오기 ■
	public List<UserVO> getAllUserList(){
		
			Connection con= null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			
			List<UserVO> userList = new ArrayList<>();
		
		try {
			
			con = ds.getConnection();
			String sql = "SELECT * FROM userinfo";
			pstmt = con.prepareStatement(sql);
			rs = pstmt.executeQuery();
			
			// UserVO ArrayList에 rs에 든 모든 자료를 저장해주세요
			while(rs.next()) {
				String uId = rs.getString("uid");
				String uName = rs.getString("uname");
				String uPw = rs.getString("upw");
				String uPnum = rs.getString("upnum");
				String uEmail = rs.getString("uemail");
				Boolean uType = rs.getBoolean("utype");
				int counting = rs.getInt("counting");
				
				UserVO userData = new UserVO(uId, uName, uPw, uPnum, uEmail, uType, counting);

				userList.add(userData);
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

		return userList;
	}
	
	
	
	// ■ 유저(한 명) 데이터 가져오기 ■ (세션 아이디) 
	public UserVO getUserData(String sId) {
		
		String userId = sId;
		Connection con= null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		UserVO user = null;
		
		
		try {
			
			con = ds.getConnection();
			
			
			String sql = "SELECT * FROM userinfo WHERE uid =?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, userId);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				String uId = rs.getString("uid");
				String uName = rs.getString("uname");
				String uPw = rs.getString("upw");
				String uPnum = rs.getString("upnum");
				String uEmail = rs.getString("uemail");
				Boolean uType = rs.getBoolean("utype");
				int counting = rs.getInt("counting");
				
				user = new UserVO(uId, uName, uPw, uPnum, uEmail, uType, counting);

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
		
		return user;
	}
	
	
	
	// ■ 회원 정보 수정 ■ (세션 아이디)
	public void userUpdate(String name, String pw, String email, String pNum, String sId) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			
			con = ds.getConnection();
			
			String sql = "UPDATE userinfo SET uname=?, upw=?, uemail=?, upnum=? WHERE uid=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, name);
			pstmt.setString(2, pw);
			pstmt.setString(3, email);
			pstmt.setString(4, pNum);
			pstmt.setString(5, sId);
			
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
	
	
	
	// ■ 회원 정보 삭제 ■ (세션 아이디)
	public void deleteUser(String sId) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
		
			con = ds.getConnection();
			
			String sql = "DELETE FROM userinfo WHERE uid=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, sId);
			
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
