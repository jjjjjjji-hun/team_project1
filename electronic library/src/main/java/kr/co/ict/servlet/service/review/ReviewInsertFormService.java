package kr.co.ict.servlet.service.review;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.RentalDAO;
import kr.co.ict.RentalVO;
import kr.co.ict.ReviewDAO;
import kr.co.ict.ReviewVO;

public class ReviewInsertFormService implements IReviewService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int bNum = Integer.parseInt(request.getParameter("fbnum"));
		String bName = request.getParameter("fbname");
		//String uId = request.getParameter("fid");
		//System.out.println("들어온 아이디 -> " + uId);
		
		// 03.16 폼 아이디로 받아와서 넣어줬는데 세션아이디 처리할게요
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		
		
		// ■ case1) 이미 작성한 리뷰가 있으면 해당 리뷰로 리다이렉트
			// 03.16 리다이렉트 말고 포워딩으로 처리해야
			ReviewDAO dao = ReviewDAO.getInstance();
			List<ReviewVO> testVOList = dao.getMyReviewInfo(sId);
			
			System.out.println("reviewInsertform  서비스에서 받은 testVO -> " + testVOList);
			//int testVOrevNum = testVO.getRevNum();
			
			for(ReviewVO testVO : testVOList) {
				
				System.out.println("현재 for문 안에 있는 testVO -> " + testVO);
				
				if(testVO.getbNum() == bNum) {
	
	//				response.setContentType("text/html; charset=UTF-8"); 
	//				PrintWriter writer = response.getWriter(); 
	//				writer.println("<script>alert('이미 작성된 리뷰로 넘어갑니다.');</script>");
	//				writer.close();	
					
					RequestDispatcher dp = request.getRequestDispatcher("/reviewDetail.do?revnum=" + testVO.getRevNum());
					dp.forward(request, response);		
					
				}
			}
		
		/* 작업중(미완)
		// ■ case2) 렌트한 적 없는 책을 쓰는 경우
			// http://localhost:8181/electronic_library/insertReviewForm.do?fbnum=7&fbname=책6
			// 위와 같은 주소로 들어오는 것을 방지하기 위해(빌리지 않은 책 리뷰를 작성할 수 있음)
			
			RentalDAO dao2 = RentalDAO.getInstance();
			List<RentalVO> myRentList = dao2.getAllRentalInfoBookList(sId);
			
			for(RentalVO myRent : myRentList) {
				if(myRent.getbNum() != bNum) {
					
					RequestDispatcher dp = request.getRequestDispatcher("/reviewList.do");
					dp.forward(request, response);	
					
				}
			}
		*/	
		
		
		
		
		System.out.println("book_return.jsp에서 받은 데이터 -> " + bNum +", " + bName );
		System.out.println("리뷰인서트폼서비스에서 받은 세션 아이디 -> " + sId);
		
		// 바인딩
		request.setAttribute("bNum", bNum);
		request.setAttribute("bName", bName);
		request.setAttribute("uId", sId);
		
		
		
		
		
	}

}
