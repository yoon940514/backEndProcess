<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<%@page import="java.sql.*"%>

<script>
   $(function(){
      var result =  '${result}'; console.log(result);
      if(   result == '실패'  ){  alert('관리자에게 문의바랍니다.');     }
      else if(result.length != 0 ){  alert( '${result}');  }
   });
</script>
<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>MULTIBOARD 상세보기</h3> 					
	<div class="panel" >
	  <div  class="panel-body"> 
	  		<span class="glyphicon glyphicon-plus">  조회수</span>
	  		<p>${dto.bhit}</p>
	</div>	
	</div>	
	<div class="panel"  >
	  <div  class="panel-body">
	  		<span class="glyphicon glyphicon-plus">  이름</span> 
			<p>${dto.bname}</p>
		</div>
	</div>				
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">  제목</span> 
	     <p>${dto.btitle}</p>
	  </div>	
	</div>
	<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">  내용</span>
	  	<p>${dto.bcontent}</p>
	  </div> 
	</div>
	<div class="panel"  >
	  <div class="panel-body">
		<span class="glyphicon glyphicon-plus">  사진</span>
		<img src="/upload/${dto.bfile}"/>
	  </div>
	</div>		
	<div class="text-right"    >
		 <a href="${pageContext.request.contextPath}/board/edit?bno=${dto.bno}"  class="btn btn-danger" >수정</a> 
		 <a href="${pageContext.request.contextPath}/board/delete?bno=${dto.bno}"  class="btn btn-danger" >삭제</a>    
		 <a href="${pageContext.request.contextPath}/board/list"  class="btn btn-info" >목록보기</a> 
	</div>						 
</div>	
</body>
</html>