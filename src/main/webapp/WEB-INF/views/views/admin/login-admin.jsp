<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<! DOCTYPE html>
<html lang="en">
<head>
<meta charset="UTF-8">
<title></title>
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css">
</head>

<body>
	<div class="pt-5">
		<h1 class="text-center">ĐĂNG NHẬP</h1>
		<div class="container">
			<div class="row">
				<div class="col-md-5 mx-auto">
					<div class="card card-body"
						style="background-color: rgb(247, 242, 242);">
						<form action="/manageraccount/checklogin" modelAttribute="ACCOUNT"
							method="post">
							<div class="form-group required">
								<label for="username">Username</label> <input type="text"
									class="form-control text-lowercase" path="username"
									name="username" placeholder="username">
							</div>
							<div class="form-group required">
								<label class="d-flex flex-row align-items-center" for="password">Password
								</label> <input type="password" class="form-control" path="password"
									name="password" placeholder="password">
								<p class="error" style="margin-top: 5px; color: red;">${error}</p>
							</div>
							<div class="form-group pt-1">
								<button class="btn btn-primary btn-block" type="submit">Log
									In</button>
							</div>
						</form>
					</div>
				</div>
			</div>
		</div>
	</div>
</body>

</html>