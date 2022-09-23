<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>

<head>
    <meta charset="ISO-8859-1">
    <title>Bus Booking</title>
     <link rel="stylesheet" href="css/home-styles.css">
</head>
<body>
<nav class="nav">
    <div class="container">
        <div class="logo">
            <img src="images/img.png" alt="">
        </div>
        <div id="mainListDiv" class="main_list">
            <ul class="navlinks">
                <li><a href="userLogin"><b>User Login</b></a></li>
                <li><a href="adminLogin"><b>Admin Login</b></a></li>
                <li><a href="#footer"><b>Contact</b></a></li>
            </ul>
        </div>
    </div>
</nav>

<section class="home">
</section>
<div style="height: 500px">
    <!-- just to make scrolling effect possible -->
        <h2 class="myH2"><center><strong>ABOUT</strong></h1></center></h1>
        <h2 class="myH2"><b>Online Bus Ticket Booking-The Easiest way</b></h2>
        <p class="myP1">"Live with no excuses and travel with no regrets"</p>
        <p class="myP"><strong>CONVENIENCE ON-THE-GO.</strong></p>
<pre class="myP">
            
Enjoy the following exclusive features on the bus booking app

Minute Booking - In a hurry to book a bus at the last minute?
Choose the bus passing from your nearest boarding point and book in a few easy steps.
Boarding Point Navigation - Never lose your way while travelling to your boarding point!
            
Comprehensive Ticket Details- Everything that you need to make the travel
hassle free - pickup points,rest points,easy payment and much more.
 </pre>
</div>

<!-- Jquery needed -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.1.1/jquery.min.js"></script>
<script src="js/scripts.js"></script>

<!-- Function used to shrink nav bar removing paddings and adding black background -->
<script>
    $(window).scroll(function() {
        if ($(document).scrollTop() > 50) {
            $('.nav').addClass('affix');
            console.log("OK");
        } else {
            $('.nav').removeClass('affix');
        }
    });
</script>
<footer class="sticky-footer">
    <ul >
        <li><a href="https://twitter.com/DXCTechnology">
            <ion-icon name="logo-twitter"></ion-icon>
        </a></li>
        <li><a href="https://www.facebook.com/DXCTechnology">
            <ion-icon name="logo-facebook"></ion-icon>
        </a></li>
        <li><a href="https://www.instagram.com/dxctechnology/">
            <ion-icon name="logo-instagram"></ion-icon>
        </a></li>
        <li><a href="https://www.linkedin.com/dxctechnology/">
            <ion-icon name="logo-linkedin"></ion-icon>
        </a>
    </ul>
    <p>
        <ion-icon name="help-circle"></ion-icon>
        Copyright 2022 DXC Technology</a></p>
</footer>
<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>
    