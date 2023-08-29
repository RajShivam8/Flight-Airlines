<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Create</title>
</head>
<body>
<h2>Create New Account</h2>
<form action="saveReg" method="post">
FirstName<input type="text" name="firstName"/><br>
LastName<input type="text" name="lastName"/><br>
Email<input type="text" name="email"/><br>
Password<input type="password" name="password"/><br>
<input type="submit" value="save"/>
</form>

</body>
</html>