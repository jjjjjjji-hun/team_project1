package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.ReviewDAO;
import kr.co.ict.ReviewVO;

public class ReviewDetailService implements IReviewService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String strReviewNum = request.getParameter("revnum");
		int reviewNum = Integer.parseInt(strReviewNum);
		
		// 다오
		ReviewDAO dao = ReviewDAO.getInstance();
		
		// 메서드 호출
		ReviewVO reviewDetail = dao.getDetailReview(reviewNum);
		System.out.println("받은 데이터 : " + reviewDetail);
		
		// 세션 아이디
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		
		// 바인딩
		request.setAttribute("reviewDetail", reviewDetail);
		request.setAttribute("sId", sId);
	}

}
