<%-- 결과를 텍스트형식으로 만들겠다. --%>
<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- 쓸데없는 공백을 제거 하겠다. --%>
<%@ page trimDirectiveWhitespaces="true"%>
<%
	request.setCharacterEncoding("UTF-8");
	String name = request.getParameter("name"); 
	// 이름이 넘어오지 않았다면
	if(name==null || name.trim().length()==0){
		name = "손";
	}
	out.print(name + "님 반갑습니다.");
%>