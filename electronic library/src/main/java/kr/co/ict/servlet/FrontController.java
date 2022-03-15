package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.servlet.service.IReviewService;
import kr.co.ict.servlet.service.ReviewDeleteService;
import kr.co.ict.servlet.service.ReviewDetailService;
import kr.co.ict.servlet.service.ReviewInsertToDBService;
import kr.co.ict.servlet.service.ReviewListService;
import kr.co.ict.servlet.service.ReviewUpdateFormService;
import kr.co.ict.servlet.service.ReviewUpdateService;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.do")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FrontController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doRequest(request, response);
		
	}
	
	private void doRequest(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 초기 세팅
		
			// 인코딩 (post일 경우)
			request.setCharacterEncoding("utf-8");
			
			// uri 받아오기
			String uri = request.getRequestURI();
			
			// 포워딩 할 .jsp 파일의 경로를 미리 저장해둘 변수
			String ui = null;
			
			// 인터페이스 - 리뷰
			IReviewService rs = null;
			
			System.out.println("현재 주소창에 입력된 .do 패턴 -> " + uri);
		
		
		// ■ 리뷰 입력 폼으로 이동하기
		if(uri.equals("/electronic_library/insertReviewForm.do")) {
			
			ui = "/book/book_review_form.jsp";
			
		// ■ 리뷰 폼에서 날린 데이터 DB에 적재하기	
		}else if(uri.equals("/electronic_library/insertReview.do")) {
			rs = new ReviewInsertToDBService();
			rs.execute(request, response);
			ui = "/reviewList.do";
			
		// ■ 리뷰 리스트
		}else if(uri.equals("/electronic_library/reviewList.do")) {
			rs = new ReviewListService();
			rs.execute(request, response);
			ui = "/book/book_review_list.jsp";
		
		// ■ 리뷰 디테일
		}else if(uri.equals("/electronic_library/reviewDetail.do")) {
			rs = new ReviewDetailService();
			rs.execute(request, response);
			ui = "/book/book_review_detail.jsp";
			
		// ■ 수정 폼으로 가기
		}else if(uri.equals("/electronic_library/updateReviewForm.do")){
			rs = new ReviewUpdateFormService();
			rs.execute(request, response);
			ui = "/book/review_update_form.jsp";
			
			
		// ■ 수정 폼에서 변경된 정보를 DB에서 update하기
		}else if(uri.equals("/electronic_library/updateReview.do")){	
			rs = new ReviewUpdateService();
			rs.execute(request, response);
			ui = "/reviewDetail.do?revnum=" + request.getParameter("revnum");
		
		// ■ 리뷰 삭제
		}else if(uri.equals("/electronic_library/deleteReview.do")) {
			rs = new ReviewDeleteService();
			rs.execute(request, response);
			ui = "/reviewList.do";
			
		// ■ 그 외	
		}else {
			ui = "/";
		}
			
		
		// 포워딩
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
		
		
		
	}
	
	

}
