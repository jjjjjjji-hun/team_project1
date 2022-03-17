package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RentDAO;
import kr.co.ict.RentVO;

/**
 * Servlet implementation class UseRentInfoCheckServlet
 */
@WebServlet("/UseRentInfoCheckServlet")
public class UserRentInfoCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRentInfoCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
<<<<<<< HEAD:electronic library/src/main/java/kr/co/ict/servlet/UserRentInfoCheckServlet.java
        String uId = request.getParameter("uId");
        System.out.println("user_list.jsp에서 들어온 uId의 값 -> " + uId);
        
        // 다오 메서드 호출
        RentalDAO dao = RentalDAO.getInstance();
        List<RentalVO> rentalList = dao.getAllRentalInfoBookList(uId);
        
        // 바인딩
        request.setAttribute("rentalList", rentalList);
        request.setAttribute("uId", uId);
        
        // 포워딩
        RequestDispatcher dp = request.getRequestDispatcher("/master/book_rent_list_one_user.jsp");
        dp.forward(request, response);
=======
		
		// dao
		RentDAO dao = RentDAO.getInstance();
		
		// 여러 RentVO 받아올 리스트 생성
		List<RentVO> allRentBookList = dao.getAllRentBookList();
		System.out.println("리스트 : " + allRentBookList);
		
		// 바인딩
		request.setAttribute("allRentBookList", allRentBookList);
		
		// 포워딩
		RequestDispatcher dp = request.getRequestDispatcher("/master/book_rent_list.jsp");
		dp.forward(request, response);
		
				
		
		
>>>>>>> 299816329980666db67e233e20bc383e98e1a6e7:electronic library/src/main/java/kr/co/ict/servlet/BookRentListServlet.java
	}

}
