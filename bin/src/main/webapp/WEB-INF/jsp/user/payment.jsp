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
    <script src="js/Main.js" defer></script>
    <script src="js/Dynamic.js" defer></script>
    <script src="js/Tabs.js" defer></script>
    <script src="https://kit.fontawesome.com/2c135d6bdb.js" crossorigin="anonymous"></script>
    <title>Complete your Booking</title>
</head>
<body>

    <header>
        <h1 class="logo"> <img alt="Qries" src="images/img.png"
            width=300" height="65"></h1>
        
            <div class="progressbar">
                <div class="progress" id="progress"></div>
                
                <div
                  class="progress-step progress-step-active"
                  data-title="Passenger Details"
                ></div>
                <div class="progress-step" data-title="Contact Details"></div>
                <div class="progress-step" data-title="Payment Method"></div>
                <div class="progress-step" data-title="Payment Status"></div>
              </div>



        <div class="menu-icons-container">
          <a href="" class="user"><i class="fa fa-user"></i></a>
          <a href="searchbuspage" class="home"><i class="fa fa-home"></i></a>
        </div>
    </header>
    <form action="ticket" class="form">
        <!-- Steps -->
      <div class="form-step form-step-active">
        <div id="survey_options">
        <div class="input-group">
          <label for="pname">Passenger name</label>
          <input type="text" name="survey_options[]" class="survey_options" size="50" id="pname" required />
        </div>
        <div class="input-group">
          <label for="page">Age</label>
          <input type="text" name="survey_options[]" class="survey_options" size="50" id="page" required />
          <label for="gender"> Select you gender</label>
<select name="gender">
	<option value="none" selected>Gender</option>
	<option value="male">Male</option>
	<option value="female">Female</option>
	<option value="other">other</option>
</select>
        </div>
        <div class="controls">
            <a href="#" id="add_more_fields"><i class="fa fa-plus"></i>Add More</a>
            <a href="#" id="remove_fields"><i class="fa fa-minus"></i>Remove</a>
          </div>
        </div>
        <div class="">
          <a href="#" class="btn btn-next width-50 ml-auto">Next</a>
        </div>
      </div>
      <div class="form-step">
        <div class="input-group">
          <label for="phone">Phone</label>
          <input type="text" name="phone" id="phone" placeholder="999-999-9999" required />
        </div>
        <div class="input-group">
          <label for="email">Email</label>
          <input type="text" name="email" id="email" placeholder="abc@email.com" required />
        </div>
        <div class="btns-group">
          <a href="#" class="btn btn-prev">Previous</a>
          <a href="#" class="btn btn-next">Next</a>
        </div>
      </div>
      <div class="form-step">
        <div class="input-group">
          <!-- Tab links -->
<div class="tab">
    <button class="tablinks" onclick="openCity(event, 'Cards')">Cards</button>
    <button class="tablinks" onclick="openCity(event, 'NetBanking')">NetBanking</button>
    <button class="tablinks" onclick="openCity(event, 'UPI')">UPI</button>
