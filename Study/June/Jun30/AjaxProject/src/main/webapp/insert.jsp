<%@page import="kr.human.service.InsertService"%>
<%@ page language="java" contentType="text/plain; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true" %>
<%
	// 서비스를 호출해서 저장을 수행하고
	int result = InsertService.insert(request.getParameter("name"));
	// 결과를 성공시 1 실패시 0을 출력해준다.
	out.print(result);
%>