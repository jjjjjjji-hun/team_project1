package kr.co.ict.servlet.service.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BookDAO;
import kr.co.ict.BookDTO;
import kr.co.ict.BookVO;
import kr.co.ict.RequestDTO;
import kr.co.ict.servlet.service.review.IReviewService;

public class BookListService implements IBookService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String strpNum = request.getParameter("pageNum");
		int pNum = 0;
		try {// 페이지 번호를 입력하면 해당 페이지로
			pNum = Integer.parseInt(strpNum);
		}catch(Exception e) {// 페이지 번호를 입력하지 않으면 자동으로 1페이지로
			pNum = 1;
		}
		// dao
		BookDAO dao = BookDAO.getInstance();
				
		// 여러 UserVO 받아올 리스트 생성
		List<BookVO> allBookList = dao.getAllBookList(pNum);
		
		// 페이징 버튼 생성을 위한 게시글 개수 확인하기
		int bookCount = dao.getPageNum();
		BookDTO dto = new BookDTO(bookCount, pNum);
		System.out.println("페이징 처리 정보 : " + dto);
		
		// 바인딩
		request.setAttribute("dto", dto);
		request.setAttribute("allBookList", allBookList);
		
	}

}
