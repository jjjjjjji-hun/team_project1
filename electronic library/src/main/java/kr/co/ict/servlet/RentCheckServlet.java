package kr.co.ict.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class RentCheckServlet
 */
@WebServlet("/RentCheckServlet")
public class RentCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public RentCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// detail에서 값 받아오기
		request.setCharacterEncoding("utf-8");
		int bNum = Integer.parseInt(request.getParameter("bnum"));
		String checkOut = request.getParameter("checkout");
		String uId = request.getParameter("sid");
		System.out.println(uId);
		// 다오 생성
		
	}

}
