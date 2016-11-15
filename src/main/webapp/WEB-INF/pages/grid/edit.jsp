<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<!-- jQuery -->
<script type="text/javascript"
	src="resources/jquery/jquery-2.2.3.min.js"></script>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<div>
<form id="userForm" name="userForm" class="form-horizontal" role="form" method="post">

        <div class="form-group"><label class="col-sm-2 control-label">描述</label>
            <div class="col-sm-10">
            <input type="text" class="form-control" name="description" value="${user.userName}" placeholder="请输入名字" data-rule="名字:required;description">
            </div>
        </div>
</form>
<div class="center">
	<button id="btnAdd" type="button" onclick="javascript:$('#userForm').submit();" class="btn btn-success btn-sm">
		<i class="fa fa-user-plus"></i>&nbsp;
		<c:if test="${empty user}">
		添加
		</c:if>
		<c:if test="${!empty user}">
		保存
		</c:if>
	</button>
<button id="btn" type="button"
		onclick="window.open('<%=basePath%>/gridList.htm');"
		class="btn btn-info btn-sm">
		<i class="fa fa-undo"></i>&nbsp;返回
	</button>
	</div>