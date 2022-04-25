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
	margin-top: 50px; margin-bottom: 20px;" class="btn btn-success">회원정보 수정</a>   
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
	<a href="${pageContext.request.contextPath}/deleteview.mypage" style="display:block; width:250px; height:50px; margin-bottom: 20px;
	margin-top: 50px; font-size: 20px;" class="btn btn-success">회원탈퇴</a> 
	</div>
</div>
<%
	}
%>

<div class="col-sm-10">
<table class="table table-stripe">
<% 
	LDto dto2 = (LDto) session.getAttribute("perDetail");

	if (dto2.getLuser().equals("admin"))
	{
%>
	
	<caption>관리자 ${perDetail.lid}님의 개인정보입니다.</caption>
<%
	} else
	{
%>	
	
	<caption>사용자 <%out.println(dto2.getLid());%>님의 개인정보입니다.</caption>
<%
	}
%>		

	<thead>		
		<tr> 
			<th scope="col">회원번호</th>
			<th scope="col">아이디</th>
			<th scope="col">이메일</th>
			<th scope="col">나이</th>
			<th scope="col">성별</th>
		</tr>
	</thead>
	
<tbody>  

	<tr>
		<td><%out.println(dto2.getLno());%></td><td><%out.println(dto2.getLid());%></td><td><%out.println(dto2.getLemail());%></td>
		<td><%out.println(dto2.getLage());%></td><td><%out.println(dto2.getLsex());%></td>
	</tr>	

</tbody>
</table>


<form action="ban.mypage" method="post" id="selectadministerform2">
	<fieldset>

<%

	if (dto2.getLuser().equals("user"))
	{
%>		
	
		
		<div class="form-group col-sm-10"></div>
		<div class="form-group col-sm-2">
			<label for="lid2"></label>
			<input type="hidden" name="lid2" value="${perDetail.lid}" id="lid2" class="form-control"/>	

			<div class="form-group">
				<button type="button"  data-toggle="modal" data-target="#myModal" class="btn btn-danger">해당 사용자 강퇴하기</button>	
			</div>
		</div>
<%
	}
%>
				<div class="modal fade" id="myModal" tabindex="-1" role="dialog" aria-labelledby="exampleModalLabel" aria-hidden="true">
		<div class="modal__background">
			<div class="modal-dialog" role="document">
				<div class="modal-content">
					<div class="modal-header">
						<button class="close" type="button" data-dismiss="modal" aria-label="Close"></button>
						
						<h3 class="modal-title" id="exampleModalLabel">강퇴 최종확인</h3>
					</div>
					<div class="modal-body">강퇴를 완료하면 데이터를 복구할 수 없습니다. 그래도 강퇴하시겠습니까?</div>
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

<%@include file="../inc/footer.jsp" %>