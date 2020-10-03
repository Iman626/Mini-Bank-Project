<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Exchange</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">

<form action="exchangeOperation" method="post">
	<c:forEach items="${currencies}" var="cur">
		<c:if test="${cur.id == account.currency_id.id}">
			<input name="newCurrencyId" type="radio" value="${cur.id}" checked>${cur.short_name}
			<input type="hidden" name="currentCurrencyId" value="${cur.id}"/>
		</c:if>
		<c:if test="${cur.id != account.currency_id.id}">
			<input name="newCurrencyId" type="radio" value="${cur.id}">${cur.short_name}
		</c:if>
	</c:forEach>
	<input type="hidden" name="id" value="${account.id}"/>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<button type="submit" class="btn btn-primary">Confirm</button>
</form>
</div>
</body>
</body>
</html>
