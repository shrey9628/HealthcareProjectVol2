<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>

<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">

<title>Home</title>



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


<img src="logo.png" style="padding-left: 32%">

<a href="#" data-target="slide-out" class="sidenav-trigger" style="display: inline;"><i style="font-size: 50px" class="material-icons">menu</i></a>


<a class="waves-effect waves-light btn" href="logout" style="
    position: fixed;
    left: 89%;
    top: 13px;
    background-color: #ee6e73;
">Logout</a>


</nav>


<img src="home2.jpg" style="height: 592px;
    width: 100%;">












  <ul id="slide-out" class="sidenav">
    <li><div class="user-view">
   
    </div></li>
    <li><a href="#!"><i class="Large material-icons">local_hospital</i>Health Care System Menu</a></li>
   
    <li><div class="divider"></div></li>
    <li><a class="subheader"><i class="Large material-icons">group</i>Services we provided</a></li>
    <br>
    <li><a class="subheader"><i class="Large material-icons">group_add</i>Registered_User</a></li>
   <li><a class="subheader"><i class="Large material-icons">exposure</i>Drugs Store</a></li>
      <li><a class="subheader"><i class="Large material-icons">library_add</i>Case Records</a></li>
   <li><a class="subheader"><i class="Large material-icons">portrait</i>Daily Entry</a></li>


  </ul>
  








 
</body>
</html>