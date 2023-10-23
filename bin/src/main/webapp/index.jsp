<%@page import="src.main.java.com.connection.DbConnection"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shoping Cart App</title>
<%@ include file="includes/head.jsp"%>
<%@ include file="includes/nav.jsp"%>
</head>
<body>

	<%= DbConnection.getConnection() %>

<%@ include file="includes/footer.jsp"%>
</body>
</html>