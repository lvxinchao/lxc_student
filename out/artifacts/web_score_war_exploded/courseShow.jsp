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
        body{ background:url("image/4.png");
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
    <script type="text/javascript">

        function goPage() {
            var n = document.getElementById("studentShow").value;
            window.location.href="<%=PATH%>/findCour_PageServlet?index="+n;
        }

        function changeSize(size) {
            location.href="<%=PATH%>/findCour_PageServlet?size="+size;
        }

        function change(index,size){
            location.href="<%=PATH%>/findCour_PageServlet?index="+index+"&size="+size;
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
    <form method="get" action="<%=PATH%>/courseShow" style="float: left;">
        <label style="font-size: 17px">请输入课程号：</label>
        <input type="text" name="courseKey" style="height: 25px">
        <button type="submit" style="height: 30px;width: 90px">查询</button>
    </form>
    <div style="float: left;margin-left: 120px;">
        <button onclick="toCourseAdd()" style="color: blue;height: 30px;width: 90px">添加课程</button>
    </div>
    <div style="float: left;margin-left: 20px;">
        <button onclick="toShow()" style="color: red;height: 30px;width: 90px">返回</button>
    </div>
</div>

<div style="text-align: center;margin-top: 20px">
    <table style="margin: auto">
        <tr class="mytable">
            <th style="width: 200px;">课程号</th>
            <th style="width: 200px;">课程名称</th>
            <th style="width: 200px;">任课教师</th>
            <th style="width: 150px;">操作</th>
        </tr>

        <c:forEach items="${courpageBean.list }" var="item" >
            <tr class="double">
                <td>${item.cId}</td>
                <td>${item.cName}</td>
                <td>${item.cTeacher}</td>
                <td>
                    <button onclick="toCourseUpdate(${item.cId})">修改</button>
                    <button onclick="courseDelete(${item.cId})" style="color: red;">删除</button>
                </td>
            </tr>
        </c:forEach>

        <tr>
            <td colspan="6" align="center">

                <a href="javascript:change(1,${courpageBean.size})">首页 </a>&nbsp;&nbsp;

                <c:if test="${courpageBean.index!=1 }">

                    <a href="<%=PATH%>/findCour_PageServlet?index=${courpageBean.index-1}&size=${courpageBean.size}">上一页</a>&nbsp;&nbsp;

                </c:if>
                <c:if test="${courpageBean.index==1 }">
                    上一页&nbsp;&nbsp;
                </c:if>

                <c:forEach items="${courpageBean.numbers}" var="number">
                    <c:if test="${number==courpageBean.index }">
                        [<a href="<%=PATH%>/findCour_PageServlet?index=${number}&size=${courpageBean.size}">${number}</a>]&nbsp;&nbsp;
                    </c:if>
                    <c:if test="${number!=courpageBean.index }">
                        <a href="<%=PATH%>/findCour_PageServlet?index=${number}&size=${courpageBean.size}">${number}</a>&nbsp;&nbsp;
                    </c:if>
                </c:forEach>

                <c:if test="${courpageBean.index!=courpageBean.totalPageCount }">
                    <a href="<%=PATH%>/findCour_PageServlet?index=${courpageBean.index+1}&size=${courpageBean.size}">下一页</a>&nbsp;&nbsp;
                </c:if>
                <c:if test="${courpageBean.index==courpageBean.totalPageCount }">
                    下一页&nbsp;&nbsp;
                </c:if>

                <a href="<%=PATH%>/findCour_PageServlet?index=${courpageBean.totalPageCount }&size=${courpageBean.size}">末页</a>&nbsp;&nbsp;

                每页
                <select onchange="changeSize(this.value)" id="size">
                    <c:forEach begin="5" end="30" step="5" var="n">
                        <c:if test="${n==courpageBean.size }">
                            <option var=${n} selected="selected">${n}</option>
                        </c:if>
                        <c:if test="${n!=courpageBean.size }">
                            <option var=${n} >${n}</option>
                        </c:if>
                    </c:forEach>
                </select>
                记录

                共${courpageBean.totalCount }条记录
            </td>

        </tr>


    </table>
</div>
<script>
<%--    修改课程--%>
    function toCourseUpdate(id){
        document.location.href="<%=PATH%>/courseUpdate?id="+id;
    }

<%--    删除课程--%>
    function courseDelete(id){
        var b = window.confirm("你确定要删除该课程吗?");
        if(b == true){
            $.ajax({
                url:"<%=PATH%>/courseDelete",
                type:"post",
                dataType:"json",
                data:{
                    id:id
                },
                success:function (data){
                    if(data.flag){
                       alert("课程删除成功！");
                       document.location.href="<%=PATH%>/courseShow";
                    }else {
                        alert("课程删除失败！");
                    }
                }
            })
        }
    }
<%--    去添加课程页面--%>
    function toCourseAdd(){
        document.location.href = "<%=PATH%>/courseAdd";
    }
<%--    去show页面--%>
    function toShow(){
        document.location.href = "<%=PATH%>/show.jsp"
    }
</script>
</body>
</html>
