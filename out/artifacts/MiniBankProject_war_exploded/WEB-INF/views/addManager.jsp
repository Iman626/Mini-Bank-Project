<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Add Manager</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>

<div class="container">
<form action="addManager" method="post">
	<label class="control-label col-sm-2">Login :</label>
	<div class="col-sm-10"><input class="form-control" type="text" name="login"></div><br>
	<label class="control-label col-sm-2">Password :</label>
	<div class="col-sm-10"><input class="form-control" type="text" name="password"></div><br>
	<label class="control-label col-sm-2">Full name :</label>
	<div class="col-sm-10"><input class="form-control" type="text" name="fullName"></div><br>
	<button class="btn btn-primary" type="submit">Create manager</button>
	<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
</form>

<form action="admin" method="get">
	<button class="btn btn-primary" type="submit">Go back</button>
</form>
</div>

</body>
</html>
