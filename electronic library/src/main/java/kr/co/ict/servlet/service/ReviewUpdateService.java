package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.ReviewDAO;

public class ReviewUpdateService implements IReviewService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

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
		
	}

}
