<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>   
<%@include file="../inc/header.jsp" %>
<div class="container-fluid">
	<div class="form-group row">  
<div class="col-sm-2">
	<div class="form-group">
	<a href="${pageContext.request.contextPath}/joinselect.mypage" style="display:block; width:250px; height:50px; font-size: 20px;
	margin-top: 20px; margin-bottom: 20px;" class="btn btn-success">회원가입</a>
	</div>
	<div class="form-group">
	<a href="${pageContext.request.contextPath}/findselect.mypage" style="display:block; width:250px; height:50px; font-size: 20px;
	margin-top: 50px; margin-bottom: 20px;" class="btn btn-success">아이디/비밀번호 찾기</a> 
	</div>
</div>
<div class="col-sm-10">
<div class="container panel panel-info">
<div class="row panel panel-info">
<h3 class="panel-heading">아이디/비밀번호 찾기 선택</h3>
<div class="panel-body">
<a href="findidform.mypage"  class="btn btn-danger">아이디 찾기</a>
<a href="findpwform.mypage"  class="btn btn-danger">비밀번호 찾기</a>
</div>
</div>
</div>
</div>
</div>
</div>
<%@include file="../inc/footer.jsp" %>