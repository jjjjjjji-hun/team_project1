package kr.co.ict.servlet.service.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RequestDAO;
import kr.co.ict.RequestVO;

public class RequestListService implements IRequestService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// 다오 메서드
		RequestDAO dao = RequestDAO.getInstance();
		List<RequestVO> allRequestList = dao.getAllRequestList();
		
		// 바인딩
		request.setAttribute("allRequestList", allRequestList);
		
	}

}
