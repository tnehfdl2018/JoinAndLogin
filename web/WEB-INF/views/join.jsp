<%--
  Created by IntelliJ IDEA.
  User: soobineey
  Date: 2020-07-07
  Time: 오전 12:20
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>

<html>
<head>
  <title>Title</title>
  <script src="http://code.jquery.com/jquery-1.11.2.min.js"></script>
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="resources/vendor/bootstrap/css/bootstrap2.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="resources/fonts/font-awesome-4.7.0/css/font-awesome.min.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="resources/css/util2.css">
  <!--===============================================================================================-->
  <link rel="stylesheet" type="text/css" href="resources/css/main2.css">
  <!--===============================================================================================-->

  <script type="text/javascript">
    /*이메일 인증 버튼 클릭시 발생하는 이벤트*/
    $(function () {
      $("#ckAuthDiv").hide();
      $.ajax({
        type: "get",
        url: "/email",
        success: function (data) {
          console.log("난수 발생");
        },
        error: function (data) {
          console.log("난수 발생 실패");
        }
      });
      /*$("#ckAuthDiv").hide();
      $(document).on("click", "#sendEmail", function () {
        /!*이메일 중복 체크 후 메일 발송 비동기 처리*!/
        $.ajax({
          type: "get",
          url: "/email/createEmailCheck.do",
          data: "userEmail=" + $("#email").val() + "&random=" + $("#random").val(),
          success: function (data) {
            $("#ckAuthDiv").show();
            alert("사용 가능한 이메일 입니다. 인증번호를 입력 해주세요.");
          },
          error: function (data) {
            alert("에러가 발생했습니다.")
            return false;
          }
        });
      });*/
    });

    $(document).on("click", "#sendEmail", function () {
      /*이메일 중복 체크 후 메일 발송 비동기 처리*/
      $.ajax({
        type: "get",
        url: "<c:url value='/createEmailCheck'/>",
        data: "userEmail=" + $("#email").val() + "&random=" + $("#random").val(),
        success: function (data) {
          $("#ckAuthDiv").show();
          alert("사용 가능한 이메일 입니다. 인증번호를 입력 해주세요.");
        },
        error: function (data) {
          console.log(data);
          alert("에러가 발생했습니다.")
          return false;
        }
      });
    });

    /*이메일 인증번호 입력 후 인증 버튼 클릭 이벤트*/
    $(document).on("click", "#ckAuth", function () {
      $("#joinBtn").attr('disabled', true);
      $.ajax({
        type: "get",
        url: "<c:url value='/emailAuth'/>",
        data: "authCode=" + $('#emailAuth').val() + "&random=" + $("#random").val(),
        success: function (data) {
          if (data == "complete") {
            alert("인증이 완료되었습니다.");
          } else if (data == "false") {
            alert("인증번호를 잘 못 입력하였습니다.");
          }
        },
        error: function (data) {
          alert("인증에 실패하였습니다.");
        }
      });
    });

    $(function () {
      $("#alert-success").hide();
      $("#alert-danger").hide();
      $("input").keyup(function () {
        var pw = $("#pw").val();
        var ckPw = $("#ckPw").val();
        if (pw != "" || ckPw != "") {
          if (pw == ckPw) {
            $("#alert-success").show();
            $("#alert-danger").hide();
            $("#submit").removeAttr("disabled");
            $("#joinBtn").attr('disabled', false);
          } else if(pw == "" || ckPw == "") {
            $("#alert-success").hide();
            $("#alert-danger").hide();
            $("#joinBtn").attr('disabled', true);
          } else {
            $("#alert-success").hide();
            $("#alert-danger").show();
            $("#submit").attr("disabled", "disabled");
            $("#joinBtn").attr('disabled', true);
          }
        }
      });
    });
    $(document).on("click", "#joinBtn", function () {
      let obj = {
        id: $("#id"),
        pw: $("#pw")
      }
      $.ajax({
        type: "post",
        url: "/joined",
        data: obj,
        dataType: "json",
        success: function () {
          alert("회원가입에 성공하였습니다.");
        },
        error: function () {
          alert("회원가입중 문제가 발생하였습니다.");
        }
      })

    });
  </script>

</head>
<body>
${random}

<div class="limiter">
  <div class="container-login100">
    <div class="wrap-login100">
     <%-- <div class="login100-pic js-tilt" data-tilt>
        &lt;%&ndash;<a href="main"><img src="img/logo/logo.png" alt="IMG">&ndash;%&gt;
        <span class="login100-form-title">
                Welcome to Soolfarm
            </span>
        </a>

      </div>--%>

      <form class="login100-form validate-form" action="joinSubmit" method="post" id="submit_form">
            <span class="login100-form-title">
                Member join
            </span>

        <div class="wrap-input100 validate-input" data-validate="Password is required">
          <input class="input100" type="text" name="id" id="id" placeholder="아이디를 입력해주세요.">
          <span class="focus-input100"></span>
          <span class="symbol-input100">
            <i class="fa fa-id-badge" aria-hidden="true"></i>
            </span>
        </div>

        <div class="wrap-input100 validate-input">
          <input type="password" class="input100" name="pw" id="pw" placeholder="비밀번호를 입력해주세요.">
          <span class="focus-input100"></span>
          <span class="symbol-input100">
            <i class="fa fa-lock" aria-hidden="true"></i>
            </span>
        </div>
        <div class="wrap-input100 validate-input" data-validate="Password is required">
          <input class="input100" type="password" name="ckPw" id="ckPw" placeholder="비밀번호를 다시 입력해주세요.">
          <span class="focus-input100"></span>
          <span class="symbol-input100">
            <i class="fa fa-lock" aria-hidden="true"></i>
          </span>
        </div>

        <div class="alert alert-success wrap-input100 validate-input" id="alert-success">비밀번호가 일치합니다.</div>
        <div class="alert alert-danger wrap-input100 validate-input" id="alert-danger">비밀번호가 일치하지 않습니다.</div>

        <div class="wrap-input100 validate-input">
          <input class="post_num" type="email" id="email" name="email" placeholder="이메일을 입력해주세요.">
          <span class="focus-input100"></span>
          <input class="post_num_btn" type="button" id="sendEmail" value="인증">
          <span class="symbol-input100">
							<i class="fa fa-id-card" aria-hidden="true"></i>
						</span>
        </div>

        <div class="wrap-input100 validate-input" id="ckAuthDiv">
          <input class="post_num" type="text" id="auth" name="auth" placeholder="인증번호를 입력해주세요.">
          <input class="post_num_btn" type="button" id="ckAuth" value="확인">
          <span class="focus-input100"></span>
          <span class="symbol-input100">
							<i class="fa fa-id-card" aria-hidden="true"></i>
						</span>
        </div>

        <div>
          <input type="text" path="random" id="random" value="${random}">
        </div>

        <div class="container-login100-form-btn">
          <button class="login100-form-btn" disabled="disabled" id="joinBtn">
            Join
          </button>
        </div>

        <%--<div class="text-center p-t-12">
              <span class="txt1">
                  Forgot
              </span>
          <a class="txt2" href="#">
            Username / Password?
          </a>
        </div>--%>

        <div class="text-center p-t-136">
          <a class="txt2" href="/">
            Login
            <i class="fa fa-long-arrow-right m-l-5" aria-hidden="true"></i>
          </a>
        </div>
      </form>
    </div>
  </div>
</div>
</body>
</html>