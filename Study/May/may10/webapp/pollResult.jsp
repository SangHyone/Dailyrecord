<%@page import="kr.human.lunar.PollUtil"%>
<%@page import="kr.human.lunar.PollVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%
String filename = application.getRealPath("/data/poll.json");
PollVO pollVO = PollUtil.readPoll(filename);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>온라인 설문조사</title>
<!-- Bootstrap과 Jquery사용 -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.min.js"></script>

<script type="text/javascript">
	$(function(){
		$("#homeBtn").click(function() {
			location.href = 'poll.jsp'; // 자바스크립트로 페이지 이동하기
		})
	});

</script>
<style type="text/css">
table {
	margin: auto;
	width: 500px;
	border: 1px solid gray;
	padding: 5px;
	border-spacing: 5px;
}

.title {
	font-size: 14pt;
	text-align: center;
	background-color: silver;
	border: 1px solid gray;
}
td {
	padding : 7px;
}
</style>
</head>
<body>
	
		<table>
			<tr>
				<td class="title">온라인 설문조사 Ver 0.009</td>
			</tr>
			<tr>
				<td>제목 : <%=pollVO.getTitle()%></td>
			</tr>
			<tr>
				<td align="right">총 투표수 : <%=pollVO.getTotal()%>표</td>
			</tr>
			<%
				String[] colors = "red,green,blue,pink,yellow,brown,silver".split(",");
				for(int i=0;i<pollVO.getItem().length; i++){
					out.println("<tr>");
					out.println("<td>");
					out.println((i+1)+". "+pollVO.getItem()[i]);
					out.println("("+pollVO.getItemCount()[i] + "표, " + pollVO.getPercent(i) + ")");
					out.println("</td>");
					out.println("</tr>");
					// 그래프를 선으로 그리자
					out.println("<tr>");
					out.println("<td>");
					out.println("<hr size='20' align='left' width='" 
								+ pollVO.getPercent(i) + "' style='background-color:"+colors[i%colors.length]+"' />");
					out.println("</td>");
					out.println("</tr>");
				}
			%>
			
			<tr>
			<td align="center">
				
				<input type="submit" id="homeBtn" class="btn btn-sm btn-outline-success" value="돌아가기">
			</td>
			</tr>
		</table>

</body>
</html>