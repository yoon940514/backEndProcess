package com.company.BoardController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoardDao.MvcBoardDao;
import com.BoardDto.MvcBoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;

public class BEdit implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		MvcBoardDao dao = new MvcBoardDao();
		MvcBoardDto dto = new MvcBoardDto();
		int bno = 0;
		//String filepath = "C:\\upload"; // 연습용
		String filepath = request.getServletContext().getRealPath("/upload/"); // 호스팅용
	try {	
		MultipartRequest multi = new MultipartRequest(request, filepath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		String bfile = multi.getFilesystemName("bfile");
		bno = Integer.parseInt(multi.getParameter("bno"));
		if (bfile == null) {
			dto.setBno(bno);	MvcBoardDto prevFile = dao.listOne(dto);
			bfile = prevFile.getBfile();
			}
		
		dto.setBno(bno);
		dto.setBfile(bfile);
		dto.setBname(multi.getParameter("bname"));
		dto.setBtitle(multi.getParameter("btitle"));
		dto.setBpass(multi.getParameter("bpass"));
		dto.setBcontent(multi.getParameter("bcontent"));
	} catch (Exception e) {e.printStackTrace();}
		
		if(dao.update(dto)<1) {
	         
	          out.println("<script>alert('비밀번호 확인');history.go(-1);</script>");
	         
	      }else {String url = "list.board?pstartno=0"; 
	    	  out.println("<script>alert('수정성공');location.href='"+ request.getContextPath()+"/detail.board?bno=" + bno + "';</script>"); }
	   }
	}