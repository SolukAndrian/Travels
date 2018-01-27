<%@ taglib prefix="sec" uri="http://www.springframework.org/security/tags" %>
<%@ taglib prefix="h" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Apple
  Date: 24.04.2017
  Time: 17:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Departure ${departure.tourDescription.name}</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.0/jquery.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
    <link href="https://fonts.googleapis.com/css?family=Sigmar+One" rel="stylesheet">
    <link rel="stylesheet" href="/resources/css/style2.css"> </head>

<body>
<nav class="navbar navbar-default">
    <div class="container-fluid">
        <div class="navbar-header"> <a class="navbar-brand" href="/">Friends' Travel</a> </div>
        <form class="navbar-form navbar-left">
            <div class="form-group">
                <input type="text" class="form-control" placeholder="Search"> </div>
            <button class="btn btn-default" type="submit"> GO </button>
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
</nav>


<div class="container">
    <div class="imgSSS">
        <img id="myImg" src="/imageDisplay?id=${departure.tourDescription.id}" alt="" width="300" height="250">
        <sec:authorize access="hasRole('ROLE_ADMIN')"><a href="/departureDelete/${departure.id}"><button class="but1">Delete departure</button></a></sec:authorize>
        <sec:authorize access="hasRole('ROLE_USER')"><a href="/booking/${departure.id}"><button class="but3">Booking</button></a></sec:authorize>
        <sec:authorize access="isAnonymous()"><a href="/loginpage"><button class="but4">Booking</button></a></sec:authorize>

    </div>

    <!-- The Modal -->
    <div id="myModal" class="modal">
        <span class="close">&times;</span>
        <img class="modal-content" id="img01">
    </div>

    <div class="container2">
        <div class="nameInfo"><h2>${departure.tourDescription.name} </h2>
            <h3>Price: ${departure.price} $</h3>
            <h3>
                Type: ${departure.typeTrip}
            </h3>
        </div><hr>
        <div class="description">

            <h3>Description: </h3>
            <p>Country: ${departure.tourDescription.countries}</p> <br>
            <p>Cities: ${departure.tourDescription.cities}</p><br>
            <p>Days: ${departure.tourDescription.days}</p><br>
            <p>Vehicle: ${departure.tourDescription.vehicle}</p><br>
        </div>
    </div>
</div>
<div class="hotels">
    <h:forEach var="h" items="${hotels}">
    <div class="hotel">
        <img src="/imageDisplay2?id=${h.hotel.id}" alt="">
        <div class="information">
            <p>Hotel: ${h.hotel.nameHotel}</p>
            <p>Date entry: ${h.dateEntry}</p>
            <p>Date departure: ${h.dateDeparture}</p>
            <p>Address: ${h.hotel.address}</p>
            <p>Stars: ${h.hotel.stars}</p>
        </div>
    </div>
    </h:forEach>
</div>
<script>
    // Get the modal
    var modal = document.getElementById('myModal');

    // Get the image and insert it inside the modal - use its "alt" text as a caption
    var img = document.getElementById('myImg');
    var modalImg = document.getElementById("img01");
    var captionText = document.getElementById("caption");
    img.onclick = function(){
        modal.style.display = "block";
        modalImg.src = this.src;
    }

    // Get the <span> element that closes the modal
    var span = document.getElementsByClassName("close")[0];

    // When the user clicks on <span> (x), close the modal
    span.onclick = function() {
        modal.style.display = "none";
    }
</script>
</body>

</html>
