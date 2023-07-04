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
    <style type="text/css">
        .mytable{
            border:1px solid #A6C1E4;
            font-family:Arial;
            border-collapse: collapse;
        }
        body{ background:url("image/2.jpg");
             background-size: cover;}

        table th{
            border:1px solid black;
            background-color:#71c1fb;
            width:100px;
            height:20px;
            font-size:15px;
        }

        table td{
            border:1px solid #A6C1E4;
            text-align:center;
            height:40px;
            padding-top:5px;
            font-size:15px;
        }

        .double{
            background-color:#c7dff6;
        }
    </style>
</head>
<body style="text-align: center;">
<div style="margin-top: 90px;">
    <h1>学生成绩管理系统</h1>
</div>

<div style="margin-top: 20px;">
    <h4>欢迎 <strong>${sessionScope.student.sName}</strong> 使用系统</h4>
</div>

<div style="margin-top: 60px;">
    <button onclick="toStudentManager()" style="height: 40px;width: 150px;margin-left: 20px;font-size: 18px;">学生信息管理</button>
</div>

<div style="margin-top: 30px;">
    <button onclick="toCourseManager()" style="height: 40px;width: 150px;margin-left: 20px;font-size: 18px;">课程信息管理</button>
</div>

<div style="margin-top: 30px;">
    <button onclick="toGradeManager()" style="height: 40px;width: 150px;margin-left: 20px;font-size: 18px;">成绩管理</button>
</div>

<div style="margin-top: 90px;">
    <button onclick="logout()" style="height: 40px;width: 150px;margin-left: 20px;color: red;">退出系统</button>
</div>
<script>
<%--   去成绩管理界面--%>
    function toGradeManager(){
        document.location.href="<%=PATH%>/markShow"
    }
<%--    去课程管理界面--%>
    function toCourseManager(){
        document.location.href="<%=PATH%>/courseShow"
    }
<%--    去学生管理界面--%>
    function toStudentManager(){
        document.location.href="<%=PATH%>/studentShow"
    }
<%--    退出登录--%>
    function logout(){
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
