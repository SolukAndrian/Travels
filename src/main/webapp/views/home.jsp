<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="dep" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 17.04.2017
  Time: 20:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Friends' Travel</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Sigmar+One" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/style.css"> </head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header"> <a class="navbar-brand" href="/">Friends' Travel</a> </div>
        <form action="/searchByNameDeparture" method="post" class="navbar-form navbar-left">
            <div class="form-group">
                <input name="inputSearch" type="text" class="form-control" placeholder="Search">
            </div>
            <button class="btn btn-default" type="submit">
                GO
            </button>
        </form>
        <ul class="nav navbar-nav navbar-right">
            <sec:authorize access="hasRole('ROLE_ADMIN')"> <li><a href="/tourDescription"><span class="glyphicon glyphicon-plus"></span> Add tour description</a></li></sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')"> <li><a href="/hotelAdd"><span class="glyphicon glyphicon-plus"></span> Add hotel</a></li></sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')"> <li><a href="/departureAdd"><span class="glyphicon glyphicon-plus"></span> Add departure</a></li></sec:authorize>
            <sec:authorize access="hasRole('ROLE_ADMIN')"> <li><a href="/hotelAccommodation"><span class="glyphicon glyphicon-plus"></span> Add hotel accommodation</a></li></sec:authorize>
            <sec:authorize access="isAuthenticated()"><li><a href="/logout"><span class="glyphicon glyphicon-log-out"></span> Log out</a></li></sec:authorize>
            <sec:authorize access="isAnonymous()"><li><a href="/loginpage"><span class="glyphicon glyphicon-log-in"></span> Log in</a></li></sec:authorize>
            <sec:authorize access="isAnonymous()"><li><a href="/registrationPage"><span class="glyphicon glyphicon-list-alt"></span> Registration page</a></li></sec:authorize>

        </ul>
    </div>
</nav>

<div class="container">
        <dep:forEach var="dep" items="${dep}">
            <a href="/departure/${dep.id}">
                <div class="tour">
                    <h2>${dep.tourDescription.name}</h2> <img src="/imageDisplay?id=${dep.tourDescription.id}" alt="">
                    <div class="price">${dep.price}</div>
                    <div class="description">${dep.tourDescription.vehicle}</div>
                    <div class="button1">
                        <sec:authorize access="hasRole('ROLE_ADMIN')"><a href="/departureDelete/${dep.id}">  <button class="b2"><span class="glyphicon glyphicon-trash"></span>delete</button></a></sec:authorize>
                        <sec:authorize access="hasRole('ROLE_USER')"><a href="/booking/${dep.id}"><button class="b3">Booking</button></a></sec:authorize>
                        <sec:authorize access="isAnonymous()"><a href="/loginpage"><button class="b4">Booking</button></a></sec:authorize>
                    </div>
                </div>
            </a>
        </dep:forEach>
</div>
</body>

</html>
