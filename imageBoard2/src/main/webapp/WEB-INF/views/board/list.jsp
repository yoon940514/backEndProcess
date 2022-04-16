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
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
  <!--  -->
	
	<div class="container panel panel-success">
		<h2 class="text-center">QNA</h2>
		<table class="table table-striped">
			<caption class="text-center">문의사항이 있으시면 언제든시 문의주세요</caption>
			<thead>
				<tr>
					<th scope="col">NO</th>
					<th scope="col">TITLE</th>
					<th scope="col">WRITER</th>
					<th scope="col">DATE</th>
					<th scope="col">HIT</th>
				</tr>
			</thead>
			<tbody>
			<c:set var="total" value="${list.size()}"/>
			<c:forEach var="dto" items="${list}" varStatus="status">
				<tr><td>${total-status.index}</td><td><a href="${pageContext.request.contextPath}/board/detail?bno=${dto.bno}">${dto.btitle}</a></td>
				<td>${dto.bname}</td><td>${dto.bdate}</td><td>${dto.bhit}</td></tr>
			</c:forEach>
		</tbody>
		</table>
		<p class="text-right"  >
				<!-- <input type="submit" value="글쓰기" class="btn btn-primary " title="글쓰기"/> -->
				<a href="${pageContext.request.contextPath}/board/write" class="btn btn-danger " title="글쓰기폼">글쓰기 </a>
 		
			</p>
	</div>
	<script>
   $(function(){
      var result =  '${result}'; console.log(result);
      if(   result == '실패'  ){  alert('관리자에게 문의바랍니다.');     }
      else if(result.length != 0 ){  alert( '${result}');  }
   });
</script>
</body>
</html>