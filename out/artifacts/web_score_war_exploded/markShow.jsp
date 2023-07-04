<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String PATH = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%-- <%=PATH%>  --%>
<html>
<head>
    <title>吕新超-学生成绩管理系统</title>
    <!-- 添加logo -->
    <link rel="shortcut icon" href="image/1.ico" type="image/x-icon">
    <meta http-equiv="content-type" content="text/html;charset=utf-8"/>
    <script src="<%=PATH%>/js/jquery-3.5.1.min.js"></script>
    <style type="text/css">
        .mytable{
            border:1px solid #A6C1E4;
            font-family:Arial;
            border-collapse: collapse;
        }
        body{ background:url("image/4.png");
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

<div style="margin-top: 30px;display:inline-block;">
    <form method="get" action="<%=PATH%>/markShow" style="float: left;">
        <label style="font-size: 17px">请输入课程号：</label>
        <input type="text" name="cIdKey" style="height: 25px">
        <button type="submit" style="height: 30px;width: 90px">查询</button>
    </form>
    <div style="float: left;margin-left: 120px;">
        <button onclick="toMarkAdd()" style="color: blue;height: 30px;width: 90px">添加成绩</button>
    </div>
    <div style="float: left;margin-left: 20px;">
        <button onclick="toShow()" style="color: red;height: 30px;width: 90px">返回</button>
    </div>
</div>

<div style="text-align: center;margin-top: 20px">
    <table style="margin: auto">
        <tr class="mytable">
            <th style="width: 200px;">序号</th>
            <th style="width: 200px;">课程号</th>
            <th style="width: 200px;">课程名称</th>
            <th style="width: 200px;">学生</th>
            <th style="width: 200px;">成绩</th>
            <th style="width: 150px;">操作</th>
        </tr>

        <c:forEach items="${requestScope.grades}" var="item">
            <tr class="double">
                <td>${item.id}</td>
                <td>${item.course.cId}</td>
                <td>${item.course.cName}</td>
                <td>${item.student.sName}</td>
                <td>${item.mark}</td>
                <td>
                    <button onclick="toMarkUpdate(${item.id})">修改</button>
                    <button onclick="markDelete(${item.id})" style="color: red;">删除</button>
                </td>
            </tr>
        </c:forEach>
    </table>
</div>
<script>
<%--    去修改成绩页面--%>
    function toMarkUpdate(pid){
        document.location.href = "<%=PATH%>/markUpdate?pid="+pid;
    }
<%--    删除成绩--%>
    function markDelete(gId){
        var b = window.confirm("你确定要删除该门课的成绩吗?");
        if (b == true){
            $.ajax({
                url:"<%=PATH%>/markDelete",
                type:"post",
                dataType:"json",
                data:{
                    gId:gId
                },
                success:function (data){
                    if (data.flag){
                        alert("删除成功！");
                        document.location.href = "<%=PATH%>/markShow";
                    }else {
                        alert("删除失败！");
                    }
                }
            })
        }
    }
<%--    去主页面--%>
    function toShow(){
        document.location.href = "<%=PATH%>/show.jsp";
    }
<%--    去添加成绩页面--%>
    function toMarkAdd(){
        document.location.href = "<%=PATH%>/markAdd";
    }
</script>
</body>
</html>

