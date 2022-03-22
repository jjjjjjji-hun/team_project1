package kr.co.ict.servlet.service.review;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.ReviewDAO;
import kr.co.ict.ReviewDTO;
import kr.co.ict.ReviewVO;

public class ReviewListService implements IReviewService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 페이지 번호를 get방식으로 가져옵니다. (?pageNum=번호 형식으로 받아옵니다.)
		String strpNum = request.getParameter("pageNum");
		int pNum = 0;
		try {// 페이지 번호를 입력하면 해당 페이지로
			pNum = Integer.parseInt(strpNum);
		}catch(Exception e) {// 페이지 번호를 입력하지 않으면 자동으로 1페이지로
			pNum = 1;
		}
		// 다오
		ReviewDAO dao = ReviewDAO.getInstance();
		List<ReviewVO> allReviewList = dao.getAllReviewList(pNum);
		// 페이징 버튼 생성을 위한 리뷰 글 개수 확인하기
		int reviewCount = dao.getPageNum();
		ReviewDTO dto = new ReviewDTO(reviewCount, pNum);
		System.out.println("페이징 처리 정보 : " + dto);
		
		
		// 세션 발급
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		
		
		// 바인딩
		request.setAttribute("dto", dto);
		request.setAttribute("allReviewList", allReviewList);
		request.setAttribute("sId", sId);
		
	}

}
