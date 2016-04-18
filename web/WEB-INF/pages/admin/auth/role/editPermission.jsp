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
    <link rel="stylesheet" href="${ctx}/static/scripts/adminLTE/plugins/ztree/css/metroStyle/metroStyle.css">
  </head>
  <body class="hold-transition sidebar-mini fixed">
  <input type="hidden" id="checkedStatus" value="0"/>
  <input type="hidden" id="roleId" value="${roleId}"/>
    <div class="wrapper">
      <!-- Main content -->
      <section class="container">
        <div class="row">
          <div class="col-xs-6 form-horizontal">
              <label>菜单权限</label>
            <form class="form-horizontal" id="edit_role_form">
              <ul id="ztree" class="ztree"></ul>
            </form>
          </div>
            <div class="col-xs-6 form-horizontal">
                <label>标签权限</label>
                <form class="form-horizontal" id="edit_role_form_01">
                    <ul id="ztree_01" class="ztree"></ul>
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
    <script src="${ctx}/static/scripts/adminLTE/plugins/ztree/js/jquery.ztree.all-3.5.min.js"></script>
    <script>

        var asyncCount = 0;

      var setting = {
          check: {
              enable: true,
              chkStyle: "checkbox"
          },
        async: {
          enable: true,
          url:"${ctx}/admin/auth/role/getPermissionTree",
          autoParam:["id", "level"],
          otherParam:{"roleId":${roleId},"checkedStatus":function() {return $("#checkedStatus").val();}},
          dataFilter: filter,
          type: "get"
        },
        callback: {
          beforeAsync: beforeAsync,
          onAsyncSuccess: onAsyncSuccess,
          onAsyncError: onAsyncError
        }
      };

      function filter(treeId, parentNode, childNodes) {
        if (!childNodes) return null;
        for (var i=0, l=childNodes.length; i<l; i++) {
          childNodes[i].name = childNodes[i].name.replace(/\.n/g, '.');
        }
        return childNodes;
      }

      function beforeAsync(treeId, treeNode) {
          if( treeNode && treeNode.checked ) {
              $("#checkedStatus").val(1);
          } else {
              $("#checkedStatus").val(0);
          }
      }

      function onAsyncSuccess(event, treeId, treeNode, msg) {
          asyncCount++;
      }

      function onAsyncError(event, treeId, treeNode, XMLHttpRequest, textStatus, errorThrown) {
      }

      function addHoverDom(treeId, treeNode) {
          var sObj = $("#" + treeNode.tId + "_span");
          if (treeNode.editNameFlag || $("#addBtn_"+treeNode.tId).length>0) return;
          var addStr = "<span class='button add' id='addBtn_" + treeNode.tId
                  + "' title='add node' onfocus='this.blur();'></span>";
          sObj.after(addStr);
          var btn = $("#addBtn_"+treeNode.tId);
          if (btn) btn.bind("click", function(){
              var zTree = $.fn.zTree.getZTreeObj("treeDemo");
              zTree.addNodes(treeNode, {id:(100 + newCount), pId:treeNode.id, name:"new node" + (newCount++)});
              return false;
          });
      };
      function removeHoverDom(treeId, treeNode) {
          $("#addBtn_"+treeNode.tId).unbind().remove();
      };
      $(function() {
          setting.async.otherParam.type=1;
        var ztree = $.fn.zTree.init($("#ztree"), setting);
          setting.async.otherParam.type=2;
        var ztree01 = $.fn.zTree.init($("#ztree_01"), setting);
          function asyAll() {
              setTimeout(function() {
                  if( asyncCount == 2 ) {
                      asyncAll();
                  } else {
                      asyAll();
                  }
              }, 100);
          }
          asyAll();

        var index = parent.layer.getFrameIndex(window.name); //获取窗口索引
//          parent.layer.iframeAuto(index);
        $("#cancel").on("click", function() {
          parent.layer.close(index);
        });
        $("#submitBtn").on("click", function() {
          $(this).attr("disabled", true);
            var menuNodes = ztree.getCheckedNodes(true);
            var tagNodes = ztree01.getCheckedNodes(true);
            var menuIds = "";
            for( var i in menuNodes ) {
                if( menuNodes[i].level == 2 ) {
                    menuIds += ","+menuNodes[i].id;
                }
            }
            var tagIds = "";
            for( var i in tagNodes ) {
                if( tagNodes[i].level == 2 ) {
                    tagIds += ","+tagNodes[i].id;
                }
            }
            var roleId = $("#roleId").val();
            $.post("${ctx}/admin/auth/role/${roleId}/doEditPermission", {"menuIds":menuIds, "tagIds":tagIds}, function(resp) {
                if( resp.status == "success" ) {
                    parent.layer.alert("权限修改成功", {icon:6, skin:'layui-layer-lan'}, function(i) {
                        parent.layer.closeAll();
                    });
                } else {
                    $(this).attr("disabled", false );
                    parent.layer.msg(resp.message);
                }
            });
        });
      });

      function asyncAll() {
          var menuZtree = $.fn.zTree.getZTreeObj("ztree");
          var tagZtree = $.fn.zTree.getZTreeObj("ztree_01");
          $.ajaxSetup({async:false});
          asyncNodesForMenu(menuZtree.getNodes());
          asyncNodesForTag(tagZtree.getNodes());
          $.ajaxSetup({async:true});
      }
      function asyncNodesForMenu(nodes) {
          if (!nodes) return;
          var menuZtree = $.fn.zTree.getZTreeObj("ztree");
          for (var i=0, l=nodes.length; i<l; i++) {
              if (!(nodes[i].isParent && nodes[i].zAsync)) {
                  menuZtree.reAsyncChildNodes(nodes[i], "refresh", true);
              }
              asyncNodesForMenu(nodes[i].children);
          }
      }
        function asyncNodesForTag(nodes) {
            if (!nodes) return;
          var tagZtree = $.fn.zTree.getZTreeObj("ztree_01");
            for (var i=0, l=nodes.length; i<l; i++) {
                if (!(nodes[i].isParent && nodes[i].zAsync)) {
                    tagZtree.reAsyncChildNodes(nodes[i], "refresh", true);
                }
                asyncNodesForTag(nodes[i].children);
            }
        }
    </script>
  </body>
</html>
