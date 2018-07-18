<%--
  Created by IntelliJ IDEA.
  User: wdphu
  Date: 2017/7/16
  Time: 22:33
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
    <title>今日信息</title>

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
                    <li>
                        <a href="/referenceMe">@我的聚会</a>
                    </li>
                    <li class="active">
                        <a  class="active">我的信息</a>
                    </li>
                </ul>

            </nav>
        </div>
    </header>
</head>

<div class="bs-docs-header" id="content" tabindex="-1">
    <div class="container">
        <h3>今天要参加的聚会</h3>

    </div>
</div>

<col-3>
    <div class="bs-example" align="right">
        <form action="modifyUserInfo">
            <table width="300">
                <th width="300px"></th>
                <th width="100px"></th>
                <tr class="warning">
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon1" style="width:100px;">姓名</span>
                            <input id="name" type="text" class="form-control" placeholder="${user.name}" aria-describedby="basic-addon1" style="width: 200px">
                        </div>
                    </td>
                </tr>
                <tr>
                    <p/>
                </tr>
                <tr class="danger">
                    <td>
                        <div class="input-group">
                            <span class="input-group-addon" id="basic-addon2" style="width: 100px">昵称</span>
                            <input id="nickname" type="text" class="form-control" placeholder="${user.nickname}" aria-describedby="basic-addon1" style="width:200px;">
                        </div>
                    </td>
                </tr>
            </table>
        </form>
        <button name="submit" type="button" class="button-border button-royal" style="width: 72px">修改</button>
        <button type="button" class="button-border button-royal"><a href="addNewUser">新增用户</a></button>
    </div>
</col-3>

<col-9>
    <div class="bs-example">
    <form action="/doFinalChoice">
        <table align="center"><tr><td><h4>我发起的</h4></td></tr></table>
        <table class="table">
            <thead>
            <th width="100px">做选择</th>
            <th width="200px">聚会主题</th>
            <th width="400px">聚会描述</th>
            <th width="200px">聚会时间</th>
            <th width="50px">完成</th>
            <th>投票结果</th>
            </thead>
            <tbody>

            <c:forEach items="${todayLaunchedByMe}" var="tempLaunchVo">
                <tr>
                    <td><input type="radio" name="partyId" value="${tempLaunchVo.party.partyId}"></td>
                    <td>${tempLaunchVo.party.partyTheme}</td>
                    <td>${tempLaunchVo.party.partyDescription}</td>
                    <td>${tempLaunchVo.party.partyActivityTime}</td>
                    <td>${tempLaunchVo.completed}</td>
                    <td>
                        <c:forEach items="${tempLaunchVo.resultPlace}" var="tempPlace">
                            ${tempPlace.placeName}+" "
                        </c:forEach>
                    </td>
                </tr>
            </c:forEach>
            </tbody>
        </table>
        <table align="center"><tr><td>${noLaunchedByMe}</td></tr></table>
        <table align="right"><tr><td>
            <button type="submit" class="button button-border button-royal">确定</button>
        </td></tr></table>
    </form>
    </div>

    <div class="bs-example">
    <table align="center"><tr><td><h4>被邀请的</h4></td></tr></table>
    <table class="table" align="center">
        <thead>
        <th width="100px">邀请人</th>
        <th width="200px">聚会主题</th>
        <th width="400px">聚会描述</th>
        <th width="200px">聚会时间</th>
        <th width="50px">完成</th>
        <th>投票结果</th>
        </thead>
        <c:forEach items="${todayLaunchedByOther}" var="tempLaunchVo">
            <tr>
                <td>${tempLaunchVo.partyOwnerName}</td>
                <td>${tempLaunchVo.party.partyTheme}</td>
                <td>${tempLaunchVo.party.partyDescription}</td>
                <td>${tempLaunchVo.party.partyActivityTime}</td>
                <td>${tempLaunchVo.completed}</td>
                <td>
                    <c:forEach items="${tempLaunchVo.resultPlace}" var="tempPlace">
                        ${tempPlace.placeName}+
                    </c:forEach>
                </td>
            </tr>
        </c:forEach>
    </table>
    <table align="center"><tr><td>${noLaunchedByOther}</td></tr></table>
    </div>
</col-9>


</body>
</html>
