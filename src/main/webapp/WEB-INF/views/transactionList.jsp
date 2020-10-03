<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Transaction List</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<table class="table table-condensed">
		<tr>
			<th>Manager</th>
			<th>From</th>
			<th>To</th>
			<th>Operation</th>
			<th>Value</th>
			<th>Date</th>
		</tr>
		<c:forEach items="${transactionList}" var="list">
			<tr>
				<td>${list.manager_id.full_name}</td>
				<td>${list.sender_account_id.last_name} ${list.sender_account_id.first_name}</td>
				<td>${list.receiver_account_id.last_name} ${list.receiver_account_id.first_name}</td>
				<td>${list.operation_id.name}</td>
				<td>${list.amount}</td>
				<td>${list.operation_time}</td>
			</tr>
		</c:forEach>
	</table>

	<%
		int role = (int) request.getAttribute("role");
		if (role == 1) {
	%>
	<form action="admin" method="get">
		<button type="submit">Go back</button>
	</form>
	<%
	} else {
	%>
	<form action="managerPage" method="get">
		<button type="submit">Go back</button>
	</form>
	<%
		}
	%>

</div>
</body>
</html>
