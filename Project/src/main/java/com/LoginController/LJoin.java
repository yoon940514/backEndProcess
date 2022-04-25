package com.LoginController;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LoginDao.LDao;
import com.LoginDto.LDto;



public class LJoin implements LAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		LDao dao = new LDao ();
		LDto dto = new LDto ();	
		
		dto.setLid(request.getParameter("lid"));
		dto.setLpw(request.getParameter("lpw"));
		dto.setLemail(request.getParameter("lemail"));
		dto.setLage(Integer.parseInt(request.getParameter("lage")));
		dto.setLsex(request.getParameter("lsex"));
		dto.setLuser(request.getParameter("luseraa"));
				
		if(dao.insert(dto)<1)
		{
			out.println("<script> alert('회원가입 실패'); history.go(-1);</script>");
		} else
		{
			out.println("<script> alert('회원가입 성공'); location.href='loginform.mypage'</script>");
		}
		
		
	}
	
}
