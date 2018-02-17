<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Login Page</title>
<link rel="stylesheet" href="assets/css/bootstrap.min.css">
<link rel="stylesheet" href="assets/css/style.css">
</head>
<body>

<div id="loginbox" class="jumbotron">
<p>Account Login</p>
<div class="form-group">
<form action="processLogin.jsp" method="POST">

<label>Username</label>
<input type="text" class="form-control" placeholder="Username" value="">
<label>Password</label>
<input type="password" class="form-control" placeholder="Password" value="" >
</form>
<button class="btn btn-primary loginbtn"><a href="login.jsp">Login</a></button>
</div>

</div>

</body>
</html>