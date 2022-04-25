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
<h3 class="panel-heading">회원가입</h3>
	<form action="join.mypage" method="post" id="join">
		<fieldset>
		<legend>회원가입</legend>
		
		<div class="form-group">
			<label for="lid">아이디</label>
			<input type="text" name="lid" id="lid" class="form-control" placeholder = "아이디를 적어주세요"/>	
			<input type="button" value="아이디중복확인" id="lidEqual" class="btn btn-success" />	
		</div>
		
		<input type="hidden" value="y" id="finalcheck" class="btn btn-success"/>	
		<input type="hidden" value="y" id="finalcheck2" class="btn btn-success"/>	
		
		<div class="r1 well">
		<p></p>
		</div> 
		
		<div class="form-group">
			<label for="lpw">비밀번호 입력</label>
			<input type="password" name="lpw" id="lpw" class="form-control" placeholder = "비밀번호를 적어주세요" />
			
			<label for="lpw2">비밀번호 확인</label>
			<input type="password" name="lpw2" id="lpw2" class="form-control" placeholder = "비밀번호를 다시 적어주세요"/>
			<input type="button" value="비밀번호확인" id="lpwconfirm" class="btn btn-success"  />			
		</div>	
		
		<div class="r2 well">
		<p></p>
		</div> 
<script>

$(function(){
	$("#lidEqual").on("click", function() {
		$.ajax({
			url:"${pageContext.request.contextPath}/IdEqual.mypage",
			type:"get", dataType:"text",
			data:{"lid":$('#lid').val()}
			, success:function(data){
			
				var result = "<p>사용가능한 아이디입니다.</p>"
				if(data==0) 
				{
					$("#finalcheck").val("n");
					result = "<p>중복된 아이디입니다.</p>"
				} else {
					$("#finalcheck").val("y");
					result = "<p>사용가능한 아이디입니다.</p>"
				}
				
				$(".r1 p").html(result);	// html 리셋
			}, error:function(xhr, textStatus, errorThrown)
			{
				$(".r1 p").html(textStatus + "(HTTP-)" + xhr.status+"/" + errorThrown);
			}
			});
		
			
		});
	
	$("#lpwconfirm").on("click", function() {
		$.ajax({
			url:"",
			type:"get", dataType:"text"
			
			,success:function(data){
			
				var result = "<p>비밀번호를 올바르게 입력했습니다.</p>"
				if($('#lpw').val()!=$('#lpw2').val()) 
				{
					$("#finalcheck2").val("n");
					result = "<p>비밀번호가 서로 다릅니다.</p>"
				} else {
					$("#finalcheck2").val("y");
					result = "<p>비밀번호를 올바르게 입력했습니다.</p>"
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
			<input type="email" name="lemail" id="lemail" class="form-control" placeholder = "이메일을 적어주세요" />	
		</div>
		
		<div class="form-group">
			<label for="lage">나이 (숫자만 입력하시오)</label>
			<input type="number" name="lage" id="lage" class="form-control" placeholder = "나이를 적어주세요" />	
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
		<% String i = (String) request.getAttribute("luser"); %>
		<input type="hidden" name="luseraa" value="<%=i%>" class="form-control"/>	
		</div>
		
		<div class="form-group">
			<label for="join"></label>
			<input type="submit" value="회원가입완료" id="" class="btn btn-danger" title="회원가입을 합니다."/>	
		</div>
	</fieldset>
	</form>
	<script>
	$(function(){
		$("#join").on("submit",function(){	// 폼을 전송할때
		
			if($("#finalcheck").val() == "n") 
			{
				alert("아이디가 중복되거나 비밀번호를 올바르게 입력하지 않았습니다. 다시 확인해주세요.");
				return false;
			}
		
			if($("#finalcheck2").val() == "n") 
			{
				alert("아이디가 중복되거나 비밀번호를 올바르게 입력하지 않았습니다. 다시 확인해주세요.");
				return false;
			}
	
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
		
		if($("#ladress").val() == "") {
			alert("주소창이 빈칸입니다.");
			$("#ladress").focus(); 		
			return false;	
		}
		
		if($("#ladress2").val() == "") {
			alert("상세 주소창이 빈칸입니다.");
			$("#ladress2").focus(); 		
			return false;	
		}
		
		if($("#lpostcode").val() == "") {
			alert("우편번호가 빈칸입니다.");
			$("#lpostcode").focus(); 		
			return false;	
		}lpostcode
	});
	});
	</script>
</div>
</div>    
</div>
</div>
<%@include file="../inc/footer.jsp" %>   