<%--
  Created by IntelliJ IDEA.
  User: wdphu
  Date: 2017/7/20
  Time: 15:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<html>
<head>
    <title>选择聚会地点</title>
    <script type="application/javascript" src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
    <script type="application/javascript" href="<%=basePath%>/js/bootstrap.js"></script>
    <link  rel="stylesheet"  href="<%=basePath%>/css/bootstrap.min.css" />
    <link  rel="stylesheet"  href="<%=basePath%>/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/css/buttons.css">
    <link rel="stylesheet" href="<%=basePath%>/css/doc.css">
</head>
<body>
<div class="bs-docs-header" id="content" tabindex="-1">
    <div class="container">
        <h3>店铺信息列表</h3>
    </div>
</div>
<div class="bs-example">
    <form name="form1" action="/doPlaceChoice" method="get">
        <table class="table">
            <th>我的选择</th>
            <th>店铺名称</th>
            <th>店铺地点</th>
            <th>店铺描述</th>
            <c:forEach items="${placeList}" var="tempPlace">
                <tr>
                    <td><input type="radio" name="placeId" value="${tempPlace.placeId}"></td>
                    <td>${tempPlace.placeName}</td>
                    <td>${tempPlace.placeAddress}</td>
                    <td>${tempPlace.placeDescription}</td>
                </tr>
            </c:forEach>
            <input type="hidden" name="placeId"/>
        </table>
        <button type="submit" class="button button-border button-rounded button-royal">选择</button>
        <input id="partyId"name="partyId" value="${partyId}" style="display: none;"></input>
    </form>
</div>
</body>
</html>