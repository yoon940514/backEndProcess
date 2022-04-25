package com.company.BoardController;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoardDao.MvcBoardDao;
import com.BoardDto.MvcBoardDto;


public class BDetail implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("text/html; charset=UTF-8");
		MvcBoardDao dao = new MvcBoardDao();
		MvcBoardDto dto = new MvcBoardDto();
		dto.setBno(Integer.parseInt(request.getParameter("bno")));
		dao.update(dto);
		request.setAttribute("dto", dao.listOne(dto));

	}

}
