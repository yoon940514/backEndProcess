<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<div class="container panel panel-info">
		<h3 class="panel-heading"> 파일 업로드 </h3>
			<form action="${pageContext.request.contextPath}/basic/upload" method="post" enctype="multipart/form-data">
				<div class="form-group">
					<label for="name">글쓴이</label>
					<input type="text" name="name" id="name" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="title">제목</label>
					<input type="text" name="title" id="title" class="form-control"/>
				</div>
				<div class="form-group">
					<label for="file">파일업로드</label>
					<input type="file" name="file" id="file" class="form-control"/>
				</div>
				<div class="form-group">
					<input type="submit" value="전송" class="form-control btn btn-warning"/>
				</div>
			
			</form>
	</div>
</body>
</html>