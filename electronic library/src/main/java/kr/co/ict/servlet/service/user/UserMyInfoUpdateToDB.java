package kr.co.ict.servlet.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;

public class UserMyInfoUpdateToDB implements IUserService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String uId = request.getParameter("fuid");
		String uPw = request.getParameter("fupw");
		String uName = request.getParameter("funame");
		String uEmail = request.getParameter("fuemail");
		String uPnum = request.getParameter("fupnum");
		
		UserDAO dao = UserDAO.getInstance();
		dao.userUpdate(uName, uPw, uEmail, uPnum, uId);
		
	}

}
