<%--
  Created by IntelliJ IDEA.
  User: alvin
  Date: 15/9/7
  Time: 下午10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String path = request.getContextPath();
    String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>
<html>
<head>
    <title>login</title>
    <script type="application/javascript" src="<%=basePath%>/js/jquery-3.2.1.min.js"></script>
    <script type="application/javascript" href="<%=basePath%>/js/bootstrap.js"></script>
    <link  rel="stylesheet"  href="<%=basePath%>/css/bootstrap.min.css" />
    <link  rel="stylesheet"  href="<%=basePath%>/css/bootstrap-theme.min.css" />
    <link rel="stylesheet" href="<%=basePath%>/css/buttons.css">
</head>
<body>
<style type="text/css">
    /*
    CSS RESET
    http://meyerweb.com/eric/tools/css/reset/
    v2.0 | 20110126
    License:  none (public domain)
     */
    html,body,div,span,applet,object,iframe,h1,h2,h3,h4,h5,h6,p,blockquote,pre,a,abbr,acronym,address,big,cite,code,del,dfn,em,img,ins,kbd,q,s,samp,small,strike,strong,sub,sup,tt,var,b,u,i,center,dl,dt,dd,ol,ul,li,fieldset,form,label,legend,table,caption,tbody,tfoot,thead,tr,th,td,article,aside,canvas,details,embed,figure,figcaption,footer,header,hgroup,menu,nav,output,ruby,section,summary,time,mark,audio,video {
        margin: 0;
        padding: 0;
        border: 0;
        font-size: 100%;
        font: inherit;
        vertical-align: baseline;
    }

    /* HTML5 display-role reset for older browsers */
    article,aside,details,figcaption,figure,footer,header,hgroup,menu,nav,section {
        display: block;
    }

    body {
        line-height: 1;
    }

    ol,ul {
        list-style: none;
    }

    blockquote,q {
        quotes: none;
    }

    blockquote:before,blockquote:after,q:before,q:after {
        content: '';
        content: none;
    }

    table {
        border-collapse: collapse;
        border-spacing: 0;
    }

    /* CSS Animations */
    @keyframes "login" {
        0% {
            -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
            filter: alpha(opacity=0);
            opacity: 0;
            margin-top: -50px;
        }
        100% {
            -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=100)";
            filter: alpha(opacity=100);
            opacity: 1;
            margin-top: -75px;
        }

    }

    @-moz-keyframes login {
        0% {
            filter: alpha(opacity=0);
            opacity: 0;
            margin-top: -50px;
        }
        100% {
            filter: alpha(opacity=100);
            opacity: 1;
            margin-top: -75px;
        }

    }

    @-webkit-keyframes "login" {
        0% {
            filter: alpha(opacity=0);
            opacity: 0;
            margin-top: -50px;
        }
        100% {
            filter: alpha(opacity=100);
            opacity: 1;
            margin-top: -75px;
        }

    }

    @-ms-keyframes "login" {
        0% {
            -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=0)";
            filter: alpha(opacity=0);
            opacity: 0;
            margin-top: -50px;
        }
        100% {
            -ms-filter: "progid:DXImageTransform.Microsoft.Alpha(Opacity=100)";
            filter: alpha(opacity=100);
            opacity: 1;
            margin-top: -75px;
        }

    }

    @-o-keyframes "login" {
        0% {
            filter: alpha(opacity=0);
            opacity: 0;
            margin-top: -50px;
        }
        100% {
            filter: alpha(opacity=100);
            opacity: 1;
            margin-top: -75px;
        }

    }

    /* Main CSS */
    * { -moz-box-sizing: border-box; -webkit-box-sizing: border-box; box-sizing: border-box; }

    body {
        font-family: sans-serif;

        background-color: #323B55;
        background-image: -webkit-linear-gradient(bottom, #323B55 0%, #424F71 100%);
        background-image: -moz-linear-gradient(bottom, #323B55 0%, #424F71 100%);
        background-image: -o-linear-gradient(bottom, #323B55 0%, #424F71 100%);
        background-image: -ms-linear-gradient(bottom, #323B55 0%, #424F71 100%);
        background-image: linear-gradient(bottom, #323B55 0%, #424F71 100%);
    }

    #slick-login {
        width: 220px;
        height: 155px;
        position: absolute;
        left: 50%;
        top: 50%;
        margin-left: -110px;
        margin-top: -75px;

        -webkit-animation: login 1s ease-in-out;
        -moz-animation: login 1s ease-in-out;
        -ms-animation: login 1s ease-in-out;
        -o-animation: login 1s ease-in-out;
        animation: login 1s ease-in-out;
    }

    #slick-login label {
        display: none;
    }

    .placeholder {
        color: #444;
    }

    #slick-login input[type="text"],#slick-login input[type="password"] {
        width: 100%;
        height: 40px;
        positon: relative;
        margin-top: 7px;
        font-size: 14px;
        color: #444;
        outline: none;
        border: 1px solid rgba(0, 0, 0, .49);

        padding-left: 20px;

        -webkit-background-clip: padding-box;
        -moz-background-clip: padding-box;
        background-clip: padding-box;
        border-radius: 6px;

        background-image: -webkit-linear-gradient(bottom, #FFFFFF 0%, #F2F2F2 100%);
        background-image: -moz-linear-gradient(bottom, #FFFFFF 0%, #F2F2F2 100%);
        background-image: -o-linear-gradient(bottom, #FFFFFF 0%, #F2F2F2 100%);
        background-image: -ms-linear-gradient(bottom, #FFFFFF 0%, #F2F2F2 100%);
        background-image: linear-gradient(bottom, #FFFFFF 0%, #F2F2F2 100%);

        -webkit-box-shadow: inset 0px 2px 0px #d9d9d9;
        box-shadow: inset 0px 2px 0px #d9d9d9;

        -webkit-transition: all .1s ease-in-out;
        -moz-transition: all .1s ease-in-out;
        -o-transition: all .1s ease-in-out;
        -ms-transition: all .1s ease-in-out;
        transition: all .1s ease-in-out;
    }

    #slick-login input[type="text"]:focus,#slick-login input[type="password"]:focus {
        -webkit-box-shadow: inset 0px 2px 0px #a7a7a7;
        box-shadow: inset 0px 2px 0px #a7a7a7;
    }

    #slick-login input:first-child {
        margin-top: 0px;
    }

    #slick-login input[type="submit"] {
        width: 100%;
        height: 50px;
        margin-top: 7px;
        color: #fff;
        font-size: 18px;
        font-weight: bold;
        text-shadow: 0px -1px 0px #5b6ddc;
        outline: none;
        border: 1px solid rgba(0, 0, 0, .49);

        -webkit-background-clip: padding-box;
        -moz-background-clip: padding-box;
        background-clip: padding-box;
        border-radius: 6px;

        background-color: #5466da;
        background-image: -webkit-linear-gradient(bottom, #5466da 0%, #768ee4 100%);
        background-image: -moz-linear-gradient(bottom, #5466da 0%, #768ee4 100%);
        background-image: -o-linear-gradient(bottom, #5466da 0%, #768ee4 100%);
        background-image: -ms-linear-gradient(bottom, #5466da 0%, #768ee4 100%);
        background-image: linear-gradient(bottom, #5466da 0%, #768ee4 100%);

        -webkit-box-shadow: inset 0px 1px 0px #9ab1ec;
        box-shadow: inset 0px 1px 0px #9ab1ec;

        cursor: pointer;

        -webkit-transition: all .1s ease-in-out;
        -moz-transition: all .1s ease-in-out;
        -o-transition: all .1s ease-in-out;
        -ms-transition: all .1s ease-in-out;
        transition: all .1s ease-in-out;
    }

    #slick-login input[type="submit"]:hover {
        background-color: #5f73e9;
        background-image: -webkit-linear-gradient(bottom, #5f73e9 0%, #859bef 100%);
        background-image: -moz-linear-gradient(bottom, #5f73e9 0%, #859bef 100%);
        background-image: -o-linear-gradient(bottom, #5f73e9 0%, #859bef 100%);
        background-image: -ms-linear-gradient(bottom, #5f73e9 0%, #859bef 100%);
        background-image: linear-gradient(bottom, #5f73e9 0%, #859bef 100%);

        -webkit-box-shadow: inset 0px 1px 0px #aab9f4;
        box-shadow: inset 0px 1px 0px #aab9f4;
        margin-top: 10px;
    }

    #slick-login input[type="submit"]:active {
        background-color: #7588e1;
        background-image: -webkit-linear-gradient(bottom, #7588e1 0%, #7184df 100%);
        background-image: -moz-linear-gradient(bottom, #7588e1 0%, #7184df 100%);
        background-image: -o-linear-gradient(bottom, #7588e1 0%, #7184df 100%);
        background-image: -ms-linear-gradient(bottom, #7588e1 0%, #7184df 100%);
        background-image: linear-gradient(bottom, #7588e1 0%, #7184df 100%);

        -webkit-box-shadow: inset 0px 1px 0px #93a9e9;
        box-shadow: inset 0px 1px 0px #93a9e9;
    }
</style>
<form id="slick-login" action="/login">
    <label for="id">username</label><input name="id" class="placeholder" placeholder="用户名" type="text">
    <label for="password">password</label><input name="password" class="placeholder" placeholder="密码" type="password">
    <input value="Log In" type="submit">
</form>

</body>
</html>