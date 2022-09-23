<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="utf-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page isELIgnored="false" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>Add Bus</title>
    <link rel="stylesheet"
          href="https://stackpath.bootstrapcdn.com/bootstrap/4.1.3/css/bootstrap.min.css"
          integrity="sha384-MCw98/SFnGE8fJT3GXwEOngsV7Zt27NXFoaoApmYm81iuXoPkFOJwJ8ERdknLPMO"
          crossorigin="anonymous">
    <link rel="stylesheet" href="css/addBusStyles.css">


    <!-- Google Fonts -->
    <link
            href="https://fonts.googleapis.com/css2?family=Montserrat:wght@400;900&family=Ubuntu:wght@300&display=swap"
            rel="stylesheet">
    <!-- Fontawesome Icons -->
    <script src="https://kit.fontawesome.com/2c135d6bdb.js"
            crossorigin="anonymous"></script>
    <link rel="stylesheet" href="https://www.w3schools.com/w3css/4/w3.css">

<script type="text/javascript">
function seatsStep() {
	 var p = document.getElementById("type").value;
	if(p==="Sleeper"||p==="AC-Sleeper"){
		document.getElementById("numbers").min="18";
		document.getElementById("numbers").max="36";
		document.getElementById("numbers").setAttribute("step",6);
	}else{
		document.getElementById("numbers").min="25";
		document.getElementById("numbers").max="50";
		document.getElementById("numbers").setAttribute("step",5);
	}
}
</script>
</head>

<body>
<!-- Nav Bar -->
<nav class="navbar navbar-expand-lg navbar-dark">
    <img alt="logo" src="images/img.png" class="logo">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
             <li class="nav-item"><b><a href="AdminDashboard">Dashboard
                <ion-icon name="home"></ion-icon></b></a>
            </li>

        </ul>
    </div>
</nav>
<section id="title">
    <img class="log">
    <div class="testbox">
        <form action="saveBus" method="post">
            <div class="banner">
                <h1>Add Bus</h1>
            </div>
            <H6 class="top-info">Create Bus Record by Adding following Details</H6><br><br>
            <div class="item">


                <div class="name-item">
                    <p>
                        Bus Name<span class="required">*</span>
                    </p>
                    <input type="text" name="busName" placeholder="Enter Bus Name"/>
                </div>
                <p>
                    Bus Register Number <span class="required">*</span>
                </p>
                <div class="name-item">
                    <input type="text" name="busRegNo"
                           placeholder="Enter Bus Register Number"
                           required/>
                </div>
                <div class="item">
                    <p>
                        Start date<span class="required">*</span>
                    </p>
                    <input type="datetime-local" name="createdAt" required
                    /> <i class="fas fa-calendar-alt"></i>
                </div>
                <br>
                <div class="item">
                    <p>
                        End date<span class="required">*</span>
                    </p>
                    <input type="datetime-local" name="updatedAt"
                           required> <i
                        class="fas fa-calendar-alt"></i>
                </div>
            </div>
            <br>
            <div class="question">
                <p>
                    What is your current Bus type?<span class="required">*</span>
                </p>
                <div class="name-item">
                    <select id="type" name="busType" class="busType" onchange="seatsStep()">
            			<option value="" disabled selected >Select Your Bus Type</option>
            			<option value="AC-Sleeper">AC-Sleeper</option>
           				<option value="Normal">Normal</option>
           				<option value="Sleeper">Sleeper</option>
       				 </select>
                </div>
                
                                <p>
                    No Of Seats<span class="required">*</span>
                </p>
                <div class="name-item">
                    <input type="number" name="no_of_seats"
                           placeholder="Enter Number Of Seats" id="numbers">
                </div>
            </div>
            <br>
            <div class="btn-block">
                <button type="submit" href="/">Add Bus</button>
                <p> Check your bus details? <a href="displayBuses"> Click here</a></p>
            </div>
        </form>
    </div>
</section>
<!-- Footer -->

<footer id="footer">
    <ul class="mylogo">
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
        </a></li>
    </ul>
    <p>
        <ion-icon name="help-circle"></ion-icon>
        Copyright 2022 <a href="https://dxc.com/in/en">DXC Technology</a></p>
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

<script type="module" src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.esm.js"></script>
<script nomodule src="https://unpkg.com/ionicons@5.5.2/dist/ionicons/ionicons.js"></script>
</body>
</html>