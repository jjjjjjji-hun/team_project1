/*
	(문제)
      - http://localhost:8181/electronic_library/updateReviewForm.do?revnum=13
        위와 같은 주소로 접근시 자기 아이디로 쓴 리뷰가 아니어도 수정 가능한 문제 발생
      - 해결을 위해 세션 아이디 발급
*/


package kr.co.ict.servlet.service.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.ReviewDAO;
import kr.co.ict.ReviewVO;

public class ReviewUpdateFormService implements IReviewService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		
		String strReviewNum = request.getParameter("revnum");
		int reviewNum = Integer.parseInt(strReviewNum);
		
		// 03.16 추가
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		
		System.out.println("(서비스)리뷰업데이트폼서비스에서 받은 리뷰 번호 : " + reviewNum + ", 세션 아이디 : " + sId);
		
		// 다오 생성
		ReviewDAO dao = ReviewDAO.getInstance();
		
		// 메서드 호출
		ReviewVO review = dao.getDetailReview(reviewNum);
		
		// 바인딩 
		request.setAttribute("reviewDetail", review);
		request.setAttribute("sId", sId);
		
	}

}
