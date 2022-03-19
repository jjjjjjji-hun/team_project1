package kr.co.ict.servlet.service.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.RequestDAO;

public class RequestDeleteService implements IRequestService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String strNum = request.getParameter("reqnum");
		int reqNum = 0;
		if(strNum != null) {
			reqNum = Integer.parseInt(strNum);
		}
		String fId = request.getParameter("fid");
		
		// 세션
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		
		if(fId.equals(sId)) {
			// 다오 메서드
			RequestDAO dao = RequestDAO.getInstance();
			dao.deleteBookRequest(reqNum);
		}
	}

}
