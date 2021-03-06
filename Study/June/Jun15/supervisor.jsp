<%@page import="kr.human.user.service.UserServiceImpl"%>
<%@page import="kr.human.tw.vo.UserVO"%>
<%@page import="kr.human.twboard.service.TwBoardServiceImpl"%>
<%@page import="kr.human.twboard.service.TwBoardService"%>
<%@page import="kr.human.tw.vo.PagingVO"%>
<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%-- JSTL 추가 --%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%-- 공통코드 삽입 --%>
<%@ include file="include.jsp" %>
<%
// 1페이지 분량의 글을 읽어오기
	PagingVO<UserVO> pagingVO = UserServiceImpl.getInstance().selectList(currentPage, pageSize, blockSize);
	request.setAttribute("pv", pagingVO);
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>자료실 목록 보기</title>
<%-- axicon 사용하기 --%>
<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath }/axicon/axicon.min.css" />
<%-- 부트스트랩을 사용하기 위한 준비 시작 --%>
<meta name="viewport" content="width=device-width, initial-scale=1">
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet">
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"></script>
<script src="https://cdn.jsdelivr.net/npm/@popperjs/core@2.10.2/dist/umd/popper.min.js" ></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.min.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.6.0/jquery.min.js"></script>
<%-- 부트스트랩을 사용하기 위한 준비 끝 --%>
<%-- 사용자 정의 자바스크립트 함수를 추가한다. --%>
<script type="text/javascript" src="${pageContext.request.contextPath }/js/commons.js"></script>

<script type="text/javascript">

</script>
<style type="text/css">
	table { width: 1000px; margin: auto; padding: 5px;}
	th {padding: 5px; border: 1px solid gray; background-color: silver;text-align: center;}
	td {padding: 5px; border: 1px solid gray; text-align: center;}
	.title {border: none; font-size: 20pt; text-align: center;}
	.sub_title {border: none; text-align: right;}
	/* 링크의 모양을 변경한다. */
	a:link 		{ color: black; text-decoration: none;} /* 링크가 걸린모양 */
	a:visited 	{ color: black; text-decoration: none;} /* 방문했던 링크 */
	a:hover 	{ color: black; text-decoration: none; font-weight: bold;} /* 마우스오버시 모양 */
	a:active 	{ color: orange; text-decoration: none;} /* 마우스 클릭시 모양 */
</style>
</head>
<body>
	<table>
		<tr>
			<td colspan="4" class="title">
				회원관리
			</td>
		</tr>
		<tr>
			<td colspan="4" class="sub_title">
				${pv.pageInfo }
			</td>
		</tr>
		<tr>
			<th>No</th>
			<th width="55%">ID</th>
			<th>password</th>
			<th>name</th>
			<th>birth</th>
			<th>gender</th>
			<th>email</th>
			<th>phone</th>
			<th>postCode</th>
			<th>addr1</th>
			<th>addr2</th>
			<th>use</th>
			<th>lev</th>
		</tr>
		<c:if test="${pv.totalCount==0 }">
			<tr>
				<td colspan="5" style="text-align: center;">
				등록된 글이 없습니다.
				</td>
			</tr>
		</c:if>
		<c:if test="${pv.totalCount>0 }">
			<c:if test="${not empty pv.list }">
				<%-- 시작 번호 계산 --%>
				<c:set var="no" value="${pv.totalCount - (pv.currentPage-1)*pv.pageSize }"/>
				<c:forEach var="vo" items="${pv.list }">
					<tr>
						<td>
							${no }
							<c:set var="no" value="${no - 1 }"/>
						</td>					
						<td style="text-align: left;">
							<c:out value="${vo.id }"/>
						</td>					
						<td>
							<c:out value="${vo.password }"/>
						</td>					
						<td>
							<c:out value="${vo.name }"/>
						</td>					
						<td>
							<c:out value="${vo.birth }"/>
						</td>					
						<td>
							<c:out value="${vo.gender }"/>
						</td>					
						<td>
							<c:out value="${vo.email }"/>
						</td>					
						<td>
							<c:out value="${vo.phone }"/>
						</td>					
						<td>
							<c:out value="${vo.postCode }"/>
						</td>					
						<td>
							<c:out value="${vo.addr1 }"/>
						</td>					
						<td>
							<c:out value="${vo.addr2 }"/>
						</td>					
						<td>
							<c:out value="${vo.use }"/>
						</td>					
						<td>
							<c:out value="${vo.lev }"/>
						</td>									
					</tr>
				</c:forEach>
				<tr>
					<td colspan="4" class="sub_title" style="text-align: center;">
						${pv.pageList }
					</td>
				</tr>
			</c:if>
		</c:if>
	</table>
</body>
</html>