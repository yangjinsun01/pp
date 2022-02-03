<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta name="viewport" content="width=device-width, maximum-scale=1.0, minimum-scale=1, user-scalable=yes,initial-scale=1.0" />
<script src="https://code.jquery.com/jquery-3.6.0.slim.js" integrity="sha256-HwWONEZrpuoh951cQD1ov2HUK5zA5DwJ1DNUXaM6FsY=" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3" crossorigin="anonymous">
<link rel="stylesheet" href="../css/style.css?ver=3" type="text/css">
<script type="text/javascript">

function popClose(){
	window.opener.parent.location.reload();
	window.close();
}
</script>
<meta charset="UTF-8">
<title>법인정보상세</title>
</head>
<body>
<c:forEach items="${dlist}" var="dwbdto">
<form method="post" name="createForm" action="binfo_update.do?oid=${dwbdto.oid}">
<div class="tableContainerALL">
<div class="tableTopName">
법인정보상세
</div>
<div class="tableContainer">
<table style="width:100%; border-bottom:none;">
 		<tr>
  		<th class="createSubject" scope="col">OID</th>
	  <td>
	  ${dwbdto.oid}
	  </td>
	    </tr>
	    <tr>
	     <th class="createSubject" scope="col">법인코드</th>
    	 <td>${dwbdto.bcode}</td>
        </tr>
         		<tr>
  		<th class="createSubject" scope="col">작업일자</th>
	  <td>${dwbdto.w_day}</td>
	    </tr>
	     		<tr>
  		<th class="createSubject" scope="col">교대수</th>
	  <td>${dwbdto.t_cnt}</td>
	    </tr>
	     		<tr>
  		<th class="createSubject" scope="col">재고일수</th>
	  <td>${dwbdto.s_day}</td>
	    </tr>
	     		<tr>
  		<th class="createSubject" scope="col">법인명</th>
	  <td>${dwbdto.bname}</td>
	    </tr>
	    <tr>
  		<th class="createSubject" scope="col">등록일</th>
	  <td>${dwbdto.c_date}</td>
	    </tr>
</table>

</div>
<div class="tableContainer">
<table style="width:100%;">
 		<tr>
  		<th class="createSubject" scope="col"></th>
	  <td></td>
	    </tr>
 		<tr>
  		<th class="createSubject" scope="col">법인명</th>
	  <td>${dwbdto.bname}</td>
	    </tr>
	    <tr>
	     <th class="createSubject" scope="col">작업시간</th>
    	 <td>${dwbdto.w_time}</td>
        </tr>
         		<tr>
  		<th class="createSubject" scope="col">로트기준</th>
	  <td>${dwbdto.l_stand}</></td>
	    </tr>
	    <tr>
  		<th class="createSubject" scope="col"></th>
	  <td></td>
	    </tr>
	    <tr>
  		<th class="createSubject" scope="col">수정일</th>
	  <td>${dwbdto.u_date}</td>
	    </tr>
	    	    <tr>
  		<th class="createSubject" scope="col"></th>
	  <td></td>
	    </tr>

</table>
</div>
<div class="tableContainerBottom">
<table style="width:100%;">
		<tr>
  		<th class="createSubject" scope="col">비고</th>
	  <td>${dwbdto.description}</td>
		</tr>
</table>
</c:forEach>
<div class="createBtn">
	<input class="btn btn-outline-dark btn-sm" type="submit" value="수정">
  	<input class="btn btn-outline-dark btn-sm" type="button" onclick="popClose()" value="닫기">
</div>
</div>
</div>
</form>
</body>
</html>