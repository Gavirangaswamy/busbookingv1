<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%-- <%@page import="com.dxctechproject.busticketbooking.Entity.Cancelled"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%> --%>
<!doctype html>
<html lang="en">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    <link rel="stylesheet" href="css/mystyle.css">
    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/css/bootstrap.min.css" integrity="sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm" crossorigin="anonymous">

    <title>Booked Tickets!</title>
    
    <script type="text/javascript">
    function onCancel(){
    	alert("Ticket cancelled Successfully!");
    }
    function onPrint(){
    	alert("Ticket printed Successfully!");
    }
    </script>
  </head>
  <body>
  <nav class="navbar navbar-expand-lg navbar-dark">
		<img alt="logo" src="images/img.png" class="logo">
		<div class="collapse navbar-collapse" id="navbarSupportedContent">
			<ul class="navbar-nav ml-auto">
				<li class="nav-item"><b><a href="searchbuspage">Back <ion-icon
								name="home"></ion-icon></b></a></li>

			</ul>
		</div>
	</nav>
  <div class="container">
  <div class="text-center mt-5 p-3 mb-2 bg-success text-white"style="margin-left: 15%;margin-right: 15%;">
  <h3>Booked Tickets</h3>
  </div>
  <c:if test="${bookedTickets.size()==0}">
  		<div class="container text-center mt-6">
			<label>No booked Tickets</label>
		</div>
  </c:if>
  
  <c:forEach items="${bookedTickets}" var="ticket">
  <div class="card mt-5 bg-info text-white border-info" style="margin-left: 25%;margin-right: 25%;border-width: thick;">
  	<div class="card-header text-center border-dark">
  	<span style="color: black;font-size: larger;"><b>TICKET</b></span>
  	</div>
	<div class="card-body" style="padding-bottom: 0px;">
	<form action = "cancelticket" method="post">
	<input type="hidden" name="ticketId" value="${ticket.getTicketId()}">
	<div class="row">
		<div class="col" align="center">
		<span><b>TICKET ID - ${ticket.getTicketId()}</b></span>
		</div>
	</div>
	<br>
	<div class="row" >
	<div class="col">
			<div class="row" >
				<span><b>BUS NAME</b></span>
			</div>
			<div class="row" >
				<span><b>ORIGIN</b></span>
			</div>
			<div class="row" >
				<span><b>BUS NO</b></span>
			</div>
			<div class="row">
				<span class="mr-3"><b>DATE</b></span>
			</div>
			<div class="row">
				<span><b>SEAT NO</b></span>
			</div>
		</div>
		<div class="col">
			<div class="row" >
				<span>${ticket.getBusName()}</span>
			</div>
			<div class="row" >
				<span>${ticket.getOrigin()}</span>
			</div>
			<div class="row" >
				<span>${ticket.getBusNumber()}</span>
			</div>
			<div class="row">
				<span class="mr-3">${ticket.getTravelDate()}</span>
			</div>
			<div class="row">
				<span>${ticket.getSeats()}</span>
			</div>
		</div>
		<div class="col">
			<div class="row">
				<span><b>ROUTE</b></span>
			</div>
			<div class="row">
				<span><b>DESTINATION</b></span>
			</div>
			<div class="row">
				<span><b>PASSENGERS</b></span>
			</div>
			<div class="row">
				<span><b>DEPARTURE TIME</b></span>
			</div>
			<div class="row">
				<span><b>FARE</b></span>
			</div>
		</div>
		<div class="col">
			<div class="row">
				<span>${ticket.getRouteName()}</span>
			</div>
			<div class="row">
				<span>${ticket.getDestination()}</span>
			</div>
			<div class="row">
				<span>${ticket.getCount() }</span>
			</div>
			<div class="row">
				<span>${ ticket.getTravelTime() }</span>
			</div>
			<div class="row">
				<span>${ ticket.getAmount() }</span>
			</div>
		</div>
		</div>
		<div class="card-footer text-muted" style="margin-top: 5px; margin-left: 0px;margin-right: 0px;">
			<a href="print/${ticket.getTicketId()}" onclick="onPrint();" class="btn btn-dark" aria-pressed="true">Print</a>
			
			<button type="submit" class="btn btn-dark" onclick="onCancel();" style="float: right;">Cancel</button>
		</div>
	</form>
	</div>
	</div>
  </c:forEach>
	</div>
    <!-- Optional JavaScript -->
    <!-- jQuery first, then Popper.js, then Bootstrap JS -->
    <script src="https://code.jquery.com/jquery-3.2.1.slim.min.js" integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.12.9/dist/umd/popper.min.js" integrity="sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q" crossorigin="anonymous"></script>
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@4.0.0/dist/js/bootstrap.min.js" integrity="sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl" crossorigin="anonymous"></script>
  </body>
</html>