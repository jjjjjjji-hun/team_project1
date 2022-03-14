package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BookDAO;
import kr.co.ict.BookVO;

/**
 * Servlet implementation class ServletBookSearch
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
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// book_search.jsp 에서 post 방식으로 접속
		// 다오 생성
		BookDAO dao = BookDAO.getInstance();
		
		request.setCharacterEncoding("utf-8");
		// 폼에서 날린 데이터 자바 변수로 받기
		String fBname = request.getParameter("fbname");
		// 확인하기(디버깅)
		System.out.println("post로 들어온 데이터 : " + fBname );
		// VO 생성
		List<BookVO> booklist = dao.getSearchBookList(fBname);

		// 바인딩
		request.setAttribute("BookList", booklist);
		
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
