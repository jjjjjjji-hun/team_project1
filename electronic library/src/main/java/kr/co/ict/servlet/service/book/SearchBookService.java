package kr.co.ict.servlet.service.book;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BookDAO;
import kr.co.ict.BookVO;
import kr.co.ict.servlet.service.review.IReviewService;

public class SearchBookService implements IBookService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// main_Page.jsp에서 날린 http 데이터들
        
        String searchKeyword = request.getParameter("keyword");
        System.out.println("(서블릿)서블릿북서치2에 들어온 검색 키워드 -> "+ searchKeyword);
        
        String option = request.getParameter("option");
        System.out.println("(서블릿)서블릿북서치2에 들어온 옵션 키워드 -> "+ option);
        
        // BookDAO 메서드 호출 (해당하는 옵션, 키워드로 찾아온 책 리스트)
        BookDAO dao = BookDAO.getInstance();
        List<BookVO> booklist = dao.getSearchBookList2(option, searchKeyword);

        // 바인딩
        request.setAttribute("BookList", booklist);
        request.setAttribute("searchKeyword", searchKeyword);
		
	}

}
