<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String PATH = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
<head>
    <meta charset="utf-8">
    <title>吕新超-学生成绩管理系统</title>
    <!-- 添加logo -->
    <link rel="shortcut icon" href="image/1.ico" type="image/x-icon">
    <script type="text/javascript" src="<%=PATH%>/js/jquery-3.5.1.min.js"></script>
    <style>body{ background:url("image/2.jpg");
        background-size: cover;}
    </style>
</head>
<body style="text-align: center;">
<div style="margin-top: 30px;">
    <h1>学生成绩管理系统</h1>
</div>

<div style="margin-top: 90px;">
    <h2>欢迎 <strong style="color: red;">${sessionScope.student.sName}</strong> 同学</h2>
</div>

<div style="margin-top: 30px;">
    <button onclick="toUserInfo()" style="height: 40px;width: 150px;margin-left: 20px;font-size: 18px;">个人信息</button>
</div>

<div style="margin-top: 30px;">
    <button onclick="toUserCourse()" style="height: 40px;width: 150px;margin-left: 20px;font-size: 18px;">查看成绩</button>
</div>

<div style="margin-top: 90px;">
    <button onclick="toLogin()" style="height: 40px;width: 150px;margin-left: 20px;color: blue;">返回</button>
</div>
<script>
<%--    去成绩模块--%>
    function toUserCourse(){
        document.location.href="<%=PATH%>/userCourse";
    }
<%--    去个信息--%>
    function toUserInfo(){
        document.location.href="<%=PATH%>/userSelect";
    }
<%--    退出登录--%>
    function toLogin(){
        $.ajax({
            url:"<%=PATH%>/logout",
            type:"post",
            dataType:"json",
            success:function (data){
                if (data.flag){
                    alert("退出成功");
                    document.location.href="<%=PATH%>/index.jsp";
                }else {
                    alert("退出失败");
                }
            }
        })
    }
</script>
</body>
</html>

