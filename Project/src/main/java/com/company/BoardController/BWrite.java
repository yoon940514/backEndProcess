package com.company.BoardController;

import java.io.IOException;
import java.io.PrintWriter;
import java.net.InetAddress;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.BoardDao.MvcBoardDao;
import com.BoardDto.MvcBoardDto;
import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;



public class BWrite implements BAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		MvcBoardDto dto= new MvcBoardDto();
		MvcBoardDao dao = new MvcBoardDao();
		//String filepath = "C:\\upload"; // 연습용
		String filepath = request.getServletContext().getRealPath("/upload/"); // 호스팅용
	try {	
		MultipartRequest multi = new MultipartRequest(request, filepath, 5*1024*1024, "UTF-8", new DefaultFileRenamePolicy());
		
		String bfile = multi.getFilesystemName("bfile");
		if(bfile==null) {bfile="no.jpg";}
		
		dto.setBfile(bfile);
		dto.setBname(multi.getParameter("bname"));
		dto.setBtitle(multi.getParameter("btitle"));
		dto.setBpass(multi.getParameter("bpass"));
		dto.setBcontent(multi.getParameter("bcontent"));
		dto.setBip(InetAddress.getLocalHost().getHostAddress());
		request.setAttribute("list", dao.ReadAll());
		request.setAttribute("dto", dao.listOne(dto));
	} catch (Exception e) {e.printStackTrace();}	
		
		if(dao.insert(dto)<1) {
			out.println("<script>alert('관리자에게 문의바랍니다.'); history.go(-1);</script>");
	} else {out.println("<script>alert('성공'); location.href='" + request.getContextPath() + "/list.board?pstartno=0';</script>");}
	}}

