package kr.co.ict.servlet.service.review;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.ReviewDAO;

public class ReviewUpdateService implements IReviewService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		String strRevNum = request.getParameter("revnum");
		String fId = request.getParameter("fid");
		
		// 03.19 NumberFormatException: null을 해결하기 위해 int 변수를 먼저 선언하고 if문 생성
		int revNum = 0;
		if(strRevNum != null) {
			revNum = Integer.parseInt(strRevNum);
		}
		
		String strBookNum = request.getParameter("booknum");
		System.out.println("폼에서 수정한 책 번호 String 타입 : " + strBookNum);
		int bookNum = Integer.parseInt(strBookNum);
		System.out.println("폼에서 수정한 책 번호 : " + bookNum);
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		// 세션 아이디
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		
		
		if(fId.equals(sId)) {
			// 다오 생성
			ReviewDAO dao = ReviewDAO.getInstance();
			
			// 메서드 호출
			dao.updateReview(title, content, revNum);
		}
		
	}

}
