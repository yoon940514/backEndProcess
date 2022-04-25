package com.Frontcontroller;


import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.LoginController.LAction;
import com.LoginController.LBan;
import com.LoginController.LDelete;
import com.LoginController.LDetail;
import com.LoginController.LIdEqual;
import com.LoginController.LJoin;
import com.LoginController.LListAll;
import com.LoginController.LLogin;
import com.LoginController.LLoginPaging;
import com.LoginController.LLogout;
import com.LoginController.LMypage;
import com.LoginController.LUpdate;
import com.LoginController.LidFind;
import com.LoginController.LperDetail;
import com.LoginController.LpwFind;


/**
 * Servlet implementation class Loginfrontcontroller
 */
@WebServlet("*.mypage")
public class LoginFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginFrontController() {
        super();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request,response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request,response);
	}
	
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
				
		String path=request.getServletPath();
		LAction controller=null;
		
		
		if(path.equals("/loginform.mypage")) 
		{ 
			System.out.println("loginform.jsp로 가기");    
			request.getRequestDispatcher("mypage/loginform.jsp").forward(request, response);
		}
		else if(path.equals("/joinselect.mypage")) 
		{
			System.out.println("joinselect.jsp으로 가기"); 
			request.getRequestDispatcher("mypage/joinselect.jsp").forward(request, response);
		}
		
		else if(path.equals("/joinform.mypage")) 
		{
			System.out.println("joinform.jsp로 가기");
			request.setAttribute("luser", request.getParameter("luser"));
			request.getRequestDispatcher("mypage/joinform.jsp").forward(request, response);
		}
		
		else if(path.equals("/home.mypage")) 
		{
			System.out.println("home.jsp로 가기");
			request.getRequestDispatcher("home.jsp").forward(request, response);
		}
		
		else if(path.equals("/IdEqual.mypage"))
		{
			System.out.println("아이디 중복검사 프로세스로 가기");
			controller =new LIdEqual();  controller.execute(request,response);	
		}
		
		else if(path.equals("/join.mypage")) 
		{
			System.out.println("회원가입 프로세스로 가기");
			controller =new LJoin();  controller.execute(request,response);	
		}
		
		else if(path.equals("/login.mypage")) 
		{
			System.out.println("로그인 프로세스로 가기");
			controller =new LLogin();  controller.execute(request,response);
		}
		
		else if(path.equals("/mypageKakao.mypage"))
		{
			System.out.println("mypageKakao.jps로 가기");
			request.getRequestDispatcher("mypage/mypageKakao.jsp").forward(request, response);
		}
		
		else if(path.equals("/mypage.mypage")) 
		{
			System.out.println("마이페이지 프로세스로 가기");
			controller =new LMypage();  controller.execute(request,response);
			request.getRequestDispatcher("mypage/mypage.jsp").forward(request, response);
		}
		
		else if(path.equals("/perdetail.mypage")) 
		{
			System.out.println("아이디검색 프로세스로 가기");
			controller =new LperDetail();  controller.execute(request,response);
		}
		
		else if(path.equals("/detail.mypage")) 
		{
			System.out.println("상세검색 프로세스로 가기");
			controller =new LDetail();  controller.execute(request,response);
			request.getRequestDispatcher("mypage/idDetail.jsp").forward(request, response);
		}
		
		else if(path.equals("/perdetailview.mypage")) 
		{
			System.out.println("perdetailview.jsp로 가기");
			request.getRequestDispatcher("mypage/perdetailview.jsp").forward(request, response);
		}
		
		else if(path.equals("/logout.mypage")) 
		{
			System.out.println("로그아웃 프로세스로 가기");
			controller =new LLogout();  controller.execute(request,response);
		}
		
		else if(path.equals("/findselect.mypage")) 
		{
			System.out.println("findselect.jsp으로 가기");
			request.getRequestDispatcher("mypage/findselect.jsp").forward(request, response);
		}
		
		else if(path.equals("/findidform.mypage")) 
		{
			System.out.println("findidform.jsp으로 가기");
			request.getRequestDispatcher("mypage/findidform.jsp").forward(request, response);
		}
		
		
		else if(path.equals("/findpwform.mypage")) 
		{
			System.out.println("findpwform.jsp으로 가기");
			request.getRequestDispatcher("mypage/findpwform.jsp").forward(request, response);
		}
		
		else if(path.equals("/idfind.mypage")) 
		{
			System.out.println("id찾기 프로세스로 가기");
			controller =new LidFind();  controller.execute(request,response);
		}
		
		else if(path.equals("/pwfind.mypage")) 
		{
			System.out.println("pw찾기 프로세스로 가기");
			controller = new LpwFind(); controller.execute(request,response);
		}
		
		else if(path.equals("/updateform.mypage")) 
		{
			System.out.println("updateform으로 가기");
			request.getRequestDispatcher("mypage/updateform.jsp").forward(request, response);
		}
		
		else if(path.equals("/update.mypage")) 
		{
			controller = new LUpdate(); controller.execute(request,response);
		}
		
		else if(path.equals("/selectadministerform.mypage")) 
		{
			System.out.println("selectadministerform으로 가기");
			
			controller = new LListAll(); controller.execute(request,response);
			controller = new LLoginPaging(); controller.execute(request,response);
			request.getRequestDispatcher("mypage/selectadministerform.jsp").forward(request, response);
		}
		
		else if(path.equals("/ban.mypage")) 
		{
			System.out.println("ban 프로세스로 가기");
			controller = new LBan(); controller.execute(request,response);
		}
		
		else if(path.equals("/deleteview.mypage")) 
		{
			System.out.println("deleteview로 가기");
			request.getRequestDispatcher("mypage/deleteview.jsp").forward(request, response);
		}
		
		else if(path.equals("/delete.mypage")) 
		{
			System.out.println("delete");
			controller = new LDelete(); controller.execute(request,response);
		}
	}
}
