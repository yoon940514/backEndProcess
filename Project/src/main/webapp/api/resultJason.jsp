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
<div class="well r1">
	<table class="table table-dark">
	<thead>
		<tr>
		
			<th scope="col">사업연도</th>
			<th scope="col">개별/연결명</th>
			<th scope="col">종목코드</th>
			<th scope="col">계정명</th>
			<th scope="col">당기해당금액</th>
			<th scope="col">당기누적금액</th>
		</tr>
	</thead>
	<tbody>
	</tbody>
	</table>
</div> 


<script>
$(function(){
		$.ajax({
			url: "${pageContext.request.contextPath}/Gongsi2.Json", type:"GET", dataType: "json", 
				success: function(json){
				for (var i = 0; i < json.list.length; i++)
					{
						var bsns_year = json.list[i].bsns_year;
						var fs_nm = json.list[i].fs_nm;
						var stock_code = json.list[i].stock_code;
						var account_nm = json.list[i].account_nm;
						var thstrm_amount = json.list[i].thstrm_amount;
						var thstrm_add_amount = json.list[i].thstrm_add_amount;
						
						var tr = $("<tr>");
						var a1 = $("<td>").html(bsns_year);
						var a2 = $("<td>").html(fs_nm);
						var p0 = $("<td>").html(stock_code);
						var p1 = $("<td>").html(account_nm);
						var p2 = $("<td>").html(thstrm_amount);
						var p3 = $("<td>").html(thstrm_add_amount);
						
						tr.append(a1).append(a2).append(p0).append(p1).append(p2).append(p3);
						$(".r1 tbody").append(tr);
					}
				
		}, error: function(xhr, textStatus, errorThrown){
		   $(".r1").html(textStatus + "(HTTP-)" + xhr.status + "/" + errorThrown + ")");	
		}
	});
});
</script>   

   </body>
</html>