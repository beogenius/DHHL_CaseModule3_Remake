
<%--thay ảnh nền và font--%>

<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <title>Login</title>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!--===============================================================================================-->
    <link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
    <!--===============================================================================================-->
    <!-- Latest compiled and minified CSS -->
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <!-- jQuery library -->
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <!-- Latest compiled JavaScript -->
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
    <!--===============================================================================================-->
</head>
<body>

<style>
    @import url(https://fonts.googleapis.com/css?family=Roboto:300);

    .login-page {

        width: 360px;
        padding: 8% 0 0;
        margin: 7px 150px;

    }

    .form {
        position: relative;
        z-index: 1;
        background: #ffffff;
        max-width: 360px;
        margin: 0 auto 100px;
        padding: 45px;
        text-align: center;
        box-shadow: 0 0 20px 0 rgba(0, 0, 0, 0.2), 0 5px 5px 0 rgba(0, 0, 0, 0.24);
    }

    .form input {
        font-family: "Roboto", sans-serif;
        outline: 0;
        background: #f2f2f2;
        width: 100%;
        border: 0;
        margin: 0 0 15px;
        padding: 15px;
        box-sizing: border-box;
        font-size: 14px;
    }

    .form button {
        font-family: "Roboto", sans-serif;
        text-transform: uppercase;
        outline: 0;
        background: #4caf50;
        width: 100%;
        border: 0;
        padding: 15px;
        color: #ffffff;
        font-size: 14px;
        cursor: pointer;
    }

    .form button:hover,
    .form button:active,
    .form button:focus {
        background: #43a047;
    }

    .form .message {
        margin: 15px 0 0;
        color: #b3b3b3;
        font-size: 12px;
    }

    .form .message a {
        color: #4caf50;
        text-decoration: none;
    }

    .form .register-form {
        display: none;
    }

    .container {
        position: relative;
        z-index: 1;
        max-width: 300px;
        margin: 0 auto;
    }

    .container:before,
    .container:after {
        content: "";
        display: block;
        clear: both;
    }

    .container .info {
        margin: 50px auto;
        text-align: center;
    }

    .container .info h1 {
        margin: 0 0 15px;
        padding: 0;
        font-size: 36px;
        font-weight: 300;
        color: #1a1a1a;
    }

    .container .info span {
        color: #4d4d4d;
        font-size: 12px;
    }

    .container .info span a {
        color: #000000;
        text-decoration: none;
    }

    .container .info span .fa {
        color: #ef3b3a;
    }

    body {
        background: #76b852; /* fallback for old browsers */
        background: -webkit-linear-gradient(right, #76b852, #8dc26f);
        background: -moz-linear-gradient(right, #76b852, #8dc26f);
        background: -o-linear-gradient(right, #76b852, #8dc26f);
        background: linear-gradient(to left, #76b852, #8dc26f);
        font-family: "Roboto", sans-serif;
        -webkit-font-smoothing: antialiased;
        -moz-osx-font-smoothing: grayscale;
        background-image: url("view/images/anhnendangky.png");
        background-size: cover;
    }
</style>
<div class="login-page">
    <div class="form">
        <span style="font-size: large">
            Account Create
        </span>
        <form class="login-form" action="/create-buyer" method="post">
            <input type="email" placeholder="userEmail" name="userEmail" required/>
            <input type="password" minlength="6" placeholder="userPass" name="userPass" required/>
            <input type="number" minlength="6" placeholder="phoneNumber" name="phoneNumber" required/>
            <input type="text" placeholder="userName" name="userName" required/>

            <input type="submit" class="login100-form-btn" value="Create Account" style="background-color: greenyellow" >
            <p class="message">Not registered shop? <a href="#">create shop</a></p>
        </form>

        <form class=register-form action="/create-shop" method="post">
            <input type="text" name="shopName" placeholder="shopName" required/>
            <input type="email" name="shopEmail" placeholder="shopEmail" required/>
            <input type="password" minlength="6" type="shopPass" name="shopPass" placeholder="Password" required/>
            <input type="text" name="address" placeholder="address" required/>

            <input type="submit" class="login100-form-btn" value="Create Shop" style="background-color: greenyellow">
            <p class="message">Not registered user? <a href="#">Create an account</a></p>
        </form>

    </div>
</div>
<%--private int shopID;--%>
<%--private String shopName;--%>
<%--private String shopEmail;--%>
<%--private String shopPass;--%>
<%--private String address;--%>
<div id="dropDownSelect1"></div>
<!--===============================================================================================-->
<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/bootstrap/js/popper.js"></script>
<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
<script src="vendor/daterangepicker/moment.min.js"></script>
<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
<script src="js/main.js"></script>
<script>$('.message a').click(function () {
    $('form').animate({height: "toggle", opacity: "toggle"}, "slow");
});</script>
</body>
</html>