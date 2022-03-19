package kr.co.ict.servlet.service.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BookDAO;
import kr.co.ict.BookVO;
import kr.co.ict.RequestDAO;

public class RequestPermissionService implements IRequestService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("-------------------------------------");
		System.out.println("(서비스)RequestPermissionService 진입");
		
		// book_request_detail.jsp에서 날아온 http 데이터
		String strReqNum = request.getParameter("reqnum");
		int reqNum = 0;
		if(strReqNum != null) {
			reqNum = Integer.parseInt(strReqNum);
		}
		String reqStatus = request.getParameter("reqstatus");
		String bName = request.getParameter("bname");
		String bWriter = request.getParameter("bwriter");
		String bPub = request.getParameter("bpub");
		String bCategory = request.getParameter("bcategory");
		
		System.out.println("받은 데이터 -> " + reqNum + ", " + reqStatus + ", " + bName + ", " + bWriter + ", " + bPub + ", " + bCategory);
		
		
		// 해당 '도서 요청'의 상태를 바꿔줌(false : 대기중 -> true : 구매완료)
		RequestDAO dao = RequestDAO.getInstance();
		dao.updateRequestStatus(reqNum);
		System.out.println("(서비스)RequestPermissionService에서 도서 상태 변경 완료");
		
		
		// 요청 허가 완료된 도서를 book 테이블에 적재
		BookDAO dao2 = BookDAO.getInstance();
		BookVO bookCheck = dao2.getBookData(bName);
		
			// book 테이블에 해당 도서가 없는 경우에만 적재
			if(bookCheck == null) {
				dao2.insertBookData2(bName, bWriter, bPub, bCategory);
				System.out.println("(서비스)RequestPermissionService에서 도서 적재 완료");
			}
		
		
	}

}
