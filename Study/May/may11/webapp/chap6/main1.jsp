<%@page import="java.net.URLEncoder"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<table>
		<tr>
			<td colspan="2">
				<%-- 상단 --%>
				<jsp:include page="top.jsp">
					<jsp:param value='<%=URLEncoder.encode("한사람","UTF-8") %>' name="name"/>
					<jsp:param value="555-6789" name="phone"/>
				</jsp:include>
			</td>
		</tr>
		<tr>
			<td>
				<%-- 왼쪽메뉴 --%>
				<jsp:include page="left.jsp"/>
					
			</td>
			<td>
				<%-- 메인컨텐츠 --%>
				<h1>나는 첫번째 페이지 입니다.</h1>
			</td>
		</tr>
		<tr>
			<td colspan="2">
				<%-- 하단 --%>
				<jsp:include page="bottom.jsp"/>
			</td>
		</tr>
	</table>
</body>
</html>