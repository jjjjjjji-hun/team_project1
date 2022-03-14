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
import kr.co.ict.RentalDAO;
import kr.co.ict.RentalVO;
import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/returnbook")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 값 받아오기
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		int rentNum = Integer.parseInt(request.getParameter("rentnum"));
		int bNum = Integer.parseInt(request.getParameter("bnum"));
		// 다오 생성, 메서드 호출
		BookDAO dao1 = BookDAO.getInstance();
		RentalDAO dao2 = RentalDAO.getInstance();
		UserDAO dao3 = UserDAO.getInstance();
		dao1.CheckOutOff(bNum);
		dao2.UpdateRentalBookData(rentNum);
		List<RentalVO> rentInfoList = dao2.getAllRentalInfoBookList(sId);
		UserVO userInfo = dao3.getUserData(sId);
		// 바인딩
		request.setAttribute("rentInfoList", rentInfoList);
		request.setAttribute("userInfo", userInfo);
		// 포워딩
		RequestDispatcher dp = request.getRequestDispatcher("/users/book_return.jsp");
		dp.forward(request, response);
		
	}

}
