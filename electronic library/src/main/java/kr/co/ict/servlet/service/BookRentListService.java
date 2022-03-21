package kr.co.ict.servlet.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RentalDAO;
import kr.co.ict.RentalVO;

public class BookRentListService implements IReviewService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) {
		// dao
				RentalDAO dao = RentalDAO.getInstance();
				// 여러 RentalVO 받아올 리스트 생성
				List<RentalVO> allRentalBookList = dao.getAllRentalBookList();
				System.out.println("리스트 : " + allRentalBookList);
				// 바인딩
				request.setAttribute("allRentalBookList", allRentalBookList);
		
	}

}
