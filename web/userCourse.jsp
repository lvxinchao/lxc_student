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
<div style="margin-top: 30px;">
    <h1>学生成绩管理系统</h1>
</div>

<div style="margin-top: 120px;">
    <h2>各科成绩信息</h2>
</div>

<div style="text-align: center;margin-top: 20px">
    <table style="margin: auto">
        <tr class="mytable">
            <th style="width: 200px;">科目编号</th>
            <th style="width: 200px;">科目名称</th>
            <th style="width: 200px;">分数</th>
        </tr>

        <c:forEach items="${requestScope.list}" var="item">
            <tr class="double">
                <td>${item.course.cId}</td>
                <td>${item.course.cName}</td>
                <td>${item.mark}</td>
            </tr>
        </c:forEach>

    </table>
</div>

<div style="margin-top: 30px;">
    <button onclick="toUser()" style="height: 40px;width: 150px;margin-left: 20px;color: blue;">返回</button>
</div>
<script>
    function toUser(){
        document.location.href="<%=PATH%>/user.jsp"
    }
</script>
</body>
</html>
