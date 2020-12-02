<%--
  Created by IntelliJ IDEA.
  User: adminn
  Date: 11/5/2020
  Time: 8:28 PM
  To change this template use File | Settings | File Templates.
--%>
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
            <li class="active"><a href="/show-buyer-list">Buyer List</a></li>
            <li><a href="/show-shop-list">Shop List</a></li>
        </ul>
        <ul class="nav navbar-nav navbar-right">
            <li><a href="/shopee"><span class="glyphicon glyphicon-log-in"></span> Logout</a></li>
        </ul>
    </div>
</nav>

<div class="container">
    <h3>BUYER LIST</h3>
    <br>
    <table class="table table-striped">
        <tr>
            <th>Buyer ID</th>
            <th>Buyer Email</th>
            <th>Buyer Password</th>
            <th>Buyer Phone Number</th>
            <th>Buyer Name</th>
        </tr>
        <c:forEach items="${buyers}" var="buyer">
            <tr>
                <td scope="col">${buyer.getUserID()}</td>
                <td scope="col">${buyer.getUserEmail()}</td>
                <td scope="col">${buyer.getUserPass()}</td>
                <td scope="col">${buyer.getPhoneNumber()}</td>
                <td scope="col">${buyer.getUserName()}</td>
            </tr>
        </c:forEach>
    </table>
</div>
</body>
</html>











