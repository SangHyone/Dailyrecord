<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	하하하하하하하하하
	<%@ include file="var2.jsp" %>
	<%-- JSP에서 포워딩하는 3가지 방법
		1. <jsp:forward page="to.jsp"></jsp:forward> : 태그로 사용할때
	
	--%>
	<%
		// 2. pageContext.forward("to.jsp");  // 코드 중에서 포워딩할때
		
		// 3. 서블릿에서 사용!!! : 서블릿에는 pageContext가 없다.
		RequestDispatcher dispatcher = request.getRequestDispatcher("to.jsp");
		dispatcher.forward(request, response);
		
;	%>
</body>
</html>