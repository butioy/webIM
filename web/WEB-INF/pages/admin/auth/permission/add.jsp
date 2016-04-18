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
            <form class="form-horizontal" id="add_permission_form">
              <div class="form-group">
                <label for="name" class="col-md-4 control-label">权限名称</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" id="name" name="name" placeholder="权限名称"/>
                </div>
              </div>
              <div class="form-group">
                <label for="name" class="col-md-4 control-label">连接地址</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" id="url" name="url" placeholder="请输入权限连接地址"/>
                </div>
              </div>
              <div class="form-group">
                <label for="depId" class="col-md-4 control-label">所属部门</label>
                <div class="col-md-8">
                  <select class="form-control" name="depId" id="depId" placeholder="请选择部门" onchange="getGroups(this)">
                    <option value="">--请选择--</option>
                    <c:forEach items="${departments}" var="item">
                      <option value="${item.id}">--${item.name}--</option>
                    </c:forEach>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label for="depId" class="col-md-4 control-label">所属权限组</label>
                <div class="col-md-8">
                  <select class="form-control" name="perGroupId" id="perGroupId" placeholder="请选择权限组">
                    <option value="">--请选择--</option>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label class="col-md-4 control-label">权限类型</label>
                <div class="col-md-8">
                  <label>
                    <input type="radio" name="type" id="type_1" class="form-control" value="1">&nbsp;&nbsp;菜单权限
                  </label>
                  <label style="margin-left: 30px;">
                    <input type="radio" name="type" id="type_2" class="form-control" value="2">&nbsp;&nbsp;操作权限
                  </label>
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

              <div class="form-group">
                <label class="col-md-4 control-label">权限描述</label>
                <div class="col-md-8">
                  <textarea name="remark" id="remark" rows="3" class="form-control" placeholder="请输入"></textarea>
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
        $("input[type='radio']").iCheck({
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
        $("#cancel").on("click", function() {
          parent.layer.close(index);
        });
        $("#submitBtn").on("click", function() {
          $(this).attr("disabled", true);
          var param = $("#add_permission_form").serialize();
          $.ajax({
            type:"post",
            url: "${ctx}/admin/auth/permission/doAdd",
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

      function getGroups( _this ) {
        var depId = $(_this).val();
        $.getJSON('${ctx}/admin/auth/permissionGroup/getKVListByDepartment', {'depId':depId}, function(resp) {
          var html = '<option value="">--请选择--</option>';
          if( resp.status == 'success' ) {
            var list = resp.data;
            if( null != list && list.length > 0 ) {
              var obj;
              for( var i in list ) {
                obj = list[i];
                html += '<option value="'+obj.k+'">--'+obj.v+'--</option>';
              }
            }
          } else {
            parent.layer.alert(resp.message, {icon:5});
          }
          $("#perGroupId").html(html);
        });
      }
    </script>
  </body>
</html>
