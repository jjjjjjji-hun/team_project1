package kr.co.ict.servlet.service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BookDAO;
import kr.co.ict.RentalDAO;
import kr.co.ict.RentalVO;
import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

public class ReturnBookService implements IReviewService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		//값 받아오기
				SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
				String returnDate = request.getParameter("returndate");
				String returnSchedule = request.getParameter("returnschedule");
				System.out.println("다오 생성 전 : " + returnDate); // null
				System.out.println("다오 생성 전 : " + returnSchedule); // not null
				int rentNum = Integer.parseInt(request.getParameter("rentnum"));
				HttpSession session = request.getSession();
				String sId = (String)session.getAttribute("sId");
				int bNum = Integer.parseInt(request.getParameter("bnum"));
				String Overdue = request.getParameter("overdue");
				Calendar reDate = Calendar.getInstance();
				
				if(returnDate .equals("")) {
					returnDate = format.format(reDate.getTime());
				}
				
				// 다오 생성, 메서드 호출
				RentalDAO dao2 = RentalDAO.getInstance();
				dao2.UpdateRentalBookData(rentNum);
				BookDAO dao1 = BookDAO.getInstance();
				UserDAO dao3 = UserDAO.getInstance();
				dao1.CheckOutOff(bNum);
				dao3.countingUpdateDown(sId);
				List<RentalVO> rentInfoList = dao2.getAllRentalInfoBookList(sId);
				if(returnDate.equals("")) { // null이 returnSchedule과 비교가 안될까봐 넣어준 것
					dao2.UpdateOverdue(false, bNum);
				}else if(returnDate.compareTo(returnSchedule) > 0 ) {
					dao2.UpdateOverdue(true, bNum);
				}else if(returnDate.compareTo(returnSchedule) <= 0 ) {
					dao2.UpdateOverdue(false, bNum);
				}
		
				UserVO userInfo = dao3.getUserData(sId);
				//바인딩
				request.setAttribute("rentInfoList", rentInfoList);
				request.setAttribute("userInfo", userInfo);
		
	}

}
