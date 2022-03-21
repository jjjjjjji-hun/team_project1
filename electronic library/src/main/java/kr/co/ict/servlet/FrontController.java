package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.servlet.service.book.BookDetailService;
import kr.co.ict.servlet.service.book.BookListService;
import kr.co.ict.servlet.service.book.IBookService;
import kr.co.ict.servlet.service.book.SearchBookService;
import kr.co.ict.servlet.service.rental.BookRentListService;
import kr.co.ict.servlet.service.rental.IRentalService;
import kr.co.ict.servlet.service.rental.RentCheckService;
import kr.co.ict.servlet.service.rental.RentInfoService;
import kr.co.ict.servlet.service.rental.ReturnBookService;
import kr.co.ict.servlet.service.request.IRequestService;
import kr.co.ict.servlet.service.request.RequestDeleteService;
import kr.co.ict.servlet.service.request.RequestDetailService;
import kr.co.ict.servlet.service.request.RequestDetailUpdateFormService;
import kr.co.ict.servlet.service.request.RequestDetailUpdateToDBService;
import kr.co.ict.servlet.service.request.RequestFormToDBService;
import kr.co.ict.servlet.service.request.RequestInsertFormService;
import kr.co.ict.servlet.service.request.RequestListService;
import kr.co.ict.servlet.service.request.RequestPermissionService;
import kr.co.ict.servlet.service.review.IReviewService;
import kr.co.ict.servlet.service.review.ReviewDeleteService;
import kr.co.ict.servlet.service.review.ReviewDetailService;
import kr.co.ict.servlet.service.review.ReviewInsertFormService;
import kr.co.ict.servlet.service.review.ReviewInsertToDBService;
import kr.co.ict.servlet.service.review.ReviewListService;
import kr.co.ict.servlet.service.review.ReviewSearchService;
import kr.co.ict.servlet.service.review.ReviewUpdateFormService;
import kr.co.ict.servlet.service.review.ReviewUpdateService;

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
			
			// 인터페이스 - 리뷰 ●
			IReviewService rs = null;
			
			// 인터페이스 - 렌탈 ♣
			IRentalService rts = null;
			
			// 인터페이스 - 북 ■
			IBookService bs = null;
			
			// 인터페이스 - 리퀘스트 ▲
			IRequestService rqs = null;
			
			System.out.println("현재 주소창에 입력된 .do 패턴 -> " + uri);
		
		
		// ● 리뷰 입력 폼으로 이동하기
		if(uri.equals("/electronic_library/insertReviewForm.do")) {
			rs = new ReviewInsertFormService();
			rs.execute(request, response);			
			ui = "/book/book_review_form.jsp";
			
		// ● 리뷰 폼에서 날린 데이터 DB에 적재하기	
		}else if(uri.equals("/electronic_library/insertReview.do")) {
			rs = new ReviewInsertToDBService();
			rs.execute(request, response);
			ui = "/reviewList.do";
			
		// ● 리뷰 리스트
		}else if(uri.equals("/electronic_library/reviewList.do")) {
			rs = new ReviewListService();
			rs.execute(request, response);
			ui = "/book/book_review_list.jsp";
		
		// ● 리뷰 디테일
		}else if(uri.equals("/electronic_library/reviewDetail.do")) {
			rs = new ReviewDetailService();
			rs.execute(request, response);
			ui = "/book/book_review_detail.jsp";
			
		// ● 수정 폼으로 가기
		}else if(uri.equals("/electronic_library/updateReviewForm.do")){
			rs = new ReviewUpdateFormService();
			rs.execute(request, response);
			ui = "/book/review_update_form.jsp";
			
			
		// ● 수정 폼에서 변경된 정보를 DB에서 update하기
		}else if(uri.equals("/electronic_library/updateReview.do")){	
			rs = new ReviewUpdateService();
			rs.execute(request, response);
			ui = "/reviewDetail.do?revnum=" + request.getParameter("revnum");
		
		// ● 리뷰 삭제
		}else if(uri.equals("/electronic_library/deleteReview.do")) {
			rs = new ReviewDeleteService();
			rs.execute(request, response);
			ui = "/reviewList.do";

		// ● 리뷰 찾기 결과 페이지
		}else if(uri.equals("/electronic_library/reviewSearch.do")) {
			rs = new ReviewSearchService();
			rs.execute(request, response);
			ui ="/book/book_review_search_list.jsp";
			
		// ■ 도서 검색
		}else if(uri.equals("/electronic_library/bookSearch.do")) {
			bs = new SearchBookService();
			bs.execute(request, response);
			ui = "/book/search_check.jsp";
			
		// ■ 상세 도서 검색
		}else if(uri.equals("/electronic_library/bookDetail.do")) {
			bs = new BookDetailService();
			bs.execute(request, response);
			ui = "/book/book_detail.jsp";
			
		// ■ 관리자 페이지에서 북 리스트 조회
		}else if(uri.equals("/electronic_library/bookList.do")) {
			bs = new BookListService();
			bs.execute(request, response);
			ui = "/master/book_list.jsp";
			
		// ♣ 대여 버튼 클릭 시 대여 체크
		}else if(uri.equals("/electronic_library/rentCheck.do")) {
			rts = new RentCheckService();
			rts.execute(request, response);
			ui = "/book/book_detail.jsp";
			
		// ♣ 마이페이지에서 대여 정보 조회	
		}else if(uri.equals("/electronic_library/rentInfo.do")) {
			rts = new RentInfoService();
			rts.execute(request, response);
			ui = "/users/book_return.jsp";
			
		// ♣ 대여 정보 조회에서 반납 버튼 클릭 시
		}else if(uri.equals("/electronic_library/returnBook.do")) {
			rts = new ReturnBookService();
			rts.execute(request, response);
			ui = "/users/book_return.jsp";
			
		// ♣ 관리자 페이지에서 대여 리스트 조회
		}else if(uri.equals("/electronic_library/bookRentList.do")) {
			rts = new BookRentListService();
			rts.execute(request, response);
			ui = "/master/book_rent_list.jsp";
		
		// ▲ 도서 요청 폼으로 이동
		}else if(uri.equals("/electronic_library/insertRequestForm.do")) {
			rqs = new RequestInsertFormService();
			rqs.execute(request, response);
			ui = "/request/book_request_form.jsp";
		
		// ▲ 도서 요청 폼에 입력된 정보를 DB로 INSERT
		}else if(uri.equals("/electronic_library/requestInsertFormToDB.do")) {
			rqs = new RequestFormToDBService();
			rqs.execute(request, response);
			ui = "/requestList.do";
		
		// ▲ 도서 요청 리스트로 이동
		}else if(uri.equals("/electronic_library/requestList.do")) {
			rqs = new RequestListService();
			rqs.execute(request, response);
			ui = "/request/book_request_list.jsp";
		
		// ▲ 도서 요청 디테일로 이동
		}else if(uri.equals("/electronic_library/requestDetail.do")){
			rqs = new RequestDetailService();
			rqs.execute(request, response);
			ui = "/request/book_request_detail.jsp";
			
		// ▲ 도서 요청 수정 폼으로 이동
		}else if(uri.equals("/electronic_library/requestUpdateForm.do")) {
			rqs = new RequestDetailUpdateFormService();
			rqs.execute(request, response);
			ui ="/request/book_request_detail_update_form.jsp";
		
		// ▲ 수정 폼에서 날린 데이터를 DB에 UPDATE
		}else if(uri.equals("/electronic_library/requestUpdateFormToDB.do")) {
			rqs = new RequestDetailUpdateToDBService();
			rqs.execute(request, response);
			ui ="/requestDetail.do?reqnum=" + request.getParameter("reqnum");
		
		// ▲ 도서 요청 삭제
		}else if(uri.equals("/electronic_library/deleteBookRequest.do")) {
			rqs = new RequestDeleteService();
			rqs.execute(request, response);
			ui = "/requestList.do";
		
		// ▲ 도서 요청 허가
		}else if(uri.equals("/electronic_library/requestPermission.do")) {
			rqs = new RequestPermissionService();
			rqs.execute(request, response);
			ui ="/requestDetail.do?reqNum=" + request.getParameter("reqnum");
			
		// ■ 그 외	
		}else {
			ui = "/";
		}
		
		
		// 포워딩
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
		
		
		
	}
	
	

}

