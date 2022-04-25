<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>   
<%@include file="../inc/header.jsp" %>
<div class="container-fluid">
	<div class="form-group row">   
		<div class="col-sm-2">
				<div class="form-group">
				<a href="${pageContext.request.contextPath}/joinselect.mypage" style="display:block;  font-size: 20px;
				margin-top: 20px; margin-bottom: 20px;" class="btn btn-success">회원가입</a>
				</div>
				<div class="form-group">
				<a href="${pageContext.request.contextPath}/findselect.mypage" style="display:block;  font-size: 20px;
				margin-top: 50px; margin-bottom: 20px;" class="btn btn-success">아이디/비밀번호 찾기</a> 
				</div>
			</div>
			
		<%
		String lid="";
		String remember = ""; boolean ison=false;
		String cookie = request.getHeader("Cookie");
		if(cookie != null){
			Cookie [] cookies = request.getCookies();
			for(int i=0; i<cookies.length; i++){
				if(cookies[i].getName().equals("lid") )		{ lid = cookies[i].getValue(); }
				if(cookies[i].getName().equals("remember") ){ remember = cookies[i].getValue(); ison=true; }		
			}		
		}	
		%>
		
		<div class="col-sm-10">
		<div class="container panel panel-info">
		<h3 class="panel-heading">로그인하기</h3>
			<form action="login.mypage" method="post" id="login">
			<fieldset>
				<legend>아이디와 비밀번호를 입력하세요.</legend>
				
				<div class="form-group">
					<label for="lid">아이디</label>
					<input type="text" name="lid" id="lid" class="form-control" placeholder = "아이디를 적어주세요" <%if(ison){ %> value = "<%=lid%>"<%}%>>	
				</div>
				
				<div class="form-group">
					<label for="lpw">비밀번호</label>
					<input type="password" name="lpw" id="lpw" class="form-control" placeholder = "비밀번호를 적어주세요"/>	
				</div>
				
				<div class="form-group">		
				<input type="checkbox" name="remember"  id = "remember" <%if(ison){ %>  checked<%  } %>/>
				<label for="remember"> 아이디저장 </label>
				</div>
				
				<div class="form-group">
					<label for="login"></label>
					<input type="submit" value="로그인하기" name="login" id="login" class="btn btn-danger" title="로그인을 합니다."/>
					<a href="https://kauth.kakao.com/oauth/authorize?client_id=6ffd179c0c8458bdbe91deb86d4707be&redirect_uri=http://localhost:8080/Project/KakaoLogin&response_type=code">
					<img src="images/kakao.png" style="width:130px; height:32px;"/></a>	
				</div>
			</fieldset>
			</form> 
		</div>
		</div>
	</div>
</div>
<%@include file="../inc/footer.jsp" %>