package com.LoginController;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.LoginDao.LDao;
import com.LoginDto.LDto;

public class LLogin implements LAction {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String lid = request.getParameter("lid"); 	
	 	String lpw = request.getParameter("lpw");
	 	String remember = request.getParameter("remember");
		
		LDto dto = new LDto();
		LDao dao = new LDao();
		
		dto.setLid(lid);
		dto.setLpw(lpw);
	
		HttpSession session = request.getSession();	// servlet에서 세션 setAttribute할려면 있어야함

		if (dao.login(dto) > 0)
		{
			session.setAttribute("lid", lid);
			session.setAttribute("lpw", lpw);
			
			if( remember !=null) { 			
	 			Cookie cookie1 = new Cookie("lid", lid);
	 			Cookie cookie2 = new Cookie("remember","checked");
	 			cookie1.setMaxAge(1*60*60*24*3);
	 			cookie2.setMaxAge(1*60*60*24*3);
	 			response.addCookie(cookie1);	
	 			response.addCookie(cookie2); 			
	 		}else{
	 			String cookie = request.getHeader("Cookie");
	 			if(cookie != null){
	 				Cookie [] cookies = request.getCookies();
	 				for(int i=0; i<cookies.length; i++){
	 					if(cookies[i].getName().equals("remember") || cookies[i].getName().equals("lid")) {
	 						cookies[i].setMaxAge(0); 
	 						response.addCookie(cookies[i]);
	 				}
	 			    }
	 					
	 			}
	 		}	
			out.println("<script> alert('로그인 성공.'); location.href='home.mypage';</script>");
			
		} else
		{
			out.println("<script> alert('로그인 실패. 아이디나 비밀번호를 확인해주세요.'); history.go(-1);</script>");
		}
	}
}
