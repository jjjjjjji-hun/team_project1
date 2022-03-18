package kr.co.ict.servlet.service.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RequestDAO;

public class RequestDetailUpdateToDBService implements IRequestService{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("(서비스)RequestDetailUpdateToDBService로 진입");
		
		// 폼에서 날아온 데이터 받음
		
		int reqNum = Integer.parseInt(request.getParameter("reqnum"));
		String country = request.getParameter("fcountry");
		String reqId = request.getParameter("reqid");  // 세션 비교용
		String bName = request.getParameter("fbname");
		String bWriter = request.getParameter("fbwriter");
		String bPub = request.getParameter("fbpub");
		String bCategory = request.getParameter("fbcategory");
		String reqTitle = request.getParameter("ftitle");
		String reqContent = request.getParameter("fcontent");
		
		
		// 콘솔 확인
		System.out.println(reqNum + ", " + country + ", " + reqId + ", " + bName + ", " + bWriter + ", "
				+ bPub + ", " + bCategory + ", " + reqTitle + ", " + reqContent);
		
		// 다오 메서드
		RequestDAO dao = RequestDAO.getInstance();
		dao.updateRequestFormToDB(country, reqTitle, bName, bWriter, bPub, bCategory, reqContent, reqNum);
		
	}

}
