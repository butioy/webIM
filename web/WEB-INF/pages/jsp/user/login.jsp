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
  <title>AdminLTE 2 | Log in</title>
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

  <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
  <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
  <!--[if lt IE 9]>
  <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
  <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
  <![endif]-->
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="${ctx}/user/login"><b> BUTIOY </b>WebIM</a>
  </div>
  <!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg" id="message">登录后开始聊天</p>

    <form action="" method="post" id="login-form">
      <div class="form-group has-feedback">
        <input type="text" name="account" class="form-control" placeholder="帐号">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="password" name="password" class="form-control" placeholder="密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox"> 记住我
            </label>
          </div>
        </div>
        <!-- /.col -->
        <div class="col-xs-4">
          <button type="button" id="login_btn" class="btn btn-primary btn-block btn-flat">登录</button>
        </div>
        <!-- /.col -->
      </div>
      <div class="row">
        <div class="col-xs-4">
          <a href="javascript:;" class="btn btn-link text-center pull-left">忘记密码</a>
        </div>
        <div class="col-xs-4">
          <a href="${ctx}/admin/userCode" class="btn btn-link text-center">生成CODE码</a>
        </div>
        <div class="col-xs-4">
          <a href="${ctx}/user/toRegister" class="btn btn-link text-center pull-right">注册帐号</a>
        </div>
      </div>
    </form>

    <div class="social-auth-links text-center" id="login_success">
      <%--<p>- OR -</p>--%>
      <%--<a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using--%>
        <%--Facebook</a>--%>
      <%--<a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using--%>
        <%--Google+</a>--%>
    </div>
    <!-- /.social-auth-links -->
  </div>
  <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.1.4 -->
<script src="${ctx}/static/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
<!-- iCheck -->
<script src="${ctx}/static/iCheck/icheck.min.js"></script>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });
    $("#login_btn").on("click", function() {
      $.post("${ctx}/user/doLogin", $("#login-form").serialize(), function (resp) {
        if (resp.status === "success") {
          $(".login-box-body").children().hide();
          $("#login_success").html("<p>登录成功，<span id='interval'>5</span>秒后跳转到聊天页！</p>");
          $("#login_success").show();
          var interval = 5;
          var intervalIndex = setInterval(function () {
            $("#interval").text(--interval);
            if (interval <= 0) {
              window.location.href = "${ctx}/chat";
              window.clearInterval(intervalIndex);
            }
          }, 1000);
        } else {
          $("#login_success").html('<p style="color:#FF2F2F;">'+resp.message+'</p>');
          $("#login_success").show();
        }
      },'json');
    });
  });
</script>
</body>
</html>
