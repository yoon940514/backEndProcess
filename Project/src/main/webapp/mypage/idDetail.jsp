<%@page import="java.util.ArrayList"%>
<%@page import="com.LoginDto.LDto"%>
<%@page import="com.LoginDao.LDao"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

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
	<a href="${pageContext.request.contextPath}/quit.mypage" style="display:block; width:250px; height:50px; margin-bottom: 20px;
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

<%
	String luser = (String) session.getAttribute("luserDetail");

	if (luser.equals("admin"))
	{
		luser = "관리자";
	} else 
	{
		luser = "사용자";
	}
%>
<div class="col-sm-10">
<table class="table table-stripe">

<%
	String s = (String)session.getAttribute("Sort");
	String l = (String)session.getAttribute("lresult");
%>

	<caption> <%=luser%> 상세보기 리스트입니다. <br> 정렬방식: <%out.println(s); %> <br> (DESC는 내림차순, ASC는 오름차순을 의미합니다.) <br> 정렬선택: <%out.println(l);%>
	<br>(lno는 기본정렬, lsex는 성별순, lid는 아이디순, lemail는 이메일순, lage는 나이순을 의미합니다.)
	</caption>
	<thead>		
		<tr> 
			<th scope="col">권한</th>
			<th scope="col">아이디</th>
			<th scope="col">이메일</th>
			<th scope="col">나이</th>
			<th scope="col">성별</th>
		</tr>
	</thead>
	
<tbody>  
<c:forEach var="dto2" items="${adminlist}" varStatus="status">
	<tr>
		<td>${dto2.luser}</td><td>${dto2.lid}</td><td>${dto2.lemail}</td>
		<td>${dto2.lage}</td><td>${dto2.lsex}</td>
	</tr>	
</c:forEach>
</tbody>
</table>
</div>
</div>
</div>
</div>
</div>
<%@include file="../inc/footer.jsp" %>  