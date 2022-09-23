<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <link rel="stylesheet" href="css/searchRoutesstyle.css">
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Search Routes</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-EVSTQN3/azprG1Anm3QDgpJLIm9Nao0Yz1ztcQTwFspd3yD65VohhpuuCOmLASjC" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.0.2/dist/js/bootstrap.bundle.min.js" integrity="sha384-MrcW6ZMFYlzcLA8Nl+NtUVF0sA7MsXsP1UyJoMp4YLEuNSfAP+JcXn/tWtIaxVXM" crossorigin="anonymous"></script>
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
    
</head>
<body>
    <div class="container">
    <div class="row pt-1 pb-1">
        <div class="col-lg-12 text-center">
               <h3 class="py-3"><a href="https://dxc.com/"> <img src="images/img.png" alt="" class="logo"></a></h3>
               <a href="" class="user"><i class="fa fa-user"></i></a>
               <a href="index.html" class="home"><i class="fa fa-home"></i></a>
               <br>

            <h2 class="text-center">Welcome to Transportation Services</h2>
            <h5 class="tagline"><q>Live with no excuses and travel with no regrets</q></h5>
            
        </div>
    </div>
</div>
<section>

                <section class="search-sec">
                    <div class="container">
                        <form action="searchBus" method="get" novalidate="novalidate">
                            <div class="row">
                                <div class="col-lg-6 BusStyle">
                                <img src="images/bus.png" class="d-block w-100" alt="...">
                            </div>
                                <div class="col-lg-5">
                                <p style="color: #EB1D36; font-size :20px">${msg}</p>
                                    <div class="row">
                                            <input type="text" class="form-control search-slt" placeholder="Enter Origin" name="origin">
                                        
                                        
                                            <input type="text" class="form-control search-slt" placeholder="Enter Destination" name="destination">
                                        
                                        
                                            <input type="date" class="form-control search-slt" placeholder="Select Date" name="date">
                                        
                                        
                                            <input type="submit" class="btn btn-danger wrn-btn" value="Search Buses">
                                        
                                    </div>
                                </div>
                            </div>
                        </form>
                    </div>
                </section>

            </div>
        </div>
    </div>
</section>

    
</body>
</html>