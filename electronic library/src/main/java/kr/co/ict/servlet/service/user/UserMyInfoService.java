package kr.co.ict.servlet.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class UserMyInfoService implements IUserService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 세션 아이디
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		
		// 다오 생성, 메서드 호출
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.getUserData(sId);
		
		// 바인딩
		request.setAttribute("user", user);
		
	}

}
