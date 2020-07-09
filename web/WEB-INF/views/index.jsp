<%--
  Created by IntelliJ IDEA.
  User: soobineey
  Date: 2020-07-05
  Time: 오후 10:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>로그인 페이지</title>
  <%--captcha v3--%>
 <%-- <script src="https://www.google.com/recaptcha/api.js"></script>
  <script>
    function onSubmit(token) {
      document.getElementById("#limiter").submit();
    }
  </script>--%>

  <%--captcha v2--%>
  <script src="https://www.google.com/recaptcha/api.js" async defer></script>
  <!--===============================================================================================-->
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="resources/css/util2.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="resources/css/main2.css">
  <!--===============================================================================================-->
</head>

<body>
<div class="limiter" id="limiter">
  <div class="container-login100">
    <div class="wrap-login100">
      <form class="login100-form validate-form" action="login" method="post">
        <!-- action="loginSubmit" method="post" -->
        <span class="login100-form-title">
						Member Login
					</span>

        <div class="wrap-input100 validate-input" data-validate="Valid email is required: ex@abc.xyz">
          <input class="input100" type="text" name="id" id="id" placeholder="Email" onclick="changeID()">
          <span class="focus-input100"></span>
          <span class="symbol-input100">
							<i class="fa fa-envelope" aria-hidden="true"></i>
						</span>
        </div>

        <div class="wrap-input100 validate-input" data-validate="Password is required">
          <input class="input100" type="password" name="pw" id="pw" placeholder="Password">
          <span class="focus-input100"></span>
          <span class="symbol-input100">
							<i class="fa fa-lock" aria-hidden="true"></i>
						</span>
        </div>

        <%--reCaptcha v3--%>
       <%-- <button class="g-recaptcha"
                data-sitekey="6Lf_T64ZAAAAAGAoM9KMMjRIn1BigUr2d02_B9yw"
                data-callback='onSubmit'
                data-action='submit'>Submit</button>--%>

        <%--reCaptcha v2--%>
          <div class="g-recaptcha" data-sitekey="6LcTUa4ZAAAAANJCp0fgsysI48Z3ZvTaTbCVfnx7" style="margin-left: 20px"></div>
          <br/>
        <div class="container-login100-form-btn">
          <input type="submit" class="login100-form-btn" id="login" value="LogIn">
        </div>

        <div class="text-center p-t-12">
						<span class="txt1">
							Forgot
						</span>
          <a class="txt2" href="#">
            Username / Password?
          </a>
        </div>

        <div class="text-center p-t-136">
          <a class="txt2" href="goJoin">
            Create your Account
            <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
          </a>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>
