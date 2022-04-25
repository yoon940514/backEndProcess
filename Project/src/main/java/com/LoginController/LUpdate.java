package com.LoginController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginDao.LDao;
import com.LoginDto.LDto;

public class LUpdate implements LAction{

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		LDao dao = new LDao ();
		LDto dto = new LDto ();	
		HttpSession session = request.getSession();
		
		dto.setLid((String)session.getAttribute("lid"));
		dto.setLpw(request.getParameter("lpw"));
		dto.setLemail(request.getParameter("lemail"));
		dto.setLage(Integer.parseInt(request.getParameter("lage")));
		dto.setLsex(request.getParameter("lsex"));
		
		if((dao.update(dto)<1))
		{
			out.println("<script> history.go(-1);</script>");
		} else {
			out.println("<script> alert('수정 성공'); location.href='mypage.mypage'</script>");
		}
	}

}
