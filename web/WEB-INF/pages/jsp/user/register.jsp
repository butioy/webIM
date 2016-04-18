<%--
Created by IntelliJ IDEA.
User: butioy
Date: 2016/1/30
Time: 22:16
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>AdminLTE 2 | Registration Page</title>
  <!-- Tell the browser to be responsive to screen width -->
  <meta content="width=device-width, initial-scale=1, maximum-scale=1, user-scalable=no" name="viewport">
  <!-- Bootstrap 3.3.5 -->
  <link rel="stylesheet" href="${ctx}/static/bootstrap/css/bootstrap.min.css">
  <!-- Font Awesome -->
  <link rel="stylesheet" href="${ctx}/static/font-awesome/css/font-awesome.min.css">
  <!-- Ionicons -->
  <link rel="stylesheet" href="${ctx}/static/ionicons/css/ionicons.min.css">
  <!-- Theme style -->
  <link rel="stylesheet" href="${ctx}/static/adminlte/css/AdminLTE.css">
  <!-- iCheck -->
  <link rel="stylesheet" href="${ctx}/static/iCheck/square/blue.css">
  <!-- Bootstrap Validator -->
  <link rel="stylesheet" href="${ctx}/static/chatlib/validator/css/bootstrapValidator.min.css">

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition register-page">
<div class="register-box">
  <div class="register-logo">
    <a href=""><b> BUTIOY </b>WebIM</a>
  </div>

  <div class="register-box-body">
    <p class="login-box-msg">注册账号</p>

    <form action="" method="post" id="register_form">
      <div class="form-group has-feedback">
        <input type="text" name="userName" id="userName" class="form-control" placeholder="昵称">
      </div>
      <div class="form-group has-feedback">
        <input type="text" name="realName" id="realName" class="form-control" placeholder="真实姓名">
      </div>
      <%--<div class="form-group has-feedback">--%>
        <%--<input type="email" class="form-control" placeholder="Email">--%>
        <%--<span class="glyphicon glyphicon-envelope form-control-feedback"></span>--%>
      <%--</div>--%>
      <div class="form-group has-feedback">
        <input type="password" name="password" id="password" class="form-control" placeholder="密码">
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="re_password" id="re_password" class="form-control" placeholder="确认密码">
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> 我同意该网站 <a href="javascript:;">条款</a>
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="submit" id="register_btn" class="btn btn-primary btn-block btn-flat">注册</button>
        </div>
        <!-- /.col -->
      </div>
    </form>
    <a href="${ctx}/user/toLogin" class="text-center">我已有帐号</a>
    <div class="social-auth-links text-center" id="register_success">
      <%--<p>- OR -</p>--%>
      <%--<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using--%>
        <%--Facebook</a>--%>
      <%--<a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up using--%>
        <%--Google+</a>--%>
    </div>
  </div>
  <!-- /.form-box -->
</div>
<!-- /.register-box -->

<!-- jQuery 2.1.4 -->
<script src="${ctx}/static/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${ctx}/static/iCheck/icheck.min.js"></script>
<!-- Bootstrap Validator -->
<script src="${ctx}/static/chatlib/validator/js/bootstrapValidator.js"></script>
<script src="${ctx}/static/chatlib/validator/js/language/zh_CN.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });

    $("#register_form").bootstrapValidator({
      message: '请输入有效的值',
      feedbackIcons: {
        valid: 'fa fa-ok',
        invalid: 'fa fa-remove',
        validating: 'fa fa-refresh'
      },
      fields:{
        userName : {
          validators:{
            notEmpty:{
              message: '昵称不能为空'
            }
          }
        },
        realName : {
          validators:{
            notEmpty:{
              message: '真实姓名不能为空'
            }
          }
        },
        password : {
          validators:{
            notEmpty:{
              message: '密码不能为空'
            },
            identical:{
              field : 're_password',
              message : '与确认密码不一致'
            },
            different : {
              field: 'userName',
              message: '密码不能与昵称相同'
            }
          }
        },
        re_password : {
          validators:{
            notEmpty:{message: '确认密码不能为空'},
            identical:{
              field : 'password',
              message : '与密码不一致'
            },
            different : {
              field: 'userName',
              message: '密码不能与昵称相同'
            }
          }
        }
      }
    }).on("error.form.bv", function(e) {
      // Prevent form submission
      e.preventDefault();

      // Get the form instance
      var $form = $(e.target);

      // Get the BootstrapValidator instance
      var bv = $form.data('bootstrapValidator');

      $("#btn-text").removeClass("fa fa-rotate-right fa-pulse").text("注册");
    }).on("success.form.bv", function(e) {
      // Prevent form submission
      e.preventDefault();

      // Get the form instance
      var $form = $(e.target);

      // Get the BootstrapValidator instance
      var bv = $form.data('bootstrapValidator');
      $("#btn-text").addClass("fa fa-rotate-right fa-pulse").text("");

      // Use Ajax to submit form data
      $.post("${ctx}/user/doAdd", $form.serialize(), function(resp) {
        if( resp.status == "success" ) {
          $(".register-box-body").children().hide();
          var code = resp.data.code;
          var text = "<p>注册成功，你注册的账号是<span style='font-size: 18px; font-weight: 700;'>"+code+"</span></p>";
          text += "<p style='text-align:center;'><a href='${ctx}/user/toLogin'>跳转到登录页登录！</a></p>";
          $("#register_success").html(text);
          $("#register_success").show();
        }
      }, 'json');
    });
  });
</script>
</body>
</html>
