<%-- Created by IntelliJ IDEA. --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html >
<head>
  <meta charset="UTF-8">
  <title>ConnectBook</title>


  <link rel="stylesheet" href="css/normalize.css">

  <link rel='stylesheet prefetch' href='http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css'>

  <link rel="stylesheet" href="css/style.css">
</head>

<body>

<%
    String errorMessage = (String) request.getAttribute("error_message");
  if(errorMessage != null && !errorMessage.equals("")) {
      out.println("<center>");
      out.println(errorMessage);
      out.println("</center>");
  }
%>

<div class="login-box">
  <div class="lb-header">
    <a href="#" class="active" id="login-box-link">Login</a>
    <a href="#" id="signup-box-link">Sign Up</a>
  </div>
  <div class="social-login">
    <a href="#">
      <i class="fa fa-facebook fa-lg"></i>
      Login in with facebook
    </a>
    <a href="#">
      <i class="fa fa-google-plus fa-lg"></i>
      log in with Google
    </a>
  </div>
  <form class="email-login" method="post" action="signinservlet">
    <div class="u-form-group">
      <input type="email" placeholder="Email" name="email"/>
    </div>
    <div class="u-form-group">
      <input type="password" placeholder="Password" name="password"/>
    </div>
    <div class="u-form-group">
      <button>Log in</button>
    </div>
    <div class="u-form-group">
      <a href="#" class="forgot-password">Forgot password?</a>
    </div>
  </form>

  <form class="email-signup" method="post" action="signupservlet">
    <div class="u-form-group">
      <input type="email" placeholder="Email" id="email" name="email"/>
    </div>
    <div class="u-form-group">
      <input type="password" placeholder="Password" id="password" name="password"/>
    </div>
    <div class="u-form-group">
      <input type="password" placeholder="Confirm Password" id="confirm_password" name="confirm_password"/>
    </div>
    <div class="u-form-group">
      <button type="submit">Sign Up</button>
    </div>
  </form>

</div>

<script src='http://cdnjs.cloudflare.com/ajax/libs/jquery/2.1.3/jquery.min.js'></script>

<script src="js/index.js"></script>

</body>
</html>