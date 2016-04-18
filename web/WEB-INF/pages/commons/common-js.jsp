<%--
  Created by IntelliJ IDEA.
  User: butioy
  Date: 2015/9/6
  Time: 21:03
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglibs.jsp" %>
<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
<script src="${ctx}/static/scripts/html5shiv/html5shiv.min.js"></script>
<script src="${ctx}/static/scripts/respond/respond.min.js"></script>
<![endif]-->

<!-- jQuery 2.1.4 -->
<%--<script src="${ctx}/static/scripts/jquery/jQuery-2.1.4.min.js"></script>--%>
<script src="${ctx}/static/scripts/jquery/jquery-1.11.1.min.js"></script>
<!-- Bootstrap 3.3.5 -->
<script src="${ctx}/static/scripts/bootstrap/js/bootstrap.min.js"></script>
<!-- FastClick -->
<script src="${ctx}/static/scripts/adminLTE/plugins/fastclick/fastclick.min.js"></script>
<!-- iCheck -->
<script src="${ctx}/static/scripts/adminLTE/plugins/iCheck/icheck.min.js"></script>

<!-- jclock -->
<script src="${ctx}/static/scripts/adminLTE/plugins/clock-plugin/js/jquery.jclock-2.1.1.js"></script>
<!-- layer alert plugin -->
<script src="${ctx}/static/scripts/adminLTE/plugins/layer/layer.js"></script>

<script>
    $(function () {

        //除此之外，extend还允许你加载css。这对于layer的第三方皮肤有极大的帮助，如：
        layer.config({
            extend: [
                'extend/layer.ext.js',
                'skin/layer.ext.css' //layer-ext-myskin即是你拓展的皮肤文件
            ]
        });

        //初始化实时显示时间
        $("#curr_clock").jclock({format: '%Y-%b-%d %A %H:%M:%S'});

        //动画格式：0：从中间由小变大，居中，1：由上之中，由小变大 2：与1的方形相反（由下至中） 3：由左至中
        //4：在中间旋转90度 5:由中间淡入 6：中间左右颤抖一下
        //重置密码弹框
        $("#reset-pwd").on("click", function () {
            var html = '<div class="login-box-body"><form id="reset-form" method="post"><div class="form-group has-feedback">' +
                    '<div class="form-group has-feedback"><input type="text" name="password" onfocus="this.type=\'password\'" class="form-control" placeholder="原密码" autocomplete="off">'+
                    '<span class="glyphicon glyphicon-lock form-control-feedback"></span></div>'+
                    '<input type="text" name="password" onfocus="this.type=\'password\'" class="form-control" placeholder="新密码" autocomplete="off">' +
                    '<span class="glyphicon glyphicon-lock form-control-feedback"></span></div><div class="form-group has-feedback">' +
                    '<input type="text" id="rePassword" onfocus="this.type=\'password\'"  class="form-control" placeholder="确认密码" autocomplete="off">' +
                    '<span class="glyphicon glyphicon-lock form-control-feedback"></span></div></from></div>';
            layer.open({
                title: '重置密码',
                type: 1,
                content: html, //这里content是一个普通的String
                skin: 'layui-layer-lan',
                moveType: 1,
                shift: 1,
                scrollbar: false,
//              closeBtn:false,
                btn: ['重置密码', '取消'],
                yes: function (index) {
                    $.ajax({
                        url: "${ctx}/admin/auth/user/resetPassword",
                        type: "get",
                        data: $("#reset-from").serialize(),
                        dataType: "json",
                        success: function (resp) {
                            if (resp.status == "success") {
                                window.location.reload(true);
                            } else {
                                layer.msg(resp.message, {
                                    icon: 2,
                                    skin: 'layui-layer-default',
                                    shift: 6,
                                    time: 2000 //2秒关闭（如果不配置，默认是3秒）
                                });
                            }
                        },
                        error: function () {
                            //icon:0 感叹号，提醒，1:对号，成功 2：叉号，错误 3：问号，未知提醒
                            // 4：锁，秘密 5：哭丧脸，失败 6，笑脸，成功
                            layer.msg("网络错误，请检查", {
                                skin: 'layui-layer-hui',
                                icon: 5,
                                shift: 6,
                                time: 2000 //2秒关闭（如果不配置，默认是3秒）
                            });
                        }
                    });
                },
                cancel: function (index) {
                    layer.close(index);
                }
            });
        });

        //修改头像弹框
        $("#reset-head").on("click", function () {
            layer.open({
                type: 2,
                skin: 'layui-layer-lan',
                title: '修改头像',
                fix: true,
                moveType: 1,
                shade: 0.8,
                area: ['50%', '60%'],
                content: '${ctx}/admin/auth/user/resetHead'
            });
//            layer.open({
//                type: 1,
//                content: '传入任意的文本或html', //这里content是一个普通的String
//                shift: 7
//            });
        });

        //锁定屏幕
        $("#lock-screen").on("click", function () {
            var url = window.location.href;
            url = url.substring(url.indexOf("//") + 2);
            url = url.substring(url.indexOf("/"));
            window.location.href = "${ctx}/admin/lockScreen?from=" + url;
        });

        //退出系统
        $("#login-out").on("click", function() {
            window.location.href="${ctx}/admin/loginOut";
        });
    });

    /**
     * 跳转到指定页面
     * @param url 跳转地址
     * @param depId 部门ID
     * @param permGroupId 权限组ID
     * @param permId 权限ID
     */
    function jumpPage( url, permId ) {
        var param = "AUTH_PERM_ID="+permId;
        if( url.indexOf("?") != -1 ) {
            param = "&" + param;
        } else param = "?" + param;
        window.location.href='${ctx}'+url+param;
    }
</script>