<%--
  Created by IntelliJ IDEA.
  User: butioy
  Date: 2015/9/6
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglibs.jsp" %>
<!-- Left side column. contains the logo and sidebar -->
<aside class="main-sidebar">
    <!-- sidebar: style can be found in sidebar.less -->
    <section class="sidebar">
        <!-- Sidebar user panel -->
        <div class="user-panel">
            <div class="pull-left image">
                <%--<img src="${ctx}/static/styles/adminLTE/dist/img/user2-160x160.jpg" class="img-circle" alt="User Image">--%>
                <img src="${headImg}" onerror="${defaultHeadImg}" class="img-circle" alt="User Image">
            </div>
            <div class="pull-left info">
                <p>${SESSION_USER_KEY.fullName}</p>
                <a href="javascript:;"><i class="fa fa-circle text-success"></i> Online</a>
            </div>
        </div>
        <!-- search form -->
        <%--<form action="" method="get" class="sidebar-form">--%>
            <%--<div class="input-group">--%>
                <%--<input type="text" name="q" class="form-control" placeholder="Search...">--%>
              <%--<span class="input-group-btn">--%>
                <%--<button type="submit" name="search" id="search-btn" class="btn btn-flat"><i class="fa fa-search"></i>--%>
                <%--</button>--%>
              <%--</span>--%>
            <%--</div>--%>
        <%--</form>--%>
        <!-- /.search form -->
        <!-- sidebar menu: : style can be found in sidebar.less -->
        <ul class="sidebar-menu">
            <%--<li class="header">MENU LIST</li>--%>
            <c:forEach items="${MENU_LIST}" var="item">
                <li class="treeview ${CURRENT_MENU.id eq item.id ? 'active' : ''}">
                    <a href="javascript:;">
                        <i class="fa fa-files-o"></i>
                        <span>${item.name}</span>
                        <i class="fa fa-angle-left pull-right"></i>
                    </a>
                    <c:if test="${not empty item.permissions}">
                        <ul class="treeview-menu">
                        <c:forEach items="${item.permissions}" var="perm">
                            <li ${CURRENT_PERM.id eq perm.id ? "class='active'" : ""}><a href="javascript:;" onclick="jumpPage('${perm.url}', ${perm.id})">
                                <i class="fa fa-circle-o"></i> ${perm.name}</a>
                            </li>
                        </c:forEach>
                        </ul>
                    </c:if>
                </li>
            </c:forEach>
        </ul>
    </section>
    <!-- /.sidebar -->
</aside>
