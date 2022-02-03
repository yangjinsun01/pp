<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="common.*, java.util.*, java.io.*, com.oreilly.servlet.*, com.oreilly.servlet.multipart.*, java.net.URLEncoder" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %> 

<jsp:useBean id="biDao" class="dao.binfoDao"/>
<%
	request.setCharacterEncoding("UTF-8");
	String upload_path="e:/uploadFile";
	int size = 10*1024*1024;
	String oid = URLEncoder.encode(request.getParameter("oid"), "UTF-8");
	MultipartRequest multi = new MultipartRequest(request, upload_path, size, "UTF-8", new DefaultFileRenamePolicy());
	biDao.binfoFileUpload(oid, multi, request);
%>    
