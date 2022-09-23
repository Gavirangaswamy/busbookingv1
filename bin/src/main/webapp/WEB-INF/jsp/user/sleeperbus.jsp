<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %><!DOCTYPE html>
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
                <a href="" class="user"><i class="fa fa-user"></i></a>
               <a href="searchbuspage" class="home"><i class="fa fa-home"></i></a>
                <br>
                <h1 class="heading">Welcome to Transportation Services</h1><br>
         <input type="hidden" value="${sbus.tktFare}" id ="price">         
    <div class="container search-sec">
        <h2 class="sheading">Select Seats</h2>
    <ul class="showcase">
      <li>
        <div class="seat"></div>
        <small>N/A</small>
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
      <p class="ltext">LOWER</p> <p class="utext">UPPER</p> 
      <div class="row">
        <div class="seat sleeper">1</div>
        <div class="seat sleeper">2</div>
        <div class="seat sleeper">3</div>
        <div class="seat sleeper">4</div>
        <div class="seat sleeper">5</div>
        <div class="seat sleeper">6</div>
      </div>
      <div class="row">
        <div class="seat sleeper">7</div>
        <div class="seat sleeper">8</div>
        <div class="seat sleeper">9</div>
        <div class="seat sleeper">10</div>
        <div class="seat sleeper">11</div>
        <div class="seat sleeper">12</div>
      </div>

      <div class="row">
        <div class="seat sleeper">13</div>
        <div class="seat sleeper">14</div>
        <div class="seat sleeper">15</div>
        <div class="seat sleeper">16</div>
        <div class="seat sleeper">17</div>
        <div class="seat sleeper">18</div>
      </div>

      <div class="row">
        <div class="seat sleeper">19</div>
        <div class="seat sleeper">20</div>
        <div class="seat sleeper">21</div>
        <div class="seat sleeper">22</div>
        <div class="seat sleeper">23</div>
        <div class="seat sleeper">24</div>
      </div>

      <div class="row">
        <div class="seat sleeper">25</div>
        <div class="seat sleeper">26</div>
        <div class="seat sleeper">27</div>
        <div class="seat sleeper">28</div>
        <div class="seat sleeper">29</div>
        <div class="seat sleeper">30</div>
      </div>

      <div class="row">
        <div class="seat sleeper">31</div>
        <div class="seat sleeper">32</div>
        <div class="seat sleeper">33</div>
        <div class="seat sleeper">34</div>
        <div class="seat sleeper">35</div>
        <div class="seat sleeper">36</div>
      </div>
      <p class="text">
        You have selected <span id="count">0</span> seats for a price of Rs.<span id="total">0</span>
      </p>
    </div>
    
</div>


<div class="container1">
  <div class="brand-title">Select Pickup and Drop</div>
  <div class="inputs">
    <form action="payment">
    <label>Pickup</label>
    <input type="text" placeholder="Enter Your Pickup" name="pickup"/>
    <label>Drop</label>
    <input type="text" placeholder="Enter Your Drop" name="drop"/>
    <input type="hidden" value="" id="totalcount" name = "totalcount">
    <input type="hidden" value="" id="totalamount" name = "totalamount">
    <input type="hidden" value="" name = "seatnumbers" id="seatnum">
    <input type="hidden" value="${sbus.id}" name = "route">
    <input type="submit" class="btn" value="Book Ticket">
  </form> 
  </div>
</div>
    <script src="js/script.js"></script>
  </body>
</html>