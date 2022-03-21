package kr.co.ict.servlet.service.user;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class UserType1PageService implements IUserService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		Boolean sUserType = (Boolean)session.getAttribute("sUtype");
		System.out.println("(서비스) UserType1PageService에서 확인된 유저 타입 -> " + sUserType );

	}


}