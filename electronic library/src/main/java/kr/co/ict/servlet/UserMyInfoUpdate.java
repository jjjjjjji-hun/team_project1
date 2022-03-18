package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;

/**
 * Servlet implementation class UserMyInfoUpdate
 */
@WebServlet("/userinfoupdate")
public class UserMyInfoUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserMyInfoUpdate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		
		String uId = request.getParameter("fuid");
		String uPw = request.getParameter("fupw");
		String uName = request.getParameter("funame");
		String uEmail = request.getParameter("fuemail");
		String uPnum = request.getParameter("fupnum");
		
		UserDAO dao = UserDAO.getInstance();
		dao.userUpdate(uName, uPw, uEmail, uPnum, uId);
		
		response.sendRedirect("http://localhost:8181/electronic_library/utypecheck");
	}

}
