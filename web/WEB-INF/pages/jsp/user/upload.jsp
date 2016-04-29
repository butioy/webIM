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
    <link rel="stylesheet" href="${ctx}/static/font-awesome/css/font-awesome.css">
    <!-- Theme style -->
    <link rel="stylesheet" href="${ctx}/static/adminlte/css/AdminLTE.css">
    <!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
    <!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
    <!--[if lt IE 9]>
    <script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
    <script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
    <![endif]-->
    <style>
        .remove{
            position: absolute;
            background: #000;
            opacity: 0.5;
            height: 40px;
            left: 0px;
            top: 0px;
        }
        .wrapper, body {
            min-width: 600px;
            overflow-x: auto;
        }
        .row>div{
            margin:10px 0px;}
    </style>
</head>
<body class="hold-transition skin-blue sidebar-mini fixed">
<div class="wrapper">
    <div class="content">
        <input type="file" id="upload_img" placeholder="请选择图片" />
        <div class="panel panel-info">
            <div class="panel-heading">
                <div class="row">
                    <div class="col-md-12 clearfix">
                        <button type="button" id="upload_btn" class="btn btn-primary btn-flat btn-sm pull-right margin-l-5">开始上传</button>
                        <button type="button" id="select_btn" class="btn bg-olive btn-flat btn-sm pull-right margin-l-5">选择文件</button>
                    </div>
                </div>
            </div>
            <div class="panel-body">
                <div class="row" id="preview">
                </div>
            </div>
        </div>
    </div>
</div>

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
        uploadDir:'/upload/files',
        selected:function(file, index, files) {
            var p = document.getElementById('preview');
            var reader = new FileReader();
            reader.onload = function( e ) {
                var col = document.createElement('div');
                col.className = 'col-xs-2';
                col.id='div_img_'+index;
                p.appendChild(col);
                var width = col.clientWidth;
                var preDiv = document.createElement('div');
                preDiv.style.height=(width-30)+'px';
                preDiv.style.lineHeight=(width-34)+'px';
                preDiv.style.width='100%';
                preDiv.style.border = '1px solid #ccc';
                preDiv.style.textAlign = 'center';
                preDiv.style.position = 'relative';
                var htmls = '<div class="remove hidden" style="width: 100%; font-size: 25px; color: #5897fb;">' +
                        '<i class="col-xs-2 fa fa-undo pull-right" id="remove_'+index+'" style="line-height: 40px;"></i>' +
                        '<i class="col-xs-2 fa fa-trash-o pull-right" id="rotation_'+index+'" style="line-height: 40px;"></i></div>';
                preDiv.innerHTML = htmls+'<img title="'+file.name+'" src="'+e.target.result+'" id="img_'+index+'"'+
                        ' style="max-width: 100%; max-height: '+(width-32)+'px;"/>';
                col.appendChild(preDiv);
            };
            reader.readAsDataURL(file);
        }
    });
</script>
</body>
</html>