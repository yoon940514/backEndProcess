package com.LoginController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LoginDao.LDao;
import com.LoginDto.LDto;

public class LBan implements LAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		LDao dao = new LDao ();
		LDto dto = new LDto ();	
		
		dto.setLid(request.getParameter("lid2"));
				
		if(dao.ban(dto)<1)
		{
			out.println("<script> alert('관리자는 강퇴할 수 없습니다'); history.go(-1);</script>");
		} else
		{
			out.println("<script> alert('강퇴 성공'); location.href='selectadministerform.mypage?pstartno=0'</script>");
		}
	}

}
