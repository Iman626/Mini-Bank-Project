<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Currency</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<c:forEach items="${curList}" var="list">

		<form action="editCurrencies" method="post">
			${list.currency_id.short_name}
				
				
                <label>Purchase :</label><input type="text"  name="buy" value="${list.purchase_value}">
                <label>Sale :</label><input type="text" name="sale" value="${list.sale_value}">
			
					<input type="hidden" name="id" value="${list.id}"/>
					<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
					<button class="btn btn-primary" type="submit">Confirm</button>
			
		</form>
	</c:forEach>

	<form action="admin" method="get">
		<button type="submit" class="btn btn-primary">Go back</button>
	</form>
</div>

</body>
</html>
