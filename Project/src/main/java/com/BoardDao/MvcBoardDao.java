package com.BoardDao;

import java.net.InetAddress;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.BoardDto.*;
import com.DBManager.DBManager;


public class MvcBoardDao {
	public ArrayList<MvcBoardDto> ReadAll(){
		ArrayList<MvcBoardDto> list = new ArrayList<MvcBoardDto>();
		
		//select *from mvcboard3 order by uno desc;
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String sql = "select *from mvcboard6 order by bno desc;";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			rset = pstmt.executeQuery();
			while(rset.next()) {
				list.add(new MvcBoardDto(
						rset.getInt("bno"),	rset.getString("bname"), rset.getString("btitle"),
						rset.getString("bpass"), rset.getString("bcontent"),	rset.getString("bdate"),
						rset.getInt("bhit"), rset.getString("bfile"), rset.getString("bip")));
			}
			System.out.println(list);
		}catch(Exception e) { e.printStackTrace();
		}finally {
			if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return list;
	}
	
	
	//ㅁ select * from mvcboard3 where bno = ?
	//ㅁ update mvcboard3 set bhit=bhit+1 where bno=?
	public MvcBoardDto listOne(MvcBoardDto dto){
		MvcBoardDto result = null;
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; ResultSet rset = null;
		String sql1 = "update mvcboard6 set bhit=bhit+1 where bno=?";
		String sql2 = "select * from mvcboard6 where bno = ?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql1);
			pstmt.setInt(1, dto.getBno());
			pstmt.executeUpdate();
			pstmt.close();
			
			pstmt = conn.prepareStatement(sql2);
			pstmt.setInt(1, dto.getBno());
			rset = pstmt.executeQuery();
			if(rset.next()) {
				result=new MvcBoardDto(rset.getInt("bno"),	rset.getString("bname"), rset.getString("btitle"),
						rset.getString("bpass"), rset.getString("bcontent"),	rset.getString("bdate"),
						rset.getInt("bhit"), rset.getString("bfile"),  rset.getString("bip"));
			}
			System.out.println(result);
		}catch(Exception e) { e.printStackTrace();
		}finally {
			if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}

	//ㅁ "insert into mvcboard3 (bname, bpass, btitle, bcontent, bip) values (?, ?, ?, ?, ?)";
	public int insert(MvcBoardDto dto){
		int result = -1;
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; // ResultSet rset = null;
		String sql = "insert into mvcboard6 (bname, bpass, btitle, bcontent, bfile, bip) values (?, ?, ?, ?, ?, ?)";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  dto.getBname());
			pstmt.setString(2,  dto.getBpass());
			pstmt.setString(3,  dto.getBtitle());
			pstmt.setString(4,  dto.getBcontent());
			pstmt.setString(5,  dto.getBfile());
			pstmt.setString(6,  InetAddress.getLocalHost().getHostAddress());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) { e.printStackTrace();
		}finally {
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	
	//ㅁ update mvcboard3 set btitle=?, bcontent=? where bno=? and bpass=?
	public int update(MvcBoardDto dto){
		int result = -1;
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; // ResultSet rset = null;
		String sql = "update mvcboard6 set btitle=?, bcontent=?, bfile=? where bno=? and bpass=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1,  dto.getBtitle());
			pstmt.setString(2,  dto.getBcontent());
			pstmt.setString(3,  dto.getBfile());
			pstmt.setInt(4,  dto.getBno());
			pstmt.setString(5,  dto.getBpass());
			result = pstmt.executeUpdate();
		}catch(Exception e) { e.printStackTrace();
		}finally {
		//	if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
		}
		return result;
	}
	
	//ㅁ delete from mvcboard3 where bno=? and bpass=?
	public int delete(MvcBoardDto dto){
		int result = -1;
		DBManager db = new DBManager();
		Connection conn = null; PreparedStatement pstmt = null; // ResultSet rset = null;
		String sql = "delete from mvcboard6 where bno=? and bpass=?";
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1,  dto.getBno());
			pstmt.setString(2,  dto.getBpass());
			result = pstmt.executeUpdate();
			
		}catch(Exception e) { e.printStackTrace();
		}finally {
		//	if(rset!=null) {try { rset.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(pstmt!=null) {try { pstmt.close(); } catch (SQLException e) { e.printStackTrace(); }}
			if(conn!=null) {try { conn.close(); } catch (SQLException e) { e.printStackTrace(); }}
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
		
		String sql = "select count(*) from mvcboard6";
		
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
	
	public ArrayList <MvcBoardDto> pagingListPage(int pstartno)
	{
		ArrayList<MvcBoardDto> list = new ArrayList<MvcBoardDto> ();
		
		DBManager db = new DBManager();
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rset = null;		
		
		String sql = "select*from mvcboard6 order by bno desc limit ?,10;";
		
		try {
			conn = db.getConnection();
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, pstartno);
			rset = pstmt.executeQuery();				

			 while(rset.next()) 
			 {list.add(new MvcBoardDto(rset.getInt("bno"),	rset.getString("bname"), rset.getString("btitle"),
						rset.getString("bpass"), rset.getString("bcontent"),	rset.getString("bdate"),
						rset.getInt("bhit"), rset.getString("bfile"),  rset.getString("bip")));}
			
		}catch(Exception e) {e.printStackTrace();
		}finally {
			if(rset!=null){try{rset.close();}catch(Exception e){e.printStackTrace();}}
			if(pstmt!=null){try{pstmt.close();}catch(Exception e){e.printStackTrace();}}
			if(conn!=null){try{conn.close();}catch(Exception e){e.printStackTrace();}}
		}
		
		return list;
	}
}
