<%@page import="kr.human.lunar.PollVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.FileReader"%>
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
		String fileName = application.getRealPath("/data/poll.json");
		FileReader fr = new FileReader(fileName);
		
		Gson gson = new Gson();
		
		PollVO pollVO = gson.fromJson(fr, PollVO.class);
		
		out.println("설문제목 : " + pollVO.getTitle() + "<br>");
		
		for(int i =0; i<pollVO.getItem().length;i++){
			out.println("<input type='radio' value='' name='poll'>");
			out.println(pollVO.getItem()[i] + "<br>");
		}
	%>
</body>
</html>