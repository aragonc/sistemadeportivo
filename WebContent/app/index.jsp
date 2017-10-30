<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%
	String validar = (String) request.getAttribute("validar");
%>
<!DOCTYPE html>
<html lang="en">
    <head>
        <meta charset="utf-8">
        <meta http-equiv="X-UA-Compatible" content="IE=edge">
        <meta name="viewport" content="width=device-width, initial-scale=1">
        <title>Sistema de Campeonato Deportivo</title>
        <!-- CSS -->
        <link rel="stylesheet" href="http://fonts.googleapis.com/css?family=Roboto:400,100,300,500">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/bootstrap/dist/css/bootstrap.min.css">
  		<link rel="stylesheet" href="${pageContext.request.contextPath}/bower_components/font-awesome/css/font-awesome.min.css">
		<link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/form-elements.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/static/css/login.css">

        <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
        <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
        <!--[if lt IE 9]>
            <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
            <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
        <![endif]-->

        <!-- Favicon and touch icons -->
        <link rel="shortcut icon" href="${pageContext.request.contextPath}/images/favicon.png">
    </head>
    <body>

        <!-- Top content -->
        <div class="top-content">
        	
            <div class="inner-bg">
                <div class="container">
                    <div class="row">
                        <div class="col-sm-8 col-sm-offset-2 text">
                           <img src="${pageContext.request.contextPath}/images/logoapp.svg" width="350px" />
                            <div class="description">
                            	<% if (validar != null) { %>
                    				<div class="alert alert-warning" role="alert">${requestScope.validar}</div>
                    			<% } %>
                            </div>
                        </div>
                    </div>
                    <div class="row">
                        <div class="col-sm-6 col-sm-offset-3 form-box">
                        	<div class="form-top">
                        		<div class="form-top-left">
                        			<h3>Ingresar al sistema</h3>
                            		<p>Ingrese su usuario  y contraseña</p>
                        		</div>
                        		<div class="form-top-right">
                        			<i class="fa fa-lock"></i>
                        		</div>
                            </div>
                            <div class="form-bottom">
			                    <form role="form" action="${pageContext.request.contextPath}/ServletUsuario?tipo=autenticar" method="post" class="login-form">
			                    	<div class="form-group">
			                    		<label class="sr-only" for="form-username">Username</label>
			                        	<input type="text" name="username" placeholder="Email" class="form-username form-control" id="username">
			                        </div>
			                        <div class="form-group">
			                        	<label class="sr-only" for="form-password">Password</label>
			                        	<input type="password" name="password" placeholder="Contraseña" class="form-password form-control" id="password">
			                        </div>
			                        <button type="submit" class="btn">Iniciar sesión</button>
			                    </form>
		                    </div>
                        </div>
                    </div>
                    
                </div>
            </div>
            
        </div>


        <!-- Javascript -->
       	<script src="${pageContext.request.contextPath}/bower_components/jquery/dist/jquery.min.js"></script>
		<script src="${pageContext.request.contextPath}/bower_components/bootstrap/dist/js/bootstrap.min.js"></script>
        <script src="${pageContext.request.contextPath}/static/js/jquery.backstretch.min.js"></script>
        <script type="text/javascript">
        
        jQuery(document).ready(function() {
        	
            /*
                Fullscreen background
            */
            $.backstretch([
                            "${pageContext.request.contextPath}/images/bg-fondo.jpg"
        	             ], {duration: 3000, fade: 750});
            
            /*
                Form validation
            */
            $('.login-form input[type="text"], .login-form input[type="password"], .login-form textarea').on('focus', function() {
            	$(this).removeClass('input-error');
            });
            
            $('.login-form').on('submit', function(e) {
            	
            	$(this).find('input[type="text"], input[type="password"], textarea').each(function(){
            		if( $(this).val() == "" ) {
            			e.preventDefault();
            			$(this).addClass('input-error');
            		}
            		else {
            			$(this).removeClass('input-error');
            		}
            	});
            	
            });
            
            
        });
        
        </script>
        
        <!--[if lt IE 10]>
            <script src="assets/js/placeholder.js"></script>
        <![endif]-->

    </body>

</html>