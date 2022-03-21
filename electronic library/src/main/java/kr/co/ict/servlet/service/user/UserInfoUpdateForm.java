package kr.co.ict.servlet.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class UserInfoUpdateForm implements IUserService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String uId = request.getParameter("fid");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.getUserData(uId);
		System.out.println("유저 정보 수정 폼에 들어온 user -> " + user);
		
		// 바인딩
		request.setAttribute("user", user);
		System.out.println("바인딩 완료");
		
	}

}
