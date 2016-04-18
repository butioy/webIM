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
              <input type="hidden" name="id" value="${user.id}"/>
              <div class="form-group">
                <label for="userName" class="col-md-4 control-label">用户名</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" id="userName" name="userName" value="${user.userName}" placeholder="用户名"/>
                </div>
              </div>
              <div class="form-group">
                <label for="fullName" class="col-md-4 control-label">真实姓名</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" id="fullName" name="fullName" value="${user.fullName}" placeholder="真实姓名"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-md-4 control-label">性别</label>
                <div class="col-md-8">
                  <label>
                    <input type="radio" name="sex" id="sex_1" class="form-control" value="1" ${user.sex eq 1 ? "checked" : ""}>&nbsp;&nbsp;男${user.sex }
                  </label>
                  <label style="margin-left: 30px;">
                    <input type="radio" name="sex" id="sex_0" class="form-control" value="0" ${user.sex eq 0 ? "checked" : ""}>&nbsp;&nbsp;女
                  </label>
                </div>
              </div>
              <div class="form-group">
                <label for="birthday" class="col-md-4 control-label">生日</label>
                <div class="col-md-8">
                  <input type="text" class="form-control laydate-icon" id="birthday" name="birthdayStr" placeholder="请选择日期"
                          value="<fmt:formatDate value="${user.birthday }" pattern="yyyy-MM-dd"/>" />
                </div>
              </div>
              <div class="form-group">
                <label class="col-md-4 control-label">类型</label>
                <div class="col-md-8">
                  <label>
                    <input type="radio" name="userType" id="userType_1" class="form-control" value="1" ${user.userType eq 1 ? "checked" : ''}>&nbsp;&nbsp;系统管理员
                  </label>
                  <label style="margin-left: 30px;">
                    <input type="radio" name="userType" id="userType_2" class="form-control" value="2" ${user.userType eq 2 ? "checked" : ''}>&nbsp;&nbsp;普通用户
                  </label>
                  <%--<label style="margin-left: 30px;">--%>
                    <%--<input type="radio" name="userType" id="userType_5" class="form-control" value="5" ${user.userType eq 5 ? "checked" : ''}>&nbsp;&nbsp;超级管理员--%>
                  <%--</label>--%>
                </div>
              </div>
              <div class="form-group">
                <label for="headImg" class="col-md-4 control-label">头像</label>
                <div class="col-md-8">
                  <input type="text" class="form-control" id="headImg" name="headImg" ${item.headImg} placeholder="头像"/>
                </div>
              </div>
              <div class="form-group">
                <label class="col-md-4 control-label">状态</label>
                <div class="col-md-8">
                  <label>
                    <input type="radio" name="status" id="status_1" class="form-control" value="1" ${user.status eq 1 ? "checked" : ''}>&nbsp;&nbsp;启用
                  </label>
                  <label style="margin-left: 30px;">
                    <input type="radio" name="status" id="status_0" class="form-control" value="0" ${user.status eq 0 ? "checked" : ''}>&nbsp;&nbsp;禁用
                  </label>
                </div>
              </div>
              <div class="form-group">
                <label for="roleId" class="col-md-4 control-label">所属角色</label>
                <div class="col-md-8">
                  <select id="roleId" name="roleId" class="form-control" placeholder="请选择角色">
                    <option value="">--请选择--</option>
                    <c:forEach items="${roles}" var="item">
                      <option value="${item.id}" ${hasRoleId eq item.id ? 'selected' : ''}>--${item.name}--</option>
                    </c:forEach>
                  </select>
                </div>
              </div>
              <div class="form-group">
                <label for="remark" class="col-md-4 control-label">描述</label>
                <div class="col-md-8">
                  <textarea id="remark" name="remark" class="form-control" placeholder="描述">${item.remark}</textarea>
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
        laydate({
          elem: '#birthday'
        })
        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
//        parent.layer.iframeAuto(index);
        $("input[type='radio']").iCheck({
          radioClass: 'iradio_square-blue',
          increaseArea: '20%' // optional
        });
        $("#cancel").on("click", function() {
          parent.layer.close(index);
        });
        $("#submitBtn").on("click", function() {
          $(this).attr("disabled", true);
          var param = $("#edit_user_form").serialize();
          $.ajax({
            type:"post",
            url: "${ctx}/admin/auth/user/doEdit",
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
