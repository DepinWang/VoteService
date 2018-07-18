<%--
  Created by IntelliJ IDEA.
  User: wdphu
  Date: 2017/7/16
  Time: 15:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
    <title>我的聚会</title>

<%--
Created by IntelliJ IDEA.
User: wdphu
Date: 2017/7/19
Time: 15:44
To change this template use File | Settings | File Templates.
--%>


<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
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
                    <li class="active">
                        <a >我发起的聚会</a>
                    </li>
                    <li>
                        <a href="/referenceMe">@我的聚会</a>
                    </li>
                    <li >
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
        <h3>我发起的聚会</h3>

    </div>
</div>
<div class="bs-example">
    <button class="button button-royal button-border"><a href="editNewParty">新增聚会 </a></button>
</div>
    <div class="bs-example">
        <table align="center"><tr><td><h4>正在投票的聚会</h4></td></tr></table>
        <form>
            <table align="center" class="table">
                <thead>
                <tr>
                    <th>聚会id</th>
                    <th>聚会主题</th>
                    <th>发起时间</th>
                    <th>聚会时间</th>
                    <th>聚会详细描述</th>
                    <th>投票是否完成</th>
                    <th>当前投票结果</th>
                </tr>
                </thead>
                <c:forEach items="${listPartyLaunchVo}" var="partyLaunchVo">
                    <tr >
                        <td>${partyLaunchVo.party.partyId}</td>
                        <td>${partyLaunchVo.party.partyTheme}</td>
                        <td>${partyLaunchVo.party.partyCreateTime}</td>
                        <td>${partyLaunchVo.party.partyActivityTime}</td>
                        <td>${partyLaunchVo.party.partyDescription}</td>
                        <td>${partyLaunchVo.completed}</td>

                        <c:forEach items="${partyLaunchVo.resultPlace}" var="tempPlace">
                            <td>${tempPlace.placeName}</td>
                        </c:forEach>
                    </tr>
                </c:forEach>
            </table>
        </form>
        <table align="center"><tr><td>${noPartyLaunched}</td></tr></table>
    </div>
    <br/>
<br/>
<br/>
<div class="bs-example">
    <table align="center"><tr><td><h4>已经失效的聚会</h4></td></tr></table>
    <table class="table" align="center">
        <thead>
        <th>聚会主题</th>
        <th>发起时间</th>
        <th>聚会时间</th>
        <th>聚会详细描述</th>
        </thead>
        <tbody>
        <c:forEach items="${listPartyVoOutOfWork}" var="partyLaunchVo">
            <tr>
                <td>${partyLaunchVo.party.partyTheme}</td>
                <td>${partyLaunchVo.party.partyCreateTime}</td>
                <td>${partyLaunchVo.party.partyActivityTime}</td>
                <td>${partyLaunchVo.party.partyDescription}</td>
            </tr>
        </c:forEach>
        </tbody>
    </table>
<table align="center"><tr><td>${noPartyLaunchOutOfWork}</td></tr></table>
</div>
</body>
</html>
