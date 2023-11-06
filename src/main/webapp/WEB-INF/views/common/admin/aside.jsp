<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>

<form:form action="/manageraccount/checklogin"
	modelAttribute="ACCOUNT" method="post">
	<aside class="main-sidebar sidebar-dark-primary elevation-4">
		<a href="#" class="brand-link"> <img
			src="/images/img1/AdminLTELogo.png" alt="AdminLTE Logo"
			class="brand-image img-circle elevation-3" style="opacity: .8">
			<p class="brand-text font-weight-light">
				<label>${USERNAME }</label>
			</p>
		</a>
		<div class="sidebar">
			<nav class="mt-2">
				<ul class="nav nav-pills nav-sidebar flex-column"
					data-widget="treeview" role="menu" data-accordion="false">
					<li class="nav-item menu-open"><a href="#"
						class="nav-link active" style="text-align: center;"> <i
							class="nav-icon"></i>
							<p>QUẢN LÍ NGƯỜI DÙNG</p>
					</a>
						<ul class="nav nav-treeview">
							<li class="nav-item"><a
								href="/manageraccount/listaccount/page" class="nav-link"> <i
									class="far fa-circle nav-icon"></i>
									<p>Danh sách người dùng</p>
							</a></li>
							<li class="nav-item"><a
								href="/managercustomer/listcustomer/page" class="nav-link">
									<i class="far fa-circle nav-icon"></i>
									<p>Danh Sách Khách Hàng</p>
							</a></li>
						</ul></li>
					<li class="nav-item menu-open"><a href="#"
						class="nav-link active"
						style="border-bottom: 1px solid #4b545c; text-align: center;">
							<i class="nav-icon"></i>
							<p>QUẢN LÍ SẢN PHẨM</p>
					</a>
						<ul class="nav nav-treeview">
							<li class="nav-item"><a
								href="/managerproduct/listproduct/page" class="nav-link "> <i
									class="far fa-circle nav-icon"></i>
									<p>Danh sách sản phẩm</p>
							</a></li>
							<li class="nav-item"><a
								href="/managercategory/listcategory/page" class="nav-link ">
									<i class="far fa-circle nav-icon"></i>
									<p>Loại sản phẩm</p>
							</a></li>
							<li class="nav-item"><a href="/managerproduct/editproduct"
								class="nav-link"> <i class="far fa-circle nav-icon"></i>
									<p>Thêm và chỉnh sửa</p>
							</a></li>
						</ul></li>
					<li class="nav-item menu-open"><a href="#"
						class="nav-link active"
						style="border-bottom: 1px solid #4b545c; text-align: center;">
							<i class="nav-icon"></i>
							<p>THỐNG KÊ</p>
					</a>
						<ul class="nav nav-treeview">
							<li class="nav-item"><a href="ThongkeHangBanDuoc.html"
								class="nav-link "> <i class="far fa-circle nav-icon"></i>
									<p>Thống kê hàng đã bán</p>
							</a></li>
							<li class="nav-item"><a href="ThongkeHangTonKho.html"
								class="nav-link"> <i class="far fa-circle nav-icon"></i>
									<p>Thống kê hàng tồn kho</p>
							</a></li>
						</ul></li>
					<li style="margin-top: 180px; margin-left: 50px;"><a
						class="nav-link nav-icon bi bi-box-arrow-right"
						href="/manageraccount/logout">Sign out</a></li>
				</ul>
			</nav>
		</div>
	</aside>
</form:form>