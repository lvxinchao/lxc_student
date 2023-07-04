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

<div style="margin-top: 20px;">
    <h4>欢迎 <strong>${sessionScope.student.sName}</strong> 使用系统</h4>
</div>

<div style="margin-top: 20px;">
    <h4 style="color: #31B0D5">添加成绩信息</h4>
</div>

<div style="margin-top: 20px;display:inline-block;">
    <div>
        <div>
            <label style="font-size: 25px">课程号：</label>
            <input id="c_id" name="cId" type="text" style="height: 30px">
        </div>
        <div style="margin-top: 20px">
            <label style="font-size: 25px">课程名称：</label>
            <input id="c_name" readonly name="cName" value="" type="text" style="height: 30px;margin-right: 30px;">
        </div>
        <div style="margin-top: 20px">
            <label style="font-size: 25px">学号：</label>
            <input id="s_id" name="s_id" value="" type="text" style="height: 30px">
        </div>
        <div style="margin-top: 20px">
            <label style="font-size: 25px">姓名：</label>
            <input id="s_name" readonly name="s_name" value="" type="text" style="height: 30px">
        </div>
        <div style="margin-top: 20px">
            <label style="font-size: 25px">成绩：</label>
            <input id="mark" name="mark" value="" type="text" style="height: 30px">
        </div>
        <div style="margin-top: 20px">
            <button onclick="gradeAdd()" style="margin-right: 60px;height: 35px;width: 90px">确定</button>
            <button style="margin-left: 60px;height: 35px;width: 90px">
                <a href="<%=PATH%>/markShow" style="text-decoration: none;">返回</a>
            </button>
        </div>
    </div>
</div>
<script>
<%--    添加成绩--%>
    function gradeAdd(){
        var c_id = $("#c_id").val();
        var s_id = $("#s_id").val();
        var mark = $("#mark").val();

        var c_name = $("#c_name").val();
        var s_name = $("#s_name").val();
        if (c_id == ""){
            alert("请输入课程号！");
        }else if(c_name == ""){
            alert("该门课程不存在，请输入正常的课程号！");
        } else if (s_id == ""){
            alert("请输入学号！");
        }else if(s_name == ""){
            alert("该学生不存在，请输入正确的学生号！")
        } else if (mark == ""){
            alert("请输入成绩！");
        }else {
            $.ajax({
                url:"<%=PATH%>/gradeAdd",
                type:"post",
                dataType:"json",
                data:{
                    c_id:c_id,
                    s_id:s_id,
                    mark:mark
                },
                success:function (data){
                    if (data.flag){
                        alert("学生成绩录入成功！");
                        document.location.href="<%=PATH%>/markShow";
                    }else {
                        alert(data.message)
                    }
                }
            })
        }
    }

    $(function (){
        $("#c_id").blur(function (){
            var c_id = $("#c_id").val();
            if (c_id != ""){
                $.ajax({
                    url:"<%=PATH%>/data",
                    type:"post",
                    dataType:"json",
                    data:{
                        c_id:c_id
                    },
                    success:function (data){
                        if (data.flag){
                            $("#c_name").val(data.course.cName);
                        }
                    }
                })
            }
        });

        $("#s_id").blur(function (){
            var s_id = $("#s_id").val();
            if (s_id != ""){
                $.ajax({
                    url:"<%=PATH%>/data",
                    type:"get",
                    dataType:"json",
                    data:{
                        s_id:s_id
                    },
                    success:function (data){
                        if (data.flag){
                            $("#s_name").val(data.student.sName);
                        }
                    }
                })
            }
        });
    })
</script>
</body>
</html>
