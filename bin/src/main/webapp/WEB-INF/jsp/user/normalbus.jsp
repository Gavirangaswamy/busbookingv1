<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
                <a href="" class="user"><i class="fa fa-user"></i></a>
               	<a href="searchbuspage" class="home"><i class="fa fa-home"></i></a>
                <br>
                <h1 class="heading">Welcome to Transportation Services</h1><br>
                 <input type="hidden" value="${sbus.tktFare}" id ="price">
                 <input type="hidden" value="${seats}" id ="seats1">
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

    <div class="seat-container">
      <p class="text">
        You have selected <span id="count">0</span> seats for a price of Rs.<span id="total">0</span>
      </p>
      <div class="row">
        <div class="seat">1</div>
        <div class="seat">2</div>
        <div class="seat">3</div>
        <div class="seat">4</div>
        <div class="seat">5</div>
      </div>
      <div class="row">
        <div class="seat">6</div>
        <div class="seat">7</div>
        <div class="seat">8</div>
        <div class="seat">9</div>
        <div class="seat">10</div>
      </div>

      <div class="row">
        <div class="seat">11</div>
        <div class="seat">12</div>
        <div class="seat">13</div>
        <div class="seat">14</div>
        <div class="seat">15</div>
      </div>

      <div class="row">
        <div class="seat">16</div>
        <div class="seat">17</div>
        <div class="seat">18</div>
        <div class="seat">19</div>
        <div class="seat">20</div>
      </div>

      <div class="row">
        <div class="seat">21</div>
        <div class="seat">22</div>
        <div class="seat">23</div>
        <div class="seat">24</div>
        <div class="seat">25</div>
      </div>

      <div class="row">
        <div class="seat">26</div>
        <div class="seat">27</div>
        <div class="seat">28</div>
        <div class="seat">29</div>
        <div class="seat">30</div>
      </div>
      <div class="row">
        <div class="seat">31</div>
        <div class="seat">32</div>
        <div class="seat">33</div>
        <div class="seat">34</div>
        <div class="seat">35</div>
      </div>

      <div class="row">
        <div class="seat">36</div>
        <div class="seat">37</div>
        <div class="seat">38</div>
        <div class="seat">39</div>
        <div class="seat">40</div>
      </div>
      <div class="row">
        <div class="seat">41</div>
        <div class="seat">42</div>
        <div class="seat">43</div>
        <div class="seat">44</div>
        <div class="seat">45</div>
      </div>

      <div class="row">
        <div class="seat">46</div>
        <div class="seat">47</div>
        <div class="seat">48</div>
        <div class="seat">49</div>
        <div class="seat">50</div>
      </div>
    </div>
    
</div>


<div class="container1">
  <div class="brand-title">Select Pickup and Drop</div>
  <div class="inputs">
  <form action="payment">
    <label>Pickup</label>
    <input type="text" placeholder="Enter Your Pickup" />
    <label>Drop</label>
    <input type="text" placeholder="Enter Your Drop" />
    <input type="hidden" value="" id="totalamount" name = "totalamount">
    <input type="hidden" value="" id="totalcount" name = "totalcount">
    <input type="hidden" value="" name = "seatnumbers" id="seatnum">
   	<input type="hidden" value="${sbus.id}" name = "route">
    <input type="submit" class="btn" value="Book Ticket">
    </form> 
  </div>
</div>
    <script src="js/script.js"></script>
  </body>
</html>