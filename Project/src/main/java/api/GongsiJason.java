package api;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class Api3
 */
@WebServlet("*.Json")
public class GongsiJason extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public GongsiJason() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		action(request, response);
	}
	
	protected void action(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String path=request.getServletPath();
        HttpSession session = request.getSession();   

		if(path.equals("/Gongsi.Json")    ) 
		{ 
			out.println("11111111111111111111");
			String corp_code = request.getParameter("corp_code");
			String bsns_year = request.getParameter("bsns_year");
			String reprt_code = request.getParameter("reprt_code");
			
			session.setAttribute("corp_code", corp_code);
			session.setAttribute("bsns_year", bsns_year);
			session.setAttribute("reprt_code", reprt_code);
		
			// opendart 단일회사 주요계정 openapi
			String apiURL="https://opendart.fss.or.kr/api/fnlttSinglAcnt.json?crtfc_key=4da9032c12da1e518c695159c47bf9d9c7934752&corp_code=" + corp_code 
					+ "&bsns_year=" + bsns_year + "&reprt_code=" + reprt_code;
			BufferedReader reader = null;
			HttpURLConnection conn = null;
			
			try {
				URL url = new URL(apiURL);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				if (conn.getResponseCode() == 200) { 
					reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				}	
					String line="";
					StringBuffer buffer = new StringBuffer();
					while((line=reader.readLine()) != null) {buffer.append(line);}
					request.getRequestDispatcher("api/resultJason.jsp").forward(request, response);
			} catch (Exception e) {e.printStackTrace();}
			finally {reader.close(); conn.disconnect();}
			
			
		}
		
		if(path.equals("/Gongsi2.Json")    ) 
		{
			String corp_code = (String) session.getAttribute("corp_code");
			String bsns_year = (String) session.getAttribute("bsns_year");
			String reprt_code = (String) session.getAttribute("reprt_code");
		
			String apiURL="https://opendart.fss.or.kr/api/fnlttSinglAcnt.json?crtfc_key=4da9032c12da1e518c695159c47bf9d9c7934752&corp_code=" + corp_code + ""
					+ "&bsns_year=" + bsns_year + "&reprt_code=" + reprt_code;
			BufferedReader reader = null;
			HttpURLConnection conn = null;
			
			try {
				URL url = new URL(apiURL);
				conn = (HttpURLConnection) url.openConnection();
				conn.setRequestMethod("GET");
				
				if (conn.getResponseCode() == 200) { 
					reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
				}	String line="";
					StringBuffer buffer = new StringBuffer();
					while((line=reader.readLine()) != null) {buffer.append(line);}
					out.println(buffer.toString()); 
			} catch (Exception e) {e.printStackTrace();}
			finally {reader.close(); conn.disconnect();}
			
		}
	}
}
