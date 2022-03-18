package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BookDAO;
import kr.co.ict.BookVO;
import kr.co.ict.RentalDAO;
import kr.co.ict.RentalVO;
import kr.co.ict.UserDAO;

/**
 * Servlet implementation class RentCheckServlet
 */
@WebServlet("/RentCheckServlet")
public class RentCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 한글
		request.setCharacterEncoding("utf-8");
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
			// 포워딩
			RequestDispatcher dp = request.getRequestDispatcher("/book/book_detail.jsp");
			dp.forward(request, response);
		
		/*if(uId == null){
			out.println("<script>alert('로그인이 필요한 서비스 입니다.');</script>");
		} else {
			out.println("<script>alert('대여가 완료되었습니다. 마이페이지를 확인해주세요.');</script>");*/
		// 바인딩
		//request.setAttribute("bName", Book);
		// 포워딩
		//RequestDispatcher dp = request.getRequestDispatcher("/book/book_detail.jsp");
		//dp.forward(request, response);
	}

}
