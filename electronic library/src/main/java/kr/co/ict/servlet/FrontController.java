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
import kr.co.ict.servlet.service.rental.BookRentListService;
import kr.co.ict.servlet.service.rental.IRentalService;
import kr.co.ict.servlet.service.rental.RentCheckService;
import kr.co.ict.servlet.service.rental.RentInfoService;
import kr.co.ict.servlet.service.rental.ReturnBookService;
import kr.co.ict.servlet.service.rental.UserRentInfoService;
import kr.co.ict.servlet.service.request.IRequestService;
import kr.co.ict.servlet.service.request.RequestDeleteService;
import kr.co.ict.servlet.service.request.RequestDetail2Service;
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
import kr.co.ict.servlet.service.user.IUserService;
import kr.co.ict.servlet.service.user.MainPageService;
import kr.co.ict.servlet.service.user.UserInfoUpdateForm;
import kr.co.ict.servlet.service.user.UserJoinService;
import kr.co.ict.servlet.service.user.UserListService;
import kr.co.ict.servlet.service.user.UserLoginService;
import kr.co.ict.servlet.service.user.UserLogoutService;
import kr.co.ict.servlet.service.user.UserMyInfoService;
import kr.co.ict.servlet.service.user.UserMyInfoUpdateToDB;
import kr.co.ict.servlet.service.user.UserOutService;
import kr.co.ict.servlet.service.user.UserType1PageService;

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
		
		// ?????? ??????
		
			// ????????? (post??? ??????)
			request.setCharacterEncoding("utf-8");
			
			// uri ????????????
			String uri = request.getRequestURI();
			
			// ????????? ??? .jsp ????????? ????????? ?????? ???????????? ??????
			String ui = null;
			
			// ??????????????? - ?????? ???
			IReviewService rs = null;
			
			// ??????????????? - ?????? ???
			IRentalService rts = null;
			
			// ??????????????? - ??? ???
			IBookService bs = null;
			
			// ??????????????? - ???????????? ???
			IRequestService rqs = null;
			
			// ??????????????? - ?????? ???
			IUserService us = null;
			
			System.out.println("?????? ???????????? ????????? .do ?????? -> " + uri);
		
		
		// ??? ?????? ?????? ????????? ????????????
		if(uri.equals("/electronic_library/insertReviewForm.do")) {
			rs = new ReviewInsertFormService();
			rs.execute(request, response);			
			ui = "/book/book_review_form.jsp";
			
		// ??? ?????? ????????? ?????? ????????? DB??? ????????????	
		}else if(uri.equals("/electronic_library/insertReview.do")) {
			rs = new ReviewInsertToDBService();
			rs.execute(request, response);
			ui = "/reviewList.do";
			
		// ??? ?????? ?????????
		}else if(uri.equals("/electronic_library/reviewList.do")) {
			rs = new ReviewListService();
			rs.execute(request, response);
			ui = "/book/book_review_list.jsp";
		
		// ??? ?????? ?????????
		}else if(uri.equals("/electronic_library/reviewDetail.do")) {
			rs = new ReviewDetailService();
			rs.execute(request, response);
			ui = "/book/book_review_detail.jsp";
			
		// ??? ?????? ????????? ??????
		}else if(uri.equals("/electronic_library/updateReviewForm.do")){
			rs = new ReviewUpdateFormService();
			rs.execute(request, response);
			ui = "/book/review_update_form.jsp";
			
			
		// ??? ?????? ????????? ????????? ????????? DB?????? update??????
		}else if(uri.equals("/electronic_library/updateReview.do")){	
			rs = new ReviewUpdateService();
			rs.execute(request, response);
			ui = "/reviewDetail.do?revnum=" + request.getParameter("revnum");
		
		// ??? ?????? ??????
		}else if(uri.equals("/electronic_library/deleteReview.do")) {
			rs = new ReviewDeleteService();
			rs.execute(request, response);
			ui = "/reviewList.do";

		// ??? ?????? ?????? ?????? ?????????
		}else if(uri.equals("/electronic_library/reviewSearch.do")) {
			rs = new ReviewSearchService();
			rs.execute(request, response);
			ui ="/book/book_review_search_list.jsp";
			
		// ??? ?????? ?????? ??????
		}else if(uri.equals("/electronic_library/bookDetail.do")) {
			bs = new BookDetailService();
			bs.execute(request, response);
			ui = "/book/book_detail.jsp";
			
		// ??? ????????? ??????????????? ??? ????????? ??????
		}else if(uri.equals("/electronic_library/bookList.do")) {
			bs = new BookListService();
			bs.execute(request, response);
			ui = "/master/book_list.jsp";
			
		// ??? ?????? ?????? ?????? ??? ?????? ??????
		}else if(uri.equals("/electronic_library/rentCheck.do")) {
			rts = new RentCheckService();
			rts.execute(request, response);
			ui = "/book/book_detail.jsp";
			
		// ??? ????????????????????? ?????? ?????? ??????	
		}else if(uri.equals("/electronic_library/rentInfo.do")) {
			rts = new RentInfoService();
			rts.execute(request, response);
			ui = "/users/book_return.jsp";
			
		// ??? ?????? ?????? ???????????? ?????? ?????? ?????? ???
		}else if(uri.equals("/electronic_library/returnBook.do")) {
			rts = new ReturnBookService();
			rts.execute(request, response);
			ui = "/rentInfo.do";
			
		// ??? ????????? ??????????????? ?????? ????????? ??????
		}else if(uri.equals("/electronic_library/bookRentList.do")) {
			rts = new BookRentListService();
			rts.execute(request, response);
			ui = "/master/book_rent_list.jsp";
			
		// ??? ????????? ??????????????? ???????????????-> ????????? ??????????????? ??????
		}else if(uri.equals("/electronic_library/bookRentListOneUser.do")) {
			System.out.println("?????? ??????");
			rts = new UserRentInfoService();
			rts.execute(request, response);
			ui = "/master/book_rent_list_one_user.jsp";
		
		// ??? ?????? ?????? ????????? ??????
		}else if(uri.equals("/electronic_library/insertRequestForm.do")) {
			rqs = new RequestInsertFormService();
			rqs.execute(request, response);
			ui = "/request/book_request_form.jsp";
		
		// ??? ?????? ?????? ?????? ????????? ????????? DB??? INSERT
		}else if(uri.equals("/electronic_library/requestInsertFormToDB.do")) {
			rqs = new RequestFormToDBService();
			rqs.execute(request, response);
			ui = "/requestList.do";
		
		// ??? ?????? ?????? ???????????? ??????
		}else if(uri.equals("/electronic_library/requestList.do")) {
			rqs = new RequestListService();
			rqs.execute(request, response);
			ui = "/request/book_request_list.jsp";
		
		// ??? ?????? ?????? ???????????? ?????? (????????? ??????)
		}else if(uri.equals("/electronic_library/requestDetail.do")){
			rqs = new RequestDetailService();
			rqs.execute(request, response);
			ui = "/request/book_request_detail.jsp";
		
		// ??? ?????? ?????? ???????????? ??????2 (????????? ??? ????????? ??????) : ????????? ??????
		}else if(uri.equals("/electronic_library/requestDetail22.do")) {
			rqs = new RequestDetail2Service();
			rqs.execute(request, response);
			ui = "/request/book_request_detail.jsp";
				
		// ??? ?????? ?????? ?????? ????????? ??????
		}else if(uri.equals("/electronic_library/requestUpdateForm.do")) {
			rqs = new RequestDetailUpdateFormService();
			rqs.execute(request, response);
			ui ="/request/book_request_detail_update_form.jsp";
		
		// ??? ?????? ????????? ?????? ???????????? DB??? UPDATE
		}else if(uri.equals("/electronic_library/requestUpdateFormToDB.do")) {
			rqs = new RequestDetailUpdateToDBService();
			rqs.execute(request, response);
			ui ="/requestDetail22.do?reqnum=" + request.getParameter("reqnum");
		
		// ??? ?????? ?????? ??????
		}else if(uri.equals("/electronic_library/deleteBookRequest.do")) {
			rqs = new RequestDeleteService();
			rqs.execute(request, response);
			ui = "/requestList.do";
		
		// ??? ?????? ?????? ??????
		}else if(uri.equals("/electronic_library/requestPermission.do")) {
			rqs = new RequestPermissionService();
			rqs.execute(request, response);
			ui ="/requestDetail.do?reqNum=" + request.getParameter("reqnum");
		
		// ??? ????????? ????????????
		}else if(uri.equals("/electronic_library/userJoin.do")) {
			us = new UserJoinService();
			us.execute(request, response);
			ui ="/users/login_form.jsp";
			
		// ??? ????????? ?????????
		}else if(uri.equals("/electronic_library/userLogin.do")) {
			us = new UserLoginService();
			us.execute(request, response);
			ui ="/mainPage.do";
		
		// ??? ????????? ????????????
		}else if(uri.equals("/electronic_library/userLogout.do")) {
			us = new UserLogoutService();
			us.execute(request, response);
			ui="/users/login_form.jsp";
		
		// ??? ????????? ???????????? ??????
		}else if(uri.equals("/electronic_library/uTypeCheck1.do")) {
			us = new UserType1PageService();
			us.execute(request, response);
			ui="/users/admin_page.jsp";
		
		// ??? ?????? ???????????? ??????
		}else if(uri.equals("/electronic_library/uTypeCheck0.do")) {
			us = new UserMyInfoService();
			us.execute(request, response);
			ui="/users/my_page.jsp";
			
		// ??? ?????? ????????? - ?????? ?????? (????????? ??????)
		}else if(uri.equals("/electronic_library/userInfoUpdateForm.do")) {
			us = new UserInfoUpdateForm();
			us.execute(request, response);
			ui="/users/user_info_update_form.jsp";
		
		// ??? ??????????????? - ?????? ?????? (DB??? UPDATE)
		}else if(uri.equals("/electronic_library/userInfoUpdateToDB.do")) {
			us = new UserMyInfoUpdateToDB();
			us.execute(request, response);
			ui="/uTypeCheck0.do";
		
		// ??? ??????????????? - ?????? ??????
		}else if(uri.equals("/electronic_library/userOut.do")){
			us = new UserOutService();
			us.execute(request, response);
			ui="/users/user_out_script.jsp";
			
		// ??? ??????????????? - ?????? ?????????
		}else if(uri.equals("/electronic_library/userList.do")){
			us = new UserListService();
			us.execute(request, response);
			ui="/master/user_list.jsp";
			
		// ?????? ????????? (?????? ??????????????? ?????? ??????)
		}else if(uri.equals("/electronic_library/mainPage.do")) {
			us = new MainPageService();
			us.execute(request, response);
			ui = "/";
			
		// ??? ???	
		}else {
			ui = "/mainPage.do";
		}
		
		// ?????????
		RequestDispatcher dp = request.getRequestDispatcher(ui);
		dp.forward(request, response);
		
		
		
		
	}
	
	

}

