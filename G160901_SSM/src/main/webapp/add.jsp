<%--
  Created by IntelliJ IDEA.
  User: Mr.Sha
  Date: 2018/3/11
  Time: 14:58
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="/addUser.action" method="post">
        用户名:<input type="text" name="uname"><br/>
        年龄:<input type="text" name="age"><br/>
        <input type="submit" value="提交">

    </form>

    <a href="/findAllUser.action">查询所有</a>

</body>
</html>
