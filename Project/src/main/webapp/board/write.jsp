<%@page language= "java"   contentType = "text/html; charset=UTF-8" pageEncoding = "UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@include file="../inc/header.jsp" %>
	
	<div class="container panel panel-info">
		<form action="${pageContext.request.contextPath}/write.board" method="post" enctype="multipart/form-data">
		<fieldset>
	  	<h3 style="font-weight: bold;" >쓰기</h3> 
	    <label for="bname">이름</label> 
	    <input type="text"	name="bname"  class="form-control" 	id="bname"   placeholder = "작성자를 적어주세요"/> 
	    <label for="bpass">비밀번호</label> 
	    <input type="password"	name="bpass"  class="form-control" 	id="bpass"   placeholder = "비밀번호를 적어주세요"/> 
	    <label for="btitle">제목</label> 
	    <input type="text"	name="btitle"  class="form-control" 	id="btitle"   placeholder = "제목을 적어주세요"/> 
	    <label for="text">내용</label>
	    <textarea class="form-control" rows="5" id="bcontent" name="bcontent"></textarea> 
	    <div class="form-group">
			<label for="bfile">파일업로드</label> <input type="file" name="bfile" id="bfile" class="form-control"/>
		</div> 
		
		<input type="submit" value="입력"	 class="btn btn-block"  title="데이터삽입"  id="click1"/> <br>
		<input type="button" value="취소"	 class="btn btn-block"  title="취소"  	 id="click2"/> <br>
		<input type="button" value="목록"	 class="btn btn-block"  title="목록이동"   id="click3"/> <br>
			<script>
				$(function(){ 
					$("#click1").on("click", function(){
						if($("#new_content").val() == "" || $("#title").val() == "" || $("#name").val() == "") { alert("다시확인해주세요"); return false; }
					});
				});
				$(function(){ 
					$("#click2").on("click", function(){
						if(confirm("글작성을 그만둘까요?")) { history.go(-1); }
						else{ return false;}
					});
				});
				$(function(){ 
					$("#click3").on("click", function(){
						history.go(-1); 
					});
				});
			</script>
			</fieldset>
			</form>
		</div> <br>
	<!--  -->
	<!--  -->
	<!--  -->
<%@include file="../inc/footer.jsp" %>