package kr.co.ict.servlet.service.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.RequestDAO;
import kr.co.ict.RequestVO;

public class RequestDetailUpdateFormService implements IRequestService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("(서비스)RequestDetailUpdateFormService로 진입");
		
		// book_request_detail.jsp에서 날아온 데이터
		String strReqNum = request.getParameter("reqnum");
		// null로 들어오는 경우 에러 방지를 위해
		int reqNum = 0;
		if(strReqNum != null) {
			reqNum = Integer.parseInt(strReqNum);
		}
		System.out.println("들어온 strReqNum -> " + strReqNum); 
		
		// 세션 아이디
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		
		RequestDAO dao = RequestDAO.getInstance();
		RequestVO requestDetail = dao.getRequestDetail(reqNum);
		
		// 바인딩
		request.setAttribute("requestDetail", requestDetail);
		request.setAttribute("sId", sId);
		
	}

}
