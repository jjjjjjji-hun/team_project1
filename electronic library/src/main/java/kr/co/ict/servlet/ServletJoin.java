package kr.co.ict.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class ServletJoin
 */
@WebServlet("/ServletJoin")
public class ServletJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJoin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("join_form.jsp에서 post 방식으로 접속");
		
		request.setCharacterEncoding("utf-8");

		String fId = request.getParameter("fid");
		String fPw = request.getParameter("fpw");
		String fName = request.getParameter("fname");
		String fPnum = request.getParameter("fpnum");
		String fEmail = request.getParameter("femail");
		
		System.out.println("post로 들어온 데이터 : " + fId + ", " + fPw + ", " + fName + ", " + fPnum + ", " + fEmail);
		
		
		UserDAO dao = UserDAO.getInstance();		
		UserVO user = dao.getUserData(fId);
		System.out.println("회원가입한 정보가 있는지? => " + user);
		
		
		if(user != null) {
		
			if(fId.equals(user.getuId())) {
				System.out.println("이미 가입된 유저 정보 -> " + user);
				
				response.setContentType("text/html; charset=UTF-8");
				PrintWriter out = response.getWriter();
				out.println("<script>alert('이미 회원가입 된 아이디입니다.'); location.href='http://localhost:8181/electronic_library/users/join_form.jsp';</script>");
				out.flush();
			}
			
		}else {
			// 같은 아이디로 회원가입 된 적이 없다면 DB에 적재
			System.out.println("else문으로 진입");
			dao.insertUserData(fId, fPw, fName, fPnum, fEmail);
			System.out.println("적재까지 완료");
			
			// 로그인 폼으로 리다이렉트		
			response.sendRedirect("http://localhost:8181/electronic_library/users/login_form.jsp");
		}
		
		
	}

}
