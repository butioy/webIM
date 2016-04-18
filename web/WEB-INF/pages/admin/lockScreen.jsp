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
    <title>Butioy | 锁屏</title>
    <%@ include file="/WEB-INF/pages/commons/common-css.jsp"%>
    <style>
      .error-password{
        -webkit-animation: shake .3s;
        -moz-animation: shake .3s;
        -o-animation: shake .3s;
        animation: shake .3s;
      }
    </style>
  </head>
  <body class="hold-transition lockscreen">
    <!-- Automatic element centering -->
    <div class="lockscreen-wrapper">
      <div class="lockscreen-logo">
        <a href="../../index2.html"><b>Butioy</b>LTE</a>
      </div>
      <!-- User name -->
      <div class="lockscreen-name">${user.userName}</div>
      <input type="hidden" id="from" value="${FROM_URL}"/>
      <!-- START LOCK SCREEN ITEM -->
      <div class="lockscreen-item">
        <!-- lockscreen image -->
        <div class="lockscreen-image">
          <c:set value="${ctx}/static/images/head/default/default_${user.sex eq 1 ? 'man' : 'woman'}.jpg" var="defaultHeadImg"/>
          <c:choose>
            <c:when test="${empty user.headImg}">
              <c:set value="${defaultHeadImg}" var="headImg"/>
            </c:when>
            <c:otherwise>
              <c:set value="${ctx}${user.headImg}.jpg" var="headImg"/>
            </c:otherwise>
          </c:choose>
          <img src="${headImg}" onerror="this.src='${defaultHeadImg}'" alt="User Image">
        </div>
        <!-- /.lockscreen-image -->

        <!-- lockscreen credentials (contains the form) -->
        <form id="unlock-from" class="lockscreen-credentials">
          <div class="input-group" >
            <input type="hidden" name="account" value="${user.userName}"/>
            <input type="text" id="password" name="password" class="form-control" placeholder="密码" onfocus="this.type='password'">
            <div class="input-group-btn">
              <button type="button" class="btn" id="unlock-screen"><i class="fa fa-arrow-right text-muted"></i></button>
            </div>
          </div>
        </form><!-- /.lockscreen credentials -->

      </div><!-- /.lockscreen-item -->
      <div class="help-block text-center">
        输入密码进入系统
      </div>
      <div class="text-center">
        <a href="${ctx}/admin/login">或者使用其他用户登录</a>
      </div>
      <div class="lockscreen-footer text-center">
        Copyright &copy; 2014-2015 <b><a href="http://almsaeedstudio.com" class="text-black">Almsaeed Studio</a></b><br>
        All rights reserved
      </div>
    </div><!-- /.center -->

    <%@ include file="/WEB-INF/pages/commons/common-js.jsp"%>
    <script>
      $(function() {
        $("#unlock-screen").on("click", function() {
          $.get("${ctx}/admin/doLogin", $("#unlock-from").serialize(), function(resp) {
            if( resp.status == "success" ) {
              window.location.href="${ctx}"+$("#from").val();
            } else {
              $("#password").addClass("error-password");
              $("#password").css({'color':'#d43f3a'});
              setTimeout(function(){$("#password").removeClass("error-password")},300);
//              layer.msg(resp.message , {
//                shift : 6
//              });
            }
          });
        });
      });
    </script>
  </body>
</html>