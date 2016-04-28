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
                <input type="file" id="upload_img" class="form-control" placeholder="请选择图片"/>
            </div>
            <div class="form-group row">
                <div class="col-xs-6">
                    <button type="button" id="select_btn" class="btn btn-primary btn-block btn-flat">选择文件</button>
                </div>
                <div class="col-xs-6">
                    <button type="button" id="upload_btn" class="btn btn-primary btn-block btn-flat">开始上传</button>
                </div>
            </div>
            <div class="form-group row" id="preview">
            </div>
        </form>
    </div>
    <!-- /.login-box-body -->
</div>
<!-- /.login-box -->

<!-- jQuery 2.1.4 -->
<script src="${ctx}/static/jQuery/jQuery-2.1.4.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="${ctx}/static/bootstrap/js/bootstrap.min.js"></script>
<script src="${ctx}/static/upload.js"></script>
<!-- iCheck -->
<script>
    'use strict';
    BU.init({
        url : '${ctx}/upload/doUpload',
        fileId : 'upload_img',
        selectId : 'select_btn',
        uploadId : 'upload_btn',
        previewId : 'preview',
        repeat : false,
        multi : true,
        accepts:'png|jpeg|jpg|gif|bmp',
        selected:function(file, index, files) {
            var p = document.getElementById('preview');
            var reader = new FileReader();
            reader.onload = function( e ) {
                var col = document.createElement('div');
                col.className = 'col-xs-3';
                col.id='div_img_'+index;
                p.appendChild(col);
                var width = col.clientWidth;
                col.style.height=width+'px';
                col.style.lineHeight = width+'px';
                col.style.border = '1px solid #ccc';
                col.innerHTML = '<img alt="'+file.name+'" src="'+e.target.result+'" id="img_'+index+'"'+
                        ' style="width:expression(this.width > '+width+' ? '+width+'px : this.width); max-width: 100%;"/>';
            };
            reader.readAsDataURL(file);
        }

    });
</script>
</body>
</html>