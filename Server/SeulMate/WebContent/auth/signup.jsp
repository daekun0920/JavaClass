<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
 <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/font-awesome/4.5.0/css/font-awesome.min.css">
<link href='https://fonts.googleapis.com/css?family=Roboto:400,700,900' rel='stylesheet' type='text/css'>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/normalize/5.0.0/normalize.min.css">

  
      <link rel="stylesheet" href="css/style.css">

<title>Insert title here</title>
<style>

</style>
<script>

</script>
</head>
<body>
<div class="back"></div>
<div class="registration-form">
  <header>
    <h1>Sign Up</h1>
    <p>Fill in all informations</p>
  </header>
  <form>
    <div class="input-section email-section">
      <input class="email" type="email" placeholder="ENTER YOUR E-MAIL HERE" autocomplete="off"/>
      <div class="animated-button"><span class="icon-paper-plane"><i class="fa fa-envelope-o"></i></span><span class="next-button email"><i class="fa fa-arrow-up"></i></span></div>
    </div>
    <div class="input-section password-section folded">
      <input class="password" type="password" placeholder="ENTER YOUR PASSWORD HERE"/>
      <div class="animated-button"><span class="icon-lock"><i class="fa fa-lock"></i></span><span class="next-button password"><i class="fa fa-arrow-up"></i></span></div>
    </div>
    <div class="input-section repeat-password-section folded">
      <input class="repeat-password" type="password" placeholder="REPEAT YOUR PASSWORD HERE"/>
      <div class="animated-button"><span class="icon-repeat-lock"><i class="fa fa-lock"></i></span><span class="next-button repeat-password"><i class="fa fa-paper-plane"></i></span></div>
    </div>
    <div class="success"> 
      <p>ACCOUNT CREATED</p>
    </div>
  </form>
</div>
  <script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

  

    <script  src="js/index.js"></script>


</body>
</html>