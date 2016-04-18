<%--
Created by IntelliJ IDEA.
User: butioy
Date: 2015/9/6
Time: 21:01
To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="/WEB-INF/pages/commons/taglibs.jsp"%>
<c:if test="${not empty permissionGroups}">
  <div class="box-body table-responsive">
    <table class="table table-hover table-striped table-bordered text-center">
      <thead>
      <tr>
        <th class="info">序号</th>
        <th class="info">操作</th>
        <th class="info">名称</th>
        <th class="info">创建时间</th>
        <th class="info">修改时间</th>
        <th class="info">创建人</th>
        <th class="info">状态</th>
      </tr>
      </thead>
      <tbody>
      <c:forEach items="${permissionGroups}" var="item" varStatus="st">
        <tr>
          <td>${st.count}</td>
          <td>
            <a href="javascript:;" class="btn btn-primary btn-flat btn-xs" onclick="editPermissionGroup(${item.id});"><i class="fa fa-edit"></i> 编辑</a>
            <a href="javascript:;" class="btn btn-primary btn-flat btn-xs" onclick="showPermissions(${item.id});"><i class="fa fa-edit"></i> 查看权限</a>
            <a href="javascript:;" class="btn btn-danger btn-flat btn-xs" onclick="removePermissionGroup(this, ${item.id});"><i class="fa fa-trash"></i> 删除</a>
          </td>
          <td>${item.name}</td>
          <td><fmt:formatDate value="${item.addTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
          <td><fmt:formatDate value="${item.modifyTime}" pattern="yyyy-MM-dd HH:mm:ss"/></td>
          <td>${item.addUserId}</td>
          <td>${item.status eq 1 ? '启用' : '禁用'}</td>
        </tr>
      </c:forEach>
      </tbody>
    </table>
  </div>
</c:if>