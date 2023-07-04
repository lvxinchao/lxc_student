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
        body{ background:url("image/2.jpg");
            background-size: cover;}
        .mytable{
            border:1px solid #A6C1E4;
            font-family:Arial;
            border-collapse: collapse;
        }

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

<div style="margin-top: 20px;">
    <h4>欢迎 <strong>${sessionScope.student.sName}</strong> 使用系统</h4>
</div>

<div style="margin-top: 20px;">
    <h4 style="color: #31B0D5">编辑课程信息</h4>
</div>

<div style="margin-top: 20px;display:inline-block;">
    <div>
        <div>
            <label style="font-size: 25px">课程号：</label>
            <input id="cId" name="cId" readonly type="text" value="${requestScope.course.cId}" style="height: 30px">
        </div>
        <div style="margin-top: 20px">
            <label style="font-size: 25px">课程名称：</label>
            <input id="cName" name="cName" type="text" value="${requestScope.course.cName}" style="height: 30px">
        </div>
        <div style="margin-top: 20px">
            <label style="font-size: 25px">任课教师：</label>
            <input id="cTeacher" name="cTeacher" value="${requestScope.course.cTeacher}" type="text" style="height: 30px">
        </div>
        <div style="margin-top: 20px">
            <button onclick="courseAdd()" style="margin-right: 60px;height: 35px;width: 90px">确定</button>
            <button style="margin-left: 60px;height: 35px;width: 90px">
                <a href="<%=PATH%>/courseShow" style="text-decoration: none;">返回</a>
            </button>
        </div>
    </div>
</div>
<script>
    <%--    添加课程--%>
    function courseAdd(){
        var cId = $("#cId").val();
        var cName = $("#cName").val();
        var cTeacher = $("#cTeacher").val();

        if (cId == ""){
            alert("请输入课程号");
        }else if(cName == ""){
            alert("请输入课程名称！");
        }else if(cTeacher == ""){
            alert("请输入任课老师！")
        }else {
            $.ajax({
                url:"<%=PATH%>/courseUpdate",
                type:"post",
                dataType:"json",
                data:{
                    cId:cId,
                    cName:cName,
                    cTeacher:cTeacher
                },
                success:function (data){
                    if(data.flag){
                        alert("课程编辑成功！");
                        document.location.href="<%=PATH%>/courseShow"
                    }else {
                        alert("课程编辑成功！");
                    }
                }
            })
        }

    }
</script>
</body>
</html>
