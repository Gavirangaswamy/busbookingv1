<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">
    <link rel="stylesheet" href="css/addBusStyles.css">
    <title>Tickets!</title>
  </head>
  <body style="background-image: url('images/home_image.jpg');">
<nav style="height: 25%;width: 100%;background-color: rgba(41, 170, 221, 0.68);clear: both;">
    <img alt="logo" src="images/logo.png" style="width: 7%;padding-left: 4px;">
    <div class="collapse navbar-collapse" id="navbarSupportedContent">
        <ul class="navbar-nav ml-auto">
            <li style="padding: 0 18px;"><b><a href="index.html" type="button">Back
                <ion-icon name="home"></ion-icon></b></a>
            </li>

        </ul>
    </div>
    <div class="container" >
  <div class="btn-group" role="group" aria-label="Button group with nested dropdown" style="float: right;" >
    <button id="btnGroupDrop1" type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown">
      View Tickets
    </button>
    <div class="dropdown-menu" aria-labelledby="btnGroupDrop1">
    	<form action="bookedtickets">
			<input class="btn btn-primary dropdown-item" type="submit" value="booked tickets">
		</form>
		
		<form action="cancelledtickets">
			<input class="btn btn-primary dropdown-item"type="submit" value="cancelled tickets">
		</form>
      	<button class="btn btn-primary dropdown-item" type="button" data-toggle="collapse" data-target="#canceltickets">cancel ticket</button> 		
   		 </div>
  		</div>
  	</div>
</nav>

<div id="selector">
	<div class="collapse single-collapse" id="canceltickets" data-parent="#selector" style="padding-right: 10%; padding-left: 10%;">
    <div class="embed-responsive embed-responsive-9by16">
	<form action="cancelTicket" method="post">
		<div class="form-group">
		<label for="Name">Ticket Id</label>
	    	<input type="text" class="form-control" id="Name" name="ticketId" placeholder="Enter Ticket Id">
	    </div>
	    <div class="form-group text-center">
	  	<button type="submit" class="btn btn-primary text-center" >submit</button>
	  	</div>
	  	</form>
	</div>
	</div>
    <div class="collapse single-collapse" id="bookedtickets" data-parent="#selector" style="padding-right: 10%; padding-left: 10%;">
    <div class="embed-responsive embed-responsive-16by9">
  <iframe class="embed-responsive-item" src="/bookedtickets"></iframe>
	</div>
	</div>
    <div class="collapse single-collapse" id="cancelledtickets" data-parent="#selector" style="padding-right: 10%; padding-left: 10%;">
    <div class="embed-responsive embed-responsive-16by9">
  <iframe class="embed-responsive-item" src="/cancelledtickets"></iframe>
	</div>
	</div>
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>