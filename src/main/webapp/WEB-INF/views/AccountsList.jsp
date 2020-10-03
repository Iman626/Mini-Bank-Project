<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Account List</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<table class="table table-condensed">
		<tr>
			<th>Last name</th>
			<th>First Name</th>
			<th>IIN</th>
			<th>Balance</th>
			<th></th>
			<th></th>
		</tr>
		<c:forEach items="${accountsList}" var="account">
			<tr>
				<td>${account.last_name}</td>
				<td>${account.first_name}</td>
				<td>${account.iin_number}</td>
				<td>${account.amount} ${account.currency_id.short_name}</td>
				<td>
					<form action="seeAccountHistory" method="get">
						<input type="hidden" name="id" value="${account.id}"/>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<button type="submit" class="btn btn-primary">History</button>
					</form>
				</td>
				<td>
					<form action="userOperation" method="post">
						<select class="form-control" name="operation">
							<c:forEach items="${operationsList}" var="op">
								<option value="${op.id}">${op.name}</option>
							</c:forEach>
						</select>
						<input type="hidden" name="id" value="${account.id}"/>
						<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
						<button type="submit" class="btn btn-primary">Operations</button>
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
</div>

<form class="col-4" action="managerPage" method="get">
	<button type="submit" class="btn btn-primary">Go back</button>
</form>

</body>
</html>
