package kr.co.ict.servlet.service.book;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface IBookService {

	void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException;
	
}
