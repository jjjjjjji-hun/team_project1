/* 서비스 : 도서 요청 상세 페이지로 이동 */

package kr.co.ict.servlet.service.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RequestDAO;
import kr.co.ict.RequestVO;

public class RequestDetailService implements IRequestService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String strReqNum = request.getParameter("reqNum");
		int reqNum = Integer.parseInt(strReqNum);
		
		// 다오 생성
		RequestDAO dao = RequestDAO.getInstance();
		
		// 조회수 + 1
		dao.upHit(reqNum);
		
		// 가져오기
		RequestVO requestDetail = dao.getRequestDetail(reqNum);
		
		// 바인딩
		request.setAttribute("requestDetail", requestDetail);
		
		
	}

}
