<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="common.*, java.util.List" %>
<%
	String oid = request.getParameter("OID");
%>    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>Insert title here</title>
</head>
<body>
<h3>파일업로드</h3>
<form name="uploadFile" method="post" enctype="multipart/form-data" action="/yura/ma/upload_result.jsp?oid=<%=oid%>">
파일 1 : <input type="file" name="file1"><br>
파일 1 : <input type="file" name="file2"><br>
<input type="hidden" name="oid" value="<%=oid%>">
<input type="submit" value="업로드">
</form>
</body>
</html>