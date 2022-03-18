package kr.co.ict.servlet.service.request;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import kr.co.ict.RequestDAO;

public class RequestFormToDBService implements IRequestService {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		System.out.println("(서비스)RequestFormToDB로 진입");
		
		// 폼에서 날아온 데이터 받음	
		String country = request.getParameter("fcountry");
		String reqId = request.getParameter("reqid");
		String bName = request.getParameter("fbname");
		String bWriter = request.getParameter("fbwriter");
		String bPub = request.getParameter("fbpub");
		String bCategory = request.getParameter("fbcategory");
		String reqTitle = request.getParameter("ftitle");
		String reqContent = request.getParameter("fcontent");
		
		
		System.out.println("(서비스)RequestFormToDB에서 받은 데이터 -> " 
		+ country + ", " + reqId + ", " + bName + ", " + bWriter + ", " + bPub + ", " + bCategory + ", " + reqTitle + ", " + reqContent);
		
		RequestDAO dao = RequestDAO.getInstance();
		dao.insertRequest(country, reqTitle, bName, bWriter, bPub, bCategory, reqId, reqContent);
		
	}

}
