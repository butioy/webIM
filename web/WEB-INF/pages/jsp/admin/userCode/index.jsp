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
    <!-- Bootstrap Validator -->
    <link rel="stylesheet" href="${ctx}/static/chatlib/validator/css/bootstrapValidator.min.css">

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
        <p class="login-box-msg">生成用户CODE码</p>

        <form action="" method="post" id="generate-form">
            <div class="form-group has-feedback">
                <input type="text" name="total" class="form-control integer" placeholder="生成数量">
            </div>
            <div class="row">
                <div class="col-xs-12">
                    <button type="submit" id="generate_btn" class="btn btn-primary btn-block btn-flat"><span id="btn-text">生成</span></button>
                </div>
                <!-- /.col -->
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
<!-- Bootstrap Validator -->
<script src="${ctx}/static/chatlib/validator/js/bootstrapValidator.js"></script>
<script src="${ctx}/static/chatlib/validator/js/language/zh_CN.js"></script>
<script>
    $(function () {
        $("#generate-form").bootstrapValidator({
            message: '请输入有效的值',
            feedbackIcons: {
                valid: 'fa fa-ok',
                invalid: 'fa fa-remove',
                validating: 'fa fa-refresh'
            },
            fields:{
                total : {
                    validators:{
                        notEmpty:{},
                        digits:{}
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

            $("#btn-text").removeClass("fa fa-rotate-right fa-pulse").text("生成CODE码");
        }).on("success.form.bv", function(e) {
            // Prevent form submission
            e.preventDefault();

            // Get the form instance
            var $form = $(e.target);

            // Get the BootstrapValidator instance
            var bv = $form.data('bootstrapValidator');
            $("#btn-text").addClass("fa fa-rotate-right fa-pulse").text("");

            // Use Ajax to submit form data
            $.post("${ctx}/admin/userCode/generateCode", $form.serialize(), function( resp ) {
                if (resp.status == "success") {
                    $(".login-box-body").children().hide();
                    $("#login_success").html("<p>生成成功，<span id='interval'>5</span>秒后跳转到登录页！</p>");
                    $("#login_success").show();
                    var interval = 5;
                    var intervalIndex = setInterval(function () {
                        $("#interval").text(--interval);
                        if (interval <= 0) {
                            window.location.href = "${ctx}/user/toLogin";
                            window.clearInterval(intervalIndex);
                        }
                    }, 1000);
                }
            }, 'json');
        });
    });
</script>
</body>
</html>
