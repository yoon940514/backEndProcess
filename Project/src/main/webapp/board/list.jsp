<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@page import="java.util.*"%>
<%@page import="java.sql.*"%>
<%@include file="../inc/header.jsp" %>
  <!--  -->
	
	<div class="container panel panel-success">
		<h2 class="text-center">UNIVEST</h2>
		<table class="table table-striped">
			<caption class="text-center">자유게시판</caption>
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
			<c:forEach var="dto" items="${paging.list10}" varStatus="status">
				<tr><td>${total-status.index}</td><td><a href="detail.board?bno=${dto.bno}">${dto.bpass}</a></td>
				<td>${dto.bname}</td><td>${dto.bdate}</td><td>${dto.bhit}</td></tr>
			</c:forEach>
		</tbody>
		<tfoot>
		<tr><td colspan="5" class="text-center">
         <ul class="pagination">
          
		<c:if test="${ paging.startBtn >= paging.bottomList }">
		<li><a href="${pageContext.request.contextPath }/list.board?pstartno=${(paging.startBtn-2)*paging.onePageLimit }">이전</a></li>
		</c:if>
		
		<c:forEach var="i" begin="${paging.startBtn}" end="${paging.endBtn}" >
		<li <c:if test="${i==paging.currentBtn}"> class="active" </c:if>>
		 <a href="${pageContext.request.contextPath}/list.board?pstartno=${ (i-1)*paging.onePageLimit }">${i }</a></li>
		</c:forEach>
		
		<c:if test="${paging.pageAll > paging.endBtn}">
		<li><a href="${pageContext.request.contextPath }/list.board?pstartno=${paging.endBtn*paging.onePageLimit }">다음</a></li>
		</c:if>
          
         </ul>
     	 </td></tr>
	</tfoot>
		</table>
		<p class="text-right"  >
				<!-- <input type="submit" value="글쓰기" class="btn btn-primary " title="글쓰기"/> -->
				<a href="write_view.board" class="btn btn-danger " title="글쓰기폼">글쓰기 </a>
 		
			</p>
	</div>
	
<%@include file="../inc/footer.jsp"%>