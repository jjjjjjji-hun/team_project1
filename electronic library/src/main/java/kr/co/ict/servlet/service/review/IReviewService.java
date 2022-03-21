/* 인터페이스 : 리뷰 */

package kr.co.ict.servlet.service.review;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IReviewService {
	
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
