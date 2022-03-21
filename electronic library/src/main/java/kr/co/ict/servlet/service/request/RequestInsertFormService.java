/* (서비스) 도서요청폼으로 이동 */

package kr.co.ict.servlet.service.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class RequestInsertFormService implements IRequestService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		HttpSession session = request.getSession();
		String sId = (String)session.getAttribute("sId");
		System.out.println("(서비스)RequestInsertForm에서 확인된 세션 아이디 -> " + sId);
		
		// 바인딩
		request.setAttribute("sId", sId);
		
		
	}

}
