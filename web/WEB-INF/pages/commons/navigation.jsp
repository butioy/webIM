<%--
  Created by IntelliJ IDEA.
  User: butioy
  Date: 2015/9/6
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglibs.jsp" %>
<header class="main-header">

    <!-- Logo -->
    <a href="index2.html" class="logo">
        <!-- mini logo for sidebar mini 50x50 pixels -->
        <span class="logo-mini"><b>B</b>LT</span>
        <!-- logo for regular state and mobile devices -->
        <span class="logo-lg"><b>Butioy</b>LTE</span>
    </a>

    <!-- Header Navbar: style can be found in header.less -->
    <nav class="navbar navbar-static-top" role="navigation">
        <!-- Sidebar toggle button-->
        <a href="javascript:;" class="sidebar-toggle" data-toggle="offcanvas" role="button">
            <span class="sr-only">Toggle navigation</span>
        </a>

        <!-- Navbar Right Menu -->
        <div class="navbar-custom-menu">
            <ul class="nav navbar-nav">
                <!-- User Account: style can be found in dropdown.less -->
                <li class="dropdown user user-menu">
                    <a href="javascript:;" class="dropdown-toggle" data-toggle="dropdown">
                        <%--<img src="${ctx}/static/styles/adminLTE/dist/img/user2-160x160.jpg" class="user-image" alt="User Image">--%>
                        <c:set value="${ctx}/static/images/head/default/default_${SESSION_USER_KEY.sex eq 1 ? 'man' : 'woman'}.jpg"
                               var="defaultHeadImg"/>
                        <c:choose>
                            <c:when test="${empty SESSION_USER_KEY.headImg}">
                                <c:set value="${defaultHeadImg}" var="headImg"/>
                            </c:when>
                            <c:otherwise>
                                <c:set value="${ctx}${SESSION_USER_KEY.headImg}.jpg" var="headImg"/>
                            </c:otherwise>
                        </c:choose>
                        <img src="${headImg}" onerror="this.src='defaultHeadImg'" class="user-image" alt="User Image">
                        <span class="hidden-xs">${SESSION_USER_KEY.fullName}</span>
                    </a>
                    <ul class="dropdown-menu">
                        <!-- User image -->
                        <li class="user-header">
                            <img src="${headImg}" onerror="this.src='${defaultHeadImg}'" class="img-circle" alt="User Image">
                            <p>欢迎 ${SESSION_USER_KEY.fullName} 登录系统Local
                                <small id="curr_clock"></small>
                            </p>
                        </li>
                        <!-- Menu Body -->
                        <li class="user-footer">
                            <div class="col-xs-4">
                                <a href="javascript:;" id="reset-pwd" class="btn btn-default btn-flat">修改密码</a>
                            </div>
                            <div class="col-xs-4">
                                <a href="javascript:;" id="reset-head" class="btn btn-default btn-flat">修改头像</a>
                            </div>
                            <div class="col-xs-4">
                                <a href="javascript:;" id="lock-screen" class="btn btn-default btn-flat">锁屏</a>
                            </div>
                        </li>
                        <!-- Menu Footer-->
                        <li class="user-footer">
                            <div class="pull-left">
                                <a href="javascript:;" id="user-info" class="btn btn-primary btn-flat">个人信息</a>
                            </div>
                            <div class="pull-right">
                                <a href="javascript:;" id="login-out" class="btn btn-primary btn-flat">退出系统</a>
                            </div>
                        </li>
                    </ul>
                </li>
            </ul>
        </div>

        <!-- Navbar Right Menu -->
        <div class="navbar-header pull-left">
            <%--<button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">--%>
                <%--<span class="sr-only navbar-brand" >菜单</span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
                <%--<span class="icon-bar"></span>--%>
            <%--</button>--%>
            <a class="navbar-brand navbar-toggle collapsed" href="#" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">菜单</a>
        </div>
        <div class="navbar-custom-menu collapse pull-left navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul class="nav navbar-nav">
                <!-- department navigator -->
                <c:forEach items="${DEPARTMENT_LIST}" var="item" varStatus="st">
                    <li class="messages-menu ${CURRENT_DEPARTMENT.id eq item.id ? 'active' : ''}">
                        <a href="${ctx}/admin/auth/department/${item.id}/index">${item.name}</a>
                    </li>
                </c:forEach>
            </ul>
        </div>
    </nav>
</header>
