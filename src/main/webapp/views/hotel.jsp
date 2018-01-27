<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 18.04.2017
  Time: 13:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding hotel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Sigmar+One" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/style.css">
</head>
<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header">
            <a class="navbar-brand" href="/">Friends' Travel</a>
        </div>

        <form class="navbar-form navbar-left">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search">
            </div>
            <button class="btn btn-default" type="submit">
                GO
            </button>
        </form>

        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="hasRole('ROLE_ADMIN')"> <li><a href="/tourDescription"><span class="glyphicon glyphicon-plus"></span> Add tour description</a></li></sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')"> <li><a href="/hotelAdd"><span class="glyphicon glyphicon-plus"></span> Add hotel</a></li></sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')"> <li><a href="/departureAdd"><span class="glyphicon glyphicon-plus"></span> Add departure</a></li></sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')"> <li><a href="/hotelAccommodation"><span class="glyphicon glyphicon-plus"></span> Add /hotel accomondation</a></li></sec:authorize>

            <sec:authorize access="isAuthenticated()"><li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li></sec:authorize>
            <sec:authorize access="isAnonymous()"><li><a href="/loginpage"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li></sec:authorize>
            <sec:authorize access="isAnonymous()"><li><a href="/registrationPage"><span class="glyphicon glyphicon-list-alt"></span> Registration page</a></li></sec:authorize>

        </ul>
    </div>
</nav>
<div class="addTour">
    <form action="" method="post" enctype="multipart/form-data">
        <h1>Add hotel</h1>

        <label for="hotelName">Name hotel:</label>
        <input id="hotelName" name="hotelName" type="text">
        <br>
        <label for="stars">Stars:</label>
        <input id="stars" name="stars" type="number">
        <br>
        <label for="country">Country:</label>
        <input id="country" name="country" type="text">
        <br>
        <label for="city">City:</label>
        <input id="city" name="city" type="text">
        <br>
        <label for="address">Address:</label>
        <input id="address" name="address" type="text">
        <br>
        <label class="pPhoto"><input type="file" name="image" multiple accept="image/*" ></label>
        <button type="submit" class="btn btn-primary">Add departure</button>
    </form>
</div>
</body>
</html>