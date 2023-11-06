<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="/customer/checklogin" modelAttribute="CUSTOMER"
	method="post">
	<nav class="navbar navbar-expand-lg">
		<div class="container-fluid">
			<a class="navbar-brand" href="#" style="font-size: 35px;"> <i
				class="fas mr-2"></i> LILY-EYEWEAR
			</a>
			<button class="navbar-toggler" type="button" data-toggle="collapse"
				data-target="#navbarSupportedContent"
				aria-controls="navbarSupportedContent" aria-expanded="false"
				aria-label="Toggle navigation">
				<i class="fas fa-bars"></i>
			</button>
			<div class="collapse navbar-collapse" id="navbarSupportedContent">
				<ul class="navbar-nav ml-auto mb-2 mb-lg-0">
					<li class="nav-item"><a class="nav-link nav-link-1 active"
						href="/home/cart">GIỎ HÀNG</a></li>
					<c:if test="${isLogin}">

						<li class="nav-item"><a class="nav-link nav-link-2 "
							aria-current="page" href="/customer/login">LOGIN</a></li>
					</c:if>
					<c:if test="${!isLogin}">
						<li class="nav-item"><a class="nav-link nav-link-2 "
							aria-current="page" href="#">${CUSTOMERNAME }</a></li>
						<li class="nav-item"><a class="nav-link nav-link-2 "
							aria-current="page" href="/customer/logout">LOGOUT</a></li>
					</c:if>
					
				</ul>
			</div>
		</div>
	</nav>
</form:form>
<div class="container-fluid">
	<nav class="navbar navbar-expand-lg navbar-light bg-light"
		style="padding-left: 280px;">
		<div class="collapse navbar-collapse" id="navbarNavDropdown">
			<ul class="navbar-nav">
				<li class="nav-item active"><a class="nav-link" href="/home/index"
					style="color: black;">HOME <span class="sr-only">(current)</span></a>
				</li>
				<li class="nav-item"><a class="nav-link" href="#"
					style="color: black;">GIỚI THIỆU</a></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false" style="color: black;">
						SẢN PHẨM </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="/home/allproduct">TẤT CẢ SẢN PHẨM</a> <a
							class="dropdown-item" href="#">KÍNH GỌNG KIM LOẠI</a> <a
							class="dropdown-item" href="#">KÍNH GỌNG NHỰA CỨNG</a> <a
							class="dropdown-item" href="#">KÍNH GỌNG NHỰA MỀM</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false" style="color: black;">
						DỊCH VỤ </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="#">KÍNH GỌNG KIM LOẠI</a> <a
							class="dropdown-item" href="#">KÍNH GỌNG NHỰA CỨNG</a> <a
							class="dropdown-item" href="#">KÍNH GỌNG NHỰA MỀM</a>
					</div></li>
				<li class="nav-item dropdown"><a
					class="nav-link dropdown-toggle" href="#"
					id="navbarDropdownMenuLink" data-toggle="dropdown"
					aria-haspopup="true" aria-expanded="false" style="color: black;">
						GÓC LILY </a>
					<div class="dropdown-menu" aria-labelledby="navbarDropdownMenuLink">
						<a class="dropdown-item" href="#">KÍNH GỌNG KIM LOẠI</a> <a
							class="dropdown-item" href="#">KÍNH GỌNG NHỰA CỨNG</a> <a
							class="dropdown-item" href="#">KÍNH GỌNG NHỰA MỀM</a>
					</div></li>
				<li class="nav-item"><a class="nav-link" href="#"
					style="color: black;">BLOG</a></li>
				<li class="nav-item"><a class="nav-link" href="#"
					style="color: black;">LIÊN HỆ</a></li>
			</ul>
		</div>
	</nav>
</div>

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