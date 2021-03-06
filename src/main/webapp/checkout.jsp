<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@page import="com.dcomp.redsaju.domain.*" %>
<!DOCTYPE html>
<html lang="en">
  <head>
    <title>RedsAju - Vista O Seu Time</title>
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
    
    <link href="https://fonts.googleapis.com/css?family=Lato:100,300,400,700,900" rel="stylesheet">
    <link href="https://fonts.googleapis.com/css?family=Roboto+Condensed:300,400,700" rel="stylesheet">

    <link rel="stylesheet" href="css/open-iconic-bootstrap.min.css">
    <link rel="stylesheet" href="css/animate.css">
    
    <link rel="stylesheet" href="css/owl.carousel.min.css">
    <link rel="stylesheet" href="css/owl.theme.default.min.css">
    <link rel="stylesheet" href="css/magnific-popup.css">

    <link rel="stylesheet" href="css/aos.css">

    <link rel="stylesheet" href="css/ionicons.min.css">

    <link rel="stylesheet" href="css/bootstrap-datepicker.css">
    <link rel="stylesheet" href="css/jquery.timepicker.css">

    
    <link rel="stylesheet" href="css/flaticon.css">
    <link rel="stylesheet" href="css/icomoon.css">
    <link rel="stylesheet" href="css/style.css">

  </head>
  <body>

    <nav class="navbar navbar-expand-lg navbar-dark ftco_navbar bg-dark ftco-navbar-light" id="ftco-navbar">
	    <div class="container">
	      <a style="color: black;" class="navbar-brand" href="/">RedsAju</a>

	      <div class="collapse navbar-collapse" id="ftco-nav">
	        <ul class="navbar-nav ml-auto">

	          <li class="nav-item cta cta-colored"><a style="color: black;" href="/cart" class="nav-link"><span class="icon-shopping_cart"></span>[${carrinho.getQuantidade()}]</a></li>
			  <li class="nav-item cta cta-colored-login"><a href="#" style="color: black;" class="nav-link">Login</a></li>
	        </ul>
	      </div>
	    </div>
	  </nav>
    <!-- END nav -->
		
	<!-- Cabeçalho com foto
		<div class="hero-wrap hero-bread" style="background-image: url('images/bg_6.jpg');">
      <div class="container">
        <div class="row no-gutters slider-text align-items-center justify-content-center">
          <div class="col-md-9 ftco-animate text-center">
            <h1 class="mb-0 bread">Checkout</h1>
            <p class="breadcrumbs"><span class="mr-2"><a href="index.html">Home</a></span> <span>Checkout</span></p>
          </div>
        </div>
      </div>
	</div>
	-->
		
		<section class="ftco-section">
      <div class="container">
		<div class="row justify-content-center mb-3 pb-3">
			<div class="col-md-12 heading-section text-center ftco-animate">
				<h1 class="big">Pagamento</h1>
			  <h2 class="mb-4">Pagamento</h2>
			</div>
		  </div>    		
		  </div>
        <div class="row justify-content-center">
          <div class="col-xl-8 ftco-animate">
						<form action="#" class="billing-form bg-light p-3 p-md-5">
							<h3 class="mb-4 billing-heading">Dados da Cobran�a</h3>
	          	<div class="row align-items-end">
	          		<div class="col-md-12">
	                <div class="form-group">
	                	<label for="firstname">Nome</label>
	                  <input required type="text" name="nome" class="form-control" placeholder="">
	                </div>
	              </div>
	              <div class="col-md-12">
	                <div class="form-group">
	                	<label for="emailaddress">CPF</label>
	                  <input required type="text" name="cpf" class="form-control" placeholder="">
	                </div>
                </div>
	              <div class="col-md-12">
	                <div class="form-group">
	                	<label for="emailaddress">Endere�o de Email</label>
	                  <input required type="text" name="email" class="form-control" placeholder="">
	                </div>
                </div>
                <div class="col-md-12">
	                <div class="form-group">
	                	<label for="emailaddress">Data de Nascimento</label>
	                  <input required type="date" name="data-nascimento" class="form-control" placeholder="">
	                </div>
                </div>           
                <div class="w-100"></div>
		            <div class="col-md-12">
		            	<div class="form-group">
		            		<label for="country">Estado</label>
		            		<div class="select-wrap">
		                  <div class="icon"><span class="ion-ios-arrow-down"></span></div>
		                  <select name="estado" id="" class="form-control">
		                  	<option value="">Sergipe</option>
		                    <option value="">Bahia</option>
		                    <option value="">S�o Paulo</option>
		                  </select>
		                </div>
		            	</div>
		            </div>
		            <div class="w-100"></div>
		            <div class="col-md-6">
		            	<div class="form-group">
	                	<label for="streetaddress">Endere�o</label>
	                  <input required type="text" name="logradouro" class="form-control" placeholder="Nome da rua e n�mero da casa">
	                </div>
		           	            
		            </div>
		            <div class="col-md-6">
		            	<div class="form-group">
		            		<label for="postcodezip">Bairro</label>
	                  <input required type="text" name="bairro" class="form-control" placeholder="">
	                </div>
		            </div>
		            <div class="col-md-6">
		            	<div class="form-group">
	                	<label for="towncity">Cidade</label>
	                  <input required type="text" name="cidade" class="form-control" placeholder="">
	                </div>
		            </div>
		            <div class="col-md-6">
		            	<div class="form-group">
		            		<label for="postcodezip">CEP</label>
	                  <input required type="text" name="cep" class="form-control" placeholder="">
	                </div>
		            </div>
		            <div class="w-100"></div>
		            <div class="col-md-6">
	                <div class="form-group">
	                	<label for="phone">Telefone</label>
	                  <input required type="text" name="telefone" class="form-control" placeholder="">
	                </div>
	              </div>
	              <div class="col-md-6">
	                <div class="form-group">
	                	<label for="phone">N�mero do Cart�o</label>
	                  <input required type="text" name="cartao" class="form-control" placeholder="">
	                </div>
	              </div>
	              
                <div class="w-100"></div>
                
	            </div>
	          <!-- END -->



	          <div class="row mt-5 pt-3 d-flex">
	          	<div class="col-md-6 d-flex">
	          		<div class="cart-detail cart-total bg-light p-3 p-md-4">
	          			<h3 class="billing-heading mb-4">Total do Carrinho</h3>
	          			<p class="d-flex">
    						<span>Total</span>
    						<span>R$ ${carrinho.getPreco()}</span>
    					</p>
    					
								</div>
	          	</div>
	          	<div class="col-md-6">
	          		<div class="cart-detail bg-light p-3 p-md-4">
	          			<h3 class="billing-heading mb-4">M�todo de Pagamento</h3>
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
											   <label><input type="radio" name="optradio" class="mr-2"> Boleto Banc�rio</label>
											</div>
										</div>
									</div>
									
									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
											   <label><input type="radio" name="optradio" class="mr-2"> Cart�o de Cr�dito</label>
											</div>
										</div>
									</div>

									<div class="form-group">
										<div class="col-md-12">
											<div class="radio">
											   <label><input type="radio" name="optradio" class="mr-2"> Cart�o de D�dito</label>
											</div>
										</div>
									</div>

									<p><a href="/pagar"class="btn btn-primary py-3 px-4">Fazer o pedido</a></p>
								</div>
	          	</div>
	          </div>
          </div> <!-- .col-md-8 -->
          </form>
        </div>
      </div>
    </section> <!-- .section -->


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

  <script>
		$(document).ready(function(){

		var quantitiy=0;
		   $('.quantity-right-plus').click(function(e){
		        
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		            
		            $('#quantity').val(quantity + 1);

		          
		            // Increment
		        
		    });

		     $('.quantity-left-minus').click(function(e){
		        // Stop acting like a button
		        e.preventDefault();
		        // Get the field name
		        var quantity = parseInt($('#quantity').val());
		        
		        // If is not undefined
		      
		            // Increment
		            if(quantity>0){
		            $('#quantity').val(quantity - 1);
		            }
		    });
		    
		});
	</script>
    
  </body>
</html>