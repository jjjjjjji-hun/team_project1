package kr.co.ict.servlet.service.user;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class UserJoinService implements IUserService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String fId = request.getParameter("fid");
		String fPw = request.getParameter("fpw");
		String fName = request.getParameter("fname");
		String fPnum = request.getParameter("fpnum");
		String fEmail = request.getParameter("femail");
		
		System.out.println("회원가입 폼에서 post로 들어온 데이터 : " + fId + ", " + fPw + ", " + fName + ", " + fPnum + ", " + fEmail);
		
		
		UserDAO dao = UserDAO.getInstance();		
		UserVO user = dao.getUserData(fId);
		System.out.println("(서비스)UserJoinService에서 확인된 이미 회원가입한 정보가 있는지 여부 => " + user);
		
		
		if(user != null) {	
				System.out.println("(서비스)UserJoinService : 이미 가입된 유저 정보가 있음 -> " + user);
				// login_form.jsp로 바인딩 (거기서 경고창 띄우고 리다이렉트 처리)
				request.setAttribute("user", user);
			
		}else {
			// 같은 아이디로 회원가입 된 적이 없다면 DB에 적재
			System.out.println("(서비스)UserJoinService : 가입된 아이디가 없는 경우로 진입");
			dao.insertUserData(fId, fPw, fName, fPnum, fEmail);
			System.out.println("DB에 회원가입 정보 적재 완료");
			
		}
		
	}

}
