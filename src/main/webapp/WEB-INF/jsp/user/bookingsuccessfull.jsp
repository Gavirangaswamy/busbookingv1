<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
         
         <%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel="stylesheet" href="css/Payment.css">
    <link rel="stylesheet" type="text/css" href="https://stackpath.bootstrapcdn.com/font-awesome/4.7.0/css/font-awesome.min.css">

    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
    <title>Complete your Booking</title>
</head>
<body>

    <header>
        <h1 class="logo"> <img alt="Qries" src="images/img.png"
            width=300" height="65"></h1>

        <div class="menu-icons-container">
          <a href="searchbuspage" class="home"><i class="fa fa-home"></i></a>
        </div>
    </header>
    <div>
    <c:if test="${cond }"><b><p align="center" style="font-size:xx-large;">Transaction Successful<img src="images/Check.png" width="30" height="30"></p></b></c:if>
    <c:if test="${!cond }"><b><p align="center" style="font-size:xx-large;">Transaction Failed<img src="images/failed.jpg" width="30" height="30"></p></b></c:if>
    <form action="searchbuspage" class="form">  
          <div class="btns-group">
          <c:if test="${cond }">
          <a href="print/${ticketId}" class="btn btn-prev" role="button"
											aria-pressed="true">Download</a></c:if>
          <input type="hidden" value="${user}" name="user">
          <input type="submit" class="btn btn-prev" value="Continue" style="position: relative;">
        </div>
    </form>
    </div>
  </body>
</html>