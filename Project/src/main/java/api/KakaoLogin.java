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

import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

/**
 * Servlet implementation class KakaoLogin
 */
@WebServlet("/KakaoLogin")
public class KakaoLogin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public KakaoLogin() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		HttpSession session = request.getSession();
        String code = request.getParameter("code");
		
        String apiURL="https://kauth.kakao.com/oauth/token?grant_type=authorization_code&"
        		+ "client_id=6ffd179c0c8458bdbe91deb86d4707be&"
        		+ "redirect_uri=http://localhost:8080/Project/KakaoLogin&code=" + code;
        	
		BufferedReader reader = null;
		HttpURLConnection conn = null;
		
		try {
			URL url = new URL(apiURL);
			conn = (HttpURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
			conn.setDoInput(true);
			conn.setDoOutput(true);
			conn.setRequestProperty("Content-type", "application/json; charset=utf-8");
			
			if (conn.getResponseCode() == 200) { 
				reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
			}	String line="";
				StringBuffer buffer = new StringBuffer();
				while((line=reader.readLine()) != null) {buffer.append(line);}
				out.println(buffer.toString()); 
				try {reader.close();} catch (Exception e) {e.printStackTrace();}
				try { conn.disconnect();} catch (Exception e) {e.printStackTrace();}
		
		JsonParser JsonParser = new JsonParser();
		JsonObject Obj = (JsonObject)JsonParser.parse(buffer.toString());
		String token = Obj.get("access_token").getAsString();
		
		apiURL = "https://kapi.kakao.com/v2/user/me";
		url = new URL(apiURL);
		conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Authorization","Bearer " + token);
		conn.setRequestProperty("Content-type", "application/json; charset=utf-8");

		if (conn.getResponseCode() == 200) { 
			reader = new BufferedReader(new InputStreamReader(conn.getInputStream()));
		}	line=""; buffer = new StringBuffer();
			while((line=reader.readLine()) != null) {buffer.append(line);}
			out.println(buffer.toString());
			Obj = (JsonObject) JsonParser.parse(buffer.toString());
			JsonObject properties = (JsonObject) Obj.get("properties");
			session.setAttribute("nickname", properties.get("nickname").getAsString());
			session.setAttribute("profile_image", properties.get("profile_image").getAsString());
			
			request.getRequestDispatcher("/mypage/mypageKakao.jsp").forward(request, response);
			
		}catch (Exception e) {e.printStackTrace();}
		finally {reader.close(); conn.disconnect();}
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
