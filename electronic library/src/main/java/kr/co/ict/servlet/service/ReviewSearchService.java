package kr.co.ict.servlet.service;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.ReviewDAO;
import kr.co.ict.ReviewVO;

public class ReviewSearchService implements IReviewService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// book_review_list.jsp에서 검색된 키워드
		
		String searchKeyword = request.getParameter("keyword");
		System.out.println("(서비스)리뷰서치서비스에 들어온 검색 키워드 -> "+ searchKeyword);
		
		String option = request.getParameter("option");
		System.out.println("(서비스)리뷰서치서비스에 들어온 옵션 키워드 -> "+ option);
		
		
		// 해당하는 키워드로 찾아온 리뷰
		ReviewDAO dao = ReviewDAO.getInstance();
		List<ReviewVO> reviewList = dao.getSearchReviewList(option, searchKeyword);
		
		System.out.println("검색으로 찾은 리뷰 리스트 -> " + reviewList);
		
		// 바인딩
		request.setAttribute("reviewList", reviewList);
		
	}

}
