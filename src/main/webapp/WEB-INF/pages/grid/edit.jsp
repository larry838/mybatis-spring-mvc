<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
  String path = request.getContextPath();
  String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<html>
<head>
    <title>编辑</title>
    <%@include file="../common/include.jsp" %>
</head>
<body>
<!-- jQuery -->
<script type="text/javascript"
	src="resources/jquery/jquery-2.2.3.min.js"></script>
<c:set var="ctx" value="${pageContext.request.contextPath }" />
<div>
<form id="userForm" name="userForm" class="form-horizontal" method="post">
     <input id="userId" name="userId" value="${user.userId}" hidden>

        <div class="form-group"><label class="col-sm-2 control-label">描述</label>
            <div class="col-sm-2">
            <input type="text" class="form-control" name="userName" value="${user.userName}" placeholder="请输入名字" data-rule="名字:required;description">
            </div>
        </div>
</form>
<div class="center">
	<button id="btnAdd" type="button" onclick="save()" class="btn btn-success btn-sm">
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
<script>
    function save() {
        $.ajax({
            type: 'POST',
            url: '<%=basePath%>/edit.html',
            data: $('#userForm').serialize(),
            dataType: 'json',
            success: function (data) {
                alert(data.msg);
                if (data.success) {
                    setTimeout('toIndex()', 100);
                }
            },
            error: function () {
                alert("出错了,请重试!");
            }
        });
    }
    
    function toIndex() {
        window.location.href = '<%=basePath%>/gridList.htm';
    }
</script>
</script>
</body>
</html>