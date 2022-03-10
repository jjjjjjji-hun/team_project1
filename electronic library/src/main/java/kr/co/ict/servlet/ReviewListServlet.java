package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.ReviewDAO;
import kr.co.ict.ReviewVO;

/**
 * Servlet implementation class ReviewListServlet
 */
@WebServlet("/reviewlist")
public class ReviewListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 다오 생성
		ReviewDAO dao = ReviewDAO.getInstance();
		
		// 메서드 호출
		List<ReviewVO> allReviewList = dao.getAllReviewList();
		
		System.out.println("메서드 호출 후 : " + allReviewList);
		
		// 바인딩
		request.setAttribute("allReviewList", allReviewList);
		
		// 주소지
		RequestDispatcher dp = request.getRequestDispatcher("/book/book_review_list.jsp");
		
		// 포워딩
		dp.forward(request, response);
		
		
	}

}
