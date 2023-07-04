<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
    String PATH = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<html>
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
    <h4 style="color: #31B0D5">添加学生信息</h4>
</div>

<div style="margin-top: 20px;display:inline-block;">
    <div>
        <div>
            <label style="font-size: 25px">学号：</label>
            <input id="username" name="username" type="text" style="height: 30px">
        </div>
        <div style="margin-top: 20px">
            <label style="font-size: 25px">密码：</label>
            <input id="password" name="password" type="password" style="height: 30px">
        </div>
        <div style="margin-top: 20px">
            <label style="font-size: 25px">姓名：</label>
            <input id="name" name="name" type="text" style="height: 30px">
        </div>
        <div id="sex" style="margin-top: 20px">
            <label style="font-size: 25px">性别：</label>
            <input name="sex" type="radio" value="男" style="font-size: 20px" checked>男
            <input name="sex" type="radio" value="女" style="font-size: 20px">女
        </div>
        <div style="margin-top: 20px">
            <label style="font-size: 25px">专业：</label>
            <input id="major" name="username" type="text" style="height: 30px">
        </div>
        <div style="margin-top: 20px">
            <label style="font-size: 25px">学院：</label>
            <input id="college" name="username" type="text" style="height: 30px">
        </div>
        <div style="margin-top: 20px">
            <label style="font-size: 25px">类型：</label>
            <input id="type" name="type" type="radio" value="学生" style="font-size: 20px" checked>学生
        </div>
        <div style="margin-top: 20px">
            <button onclick="studentAdd()" style="margin-right: 60px;height: 35px;width: 90px">确定</button>
            <button style="margin-left: 60px;height: 35px;width: 90px">
                <a href="<%=PATH%>/studentShow" style="text-decoration: none;">返回</a>
            </button>
        </div>
    </div>
</div>
<script>

    function studentAdd(){
        var username = $("#username").val();
        var password = $("#password").val();
        var name = $("#name").val();
        var sex = $("#sex input:checked").val();
        var major = $("#major").val();
        var college = $("#college").val();
        var type = $("#type").val();

        if(username == ""){
            alert("请输入用户名！");
        }else if(password == ""){
            alert("请输入密码！");
        }else if(name == ""){
            alert("请输入姓名！");
        }else if(sex == ""){
            alert("请选择性别！");
        }else if(major ==""){
            alert("请输入专业！");
        }else if(college == ""){
            alert("请输入学院！");
        }else {
            $.ajax({
                url:"<%=PATH%>/studentAdd",
                type:"post",
                dataType:"json",
                data:{
                    username:username,
                    password:password,
                    name:name,
                    sex:sex,
                    major:major,
                    college:college,
                    type:type
                },
                success:function (data){
                    if(data.flag){
                        alert("学生添加成功！");
                        document.location.href = "<%=PATH%>/studentShow";
                    }else {
                        alert("学生添加失败！");
                    }
                }
            })
        }
    }
</script>
</body>
</html>

