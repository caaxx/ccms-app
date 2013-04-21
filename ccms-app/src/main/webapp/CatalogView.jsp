<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Content Items</title>
</head>
<body>
	<h1>Content items from cloud</h1>
	<c:forEach items="${contentItems}" var="contentItem" varStatus="row">
		${row.count} - ${contentItem} <br>
	</c:forEach>
</body>
</html>