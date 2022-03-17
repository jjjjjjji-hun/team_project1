package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class LoginServlet
 */
@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
		try {
			request.setCharacterEncoding("utf-8");
			response.setCharacterEncoding("utf-8");
			
			// 폼에서 날린 데이터 받기
			String uid = request.getParameter("uid");
			String upw = request.getParameter("upw");
			
			// 세션 쓰는 법
			HttpSession session = null;
			session = request.getSession();
			
			// VO 생성 및 데이터 입력
			UserVO user = new UserVO();
			user.setuId(uid);
			user.setuPw(upw);
			
			// dao 호출
			UserDAO dao = UserDAO.getInstance();
			
			int result = dao.usersLogin(user);
			
			if(result ==  1) {
				// 통과시 세션 발급
				session.setAttribute("session_id", uid);
				session.setAttribute("session_pw", upw);
			} else if(result == 0) {
				session.setAttribute("login", "fail");
			}
			
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		
	}
		
	}
