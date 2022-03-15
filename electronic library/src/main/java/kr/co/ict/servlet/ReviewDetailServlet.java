package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.ReviewDAO;
import kr.co.ict.ReviewVO;

/**
 * Servlet implementation class ReviewDetailServlet
 */
@WebServlet("/reviewdetail")
public class ReviewDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strReviewNum = request.getParameter("revnum");
		int reviewNum = Integer.parseInt(strReviewNum);
		
		// 다오
		ReviewDAO dao = ReviewDAO.getInstance();
		
		// 메서드 호출
		ReviewVO reviewDetail = dao.getDetailReview(reviewNum);
		System.out.println("받은 데이터 : " + reviewDetail);
		
		// 바인딩
		request.setAttribute("reviewDetail", reviewDetail);
		
		// 주소지
		RequestDispatcher dp = request.getRequestDispatcher("/book/book_review_detail.jsp");
		
		// 포워딩
		dp.forward(request, response);
	}

}
