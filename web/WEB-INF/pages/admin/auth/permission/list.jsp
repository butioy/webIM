<%--
Created by IntelliJ IDEA.
User: butioy
Date: 2015/9/6
Time: 21:01
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/commons/taglibs.jsp" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>AdminLTE 2 | Dashboard</title>
    <%@ include file="/WEB-INF/pages/commons/common-css.jsp" %>
    <!-- jvectormap -->
    <link rel="stylesheet" href="${ctx}/static/styles/adminLTE/plugins/jvectormap/jquery-jvectormap-1.2.2.css">
    <!-- AdminLTE Skins. Choose a skin from the css/skins
         folder instead of downloading all of them to reduce the load. -->
    <link rel="stylesheet" href="${ctx}/static/styles/adminLTE/dist/css/skins/_all-skins.min.css">
</head>
<body>
<!-- Main content -->
<section class="content">
    <!-- Info boxes -->
    <div class="row">
        <div class="col-md-12">
            <%--<div class="box">--%>
                <div class=" table-responsive">
                    <table class="table table-hover hover-blue table-striped table-bordered text-center">
                        <thead>
                        <tr>
                            <th class="info">序号</th>
                            <th class="info">操作</th>
                            <th class="info">权限名称</th>
                            <th class="info">权限URL</th>
                            <th class="info">类型</th>
                            <th class="info">状态</th>
                            <th class="info">创建时间</th>
                            <th class="info">修改时间</th>
                            <th class="info">创建人</th>
                            <th class="info">所属部门</th>
                            <th class="info">所属权限组</th>
                        </tr>
                        </thead>
                        <tdoby>
                            <c:forEach items="${permissions}" var="item" varStatus="st">
                                <tr>
                                    <td>${st.count}</td>
                                    <td>
                                        <a href="javascript:;" class="btn btn-primary btn-flat btn-xs" onclick="editPermission(${item.id});"><i class="fa fa-edit"></i> 编辑</a>
                                        <a href="javascript:;" class="btn btn-danger btn-flat btn-xs" onclick="removePermission(this, ${item.id});"><i class="fa fa-trash"></i> 删除</a>
                                    </td>
                                    <td>${item.name}</td>
                                    <td>${item.url}</td>
                                    <td>${item.type eq 1 ? '菜单权限' : '操作权限'}</td>
                                    <td>${item.status eq 1 ? '启用' : '禁用'}</td>
                                    <td><fmt:formatDate value="${item.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    <td><fmt:formatDate value="${item.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                    <td>${item.user.fullName}</td>
                                    <td>${item.department.name}</td>
                                    <td>${item.permissionGroup.name}</td>
                                </tr>
                            </c:forEach>
                        </tdoby>
                    </table>
                </div>
            <%--</div>--%>
        </div>
    </div>
</section>
<!-- /.content -->
<%--<div class="wrapper">--%>
    <%--<!-- Content Wrapper. Contains page content -->--%>
    <%--<div class="content-wrapper">--%>
        <%----%>
    <%--</div>--%>
    <%--<!-- /.content-wrapper -->--%>
<%--</div>--%>
<!-- ./wrapper -->
<%@ include file="/WEB-INF/pages/commons/common-js.jsp" %>

<!-- FastClick -->
<script src="${ctx}/static/scripts/adminLTE/plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="${ctx}/static/scripts/adminLTE/dist/app.min.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="${ctx}/static/scripts/adminLTE/plugins/slimScroll/jquery.slimscroll.min.js"></script>

<script>
    function editPermission( _this, id) {
        $(_this).prop("disabled", true);
        parent.layer.open({
            type: 2,
            skin: 'layui-layer-lan',
            title: '权限编辑',
            fix: true,
            moveType: 1,
            shade: 0.8,
            shadeClose: false,
            area: ['50%', '60%'],
            content: '${ctx}/admin/auth/permission/' + id + '/edit',
            end : function() {
                $(_this).prop("disabled", false);
            }
        });
    }

    function removePermission( _this, ids ) {
        $(_this).prop("disabled", true);
        if( (ids+'').length > 0 ) {
            layer.confirm("确定删除？", {icon: 3, title:'提示', skin:"layui-layer-lan"}, function(index) {
                layer.close(index);
                $.ajax({
                    url : "${ctx}/admin/auth/permission/batchRemove",
                    type : 'post',
                    data : {'ids':ids},
                    dataType : 'json',
                    success : function(resp) {
                        if( resp.status == 'success' ) {
                            layer.alert("操作成功", {icon:6, skin:"layui-layer-lan"}, function( index ) {
                                layer.close(index);
                                window.location.reload(true);
                            });
                        } else {
                            layer.alert(resp.message, {icon:5, skin:"layui-layer-lan"});
                        }
                    },
                    error : function() {
                        layer.alert("发生未知错误", {icon:5, skin:"layui-layer-lan"});
                    }
                });
                $(_this).prop("disabled", false);
            }, function(index) {
                layer.close(index);
                $(_this).prop("disabled", false);
            });
        } else {
            $(_this).prop("disabled", false);
            layer.alert("请选择需要删除的权限", {icon:5, skin:"layui-layer-lan"});
        }
    }
</script>
</body>
</html>
