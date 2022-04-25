<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@include file="../inc/header.jsp" %>

<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>MULTIBOARD 상세보기</h3> 					
		

	 <label for="bname">이름</label> 
	    <input type="text"	name="bname"  class="form-control" 	id="bname" value="${dto.bname}"  placeholder = "작성자를 적어주세요"/> 
	    <label for="btitle">제목</label> 
	    <input type="text"	name="btitle"  class="form-control" value="${dto.btitle}" id="btitle"   placeholder = "제목을 적어주세요"/> 
	    <label for="text">내용</label>
	    <textarea class="form-control" rows="5" id="bcontent" name="bcontent">${dto.bcontent}</textarea> 
		<div class="panel"  >
	  <div  class="panel-body">
	  	<span class="glyphicon glyphicon-plus">사진</span><br/>
	  <img src="${pageContext.request.contextPath}/upload/${dto.bfile}" alt="" width="460" height="345">
	</div>	
	</div>
	<div class="text-right"    >
		 <a href="edit_view.board?bno=${dto.bno}"  class="btn btn-danger" >수정</a> 
		 <a href="delete_view.board?bno=${dto.bno}"  class="btn btn-danger" >삭제</a>    
		 <a href="list.board?pstartno=0"  class="btn btn-info" >목록보기</a> 
	</div>
</div>	
<%@include file="../inc/footer.jsp" %>