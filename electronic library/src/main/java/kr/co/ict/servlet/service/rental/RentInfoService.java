package kr.co.ict.servlet.service.rental;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.co.ict.RentalDAO;
import kr.co.ict.RentalVO;
import kr.co.ict.RequestDTO;
import kr.co.ict.UserDAO;
import kr.co.ict.UserVO;
import kr.co.ict.servlet.service.review.IReviewService;

public class RentInfoService implements IRentalService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		String strpNum = request.getParameter("pageNum");
		int pNum = 0;
		try {// 페이지 번호를 입력하면 해당 페이지로
			pNum = Integer.parseInt(strpNum);
		}catch(Exception e) {// 페이지 번호를 입력하지 않으면 자동으로 1페이지로
			pNum = 1;
		}
		// 세션 아이디
				HttpSession session = request.getSession();
				String sId = (String)session.getAttribute("sId");
				
				// 다오 생성, 메서드 호출
				RentalDAO dao1 = RentalDAO.getInstance();
				UserDAO dao2 = UserDAO.getInstance();
				List<RentalVO> rentInfoList = dao1.getAllRentalInfoBookList(sId, pNum);
				UserVO userInfo = dao2.getUserData(sId);
				// 페이징 버튼 생성을 위한 게시글 개수 확인하기
				int rentInfoCount = dao1.getPageNum();
				RequestDTO dto = new RequestDTO(rentInfoCount, pNum);
				System.out.println("페이징 처리 정보 : " + dto);
				System.out.println(userInfo);
				System.out.println(rentInfoList);
				// 바인딩
				request.setAttribute("dto", dto);
				request.setAttribute("rentInfoList", rentInfoList);
				request.setAttribute("userInfo", userInfo);
		
	}

}
