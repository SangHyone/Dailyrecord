<%@page import="java.util.Enumeration"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application 객체</title>
</head>
<body>
	<%-- application객체는 현재 애플리케이션에 관한 모든 정보를 가지는 내장 객체이다. --%>
	<h1>web.xml에 저장된 초기화 파라메터 읽기</h1>
	<hr />
	<%
		out.println("DB : " + application.getInitParameter("DB_Name") + "<br>");
		out.println("DB_User : " + application.getInitParameter("DB_User") + "<br>");
		out.println("DB_Password : " + application.getInitParameter("DB_Password") + "<br>");
	%>
	<hr />
	<%
		Enumeration<String> initNames = application.getInitParameterNames(); // 이름만
	while(initNames.hasMoreElements()){ // 반복
		String name = initNames.nextElement(); // 이름 얻기
		out.println(name + " : " + application.getInitParameter(name) + "<br>"); // 이름으로 값얻기
	}
	%>
	<hr />
	서버의 절대경로 : <%=application.getRealPath("/") %> <br />
	
</body>
</html>