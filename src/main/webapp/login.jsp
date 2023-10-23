<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Shopping cart login</title>
<%@include file="includes/head.jsp"%>
</head>
<body>

	<div class="container">
		<div class="card w-50 mx-auto my-5">
			<div class="card-header text-center">User Login</div>
			<div class="card-body">
				<form action="" method="post">
					<div class="form-group">
						<label>Email Address</label> <input type="email"
							class="form-group" name="login-email"
							placeholder="Enter Your Email" required="required">
					</div>
					<div class="form-group">
						<label>Password</label> <input type="password"
							class="form-group" name="login-password"
							placeholder="**********" required="required">
					</div>
					<div class="form-group">
					<button type="submit" class="btn btn-primary">Login</button>
					</div>
				</form>
			</div>
		</div>
	</div>
	<%@include file="includes/head.jsp"%>
</body>
</html>