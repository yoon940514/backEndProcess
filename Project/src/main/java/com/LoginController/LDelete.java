package com.LoginController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginDao.LDao;
import com.LoginDto.LDto;

public class LDelete implements LAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		LDao dao = new LDao ();
		LDto dto = new LDto ();	
		HttpSession session = request.getSession();   
		
		dto.setLid(request.getParameter("lid"));
		dto.setLpw(request.getParameter("lpw"));
	      
				
		if(dao.delete(dto) == 1)
		{
			session.invalidate();
			out.println("<script> alert('탈퇴가 왼료되었습니다.'); location.href='home.mypage';</script>");
		
		} else
		{  
			out.println("<script> alert('아이디나 비밀번호가 틀렸습니다. 다시 확인해주세요.'); history.go(-1);</script>");
		}
	}

}
