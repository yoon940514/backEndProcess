package com.LoginController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LoginDao.LDao;
import com.LoginDto.LDto;

public class LIdEqual implements LAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		LDto dto = new LDto();
		LDao dao = new LDao();
		
		dto.setLid(request.getParameter("lid"));
		int a;
		if (dao.IdEqual(dto) > 0)
		{
			a = 0;			
		} else
		{
			a = 1;
		}
		out.println(a);
	}
}
