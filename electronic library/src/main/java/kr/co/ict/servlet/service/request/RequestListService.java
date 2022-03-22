package kr.co.ict.servlet.service.request;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RequestDAO;
import kr.co.ict.RequestDTO;
import kr.co.ict.RequestVO;

public class RequestListService implements IRequestService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// 페이지 번호를 get방식으로 가져옵니다. (?pageNum=번호 형식으로 받아옵니다.)
		String strpNum = request.getParameter("pageNum");
		int pNum = 0;
		try {// 페이지 번호를 입력하면 해당 페이지로
			pNum = Integer.parseInt(strpNum);
		}catch(Exception e) {// 페이지 번호를 입력하지 않으면 자동으로 1페이지로
			pNum = 1;
		}
		// 다오 메서드
		RequestDAO dao = RequestDAO.getInstance();
		List<RequestVO> allRequestList = dao.getAllRequestList(pNum);
		
		// 페이징 버튼 생성을 위한 게시글 개수 확인하기
		int requestCount = dao.getPageNum();
		RequestDTO dto = new RequestDTO(requestCount, pNum);
		System.out.println("페이징 처리 정보 : " + dto);
		
		// 바인딩
		request.setAttribute("dto", dto);
		request.setAttribute("allRequestList", allRequestList);
		
	}

}
