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
    <link rel="stylesheet" href="${ctx}/static/scripts/adminLTE/plugins/laypage/skin/laypage.css">
</head>
<body class="hold-transition skin-blue sidebar-mini fixed">
<div class="wrapper">
    <!-- 导航栏 -->
    <%@ include file="/WEB-INF/pages/commons/navigation.jsp" %>
    <!-- 左侧权限菜单 -->
    <%@ include file="/WEB-INF/pages/commons/menu.jsp" %>

    <!-- Content Wrapper. Contains page content -->
    <div class="content-wrapper">
        <!-- 内容页 当前位置 -->
        <%@ include file="/WEB-INF/pages/commons/contentHeader.jsp" %>
        <!-- Main content -->
        <section class="content">
            <!-- Info boxes -->
            <div class="row">
                <div class="col-md-12">
                    <div class="box">
                        <div class="box-header skin-blue with-border">
                            <%--<h3 class="box-title">权限表格</h3>--%>
                            <div class="pull-left">
                                <button class="btn btn-info btn-flat btn-box-tool" id="add_btn" style="color: #fff;"><i class="fa fa-plus-square-o"></i> 添加</button>
                                <button class="btn btn-danger btn-flat btn-box-tool" id="batch_del_btn" style="color: #fff;"><i class="fa fa-trash"></i> 批量删除</button>
                            </div>
                            <div class="box-tools pull-right">
                                <button class="btn btn-box-tool" data-widget="collapse"><i class="fa fa-minus"></i></button>
                                <button class="btn btn-box-tool" data-widget="remove"><i class="fa fa-times"></i></button>
                            </div>
                        </div>
                        <div class="box-body table-responsive">
                            <table class="table table-hover hover-blue table-striped table-bordered text-center">
                                <thead>
                                <tr>
                                    <th class="info">
                                        <label class="pull-left">
                                            <input type="checkbox" id="selectAll" class="pull-left"/>&nbsp;全选
                                        </label>
                                    </th>
                                    <th class="info">序号</th>
                                    <th class="info">操作</th>
                                    <th class="info">用户名</th>
                                    <th class="info">真实姓名</th>
                                    <th class="info">性别</th>
                                    <th class="info">生日</th>
                                    <th class="info">类型</th>
                                    <th class="info">状态</th>
                                    <th class="info">创建时间</th>
                                    <th class="info">修改时间</th>
                                    <th class="info">创建人</th>
                                </tr>
                                </thead>
                                <tdoby>
                                    <c:forEach items="${users}" var="item" varStatus="st">
                                        <c:choose>
                                            <c:when test="${!(item.userType eq 5)}">
                                                <tr>
                                                    <td>
                                                        <input type="checkbox" name="items" value="${item.id}" class="pull-left"/>
                                                    </td>
                                                    <td>${not empty COUNT ? st.count-COUNT : st.count}</td>
                                                    <td>
                                                        <a href="javascript:;" class="btn btn-info btn-flat btn-xs"
                                                           onclick="editUser(this, ${item.id});"><i class="fa fa-edit"></i> 编辑</a>
                                                        <a href="javascript:;" class="btn btn-danger btn-flat btn-xs"
                                                           onclick="batchRemove(this, ${item.id});"><i class="fa fa-trash"></i> 删除</a>
                                                        <a href="javascript:;" class="btn btn-info btn-flat btn-xs"
                                                           onclick="editRole(this, ${item.id});"><i class="fa fa-edit"></i> 修改角色</a>
                                                        <a href="javascript:;" class="btn btn-warning btn-flat btn-xs"
                                                           onclick="resetPassword(this, ${item.id});"><i class="fa fa-edit"></i> 重置密码</a>
                                                    </td>
                                                    <td>${item.userName}</td>
                                                    <td>${item.fullName}</td>
                                                    <td>${item.sex eq 1 ? '男' : '女'}</td>
                                                    <td><fmt:formatDate value="${item.birthday}" pattern="yyyy-MM-dd"/></td>
                                                    <td>${item.userType eq 1 ? '系统管理员' : item.userType eq 5 ? '超级管理员' : '普通用户'}</td>
                                                    <td>${item.status eq 1 ? '启用' : '禁用'}</td>
                                                    <td><fmt:formatDate value="${item.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                                    <td><fmt:formatDate value="${item.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
                                                    <td>${item.addUserId}</td>
                                                </tr>
                                            </c:when>
                                            <c:otherwise>
                                                <c:set var="COUNT" value="${not empty COUNT ? COUNT+1 : 1}" scope="page"/>
                                            </c:otherwise>
                                        </c:choose>
                                    </c:forEach>
                                </tdoby>
                                <%--<tr>--%>
                                    <%--<td colspan="8">--%>
                                    <%--</td>--%>
                                <%--</tr>--%>
                            </table>
                            <input type="hidden" id="pages" value="${pages}"/>
                            <input type="hidden" id="pageNumber" value="${pageNumber}"/>
                            <input type="hidden" id="pageSize" value="${pageSize}"/>
                            <div id="pagination" style="margin-top: 15px;"></div>
                        </div>
                    </div>
                </div>
            </div>
        </section>
        <!-- /.content -->
    </div>
    <!-- /.content-wrapper -->

    <!-- 页脚 -->
    <%@ include file="/WEB-INF/pages/commons/footer.jsp" %>

    <!-- 右侧风格设置菜单 -->
    <%@ include file="/WEB-INF/pages/commons/controlSidebar.jsp" %>

</div>
<!-- ./wrapper -->
<%@ include file="/WEB-INF/pages/commons/common-js.jsp" %>

<!-- FastClick -->
<script src="${ctx}/static/scripts/adminLTE/plugins/fastclick/fastclick.min.js"></script>
<!-- AdminLTE App -->
<script src="${ctx}/static/scripts/adminLTE/dist/app.min.js"></script>
<!-- SlimScroll 1.3.0 -->
<script src="${ctx}/static/scripts/adminLTE/plugins/slimScroll/jquery.slimscroll.min.js"></script>
<script src="${ctx}/static/scripts/adminLTE/plugins/laypage/laypage.dev.js"></script>

<script>

    $(function () {
        $("#selectAll").on("click", function() {
            var isChecked = $(this).is(":checked");
            $("input[name='items']").each(function(){$(this).prop("checked", isChecked);});
        });

        $("#add_btn").on("click", function() {
            var _this = this;
            $(_this).prop("disabled", true);
            layer.open({
                type: 2,
                skin: 'layui-layer-lan',
                title: '添加用户',
                fix: true,
                moveType: 1,
                shade: 0.8,
                shadeClose: false,
                area:["50%","60%"],
                content: '${ctx}/admin/auth/user/toAdd',
                end : function() {
                    $(_this).prop("disabled", false);
                }
            });
        });

        $("#batch_del_btn").on("click", function() {
            var ids = "";
            $("input[name='items']:checked").each(function(){
                ids += ","+$(this).val();
            });
            batchRemove(this, ids);
        });

        //好像很实用的样子，后端的同学再也不用写分页逻辑了。
        laypage({
            cont: 'pagination',
            pages: function() {
                var pages = ${pages};
                return pages ? pages : 1;
            }(), //可以叫服务端把总页数放在某一个隐藏域，再获取。假设我们获取到的是18
            curr: function(){ //通过url获取当前页，也可以同上（pages）方式获取
                var pageNumber = ${pageNumber};
                return pageNumber ? pageNumber : 1;
            }(),
            skip:true,
            jump: function(e, first){ //触发分页后的回调
                if(!first){ //一定要加此判断，否则初始时会无限刷新
                    location.href = '?pageNumber='+e.curr;
                }
            }
        });

    });

    function editUser(_this, id) {
        $(_this).prop("disabled", true);
        layer.open({
            type: 2,
            skin: 'layui-layer-lan',
            title: '用户编辑',
            fix: true,
            moveType: 1,
            shade: 0.8,
            shadeClose: false,
            area: ['50%', '60%'],
            content: '${ctx}/admin/auth/user/' + id + '/toEdit',
            end : function() {
                $(_this).prop("disabled", false);
            }
        });
    }

    function batchRemove( _this, ids ) {
        $(_this).prop("disabled", true);
        if( (ids+'').length > 0 ) {
            layer.confirm("确定删除？", {icon: 3, title:'提示', skin:"layui-layer-lan"}, function(index) {
                layer.close(index);
                $.ajax({
                    url : "${ctx}/admin/auth/user/batchRemove",
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
            layer.alert("请选择需要删除的用户", {icon:5, skin:"layui-layer-lan"});
        }
    }

    function editRole( _this, id ) {
        $(_this).prop("disabled", true);
        layer.open({
            type: 2,
            skin: 'layui-layer-lan',
            title: '所属角色修改',
            fix: true,
            moveType: 1,
            shade: 0.8,
            shadeClose: false,
            area: ['50%', '60%'],
            content: '${ctx}/admin/auth/user/' + id + '/toEditRole',
            end : function() {
                $(_this).prop("disabled", false);
            }
        });
    }

    function resetPassword( _this, id ) {
        $(_this).prop("disabled", true);
        layer.confirm("确认重置密码？", {icon: 3, title:'提示', skin:"layui-layer-lan", moveType:1}, function(index) {
            layer.close(index);
            $.ajax({
                url : "${ctx}/admin/auth/user/resetPassword",
                type : 'post',
                data : {'id': id, 'password':'111111'},
                dataType : 'json',
                success : function(resp) {
                    $(_this).prop("disabled", false);
                    if( resp.status == 'success' ) {
                        layer.alert("重置成功，新密码为："+resp.data, {icon:6, skin:"layui-layer-lan"}, function( index ) {
                            layer.close(index);
                            window.location.reload(true);
                        });
                    } else {
                        layer.alert(resp.message, {icon:5, skin:"layui-layer-lan"});
                    }
                },
                error : function() {
                    $(_this).prop("disabled", false);
                    layer.alert("发生未知错误", {icon:5, skin:"layui-layer-lan"});
                }
            });
        }, function(index) {
            layer.close(index);
            $(_this).prop("disabled", false);
        });
    }
</script>
</body>
</html>
