<%@ page import="com.myspring.entities.Accounts" %>
<%@ page import="java.util.ArrayList" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Money Transfer</title>
	<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
	<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.3.1/jquery.min.js"></script>
	<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
	<script>
        function validateForm() {
            var x = document.forms["myForm"]["value"].value;
            if (x > ${account.amount}) {
                alert("Value exceed account's balance");
                return false;
            } else if (x >= 1 && x <= ${account.amount}){
                return true;
            } else {
                alert("Incorrect input");
                return false;
            }
        }
	</script>
</head>
<body>

<div>
	<form name="myForm" action="transferOperation" onsubmit="return validateForm()" method="post">
		<Balance: ${account.amount} ${account.currency_id.short_name}<br>
		Inerts user's IIN: <input type="text" name="targetIin" list="accounts"><p style="color: red">${error}</p>
		<datalist id="accounts">
			<c:forEach items="${accountsList}" var="account">
				<option value="${account.iin_number}">${account.last_name} ${account.first_name}</option>
			</c:forEach>
		</datalist>
		Value: <input type="text" name="value">${account.currency_id.short_name}
		<input type="hidden" name="id" value="${account.id}"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>

<form class="col-4" action="accountsListPage" method="get">
	<button type="submit" class="btn btn-primary">Go back</button>
</form>

</body>
</html>
