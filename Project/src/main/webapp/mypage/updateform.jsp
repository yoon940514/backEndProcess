<%@page import="com.LoginDao.LDao"%>
<%@page import="com.LoginDto.LDto"%>
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
<div class="container panel panel-info">
<h3 class="panel-heading">회원정보 수정</h3>
	<form action="update.mypage" method="post" id="update">
		<fieldset>
		<legend>아이디는 변경할 수 없습니다!</legend>
	
		<div class="form-group">
			<label for="lid"></label>
			<input type="hidden" value="<%=session.getAttribute("lid")%>" name="lid" id="lid" class="btn btn-danger" placeholder = "아이디를 적어주세요"/>	
		</div>
	
		<div class="form-group">
			<label for="lpw">변경할 비밀번호 입력</label>
			<input type="password" name="lpw" id="lpw" class="form-control"  placeholder = "비밀번호를 적어주세요"/>	
		</div>	
		
		<div class="form-group">
			<label for="lpw2">비밀번호 확인</label>
			<input type="password" name="lpw2" id="lpw2" class="form-control" placeholder = "비밀번호를 다시 적어주세요"/>
			<input type="button" value="비밀번호확인" id="lpwconfirm" class="btn btn-success"  />		
		</div>
		
		<div class="r2 well">
		<p></p>
		</div> 
		
		<input type="hidden" value="y" id="finalcheck" class="btn btn-success"/>	
<script>
$(function(){
	$("#lpwconfirm").on("click", function() {
		$("#finalcheck").val("y");
		$.ajax({
			url:"",
			type:"get", dataType:"text"
			
			,success:function(data){
			
				var result = "<p>비밀번호를 올바르게 입력했습니다.</p>"
				if($('#lpw').val()!=$('#lpw2').val()) 
				{
					$("#finalcheck").val("n2");
					result = "<p>비밀번호가 서로 다릅니다.</p>"
				}	
				
				if($("#lpw").val() == "") {
					result = "<p>비밀번호 입력창이 빈칸입니다.</p>"
					$("#lpw").focus(); 		
				}
				
				if($("#lpw2").val() == "") {
					result = "<p>비밀번호 확인창이 빈칸입니다.</p>"
					$("#lpw2").focus(); 		
				}
				
				$(".r2 p").html(result);	// html 리셋
			}, error:function(xhr, textStatus, errorThrown)
			{
				$(".r2 p").html(textStatus + "(HTTP-)" + xhr.status+"/" + errorThrown);
			}
			});
		});
	});
</script>

		<div class="form-group">
			<label for="lemail">이메일</label>
			<input type="email" name="lemail" id="lemail" class="form-control" value="${Mypage.lemail}" placeholder = "이메일을 적어주세요"/>	
		</div>
		
		<div class="form-group">
			<label for="lage">나이 (숫자만 입력하시오)</label>
			<input type="number" name="lage" id="lage" class="form-control" value="${Mypage.lage}" placeholder = "나이를 적어주세요"/>	
		</div>
		
		<div class="form-group">
		<label for="lsex">성별</label> 
			<select id="lsex" name="lsex" class="form-control"  >
			<option value="" selected disabled>선택해주세요.</option>
				<option value = "남자">남자</option>
				<option value = "여자">여자</option>
			</select>
		</div>
		
		<div class="form-group">
			<label for="join"></label>
			<input type="submit" value="수정완료" class="btn btn-danger" title="회원가입을 합니다."/>	
		</div>
	</fieldset>
	</form>
	<script>
	$(function(){
	$("#update").on("submit",function(){	// 폼을 전송할때
		if($("#finalcheck").val()=="n2") {alert("아이디가 중복되거나 비밀번호를 올바르게 입력하지 않았습니다. 다시 확인해주세요.");
		return false;}
	
		if($("#lid").val() == "") {
			alert("아이디 입력창이 빈칸입니다.");
			$("#lid").focus(); 		
			return false;
		}	
		
		if($("#lpw").val() == "") {
			alert("비밀번호 입력창이 빈칸입니다.");
			$("#lpw").focus(); 		
			return false;	
		}
		
		if($("#lpw2").val() == "") {
			alert("비밀번호 확인창이 빈칸입니다.");
			$("#lpw2").focus(); 		
			return false;	
		}
		
		if($("#lemail").val() == "") {
			alert("이메일 입력창이 빈칸입니다.");
			$("#lemail").focus(); 		
			return false;	
		}	
		
		if($("#lage").val() == "") {
			alert("나이 입력창이 빈칸입니다.");
			$("#lage").focus(); 		
			return false;	
		}
		
		if($("#lsex").val() == "") {
			alert("성별 입력창이 빈칸입니다.");
			$("#lsex").focus(); 		
			return false;	
		}
	});
	});
	</script>
</div>    
</div>
</div>
</div>
</div>
</div>
<%@include file="../inc/footer.jsp" %>