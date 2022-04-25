package com.Frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.company.BoardController.*;

/**
 * Servlet implementation class FrontController
 */
@WebServlet("*.board")
public class BoardFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
    public BoardFrontController() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request,response);
	}
	
	private void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String path = request.getServletPath();
		String url = "";
		BAction comm = null;
		
		if(path.equals("/list.board")) {System.out.println("list");
			comm = new BList(); comm.execute(request, response);
			comm = new BPaging(); comm.execute(request,response);
			
			url = "board/list.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		
		}else if(path.equals("/write_view.board")) {System.out.println("write_view");
			url="board/write.jsp";
			request.getRequestDispatcher(url).forward(request, response);
		}else if(path.equals("/write.board")) {System.out.println("insert");
			comm = new BWrite(); comm.execute(request,response);
//			out.println("<script>alert('성공'); location.href='"+url+"';</script>");
		}else if(path.equals("/detail.board")) {System.out.println("detail");
			comm = new BDetail(); comm.execute(request,response);
			url="board/detail.jsp";
			request.getRequestDispatcher(url).forward(request, response);
	
		}else if(path.equals("/edit_view.board")) {System.out.println("edit_view");
		comm = new BEditView(); comm.execute(request,response);
		url="board/edit.jsp";
		request.getRequestDispatcher(url).forward(request, response);

		}else if(path.equals("/edit.board")) {System.out.println("edit");
		comm = new BEdit(); comm.execute(request,response);

		}else if(path.equals("/delete_view.board")) {System.out.println("delete_view");
		url="board/delete.jsp";
		request.getRequestDispatcher(url).forward(request,response);

		}else if(path.equals("/delete.board")) {System.out.println("delete");
		comm = new BDelete(); comm.execute(request,response);
//		url="list.do";
//		out.println("<script>location.href='"+url+"';</script>");
		}
	}
}
