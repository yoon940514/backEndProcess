package com.LoginController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginDao.LDao;
import com.LoginDto.LDto;

public class LMypage implements LAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		LDao dao = new LDao ();
		LDto dto = new LDto();
		
		HttpSession session = request.getSession();
		
		String lid = (String) session.getAttribute("lid");
		
		dto.setLid(lid);
		
		session.setAttribute("Mypage", dao.myPage(dto));
	}
}
