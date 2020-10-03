<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Admin Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<div>
		<c:forEach items="${balance}" var="balance">
			${balance.value}
			${balance.currency.short_name}
		</c:forEach>
	</div>

	<a href="addManagerPage" class="btn btn-primary">Add new manager</a><br><br>
	<a href="transactionListPage" class="btn btn-primary">List of transactions</a><br><br>
	<a href="currencyPage" class="btn btn-primary">Change currency</a><br><br>

	<form action="/logout" method="post">
		<input type="hidden"  name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<input type="submit" class="btn btn-primary" value="Logout">
	</form>
</div>
</body>
</html>
