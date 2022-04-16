<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container">
		<h3>파일업로드 성공</h3>
			<table class="table table-striped table-hover">
				<tbody>
					<tr><th>이미지</th>
						<td><img src="/upload/${saveName}"/></td> <!-- 연습용 -->
						<!-- <td><img src="${pageContext.request.contextPath}/upload/${saveName}"/></td> -->
					</tr>
				<tr><th>글쓴이</th><td>${name}</td></tr>
				<tr><th>제목</th><td>${title}</td></tr>
				</tbody>
			</table>
			<p><a href="javascript:history.go(-1)" class="btn btn-danger">HOME</a></p>
	</div>
</body>
</html>