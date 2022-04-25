<%@page import="com.DBManager.DBManager"%>
<%@page import="java.sql.Connection"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../inc/header.jsp" %>

<%
	DBManager db = new DBManager();
	Connection conn = db.getConnection();
	
	if (conn != null)
	{
		out.println("db연동성공");
	}
%>
  
<%@include file="../inc/footer.jsp" %>	
   