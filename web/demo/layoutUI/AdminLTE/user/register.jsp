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
    <title>butioy | Registration Page</title>

    <%@ include file="/WEB-INF/pages/commons/common-css.jsp"%>
    <!-- daterange picker -->
    <link rel="stylesheet" href="${ctx}/static/styles/adminLTE/plugins/daterangepicker/daterangepicker-bs3.css">
    <!-- iCheck for checkboxes and radio inputs -->
    <%--<link rel="stylesheet" href="${ctx}/static/styles/adminLTE/plugins/iCheck/all.css">--%>
    <!-- Bootstrap Color Picker -->
    <link rel="stylesheet" href="${ctx}/static/styles/adminLTE/plugins/colorpicker/bootstrap-colorpicker.min.css">
    <!-- Bootstrap time Picker -->
    <link rel="stylesheet" href="${ctx}/static/styles/adminLTE/plugins/timepicker/bootstrap-timepicker.min.css">
    <!-- Select2 -->
    <link rel="stylesheet" href="${ctx}/static/styles/adminLTE/plugins/select2/select2.min.css">

  </head>
  <body class="hold-transition register-page">
    <div class="register-box">
      <div class="register-logo">
        <a href="${ctx}/admin/login"><b>Butioy</b>LTE</a>
      </div>

      <div class="register-box-body">
        <p class="login-box-msg">Register a new membership</p>
        <form id="register-form" method="post">
          <div class="form-group has-feedback">
            <input type="text" class="form-control" name="userName" placeholder="帐号">
            <span class="glyphicon glyphicon-user form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="text" class="form-control" name="fullName" placeholder="真实姓名">
            <span class="fa fa-user-plus form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" name="password" placeholder="密码">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="password" class="form-control" id="re_password" placeholder="确认密码">
            <span class="glyphicon glyphicon-lock form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <select name="sex" id="sex" class="form-control">
              <option value="">性别</option>
              <option value="1">男</option>
              <option value="0">女</option>
            </select>
            <span class="fa fa-transgender form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="email" class="form-control" placeholder="邮箱">
            <span class="glyphicon glyphicon-envelope form-control-feedback"></span>
          </div>
          <div class="form-group has-feedback">
            <input type="text" class="form-control" placeholder="生日" id="reservation"
                    onfocus="WdatePicker({doubleCalendar:false,skin:'twoer',dateFmt:'yyyy-MM-dd',maxDate:'%y-%M-%d'})"/>
            <span class="fa fa-calendar form-control-feedback"></span>
          </div>
          <%--<div class="form-group has-feedback">--%>
            <%--<input type="password" class="form-control" placeholder="上传头像">--%>
            <%--<span class="glyphicon glyphicon-log-in form-control-feedback"></span>--%>
          <%--</div>--%>
          <div class="row">
            <div class="col-xs-8">
              <div class="checkbox icheck">
                <label>
                  <input type="checkbox" id="agree"> I agree to the <a href="javascript:;">terms</a>
                </label>
              </div>
            </div><!-- /.col -->
            <div class="col-xs-4">
              <button type="button" class="btn btn-primary btn-block btn-flat disabled" disabled id="register-btn">Register</button>
            </div><!-- /.col -->
          </div>
        </form>

        <div class="social-auth-links text-center">
          <p>- OR -</p>
          <a href="#" class="btn btn-block btn-social btn-facebook btn-flat"><i class="fa fa-facebook"></i> Sign up using Facebook</a>
          <a href="#" class="btn btn-block btn-social btn-google btn-flat"><i class="fa fa-google-plus"></i> Sign up using Google+</a>
        </div>

        <a href="login.html" class="text-center">I already have a membership</a>
      </div><!-- /.form-box -->
    </div><!-- /.register-box -->
    <%@ include file="/WEB-INF/pages/commons/common-js.jsp"%>
    <!-- InputMask -->
    <script src="${ctx}/static/scripts/adminLTE/plugins/input-mask/jquery.inputmask.js"></script>
    <script src="${ctx}/static/scripts/adminLTE/plugins/input-mask/jquery.inputmask.date.extensions.js"></script>
    <script src="${ctx}/static/scripts/adminLTE/plugins/input-mask/jquery.inputmask.extensions.js"></script>

    <!-- My97DatePicker -->
    <script src="${ctx}/static/scripts/adminLTE/plugins/My97DatePicker/WdatePicker.js"></script>
    <!-- SlimScroll 1.3.0 -->
    <script src="${ctx}/static/scripts/adminLTE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
    <!-- FastClick -->
    <script src="${ctx}/static/scripts/adminLTE/plugins/fastclick/fastclick.min.js"></script>
    <!-- AdminLTE App -->
    <%--<script src="${ctx}/static/scripts/adminLTE/dist/app.min.js"></script>--%>
    <script>
      $(function () {
        //Initialize Select2 Elements
//        $(".select2").select2({
//          placeholder: "请选择性别",
//          tag : true
//        });
        //Money Euro
        $("[data-mask]").inputmask();

        $('input[type="checkbox"]').iCheck({
          checkboxClass: 'icheckbox_square-blue',
          radioClass: 'iradio_square-blue'
//          increaseArea: '20%' // optional
        });

        $('input').on('ifChecked', function(event){
          $("#register-btn").removeClass("disabled").attr("disabled", false);
        });
        $('input').on('ifUnchecked', function(event){
          $("#register-btn").addClass("disabled").attr("disabled", true);
        });

        $("#register-btn").on("click", function() {
          $.post("${ctx}/admin/auth/user/doRegister", $("#register-form").serialize(), function(resp) {
            if( resp.status == "success" ) {
              window.location.href="${ctx}/admin/login";
            } else {
              layer.alert(resp.message);
            }
          });
        });

        //Timepicker
        $(".timepicker").timepicker({
          showInputs: false
        });

      });
    </script>
  </body>
</html>
