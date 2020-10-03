<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
	<title>Credit</title>
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
<div class="container">
<div>
	<form name="myForm" action="creditOperation" onsubmit="return validateForm()" method="post">
		<label>Balance :</label>${account.amount} ${account.currency_id.short_name}<br>
		<label>Value :</label><input type="text" name="value">${account.currency_id.short_name}
		<input type="hidden" name="id" value="${account.id}"/>
		<input type="hidden" name="${_csrf.parameterName}" value="${_csrf.token}"/>
		<button type="submit" class="btn btn-primary">Submit</button>
	</form>
</div>

<form class="col-4" action="accountsListPage" method="get">
	<button type="submit" class="btn btn-primary">Go back</button>
</form>
</div>
</body>
</html>
