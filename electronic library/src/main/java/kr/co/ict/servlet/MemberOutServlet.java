package kr.co.ict.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.UserDAO;

/**
 * Servlet implementation class MemberOutServlet
 */
@WebServlet("/memberout")
public class MemberOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public MemberOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("/memberout doPost로 들어옴");
		
	    HttpSession session = request.getSession();
	    String sId = (String)session.getAttribute("sId");
	    
	    System.out.println("삭제 서블릿에서 발급된 세션 아이디 -> " + sId);	    
	    
	    // 회원탈퇴 완료창 (확인 / 취소 누르기도 전에 밑에 코드를 실행해버림)
	    	// 찾아보니까 자바 코드를 다 실행하고 스크립트를 출력해주는거라 안되는 것 같음 ㅠ
//	 	response.setContentType("text/html; charset=UTF-8"); 
//	 	PrintWriter out = response.getWriter(); 
//	 	out.println("<script> var result = confirm('정말 탈퇴하시겠습니까?');</script>"); 
//	 	out.println("<script> if(!result){location.href='http://localhost:8181/electronic_library/utypecheck';}</script>");
//	 	out.flush();
	 		
	 	// 다오 생성	
		UserDAO dao = UserDAO.getInstance();
		dao.deleteUser(sId);
		System.out.println("회원 탈퇴 : DB 삭제 완료");
		
		session.invalidate();
		System.out.println("회원 탈퇴 : 세션 만료");
	
		// 탈퇴 후 알림창
		response.setContentType("text/html; charset=UTF-8"); 
		PrintWriter writer = response.getWriter(); 
		writer.println("<script>alert('회원 탈퇴가 완료 되었습니다.'); location.href='http://localhost:8181/electronic_library/mainPage';</script>"); writer.close();

	}

}