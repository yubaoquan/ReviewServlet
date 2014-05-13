<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<script type="text/javascript" src="../script/script1.js"></script>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/mainRoom.css">
<title>多人聊天室</title>
<%if (session.getAttribute("user") == null){
	response.sendRedirect("login.jsp");
} %>
</head>
<body onload="refreshMsg()">

	<div id="page-container">
		
		<%@include file="header.jsp"%>
		<%@include file="mainNavigator.jsp"%>
		<%@include file="sidebar.jsp"%>
		<%@include file="content.jsp"%>
		<%@include file="footer.jsp"%>
	</div>

</body>
</html>