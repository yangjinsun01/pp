<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f"  %>

<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, maximum-scale=1.0, minimum-scale=1, user-scalable=yes,initial-scale=1.0" />
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="../css/style.css?ver=2" type="text/css">
<script type=text/javascript>
function createOpen(){
    var pop_title = "법인정보생성" ;
    window.open('/yura/ma/binfo_create.do', 'pop_title','top=10, left=10, width=800, height=450, status=no, menubar=no, toolbar=no, resizable=no');
}
function detailOpen(){
    var pop_title = "법인정보상세" ;
    window.open('/yura/ma/binfo_detail.do', 'pop_Detail','top=10, left=10, width=800, height=450, status=no, menubar=no, toolbar=no, resizable=no');
}
function nullCheck(){
	 var searchInput = document.searchForm;
	 if(searchInput.oidValue.value == ""){
		 alert('')
	 }
}
</script>
<meta charset="UTF-8">
<title>법인생성정보</title>
</head>
<body>
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="main_binfo.do">법인 생성 정보</a>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
  </div>
</nav>
<form name ="searchForm" action="search_binfo.do" method="post">
<div>
<div class="searchDivInput">
OID <input type="text" name="oidValue" autocomplete="off" required>
</div>
  <div class="searchDivBtn">
	<input class="btn btn-outline-dark btn-sm" onclick="createOpen()" type="button" value="생성">
  	<input class="btn btn-outline-dark btn-sm" type="submit" value="조회">
  	</div>
</div>
</form>


<table class="table table-hover table-bordered"  style="font-size:14px">
  <thead>
<tr>
<th title="OID"  scope="col">OID</th>
<th title="BCODE"  scope="col">BCODE</th>
<th title="BNAME"  scope="col">BNAME</th>
<th title="W_DAY"  scope="col">W_DAY</th>
<th title="W_TIME"  scope="col">W_TIME</th>
<th title="T_CNT"  scope="col">T_CNT</th>
<th title="L_STAND"  scope="col">L_STAND</th>
<th title="S_DAY"  scope="col">S_DAY</th>
<th title="RFQ"  scope="col">RFQ</th>
<th title="N_FACTORY"  scope="col">N_FACTORY</th>
<th title="C_DATE"  scope="col">C_DATE</th>
<th title="U_DATE" scope="col">U_DATE</th>
<th title="DESCRIPTION" scope="col">DESCRIPTION</th>
<th title="FILE1"  scope="col">FILE1</th>
<th title="O_FILE1"  scope="col">O_FILE1</th>
<th title="FILE2"  scope="col">FILE2</th>
<th title="O_FILE2" scope="col">O_FILE2</th>
    </tr>
  </thead>
  <tbody>
  <c:forEach items="${blist}" var="wbdto">
	  <td title="${wbdto.oid}" ><a style="text-decoration:none" href="main_pplan.do?oid=${wbdto.oid}" target="ifrm1">${wbdto.oid}</a></td>
      <td title="${wbdto.bcode}" ><a style="text-decoration:none"  href="/yura/ma/detail_binfo.do?oid=${wbdto.oid}" onclick="window.open(this.href, 'pop_title','top=10, left=10, width=600, height=530, status=no, menubar=no, toolbar=no, resizable=no'); return false">${wbdto.bcode}</a></td>
      <td title="${wbdto.bname}" >${wbdto.bname}</td>
    <td title="${wbdto.w_day}" >${wbdto.w_day}</td>
     <td title="${wbdto.w_time}" >${wbdto.w_time}</td>
     <td title="${wbdto.t_cnt}" >${wbdto.t_cnt}</td>
     <td title="${wbdto.l_stand}" >${wbdto.l_stand}</td>
     <td title="${wbdto.s_day}" >${wbdto.s_day}</td>
     <td title="${wbdto.rfq}" >${wbdto.rfq}</td>
     <td title="${wbdto.n_factory}" >${wbdto.n_factory}</td>
     <f:formatDate var="c_date" value="${wbdto.c_date}" type="DATE" pattern="yy/MM/dd" />
     <td title="${c_date}" >${c_date}</td>
     <f:formatDate var="u_date" value="${wbdto.u_date}" type="DATE" pattern="yy/MM/dd" />
     <td title="${u_date}">${u_date}</td>
     <td title="${wbdto.description}">${wbdto.description}</td>
<td></td>
<td></td>
<td></td>
<td></td>
  </tbody>
  </c:forEach>
</table>
<jsp:include page="paging.jsp">
	<jsp:param value="b" name="boardName"/>
    <jsp:param value="${paging.page}" name="page"/>
    <jsp:param value="${paging.beginPage}" name="beginPage"/>
    <jsp:param value="${paging.endPage}" name="endPage"/>
    <jsp:param value="${paging.prev}" name="prev"/>
    <jsp:param value="${paging.next}" name="next"/>
</jsp:include>
</div>
<hr></hr>
<!--  iframe   -->
<div class="container">
<nav class="navbar navbar-expand-lg navbar-light bg-light">
  <a class="navbar-brand" href="#"> 생산 계획 정보</a>
  <div class="collapse navbar-collapse" id="navbarTogglerDemo03">
  </div>
</nav>
<div class="iframeBox" style=frameborder:0;>
<iframe src="about:blank" name="ifrm1" style="border:none" scrolling="no";></iframe>
</div>
</div>
</body>
</html>
