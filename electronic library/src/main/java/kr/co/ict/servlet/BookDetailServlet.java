package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BookDAO;
import kr.co.ict.BookVO;

/**
 * Servlet implementation class BookDetailServlet
 */
@WebServlet("/BookDetailServlet")
public class BookDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BookDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// request.getParameter 를 이용해 도서명 가져오기
		String BName = request.getParameter("bName");
		// 디버깅
		System.out.println(BName);
		// 다오 생성
		BookDAO dao = BookDAO.getInstance();
		// 한글
		request.setCharacterEncoding("utf-8");
		// 다오에서 해당 도서명에 대한 정보 가져오고 디버깅
		BookVO Book = dao.getBookData(BName);
		System.out.println(Book);
		// 바인딩
		request.setAttribute("bName", Book);
		// 포워딩
		RequestDispatcher dp = request.getRequestDispatcher("/book/book_detail.jsp");
		dp.forward(request, response);
		//response.getWriter().append("Served at: ").append(request.getContextPath());

	}

}
