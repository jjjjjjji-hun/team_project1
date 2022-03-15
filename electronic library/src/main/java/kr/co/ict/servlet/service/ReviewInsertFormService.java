package kr.co.ict.servlet.service;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RentalDAO;
import kr.co.ict.ReviewDAO;
import kr.co.ict.ReviewVO;

public class ReviewInsertFormService implements IReviewService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {

		int bNum = Integer.parseInt(request.getParameter("fbnum"));
		String bName = request.getParameter("fbname");
		String uId = request.getParameter("fid");
		
		
		/*
		// 이미 작성한 리뷰가 있으면 해당 리뷰로 리다이렉트
		ReviewDAO dao = ReviewDAO.getInstance();
		ReviewVO testVO = dao.getMyReviewInfo(uId);
		
		System.out.println("reviewInsertform  서비스에서 받은 testVO -> " + testVO);
		int testVOrevNum = testVO.getRevNum();
		if(testVO.getbNum() == bNum) {
			try {
				response.sendRedirect("http://localhost:8181/electronic_library/reviewDetail.do?revnum=" + testVOrevNum);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		*/
		
		System.out.println("리뷰인서트폼서블릿에서 받은 데이터 -> " + bNum +", " + bName + ", " + uId );
		
		// 바인딩
		request.setAttribute("bNum", bNum);
		request.setAttribute("bName", bName);
		request.setAttribute("uId", uId);
		
	}

}
