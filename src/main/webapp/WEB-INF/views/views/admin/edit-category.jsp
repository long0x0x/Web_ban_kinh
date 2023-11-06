<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>EditLoaiSanPham</title>

<link rel="stylesheet"
	href="https://fonts.googleapis.com/css?family=Source+Sans+Pro:300,400,400i,700&display=fallback">
<link rel="stylesheet" href="/templates/css/all.min.css">
<link rel="stylesheet" href="/templates/css/adminlte.min.css">
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">
<link rel="stylesheet"
	href="https://cdn.jsdelivr.net/npm/bootstrap-icons@1.10.5/font/bootstrap-icons.css">
</head>

<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<jsp:include page="/WEB-INF/views/common/admin/aside.jsp" />

		<div class="content-wrapper">
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">Loại Sản Phẩm</h1>
						</div>
					</div>
				</div>
			</div>

			<section class="content">
				<div class="tab-pane fade show active">
					<form:form action="/managercategory/checkedit"
						modelAttribute="LISTCATEGORY" method="post">
						<div class="card">
							<div class="card-body">
								<div class="row">
									<div class="col">
										<div class="form-group">
											<label for="categoryid">Category Id</label>
											<form:input type="text" class="form-control"
												path="categoryid" placeholder="Category Id" />
											<form:errors path="categoryid" cssClass="error"></form:errors>
										</div>
										<div class="form-group">
											<label for="categoryname">Category Name</label>
											<form:input type="text" class="form-control"
												path="categoryname" placeholder="Category Name" />
											<form:errors path="categoryname" cssClass="error"></form:errors>
										</div>
									</div>
								</div>
								<div class="card-footer text-muted">
									<form:button type="submit" class="btn btn-primary mass">Submit</form:button>
									<a href="/managercategory/editcategory" class="btn btn-primary">clear</a>
									<a href="/managercategory/listcategory/page"
										class="btn btn-primary">Display Category</a>
								</div>
							</div>
						</div>
					</form:form>
				</div>
			</section>
		</div>

	</div>
</body>

</html>