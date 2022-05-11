<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%
		String name = request.getParameter("name");
	
		// out이 없다면
		if(name==null || name.trim().length()==0){
	%>
		이름이 없네요!!! <br />
	<%  } else { %>
		<%=name %>님 반가워요!!! <br />
	<% } %>
	<hr />
	<%
		// out이 있다면
		if(name==null || name.trim().length()==0){
			out.println("이름이 없네요!!! <br />");
		}else{
			out.println(name  + "님 반가워요!!! <br />");
		}
		
		// el을 배웠다면
	%>
	<hr />
	${param.name!=null ? param.name : "손"} 님 반가워요!!! <br />	
	
</body>
</html>