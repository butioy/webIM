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
    <title>AdminLTE 2 | Dashboard</title>
    <%@ include file="/WEB-INF/pages/commons/common-css.jsp"%>
    <!-- jvectormap -->
    <link rel="stylesheet" href="${ctx}/static/styles/adminLTE/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${ctx}/static/styles/adminLTE/dist/css/skins/_all-skins.min.css">
  </head>
  <body class="hold-transition skin-blue sidebar-mini fixed">
    <div class="wrapper">
      <!-- 导航栏 -->
      <%@ include file="/WEB-INF/pages/commons/navigation.jsp"%>
      <!-- 左侧权限菜单 -->
      <%@ include file="/WEB-INF/pages/commons/menu.jsp"%>

      <!-- Content Wrapper. Contains page content -->
      <div class="content-wrapper">
        <!-- 内容页 当前位置 -->
        <%@ include file="/WEB-INF/pages/commons/contentHeader.jsp"%>
        <!-- Main content -->
        <section class="content">
          <!-- Info boxes -->
          <c:choose>
            <c:when test="${empty MENU_LIST}">
              <div class="row">
                <div class="col-md-12">
                  <div class="box">
                    <div class="box-header with-border">
                      <h3 class="box-title">没有所属权限</h3>
                      <div class="box-tools pull-right">
                        <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                        <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                      </div>
                    </div><!-- /.box-header -->
                    <%--<div class="box-body">--%>
                      <%--<div class="row">--%>
                        <%--<div class="col-md-3 col-sm-6 col-xs-12">--%>
                          <%--<div class="info-box text-center">--%>
                            <%--<span class="info-box-icon bg-aqua"><i class="ion ion-ios-gear-outline"></i></span>--%>
                            <%--<a style="font-size: 14px; line-height: 90px;">没有所属权限</a>--%>
                          <%--</div><!-- /.info-box -->--%>
                        <%--</div><!-- /.col -->--%>
                      <%--</div><!-- /.row -->--%>
                    <%--</div><!-- ./box-body -->--%>
                  </div><!-- /.box -->
                </div><!-- /.col -->
              </div><!-- /.row -->
            </c:when>
            <c:otherwise>
              <c:forEach items="${MENU_LIST}" var="item">
                <div class="row">
                  <div class="col-md-12">
                    <div class="box">
                      <div class="box-header with-border">
                        <h3 class="box-title">${item.name}</h3>
                        <div class="box-tools pull-right">
                          <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                            <%--<div class="btn-group">--%>
                            <%--<button class="btn btn-box-tool dropdown-toggle" data-toggle="dropdown"><i class="fa fa-wrench"></i></button>--%>
                            <%--<ul class="dropdown-menu" role="menu">--%>
                            <%--<li><a href="#">Action</a></li>--%>
                            <%--<li><a href="#">Another action</a></li>--%>
                            <%--<li><a href="#">Something else here</a></li>--%>
                            <%--<li class="divider"></li>--%>
                            <%--<li><a href="#">Separated link</a></li>--%>
                            <%--</ul>--%>
                            <%--</div>--%>
                          <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                        </div>
                      </div><!-- /.box-header -->
                      <div class="box-body">
                        <div class="row">
                          <c:choose>
                            <c:when test="${empty item.permissions}">
                                <div class="col-md-3 col-sm-6 col-xs-12">
                                  <div class="info-box text-center">
                                    <span class="info-box-icon bg-aqua"><i class="ion ion-ios-gear-outline"></i></span>
                                    <a style="font-size: 14px; line-height: 90px;">没有对应权限</a>
                                  </div><!-- /.info-box -->
                                </div><!-- /.col -->
                            </c:when>
                            <c:otherwise>
                              <c:forEach items="${item.permissions}" var="perm">
                                <div class="col-md-3 col-sm-6 col-xs-12">
                                  <div class="info-box text-center" style="cursor: pointer;" onclick="jumpPage('${perm.url}', ${perm.id});">
                                    <span class="info-box-icon bg-aqua"><i class="ion ion-ios-gear-outline"></i></span>
                                    <a style="font-size: 14px; line-height: 90px;">${perm.name}</a>
                                  </div><!-- /.info-box -->
                                </div><!-- /.col -->
                              </c:forEach>
                            </c:otherwise>
                          </c:choose>
                        </div><!-- /.row -->
                      </div><!-- ./box-body -->
                    </div><!-- /.box -->
                  </div><!-- /.col -->
                </div><!-- /.row -->
              </c:forEach>
            </c:otherwise>
          </c:choose>
        </section><!-- /.content -->
      </div><!-- /.content-wrapper -->

      <!-- 页脚 -->
      <%@ include file="/WEB-INF/pages/commons/footer.jsp"%>

      <!-- 右侧风格设置菜单 -->
      <%@ include file="/WEB-INF/pages/commons/controlSidebar.jsp"%>

    </div><!-- ./wrapper -->
    <%@ include file="/WEB-INF/pages/commons/common-js.jsp"%>

    <!-- FastClick -->
    <script src="${ctx}/static/scripts/adminLTE/plugins/fastclick/fastclick.min.js"></script>
    <!-- AdminLTE App -->
    <script src="${ctx}/static/scripts/adminLTE/dist/app.min.js"></script>
    <!-- SlimScroll 1.3.0 -->
    <script src="${ctx}/static/scripts/adminLTE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
  </body>
</html>
