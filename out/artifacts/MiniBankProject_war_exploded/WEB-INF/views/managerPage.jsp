<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Manager Page</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
	<a href="addAccountPage" class="btn btn-primary">Add account</a><br>
	<a href="accountsListPage" class="btn btn-primary">Accounts</a><br>
	<a href="seeManagerHistory" class="btn btn-primary">Transaction history</a><br>

<form class="col-4" action="profile" method="get">
	<button type="submit" class="btn btn-primary">Main page</button>
</form>
</div>
</body>
</html>
