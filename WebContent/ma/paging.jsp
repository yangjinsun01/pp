<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
     <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<style type="text/css">
body{
text-align:center;
}
#paging{
font-size:12pt;
}
</style>

<meta charset="UTF-8">
</head>
<body>
<div id ="paging">

<c:choose>
	<c:when test="${param.boardName =='fmiddle'}">
		<c:url var="action" value="/ma/main_fmiddle.do"/>
		<c:set var="search" value="${param.search}" />
		
		<!-- 이전 버튼 -->
		<c:if test="${param.prev}">
		    <a href="${action}?page=${param.beginPage-1}&search=${search}">prev</a>
		</c:if>
		
		<!-- 가운데 숫자 부분 -->
		<c:forEach begin="${param.beginPage}" end="${param.endPage}" step="1" var="index">
		    <c:choose>
		        <c:when test="${param.page==index}">
		            ${index}
		        </c:when>
		        <c:otherwise>
		            <a href="${action}?page=${index}&search=${search}">${index}</a>
		        </c:otherwise>
		    </c:choose>
		</c:forEach>
		
		<!-- 다음 버튼 -->
		<c:if test="${param.next}">
		    <a href="${action}?page=${param.endPage+1}&search=${search}">next</a>
		</c:if>
	</c:when>
	
	<c:otherwise>
	</c:otherwise>
</c:choose>
</div>


</body>
</html>