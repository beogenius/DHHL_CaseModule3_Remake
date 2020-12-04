<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->

    <title>Ecommerce</title>

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

                <li><a href="/back-to-home-page"><i class="fa fa-user-o"></i> Logout</a></li>
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
                            <img src="img/amazon.jpg" alt="" width="100px">
                        </a>
                    </div>
                </div>
                <!-- /LOGO -->

                <!-- SEARCH BAR -->
                <div class="col-md-4">
                    <a href="/create-product?shopid=${shop.getShopID()}"><input type="submit"
                                                                                class="btn btn-primary btn-lg"
                                                                                style="background-color: red"
                                                                                value="CREATE NEW PRODUCT"></a>
                </div>
                <!-- /SEARCH BAR -->

                <!-- SEARCH BAR -->
                <div class="col-md-3">
                    <a href="/show-product-list?shopid=${shop.getShopID()}"><input type="submit"
                                                                                   class="btn btn-primary btn-lg"
                                                                                   style="background-color: red"
                                                                                   value="YOUR PRODUCT LIST"></a>
                </div>
                <!-- /SEARCH BAR -->

                <!-- ACCOUNT -->
                <div class="col-md-3 clearfix">
                    <button type="button" class="btn btn-primary btn-lg" style="background-color: red">REVENUE</button>
                </div>
                <!-- /ACCOUNT -->
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
<c:if test="${shopProducts.size() == 0}">
    <div><span style="margin: auto; color: red; font-weight: bold; font-size: xx-large">YOUR SHOP HAS NO PRODUCT!</span></div>
</c:if>


<div class="container">
    <div class="row">
        <c:forEach items="${shopProducts}" var="product">

            <%--neu san pham co so luong = 0--%>
            <c:if test="${product.getProductQuantity() == 0}">
                <div class="col-md-3" style="margin-bottom: 50px">
                    <div class="product-item">
                        <div class="product-title" style="text-transform: uppercase; font-weight: bold; font-size: large">
                            <a href="/show-product-details-shop?productid=${product.getProductID()}&shopid=${shop.getShopID()}">${product.getProductName()}</a>
                        </div>
                        <div class="product-image">
                            <a href="/show-product-details-shop?productid=${product.getProductID()}&shopid=${shop.getShopID()}">
                                <img style="width: 100px; height: 100px" src="${product.getProductImage()}"
                                     alt="Product Image">
                            </a>
                        </div>
                        <div class="product-price">
                            <h3><span>$</span>${product.getProductPrice()} <span style="color: red">Out of stock</span></h3>
                        </div>
                        <div>
                            <a href="/show-edit-form?productid=${product.getProductID()}&shopid=${shop.getShopID()}"><input
                                    type="submit" class="btn btn-primary btn-sm" value="EDIT"></a>
                        </div>
                    </div>
                </div>
            </c:if>
            <%--            ket thuc san pham co so luong = 0--%>

            <%--            neu san pham co so luong > 0--%>
            <c:if test="${product.getProductQuantity() > 0}">

                <div class="col-md-3" style="margin-bottom: 50px">
                    <div class="product-item">
                        <div class="product-title" style="text-transform: uppercase; font-weight: bold; font-size: large">
                            <a href="/show-product-details-shop?productid=${product.getProductID()}&shopid=${shop.getShopID()}">${product.getProductName()}</a>
                        </div>
                        <div class="product-image">
                            <a href="/show-product-details-shop?productid=${product.getProductID()}&shopid=${shop.getShopID()}">
                                <img style="width: 100px; height: 100px" src="${product.getProductImage()}"
                                     alt="Product Image">
                            </a>
                        </div>
                        <div class="product-price">
                            <h3><span>$</span>${product.getProductPrice()}</h3>
                        </div>
                        <div>
                            <a href="/show-edit-form?productid=${product.getProductID()}&shopid=${shop.getShopID()}"><input
                                    type="submit" class="btn btn-primary btn-sm" value="EDIT"></a>
                            <a href="/show-delete-form?productid=${product.getProductID()}&shopid=${shop.getShopID()}"><input
                                    type="submit" class="btn btn-primary btn-sm" value="STOP SELLING"></a>
                        </div>
                    </div>
                </div>
            </c:if>
            <%--            ket thuc san pham co so luong > 0--%>



        </c:forEach>
    </div>
</div>


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
