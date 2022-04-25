<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../inc/header.jsp" %>

<table class="table table-stripe">		

<%if (session.getAttribute("nickname") != null) { %>
		<caption>카카오계정으로 로그인하셨습니다.<br>
		 ${nickname}님 안녕하세요. UNIVEST에 오신것을 진심으로 환영합니다.<br>
		카카오로그인 사용자는 마이페이지에서 자신의 정보만 볼수 있습니다.
		<br> ${nickname}님의 카카오 개인정보는 다음과 같습니다.
		</caption>
		
		<thead>		
		<tr> 
			<th scope="col">${nickname}님의 닉네임</th>
			<th scope="col">프로필사진</th>
		
		</tr>
	</thead>
	
<tbody>  
	<tr>
		<td>${nickname}</td>
	</tr>	
	<tr>
		<td><img src="${profile_image}"/></td>
	</tr>
</tbody>
<%
	}
%>
</table>

<%@include file="../inc/footer.jsp" %>  