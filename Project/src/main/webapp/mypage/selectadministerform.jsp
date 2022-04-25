<%@page import="java.util.ArrayList"%>
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
<caption>관리자 <%=dto.getLid()%>님 반갑습니다. 이곳에서는 전체 회원정보를 조회할수 있습니다. 또한 아이디검색창에서 사용자를 강퇴할수도 있습니다.</caption>
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
  <c:forEach var="dto2" items="${paging.list10}" varStatus="status">
      <tr>   
         <td>${dto2.luser}</td>
         <td>${dto2.lid}</td>
         <td>${dto2.lemail}</td>
         <td>${dto2.lage}</td>
         <td>${dto2.lsex}</td>
      </tr>
   </c:forEach>
</tbody>
	<tfoot>
		<tr><td colspan="5" class="text-center">
         <ul class="pagination">
          
		<c:if test="${ paging.startBtn >= paging.bottomList }">
		<li><a href="${pageContext.request.contextPath }/selectadministerform.mypage?pstartno=${(paging.startBtn-2)*paging.onePageLimit }">이전</a></li>
		</c:if>
		
		<c:forEach var="i" begin="${paging.startBtn}" end="${paging.endBtn}" >
		<li <c:if test="${i==paging.currentBtn}"> class="active" </c:if>>
		 <a href="${pageContext.request.contextPath}/selectadministerform.mypage?pstartno=${ (i-1)*paging.onePageLimit }">${i }</a></li>
		</c:forEach>
		
		<c:if test="${paging.pageAll > paging.endBtn}">
		<li><a href="${pageContext.request.contextPath }/selectadministerform.mypage?pstartno=${paging.endBtn*paging.onePageLimit }">다음</a></li>
		</c:if>
          
         </ul>
     	 </td></tr>
	</tfoot>
</table>
		
		<div class="container panel panel-info col-sm-5" style=" display:inline-block;">
		<form action="detail.mypage" method="post" id="selectadministerform1">
			<fieldset>
			<legend style="font-size:30px;">상세검색</legend>
			<div class = "from-group" >
				<label for="select">관리자/사용자 선택</label> 
				<select id="select" name="luser" class="form-control">
					<option value = "admin">관리자</option>
					<option value = "user">사용자</option>
				</select>
			</div>
				
			<br>
			
			<h4>  정렬선택  </h4>
			
			<div class = "from-group" >
				<label for="select">정렬방식</label> 
				<select id="select" name="Sort" class="form-control">
					<option value = "ASC">오름차순</option>
					<option value = "DESC">내림차순</option>
				</select>
			</div>	
				
				<label for="lno">기본정렬</label>
				<input type="checkbox" name="checkbox" id="lno" value="lno" checked />
				<label for="lsex">성별순</label>
				<input type="checkbox" name="checkbox" id="lsex" value="lsex"/>		
				<label for="lid">아이디순</label>
				<input type="checkbox" name="checkbox" id="lid" value="lid" />	
				<label for="lemail">이메일순</label>
				<input type="checkbox" name="checkbox" id="lemail" value="lemail"/>		
				<label for="lage">나이순</label>
				<input type="checkbox" name="checkbox" id="lage" value="lage"/>	
<script>
$(function(){
	$("#lsex").change(function(){
		if ($(this).is(':checked'))
			{
				$("input:checkbox[id='lno']").prop("checked", false);
			}
	});
});
$(function(){
	$("#lid").change(function(){
		if ($(this).is(':checked'))
			{
				$("input:checkbox[id='lno']").prop("checked", false);
			}
	});
});	
$(function(){
	$("#lemail").change(function(){
	 if ($(this).is(':checked'))
			{
				$("input:checkbox[id='lno']").prop("checked", false);
			}
	});
});	

$(function(){
	$("#lage").change(function(){
		 if ($(this).is(':checked'))
			{
				$("input:checkbox[id='lno']").prop("checked", false);
			}
	});	});	
$(function(){
	$("#lno").change(function(){
		 if ($(this).is(':checked'))
			{
				$("input:checkbox[id='lid']").prop("checked", false);
				$("input:checkbox[id='lemail']").prop("checked", false);
				$("input:checkbox[id='lage']").prop("checked", false);
				$("input:checkbox[id='lsex']").prop("checked", false);
			}
	});	});	
</script>			
				<div class="form-group">
					<label for="info"></label>
					<input type="submit" name="info" id="info" value="검색" class="btn btn-sucess"/>	
				</div>
				
				</fieldset>
			</form>
		</div>
				
		<div class="col-sm-1">
		</div>

		<div class="container panel panel-info col-sm-4" style=" display:inline-block;">
			<form action="perdetail.mypage" method="post" id="selectadministerform1">
			<fieldset>
				<legend style="font-size:30px;">아이디검색</legend>
				
				<div class="form-group">
					<label for="id">아이디</label>
					<input type="text" name="lid" id="id"  class="form-control"/>	
				</div>
				
				<div class="form-group">
					<label for="info"></label>
					<input type="submit" name="info" id="info" value="아이디검색" class="btn btn-danger"/>	
				</div>
				
			</fieldset>
			</form> 
		</div>
		
		
		
		<div class="col-sm-1">
		</div>
		
</div>
</div>
</div>
</div>
</div>
<%@include file="../inc/footer.jsp" %>  