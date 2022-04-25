package com.LoginController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginDao.LDao;
import com.LoginDto.LDto;

public class LperDetail implements LAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
		
		LDao dao = new LDao ();
		LDto dto = new LDto();
		
		dto.setLid(request.getParameter("lid"));
		
		if (dao.IdEqual(dto) == 0)
		{
			out.println("<script> alert('아이디를 잘못 입력했습니다.'); history.go(-1); </script>");
		} else {
			session.setAttribute("perDetail", dao.myPage(dto));
			out.println("<script>location.href='perdetailview.mypage' </script>");
		}		
	}
}
