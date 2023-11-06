<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="utf-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>EditSanPham</title>

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
	<script type="text/javascript" src="https://code.jquery.com/jquery-3.6.0.min.js"></script>
	        <style type="text/css">
        .error{
            color: red;
        }
        </style>
</head>

<body class="hold-transition sidebar-mini layout-fixed">
	<div class="wrapper">

		<jsp:include page="/WEB-INF/views/common/admin/aside.jsp" />

		<div class="content-wrapper">
			<div class="content-header">
				<div class="container-fluid">
					<div class="row mb-2">
						<div class="col-sm-6">
							<h1 class="m-0">Sản Phẩm</h1>
						</div>
					</div>
				</div>
			</div>

			<section class="content">
				<div class="tab-pane fade show active">
					<form:form action="/managerproduct/checkedit"
						modelAttribute="LISTPRODUCT" method="post"
						enctype="multipart/form-data">
						<div class="card">
							<div class="card-body">
								<div class="row">
									<div class="col">
										<div class="form-group">
											<label for="productId">Product ID</label>
											<form:input type="text" path="productid" class="form-control"
												placeholder="Product ID" />
										</div>
										<div class="form-group">
											<label for="name">Name</label>
											<form:input type="text" path="name" class="form-control"
												placeholder="Name " />
										</div>
										<div class="form-group">
											<label for="quantity">Quantity</label>
											<form:input type="number" path="qty" class="form-control"
												placeholder="Quantity" />
										</div>
										<div class="form-group">
											<label for="Price">Price</label>
											<form:input type="number" path="price" class="form-control"
												placeholder="Unit Price" />
										</div>
										<div class="form-group">
											<label for="categoryId">Category </label>
											<form:select class="form-control" path="category"
												id="categoryid">
												<c:forEach items="${catetorys}" var="item">
													<form:option value="${item.categoryid}"> ${item.categoryname}</form:option>
												</c:forEach>
											</form:select>
										</div>
									</div>
									<div class="col">
										<script>
											function chooseFile(fileInput) {
												if (fileInput.files && fileInput.files[0]) {
													var reader = new FileReader();
													reader.onload = function(e){
														$('#image').attr('src',e.target.result);
														}
													reader.readAsDataURL(fileInput.files[0]);
												}
											}  
										</script>
										<div class="form-group" style="text-align: center;">
											<img id="image" src="${product.image != null ? '/managerproduct/images/' + product.image : '/images/img1/kinhkimloai-2215.png'}"
												width="300px" class="img-fluid" alt="">
										</div>

										<div class="form-group">
											<label>Image File</label> 
											<input type="file"
												class="form-control-file" name="photo"
												accept="image/png, image/jpeg" onchange="chooseFile(this)">
											<p class="error">${ERROR_PHOTO }</p>
										</div>
										<div class="input-group form-group">
											<span class="input-group-text">Discount</span>
											<form:input type="number" class="form-control"
												path="discount" placeholder="Discount" />
											<span class="input-group-text">%</span>
										</div>
									</div>
								</div>
								<div class="row">
									<div class="col">
										<div class="form-group">
											<label for="description">Description</label>
											<form:textarea class="form-control" path="description"></form:textarea>
										</div>
									</div>
								</div>
								<div class="card-footer text-muted">
									<form:button type="submit" class="btn btn-primary mass">Submit</form:button>
									<a href="/managerproduct/editproduct" class="btn btn-primary">clear</a>
									<a href="/managerproduct/listproduct/page"
										class="btn btn-primary">Display Product</a>
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