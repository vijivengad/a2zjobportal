<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Login</title>
</head>
<body>
<body>
	<h1>Login Page</h1>
	<p style="color: red;">${errorMessage}</p>
	<a href="${pageContext.request.contextPath}/showRegistration">Register Here</a>
	<form action="${pageContext.request.contextPath}/loginMember" method="post">
		<div>
			<label>Name: </label>
			<input name="name" />
		</div>
		<div>
			<label>Password: </label>
			<input name="password" />
		</div>
		<div>
			<input type="submit" value="Login" />
		</div>
	</form>
</body>
</body>
</html>