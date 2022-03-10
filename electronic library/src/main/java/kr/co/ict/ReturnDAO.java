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
// 코드 잠시 멈춤
public class ReturnDAO {

	private DataSource ds = null;
	
	private static ReturnDAO dao = new ReturnDAO();
	
	
	// 생성자
	private ReturnDAO() {
		try {
			Context ct = new InitialContext();
			ds = (DataSource)ct.lookup("java:comp/env/jdbc/mysql");
		}catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	// 다른 파일에서 사용하게 해주는 메서드
		public static ReturnDAO getInstance() {
			if(dao == null) {
				dao = new ReturnDAO();
			}
			return dao;
		}
}
