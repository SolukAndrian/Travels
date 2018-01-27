<%@ taglib prefix="hotel" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="dep" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 18.04.2017
  Time: 15:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Adding hotel accommodation</title>
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

        <ul class="nav navbar-nav">
            <li><a href="login.html">Log in</a></li>
            <li><a href="registration.html">Sing up</a></li>
        </ul>
    </div>
</nav>
<div class="addTour">
    <form action="/hotelAccommodation" method="post">
        <h1>Add hotel accommodation:</h1>

        <label for="dateEntry">Date entry DD-MM-YYYY:</label>
        <input id="dateEntry" name="dateEntry" type="text">
        <br>
        <label for="dateDeparture">Date departure DD-MM-YYYY:</label>
        <input id="dateDeparture" name="dateDeparture" type="text">
        <br>
        <label for="quantityReservedNumbers">Quantity reserved numbers:</label>
        <input id="quantityReservedNumbers" name="quantityReservedNumbers" type="number">
        <br>
        <br>
        <label for="idHotel">Select hotel:</label>
        <select name="idHotel" id="idHotel">
            <hotel:forEach var="hotel" items="${hotels}">
                <option value="${hotel.id}">${hotel.nameHotel}</option>
            </hotel:forEach>
        </select>
        <br>
        <br>
        <label for="idDeparture">Select departure:</label>
        <select name="idDeparture" id="idDeparture">
            <dep:forEach var="dep" items="${departures}">
                <option value="${dep.id}">${dep.typeTrip}</option>
            </dep:forEach>
        </select>

        <button type="submit" class="btn btn-primary">Add hotel accommodation</button>
    </form>
</div>
</body>
</html>
