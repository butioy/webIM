<%--
Created by IntelliJ IDEA.
User: butioy
Date: 2016/1/30
Time: 22:16
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/commons/taglibs.jsp"%>
<!doctype html>
<html>
<head>
<meta charset="utf-8"/>
<title>layui WebIM 1.0beta Demo</title>
</head>
<link href="${ctx}/static/chatlib/layim/css/layim.css" type="text/css" rel="stylesheet"/>
<link href="${ctx}/static/chatlib/layim/lay/layer/skin/layer.css" type="text/css" rel="stylesheet"/>
<link href="${ctx}/static/chatlib/layim/lay/layer/skin/layer.ext.css" type="text/css" rel="stylesheet"/>
<link href="${ctx}/static/bootstrap/css/bootstrap.min.css" type="text/css" rel="stylesheet"/>
<link href="${ctx}/static/font-awesome/css/font-awesome.min.css" type="text/css" rel="stylesheet"/>
<body>
<%--<script src="${ctx}/static/chatlib/layim/lay/lib.js"></script>--%>
<script src="${ctx}/static/jQuery/jQuery-2.1.4.min.js"></script>
<script src="${ctx}/static/chatlib/layim/lay/layer/layer.min.js"></script>
<script src="${ctx}/static/chatlib/layim/lay/layim.js"></script>
<!--<script src="../sockjs-client-1.0.3.js"></script>-->
<script src="${ctx}/static/chatlib/webSocket.js"></script>
<script>
    $(function() {
        var ws = WebSocketClient.init({
            url : 'localhost:8080/webSocket',
            onOpen:onOpen,
            onMessage:onMessage,
            onClose:onClose,
            onError:onError
        });

        function onOpen() {
            console.log("web socket connection is success !");
        };
        function onMessage(e) {
            var result = $.parseJSON(e.data);
            console.log(result);
            var type = result.type.toLowerCase().trim();
            if( type == "one" || type == "group" ) {
                showMessage(result);
            } else if( type == "offline" || type == "online" ) {
                showUserStatus(result, type);
            } else {

            }
        };
        function onClose(e) {
            var result = e.data;
            console.log("web socket connection is closed !");
            console.log(result);
        };
        function onError(e) {
            var result = e.data;
            console.log("web socket error !");
            console.log(result);
        };
        xxim.init({
            api:{
                friend:'${ctx}/user/friend',
                group:'${ctx}/user/group',
                chatlog:'${ctx}/user/chatlog',
                groups:'${ctx}/user/groups',
                message:'${ctx}/user/getMessages',
                onlineCall:onlineCall,
                sendCall:sendMsg
            },
            user:{
                code:"${userInfo.userCode}",
                name:'${userInfo.userName}',
                face:'${not empty userInfo.img ? userInfo.img : "${ctx}/static/chatlib/layim/images/1.png"}'
            }
        });

        function onlineCall( param ) {
            ws.send(JSON.stringify(param));
        };

        function sendMsg( msg ) {
            ws.send(JSON.stringify(msg));
        };

        function showMessage( message ) {
            var from = message.from;
            var to = message.to;
            var flag = message.flag;
            var id = to;
            if( flag === "0" ) {
                id = from;
            }
            var obj = $("#layim_areaone"+id);
            var consumeStatus = 0;
            if( obj.length > 0 ) {
                xxim.append(message);
                consumeStatus = 1;
            } else {
                var msgNums = $("#count_"+to).text();
                if( msgNums.length > 0 ) {
                    msgNums = parseInt(msgNums);
                    msgNums+=1;
                } else {
                    msgNums = 1;
                }
                $("#count_"+to).text(msgNums);
            }
//            ws.send(JSON.stringify({""}));
        }

        function showUserStatus( option, type ) {
            var from = message.from;
            var $obj = $(".xxim_childnode[data-id='"+from+"']");
            if( type == "offline" ) {
                $obj.addClass("off-line");
                $obj.find("img").addClass("off-line");
            } else {
                $obj.removeClass("off-line");
                $obj.find("img").removeClass("off-line");
            }
        }
    });
</script>
</body>
</html>