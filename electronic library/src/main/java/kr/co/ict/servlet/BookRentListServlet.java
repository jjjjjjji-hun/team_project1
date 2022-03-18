/* 서블릿 : 대여 도서 확인용 -> book_rent_list.jsp로 이동*/

package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RentalDAO;
import kr.co.ict.RentalVO;

/**
 * Servlet implementation class BookRentListServlet
 */
@WebServlet("/rentlist")
public class BookRentListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookRentListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dao
		RentalDAO dao = RentalDAO.getInstance();
		// 여러 RentalVO 받아올 리스트 생성
		List<RentalVO> allRentalBookList = dao.getAllRentalBookList();
		System.out.println("리스트 : " + allRentalBookList);
		// 바인딩
		request.setAttribute("allRentalBookList", allRentalBookList);

		// 포워딩
		RequestDispatcher dp = request.getRequestDispatcher("/master/book_rent_list.jsp");
		dp.forward(request, response);	
		
	}

}
