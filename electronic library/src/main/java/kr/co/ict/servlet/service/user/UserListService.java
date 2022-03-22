package kr.co.ict.servlet.service.user;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.UserDAO;
import kr.co.ict.UserDTO;
import kr.co.ict.UserVO;

public class UserListService implements IUserService{

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
				
				// dao
				UserDAO dao = UserDAO.getInstance();
				
				// 여러 UserVO 받아올 리스트 생성
				List<UserVO> allUserList = dao.getAllUserList(pNum);
				// 페이징 버튼 생성을 위한 게시글 개수 확인하기
				int userCount = dao.getPageNum();
				UserDTO dto = new UserDTO(userCount, pNum);
				System.out.println("페이징 처리 정보 : " + dto);
				
				// 바인딩
				request.setAttribute("dto", dto);
				request.setAttribute("allUserList", allUserList);
				
	}

}
