package kr.co.ict.servlet.service.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.ReviewDAO;

public class ReviewDeleteService implements IReviewService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		String strReviewNum = request.getParameter("revnum");
		int reviewNum = Integer.parseInt(strReviewNum);
		
		String fId = request.getParameter("fid");
		System.out.println("(서비스)ReviewDeleteService에서 받은 리뷰 번호 : " + reviewNum + ", 폼 아이디 : " + fId);
		
		// 세션 아이디
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		System.out.println("(서비스)ReviewDeleteService에서 발급된 세션 아이디 -> " + sId);
		
		if(fId.equals(sId)) {
			// 다오 생성
			ReviewDAO dao = ReviewDAO.getInstance();
			System.out.println("다오 생성 완료");
			
			// 메서드 실행
			dao.deleteReview(reviewNum);
		}
		
	}

}
