package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mysql.cj.Session;

import kr.co.ict.BookDAO;

/**
 * Servlet implementation class bookInsertServlet
 */
@WebServlet("/bookInsert")
public class bookInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public bookInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		// 다오생성
		BookDAO dao = BookDAO.getInstance();
		// 폼에서 받을 데이터 저장
		request.setCharacterEncoding("utf-8");
		int bNum = Integer.parseInt(request.getParameter("bnum"));
		String bName = request.getParameter("bname");
		String bWriter = request.getParameter("bwriter");
		String bPub = request.getParameter("bpub");
		String bCategory = request.getParameter("bcatecory");
		// insert로직 호출
		dao.insertBookData(bNum, bName, bWriter, bPub, bCategory, true);
		// book_list로 리다이렉트
		response.sendRedirect("http://localhost:8181/electronic_library/book_list.jsp");
	}

}
