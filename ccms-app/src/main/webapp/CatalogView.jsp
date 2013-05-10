<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/security/tags" prefix="sec"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Content Items</title>
</head>
<body>
	<a href="j_spring_security_logout">Logout: <sec:authentication property="principal.username" /></a>
		<h1>Content items from cloud</h1>

		<table id="CI Report">
			<tr>
				<th>Row</th>
				<th>Cloud Name</th>
				<th>Org Name</th>
				<th>Catalog Name</th>
				<th>vApp Name</th>
				<th>Owner</th>
				<th>Deploy Count</th>
			</tr>
			<c:forEach items="${catalogItems}" var="catalogItem" varStatus="row">
				<tr>
					<td>${row.count}</td>
					<td>${catalogItem.cloudname}</td>
					<td>${catalogItem.orgname}</td>
					<td>${catalogItem.catalogname}</td>
					<td>${catalogItem.vappname}</td>
					<td>${catalogItem.itemowner}</td>
					<td>${catalogItem.deploycount}</td>
					<td>
						<form action="deploy.html" method="post">
							<input name="vAppName" value="${catalogItem.vappname}"
								type="hidden"> <input type="submit" value="Deploy">
						</form>
					</td>
				</tr>
			</c:forEach>

		</table>
</body>
</html>