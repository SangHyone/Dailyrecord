<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%-- 이 페이지에서 에러가 발생한다면 error.jsp로 가라!!! --%>
<%@ page errorPage="error.jsp"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	10/0 =
	<%=10 / 0%>
</body>
</html>