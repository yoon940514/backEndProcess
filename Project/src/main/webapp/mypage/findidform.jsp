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
<h3 class="panel-heading">아이디 찾기</h3>
	<form action="idfind.mypage" method="post" id="idfind">
<fieldset>
	<legend>이메일을 입력하세요.</legend>
		
		<div class="form-group">
			<label for="lemail">이메일주소</label>
			<input type="email" name="lemail" id="lemail" class="form-control" placeholder = "이메일을 적어주세요" />
		</div>
		
		<div class="form-group">
			<label for="idfind"></label>
			<input type="submit" value="아이디찾기" class="btn btn-danger" title="아이디를 찾습니다."/>	
		</div>
</fieldset>
	</form>
</div>
</div>
</div>
</div>
<%@include file="../inc/footer.jsp" %>
