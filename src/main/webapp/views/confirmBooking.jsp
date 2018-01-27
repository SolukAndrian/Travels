<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 24.04.2017
  Time: 22:22
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Confirm booking</title>
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
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li><a href="/tourDescription"><span class="glyphicon glyphicon-plus"></span> Add tour description</a>
                </li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li><a href="/hotelAdd"><span class="glyphicon glyphicon-plus"></span> Add hotel</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li><a href="/departureAdd"><span class="glyphicon glyphicon-plus"></span> Add departure</a></li>
            </sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')">
                <li><a href="/hotelAccommodation"><span class="glyphicon glyphicon-plus"></span> Add /hotel
                    accomondation</a></li>
            </sec:authorize>
            <sec:authorize access="isAuthenticated()">
                <li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <li><a href="/loginpage"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li>
            </sec:authorize>
            <sec:authorize access="isAnonymous()">
                <li><a href="/registrationPage"><span class="glyphicon glyphicon-list-alt"></span> Registration page</a>
                </li>
            </sec:authorize>

        </ul>
    </div>
</nav>
<div class="addTour">
    <form action="/confirmBooking" method="post">
        <h1>Confirm booking:</h1>

        <label for="dateEntry">Your surname:</label>
        <input id="dateEntry" name="dateEntry" type="text" value="${user.surname}">
        <br>
        <label for="dateDeparture">Your name:</label>
        <input id="dateDeparture" name="dateDeparture" type="text" value="${user.name}">
        <br>
        <label for="emailUser">Your email:</label>
        <input id="emailUser" name="emailUser" type="text" value="${user.email}">
        <br>
        <label for="login">Your login:</label>
        <input id="login" name="login" type="text" value="${user.login}">
        <br>

        <label for="phone">Your phone number:</label>
        <input id="phone" name="phone" type="text" value="${user.phone}">
        <br>

        <input id="departureId" name="departureId" type="hidden" value="${departure.id}">

        <label for="departure">Your departure:</label>
        <input id="departure" name="departure" type="text" value="${departure.tourDescription.name}">
        <br>


        <br>
        <label for="idHotel">Select hotel:</label>

        <select name="idHotel" id="idHotel">
            <h:forEach var="h" items="${hotels}">
                <option value="${h.hotel.id}">${h.hotel.nameHotel}</option>
            </h:forEach>
        </select>
        <br>
        <br>


        <a href="">
            <button type="submit" class="btn btn-primary">Confirm booking</button>
        </a>
    </form>
</div>
</body>
</html>

