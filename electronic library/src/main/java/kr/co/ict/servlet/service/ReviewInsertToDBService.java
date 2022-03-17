/* 인터페이스-리뷰 구현체 : DB에 리뷰 적재

	리뷰 버튼 구현하고 나서 폼에서 아이디 받는 것이 아니라 세션 아이디로 바꿀 것

*/


package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.ReviewDAO;

public class ReviewInsertToDBService implements IReviewService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 나중에 구현(버튼 만들고)
		//HttpSession session = request.getSession();
		//String sId = (String)session.getAttribute("sId");
		
		int bNum = Integer.parseInt(request.getParameter("fbnum"));
		String bName = request.getParameter("fbname");
		String title = request.getParameter("ftitle");
		String content = request.getParameter("fcontent");
		String id = request.getParameter("fid");

		ReviewDAO dao = ReviewDAO.getInstance();
		
		dao.insertReview(bNum, bName, title, content, id);
		
	}

}
