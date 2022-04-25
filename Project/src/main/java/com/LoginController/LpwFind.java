package com.LoginController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LoginDao.LDao;
import com.LoginDto.LDto;

public class LpwFind implements LAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
	
		LDto dto = new LDto();
		LDao dao = new LDao();
		
		dto.setLemail(request.getParameter("lemail"));
		dto.setLid(request.getParameter("lid"));
		
		if (dao.LpwFind(dto) == 1) 
		{
			out.println("<script> alert('당신의 비밀번호는 " + dao.LpwFind0(dto).getLpw() + "입니다.'); location.href='loginform.mypage'</script>");
		} else {
			out.println("<script> alert('아이디나 이메일주소, 전화번호를 잘못 입력했습니다.'); history.go(-1);</script>");
		}
	}

}
