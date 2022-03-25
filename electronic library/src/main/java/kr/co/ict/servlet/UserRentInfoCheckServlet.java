package kr.co.ict.servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RentalDAO;
import kr.co.ict.RentalDTO;
import kr.co.ict.RentalVO;

/**
 * Servlet implementation class UseRentInfoCheckServlet
 */
@WebServlet("/UseRentInfoCheckServlet")
public class UserRentInfoCheckServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserRentInfoCheckServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
    
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String strpNum = request.getParameter("pageNum");
		System.out.println("strpNum : " + strpNum);
		int pNum = 0;
		try {// 페이지 번호를 입력하면 해당 페이지로
			pNum = Integer.parseInt(strpNum);
		}catch(Exception e) {// 페이지 번호를 입력하지 않으면 자동으로 1페이지로
			pNum = 1;
		}
		String uId = request.getParameter("uId");
		 System.out.println("pNum값 : " + pNum);
        System.out.println("user_list.jsp에서 들어온 uId의 값!! -> " + uId);
        
        // 다오 메서드 호출
        RentalDAO dao = RentalDAO.getInstance();
        System.out.println("다오 생성 완료?");
        List<RentalVO> rentalList = dao.getAllRentalInfoBookList(uId, pNum);
        System.out.println("렌탈 리스트 : " + rentalList);
        // 페이징 버튼 생성을 위한 게시글 개수 확인하기
     	int rentalCount = dao.getPageNum();
     	RentalDTO dto = new RentalDTO(rentalCount, pNum);
     	System.out.println("확인할 페이징 처리 정보 : " + dto);
        
        // 바인딩
     	request.setAttribute("dto", dto);
        request.setAttribute("rentalList", rentalList);
        request.setAttribute("uId", uId);
        
        // 포워딩
        RequestDispatcher dp = request.getRequestDispatcher("/master/book_rent_list_one_user.jsp");
        dp.forward(request, response);
	}

}
