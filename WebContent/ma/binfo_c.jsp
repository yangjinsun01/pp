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
<link rel="stylesheet" href="../css/style.css?ver=2" type="text/css">
<script type="text/javascript">
function createOpen(){
    var pop_title = "법인정보생성" ;
    window.open('/yura/ma/popCreate.do', 'pop_title','top=10, left=10, width=800, height=400, status=no, menubar=no, toolbar=no, resizable=no');
}
function detailOpen(){
    var pop_title = "법인정보상세" ;
    window.open('/yura/ma/popDetail.do', 'pop_Detail','top=10, left=10, width=800, height=400, status=no, menubar=no, toolbar=no, resizable=no');
}
function popClose(){
	window.close();
}
</script>
<meta charset="UTF-8">
<title>정보 생성</title>
</head>
<body>
<div class="tableContainerALL">
<div class="tableTopName">
법인정보생성
</div>
<form method="post" name="createForm" action="binfo_createResult.do">
<div class="tableContainer">
<table style="font-size:10px; width:100%; border-bottom:none;">
 		<tr>
  		<th class="createSubject" scope="col">OID</th>
	  <td>
	  <c:forEach items="${lblist}" var="lwbdto">
	  <input class="createInput" type="text" name="oid" value="${lwbdto.resultCode}" readonly>
	  </c:forEach>
	  </td>
	    </tr>
	    <tr>
	     <th class="createSubject" scope="col">법인코드</th>
    	 <td><input class="createInput" type="text" id="bcode" name="bcode" autocomplete="off" required></td>
        </tr>
         		<tr>
  		<th class="createSubject" scope="col">작업일자</th>
	  <td><input class="createInput" type="text" id="w_day" name="w_day" autocomplete="off" required></></td>
	    </tr>
	     		<tr>
  		<th class="createSubject" scope="col">교대수</th>
	  <td><input class="createInput" type="text" id="t_cnt" name="t_cnt" autocomplete="off" required></></td>
	    </tr>
	     		<tr>
  		<th class="createSubject" scope="col">재고일수</th>
	  <td><input class="createInput" type="text" id="s_day" name="s_day" autocomplete="off" required></></td>
	    </tr>
	    <tr></tr>
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
	  <td><input class="createInput" type="text" id="bname" name="bname" autocomplete="off" required></></td>
	    </tr>
	    <tr>
	     <th class="createSubject" scope="col">작업시간</th>
    	 <td><input class="createInput" type="text" id="w_time" name="w_time" autocomplete="off" required></td>
        </tr>
         		<tr>
  		<th class="createSubject" scope="col">로트기준</th>
	  <td><input class="createInput" type="text" id="l_stand" name="l_stand"  autocomplete="off" required></></td>
	    </tr>
	     <tr>
  		<th class="createSubject"  scope="col"></th>
	  <td></td>
	    </tr>
</table>
</div>
<div class="tableContainerBottom">
<table style="font-size:10px; width:100%;">
		<tr>
  		<th class="createSubject" scope="col">비고</th>
	  <td><textarea cols="45" rows="3" placeholder="내용을 적어주세요." name="description"  autocomplete="off" style="resize: none;"></textarea></td>
		</tr>
</table>
<div class="createBtn">
	<input class="btn btn-outline-dark btn-sm" type="submit" value="생성">
  	<input class="btn btn-outline-dark btn-sm" type="button" onclick="popClose()" value="닫기">
</div>
</div>
</div>
</form>
</body>
</html>