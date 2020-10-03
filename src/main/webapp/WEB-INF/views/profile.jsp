<%@ page import="com.myspring.entities.Users" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Profile</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<%
	Users user = (Users) request.getAttribute("user");
%>

<h1>PROFILE PAGE OF <%=user.getFull_name() %></h1><br>
<a href="/admin" class="btn btn-primary">ADMIN PAGE</a>
<a href="/managerPage" class="btn btn-primary">MANAGER PAGE</a>

<form action="/logout" method="post">
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<input type="submit" class="btn btn-primary" value="LOGOUT">
</form>

</body>
</html>