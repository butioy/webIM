<%--
  Created by IntelliJ IDEA.
  User: butioy
  Date: 2015/9/6
  Time: 21:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/commons/taglibs.jsp"%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="utf-8">
  <meta http-equiv="X-UA-Compatible" content="IE=edge">
  <title>Butioy | 登录</title>
  <%@ include file="/WEB-INF/pages/commons/common-css.jsp"%>
</head>
<body class="hold-transition login-page">
<div class="login-box">
  <div class="login-logo">
    <a href="../../index2.html"><b>butioy</b>CMS</a>
  </div><!-- /.login-logo -->
  <div class="login-box-body">
    <p class="login-box-msg" id="message">登录后开始会话123</p>
    <form id="login-form" method="post">
      <div class="form-group has-feedback">
        <input type="text" id="account" name="account" value="${account}" class="form-control" placeholder="帐号">
        <span class="glyphicon glyphicon-user form-control-feedback"></span>
      </div>
      <div class="form-group has-feedback">
        <input type="text" id="password" name="password" onfocus="this.type='password'" class="form-control" placeholder="密码">
        <span class="glyphicon glyphicon-lock form-control-feedback"></span>
      </div>
      <div class="row">
        <div class="col-xs-8">
          <div class="checkbox icheck">
            <label>
              <input type="checkbox" name="rememberMe" value="1"> 记住我
            </label>
          </div>
        </div><!-- /.col -->
        <div class="col-xs-4">
          <button type="button" id="login" class="btn btn-primary btn-block btn-flat">登录</button>
        </div><!-- /.col -->
      </div>
    </form>

    <div class="social-auth-links text-center">
      <p>其他方式登录</p>
      <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign in using Facebook</a>
      <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign in using Google+</a>
    </div><!-- /.social-auth-links -->
    <div class="row">
      <div class="col-xs-8">
        <a href="#" class="center-block">忘记密码</a>
      </div><!-- /.col -->
      <div class="col-xs-4">
        <a href="${ctx}/admin/auth/user/register" class="text-right center-block">注册帐号</a>
      </div><!-- /.col -->
    </div>

  </div><!-- /.login-box-body -->
</div><!-- /.login-box -->
<%@ include file="/WEB-INF/pages/commons/common-js.jsp"%>
<script>
  $(function () {
    $('input').iCheck({
      checkboxClass: 'icheckbox_square-blue',
      radioClass: 'iradio_square-blue',
      increaseArea: '20%' // optional
    });

    $("#login").on("click", function() {
      $.ajax({
        url : "${ctx}/admin/doLogin",
        type : "post",
        data : $("#login-form").serialize(),
        dateType : "json",
        success : function(resp) {
          debugger;
          if( resp.status === "success" ) {
            $("#message").text("登录成功，正在跳转...");
            window.location.href = "${ctx}/admin/index";
          } else {
            var html = "<span style='color: red;'>"+resp.message+"</span>";
            $("#message").html(html);
          }
        },
        error : function(t) {

        }
      });
    });
  });
</script>
</body>
</html>
