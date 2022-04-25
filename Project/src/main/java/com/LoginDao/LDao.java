package com.LoginDao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.*;

import com.DBManager.DBManager;
import com.LoginDto.LDto;





public class LDao {
	
	public ArrayList<LDto> selectAll(){
		ArrayList<LDto> list = new ArrayList<LDto> ();
		
		DBManager db = new DBManager();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		
		String sql = "select*from login order by lno desc;";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();				

			 while(rset.next()) 
			 {list.add(new LDto(rset.getInt("lno"),rset.getString("lid"),rset.getString("lpw"),rset.getString("lemail"),
			 rset.getInt("lage"),rset.getString("lsex"),rset.getString("luser")));}
			
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rset!=null){try{rset.close();}catch(Exception e){e.printStackTrace();}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
			if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
		}
		
		return list;
	}
	
	public LDto LidFind0(LDto dto){
		LDto result = null;		
		DBManager db = new DBManager();		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		
		String sql = "select*from login where lemail=?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getLemail());
			rset = pstmt.executeQuery();				

			if(rset.next()) {
			result=new LDto(rset.getInt("lno"),rset.getString("lid"),rset.getString("lpw"),rset.getString("lemail"),
					 rset.getInt("lage"),rset.getString("lsex"),rset.getString("luser"));
			}
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rset!=null){try{rset.close();}catch(Exception e){e.printStackTrace();}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
			if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
		}
		
		return result;
	}

	public int LidFind(LDto dto){
		int result = 0;		
		DBManager db = new DBManager();		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		
		String sql = "select*from login where lemail=?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,dto.getLemail());
			rset = pstmt.executeQuery();				

			if(rset.next()) {
				result = 1;
			} else {
				result = 0;
			}
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rset!=null){try{rset.close();}catch(Exception e){e.printStackTrace();}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
			if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
		}
		
		return result;
	}
	
	
	
	public LDto LpwFind0(LDto dto){
		LDto result = null;		
		DBManager db = new DBManager();		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		
		String sql = "select*from login where lemail=? and lid=?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);

			pstmt.setString(1,dto.getLemail());
			pstmt.setString(2,dto.getLid());
			rset = pstmt.executeQuery();				

			if(rset.next()) {
			result=new LDto(rset.getInt("lno"),rset.getString("lid"),rset.getString("lpw"),rset.getString("lemail"),
					 rset.getInt("lage"),rset.getString("lsex"),rset.getString("luser"));
			}
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rset!=null){try{rset.close();}catch(Exception e){e.printStackTrace();}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
			if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
		}
		
		return result;
	}
	
	public int LpwFind(LDto dto){
		int result = 0;		
		DBManager db = new DBManager();		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		
		String sql = "select*from login where lemail=? and lid=?";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,dto.getLemail());
			pstmt.setString(2,dto.getLid());
			rset = pstmt.executeQuery();				

			if(rset.next()) {
				result = 1;
			} else {
				result = 0;
			}
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rset!=null){try{rset.close();}catch(Exception e){e.printStackTrace();}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
			if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
		}
		
		return result;
	}
	
	public int insert(LDto dto) {
		
		int result =-1;
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		
		String sql = "insert into login (lid,lpw,lemail,lage,lsex,luser) values (?,?,?,?,?,?)";
		
		try {
			conn = db.getConnection();			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getLid());
			pstmt.setString(2, dto.getLpw());		
			pstmt.setString(3, dto.getLemail());
			pstmt.setInt(4, dto.getLage());
			pstmt.setString(5, dto.getLsex());
			pstmt.setString(6, dto.getLuser());
			
			result = pstmt.executeUpdate();			
		
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
			if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
		}
		
		return result;	
	}
	
		public int update(LDto dto) {
		
		int result =-1;
		DBManager db = new DBManager();
		Connection conn = null;
		PreparedStatement pstmt = null;
	
		
		String sql = "update login set lpw=?, lemail=?, lage=?, lsex=? where lid=?";
		
		try {
			conn = db.getConnection();			
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, dto.getLpw());		
			pstmt.setString(2, dto.getLemail());
			pstmt.setInt(3, dto.getLage());
			pstmt.setString(4, dto.getLsex());
			pstmt.setString(5, dto.getLid());
			
			result = pstmt.executeUpdate();			
		
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
			if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
		}
		
		return result;	
	}
			
		public LDto myPage(LDto dto){
			LDto result = null;		
			DBManager db = new DBManager();		
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;		
			
			String sql = "select*from login where lid=?";
			
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,dto.getLid());
				rset = pstmt.executeQuery();				

				if(rset.next()) {
				result=new LDto(rset.getInt("lno"),rset.getString("lid"),rset.getString("lpw"),rset.getString("lemail"),
						 rset.getInt("lage"),rset.getString("lsex"),rset.getString("luser"));
				}
			}catch(Exception e) {e.printStackTrace();
			}finally {
				if(rset!=null){try{rset.close();}catch(Exception e){e.printStackTrace();}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
				if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
			}
			
			return result;
		}
		
		
		
		public int login(LDto dto)
		{
			int result = 0;		
			DBManager db = new DBManager();		
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;	
			
			String sql = "select * from login where lid=? and lpw=?";
			
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,dto.getLid());
				pstmt.setString(2,dto.getLpw());
				rset = pstmt.executeQuery();				

				if(rset.next()) {
					result = 1;
				} else { 
					result = 0;
				}
			}catch(Exception e) {e.printStackTrace();
			}finally {
				if(rset!=null){try{rset.close();}catch(Exception e){e.printStackTrace();}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
				if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
			}
			return result;
		}
		
		public int IdEqual(LDto dto)
		{
			int result = 0;		
			DBManager db = new DBManager();		
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;	
			
			String sql = "select * from login where lid=?";
			
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,dto.getLid());
				rset = pstmt.executeQuery();				

				if(rset.next()) {
					result = 1;
				} else { 
					result = 0;
				}
			}catch(Exception e) {e.printStackTrace();
			}finally {
				if(rset!=null){try{rset.close();}catch(Exception e){e.printStackTrace();}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
				if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
			}
			return result;
		}
		
		public ArrayList<LDto> adminDetail(LDto dto)
		{
			ArrayList<LDto> result = new ArrayList<LDto> ();
			DBManager db = new DBManager();		
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;	
			 String a = (String) dto.getLresult();
			 String b = (String) dto.getSort();
			String sql = "select * from login where luser=? order by " + a + " " + b + "";
					
			try {
				
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setString(1,dto.getLuser());
				
				rset = pstmt.executeQuery();	

			while(rset.next()) 
			 {
				result.add(new LDto(rset.getInt("lno"),rset.getString("lid"),rset.getString("lpw"),rset.getString("lemail"),
				rset.getInt("lage"),rset.getString("lsex"),rset.getString("luser")));
			 }
				
			}catch(Exception e) {e.printStackTrace();
			}finally {
				if(rset!=null){try{rset.close();}catch(Exception e){e.printStackTrace();}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
				if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
			}
			return result;
		}
		
		public int ban(LDto dto) {
			
			int result =-1;
			DBManager db = new DBManager();
			Connection conn = null;
			PreparedStatement pstmt = null;
		
			
			String sql = "delete from login where lid=? and luser='user'";
			
			try {
				conn = db.getConnection();			
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getLid());
				
				result = pstmt.executeUpdate();			
			
			}catch(Exception e) {e.printStackTrace();
			}finally {
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
				if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
			}
			
			return result;	
		}
		
		public int delete(LDto dto) {
			
			int result =-1;
			DBManager db = new DBManager();
			Connection conn = null;
			PreparedStatement pstmt = null;
		
			
			String sql = "delete from login where lid=? and lpw=?";
			
			try {
				conn = db.getConnection();			
				pstmt = conn.prepareStatement(sql);
				
				pstmt.setString(1, dto.getLid());
				pstmt.setString(2, dto.getLpw());
				
				result = pstmt.executeUpdate();			
			
			}catch(Exception e) {e.printStackTrace();
			}finally {
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
				if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
			}
			
			return result;	
		}
			
		public int pagingListAll()
		{
			int result = 0;		
			DBManager db = new DBManager();		
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;		
			
			String sql = "select count(*) from login";
			
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				rset = pstmt.executeQuery();				

				if(rset.next()) {
					result = rset.getInt("count(*)");
				} 
			}catch(Exception e) {e.printStackTrace();
			}finally {
				if(rset!=null){try{rset.close();}catch(Exception e){e.printStackTrace();}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
				if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
			}
			
			return result;
		}	
		
		public ArrayList <LDto> pagingListPage(int pstartno)
		{
			ArrayList<LDto> list = new ArrayList<LDto> ();
			
			DBManager db = new DBManager();
			
			Connection conn = null;
			PreparedStatement pstmt = null;
			ResultSet rset = null;		
			
			String sql = "select*from login order by lno desc limit ?,10;";
			
			try {
				conn = db.getConnection();
				pstmt = conn.prepareStatement(sql);
				pstmt.setInt(1, pstartno);
				rset = pstmt.executeQuery();				

				 while(rset.next()) 
				 {list.add(new LDto(rset.getInt("lno"),rset.getString("lid"),rset.getString("lpw"),rset.getString("lemail"),
				 rset.getInt("lage"),rset.getString("lsex"),rset.getString("luser")));}
				
			}catch(Exception e) {e.printStackTrace();
			}finally {
				if(rset!=null){try{rset.close();}catch(Exception e){e.printStackTrace();}}
				if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
				if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
			}
			
			return list;
		}
	
}
