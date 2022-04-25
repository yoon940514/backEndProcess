package com.company.BoardController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoardDao.MvcBoardDao;
import com.BoardDto.MvcBoardDto;


public class BDelete implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
	     PrintWriter out = response.getWriter();
	     MvcBoardDao dao = new MvcBoardDao();
		 MvcBoardDto dto = new MvcBoardDto();
		
		 dto.setBno(Integer.parseInt(request.getParameter("bno")));
		 dto.setBpass(request.getParameter("bpass"));
		
		 if(dao.delete(dto)<1) {  
	          out.println("<script>alert('실패');history.go(-1);</script>");
	         
	      }else {String url = "list.board?pstartno=0"; 
	    	  out.println("<script>alert('성공');location.href='"+url+"';</script>"); }
	   }
	}