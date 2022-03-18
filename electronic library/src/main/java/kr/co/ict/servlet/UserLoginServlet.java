package kr.co.ict.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class UserLoginServlet
 */
@WebServlet("/userlogin")
public class UserLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 인코딩
		request.setCharacterEncoding("utf-8");
		
		// 폼에서 날아온 데이터 받기
		String fId = request.getParameter("fid");
		String fPw = request.getParameter("fpw");
		
		// DAO 생성 후, fId로 날아온 아이디로 DB에서 SELECT 하는 메서드 실행
		UserDAO dao = UserDAO.getInstance();
		UserVO user = dao.getUserData(fId);
		System.out.println("/userlogin 서블릿으로 들어온 유저 정보 -> " + user);
		
		// 폼에서 날린 아이디가 DB에 있는 경우
		if(user != null) {
			
			// 폼 아이디/비번과 DB 아이디/비번이 같다면 세션 발급 후, 메인 페이지로 이동
			if(fId.equals(user.getuId()) && fPw.equals(user.getuPw())) {
				
				// 세션 발급(아이디, 비밀번호, 유저 타입)
				HttpSession session = request.getSession();
				session.setAttribute("sId", user.getuId());
				session.setAttribute("sPw", user.getuPw());
				session.setAttribute("sUtype", user.isuType());
				
				Boolean utypecheck = (Boolean)session.getAttribute("sUtype");
				System.out.println("/userlogin 서블릿에서 들어온 유저 타입은 -> " + utypecheck);
				
				// 메인 페이지로 이동
				response.sendRedirect("http://localhost:8181/electronic_library/main_Page.jsp");
				
			}else {
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('잘못 입력하셨습니다'); location.href='http://localhost:8181/electronic_library/users/login_form.jsp';</script>");
				out.flush();
			}
		
		// 폼에서 날린 아이디가 DB에 없는 경우
		}else {
			
			response.setContentType("text/html; charset=UTF-8");
			PrintWriter out = response.getWriter();
			out.println("<script>alert('존재하지 않는 아이디입니다.'); location.href='http://localhost:8181/electronic_library/users/login_form.jsp';</script>");
			out.flush();
			
		}
	}

}