<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String search = request.getParameter("search");
	pageContext.setAttribute("search", search);
%>
<!DOCTYPE html>
<html>
<head>
<!-- CSS 적용 부분 -->
<meta name="viewport" content="width=device-width, maximum-scale=1.0, minimum-scale=1, user-scalable=yes,initial-scale=1.0" />
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="../css/style.css?ver=4" type="text/css">
<!-- 버튼을 눌렸을 때 기능 -->
<script type="text/javascript">
function search(){
	var ws = document.getElementById('search').value;
	if(ws != ""){
		location.href = 'main_fmiddle.do?search='+ ws;
		
	}else{
		location.href = 'main_fmiddle.do';
	}
}
</script>
<meta charset="UTF-8">
<title>fmiddle_s</title>
</head>
<body>

<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#">fmiddle_s</a>  
  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
  </div>
</nav>
<div class="searchDivInput">
	<input type="text" name="search" var="search" id="search" autocomplete="off" placeholder="OID LIKE 값 입력" onchange="search()" required>
</div>
  <!-- search, insert -->
<div class="searchDivBtn" style="margin: 5px 0px 0px 0px;">
  <input class="btn btn-outline-dark" type="button" value="생성" onclick="window.open('fmiddle_c.jsp', 'pop_title','top=10, left=10, width=500, height=460, status=no, menubar=no, toolbar=no, resizable=no'); return false">
  <input class="btn btn-outline-dark" type="button" value="조회" onclick="search()">
</div>
<div style="float:left;">

</div>
<table class="table table-hover table-bordered"  style="font-size:14px;">
  <thead>
	<tr>
	<th title="OID"  scope="col">OID</th>
	<th title="B_OID"  scope="col">B_OID</th>
	<th title="C_TYPE"  scope="col">C_TYPE</th>
	<th title="P_NAME"  scope="col">P_NAME</th>
	<th title="P_NO"  scope="col">P_NO</th>
	<th title="GUBUN"  scope="col">GUBUN</th>
	<th title="C_DATE"  scope="col">C_DATE</th>
	<th title="U_DATE" scope="col">U_DATE</th>
	<th title="DESCRIPTION" scope="col">DESCRIPTION</th>
    </tr>
  </thead>
  <tbody>
  <!-- 받아온 값 테이블 처리 -->
  <c:forEach items="${flist}" var="wfmid">
	 <td title="${wfmid.oid}" ><a style="text-decoration:none" href="detail_fmiddle.do?oid=${wfmid.oid}" onclick="window.open(this.href, 'pop_title','top=10, left=10, width=500, height=460, status=no, menubar=no, toolbar=no, resizable=no'); return false">${wfmid.oid}</a></td>
     <td title="${wfmid.b_oid}" >${wfmid.b_oid}</td>
     <td title="${wfmid.c_type}" >${wfmid.c_type}</td>
     <td title="${wfmid.p_name}" >${wfmid.p_name}</td>
     <td title="${wfmid.p_no}" >${wfmid.p_no}</td>
     <td title="${wfmid.gubun}" >${wfmid.gubun}</td>
     <f:formatDate var="c_date" value="${wfmid.c_date}" type="DATE" pattern="yy/MM/dd" />
     <td title="${c_date}" >${c_date}</td>
     <f:formatDate var="u_date" value="${wfmid.u_date}" type="DATE" pattern="yy/MM/dd" />
     <td title="${u_date}" >${u_date}</td>
     <td title="${wfmid.description}">${wfmid.description}</td>
  </tbody>
  </c:forEach>
</table>

<!-- 페이징에 필요한 값들 넘기기 -->
<jsp:include page="paging.jsp">
	<jsp:param value="fmiddle" name="boardName"/>
	<jsp:param value="${search}" name="search" />
    <jsp:param value="${paging.page}" name="page"/>
    <jsp:param value="${paging.beginPage}" name="beginPage"/>
    <jsp:param value="${paging.endPage}" name="endPage"/>
    <jsp:param value="${paging.prev}" name="prev"/>
    <jsp:param value="${paging.next}" name="next"/>
</jsp:include>
</div>


</body>
</html>
