package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class UserMyInfoUpdateForm
 */
@WebServlet("/userupdateform")
public class UserMyInfoUpdateForm extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMyInfoUpdateForm() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String uId = request.getParameter("fid");
		
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.getUserData(uId);
		System.out.println("유저 정보 수정 폼에 들어온 user -> " + user);
		
		// 바인딩
		request.setAttribute("user", user);
		System.out.println("바인딩 완료");
		
		// 주소지
		RequestDispatcher dp = request.getRequestDispatcher("/users/user_info_update_form.jsp");
		System.out.println("주소지 입력 완료");
		
		// 포워드
		dp.forward(request, response);
	}

}
