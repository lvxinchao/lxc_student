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
    <style>body{ background:url("image/4.png");
        background-size: cover;}
    </style>
</head>
<body style="text-align: center">
<div style="margin-top: 50px">
    <h1>学生成绩管理系统</h1>
    <h3>请注册</h3>
</div>

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
        <label style="font-size: 25px">再次输入密码：</label>
        <input id="password2" name="password2" type="password" style="height: 30px;margin-right: 95px">
    </div>
    <div style="margin-top: 20px">
        <label style="font-size: 25px">姓名：</label>
        <input id="name" name="name" type="text" style="height: 30px">
    </div>
    <div id="sex" style="margin-top: 20px">
        <label style="font-size: 25px">性别：</label>
        <input name="sex" type="radio" value="男" checked="checked" style="font-size: 20px">男
        <input name="sex" type="radio" value="女" style="font-size: 20px">女
    </div>
    <div style="margin-top: 20px">
        <label style="font-size: 25px">专业：</label>
        <input id="major" name="major" type="text" style="height: 30px">
    </div>
    <div style="margin-top: 20px">
        <label style="font-size: 25px">学院：</label>
        <input id="college" name="college" type="text" style="height: 30px">
    </div>
    <div style="margin-top: 20px">
        <label style="font-size: 25px">类型：</label>
        <input id="type" name="type" type="radio" value="学生" checked="checked" style="font-size: 20px">学生
    </div>
    <div style="margin-top: 20px">
        <button onclick="studentAdd()" style="margin-right: 60px;height: 35px;width: 90px">确定</button>
        <a href="<%=PATH%>/index.jsp" style="text-decoration: none;">
            <input type="button" style="margin-left: 60px;height: 35px;width: 90px" value="返回"/>
        </a>
    </div>
</div>
<script>

    function studentAdd(){
        var username = $("#username").val();
        var password = $("#password").val();
        var password2 = $("#password2").val();
        var name = $("#name").val();
        var sex = $("#sex input:checked").val();
        var major = $("#major").val();
        var college = $("#college").val();
        var type = $("#type").val();

        if(username == ""){
            alert("请输入用户名！");
        }else if(password == ""){
            alert("请输入密码！");
        }else if(password2 == ""){
            alert("请再次输入密码！");
        }else if(name == ""){
            alert("请输入姓名！");
        }else if(sex == ""){
            alert("请选择性别！");
        }else if(major ==""){
            alert("请输入专业！");
        }else if(college == ""){
            alert("请输入学院！");
        }else if(password != password2){
            alert("两次密码输入不一致，请检查！");
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
                        alert("注册成功！");
                        document.location.href = "<%=PATH%>/";
                    }else {
                        alert("注册失败！");
                    }
                }
            })
        }
    }
</script>
</body>
</html>

