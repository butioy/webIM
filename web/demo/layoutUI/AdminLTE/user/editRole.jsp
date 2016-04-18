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
    <link rel="stylesheet" href="${ctx}/static/scripts/adminLTE/plugins/laydate/need/laydate.css">
    <link rel="stylesheet" href="${ctx}/static/scripts/adminLTE/plugins/laydate/skins/default/laydate.css">
  </head>
  <body class="hold-transition sidebar-mini">
    <div class="wrapper">
      <!-- Main content -->
      <section class="container">
        <div class="row">
          <div class="col-md-12 form-horizontal">
            <form class="form-horizontal" id="edit_user_form">
              <input type="hidden" name="id" value="${id}"/>
              <div class="form-group">
                <label for="roleId" class="col-md-4 control-label">所属角色</label>
                <div class="col-md-8">
                  <select id="roleIds" name="roleIds" class="form-control" placeholder="请选择角色">
                    <option value="">--请选择--</option>
                    <c:forEach items="${roles}" var="item">
                      <option value="${item.id}" ${hasRoleId eq item.id ? 'selected' : ''}>--${item.name}--</option>
                    </c:forEach>
                  </select>
                </div>
              </div>
            </form>
          </div>
        </div>
      </section><!-- /.content -->
      <div class="box-footer">
        <button type="button" class="btn btn-default btn-flat" id="cancel">取消</button>
        <button type="button" class="btn btn-info btn-flat pull-right" id="submitBtn">确定</button>
      </div>
    </div><!-- ./wrapper -->
    <%@ include file="/WEB-INF/pages/commons/common-js.jsp"%>

    <!-- FastClick -->
    <script src="${ctx}/static/scripts/adminLTE/plugins/fastclick/fastclick.min.js"></script>
    <script src="${ctx}/static/scripts/adminLTE/plugins/laydate/laydate.js"></script>
    <script>
      $(function() {
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        $("#cancel").on("click", function() {
          parent.layer.close(index);
        });
        $("#submitBtn").on("click", function() {
          $(this).attr("disabled", true);
          var param = $("#edit_user_form").serialize();
          $.ajax({
            type:"post",
            url: "${ctx}/admin/auth/user/doEditRole",
            data: param,
            dataType:"json",
            success : function(resp) {
              if( resp.status == "success" ) {
                parent.layer.alert("添加成功", {icon:6, skin:'layui-layer-lan'}, function(i) {
                  parent.location.reload(true);
                  parent.layer.close(i);
                  parent.layer.close(index);
                });
              } else {
                $("#submitBtn").attr("disabled", false);
                parent.layer.open({
                  type:0,
                  shift:5,
                  content:resp.message
                });
              }
            }
          });
        });
      });
    </script>
  </body>
</html>
