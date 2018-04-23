<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix = "c" uri = "http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<!--===============================================================================================-->	
	<link rel="icon" type="image/png" href="images/icons/favicon.ico"/>
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/bootstrap/css/bootstrap.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/font-awesome-4.7.0/css/font-awesome.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="fonts/iconic/css/material-design-iconic-font.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animate/animate.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/css-hamburgers/hamburgers.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/animsition/css/animsition.min.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="vendor/select2/select2.min.css">
<!--===============================================================================================-->	
	<link rel="stylesheet" type="text/css" href="vendor/daterangepicker/daterangepicker.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/util.css">
	<link rel="stylesheet" type="text/css" href="css/main_2.css">
<!--===============================================================================================-->
	<link rel="stylesheet" type="text/css" href="css/bootstrap.css">
<link href="https://fonts.googleapis.com/css?family=Alegreya+Sans+SC" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Amatic+SC" rel="stylesheet">
<link href="https://fonts.googleapis.com/css?family=Bad+Script" rel="stylesheet">
	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
	<script src="vendor/bootstrap/js/popper.js"></script>
		<script src="js/bootstrap.js"></script>
	
	<script src="vendor/bootstrap/js/bootstrap.min.js"></script>
<style>
	
	
	html{
		margin:0;
		padding:0;
	}
	body {
		background-image:url("images/architecture-buildings-city-237211.jpg");
		background-size: 100%;
		background-attachment:fixed;
		background-repeat: no-repeat;
		padding-bottom:100px;
		
	}
	#hd1 {
		width:100%;
		height:70px;
		border-bottom:1px solid black;
		padding:0;
		display:inline-block;
		background-color:black;
		
	}
	
	#hd1 div {
		
		margin-left:20px;
		margin-top:10px;
		font-size:2em;
		color:white;
		text-align:center;
	}
	
	#hd1>div span {
		font-family:Bad Script;
		margin-right:10px;
	}
	
	#logo1 {
		font-size:17em;
		color:black;
		text-align:center;
		margin-top:80px;
		text-shadow: 2px 1px 5px #FFF;
		font-family:Bad Script;

 	position:relative;
		top:-30px;
		opacity:0;
		transition:all 2s;
		
	}
	
	#reg1 {
		width:800px;
		height:500px;
		border:3px solid #EEE;
		border-radius: 18px;
		margin:0px auto;
		background-color:#EEE;
		text-align:center;
	}
	
	#reg1 input {
		width:500px;
		margin:20px;
		
	}
	
	#reg1 #identity {
		margin-top:100px;
	}
	
	.limiter {
		position:relative;
		top:-30px;
		opacity:0;
		transition:all 2s;
	}
	
	#btn-group {
		text-align:center;
		
		
	}
	
	#btn-group button {
		width:200px;
		height:100px;
		font-family:Bad Script;
		margin:30px;
		background-color:transparent;
		color:black;
		font-size:2em;
		border-radius:20px;
		padding:0;
		border:0;
		outline:0;
	}
	
	button:focus {
	
		outline:none;
		
	}
	#btn-group button div {
		width:100%;
		height:100%;
		opacity:0.2;
		background-color:#444;
		border-radius:20px;
	}
	
	#btn-group button span {
		position:relative;
		top:-70px;
		
	}
</style>
<script>
	$(document).ready(
		function() {
				$("#logo1").css("top", "0px").css("opacity", "1");
		}
	);
</script>
</head>
<body>

	<!-- <div id = "hd1">
	</div> -->
	
	
	<div id = "logo1">SeúlMate</div>
	
	<div id = "btn-group">
		<button type = "button" class = "btn btn-default"><div></div><span>Home</span></button>
		<button type = "button" class = "btn btn-default"><div></div><span>Info</span></button>
		<button type = "button" class = "btn btn-default"><div></div><span>Photo</span></button>
		<button type = "button" class = "btn btn-default"><div></div><span>Contact</span></button>
	</div>
	
	<!-- <div class="limiter">
		<div class="container-login100" style = "background-color:transparent;">
			<div class="wrap-login100">
				<form class="login100-form validate-form" method = "get" action = "">
					<span class="login100-form-title p-b-26">
						Bienvenido a SeúlMate!
					</span>
					<span class="login100-form-title p-b-48">
						<i class="zmdi zmdi-font"></i>
					</span>

					<div class="wrap-input100 validate-input" data-validate = "Valid email is: a@b.c">
						<input class="input100" type="text" name="email">
						<span class="focus-input100" data-placeholder="Email"></span>
					</div>

					<div class="wrap-input100 validate-input" data-validate="Enter password">
						<span class="btn-show-pass">
							<i class="zmdi zmdi-eye"></i>
						</span>
						<input class="input100" type="password" name="pass">
						<span class="focus-input100" data-placeholder="Password"></span>
					</div>

					<div class="container-login100-form-btn">
						<div class="wrap-login100-form-btn">
							<div class="login100-form-bgbtn"></div>
							<button class="login100-form-btn" onclick="location.href = '/mvc/auth/login.do';">
								Login
							</button>
						</div>
					</div>

					<div class="text-center p-t-115">
						<span class="txt1">
							Don’t have an account?
						</span>

						<a class="txt2" href="/mvc/signup.do">
							Sign Up
						</a>
					</div>
				</form>
			</div>
		</div>
	</div>
	

	<div id="dropDownSelect1"></div>
	 -->
	

	
	<!--===============================================================================================-->
	<script src="vendor/jquery/jquery-3.2.1.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/animsition/js/animsition.min.js"></script>
<!--===============================================================================================-->
	
<!--===============================================================================================-->
	<script src="vendor/select2/select2.min.js"></script>
<!--===============================================================================================-->
	<script src="vendor/daterangepicker/moment.min.js"></script>
	<script src="vendor/daterangepicker/daterangepicker.js"></script>
<!--===============================================================================================-->
	<script src="vendor/countdowntime/countdowntime.js"></script>
<!--===============================================================================================-->
	<script src="js/main.js"></script>
	
</body>
</html>