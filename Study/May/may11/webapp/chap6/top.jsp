<%@page import="java.net.URLDecoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<div>
	<h2>나는 상단의 내용입니다. 하하하하하</h2>
	<%
		// jsp:include의 한글은 이렇게 해도 깨진다.
		// 인코딩해서 보내고 디코딩해서 받아야 한글이 제대로 나온다
		//request.setCharacterEncoding("UTF-8");
	%>
	<%=URLDecoder.decode(request.getParameter("name"),"UTF-8") %>(<%=request.getParameter("phone") %>)
	<hr /> 
</div>