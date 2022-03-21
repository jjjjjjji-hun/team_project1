package kr.co.ict.servlet.service.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.ReviewDAO;
import kr.co.ict.ReviewVO;

public class ReviewListService implements IReviewService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		
		// 다오
		ReviewDAO dao = ReviewDAO.getInstance();
		List<ReviewVO> allReviewList = dao.getAllReviewList();
		
		
		// 세션 발급
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		
		
		// 바인딩
		request.setAttribute("allReviewList", allReviewList);
		request.setAttribute("sId", sId);
		
	}

}
