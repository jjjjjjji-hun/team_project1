package kr.co.ict.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class ServletJoin
 */
@WebServlet("/ServletJoin")
public class ServletJoin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ServletJoin() {
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
		System.out.println("join_form.jsp에서 post 방식으로 접속");
		
		request.setCharacterEncoding("utf-8");
		
		String fId = request.getParameter("fid");
		String fPw = request.getParameter("fpw");
		String fName = request.getParameter("fname");
		String fPnum = request.getParameter("fpnum");
		String fEmail = request.getParameter("femail");
		
		System.out.println("post로 들어온 데이터 : " + fId + ", " + fPw + ", " + fName + ", " + fPnum + ", " + fEmail);
		
		request.setAttribute("fId", fId);
		request.setAttribute("fPw", fPw);
		request.setAttribute("fName", fName);
		request.setAttribute("fPnum", fPnum);
		request.setAttribute("fEmail", fEmail);
		
		RequestDispatcher dp = request.getRequestDispatcher("/users/join_check.jsp");
		
		dp.forward(request, response);
	}

}
