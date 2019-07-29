<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Change Password</title>



<script
  src="https://code.jquery.com/jquery-3.4.1.min.js"
  integrity="sha256-CSXorXvZcTkaix6Yvo6HppcZGetbYMGWSFlBw8HfCJo="
  crossorigin="anonymous"></script>

<link href="https://fonts.googleapis.com/icon?family=Material+Icons" rel="stylesheet">

  <!-- Compiled and minified CSS -->
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/css/materialize.min.css">

    <!-- Compiled and minified JavaScript -->
    <script src="https://cdnjs.cloudflare.com/ajax/libs/materialize/1.0.0/js/materialize.min.js"></script>
                        
<script>
document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.sidenav');
    var instances = M.Sidenav.init(elems, options);
  });

  // Initialize collapsible (uncomment the lines below if you use the dropdown variation)
  // var collapsibleElem = document.querySelector('.collapsible');
  // var collapsibleInstance = M.Collapsible.init(collapsibleElem, options);

  // Or with jQuery

  $(document).ready(function(){
    $('.sidenav').sidenav();
  });

  
//  var instance = M.Sidenav.getInstance(elem);


//modal
 document.addEventListener('DOMContentLoaded', function() {
    var elems = document.querySelectorAll('.modal');
    var instances = M.Modal.init(elems, options);
  });

  // Or with jQuery

  $(document).ready(function(){
    $('.modal').modal();
  });


  $(document).ready(function(){
	    $('select').formSelect();
	  });
	      
  
  


</script>





</head>
<body style="overflow-x:hidden">



<nav style="position:fixed;z-index:100">


<img src="logo.png" style="padding-left: 32%">



<a class="waves-effect waves-light btn" href="Login.jsp" style="
    position: relative;
    left: 30%;
    top: -42px;
    background-color: #ee6e73;
">Home</a>

</nav>



 <!-- Modal Structure modal 2 -->
  <div id="modal2" class="modal" style="max-height: 84%">
    <div class="modal-content">
      <h4 align="center"><u>About Us</u></h4>
      
    </div>
    



    <div class="col s12 m7">
      <div class="card">
        <div class="card-image">
          <img src="aboutUs.jpg">
          <span class="card-title">About Us</span>
        </div>
        <div class="card-content">
          <p>
          
          As one of the leading community health care providers in Bangalore,S.V.U HEALTH CARE is dedicated to providing comprehensive primary health care services to the residents of Bangalore. With two state-of-the-art facilities in the metropolitan area, Family Care also works to improve the overall health of the communities it serves by reducing barriers to health care. Family Care provides care at a third site located within Places for People.Comprehensive health care is provided regardless of one’s health insurance status. Family Care accepts private, Medicaid and Medicare insurance plans. To bridge communication gaps with non-English speaking patients, staff provides interpretation services for some part of Bangalore patients and uses outside resources for patients speaking other languages.Family Care Health Centers offers patients convenience, quality and innovation in primary care. Our Providers use evidence-based medical care to address your physical and mental health needs. We coordinate your care across multiple care settings – visits to sub-specialists, the ER and the hospital. Through our exchange of information we help you better understand your medical conditions and provide the education and tools you need to take charge of your health. Our Health Centers offer convenient hours of operation including 24 hour access to physician telephone consultation for emergencies – all part of Bangalore to being your “Health Care Partner For Life”.                               
          
          
          </p>
        </div>
    
      </div>
    </div>

    
    
    
    
  </div>









  


<br><br><br><br><br>


<div class="row" style="padding-left: 33%;
    margin-right: -25%;">
    <div class="col s12 m5">
      <div class="card-panel teal" style="background-color: #ee6e73 !important">
       
         <div class="row">
    <form id="form13" action="ChangePassword" method="post"  class="col s12">
      <div class="row">
        <div class="input-field col s12"  >
          <input placeholder=" Enter OTP" name="otp" style="color: white"  type="number" class="validate" required>
          <label style="color: white">OTP</label>
        </div>
    
      </div>
       <div class="row">  
      
      
        <div class="input-field col s12">
          <input Placeholder="Enter your New Password" name="pass1" style="color: white"  id="password" type="text" class="validate" required>
          <label  style="color: white">New Password</label>
        </div>
    </div>

      
      

      <div class="row">
        <div class="input-field col s12">
          <input Placeholder="Enter your New Password Again" name="pass2" style="color: white"  id="password" type="text" class="validate" required>
          <label  style="color: white">Renter Password</label>
        </div>
      </div>


<a class="waves-effect waves-light btn" style="margin-left:38%"  onclick="document.getElementById('form13').submit();"><i class="material-icons left">send</i>Submit</a>


    </form>
  </div>
       
       
      </div>
    </div>










 
</body>
</html>