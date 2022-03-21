/* 인터페이스 : 렌탈 */

package kr.co.ict.servlet.service.rental;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IRentalService {
	
	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;

}
