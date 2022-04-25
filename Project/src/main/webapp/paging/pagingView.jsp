<%@page import="java.util.ArrayList"%>
<%@page import="Paging.LPaging"%>
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>   
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>    
<html lang="ko">
   <head> 
      <meta charset="UTF-8"/>   
      <title>Insert title here</title>
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">

<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>

</head>
   <body> 
<table class="table table-striped">
   <caption>ITEMS</caption>
   <thead>
      <tr>
         <th scope="col">INO</th>
         <th scope="col">NAME</th>
         <th scope="col">PRICE</th>
         <th scope="col">DESCRIPTION</th>
      </tr>
   </thead>
   <tbody>
   <c:forEach var="dto" items="${paging.list10}" varStatus="status">
      <tr>   
         <td>${paging.pageTotal-paging.pstartno - status.index}</td>
         <td>${dto.name}</td>
         <td>${dto.price}</td>
         <td>${dto.description}</td>
      </tr>
   </c:forEach>
   </tbody>
   <tfoot>
      <tr><td colspan="5" class="text-center">
         <ul class="pagination">
          
<c:if test="${ paging.startBtn >= paging.bottomList }">
<li><a href="${pageContext.request.contextPath }/JstlServlet?pstartno=${(paging.startBtn-2)*paging.onePageLimit }">이전</a></li>
</c:if>

<c:forEach var="i" begin="${paging.startBtn}" end="${paging.endBtn}" >
<li <c:if test="${i==paging.currentBtn}"> class="active" </c:if>>
 <a href="${pageContext.request.contextPath}/JstlServlet?pstartno=${ (i-1)*paging.onePageLimit }">${i }</a></li>
</c:forEach>

<c:if test="${paging.pageAll > paging.endBtn}">
<li><a href="${pageContext.request.contextPath }/JstlServlet?pstartno=${paging.endBtn*paging.onePageLimit }">다음</a></li>
</c:if>
          
         </ul>
      </td></tr>
   </tfoot>
   
   </table>
   </body>
</html>