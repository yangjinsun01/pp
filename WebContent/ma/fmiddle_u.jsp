<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="f" %>
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
	function buttion_click(num){
		// 입력 받은 버튼에 따른 적용 
		if(num == 'close') {
			window.opener.parent.location.reload();
			location.href = window.close();
		}
	}
</script>
<title>fmiddle 업데이트 페이지</title>
</head>
<body>
	<c:forEach items="${ulist}" var="wfmid">
	<form action="updateResult_fmiddle.do?oid=${wfmid.oid}" method="post" name="createForm">
		<div class="tableContainerALL">
		<div>
		<div class="tableTopName">W_FMIDDLE update</div>
		</div>
		<div class="tableContainer">
		<table style="font-size:14px; width:100%; border-bottom:none;">
			<tr>
				<th class="createSubject" scope="col"> </th>
				<td></td>
			</tr>
			
			<tr>
				<th class="createSubject" scope="col"> OID </th>
				<td> ${wfmid.oid} </td>
			</tr>
			
			<tr>
				<th class="createSubject" scope="col"> B_OID </th>
				<td> <input class="createInput" type="text" name ="b_oid" value="${wfmid.b_oid}" autocomplete="off" style="font-size:10px;"> </td>
			</tr>
			
			<tr>
				<th class="createSubject" scope="col"> C_TYPE </th>
				<td> <input class="createInput" type="text" name="c_type" value="${wfmid.c_type}" autocomplete="off" style="font-size:10px;"> </td>
			</tr>
			
			<tr>
				<th class="createSubject" scope="col"> </th>
				<td></td>
			</tr>
			
			<tr>
				<th class="createSubject" scope="col"> </th>
				<td></td>
			</tr>
		</table>
		</div>
		<!-- 나머지 부분 -->
		<div class="tableContainer">
		<table style="font-size:14px; width:100%;">
			<tr>
				<th class="createSubject" scope="col"> </th>
				<td></td>
			</tr>
			
			<tr>
				<th class="createSubject" scope="col"> P_NAME </th>
				<td> <input class="createInput" type="text" name="p_name" value="${wfmid.p_name}" autocomplete="off" style="font-size:10px;"> </td>
			</tr>
			
			<tr>
				<th class="createSubject" scope="col"> P_NO </th>
				<td> <input class="createInput" type="text" name="p_no" value="${wfmid.p_no}" autocomplete="off" style="font-size:10px;"> </td>
			</tr>
			
			<tr>
				<th class="createSubject" scope="col"> GUBUN </th>
				<td> <input class="createInput" type="text" name="gubun" value="${wfmid.gubun}" autocomplete="off" style="font-size:10px;"> </td>
			</tr>
			
			<tr>
				<th class="createSubject" scope="col"> </th>
				<td></td>
			</tr>
			
			<tr>
				<th class="createSubject" scope="col"> </th>
				<td></td>
			</tr>	
		</table>
		</div>
		<!-- 밑에 비고란 -->
		<div class="tableContainerBottom">
		<table style="font-size:14px; width:100%;">
			<tr>
				<th class="createSubject" scope="col"> DESCRIPTION </th>
				<td><textarea cols="70" rows="3" name="description" autocomplete="off" style="font-size:10px;"><c:out value="${wfmid.description}"></c:out></textarea> </td>
			</tr>			
		</table>
		</div>
		<!-- 버튼 부분 -->
		<div class="createBtn">
			<input class="btn btn-outline-dark" type="submit" value="수정">
			<input class="btn btn-outline-dark" type="button" value="닫기" onClick="buttion_click('close');">
		</div>
	</div>
	</form>
	</c:forEach>

</body>
</html>