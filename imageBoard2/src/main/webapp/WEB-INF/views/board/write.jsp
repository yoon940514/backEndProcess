<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>
<!--  END HEADER -->
<!--  END HEADER -->
<!--  END HEADER -->
<script>	
	jQuery(document).ready(function(){
		jQuery("#writeForm").submit(function(){
			if(jQuery("#bname").val()==""){
				alert("이름을 입력하세요");
				$("#bname").focus();
				return false;
			}
			if(jQuery("#bpass").val()==""){
				alert("비밀번호를 입력하세요");
				$("#bpass").focus();
				return false;
			}
			if(jQuery("#btitle").val()==""){
				alert("제목을 입력하세요");
				$("#btitle").focus();
				return false;
			}
			if(jQuery("#bcontent").val()==""){
				alert("내용을 입력하세요");
				$("#bcontent").focus();
				return false;
			}
		});
	});
	
	$(function(){
	      var result =  '${result}'; console.log(result);
	      if(   result == '글쓰기실패'  ){  alert('관리자에게 문의바랍니다.');     }
	      else if(result.length != 0 ){  alert( '${result}');  }
	   });
</script>
<div class="container"  style="margin-top:5%; min-height:500px">
	<h3>MULTIBOARD - 글쓰기 </h3>
	<form action="${pageContext.request.contextPath}/board/write_post"   method="post"   enctype="multipart/form-data">
		<!-- <form action="${pageContext.request.contextPath}/board/write" method="post"  enctype="multipart/form-data" id="writeForm" > -->
		   <fieldset>
		   <legend>WRITE(CREATE)</legend>
			<div class="form-group">
			  <label for="bname"  >이름</label>
			  <input type="text"   name="bname"   id="bname"   class="form-control" > 
			</div>			
			<div class="form-group">
			  <label for="bpass"  >비밀번호</label>
			  <input type="password"   name="bpass"   id="bpass"   class="form-control" > 
			  <span>(*) 수정, 삭제시 필수</span>
			</div>																
			<div class="form-group">
			  <label for="btitle"  >제목</label>
			  <input type="text"   name="btitle"   id="btitle"   class="form-control" > 
			</div>	
			<div class="form-group">
			  <label for="bcontent"  >내용</label>
			  <textarea name="bcontent"  id="bcontent"  cols="60"  rows="10"   class="form-control" ></textarea>
			</div>	
			<div class="form-group">
			  <label for="file">파일업로드</label>
			  <input type="file" name="file" id="file" class="form-control"/>
			</div>			
			<div class="form-group  text-right">
				<input type="submit"   value="입력"  class="btn btn-default"  style="color:white; background-color:#f4511e"   >  
				<input type="reset"    value="취소"  class="btn btn-default"    >  
				<a href="${pageContext.request.contextPath}/board/list"   class="btn btn-default"   >목록보기</a>
			</div>
		 </fieldset>	
		</form> <!-- end form -->	
		
		<!-- dto 
		@Data
public class BoardDto {
	private int bno;
	private String bname;
	private String btitle;
	private String bpass;
	private String bcontent;
	private String bdate;
	private int bhit;
	private String bip;
	private String bfile;
}
		
		
		
		
		-->
</div>
	
<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
<!-- END FOOTER -->
</body>
</html>