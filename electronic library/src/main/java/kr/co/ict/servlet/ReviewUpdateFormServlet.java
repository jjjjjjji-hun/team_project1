/* 서블릿 : 수정하기 위해 리뷰 디테일을 가져옴*/

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
 * Servlet implementation class ReviewUpdateFormServlet
 */
@WebServlet("/reviewUpdateForm")
public class ReviewUpdateFormServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateFormServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strReviewNum = request.getParameter("revnum");
		int reviewNum = Integer.parseInt(strReviewNum);
		
		System.out.println("받은 리뷰 번호 : " + reviewNum);
		
		// 다오 생성
		ReviewDAO dao = ReviewDAO.getInstance();
		
		// 메서드 호출
		ReviewVO review = dao.getDetailReview(reviewNum);
		
		// 바인딩 
		request.setAttribute("reviewDetail", review);
		
		// 주소지
		RequestDispatcher dp = request.getRequestDispatcher("/book/review_update_form.jsp"); 
		
		// 포워딩
		dp.forward(request, response);
		
	}

}
