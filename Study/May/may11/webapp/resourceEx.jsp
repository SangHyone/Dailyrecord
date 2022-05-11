<%@page import="kr.human.vo.PollVO"%>
<%@page import="com.google.gson.Gson"%>
<%@page import="java.io.InputStream"%>
<%@page import="java.io.InputStreamReader"%>
<%@page import="java.io.BufferedReader"%>
<%@page import="java.net.URL"%>
<%@page import="java.io.File"%>
<%@page import="java.util.Scanner"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>application객체를 이용한 자원접근</title>
</head>
<body>
	<%
		String realPath = application.getRealPath("/data/poll.json");
	%>
	서버의 절대 경로 : <%=realPath %> <br />
	<hr />
	<%
		Scanner sc = new Scanner(new File(realPath));
		while(sc.hasNextLine()){
			out.println(sc.nextLine() + "<br>");
		}
		sc.close();
	%>
	<hr />
	<%
		URL url = application.getResource("/data/poll.json");
		BufferedReader br = new BufferedReader(new InputStreamReader(url.openStream()));
		String line = "";
		while((line = br.readLine()) != null){
			out.println(line + "<br>");
		}
		br.close();
	%>
	<hr />
	<%
		InputStream is = application.getResourceAsStream("/data/poll.json");
		br = new BufferedReader(new InputStreamReader(is));
		while((line = br.readLine()) != null){
			out.println(line + "<br>");
		}
		br.close();
	%>
	<hr />
	<%
		is = application.getResourceAsStream("/data/poll.json");
		Gson gson = new Gson();
		PollVO pollVO = gson.fromJson(new InputStreamReader(is), PollVO.class);
		is.close();
		out.println("제목 : " + pollVO.getTitle() + "<br>");
	%>
</body>
</html>