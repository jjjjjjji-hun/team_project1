package kr.co.ict.servlet.service.book;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.BookDAO;
import kr.co.ict.BookVO;
import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;
import kr.co.ict.servlet.service.review.IReviewService;

public class BookDetailService implements IBookService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// request.getParameter 를 이용해 도서명 가져오기
				String BName = request.getParameter("bName");
				HttpSession session = request.getSession();
				String sId = (String)session.getAttribute("sId");
				// 디버깅
				System.out.println(BName);
				// 다오 생성
				BookDAO dao1 = BookDAO.getInstance();
				UserDAO dao2 = UserDAO.getInstance();
				// 다오에서 해당 도서명에 대한 정보 가져오고 디버깅
				BookVO Book = dao1.getBookData(BName);
				UserVO User = dao2.getUserData(sId);
				System.out.println(Book);
				// 바인딩
				request.setAttribute("bName", Book);
				request.setAttribute("user", User);
		
	}

}
