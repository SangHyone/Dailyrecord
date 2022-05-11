<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page buffer="16kb"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	현재 버퍼 크기 :
	<%=out.getBufferSize()%>
	<br /> 현재 남은 버퍼 크기 :
	<%=out.getRemaining()%>
	<br />
	<hr/>
	<%=out == pageContext.getOut() %>
</body>
</html>