</div>
    <div id="Cards" class="tabcontent">
    <div class="container">
        <h1>Enter Your Card Details</h1>
        <div class="first-row">
            <div class="cardname">
                <h3>Name On Card</h3>
                <div class="input-field">
                    <input type="text">
                </div>
            </div>
            <div class="cvv">
                <h3>CVV</h3>
                <div class="input-field">
                    <input type="password">
                </div>
            </div>
        </div>
        <div class="second-row">
            <div class="card-number">
                <h3>Card Number</h3>
                <div class="input-field">
                    <input type="text">
                </div>
            </div>
        </div>
        <div class="third-row">
            <h3>Card Expiry</h3>
            <div class="selection">
                <div class="date">
                    <select name="months" id="months">
                        <option value="Jan">Jan</option>
                        <option value="Feb">Feb</option>
                        <option value="Mar">Mar</option>
                        <option value="Apr">Apr</option>
                        <option value="May">May</option>
                        <option value="Jun">Jun</option>
                        <option value="Jul">Jul</option>
                        <option value="Aug">Aug</option>
                        <option value="Sep">Sep</option>
                        <option value="Oct">Oct</option>
                        <option value="Nov">Nov</option>
                        <option value="Dec">Dec</option>
                      </select>
                      <select name="years" id="years">
                        <option value="2030">2030</option>
                        <option value="2029">2029</option>
                        <option value="2028">2028</option>
                        <option value="2027">2027</option>
                        <option value="2026">2026</option>
                        <option value="2025">2025</option>
                        <option value="2024">2024</option>
                        <option value="2023">2023</option>
                        <option value="2022">2022</option>
                      </select>
                </div>
                <div class="cards">
                    <img src="Resources/mc.png" alt="">
                    <img src="Resources/vi.png" alt="">
                    <img src="Resources/pp.png" alt="">
                </div>
            </div>    
        </div>
        </div>
        <a href="#">Confirm</a>
    </div>
    <div id="NetBanking" class="tabcontent">
        <div class="netbanking">
            <div class="h-text">Popular banks </div>
            <ul>
                                                                    <li class="bank1">
                        <label>
                            <input name="major_nb" id="major_nb" type="radio" value="NB_AXIS">
                        </label>
                    </li>
                                                                    <li class="bank2">
                        <label>
                            <input name="major_nb" id="major_nb" type="radio" value="NB_HDFC">
                        </label>
                    </li>
                                                                    <li class="bank3">
                        <label>
                            <input name="major_nb" id="major_nb" type="radio" value="NB_SBI">
                        </label>
                    </li>
                                                                    <li class="bank4">
                        <label>
                            <input name="major_nb" id="major_nb" type="radio" value="NB_KOTAK">
                        </label>
                    </li>
                                                                    <li class="bank5">
                        <label>
                            <input name="major_nb" id="major_nb" type="radio" value="NB_ICICI">
                        </label>
                    </li>
                                                            </ul>
        </div>
        <table width="100%" border="0" cellspacing="0" cellpadding="0">
            <tr height="32">
                <td width="20%">Bank Name </td>
                <td width="80%"><select name="nb_BankName" id="nb_BankName" class="dropdown_custom">
                        <option value="">--Please select your bank --</option>
                                                                                   <option value="NB_AXIS">Axis Bank</option>
                                                                                   <option value="NB_BOB">Bank of Baroda</option>
                                                                                   <option value="NB_CANR">Canara Bank</option>
                                                                                  <option value="NB_HDFC">HDFC Bank</option>
                                                                                    <option value="NB_ICICI">ICICI Netbanking</option>
                                                                                    <option value="NB_IDBI">IDBI Bank</option>
                                                                                    <option value="NB_IDFC">IDFC Bank</option>
                                                                                  <option value="NB_IOB">Indian Overseas Bank</option>
                                                                                    <option value="NB_INDUS">IndusInd Bank</option>
                                                                                   <option value="NB_KVB">Karur Vysya Bank</option>
                                                                                    <option value="NB_KOTAK">Kotak Bank</option>
                                                                                    <option value="NB_PNB">Punjab National Bank</option>
                                                                                    <option value="NB_SCB">Standard Chartered Bank</option>
                                                                                    <option value="NB_SBI">State Bank of India</option>
                                                                                    <option value="NB_SYNB">Syndicate Bank</option>
                                                                                     <option value="NB_UBI">Union Bank of India</option>
                                                                                  <option value="NB_YESB">Yes Bank</option>
                                                                            </select>
                </td>
            </tr>
        </table>
        <a href="">Confirm</a>
    </div>



      </div>
      <div id="UPI" class="tabcontent">
        <h3 style="margin-left:10px !important;"><input type="radio" type="hidden" id="phonepe" name="phonepe" value="phonepe" class="phonepe" /><img src="Resources/ppe.png" width='75px' alt="Phonepe"></h3>
        <input type="email" value="enter phonepe number" placeholder="9999999999@abc">
        <input type="radio" type="hidden" id="gpay" name="gpay" value="gpay" class="gpay" />
        <input type="hidden" id="gpay" value="gpay"><img src="Resources/gpay.png" alt="gpay">
											<div> Enter your Google Pay mobile number:
												<input type="text" name="gpay_mobileno" value="" placeholder="Google Pay mobile number" style="width:170px;" maxlength="10" />
											</div>
      </div>
        <div class="btns-group">
        <input type="hidden" value="${route}" name ="routeid">
        <input type="hidden" value="${seatnumbers}" name ="seats">
        <input type="hidden" value="${totalcount}" name ="count">
        <input type="hidden" value="${totalamount}" name ="amount">
        <input type="hidden" value="${user}" name ="user">
          <a href="#" class="btn btn-prev">Previous</a>
          <input type="submit" value="Make Payment" class="btn" />
        </div>
      </div>
    </form>
  </body>
</html>