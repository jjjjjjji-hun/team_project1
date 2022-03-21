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
import kr.co.ict.BookDTO;
import kr.co.ict.BookVO;
import kr.co.ict.RequestDTO;

/**
 * Servlet implementation class mainPageServlet
 */
@WebServlet("/mainPage")
public class MainPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MainPageServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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
		
		System.out.println("모든 리스트 목록 : " + allBookList);
		
		// 페이징 버튼 생성을 위한 게시글 개수 확인하기
		int bookCount = dao.getPageNum();
		BookDTO dto = new BookDTO(bookCount, pNum);
		System.out.println("페이징 처리 정보 : " + dto);
		
		// 바인딩
		request.setAttribute("dto", dto);
		request.setAttribute("allBookList", allBookList);
		
		// 포워딩
		RequestDispatcher dp = request.getRequestDispatcher("/main_Page.jsp");
		dp.forward(request, response);
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
