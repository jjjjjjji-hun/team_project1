package kr.co.ict.servlet.service.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RequestDAO;
import kr.co.ict.RequestVO;

public class RequestDetailUpdateFormService implements IRequestService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("(서비스)RequestDetailUpdateFormService로 진입");
		
		String strReqNum = request.getParameter("reqnum");
		System.out.println("들어온 strReqNum -> " + strReqNum);
		int reqNum = Integer.parseInt(strReqNum);
		
		RequestDAO dao = RequestDAO.getInstance();
		RequestVO requestDetail = dao.getRequestDetail(reqNum);
		
		// 바인딩
		request.setAttribute("requestDetail", requestDetail);
		
	}

}
