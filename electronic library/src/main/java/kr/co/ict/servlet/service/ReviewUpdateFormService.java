package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.ReviewDAO;
import kr.co.ict.ReviewVO;

public class ReviewUpdateFormService implements IReviewService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String strReviewNum = request.getParameter("revnum");
		int reviewNum = Integer.parseInt(strReviewNum);
		
		System.out.println("받은 리뷰 번호 : " + reviewNum);
		
		// 다오 생성
		ReviewDAO dao = ReviewDAO.getInstance();
		
		// 메서드 호출
		ReviewVO review = dao.getDetailReview(reviewNum);
		
		// 바인딩 
		request.setAttribute("reviewDetail", review);
		
	}

}
