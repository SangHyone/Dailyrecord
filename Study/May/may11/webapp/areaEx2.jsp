<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	
	페이지 영역의 변수값 : <%=pageContext.getAttribute("i") %> <br />
	request 영역의 변수값 : <%=request.getAttribute("i") %> <br />
	session 영역의 변수값 : <%=session.getAttribute("i") %> <br />
	application 영역의 변수값 : <%=application.getAttribute("i") %> <br />
	
	<hr />
	<h2>EL을 쓰면 편리하다. (EL로 값을 출력하려면 반드시 영역에 저장되어있어야 한다.)</h2>
	변수값 : ${i } <br />
	
	페이지 영역의 변수값 : ${pageScope.i } <br />
	request 영역의 변수값 : ${requestScope.i } <br />
	session 영역의 변수값 : ${sessionScope.i } <br />
	application 영역의 변수값 : ${applicationScope.i } <br />
</body>
</html>