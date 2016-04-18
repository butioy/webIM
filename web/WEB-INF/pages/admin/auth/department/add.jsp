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
  <body class="hold-transition sidebar-mini">
    <div class="wrapper">
      <!-- Main content -->
      <section class="content container">
        <div class="row">
          <div class="col-md-12 form-horizontal">
            <form class="form-horizontal" id="add_department_form">
              <div class="form-group">
                <label for="name" class="col-md-4 control-label">部门名称</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" id="name" name="name" placeholder="部门名称"/>
                </div>
              </div>
              <div class="form-group">
                <label for="remark" class="col-md-4 control-label">备注</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" id="remark" name="remark" placeholder="备注" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-md-4 control-label">状态</label>
                <div class="col-md-8">
                  <label>
                    <input type="radio" name="status" id="status_1" class="form-control" value="1">&nbsp;&nbsp;启用
                  </label>
                  <label style="margin-left: 30px;">
                    <input type="radio" name="status" id="status_0" class="form-control" value="0">&nbsp;&nbsp;禁用
                  </label>
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
    <script>
      $(function() {
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
        parent.layer.iframeAuto(index);
        $("input[type='radio']").iCheck({
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
        $("#cancel").on("click", function() {
          parent.layer.close(index);
        });
        $("#submitBtn").on("click", function() {
          $(this).attr("disabled", true);
          var param = $("#add_department_form").serialize();
          $.ajax({
            type:"post",
            url: "${ctx}/admin/auth/department/doAdd",
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
