<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
	
<html lang="en">

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="/templates/css/bootstrap.min.css">
<link rel="stylesheet" href="/templates/css/all.min.css">
<link rel="stylesheet" href="/templates/css/templatemo-style.css">
<link rel="stylesheet" href="/templates/css/styde1.css">
<link rel="stylesheet" href="/templates/css/styde.css">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<style type="text/css">
.error {
	color: red;
}
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/sites/header.jsp" />


	<br>
	<main class="container">
		<div class="row">
			<div class="offset-4 col-4">
				<form:form action="/customer/registersubmic"
					modelAttribute="CUSTOMER" method="post">
					<div class="card">
						<div class="card-header">
							<b>ĐĂNG KÍ</b>
						</div>
						<div class="card-body">
							<div class="form-group">
								<form:input type="text" class="form-control" path="customername"
									placeholder="Username" />
								<form:errors path="customername" cssClass="error"></form:errors>
							</div>
							<div class="form-group">
								<form:input type="text" class="form-control" path="fullname"
									placeholder="Fullname" />
								<form:errors path="fullname" cssClass="error"></form:errors>
							</div>
							<div class="form-group">
								<form:input type="password" class="form-control" path="password"
									placeholder="Pasword" />
								<form:errors path="password" cssClass="error"></form:errors>
							</div>

							<div class="form-group">
								<form:input type="text" class="form-control" path="email"
									placeholder="Email" />
								<form:errors path="email" cssClass="error"></form:errors>
							</div>
							<div class="form-group">
								<form:input type="text" class="form-control" path="phone"
									placeholder="Phone" />
								<form:errors path="phone" cssClass="error"></form:errors>
							</div>
						</div>
						<div class="card-footer text-muted"
							style="width: 100%; background-color: #28303e; text-align: center;">
							<button type="submit" class="btn "
								style="color: white; background-color: #28303e; padding: 0%;">ĐĂNG
								KÍ</button>
						</div>
						<div class="card-footer">
							<div class="d-flex justify-content-center links ">
								<a href="/customer/login">Quay về</a>
							</div>
						</div>
					</div>
				</form:form>


			</div>
		</div>
	</main>
	<br>
	<br>


	<jsp:include page="/WEB-INF/views/common/sites/footer.jsp" />
	<!-- Optional JavaScript -->
	<!-- jQuery first, then Popper.js, then Bootstrap JS -->
	<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
		integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.7/umd/popper.min.js"
		integrity="sha384-UO2eT0CpHqdSJQ6hJty5KVphtPhzWj9WO1clHTMGa3JDZwrnQq4sF86dIHNDz0W1"
		crossorigin="anonymous"></script>
	<script
		src="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/js/bootstrap.min.js"
		integrity="sha384-JjSmVgyd0p3pXB1rRibZUAYoIIy6OrQ6VrjIEaFf/nJGzIxFDsf4x0xIM+B07jRM"
		crossorigin="anonymous"></script>
</body>

</html>
