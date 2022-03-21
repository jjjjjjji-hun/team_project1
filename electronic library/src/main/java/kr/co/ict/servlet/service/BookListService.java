package kr.co.ict.servlet.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BookDAO;
import kr.co.ict.BookVO;

public class BookListService implements IReviewService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// dao
				BookDAO dao = BookDAO.getInstance();
				
				// 여러 UserVO 받아올 리스트 생성
				List<BookVO> allBookList = dao.getAllBookList();
				
				// 바인딩
				request.setAttribute("allBookList", allBookList);
		
	}

}
