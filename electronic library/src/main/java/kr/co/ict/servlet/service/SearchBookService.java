package kr.co.ict.servlet.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BookDAO;
import kr.co.ict.BookVO;

public class SearchBookService implements IReviewService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// book_search.jsp 에서 post 방식으로 접속
				// 다오 생성
				BookDAO dao = BookDAO.getInstance();

				// 폼에서 날린 데이터 자바 변수로 받기
				String fBname = request.getParameter("fbname");
				// 확인하기(디버깅)
				System.out.println("post로 들어온 데이터 : " + fBname );
				// VO 생성
				List<BookVO> booklist = dao.getSearchBookList(fBname);

				// 바인딩
				request.setAttribute("BookList", booklist);
		
	}

}
