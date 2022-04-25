package com.DBManager;

import java.sql.Connection;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.sql.DataSource;

public class DBManager {
	public static Connection conn;
	public DBManager() {super();}
	
	public Connection getConnection() {
		try {
		//1.server.xml
		Context initContext = new InitialContext();
		//2.환경설정
		Context envContext = (Context)initContext.lookup("java:/comp/env");
		//3. datasource 얻어오기
		DataSource db = (DataSource)envContext.lookup("jdbc/yoon940514");
		//4. connection
		conn = db.getConnection();
		if(conn != null) {System.out.println("java - DBManager 연동성공");}
		}catch(Exception e) {e.printStackTrace();}
		return conn;
	}
}
