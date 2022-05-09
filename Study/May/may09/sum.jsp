<%@page import="kr.human.servlet.CalcUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%!public int sum(int n) {
		int s = n;
		while (n >= 1) {
			s += --n;
		}
		return s;
	}%>
</head>
<body>
	<%
	int n = 1;
	try {
		n = Integer.parseInt(request.getParameter("n"));
	} catch (Exception e) {
		;
	}

	int sum = 0;
	for (int i = 1; i <= n; i++)
		sum += i;
	
	
	
	// EL을 배운다면 출력을 간단하게 할 수 있다.
	request.setAttribute("n", n);
	request.setAttribute("sum", sum);
	%>

	1 에서
	<%=n%>까지의 합 :
	<%=sum%>
	<br />
	1 에서
	<%=n%>까지의 합 :
	<%=CalcUtil.sum(n)%>
	<br />
	1 에서
	${n }까지의 합 :
	${sum }
	<br />

</body>
</html>