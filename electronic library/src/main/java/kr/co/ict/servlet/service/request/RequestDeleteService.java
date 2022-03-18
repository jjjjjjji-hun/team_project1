package kr.co.ict.servlet.service.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RequestDAO;

public class RequestDeleteService implements IRequestService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		int reqNum = Integer.parseInt(request.getParameter("reqnum"));
		
		// 다오 메서드
		RequestDAO dao = RequestDAO.getInstance();
		dao.deleteBookRequest(reqNum);
	}

}
