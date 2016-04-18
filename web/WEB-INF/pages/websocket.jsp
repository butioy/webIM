<%--
  Created by IntelliJ IDEA.
  User: butioy
  Date: 2015/12/16
  Time: 12:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
    <title>动弹列表</title>
    <script src="http://libs.baidu.com/jquery/1.9.0/jquery.js"></script>
    <style type="text/css">
        .jz {
            margin: 0 auto;
            text-align: center;
        }

        .tw {
            border: 1px dotted red;
            height: 60px;
            width: 600px;
            margin: 0px auto;
            padding-left: 10px;
            padding-top: 10px;
            margin-top: 5px;
        }

        .top {

        }

        .buttom {
            padding-top: 10px;
        }

        #send-box {
            margin-top: 10px;
        }
    </style>
</head>
<body>
<div class="jz" style="font-size:30px;">动弹列表</div>
<div class="jz" style="font-size:20px;">欢迎回来：${param.username}，当前在线人数<b id="pcount"></b></div>
<div class="jz" id="err-box"></div>
<div id="msg-box">
    <div class="tw">
        <div class="top">admin 2015-07-05</div>
        <div class="buttom">请大家随意畅谈${USER_INFO_MAP_KEY.fullName}</div>
    </div>
</div>
<div id="send-box" class="jz">
    <input type="text" id="text-msg" style="width:300px;"/>
    <input type="button" onclick="send_msg()" value="发布动弹"/>
</div>
<script type="text/javascript">
    var username = '${USER_INFO_MAP_KEY.fullName}';
    var ws = new WebSocket('ws://localhost:8080/webSocket');
    //  var ws = new WebSocket('ws://localhost:8080/sockjsWebSocket');

    ws.onerror = function (event) {
        $('#err-box').html(event);
    };

    ws.onopen = function (event) {
        start();
    };

    ws.onclose = function (event) {
        var msg = JSON.stringify({'username': username, 'type': '3'});
        ws.send(msg);
    };

    ws.onmessage = function (event) {
        var data = JSON.parse(event.data);
        console.log(data);
        if (data.type == '2') {
            var text_msg = decodeURI(data.data);
            render_data(data.fullName, text_msg);
        } else if (data.type == '1') {
            $('#pcount').html(data.pcount);
            render_data('<span style="color:red;">系统信息</span>', data.fullName + "加入系统");
        } else if( data.type == '3' ) {
            $('#pcount').html(data.pcount);
            render_data('<span style="color:red;">系统信息</span>', data.fullName + "退出系统");
        } else if( data.type == '5' ) {
            $('#pcount').html(data.pcount);
        }
    };

    function render_data(username, data) {
        var msg = [];
        msg.push('<div class="tw">');
        msg.push('<div class="top">' + username + '  2015-07-05</div>');
        msg.push('<div class="buttom"> ' + data + ' </div>');
        msg.push('</div>');
        $('#msg-box').append(msg.join(''));
    }

    function start() {
        if (username != '') {
            var msg = JSON.stringify({'fullName': username, 'type': '1'});
            ws.send(msg);
        }
    }

    function send_msg() {
        var text_msg = $('#text-msg').val();
        if (text_msg != '') {
            text_msg = encodeURI(text_msg);
            var msg = JSON.stringify({'username': username, 'type': '2', 'data': text_msg});
            ws.send(msg);
            $('#text-msg').val('');
        }
    }

    (function () {
        if (username == '') {
            alert('用户名为空，无法发布动弹');
            $('#send-box').hide();
        }
    })();
</script>
</body>
</html>