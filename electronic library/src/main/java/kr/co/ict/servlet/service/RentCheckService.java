package kr.co.ict.servlet.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BookDAO;
import kr.co.ict.BookVO;
import kr.co.ict.RentalDAO;
import kr.co.ict.UserDAO;

public class RentCheckService implements IReviewService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// detail에서 값 받아오기
				// int Counting = Integer.parseInt(request.getParameter("count")); 북디테일에 주석처리 되어 있길래 얘도 잠깐 주석처리
				int bNum = Integer.parseInt(request.getParameter("bnum"));
				String bName = request.getParameter("bname");
				String checkOut = request.getParameter("checkout"); 
				
				HttpSession session = request.getSession();
				String sId = (String)session.getAttribute("sId");
				
				// 디버깅
				//System.out.println(bNum + ", " + bName + ", " + checkOut + ", " + sId + ", " + Counting);
				System.out.println(bNum + ", " + bName + ", " + checkOut + ", " + sId);
				
				// 다오 생성
				BookDAO dao1 = BookDAO.getInstance();
				RentalDAO dao2 = RentalDAO.getInstance();
				UserDAO dao3 = UserDAO.getInstance();
				
				// 대여 버튼 클릭 시 메서드 실행
				BookVO Book = dao1.getBookData(bName);

					dao2.insertRentalBookData(bNum, bName, sId);
					dao1.CheckOutOn(bNum);
					Book = dao1.getBookData(bName);
					dao3.countingUpdateUP(sId);
					// 바인딩
					request.setAttribute("bName", Book);
		
	}

}
