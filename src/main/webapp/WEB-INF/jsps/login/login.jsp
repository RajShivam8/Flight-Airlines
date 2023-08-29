<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<h2>Login Here</h2>
<form action = "verifyLogin" method = "post">
EmailId<input type="text" name="emailId"/><br>
Password<input type="password" name="password"/><br>
<h2><input type="submit" value="login"/></h2>
</form>
${error}
</body>
</html>