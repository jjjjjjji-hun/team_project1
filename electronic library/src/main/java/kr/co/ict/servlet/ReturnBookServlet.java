package kr.co.ict.servlet;

import java.io.IOException;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BookDAO;
import kr.co.ict.RentalDAO;
import kr.co.ict.RentalVO;
import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class ReturnBookServlet
 */
@WebServlet("/returnbook")
public class ReturnBookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ReturnBookServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		System.out.println("================================");
		System.out.println("다오 생성 후 : " + returnDate);
		System.out.println("다오 생성 후 : " + returnSchedule);
		System.out.println("다오 생성 후 : " + rentInfoList);
		
		System.out.println(returnDate.equals(""));
		System.out.println(returnDate.compareTo(returnSchedule) > 0 );
		System.out.println(returnDate.compareTo(returnSchedule) <= 0 );
		
			if(returnDate.equals("")) { // null이 returnSchedule과 비교가 안될까봐 넣어준 것
				dao2.UpdateOverdue(false, bNum);
			}else if(returnDate.compareTo(returnSchedule) > 0 ) {
				dao2.UpdateOverdue(true, bNum);
			}else if(returnDate.compareTo(returnSchedule) <= 0 ) {
				dao2.UpdateOverdue(false, bNum);
			}
	
			UserVO userInfo = dao3.getUserData(sId);
			System.out.println("if 문 실행 후 : " + rentInfoList);
			
		/*Date sqlDate1 = null;
		
		try {
			if(date1.equals("")) {
				java.util.Date returnDate = format.parse(date1);
				sqlDate1 = new Date(returnDate.getTime());
				System.out.println("a : " + sqlDate1);
			}
			java.util.Date returnSchedule = format.parse(date2);
			Date sqlDate2 = new Date(returnSchedule.getTime());
			System.out.println("b : " + sqlDate2);
			
			// 이전여부
			System.out.println("이전 여부 : " + sqlDate1.before(sqlDate2));
			// 이후 여부
			System.out.println("이후 여부 : " + sqlDate1.after(sqlDate2));
			if(sqlDate1.before(sqlDate2) == true) {
				dao2.UpdateOverdue(false);
			}else {
				dao2.UpdateOverdue(true);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}*/
		
		
		//java.util.Date returnDate = null;
				//java.util.Date returnSchedule = null;
				
				
				//System.out.println(returnDate + ", " + returnSchedule + ", " + Overdue);
				// 다오 생성, 메서드 호출
				/*try {
					returnDate = df.parse(request.getParameter("returndate"));
					returnSchedule = df.parse(request.getParameter("returnschedule"));
					if(returnDate == null) { // null이 returnSchedule과 비교가 안될까봐 넣어준 것
						dao2.UpdateOverdue(false);
					}else if(returnDate.compareTo(returnSchedule) > 0 ) {
						dao2.UpdateOverdue(true);
					}else if(returnDate.compareTo(returnSchedule) <= 0 ) {
						dao2.UpdateOverdue(false);
					}
				} catch (ParseException e) {
					e.printStackTrace();
				}*/
		// 바인딩
		request.setAttribute("rentInfoList", rentInfoList);
		request.setAttribute("userInfo", userInfo);
		// 포워딩
		RequestDispatcher dp = request.getRequestDispatcher("/users/book_return.jsp");
		dp.forward(request, response);
		
	}

}
