package kr.co.ict.servlet.service.user;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class UserLoginService implements IUserService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 폼에서 날아온 데이터 받기
		String fId = request.getParameter("fid");
		String fPw = request.getParameter("fpw");
		
		// DAO 생성 후, fId로 날아온 아이디로 DB에서 SELECT 하는 메서드 실행
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.getUserData(fId);
		System.out.println("(서비스)UserLoginService에서 fid로 호출한 유저 DB 정보 -> " + user);
		
		// 폼에서 날린 아이디가 DB에 있는 경우
		if(user != null) {
			
			// 폼 아이디/비번과 DB 아이디/비번이 같다면 세션 발급 후, 메인 페이지로 이동
			if(fId.equals(user.getuId()) && fPw.equals(user.getuPw())) {
				
				// 세션 발급(아이디, 비밀번호, 유저 타입)
				HttpSession session = request.getSession();
				session.setAttribute("sId", user.getuId());
				session.setAttribute("sPw", user.getuPw());
				session.setAttribute("sUtype", user.isuType());
				request.setAttribute("fId", fId);
				request.setAttribute("user", user);
				
				Boolean utypecheck = (Boolean)session.getAttribute("sUtype");
				System.out.println("(서비스)UserLoginService에 들어온 유저 타입은 -> " + utypecheck);
				
			// 폼에서 입력한 정보가 DB의 아이디/비번과 다른 경우 
			// (프론트 컨트롤러에서 포워딩 하기 전에 다른 곳으로 또 포워딩 시키고 싶지는 않았는데 메인.jsp에서 꼬여서 어쩔 수 없었음)
			}else {
				request.setAttribute("fId", fId);
				RequestDispatcher dp = request.getRequestDispatcher("/users/login_check_script.jsp");
				dp.forward(request, response);
						
			}
		// user값이 null인 경우 (해당 아이디가 없거나 잘못된 경로로 주소 쳐서 접속시)
		}else {
			request.setAttribute("user", user);
			RequestDispatcher dp = request.getRequestDispatcher("/users/login_check_script.jsp");
			dp.forward(request, response);
		}
		
	}

}
