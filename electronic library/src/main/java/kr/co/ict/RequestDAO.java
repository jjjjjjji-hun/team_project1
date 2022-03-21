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

public class RequestDAO {
	
	private DataSource ds = null;
	private static RequestDAO dao = new RequestDAO();
	
	
	// 생성자
	private RequestDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	// 다른 파일에서 사용하게 해주는 메서드
	public static RequestDAO getInstance() {
		if(dao == null) {
			dao = new RequestDAO();
		}
		return dao;
	}
	
	
	
	// ▲ 도서 요청 폼 DB에 적재하기
	public void insertRequest(String country, String title, String bookname, String writer, 
							  String bookpub, String category, String sId, String content) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "INSERT INTO request(country, reqtitle, bname, bwriter, bpub, bcategory, reqid, reqcontent) "
							+ "VALUES (?, ?, ?, ?, ?, ?, ?, ?)";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, country);
			pstmt.setString(2, title);
			pstmt.setString(3, bookname);
			pstmt.setString(4, writer);
			pstmt.setString(5, bookpub);
			pstmt.setString(6, category);
			pstmt.setString(7, sId);
			pstmt.setString(8, content);
			
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
	
	
	// ▲ 전체 도서 요청 리스트 가져오기
	
	public List<RequestVO> getAllRequestList(int pageNum){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RequestVO request = null;
		
		List<RequestVO> allRequestList = new ArrayList<>();
		
		try {
			
			con = ds.getConnection();
			int limitNum = ((pageNum-1) * 10);
			String sql = "SELECT * FROM request ORDER BY reqnum DESC limit ?, 10";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, limitNum);
			rs = pstmt.executeQuery();
			
			while(rs.next()) {
				int reqNum = rs.getInt("reqnum");
				String country = rs.getString("country");
				String reqTitle = rs.getString("reqtitle");
				String bName = rs.getString("bname");
				String bWriter = rs.getString("bwriter");
				String bPub = rs.getString("bpub");
				String bCategory = rs.getString("bcategory");
				String reqId = rs.getString("reqid");
				String reqContent = rs.getString("reqcontent");
				Boolean reqStatus = rs.getBoolean("reqstatus");
				Date reqDate = rs.getDate("reqdate");
				Date reqmDate = rs.getDate("reqmdate");
				int hit = rs.getInt("hit");
				
				request = new RequestVO(reqNum, country, reqTitle, bName, bWriter, bPub, bCategory, reqId, reqContent, reqStatus, reqDate, reqmDate, hit);
				
				allRequestList.add(request);
				
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
		
		return allRequestList;
		
	}
	
	
	
	// ▲ 요청 도서 상세 페이지 (글 번호 받음)
	
	public RequestVO getRequestDetail(int reqeust_num){
		
		Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		RequestVO request = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "SELECT * FROM request WHERE reqnum = ?";
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reqeust_num);
			rs = pstmt.executeQuery();
			
			if(rs.next()) {
				int reqNum = rs.getInt("reqnum");
				String country = rs.getString("country");
				String reqTitle = rs.getString("reqtitle");
				String bName = rs.getString("bname");
				String bWriter = rs.getString("bwriter");
				String bPub = rs.getString("bpub");
				String bCategory = rs.getString("bcategory");
				String reqId = rs.getString("reqid");
				String reqContent = rs.getString("reqcontent");
				Boolean reqStatus = rs.getBoolean("reqstatus");
				Date reqDate = rs.getDate("reqdate");
				Date reqmDate = rs.getDate("reqmdate");
				int hit = rs.getInt("hit");
				
				request = new RequestVO(reqNum, country, reqTitle, bName, bWriter, bPub, bCategory, reqId, reqContent, reqStatus, reqDate, reqmDate, hit);
				
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
		
		return request;
		
	}
	
	
	
	// ▲ 디테일 수정 폼에서 날린 데이터 DB에 반영하기
	
	public void updateRequestFormToDB(String country, String title, String bookname, String writer, 
			  String bookpub, String category, String content, int reqnum) {
		
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			
			String sql = "UPDATE request SET country=?, reqtitle=?, bname=?, bwriter=?, "
						+ "bpub=?, bcategory=?, reqcontent=?, reqmdate=now() WHERE reqnum=?";
			
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1, country);
			pstmt.setString(2, title);
			pstmt.setString(3, bookname);
			pstmt.setString(4, writer);
			pstmt.setString(5, bookpub);
			pstmt.setString(6, category);
			pstmt.setString(7, content);
			pstmt.setInt(8, reqnum);
			
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
	
	
	
	// ▲ 조회수 올려주는 메서드
	
	public void upHit(int reqNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			String sql = "UPDATE request SET hit = (hit + 1) WHERE reqnum = ?" ;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reqNum);
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
	
	
	// ▲ 도서 요청 글 삭제하는 메서드
	
	public void deleteBookRequest (int reqNum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			String sql = "DELETE FROM request WHERE reqnum = ?" ;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reqNum);
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
	
	
	// ▲ 해당 '도서 요청'의 상태를 바꿔줌 (false -> true)
	
	public void updateRequestStatus(int reqnum) {
		
		Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			
			con = ds.getConnection();
			String sql = "UPDATE request SET reqstatus = true WHERE reqnum = ?" ;
			pstmt = con.prepareStatement(sql);
			pstmt.setInt(1, reqnum);
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
	
	// 페이징 처리를 위해 게시글 전체 개수를 구하기
	// 쿼리문은 SELECT COUNT(*) FROM review;
		public int getPageNum() {
			Connection con = null;
			PreparedStatement pstmt = null;
			ResultSet rs = null;
			int pageNum = 0;
			try {
				con = ds.getConnection();
						
				String sql = "SELECT COUNT(*) FROM request";
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
