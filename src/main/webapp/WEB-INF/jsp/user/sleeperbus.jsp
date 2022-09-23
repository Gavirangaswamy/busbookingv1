<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@page isELIgnored="false"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <meta charset="UTF-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge" />
    <meta name="viewport" content="width=device-width, initial-scale=1.0" />
    <link rel="stylesheet" href="css/seatsstyle.css" />
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
    <title>Bus Seat Booking</title>
  </head>
  <body>
                <h3 class="py-3"><a href="https://dxc.com/"> <img src="images/img.png" alt="" class="logo"></a></h3>
               <a href="searchbuspage" class="home"><i class="fa fa-home"></i></a>
                <br>
                <h1 class="heading">Welcome to Transportation Services</h1><br>
         <input type="hidden" value="${sbus.tktFare}" id ="price"> 
         <input type="hidden" value="${bseats}" id ="seats1">        
    <div class="container search-sec">
        <h2 class="sheading">Select Seats</h2>
    <ul class="showcase">
      <li>
        <div class="seat"></div>
        <small>Available</small>
      </li>

      <li>
        <div class="seat selected"></div>
        <small>Selected</small>
      </li>

      <li>
        <div class="seat occupied"></div>
        <small>Occupied</small>
      </li>
    </ul>
    <div class="sleeper-container">
     <p class="text">
        You have selected <span id="count">0</span> seats for a price of Rs.<span id="total">0</span>
      </p>
      <p class="ltext">LOWER</p> <p class="utext">UPPER</p> 
      <div class="row">
      <% String seatnos = (String)request.getAttribute("seatnos");
      for(int i=1;i<=Integer.valueOf(seatnos);i++){ %>
      <div class="seat sleeper"><%=i %></div>
      <% if(i%6==0){ %>
      </div>
      <div class="row">
      <%} %>
      
      <% } %>
      </div>
    </div>
    
</div>


<div class="container1">
  <div class="brand-title">Select Pickup and Drop</div>
  <div class="inputs">
    <form action="bookingprocess">
    <div class="item">
		<label for="type">Pick Up</label><br> <select id="pickup"
			name="pickup" required="required">
			<option></option>
			<c:forEach items="${pickUps}" var="pickup">
				<option><c:out value="${pickup}" /></option>
			</c:forEach>
		</select>
	</div>
	<br>
	<div class="item">
		<label for="type">Drop</label><br> <select id="drop"
			name="drop" required="required">
			<option></option>
			<c:forEach items="${drops}" var="drop">
				<option><c:out value="${drop}" /></option>
			</c:forEach>
		</select>
	</div>
    <input type="hidden" value="" id="totalcount" name = "totalcount">
    <input type="hidden" value="" id="totalamount" name = "totalamount">
    <input type="hidden" value="" name = "seatnumbers" id="seatnum">
    <input type="hidden" value="${sbus.id}" name = "route">
    <input type="hidden" value="${user}" name = "user">
    <input type="submit" class="btn" value="Book Ticket">
    <p style="color:red">${msg}</p>
  </form> 
  </div>
</div>
    <script src="js/script.js"></script>
  </body>
</html>