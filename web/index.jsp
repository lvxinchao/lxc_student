<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%
  String PATH = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%-- <%=PATH%>  --%>
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
<body  style="text-align: center"  >

<div style="margin-top: 50px">
  <h1>吕新超-学生成绩管理系统</h1>
  <h3>请登录</h3>
</div>

<form method="post" action="<%=PATH%>/login">
  <div>
    <label style="font-size: 25px">账&nbsp&nbsp&nbsp&nbsp号：</label>
    <input id="username" name="username" type="text" style="height: 30px">
  </div>
  <div style="margin-top: 20px">
    <label style="font-size: 25px">密&nbsp&nbsp&nbsp&nbsp码：</label>
    <input id="password" name="password" type="password" style="height: 30px">
    <label style="font-size: 25px"> </label>
  </div>
  <%
    int var1=(int)((Math.random()*11)-1);
    int var2=(int)((Math.random()*11)-1);
    int var3=(int)((Math.random()*11)-1);
    int var4=(int)((Math.random()*11)-1);
//    String var=var1+""+var2+var3+var4;
  %>
  <div style="margin-top: 20px">
    <label style="font-size: 25px">验证码：</label>
    <input id="yanzhengma" name="yanzhengma" type="text" style="height: 30px">
    <label style="font-size: 10px">&nbsp&nbsp<br><br>&nbsp&nbsp&nbsp&nbsp</label>
    <img src="num/<%=var1%>.gif"width="18px" height="30px">
    <img src="num/<%=var2%>.gif"width="18px" height="30px">
    <img src="num/<%=var3%>.gif"width="18px" height="30px">
    <img src="num/<%=var4%>.gif"width="18px" height="30px">
  </div>
  <div style="margin-top: 8px">
    <label style="font-size: 25px">身&nbsp&nbsp份：</label>
    <input name="type" type="radio" value="管理员" checked style="font-size: 20px" >管理员
    <input name="type" type="radio" value="学生" style="font-size: 20px">学生
  </div>
  <div style="margin-top: 20px">
    <button type="submit" style="margin-right: 60px;height: 35px;width: 90px">登录</button>
      <a href="<%=PATH%>/register.jsp" style="text-decoration: none;">
        <input style="margin-left: 60px;height: 35px;width: 90px" type="button" value="注册">
      </a>
  </div>
</form>

</body>
</html>
