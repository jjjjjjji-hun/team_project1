package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BookDAO;
import kr.co.ict.BookVO;

/**
 * Servlet implementation class ServletBookSearch2
 */
@WebServlet("/ServletBookSearch")
public class ServletBookSearch extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletBookSearch() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // main_Page.jsp에서 날린 http 데이터들
        request.setCharacterEncoding("utf-8");
        
        String searchKeyword = request.getParameter("keyword");
        System.out.println("(서블릿)서블릿북서치에 들어온 검색 키워드 -> "+ searchKeyword);
        
        String option = request.getParameter("option");
        System.out.println("(서블릿)서블릿북서치에 들어온 옵션 키워드 -> "+ option);
        
        // BookDAO 메서드 호출 (해당하는 옵션, 키워드로 찾아온 책 리스트)
        BookDAO dao = BookDAO.getInstance();
        List<BookVO> booklist = dao.getSearchBookList2(option, searchKeyword);

        // 바인딩
        request.setAttribute("BookList", booklist);
        request.setAttribute("searchKeyword", searchKeyword);
        
        // 포워딩
        if(booklist.isEmpty()) { //찾는 책이 없다는 경고문구 추가해야함
        RequestDispatcher dp = request.getRequestDispatcher("/book/book_search.jsp");
        dp.forward(request, response);
        } else {
            RequestDispatcher dp = request.getRequestDispatcher("/book/search_check.jsp");
            dp.forward(request, response);
        }
		
	}

}
