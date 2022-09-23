<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>

<head>
    <meta charset="utf-8">
    <title>Bus Booking</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link rel="stylesheet" href="css/userLoginStyles.css">


    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;900&family=Ubuntu:wght@300&display=swap"
            rel="stylesheet">
    <!-- Fontawesome Icons -->
    <script src="https://kit.fontawesome.com/2c135d6bdb.js"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">
	<script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
</head>
</head>

<body>
<!-- Nav Bar -->
<nav class="navbar navbar-expand-lg navbar-dark">
    <img alt="logo" src="images/img.png" class="logo">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li class="nav-item"><a href="index.html"><i class="fa fa-home"></i></a></li>
        </ul>
    </div>
</nav>
<section id="title">

    <img class="log">
    <div class="loginbox sendotp">
        <h1>Send OTP</h1>
        <form action="sendotp.do" method="post">
            ${msg}
            <p>Email</p>
            <input type="email" name="user" placeholder="Enter email" required>
            <input type="submit" value="Send Otp"> 
            <a href="userLoginPage">Login here</a>
        </form>
    </div>
</section>


<!-- Footer -->

<footer id="footer">
    <ul class="mylogo">
        <li><a href="https://twitter.com/DXCTechnology">
            <ion-icon
                    name="logo-twitter"></ion-icon>
        </a></li>
        <li><a href="https://www.facebook.com/DXCTechnology">
            <ion-icon
                    name="logo-facebook"></ion-icon>
        </a></li>
        <li><a href="https://www.instagram.com/dxctechnology/">
            <ion-icon
                    name="logo-instagram"></ion-icon>
        </a></li>
        <li><a href="https://www.linkedin.com/dxctechnology/">
            <ion-icon
                    name="logo-linkedin"></ion-icon>
        </a></li>
    </ul>
    <p>
        <ion-icon name="help-circle"></ion-icon>
        Copyright 2022 <a href="https://dxc.com/in/en">DXC Technology</a>
    </p>
</footer>

<script src="https://code.jquery.com/jquery-3.3.1.slim.min.js"
        integrity="sha384-q8i/X+965DzO0rT7abK41JStQIAqVgRVzpbzo5smXKp4YfRvH+8abtTE1Pi6jizo"
        crossorigin="anonymous"></script>
<script
        src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.14.3/umd/popper.min.js"
        integrity="sha384-ZMP7rVo3mIykV+2+9J3UJ46jBk0WLaUAdn689aCwoqbBJiSnjAK/l8WvCWPIPm49"
        crossorigin="anonymous"></script>
<script
        src="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/js/bootstrap.min.js"
        integrity="sha384-ChfqqxuZUCnJSK3+MXmPNIyE6ZbWh2IMqE241rYiqJxyMiZ6OW/JmZQ5stwEULTy"
        crossorigin="anonymous"></script>

<script type="module"
        src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule
        src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>

</html>
