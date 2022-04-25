package com.LoginController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Paging.LPaging;

public class LLoginPaging implements LAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		int pstartno = 0;
		pstartno = Integer.parseInt(request.getParameter("pstartno"));
		LPaging paging = new LPaging(pstartno);
		
		request.setAttribute("paging", paging);
	}
}
