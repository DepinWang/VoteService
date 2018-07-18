<%--
  Created by IntelliJ IDEA.
  User: wdphu
  Date: 2017/7/16
  Time: 22:30
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>我被邀请</title>

    <%--
    Created by IntelliJ IDEA.
    User: wdphu
    Date: 2017/7/19
    Time: 15:44
    To change this template use File | Settings | File Templates.
    --%>

    <title>PartyILaunched</title>
    <script type="application/javascript" src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
    <script type="application/javascript" href="<%=basePath%>/js/bootstrap.js"></script>
    <link  rel="stylesheet"  href="<%=basePath%>/css/bootstrap.min.css" />
    <link  rel="stylesheet"  href="<%=basePath%>/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/css/buttons.css">
    <link rel="stylesheet" href="<%=basePath%>/css/doc.css">
    <header class="navbar navbar-static-top bs-docs-nav" id="top">
        <div class="container">
            <nav id="bs-navbar" class="collapse navbar-collapse">
                <ul class="nav navbar-nav">
                    <li>
                        <a href="/myLauch">我发起的聚会</a>
                    </li>
                    <li  class="active">
                        <a >@我的聚会</a>
                    </li>
                    <li>
                        <a href="/aboutMe">我的信息</a>
                    </li>
                </ul>

            </nav>
        </div>
    </header>
</head>


<body>
<div class="bs-docs-header" id="content" tabindex="-1">
    <div class="container">
        <h3>好友的邀请</h3>

    </div>
</div>

<div class="bs-example">
    <table align="center"><tr><td><h4>未处理的邀请</h4></td></tr></table>
    <table class="table">
        <thead>
        <th width="100px">邀请人</th>
        <th width="200px">聚会主题</th>
        <th width="200px">聚会创建时间</th>
        <th width="200px">聚会时间</th>
        <th width="200px">聚会描述</th>
        <th width="100px"></th>
        </thead>
        <c:forEach items="${partyLaunchVoListUndo}" var="partyLaunchVo">
            <tr>
                <td>${partyLaunchVo.partyOwnerName}</td>
                <td>${partyLaunchVo.party.partyTheme}</td>
                <td>${partyLaunchVo.party.partyCreateTime}</td>
                <td>${partyLaunchVo.party.partyActivityTime}</td>
                <td>${partyLaunchVo.party.partyDescription}</td>
                <td><a href="/place/${partyLaunchVo.party.partyId}">去投票</a></td>
            </tr>
        </c:forEach>
    </table>
</div>
<div class="bs-example">
<table align="center"><tr><td>${undoList}</td></tr></table>
</div>


<div class="bs-example">
    <table align="center"><tr><td><h4>已处理的邀请</h4></td></tr></table>
    <table class="table">
        <thead>
        <th>聚会邀请人</th>
        <th>聚会主题</th>
        <th>聚会创建时间</th>
        <th>聚会时间</th>
        <th>聚会描述</th>
        <th>聚会店铺名称</th>
        <th>聚会店铺地点</th>
        <th>聚会店铺描述</th>
        </thead>
        <tbody>
        <c:forEach items="${partyLaunchVoListDone}" var="partyLaunchVo">
        <tr>
            <td>${partyLaunchVo.partyOwnerName}</td>
            <td>${partyLaunchVo.party.partyTheme}</td>
            <td>${partyLaunchVo.party.partyCreateTime}</td>
            <td>${partyLaunchVo.party.partyActivityTime}</td>
            <td>${partyLaunchVo.party.partyDescription}</td>
            <c:forEach items="${partyLaunchVo.resultPlace}" var="tempPlace">
                <td>${tempPlace.placeName}</td>
                <td>${tempPlace.placeAddress}</td>
                <td>${tempPlace.placeDescription}</td>
            </c:forEach>
        </tr>
        </c:forEach>
        </tbody>
    </table>
</div>

<table align="center"><tr><td>${doneList}</td></tr></table>

<div class="bs-example">
    <table align="center"><tr><td><h4>已经过期失效的邀请</h4></td></tr></table>
    <table class="table">
        <thead>
        <th width="100px">邀请人</th>
        <th width="200px">聚会主题</th>
        <th width="200px">聚会创建时间</th>
        <th width="200px">聚会时间</th>
        <th width="200px">聚会描述</th>
        </thead>
        <tbody>
        <c:forEach items="${partyLaunchVoListOutOfWork}" var="partyLaunchVo">
            <tr>
                <td>${partyLaunchVo.partyOwnerName}</td>
                <td>${partyLaunchVo.party.partyTheme}</td>
                <td>${partyLaunchVo.party.partyCreateTime}</td>
                <td>${partyLaunchVo.party.partyActivityTime}</td>
                <td>${partyLaunchVo.party.partyDescription}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
</div>
<table align="center"><tr><td>${outOfWorkList}</td></tr></table>
</body>
</html>
