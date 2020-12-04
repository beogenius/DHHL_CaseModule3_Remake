
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%--<!DOCTYPE html>--%>

<!DOCTYPE html>
<html lang="en">
<head>
    <title>Bootstrap Example</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"></script>
</head>
<body>

<nav class="navbar navbar-inverse">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/back-to-admin-page">Admin Page</a>
        </div>
        <ul class="nav navbar-nav">
            <li><a href="/show-buyer-list">Buyer List</a></li>
            <li><a href="/show-shop-list">Shop List</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/shopee"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container-fluid">
    <h1>WELCOME TO ADMIN PAGE</h1>
    <br>
    <br>
    <div class="row">
        <div class="col-lg-6">
            <div class="card">
                <div class="card-header"><h3>BUYER LIST</h3></div>
                <div class="card-body">
                    <table class="table table-bordered table-striped">
                        <tr>
                            <th>ID</th>
                            <th>Email</th>
                            <th>Password</th>
                            <th>Phone</th>
                            <th>Name</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach items="${buyers}" var="buyer">
                            <tr>
                                <td scope="col">${buyer.getUserID()}</td>
                                <td scope="col">${buyer.getUserEmail()}</td>
                                <td scope="col">${buyer.getUserPass()}</td>
                                <td scope="col">${buyer.getPhoneNumber()}</td>
                                <td scope="col">${buyer.getUserName()}</td>
                                <td>

                                        <a href="/show-edit-buyer-form?Buyerid=${buyer.getUserID()}"><input
                                                type="submit" class="btn btn-primary btn-sm" value="Edit"></a>
                                    <a href="/customersUser?action=deleteOUT&id=${buyer.getUserID()}" class="btn btn-danger btn-sm">Delete</a>
                                </td>
                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
        <div class="col-lg-6">
            <div class="card">
                <div class="card-header"><h3>SHOP LIST</h3></div>
                <div class="card-body">
                    <table class="table table-bordered table-striped">
                        <tr>
                            <th>Shop ID</th>
                            <th>Shop Name</th>
                            <th>Shop Email</th>
                            <th>Shop Password</th>
                            <th>Shop Adress</th>
                            <th>Action</th>
                        </tr>
                        <c:forEach items="${shops}" var="shop">
                            <tr>
                                <td scope="col">${shop.getShopID()}</td>
                                <td scope="col">${shop.getShopName()}</td>
                                <td scope="col">${shop.getShopEmail()}</td>
                                <td scope="col">${shop.getShopPass()}</td>
                                <td scope="col">${shop.getAddress()}</td>
                                <td>
                                    <a href="/show-edit-shop-form?ShopID=${shop.getShopID()}" class="btn btn-primary btn-sm">Edit</a>
                                    <a href="/customersShop?action=delete&id=${shop.getShopID()}" class="btn btn-danger btn-sm">Delete</a>
                                </td>

                            </tr>
                        </c:forEach>
                    </table>
                </div>
            </div>
        </div>
    </div>
</div>

</body>
</html>