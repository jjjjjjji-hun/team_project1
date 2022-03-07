/* 서블릿 : 모든 도서 확인용 -> book_list.jsp로 이동 */

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
import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;

/**
 * Servlet implementation class BookListServlet
 */
@WebServlet("/booklist")
public class BookListServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookListServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	
		// dao
		BookDAO dao = BookDAO.getInstance();
		
		// 여러 UserVO 받아올 리스트 생성
		List<BookVO> allBookList = dao.getAllBookList();
		
		System.out.println(allBookList);
		
		// 바인딩
		request.setAttribute("allBookList", allBookList);
		
		// 포워딩
		RequestDispatcher dp = request.getRequestDispatcher("/master/book_list.jsp");
		dp.forward(request, response);
		
	}	
		
		
		

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dao
		BookDAO dao = BookDAO.getInstance();
		
		// 여러 UserVO 받아올 리스트 생성
		List<BookVO> allBookList = dao.getAllBookList();
		
		// 바인딩
		request.setAttribute("allBookList", allBookList);
		
		// 포워딩
		RequestDispatcher dp = request.getRequestDispatcher("/master/book_list.jsp");
		dp.forward(request, response);
		
		
	}

}
