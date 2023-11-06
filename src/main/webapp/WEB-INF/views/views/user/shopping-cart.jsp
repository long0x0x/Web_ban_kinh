<%@ page language="java" contentType="text/html;  charset=UTF-8"
	pageEncoding="UTF-8"%>
<html>

<head>
<title>Title</title>
<!-- Required meta tags -->
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1, shrink-to-fit=no">

<link rel="stylesheet" href="/templates/css/bootstrap.min.css">
<link rel="stylesheet" href="/templates/css/all.min.css">
<link rel="stylesheet" href="/templates/css/templatemo-style.css">
<link rel="stylesheet" href="/templates/css/styde.css">
<link rel="stylesheet" href="/templates/css/styde1.css">


<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">
<!-- Bootstrap CSS -->
<link rel="stylesheet"
	href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css"
	integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T"
	crossorigin="anonymous">

<style>
</style>
</head>
<body>
	<jsp:include page="/WEB-INF/views/common/sites/header.jsp" />

	<br>
	<main>
        <section id="cart">
            <div class="container">
                <div class="row" id="cart">
                    <div class="col-lg-8 col-md-8 col-sm-12 col-xs-12 pd5">
                        <h1 class="title-head-cart">Giỏ hàng</h1>
                        <form action="#" method="post" id="cartform">
                            <div class="clearfix overflow-cart">
                                <table id="table-cart">
                                    <thead>
                                        <tr>
                                            <th class="image"></th>
                                            <th class="item"></th>
                                            <th class="remove"></th>
                                        </tr>
                                    </thead>
                                    <tbody>
                                        <tr class="line-item-container" data-variant-id="1107159336" style="position: relative;">
                                            <td class="image">
                                                <a href="#">
                                                    <img src="/images/img1/kinhkimloai-2215.png" alt="">
                                                </a>
                                            </td>
                                            <td class="item" style="text-align:left; max-width:300px;">
                                                <p>KÍNH KIM LOẠI 08920</p>
                                                <p class="pri-pi"> ₫125,000  </p>
                                                <div class="qty qty-click quantity-partent">
                                                    <input type="text" size="4" name="qty" min="1" id="updates_1107159336" 
                                                        data-price="12500000" value="1" class="tc line-item-qty item-quantity">
                                                </div>
                                                <p class="price line-item-total">₫250,000</p>
                                            </td>
                                            <td class="remove">
                                                <a href="#" class="cart"> Xóa sản phẩm </a>
                                            </td>
                                        </tr>
                                    </tbody>
                                </table>
                            </div>
                            <div class="clearfix">
                                <a class="continue-shopping" title="TIẾP TỤC MUA SẢN PHẨM KHÁC" href="/home/allproduct">TIẾP TỤC MUA SẢN PHẨM KHÁC</a>
                                <button class="update-cart" type="hide" name="submit">Cập nhật giỏ hàng</button>
                            </div>
                        </form>
                    </div>
                    <div class="col-lg-4 col-md-4 col-sm-12 col-xs-12 pd5">
                        <h2 class="title-head-cart">Đơn hàng</h2>
                        <div class="right-cart">
                            <h2>
                                <label>Tổng tiền</label>
                                <label class="total-price">₫250,000</label>
                            </h2>
                            <a class="checkout" href="#">Thanh toán </a>
                        </div>
                    </div>
                </div>
            </div>
        </section>
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
<style>
    a.continue-shopping {
    border: 0px;
    background: #333;
    color: #fff;
    padding: 8px 25px;
    position: relative;
    float: left;
    margin: 20px 15px 0px 0px;
    text-decoration: none;
}
    .mora{
        color: #1c2632;
        margin-left: 15px;
    }
    .ewhe{
        color: #1c2632;
            margin-top: 80px;
        margin-left: 100px;
    }
#table-cart{
    margin-bottom: 30px;
    color: #333;
    width: 100%;
    max-width: 100%;
    float: left;
}
table#table-cart tr td.image {
    padding: 20px 0;
    border-top: 0;
    vertical-align: top;
    text-align: center;
    width: 110px;
    border-right: 0;
    border-left: 0;
}
#table-cart td{
    border: 1px solid #ccc;
}
#table-cart td.item .price {
    margin-top: 5px;
    float: right;
    font-size: 16px;
    font-weight: 600;
    text-align: right;
}
#table-cart td span {
    width: 100%;
    float: left;
}
#table-cart td.item a span {
    margin-bottom: 5px;
}
.qty-click input.item-quantity {
    font-weight: 500;
    font-size: 15px;
    height: 25px;
    padding: 0;
    text-align: center;
    width: 35px;
    background: #ededed;
    border: 1px solid #dadbdd;
    border-radius: 0;
    float: left;
}
#table-cart td span {
    width: 100%;
    float: left;
}
#table-cart td.remove {
    position: absolute;
    right: 15px;
    padding: 14px 0;
    border: 0;
}
</style>
</html>
