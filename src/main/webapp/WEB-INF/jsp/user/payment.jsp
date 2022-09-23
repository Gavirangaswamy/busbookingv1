<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
         pageEncoding="ISO-8859-1" %>
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
    <form method="post" action="submitPaymentDetail">
    <div class="container register">
        <div class="row">
            <div class="col-md-9 register-right">
                <div class="tab-content" id="myTabContent">
                    <div class="tab-pane fade show active" id="home" role="tabpanel" aria-labelledby="home-tab">
                        <div class="form-step form-step-active border">
                        <h2 style="position: relative;">Contact Info</h2>
				        <div class="input-group">
				          <label for="phone">Phone</label>
				          <input type="tel" pattern="^[6-9][0-9]{9}$" title="enter valid number" name="phone" id="phone" placeholder="999-999-9999" required />
				        </div>
				        <div class="input-group">
				          <label for="email">Email</label>
				          <input type="email" name="email" id="email" placeholder="abc@email.com" required />
				       	</div>
				        </div>
                        <div class="row register-form">
                        <div class="col-md-10">
                            <input id="user" type="hidden" class="form-control" placeholder="Customer ID" value="${user }" name="custId"/>
                            <br>
                            <div class="form-group">
                            <label for="Amount">Total Amount</label>
                                <input id="Amount" type="text" class="form-control" placeholder="Amount" value="${totalamount}" name="txnAmount" readonly="readonly"/>
						        <input type="hidden" value="${route}" name ="routeid">
						        <input type="hidden" value="${seatnumbers}" name ="seats">
						        <input type="hidden" value="${totalcount}" name ="count">
						        <input type="hidden" value="${totalamount}" name ="amount">
						        <input type="hidden" value="${pickup}" name ="pickup">
						        <input type="hidden" value="${drop}" name ="droppoint">
						        <input type="hidden" value="${user}" name ="user">
						        <input type="submit" value="Make Payment" class="btn" />
					        </div>
			                </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    </div>
    <!-- <form action="ticket" class="form"> -->
        <!-- Steps -->

      
        
        
        
    </form>
  </body>
</html>