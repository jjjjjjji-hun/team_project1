package kr.co.ict.servlet.service.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.BookDAO;
import kr.co.ict.BookDTO;
import kr.co.ict.BookVO;

public class MainPageService implements IUserService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// dao
		BookDAO dao = BookDAO.getInstance();
		
		// 여러 UserVO 받아올 리스트 생성
		List<BookVO> allBookList1 = dao.getAllBookListMain();
		List<BookVO> allBookList2 = dao.getAllBookList();
		
		System.out.println("모든 리스트 목록 : " + allBookList1);
		System.out.println("모든 리스트 목록 : " + allBookList2);
		
		// 바인딩
		request.setAttribute("allBookList1", allBookList1);
		request.setAttribute("allBookList2", allBookList2);
		
	}

}
