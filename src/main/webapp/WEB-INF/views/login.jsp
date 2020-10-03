<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head><title>Login</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div >
	<form action="/login" method="post">
		<label>Login :</label><br>
		<div class="col-sm-5"><input type="login" class="form-control" name="login_parameter"></div><br><br>
        <label>Password :</label><br>
		<div class="col-sm-5"><input type="password" class="form-control"  name="password_parameter"></div><br><br>
		<input class="btn btn-primary" type="submit" value="Sign In">
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	</form>
</div>
</div>
</body>
</html>