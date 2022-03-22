package kr.co.ict.servlet.service.rental;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RentalDAO;
import kr.co.ict.RentalVO;
import kr.co.ict.RequestDTO;
import kr.co.ict.servlet.service.review.IReviewService;

public class BookRentListService implements IRentalService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// 페이지 번호를 get방식으로 가져옵니다. (?pageNum=번호 형식으로 받아옵니다.)
		String strpNum = request.getParameter("pageNum");
		int pNum = 0;
		try {// 페이지 번호를 입력하면 해당 페이지로
		pNum = Integer.parseInt(strpNum);
		}catch(Exception e) {// 페이지 번호를 입력하지 않으면 자동으로 1페이지로
			pNum = 1;
		}
		// dao
		RentalDAO dao = RentalDAO.getInstance();
		// 여러 RentalVO 받아올 리스트 생성
		List<RentalVO> allRentalBookList = dao.getAllRentalBookList(pNum);
		System.out.println("리스트 : " + allRentalBookList);
		
		// 페이징 버튼 생성을 위한 게시글 개수 확인하기
		int requestCount = dao.getPageNum();
		RequestDTO dto = new RequestDTO(requestCount, pNum);
		System.out.println("페이징 처리 정보 : " + dto);
				
		// 바인딩
		request.setAttribute("dto", dto);
		request.setAttribute("allRentalBookList", allRentalBookList);
		
	}

}
