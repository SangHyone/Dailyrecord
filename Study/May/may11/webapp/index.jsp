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
		// WEB-INF폴더는 URL로 접근이 불가능하다. 보안에 관계된것들은
		// WEB-INF폴더에 보관하는 것이 좋다.
		// 프로그램에서는 접근이 가능하다.
		pageContext.forward("/WEB-INF/view/view.jsp");
	%>
</body>
</html>