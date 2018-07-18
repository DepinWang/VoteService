<%--
  Created by IntelliJ IDEA.
  User: wdphu
  Date: 2017/7/19
  Time: 15:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>

<html>
<script type="text/javascript">
    function funCheckAll(obj){
        var items = document.getElementsByTagName("input");
        for(var i=0;i<items.length;i++){
            if(items[i].type=="checkbox"&& items[i].name=="test")
                items[i].checked = obj.checked;
        }
    }
    function funCheck(){
        var flg = true;
        var items = document.getElementsByTagName("input");
        for(var i=0;i<items.length;i++){
            if(items[i].type=="checkbox"&& items[i].name=="test"){
                if(!items[i].checked){
                    flg = false;
                    break;
                }
            }
        }
        document.getElementById("cbSelectAll").checked= flg;
    }
</script>

<head>
    <title>Title</title>
    <script type="application/javascript" src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
    <script type="application/javascript" href="<%=basePath%>/js/bootstrap.js"></script>
    <link  rel="stylesheet"  href="<%=basePath%>/css/bootstrap.min.css" />
    <link  rel="stylesheet"  href="<%=basePath%>/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/css/buttons.css">

    <link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
    <script src="//code.jquery.com/jquery-1.9.1.js"></script>
    <%--<script src="/static/js/jqueryui/resources/demos/external/jquery.mousewheel.js"></script>--%>
    <script src="//code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
    <link rel="stylesheet" href="https://jqueryui.com/resources/demos/style.css">

</head>
<body>
<form action="/hello">
<table border="1px" align="center">
    <thead>

    <th><input type="checkbox" id='checkAll' name = "checkAll" checked="checked" onclick="funCheckAll(this);"></th>
    <th>col1</th>
    <th>col2</th>
    <th>col3</th>
    </thead>
    <tbody>
    <tr>
        <td><input type="checkbox"  name="test" value="1"/></td>
        <td>col1</td>
        <td>col2</td>
        <td>col3</td>
        <%--onclick="funCheck();--%>
    </tr>
    <tr>
        <td><input type="checkbox" name="test" value="2"/></td>
        <td>col4</td>
        <td>col5</td>
        <td>col6</td>
    </tr>
    </tbody>
</table>


    <table>
        <tr>
            <td>
                <button name="submit" class="button button-border button-highlight" ref="/hello">提交申请</button>
            </td>
        </tr>
    </table>
</form>
</body>
</html>