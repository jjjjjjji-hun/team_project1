package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.ReviewDAO;

/**
 * Servlet implementation class ReviewDeleteServlet
 */
@WebServlet("/reviewdelete")
public class ReviewDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewDeleteServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("post로 접근");
		
		String strReviewNum = request.getParameter("reviewNum");
		int reviewNum = Integer.parseInt(strReviewNum);
		System.out.println("받은 리뷰 번호 : " + reviewNum);
		
		// 다오 생성
		ReviewDAO dao = ReviewDAO.getInstance();
		System.out.println("다오 생성 완료");
		
		// 메서드 실행
		dao.deleteReview(reviewNum);
		System.out.println("메서드 실행 완료");
		
		// 리뷰 리스트로 리다이렉트
		response.sendRedirect("http://localhost:8181/electronic_library/reviewlist");
	}

}
