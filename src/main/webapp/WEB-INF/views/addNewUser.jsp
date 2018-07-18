<%--
  Created by IntelliJ IDEA.
  User: wdphu
  Date: 2017/7/24
  Time: 9:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<html>
<head>
    <title>新增用户</title>
    <script type="application/javascript" src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
    <script type="application/javascript" href="<%=basePath%>/js/bootstrap.js"></script>
    <link  rel="stylesheet"  href="<%=basePath%>/css/bootstrap.min.css" />
    <link  rel="stylesheet"  href="<%=basePath%>/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/css/buttons.css">
    <link rel="stylesheet" href="<%=basePath%>/css/doc.css">
    <%--<link rel="stylesheet" href="http://localhost:8080/resource/bootstrap-3.3.7-dist/css/buttons.css"/>--%>

</head>
<body>
<div class="bs-docs-header" id="content" tabindex="-1">
    <div class="container">
        <h3>新增用户</h3>
    </div>
</div>
<div class="bs-example">
<form a name="form" action="/submitNewUser" method="post">
    <table width="400px">
        <th width="300px"></th>
        <th width="100px"></th>
        <tr>
            <td>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon1">姓名</span>
                    <input id="name" name="name" type="text" class="form-control" placeholder="姓名" aria-describedby="basic-addon1">
                </div>
            </td>
        </tr>
        <tr>
            <p/>
        </tr>
        <tr>
            <td>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon2">昵称</span>
                    <input id="nickname" name="nickname" type="text" class="form-control" placeholder="昵称" aria-describedby="basic-addon1">
                </div>
            </td>
        </tr>
        <tr>
            <td>
                <div class="input-group">
                    <span class="input-group-addon" id="basic-addon3">密码</span>
                    <input id="password" name="password" type="password" class="form-control" placeholder="密码" aria-describedby="basic-addon1">
                </div>
            </td>
        </tr>
    </table>
    <table width="300px">
        <tr>
            <td align="right"><button name="submit" type="submit" class="button-border button-royal">新增用户</button></td>
        </tr>
    </table>
</form>
</div>
</body>
</html>
