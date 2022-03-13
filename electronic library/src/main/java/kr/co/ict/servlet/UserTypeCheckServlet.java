/* 서블릿 : 세션에서 받은 utype으로 사용자/관리자를 구분하여 마이페이지/관리페이지로 보냄 (미완)

	수정할 점 1) 세션 아이디 아직 어떻게 정해진지 모름
			2) 리다이렉트 지점을 나중에 서블릿으로 연결해야할지도(아마 아닐듯)

*/

package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


/**
 * Servlet implementation class UserTypeCheckServlet
 */
@WebServlet("/utypecheck")
public class UserTypeCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserTypeCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/utypecheck로 들어옴");
		
		
		HttpSession session = request.getSession();
		Boolean sUserType = (Boolean)session.getAttribute("sUtype");
		System.out.println("들어온 유저 타입 -> " + sUserType );
		
		
		// sUserType이 1이면 관리자, 0이면 사용자
		if(sUserType == true) {
			// 관리자
			response.sendRedirect("http://localhost:8181/electronic_library/users/admin_page.jsp");
		}else {
			// 사용자 (UserMyinfo.java 서블릿으로 이동)
			response.sendRedirect("http://localhost:8181/electronic_library/usermyinfo");
		}
		
		
		
	}

}
