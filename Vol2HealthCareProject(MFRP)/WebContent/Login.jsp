<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Login</title>



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





</script>





</head>
<body>



<nav>


<img src="logo.png" style="padding-left: 38%">

<!--
<a href="#" data-target="slide-out" class="sidenav-trigger" style="display: inline;"><i style="font-size: 50px" class="material-icons">menu</i></a>
 -->





<a class="waves-effect waves-light btn modal-trigger" href="#modal1" style="
    position: relative;
    left: 24%;
    top: -43px;
    background-color: #ee6e73;
">Login</a>



<a class="waves-effect waves-light btn modal-trigger" href="#modal2" style="
    position: relative;
    left: 118px;
    top: -43px;
    background-color: #ee6e73;
">About Us</a>
</nav>


<img src="home2.jpg" style="height: 592px;
    width: 100%;">


  <!-- Modal Structure -->
  <div id="modal1" class="modal">
    <div class="modal-content">
      <h4 align="center"><u>Login Form</u></h4>
      
    </div>
    
    <div class="row">
    <form class="col s12" id="form12" action="welcome" method="post">
      <div class="row">
        <div class="input-field col s6">
          <i class="material-icons prefix">account_circle</i>
          <input id="icon_prefix" name="id" type="text" class="validate">
          <label for="icon_prefix">Id</label>
        </div>
        
        <div class="input-field col s6">
          <i class="material-icons prefix">enhanced_encryption</i>
          <input id="icon_telephone" name="password" type="password" class="validate">
          <label for="icon_telephone">Password</label>
        </div>
      </div>


<a class="waves-effect waves-light btn" style="margin-left:46%"  onclick="document.getElementById('form12').submit();"><i class="material-icons left">send</i>Submit</a>
<a class="waves-effect waves-light btn modal-trigger" href="#modal3" style="margin-left:72%;margin-top: -5%;" ><i class="material-icons left">https</i>Forgot Password</a>

<!-- <div class="modal-footer">
     <a class="waves-effect waves-light btn"><i class="material-icons left">send</i>Submit</a>
    </div> -->
    
    </form>
  </div>
    
    
    
    
  </div>











  <div id="modal3" class="modal">
    <div class="modal-content">
      <h4 align="center"><u>Forgot Password</u></h4>
      
    </div>
    
    <div class="row">
    <form class="col s12" id="form13" action="forgotPassword" method="post">
      <div class="row">
        <div class="input-field col s12">
          <i class="material-icons prefix">account_circle</i>
          <input id="icon_prefix" name="id" type="text" class="validate">
          <label for="icon_prefix">Id</label>
        </div>
     
      </div>


<a class="waves-effect waves-light btn" style="margin-left:45%"  onclick="document.getElementById('form13').submit();"><i class="material-icons left">send</i>Submit</a>

<!-- <div class="modal-footer">
     <a class="waves-effect waves-light btn"><i class="material-icons left">send</i>Submit</a>
    </div> -->
    
    </form>
  </div>
    
    
    
    
  </div>




























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
          <p>As one of the leading community health care providers in Bangalore,S.V.U HEALTH CARE is dedicated to providing comprehensive primary health care services to the residents of Bangalore. With two state-of-the-art facilities in the metropolitan area, Family Care also works to improve the overall health of the communities it serves by reducing barriers to health care. Family Care provides care at a third site located within Places for People.Comprehensive health care is provided regardless of one’s health insurance status. Family Care accepts private, Medicaid and Medicare insurance plans. To bridge communication gaps with non-English speaking patients, staff provides interpretation services for some part of Bangalore patients and uses outside resources for patients speaking other languages.Family Care Health Centers offers patients convenience, quality and innovation in primary care. Our Providers use evidence-based medical care to address your physical and mental health needs. We coordinate your care across multiple care settings – visits to sub-specialists, the ER and the hospital. Through our exchange of information we help you better understand your medical conditions and provide the education and tools you need to take charge of your health. Our Health Centers offer convenient hours of operation including 24 hour access to physician telephone consultation for emergencies – all part of Bangalore to being your “Health Care Partner For Life”.                               
</p>
        </div>
     
      </div>
    </div>

    
    
    
    
  </div>













  <ul id="slide-out" class="sidenav">
    <li><div class="user-view">
      <div class="background">
        <img src="images/office.jpg">
      </div>
      <a href="#user"><img class="circle" src="images/yuna.jpg"></a>
      <a href="#name"><span class="white-text name">John Doe</span></a>
      <a href="#email"><span class="white-text email">jdandturk@gmail.com</span></a>
    </div></li>
    <li><a href="#!"><i class="material-icons">cloud</i>First Link With Icon</a></li>
    <li><a href="#!">Second Link</a></li>
    <li><div class="divider"></div></li>
    <li><a class="subheader">Subheader</a></li>
    <li><a class="waves-effect" href="#!">Third Link With Waves</a></li>
  </ul>
  








 
</body>
</html>