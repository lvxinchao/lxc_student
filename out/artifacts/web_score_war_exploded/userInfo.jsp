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

<div style="margin-top: 120px;">
    <h2>个人信息</h2>
</div>

<div style="margin-top: 30px;">
    <label style="font-size: 20px;">学号：</label>
    <label style="font-size: 20px;">${sessionScope.student.id}</label>
</div>
<div style="margin-top: 30px;">
    <label style="font-size: 20px;">姓名：</label>
    <label style="font-size: 20px;">${sessionScope.student.sName}</label>
</div>
<div style="margin-top: 30px;">
    <label style="font-size: 20px;">性别：</label>
    <label style="font-size: 20px;">${sessionScope.student.sex}</label>
</div>
<div style="margin-top: 30px;">
    <label style="font-size: 20px;">专业：</label>
    <label style="font-size: 20px;">${sessionScope.student.major}</label>
</div>
<div style="margin-top: 30px;">
    <label style="font-size: 20px;">学院：</label>
    <label style="font-size: 20px;">${sessionScope.student.collage}</label>
</div>
<div style="margin-top: 30px;">
    <button onclick="toLogin()" style="height: 40px;width: 150px;margin-left: 20px;color: blue;">返回</button>
</div>
<script>
    function toLogin(){
        document.location.href="<%=PATH%>/user.jsp";
    }
</script>
</body>
</html>

