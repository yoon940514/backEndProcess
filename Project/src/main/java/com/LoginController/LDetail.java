package com.LoginController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginDao.LDao;
import com.LoginDto.LDto;

public class LDetail implements LAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		HttpSession session = request.getSession();
		PrintWriter out = response.getWriter();
		
		LDto dto = new LDto();
		LDao dao = new LDao(); 
		String luser = request.getParameter("luser"); // 이건 셀렉트
		String Sort = request.getParameter("Sort");
		String [] checkbox = request.getParameterValues("checkbox");	//이건 체크박스
		
		session.setAttribute("Sort", Sort);
		dto.setSort(Sort);
		
		String lresult="";
		for(int i=0; i<checkbox.length; i++){
			if(i!=0){lresult+=",";}	
			lresult += checkbox[i];
			
		}
			
		out.println("<script>alert('1.luser 출력:" + luser + "      2.lresult 출력:" + lresult + "');</script>");
		
		dto.setLuser(luser);
		out.println("<script>alert('3.Getluser 출력:" + dto.getLuser() + "');</script>");
		dto.setLresult(lresult);
		out.println("<script>alert('4.Getresult 출력:" + dto.getLresult()  + "');</script>");
		
		session.setAttribute("lresult", lresult);
		out.println(dao.adminDetail(dto));
				
		session.setAttribute("luserDetail", request.getParameter("luser"));
		request.setAttribute("adminlist", dao.adminDetail(dto));
	}
}
