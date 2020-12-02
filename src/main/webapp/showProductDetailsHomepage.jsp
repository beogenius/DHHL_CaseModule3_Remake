<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<link href="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/css/bootstrap.min.css" rel="stylesheet" id="bootstrap-css">
<script src="//maxcdn.bootstrapcdn.com/bootstrap/3.3.0/js/bootstrap.min.js"></script>
<script src="//code.jquery.com/jquery-1.11.1.min.js"></script>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">

    <title>Electro - HTML Ecommerce Template</title>
    <link href="https://maxcdn.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Open+Sans:400,700" rel="stylesheet">
    <!-- Google font -->
    <link href="https://fonts.googleapis.com/css?family=Montserrat:400,500,700" rel="stylesheet">

    <!-- Bootstrap -->
    <link type="text/css" rel="stylesheet" href="css/bootstrap.min.css"/>

    <!-- Slick -->
    <link type="text/css" rel="stylesheet" href="css/slick.css"/>
    <link type="text/css" rel="stylesheet" href="css/slick-theme.css"/>

    <!-- nouislider -->
    <link type="text/css" rel="stylesheet" href="css/nouislider.min.css"/>

    <!-- Font Awesome Icon -->
    <link rel="stylesheet" href="css/font-awesome.min.css">

    <!-- Custom stlylesheet -->
    <link type="text/css" rel="stylesheet" href="css/style.css"/>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>

        /*****************globals*************/
        body {
            font-family: 'open sans';
            overflow-x: hidden; }

        img {
            max-width: 100%; }

        .preview {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-orient: vertical;
            -webkit-box-direction: normal;
            -webkit-flex-direction: column;
            -ms-flex-direction: column;
            flex-direction: column; }
        @media screen and (max-width: 996px) {
            .preview {
                margin-bottom: 20px; } }

        .preview-pic {
            -webkit-box-flex: 1;
            -webkit-flex-grow: 1;
            -ms-flex-positive: 1;
            flex-grow: 1; }

        .preview-thumbnail.nav-tabs {
            border: none;
            margin-top: 15px; }
        .preview-thumbnail.nav-tabs li {
            width: 18%;
            margin-right: 2.5%; }
        .preview-thumbnail.nav-tabs li img {
            max-width: 100%;
            display: block; }
        .preview-thumbnail.nav-tabs li a {
            padding: 0;
            margin: 0; }
        .preview-thumbnail.nav-tabs li:last-of-type {
            margin-right: 0; }

        .tab-content {
            overflow: hidden; }
        .tab-content img {
            width: 100%;
            -webkit-animation-name: opacity;
            animation-name: opacity;
            -webkit-animation-duration: .3s;
            animation-duration: .3s; }

        .card {
            margin-top: 50px;
            background: #eee;
            padding: 3em;
            line-height: 1.5em; }

        @media screen and (min-width: 997px) {
            .wrapper {
                display: -webkit-box;
                display: -webkit-flex;
                display: -ms-flexbox;
                display: flex; } }

        .details {
            display: -webkit-box;
            display: -webkit-flex;
            display: -ms-flexbox;
            display: flex;
            -webkit-box-orient: vertical;
            -webkit-box-direction: normal;
            -webkit-flex-direction: column;
            -ms-flex-direction: column;
            flex-direction: column; }

        .colors {
            -webkit-box-flex: 1;
            -webkit-flex-grow: 1;
            -ms-flex-positive: 1;
            flex-grow: 1; }

        .product-title, .price, .sizes, .colors {
            text-transform: UPPERCASE;
            font-weight: bold; }

        .checked, .price span {
            color: #ff9f1a; }

        .product-title, .rating, .product-description, .price, .vote, .sizes {
            margin-bottom: 15px; }

        .product-title {
            margin-top: 0; }

        .size {
            margin-right: 10px; }
        .size:first-of-type {
            margin-left: 40px; }

        .color {
            display: inline-block;
            vertical-align: middle;
            margin-right: 10px;
            height: 2em;
            width: 2em;
            border-radius: 2px; }
        .color:first-of-type {
            margin-left: 20px; }

        .add-to-cart, .like {
            background: #ff9f1a;
            padding: 1.2em 1.5em;
            border: none;
            text-transform: UPPERCASE;
            font-weight: bold;
            color: #fff;
            -webkit-transition: background .3s ease;
            transition: background .3s ease; }
        .add-to-cart:hover, .like:hover {
            background: #b36800;
            color: #fff; }

        .not-available {
            text-align: center;
            line-height: 2em; }
        .not-available:before {
            font-family: fontawesome;
            content: "\f00d";
            color: #fff; }

        .orange {
            background: #ff9f1a; }

        .green {
            background: #85ad00; }

        .blue {
            background: #0076ad; }

        .tooltip-inner {
            padding: 1.3em; }

        @-webkit-keyframes opacity {
            0% {
                opacity: 0;
                -webkit-transform: scale(3);
                transform: scale(3); }
            100% {
                opacity: 1;
                -webkit-transform: scale(1);
                transform: scale(1); } }

        @keyframes opacity {
            0% {
                opacity: 0;
                -webkit-transform: scale(3);
                transform: scale(3); }
            100% {
                opacity: 1;
                -webkit-transform: scale(1);
                transform: scale(1); } }

        /*# sourceMappingURL=style.css.map */
    </style>
</head>
<body>
<!-- HEADER -->
<header>
    <!-- TOP HEADER -->
    <div id="top-header">
        <div class="container">
            <ul class="header-links pull-left">
                <li><a href="#"><i class="fa fa-phone"></i> +012-34-56-78</a></li>
                <li><a href="#"><i class="fa fa-envelope-o"></i> shopee@email.com</a></li>
                <li><a href="#"><i class="fa fa-map-marker"></i> 2 Ham Nghi Road</a></li>
            </ul>
            <ul class="header-links pull-right">

                <li><a href="logincontroller"><i class="fa fa-user-o"></i> Login</a></li>
                <li><a href="????????????????"><i class="fa fa-user-o"></i>Register</a></li>
            </ul>
        </div>
    </div>
    <!-- /TOP HEADER -->

    <!-- MAIN HEADER -->
    <div id="header">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <!-- LOGO -->
                <div class="col-md-2">
                    <div class="header-logo">
                        <a href="/back-to-home-page" class="logo">
                            <img src="img/shopee.jpg" alt="" width="100px">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-4">
                    <div class="header-search">
                        <form action="/search-products-by-name-homepage">
                            <input class="input" placeholder="Search by name" name="productName">
                            <button type="submit" class="search-btn">Search</button>
                        </form>
                    </div>
                </div>
                <!-- /SEARCH BAR -->

                <!-- SEARCH BAR -->
                <div class="col-md-3">
                    <div class="header-search">
                        <form action="/search-products-by-price-homepage">

                            <select style="width: 100px; height: 40px" name="range">
                                <option value="0,50"><$50</option>
                                <option value="50,500"><$50-$500</option>
                                <option value="500,10000">>$500</option>
                            </select>
                            <button class="search-btn">Search</button>
                        </form>
                    </div>
                </div>
            </div>
            <!-- row -->
        </div>
        <!-- container -->
    </div>
    <!-- /MAIN HEADER -->
</header>
<!-- /HEADER -->

<!-- NAVIGATION -->
<nav id="navigation">
    <!-- container -->
    <div class="container">
        <!-- responsive-nav -->
        <div id="responsive-nav">
        </div>
        <!-- /responsive-nav -->
    </div>
    <!-- /container -->
</nav>
<!-- /NAVIGATION -->

<!-- SECTION -->
<%--<div class="section">--%>
<!-- container -->
<%--điền chi tiết thông tin sản phẩm vào đây???????????????????????????????????--%>


<%--bat dau neu sp do so luong = 0--%>
<c:if test="${product.getProductQuantity() == 0}">
<div class="container" style="width: 50%; height: 50%; margin-bottom: 200px" >
    <div class="card">
        <div class="container-fliud">
            <div class="wrapper row">
                <div class="preview col-md-6">

                    <div class="preview-pic tab-content">
                        <div class="tab-pane active"><img src="${product.getProductImage()}" /></div>
                    </div>

                </div>
                <div class="details col-md-6">
                    <h3 class="product-title">${product.getProductName()}</h3>

                    <p class="product-description">${product.getProductDescription()}</p>
                    <h4 class="price">price: <span>${product.getProductPrice()}</span></h4>

                    <h5 class="sizes">shop name:
                        <span class="size" data-toggle="tooltip" title="small">${product.getShopName()}</span>
                    </h5>
                    <br>
                    <h5 class="colors">
                        <span style="color: red">
                            Out of stock</span>
                    </h5>
                </div>
            </div>
        </div>
    </div>
</div>
</c:if>
<%--ket thuc neu sp do so luong = 0--%>


<%--bat dau neu sp do co so luong > 0--%>
<c:if test="${product.getProductQuantity() > 0}">
<div class="container" style="width: 50%; height: 50%; margin-bottom: 200px" >
    <div class="card">
        <div class="container-fliud">
            <div class="wrapper row">
                <div class="preview col-md-6">

                    <div class="preview-pic tab-content">
                        <div class="tab-pane active" id="pic-1"><img src="${product.getProductImage()}" /></div>
                    </div>

                </div>
                <div class="details col-md-6">
                    <h3 class="product-title">${product.getProductName()}</h3>

                    <p class="product-description">${product.getProductDescription()}</p>
                    <h4 class="price">price: <span>${product.getProductPrice()}</span></h4>

                    <h5 class="sizes">shop name:
                        <span class="size" data-toggle="tooltip" title="small">${product.getShopName()}</span>
                    </h5>
                    <h5 class="colors">Available Quantity:
                        <span>
                            ${product.getProductQuantity()}</span>
                    </h5>
                    <a href="logincontroller">
                        <div class="action">
                            <button class="add-to-cart btn btn-default" type="submit">Buy Now</button>
                        </div>
                    </a>
                </div>
            </div>
        </div>
    </div>
</div>
</c:if>
<%--ket thuc neu sp do co so luong > 0--%>

<%--kết thúc chi tiết thông tin sản phầm????????????????????????????????????????????--%>
<!-- /container -->
<%--</div>--%>
<!-- /SECTION -->

<!-- SECTION -->
<div class="section">
    <!-- container -->
    <div class="container">
        <!-- row -->
        <div class="row">

            <!-- section title -->
            <div class="col-md-12">
                <div class="section-title">
                    <h3 class="title">Top selling</h3>
                </div>
            </div>
            <!-- /section title -->

            <!-- Products tab & slick -->
            <div class="col-md-12">
                <div class="row">
                    <div class="products-tabs">
                        <!-- tab -->
                        <div id="tab2" class="tab-pane fade in active">
                            <div class="products-slick" data-nav="#slick-nav-2">
                                <!-- product -->
                                <!-- product -->
                                <c:forEach items="${topProducts}" var="product">
                                    <div class="product">
                                        <div class="product-img">
                                            <img src="${product.getProductImage()}" alt="">
                                        </div>
                                        <div class="product-body">
                                            <h3 class="product-name"><a
                                                    href="/show-product-details-homepage">${product.getProductName()}</a></h3>
                                            <h4 class="product-price">${product.getProductPrice()}</h4>
                                        </div>
                                        <a href="logincontroller">
                                        <div class="add-to-cart">
                                            <button class="add-to-cart-btn"><i class="fa fa-shopping-cart"></i>BUY NOW
                                            </button>
                                        </div>
                                        </a>
                                    </div>
                                </c:forEach>
                                <!-- /product -->








                            </div>
                            <div id="slick-nav-2" class="products-slick-nav"></div>
                        </div>
                        <!-- /tab -->
                    </div>
                </div>
            </div>
            <!-- /Products tab & slick -->
        </div>
        <!-- /row -->
    </div>
    <!-- /container -->
</div>
<!-- /SECTION -->

<%--<!-- SECTION -->--%>
<%--<div class="section">--%>
<%--    <!-- container -->--%>
<%--    <div class="container">--%>
<%--        <!-- row -->--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-4 col-xs-6">--%>
<%--                <div class="section-title">--%>
<%--                    <h4 class="title">Top selling</h4>--%>
<%--                    <div class="section-nav">--%>
<%--                        <div id="slick-nav-3" class="products-slick-nav"></div>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="products-widget-slick" data-nav="#slick-nav-3">--%>
<%--                    <div>--%>
<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product07.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /product widget -->--%>

<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product08.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /product widget -->--%>

<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product09.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- product widget -->--%>
<%--                    </div>--%>

<%--                    <div>--%>
<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product01.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /product widget -->--%>

<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product02.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /product widget -->--%>

<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product03.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- product widget -->--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="col-md-4 col-xs-6">--%>
<%--                <div class="section-title">--%>
<%--                    <h4 class="title">Top selling</h4>--%>
<%--                    <div class="section-nav">--%>
<%--                        <div id="slick-nav-4" class="products-slick-nav"></div>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="products-widget-slick" data-nav="#slick-nav-4">--%>
<%--                    <div>--%>
<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product04.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /product widget -->--%>

<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product05.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /product widget -->--%>

<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product06.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- product widget -->--%>
<%--                    </div>--%>

<%--                    <div>--%>
<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product07.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /product widget -->--%>

<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product08.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /product widget -->--%>

<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product09.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- product widget -->--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--            <div class="clearfix visible-sm visible-xs"></div>--%>

<%--            <div class="col-md-4 col-xs-6">--%>
<%--                <div class="section-title">--%>
<%--                    <h4 class="title">Top selling</h4>--%>
<%--                    <div class="section-nav">--%>
<%--                        <div id="slick-nav-5" class="products-slick-nav"></div>--%>
<%--                    </div>--%>
<%--                </div>--%>

<%--                <div class="products-widget-slick" data-nav="#slick-nav-5">--%>
<%--                    <div>--%>
<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product01.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /product widget -->--%>

<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product02.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /product widget -->--%>

<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product03.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- product widget -->--%>
<%--                    </div>--%>

<%--                    <div>--%>
<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product04.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /product widget -->--%>

<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product05.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- /product widget -->--%>

<%--                        <!-- product widget -->--%>
<%--                        <div class="product-widget">--%>
<%--                            <div class="product-img">--%>
<%--                                <img src="img/product06.png" alt="">--%>
<%--                            </div>--%>
<%--                            <div class="product-body">--%>
<%--                                <p class="product-category">Category</p>--%>
<%--                                <h3 class="product-name"><a href="#">product name goes here</a></h3>--%>
<%--                                <h4 class="product-price">$980.00 <del class="product-old-price">$990.00</del></h4>--%>
<%--                            </div>--%>
<%--                        </div>--%>
<%--                        <!-- product widget -->--%>
<%--                    </div>--%>
<%--                </div>--%>
<%--            </div>--%>

<%--        </div>--%>
<%--        <!-- /row -->--%>
<%--    </div>--%>
<%--    <!-- /container -->--%>
<%--</div>--%>
<%--<!-- /SECTION -->--%>

<%--<!-- NEWSLETTER -->--%>
<%--<div id="newsletter" class="section">--%>
<%--    <!-- container -->--%>
<%--    <div class="container">--%>
<%--        <!-- row -->--%>
<%--        <div class="row">--%>
<%--            <div class="col-md-12">--%>
<%--                <div class="newsletter">--%>
<%--                    <p>Sign Up for the <strong>NEWSLETTER</strong></p>--%>
<%--                    <form>--%>
<%--                        <input class="input" type="email" placeholder="Enter Your Email">--%>
<%--                        <button class="newsletter-btn"><i class="fa fa-envelope"></i> Subscribe</button>--%>
<%--                    </form>--%>
<%--                    <ul class="newsletter-follow">--%>
<%--                        <li>--%>
<%--                            <a href="#"><i class="fa fa-facebook"></i></a>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <a href="#"><i class="fa fa-twitter"></i></a>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <a href="#"><i class="fa fa-instagram"></i></a>--%>
<%--                        </li>--%>
<%--                        <li>--%>
<%--                            <a href="#"><i class="fa fa-pinterest"></i></a>--%>
<%--                        </li>--%>
<%--                    </ul>--%>
<%--                </div>--%>
<%--            </div>--%>
<%--        </div>--%>
<%--        <!-- /row -->--%>
<%--    </div>--%>
<%--    <!-- /container -->--%>
<%--</div>--%>
<%--<!-- /NEWSLETTER -->--%>

<!-- FOOTER -->
<footer id="footer">
    <!-- top footer -->
    <div class="section">
        <!-- container -->
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">About Us</h3>
                        <p>Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor
                            incididunt
                            ut.</p>
                        <ul class="footer-links">
                            <li><a href="#"><i class="fa fa-map-marker"></i>1734 Stonecoal Road</a></li>
                            <li><a href="#"><i class="fa fa-phone"></i>+021-95-51-84</a></li>
                            <li><a href="#"><i class="fa fa-envelope-o"></i>email@email.com</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Categories</h3>
                        <ul class="footer-links">
                            <li><a href="#">Hot deals</a></li>
                            <li><a href="#">Laptops</a></li>
                            <li><a href="#">Smartphones</a></li>
                            <li><a href="#">Cameras</a></li>
                            <li><a href="#">Accessories</a></li>
                        </ul>
                    </div>
                </div>

                <div class="clearfix visible-xs"></div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Information</h3>
                        <ul class="footer-links">
                            <li><a href="#">About Us</a></li>
                            <li><a href="#">Contact Us</a></li>
                            <li><a href="#">Privacy Policy</a></li>
                            <li><a href="#">Orders and Returns</a></li>
                            <li><a href="#">Terms & Conditions</a></li>
                        </ul>
                    </div>
                </div>

                <div class="col-md-3 col-xs-6">
                    <div class="footer">
                        <h3 class="footer-title">Service</h3>
                        <ul class="footer-links">
                            <li><a href="#">My Account</a></li>
                            <li><a href="#">View Cart</a></li>
                            <li><a href="#">Wishlist</a></li>
                            <li><a href="#">Track My Order</a></li>
                            <li><a href="#">Help</a></li>
                        </ul>
                    </div>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /top footer -->

    <!-- bottom footer -->
    <div id="bottom-footer" class="section">
        <div class="container">
            <!-- row -->
            <div class="row">
                <div class="col-md-12 text-center">
                    <ul class="footer-payments">
                        <li><a href="#"><i class="fa fa-cc-visa"></i></a></li>
                        <li><a href="#"><i class="fa fa-credit-card"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-paypal"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-mastercard"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-discover"></i></a></li>
                        <li><a href="#"><i class="fa fa-cc-amex"></i></a></li>
                    </ul>
                    <span class="copyright">
								 <a target="_blank" href="https://www.templateshub.net">Templates Hub</a>
							</span>
                </div>
            </div>
            <!-- /row -->
        </div>
        <!-- /container -->
    </div>
    <!-- /bottom footer -->
</footer>
<!-- /FOOTER -->

<!-- jQuery Plugins -->
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<script src="js/slick.min.js"></script>
<script src="js/nouislider.min.js"></script>
<script src="js/jquery.zoom.min.js"></script>
<script src="js/main.js"></script>

</body>
</html>

