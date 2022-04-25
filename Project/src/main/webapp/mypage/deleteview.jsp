<%@page import="com.LoginDto.LDto"%>
<%@page import="com.LoginDao.LDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>   

<%@include file="../inc/header.jsp" %>
<%
	LDao dao = new LDao();
		
	LDto dto = (LDto) session.getAttribute("Mypage");
	
	if (dao.myPage(dto).getLuser().equals("admin"))
	{
%> 
<div class="container-fluid">
	<div class="form-group row">   
	<div class="col-sm-2">
	<div class="form-group">
	<a href="${pageContext.request.contextPath}/updateform.mypage" style="display:block; width:250px; height:50px; font-size: 20px;
	margin-top: 50px; margin-bottom: 20px;" class="btn btn-success" >회원정보 수정</a>   
	</div>
	<div class="form-group">
	<a href="${pageContext.request.contextPath}/selectadministerform.mypage?pstartno=0" style="display:block; width:250px; height:50px;
	margin-top: 50px; margin-bottom: 20px; font-size: 20px;" class="btn btn-success">관리자전용 페이지</a>  
	</div>
	<div class="form-group">
	<a href="${pageContext.request.contextPath}/deleteview.mypage" style="display:block; width:250px; height:50px; margin-bottom: 20px;
	margin-top: 50px; font-size: 20px;" class="btn btn-success">회원탈퇴</a> 
	</div>
</div>
<%
	} else
	{
%> 
<div class="container-fluid">
	<div class="form-group row">   
	<div class="col-sm-2">
	<div class="form-group">
	<a href="${pageContext.request.contextPath}/updateform.mypage" style="display:block; width:250px; height:50px; font-size: 20px;
	margin-top: 50px; margin-bottom: 20px;" class="btn btn-success">회원정보 수정</a>   
	</div>
	<div class="form-group">
	<a href="${pageContext.request.contextPath}/quit.mypage" style="display:block; width:250px; height:50px; margin-bottom: 20px;
	margin-top: 50px; font-size: 20px;" class="btn btn-success">회원탈퇴</a> 
	</div>
</div>
<%
	}
%>

<div class="col-sm-10">
<div class="container panel panel-info">
	
	
<h3 class="panel-heading">회원 탈퇴</h3>
	<form action="delete.mypage" method="post" id="delete">
		<fieldset>
		<legend>회원탈퇴를 하면 다시 복구할수 없습니다!</legend>
		
				<div class="form-group">
					<label for="id">아이디</label>
					<input type="text" name="lid" id="id" class="form-control" placeholder = "탈퇴할 아이디를 적어주세요" />	
				</div>
					 	
				<div class="form-group">
					<label for="pw">비밀번호</label>
					<input type="password" name="lpw" id="pw" class="form-control" placeholder = "탈퇴할 비밀번호를 적어주세요" />	
				</div>
				
				<div class="form-group">
					<button type="button"  data-toggle="modal" data-target="#myModal" class="btn btn-danger">탈퇴하기</button>	
				</div>
				
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal__background">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" type="button" data-dismiss="modal" aria-label="Close"></button>
						
						<h3 class="modal-title" id="exampleModalLabel">탈퇴 최종확인</h3>
					</div>
					<div class="modal-body">탈퇴를 완료하면 데이터를 복구할 수 없습니다. 그래도 탈퇴하시겠습니까?</div>
					<div class="modal-footer">
						<input type="submit" class=btn value="예">
						<button class="btn" type="button" data-dismiss="modal">아니오</button>
					</div>
				</div>
			</div>
		</div>
				</div>
	</fieldset>
	</form>
	
	
	
	
	
	
</div>
</div>
</div>
</div>
</div>
</div>

<%@include file="../inc/footer.jsp" %>