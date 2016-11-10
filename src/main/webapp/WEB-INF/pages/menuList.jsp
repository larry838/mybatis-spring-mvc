<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html lang="en">
<head>
<base href="<%=basePath%>">
</head>
<body>

	<table id="table_report">
		<thead>
			<tr>
				<th>序号</th>
				<th>编号</th>
				<th>资源名称</th>
				<th>上级名称</th>
				<th>资源标识</th>
				<th>资源类型</th>
				<th>图标</th>
				<th>资源url</th>
				<th>创建时间</th>
				<th>更新时间</th>			
			</tr>
		</thead>

		<tbody>
			<!-- 开始循环 -->
			<c:choose>
				<c:when test="${not empty menulist}">

						<c:forEach items="${menulist}" var="menu" varStatus="vs">

							<tr>
								<td class='center' style="width: 30px;">${vs.index+1}</td>
								<td>${menu.id}</td>
								<td>${menu.parentId }</td>
								<td>${menu.name }</td>
								<td>${menu.sourceKey }</td>
								<td>${menu.type }</td>
								<td>${menu.sourceUrl }</td>
								<td>${menu.level }</td>
								<td>${menu.icon }</td>
								<td>${menu.isHide }</td>
								<td>${menu.description }</td>
								<td>${menu.createTime }</td>
								<td>${menu.updateTime }</td>	
							</tr>

						</c:forEach>
				</c:when>
				<c:otherwise>
					<tr class="main_info">
						<td colspan="10" class="center">没有相关数据</td>
					</tr>
				</c:otherwise>
			</c:choose>
		</tbody>
	</table>
</body>
</html>