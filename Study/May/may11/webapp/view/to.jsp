<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	호호호호호호호 <br />
	성별 : (${gender?"남자" : "여자"}) <br />
	<%
		boolean g = (boolean)request.getAttribute("gender");
		out.println(g ? "남자" : "여자");
	%>
</body>
</html>