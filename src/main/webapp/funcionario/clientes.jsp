<%@page contentType="text/html" import="com.dcomp.redsaju.services.ClienteService,java.util.*,com.dcomp.redsaju.domain.*,com.dcomp.redsaju.services.*" 
pageEncoding="utf-8"%>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>RedsAju - Vista O Seu Time</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="../css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="../css/animate.css">
    
    <link rel="stylesheet" href="../css/owl.carousel.min.css">
    <link rel="stylesheet" href="../css/owl.theme.default.min.css">
    <link rel="stylesheet" href="../css/magnific-popup.css">

    <link rel="stylesheet" href="../css/aos.css">

    <link rel="stylesheet" href="../css/ionicons.min.css">

    <link rel="stylesheet" href="../css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="../css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="../css/flaticon.css">
    <link rel="stylesheet" href="../css/icomoon.css">
    <link rel="stylesheet" href="../css/style.css">
  </head>
  <body>

    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a style="color: black;" class="navbar-brand" href="index.html">RedsAju</a>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">

	          <li class="nav-item cta cta-colored"><a style="color: black;" href="cart.html" class="nav-link"><span class="icon-shopping_cart"></span>[0]</a></li>
			  <li class="nav-item cta cta-colored-login"><a href="#" style="color: black;" class="nav-link">Login</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
		
    <section class="ftco-section bg-light">
    	<div class="container">
				<div class="row justify-content-center mb-3 pb-3">
          <div class="col-md-12 heading-section text-center ftco-animate">
          	<h1 class="big">Clientes</h1>
            <h2 class="mb-4">Nossos Clientes</h2>
          </div>
        </div>    		
    	</div>
    	<div class="container-fluid">
    		<table class="table table-hover">
				<thead class="thead-light">
				  <tr>
					<th scope="col">#</th>
					<th scope="col">Nome</th>
					<th scope="col">Email</th>
					<th scope="col">Endereço</th>
				  </tr>
				</thead>
				<tbody>

				<%
				Cliente cliente = new ClienteService().find(1);
				%>

				  <tr>
					<td>1</td>
					<td>Adisiel Alemão Santos Silveira</td>
					<td>adisielalemao@hotmail.com</td>
					<td>Rua A, nº 83, Centro, Aracaju/SE</td>
				  </tr>
				  <tr>
					<td>2</td>
					<td>Wesley Alves Santana</td>
					<td>wesley0775@gmail.com</td>
					<td>Avenida B, nº 0, Bairro América, Aracaju/SE</td>
				  </tr>
				  <tr>
					<td>3</td>
					<td>Reinaldo Lima Mendonça Junior</td>
					<td>reinaldol@live.com</td>
					<td>Rua 8, nº 20, Marcos Freire 2, Nossa Senhora do Socorro/SE</td>
				  </tr>
				</tbody>
			  </table>
    	</div>
    </section>

    <footer class="ftco-footer bg-light ftco-section">
      <div class="container">
        <div class="row">
          <div class="col-md-12 text-center">

            <p><!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						  Copyright &copy;<script>document.write(new Date().getFullYear());</script> All rights reserved | This template is made with <i class="icon-heart color-danger" aria-hidden="true"></i> by <a href="https://colorlib.com" target="_blank">Colorlib</a>
						  <!-- Link back to Colorlib can't be removed. Template is licensed under CC BY 3.0. -->
						</p>
          </div>
        </div>
      </div>
    </footer>
    
  

  <!-- loader -->
  <div id="ftco-loader" class="show fullscreen"><svg class="circular" width="48px" height="48px"><circle class="path-bg" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke="#eeeeee"/><circle class="path" cx="24" cy="24" r="22" fill="none" stroke-width="4" stroke-miterlimit="10" stroke="#F96D00"/></svg></div>


  <script src="js/jquery.min.js"></script>
  <script src="js/jquery-migrate-3.0.1.min.js"></script>
  <script src="js/popper.min.js"></script>
  <script src="js/bootstrap.min.js"></script>
  <script src="js/jquery.easing.1.3.js"></script>
  <script src="js/jquery.waypoints.min.js"></script>
  <script src="js/jquery.stellar.min.js"></script>
  <script src="js/owl.carousel.min.js"></script>
  <script src="js/jquery.magnific-popup.min.js"></script>
  <script src="js/aos.js"></script>
  <script src="js/jquery.animateNumber.min.js"></script>
  <script src="js/bootstrap-datepicker.js"></script>
  <script src="js/scrollax.min.js"></script>
  <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyBVWaKrjvy3MaE7SQ74_uJiULgl1JY0H2s&sensor=false"></script>
  <script src="js/google-map.js"></script>
  <script src="js/main.js"></script>
    
  </body>
</html>