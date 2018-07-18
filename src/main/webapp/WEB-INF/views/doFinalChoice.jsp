<%--
  Created by IntelliJ IDEA.
  User: wdphu
  Date: 2017/7/23
  Time: 21:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" import="java.util.*" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>确认地点</title>
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
        <h3>做出投票决定</h3>
    </div>
</div>
<div class="bs-example">
<form action="/submitPartyPlaceId">
    <table class="table">
        <th width="50px"></th>
        <th width="100px">店铺名称</th>
        <th width="200px">店铺地点</th>
        <th width="200px">店铺描述</th>
        <th width="100px">得票数</th>
        <c:forEach items="${placeChooseVoList}" var="tempChooseVo">
            <tr class="success">
                <td width="50px"><input type="radio" name="placeId" value="${tempChooseVo.place.placeId}"/></td>
                <td width="100px">${tempChooseVo.place.placeName}</td>
                <td width="200px">${tempChooseVo.place.placeAddress}</td>
                <td width="200px">${tempChooseVo.place.placeDescription}</td>
                <td width="50px">${tempChooseVo.placeTime}/${allUser}</td>
            </tr>
        </c:forEach>
    </table>
    <button type="submit" class="button button-border button-rounded button-royal">选择</button>
    <input id="partyId"name="partyId" value="${partyId}" style="display: none;"></input>
</form>
</div>
</body>
</html>
