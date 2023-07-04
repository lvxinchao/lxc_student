<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page import="java.util.*"%>
<%@ page import="com.system.po.Student"%>
<%@ page import="com.system.util.PageBean"%>
<%
    String PATH = request.getScheme() +"://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page isELIgnored="false" %>
<%-- <%=PATH%>  --%>
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
    <script type="text/javascript">

        function goPage() {
            var n = document.getElementById("studentShow").value;
            window.location.href="<%=PATH%>/findAll_PageServlet?index="+n;
        }

        function changeSize(size) {
            location.href="<%=PATH%>/findAll_PageServlet?size="+size;
        }

        function change(index,size){
            location.href="<%=PATH%>/findAll_PageServlet?index="+index+"&size="+size;
        }
    </script>
</head>
<body style="text-align: center;">
<div style="margin-top: 90px;">
    <h1>学生成绩管理系统</h1>
</div>

<div style="margin-top: 20px;">
    <h4>欢迎 <strong>${sessionScope.student.sName}</strong> 使用系统</h4>
</div>

<div style="margin-top: 30px;display:inline-block;">
    <form method="get" action="<%=PATH%>/studentShow" style="float: left;">
        <label style="font-size: 17px">请输入学号：</label>
        <input type="text" name="num" style="height: 25px">
        <button type="submit" style="height: 30px;width: 90px">查询</button>
    </form>
    <div style="float: left;margin-left: 60px;">
        <button onclick="toStudentAdd()" style="color: blue;height: 30px;width: 90px">添加学生</button>
    </div>
    <div style="float: left;margin-left: 20px;">
        <button onclick="toShow()" style="color: red;height: 30px;width: 90px">返回</button>
    </div>
</div>

<div style="text-align: center;margin-top: 20px">
    <table style="margin: auto">
        <tr class="mytable">
            <th>学号</th>
            <th>姓名</th>
            <th>性别</th>
            <th>专业</th>
            <th>学院 </th>
            <th>操作</th>
        </tr>
        <c:forEach items="${pageBean.list }" var="item" >
            <tr class="double">
                <td>${item.id}</td>
                <td>${item.sName}</td>
                <td>${item.sex}</td>
                <td>${item.major}</td>
                <td>${item.collage}</td>
                <td>
                    <button onclick="studentToUpdate(${item.id})">修改</button>
                    <button onclick="studentDelete(${item.id})" style="color: red;">删除</button>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="6" align="center">

                <a href="javascript:change(1,${pageBean.size})">首页 </a>&nbsp;&nbsp;

                <c:if test="${pageBean.index!=1 }">

                    <a href="<%=PATH%>/findAll_PageServlet?index=${pageBean.index-1}&size=${pageBean.size}">上一页</a>&nbsp;&nbsp;

                </c:if>
                <c:if test="${pageBean.index==1 }">
                    上一页&nbsp;&nbsp;
                </c:if>

                <c:forEach items="${pageBean.numbers}" var="number">
                    <c:if test="${number==pageBean.index }">
                        [<a href="<%=PATH%>/findAll_PageServlet?index=${number}&size=${pageBean.size}">${number}</a>]&nbsp;&nbsp;
                    </c:if>
                    <c:if test="${number!=pageBean.index }">
                        <a href="<%=PATH%>/findAll_PageServlet?index=${number}&size=${pageBean.size}">${number}</a>&nbsp;&nbsp;
                    </c:if>
                </c:forEach>

                <c:if test="${pageBean.index!=pageBean.totalPageCount }">
                    <a href="<%=PATH%>/findAll_PageServlet?index=${pageBean.index+1}&size=${pageBean.size}">下一页</a>&nbsp;&nbsp;
                </c:if>
                <c:if test="${pageBean.index==pageBean.totalPageCount }">
                    下一页&nbsp;&nbsp;
                </c:if>

                <a href="<%=PATH%>/findAll_PageServlet?index=${pageBean.totalPageCount }&size=${pageBean.size}">末页</a>&nbsp;&nbsp;

                每页
                <select onchange="changeSize(this.value)" id="size">
                    <c:forEach begin="5" end="30" step="5" var="n">
                        <c:if test="${n==pageBean.size }">
                            <option var=${n} selected="selected">${n}</option>
                        </c:if>
                        <c:if test="${n!=pageBean.size }">
                            <option var=${n} >${n}</option>
                        </c:if>
                    </c:forEach>
                </select>
                记录

                共${pageBean.totalCount }条记录
            </td>

        </tr>


    </table>
</div>
<script>
<%--    去修改学生页面--%>
    function studentToUpdate(id){
        document.location.href="<%=PATH%>/studentUpdate?id="+id;
    }
<%--    删除学生--%>
    function studentDelete(id){
        var b = window.confirm("你确定要删除吗?");
        if(b == true){
            $.ajax({
                url:"<%=PATH%>/studentDelete",
                type:"post",
                dataType:"json",
                data:{
                    id:id
                },
                success:function (data){
                    if(data.flag){
                        alert("学生信息删除成功！");
                        document.location.href="<%=PATH%>/studentShow";
                    }else {
                        alert("学生信息删除失败！");
                    }
                }
            })
        }
    }
<%--    去添加学生页面--%>
    function toStudentAdd(){
        document.location.href="<%=PATH%>/studentAdd";
    }
<%--    去后台主页面--%>
    function toShow(){
        document.location.href="<%=PATH%>/show.jsp";
    }
</script>
</body>
</html>

