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
	} else if (dao.myPage(dto).getLuser().equals("user"))
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
	if (dao.myPage(dto).getLuser().equals("admin"))
	{
%>
	<caption>관리자 <%out.println(dto.getLid());%>님 안녕하세요. UNIVEST에 오신것을 진심으로 환영합니다.
	<br> 이곳은 회원관리 페이지입니다. 개인정보 뿐만 아니라 가입한 모든 사람의 정보를 조회할수 있습니다.
	<br> <%out.println(dto.getLid());%>님의 개인정보는 다음과 같습니다.
	</caption>
	
	<thead>		
		<tr> 
			<th scope="col"><%out.println(dto.getLid());%>님의 권한</th>
			<th scope="col">아이디</th>
			<th scope="col">이메일주소</th>
			<th scope="col">나이</th>
			<th scope="col">성별</th>
		</tr>
	</thead>
	
<tbody>  
	<tr>
		<td><%out.println(dto.getLuser());%></td><td><%out.println(dto.getLid());%></td><td><%out.println(dto.getLemail());%></td>
		<td><%out.println(dto.getLage());%></td><td><%out.println(dto.getLsex());%></td>
	</tr>
<%
	} else if (dao.myPage(dto).getLuser().equals("user"))
	{
%>
	<caption>사용자 <%out.println(dto.getLid());%>님 안녕하세요. UNIVEST에 오신것을 진심으로 환영합니다.<br> 이곳은 개인정보를 관리하는 곳입니다. 
	내정보 보기, 내정보 수정하기, 탈퇴하기를 진행할수 있습니다.
	<br> <%out.println(dto.getLid());%>님의 개인정보는 다음과 같습니다.
	</caption>
	
	<thead>		
		<tr> 
			<th scope="col"><%out.println(dto.getLid());%>님의 권한</th>
			<th scope="col">아이디</th>
			<th scope="col">이메일주소</th>
			<th scope="col">나이</th>
			<th scope="col">성별</th>
		</tr>
	</thead>
	
<tbody>  
	<tr>
		<td><%out.println(dto.getLuser());%></td><td><%out.println(dto.getLid());%></td><td><%out.println(dto.getLemail());%></td>
		<td><%out.println(dto.getLage());%></td><td><%out.println(dto.getLsex());%></td>
	</tr>
	
<%
	}
%>
</tbody>
</table>
</div>
</div>
</div>
</div>
</div>
<%@include file="../inc/footer.jsp" %>  