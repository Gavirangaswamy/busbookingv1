var password = document.getElementById("pass");
var msg = document.getElementById("pmsg");
var emsg = document.getElementById("emsg");
var cmsg = document.getElementById("cmsg");
var str = document.getElementById("strength");
var email = document.getElementById("email");
var contact = document.getElementById("contact");
password.addEventListener("input", function(){
    if(password.value.length>0){
        msg.style.display = "block";
    }
    else{
        msg.style.display = "none";
    }
    if(password.value.length<4){
        str.innerHTML = "Week"
        str.style.color = "#ff5925"
        password.style.borderColor = "#ff5925"
    }
    else if(password.value.length>=4 && password.value.length<8){
        str.innerHTML = "Medium"
        str.style.color = "yellow";
        password.style.borderColor = "yellow"
    }
    else if(password.value.length>=9){
        str.innerHTML = "Strong"
        str.style.color = "green"
        password.style.borderColor = "green"
        // msg.style.display = "none";
    }
    
});

email.addEventListener("input", function(){
     var mailformat = /^([A-Za-z]+[0-9]?)+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})$/;
	 if (email.value.match(mailformat)) {
		  	emsg.style.display = "none";
   	 }else{
			emsg.style.display = "block";
			emsg.innerHTML = "Please Enter Valid email"
       	  	emsg.style.color = "red";
	}
 
    
    
});
contact.addEventListener("input", function(){
     var contactformat = /^[6-9][0-9]{9}$/;
	 if (contact.value.match(contactformat)) {
		  	cmsg.style.display = "none";
   	 }else{
			cmsg.style.display = "block";
			cmsg.innerHTML = "Please Enter Valid contact"
       	  	cmsg.style.color = "red";
	}
 
    
    
});

