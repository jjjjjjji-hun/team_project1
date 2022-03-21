package kr.co.ict.servlet.service.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;

public class UserOutService implements IUserService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("(서비스)UserOutService에 진입");
		
	    HttpSession session = request.getSession();
	    String sId = (String)session.getAttribute("sId");
	    
	    System.out.println("삭제 서비스에서 발급된 세션 아이디 -> " + sId);	   
	    
	    // 다오 생성	
 		UserDAO dao = UserDAO.getInstance();
 		dao.deleteUser(sId);
 		System.out.println("회원 탈퇴 : DB 삭제 완료");
 		
 		session.invalidate();
 		System.out.println("회원 탈퇴 : 세션 만료");
 			
	}

}
