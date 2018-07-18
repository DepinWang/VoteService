<%--
  Created by IntelliJ IDEA.
  User: wdphu
  Date: 2017/7/18
  Time: 12:44
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
    <title>编辑聚会信息</title>
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
        <h3>申请聚会投票</h3>
    </div>
</div>
<div class="bs-example">
    <form name="form1" action="/submitNewParty" method="post" >
        <table>
            <tr><td><h3>主题:</h3></td></tr>
            <tr>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon1">聚会主题：</span>
                        <input name="partyTheme" type="text" class="form-control" placeholder="聚会主题" aria-describedby="basic-addon1">
                    </div>
                </td>
            </tr>
            <tr>
                <td><h3>聚会时间：</h3></td>
            </tr>
            <tr>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon3">年：</span>
                        <input name="partyTimeYear" type="text" class="form-control" placeholder="年份" aria-describedby="basic-addon1"value="">
                    </div>
                </td>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon4">月：</span>
                        <input name="partyTimeMonth" type="text" class="form-control" placeholder="月份" aria-describedby="basic-addon1"value="">
                    </div>
                </td>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon5">日：</span>
                        <input name="partyTimeDay" type="text" class="form-control" placeholder="第几天" aria-describedby="basic-addon1"value="">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon6">时：</span>
                        <input name="partyTimeHour" type="text" class="form-control" placeholder="时" aria-describedby="basic-addon1"value="">
                    </div>
                </td>
                <td>
                    <div class="input-group">
                        <span class="input-group-addon" id="basic-addon7">分：</span>
                        <input name="partyTimeMinute" type="text" class="form-control" placeholder="分" aria-describedby="basic-addon1" value="">
                    </div>
                </td>
            </tr>
        </table>
        <div class="input-group">
            <span class="input-group-addon" id="basic-addon2">聚会描述：</span>
            <input name="partyDescription" type="text" class="form-control" placeholder="聚会描述" aria-describedby="basic-addon1" value="">
        </div>
    <div>
        <h3>请选择可供聚会的店铺（可多个）：</h3>
        <table border="1px" align="center" class="table">
            <th>店铺名称</th>
            <th>店铺地址</th>
            <th>店铺描述</th>
            <th>选择店铺</th>
            <c:forEach items="${placeList}" var="tempPlace">
                <tr>
                    <td>${tempPlace.placeName}</td>
                    <td>${tempPlace.placeAddress}</td>
                    <td>${tempPlace.placeDescription}</td>
                    <td><input type="checkbox" name="placeList" value="${tempPlace.placeId}"></td>
                </tr>
            </c:forEach>
            <input type="hidden" name="placeList"/>
        </table>
    </div>
        <div>
        <table>
            <tr>
                <td><h3>请选择参加聚会的人员：</h3></td>
                <td><input type="checkbox" name="checkAll" onclick="funCheckAll(this)">全选</td>
            </tr>
        </table>

        <table align="center" border="1px" class="table">
            <th>好友id</th>
            <th>好友名字</th>
            <th>好友昵称</th>
            <th>邀请好友</th>
            <c:forEach items="${userList}" var="tempUser">
                <tr>
                    <td>${tempUser.id}</td>
                    <td>${tempUser.name}</td>
                    <td>${tempUser.nickname}</td>
                    <td><input type="checkbox" name="userList" value="${tempUser.id}"></td>
                </tr>
            </c:forEach>
            <input type="hidden" name="userList"/>
        </table>
        </div>
        <table>
            <tr>
                <td></td>
            </tr>
        </table>
        <table align="center">
            <tr>
                <td>
                    <button name="submit" class="button button-border button-royal">提交申请</button>
                </td>
            </tr>
        </table>
    </form>
</div>

</body>
</html>

<script type="text/javascript">
    function funCheckAll(obj){
        var items = document.getElementsByTagName("input");
        for(var i=0;i<items.length;i++){
            if(items[i].type=="checkbox"&& items[i].name=="userList")
                items[i].checked = obj.checked;
        }
    }
</script>