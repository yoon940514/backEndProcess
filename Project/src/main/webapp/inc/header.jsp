<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>   
<!DOCTYPE html>    
<html lang="ko">
   <head> 
      <meta charset="UTF-8"/>   
      <title>UNIVEST</title>
     <link rel="shortcut icon" href="images/icon.ico" type="image/x-icon">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

<style>
	.glyphicon {font-size: 60px;}
	.modal__background{
  position: fixed;
  top:0; left: 0; bottom: 0; right: 0;
  background: rgba(0, 0, 0, 0.4);
}
</style>    
    </head>
   <body>  

<nav class="navbar navbar-default">

  <div class="container-fluid" style="background-color:	ivory;
    padding-left: 5px;
    padding-right: 5px;">
      <a class="nav navbar-nav navbar-nav-left" href="home.jsp" 
      style="
    margin-top: 20px;
    margin-left: 20px;
    margin-bottom: 20px;
    margin-right: 20px;"><img src="images/icon.ico" style="width:100px; height:100px;"/></a>
	<ul class="nav navbar-nav" style= "margin-top: 0px;">
   
    <li><a href="${pageContext.request.contextPath}/GoToJasonController"><img src="images/chart.png" style="
    height: 100px;
    width: 110px;
    margin-right: 15px;     margin-top: 3px;
    "></a>
    </li>
    
	<li><a href="${pageContext.request.contextPath}/list.board?pstartno=0"><img src="images/board.png" style="
    height: 100px;
    width: 120px;
    padding-left: 0px;
    border-left-width: 0px;
    margin-left: 0px;
    margin-top: 5px;
	"></a></li>
    </ul>
    
     <ul class="nav navbar-nav navbar-right" style="margin-top: 20px; margin-right: 15px;">
  	  <%
		  String I = (String)session.getAttribute("lid");
	      String P = (String)session.getAttribute("lpw");
	      String K = (String)session.getAttribute("nickname");
	      if (I != null && P != null){ 
	      	  out.println("<li><a href='" + request.getContextPath() + "/mypage.mypage' style='font-size: 25px; top: 25px;'>마이페이지</a></li>"); 
	          out.println("<li><a href='" + request.getContextPath() + "/logout.mypage' style='font-size: 25px; top: 25px;'>로그아웃하기</a></li>");
	          }
	      
	      else if (K != null) { 
	    	  out.println("<li><a href='" + request.getContextPath() + "/mypageKakao.mypage' style='font-size: 25px; top: 25px;'>카카오 마이페이지</a></li>");
	    	  out.println("<li><a href='" + request.getContextPath() + "/logout.mypage' style='font-size: 25px; top: 25px;'>로그아웃하기</a></li>"); }
	      else { out.println("<li><a href='" + request.getContextPath() + "/loginform.mypage' style='font-size: 25px; top: 25px;'>로그인하기</a></li>"); }			
       %>  
<!-- <li><img src="" style="margin-top: 10px; margin-left: 10px;"><img src="images/DayAndNight.png" style="width:100px; height:100px; color:#FFAF0A;"></li> -->
	</ul>
<!--	
	<form class="form-inline">

   <div class="form-group">
    <label for="Search"></label>
    <input class="form-control" id="Search" type="text" placeholder="원하는 종목을 입력하시오." style="
    width: 426px;
    height: 54px;
    margin-left: 25px;
    margin-top: 40px;
	">
      <button class="btn btn-default" type="submit" style="
    margin-top: 40px;">
        <i class="glyphicon glyphicon-search" style="font-size: 40px;"></i>
      </button>
  </div>

  </form>
-->
</div>
   
 
</nav>

	

   