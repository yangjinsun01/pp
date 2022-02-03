<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="../css/style.css?ver=2" type="text/css">
<script language="javascript">
</script>
<meta charset="UTF-8">
</head>
<body>
<div class="ppContainer">
<c:choose>
<c:when test = "${not empty plist}">
<table class="table table-hover table-bordered" style="font-size: 14px;">
<thead>
<tr>
<th title="OID" scope="col">OID</th>
<th title="B_OID" scope="col">B_OID</th>
<th title="C_TYPE" scope="col">C_TYPE</th>
<th title="ITEM" scope="col">ITEM</th>
<th title="P_NO" scope="col">P_NO</th>
<th title="Y_PPLAN" scope="col">Y_PPLAN</th>
<th title="M_PPLAN" scope="col">M_PPLAN"</th>
<th title="D_PPLAN" scope="col">D_PPLAN</th>
<th title="P_RATE" scope="col">P_RATE</th>
<th title="O_RATE" scope="col">O_RATE</th>
<th title="BOX" scope="col">BOX</th>
<th title="H_STICK" scope="col">H_STICK</th>
<th title="N_CAR" scope="col">N_CAR</th>
<th title="C_DATE" scope="col">C_DATE</th>
<th title="U_DATE" scope="col">U_DATE</th>
<th title="DESCRIPTION" scope="col">DESCRIPTION</th>
</tr>
</thead>
<tbody>
  <c:forEach items="${plist}" var="pdto">
<td title="${pdto.oid}">${pdto.oid}</td>
<td title="${pdto.b_oid}">${pdto.b_oid}</td>
<td title="${pdto.c_type}">${pdto.c_type}</td>
<td title="${pdto.item}">${pdto.item}</td>
<td title="${pdto.p_no}">${pdto.p_no}</td>
<td title="${pdto.y_pplan}">${pdto.y_pplan}</td>
<td title="${pdto.m_pplan}">${pdto.m_pplan}</td>
<td title="${pdto.d_pplan}">${pdto.d_pplan}</td>
<td title="${pdto.p_rate}">${pdto.p_rate}</td>
<td title="${pdto.o_rate}">${pdto.o_rate}</td>
<td title="${pdto.box}">${pdto.box}</td>
<td title="${pdto.h_stick}">${pdto.h_stick}</td>
<td title="${pdto.n_car}">${pdto.n_car}</td>
<td title="${pdto.c_date}">${pdto.c_date}</td>
<td title="${pdto.u_date}">${pdto.u_date}</td>
<td title="${pdto.description}">${pdto.description}</td>
  </tbody>
  </c:forEach>
</table>
</c:when>
<c:otherwise>
<script language="javascript">

var search = location.search;

var params = new URLSearchParams(search);

var Oid= params.get('oid');
console.log(Oid);
//Name
alert("OID : '"+ Oid + "' 에 대한 결과가 존재하지 않습니다.");
top.window.close();
</script>
</c:otherwise>
</c:choose>
<jsp:include page="paging.jsp">
	<jsp:param value="${paging.oid}" name="oid"/>
	<jsp:param value="p" name="boardName"/>
    <jsp:param value="${paging.page}" name="page"/>
    <jsp:param value="${paging.beginPage}" name="beginPage"/>
    <jsp:param value="${paging.endPage}" name="endPage"/>
    <jsp:param value="${paging.prev}" name="prev"/>
    <jsp:param value="${paging.next}" name="next"/>
</jsp:include>
</div>
</body>
</html>