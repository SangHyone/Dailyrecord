<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<%-- 이자리에 코드가 복사되어 붙여지고 서블릿으로 변환된다.
		 프로그램 코드가 포함
		 --%> 
	<%@ include file="include.jsp" %>
	<%-- 실행결과 포함
	<jsp:include page="include.jsp"></jsp:include>
	 --%>
	 
	이름 : <%=name %> <br />
	나이 : <%=age %>세 <br />
	

</body>
</html>