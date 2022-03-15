package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.ReviewDAO;

/**
 * Servlet implementation class ReviewUpdateServlet
 */
@WebServlet("/reviewUpdate")
public class ReviewUpdateServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReviewUpdateServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 폼에서 날아온 데이터 받기
		request.setCharacterEncoding("utf-8");
		
		String strRevNum = request.getParameter("revnum");
		int revNum = Integer.parseInt(strRevNum);
		
		String strBookNum = request.getParameter("booknum");
		System.out.println("폼에서 수정한 책 번호 String 타입 : " + strBookNum);
		int bookNum = Integer.parseInt(strBookNum);
		System.out.println("폼에서 수정한 책 번호 : " + bookNum);
		
		String title = request.getParameter("title");
		
		String content = request.getParameter("content");
		
		// 다오 생성
		ReviewDAO dao = ReviewDAO.getInstance();
		
		// 메서드 호출
		dao.updateReview(title, content, revNum);
		
		// 수정 후, 해당 디테일 페이지로 리다이렉트
		response.sendRedirect("http://localhost:8181/electronic_library/reviewdetail?revnum=" + revNum);
		
	}

}
