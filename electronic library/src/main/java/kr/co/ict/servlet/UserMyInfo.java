package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class UserMyInfo
 */
@WebServlet("/usermyinfo")
public class UserMyInfo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMyInfo() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 세션 아이디
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		
		// 다오 생성, 메서드 호출
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.getUserData(sId);
		
		// 바인딩
		request.setAttribute("user", user);
		
		// 주소지
		RequestDispatcher dp = request.getRequestDispatcher("/users/my_page.jsp");
		
		// 포워딩
		dp.forward(request, response);
	}

}
