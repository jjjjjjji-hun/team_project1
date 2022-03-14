package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BookDAO;
import kr.co.ict.BookVO;
import kr.co.ict.RentalDAO;
import kr.co.ict.RentalVO;
import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class RentInfoServlet
 */
@WebServlet("/rentinfo")
public class RentInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentInfoServlet() {
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
		//String sId = request.getParameter("sid");
		// 다오 생성, 메서드 호출
		RentalDAO dao1 = RentalDAO.getInstance();
		UserDAO dao2 = UserDAO.getInstance();
		BookDAO dao3 = BookDAO.getInstance();
		List<RentalVO> rentInfoList = dao1.getAllRentalInfoBookList(sId);
		UserVO userInfo = dao2.getUserData(sId);
		// 바인딩
		request.setAttribute("rentInfoList", rentInfoList);
		request.setAttribute("userInfo", userInfo);
		// 포워딩
		RequestDispatcher dp = request.getRequestDispatcher("/users/book_return.jsp");
		dp.forward(request, response);
	}

}
