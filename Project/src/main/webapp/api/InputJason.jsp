<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>    
<html lang="ko">
   <head> 
      <meta charset="UTF-8"/>   
      <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
   <body> 
<div class="container panel panel-info">
		<h3 class="panel-heading">재무제표 API 보기</h3>
			<form action="${pageContext.request.contextPath}/Gongsi.Json" method="post">
			<fieldset>
				<legend>재무재표 API</legend>
				
				<div class="form-group">
					<label for="corp_code">기업고유번호 (예시로 삼성번호: 00126380을 넣어주세요)</label>
					<input type="text" name="corp_code" id="corp_code" class="form-control" placeholder = "기업고유번호 입력" value =""/>	
				</div>
				
				<div class="form-group">
					<label for="bsns_year">사업연도 (예시로 2018을 넣어주세요)</label>
					<input type="text" name="bsns_year" id="bsns_year" class="form-control" placeholder = "사업연도를 적어주세요"/>	
				</div>
				
				<div class="form-group">
					<label for="reprt_code">보고서코드 (1분기보고서 : 11013
													반기보고서 : 11012
													3분기보고서 : 11014
													사업보고서 : 11011)</label>
					<input type="text" name="reprt_code" id="reprt_code" class="form-control" placeholder = "보고서코드를 적어주세요"/>	
				</div>
				
				
				<div class="form-group">
					<label for="a"></label>
					<input type="submit" value="api 조회하기"  id="a" class="btn btn-danger" title="api 조회를 합니다."/>	
				</div>
			</fieldset>
			</form> 
</div>   

   </body>
</html>