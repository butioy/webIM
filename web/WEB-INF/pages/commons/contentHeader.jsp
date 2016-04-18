<%--
  Created by IntelliJ IDEA.
  User: butioy
  Date: 2015/9/6
  Time: 21:04
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="taglibs.jsp" %>
<!-- Content Header (Page header) -->
<section class="content-header">
    <h1>
        ${CURRENT_DEPARTMENT.name} Dashboard
        <small>Version 2.0</small>
    </h1>
    <ol class="breadcrumb">
        <c:choose>
            <c:when test="${not empty CURRENT_DEPARTMENT}">
                <li class="${empty CURRENT_MENU ? 'active' : ''}">
                    <a href="${ctx}/admin/auth/department/${CURRENT_DEPARTMENT.id}/index">
                        <c:if test="${not empty CURRENT_MENU }"><i class="fa fa-dashboard"></i></c:if> ${CURRENT_DEPARTMENT.name}
                    </a>
                </li>
                <c:if test="${not empty CURRENT_MENU}">
                    <li class="${empty CURRENT_PERM ? 'active' : ''}"><c:if test="${not empty CURRENT_PERM }"><i class="fa fa-dashboard"></i></c:if>${CURRENT_MENU.name}</li>
                </c:if>
                <c:if test="${not empty CURRENT_PERM}">
                    <li class="active">${CURRENT_PERM.name}</li>
                </c:if>
            </c:when>
            <c:otherwise><li class="active"><a href="${ctx}/admin/index"><i class="fa fa-dashboard"></i> Home</a></li></c:otherwise>
        </c:choose>
    </ol>
</section>
