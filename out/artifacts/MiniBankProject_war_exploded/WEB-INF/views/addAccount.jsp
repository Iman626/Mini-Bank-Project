<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Add Account</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<div class="container">
<div class="form-group">
<form action="addAccount" method="post">
	<div class="form-group">
		<label>First name :</label><br>
		<div class="col-sm-5"><input type="text" class="form-control" name="fname"></div><br>
	</div>
	<div class="form-group">
		<label>Last name :</label><br>
		<div class="col-sm-5"><input type="text" class="form-control" name="lname"></div><br>
	</div>
	<div class="form-group">
		<label>Birth Date :</label><br>
		<div class="col-sm-5"><input type="text" class="form-control" name="bdate"></div><br>
	</div>
	<div class="form-group">
		<label>IIN :</label><br>
		<div class="col-sm-5"><input type="text" class="form-control" name="iin"></div><br>
	</div>
	<div class="form-group">
	<label>Currency :</label><br>
		<div class="col-sm-5"><select class="form-control" name="currency">
			<c:forEach items="${currencies}" var="cur">
				<option value="${cur.id}">${cur.short_name}</option>
			</c:forEach>
		</select></div>
	</div><br>
	<div class="form-group">
	<label>Installment :</label><input type="text" name="amount"><br>
	</div>

		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
	<button type="submit" class="btn btn-primary">Create account</button>
</form>
</div>

<form class="col-4" action="managerPage" method="get">
	<button type="submit" class="btn btn-primary">Go back</button>
</form>
</div>
</body>
</html>
