<%--
  Created by IntelliJ IDEA.
  User: Mr.Sha
  Date: 2018/3/11
  Time: 15:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ page isELIgnored="false" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
   <table>
       <tr>
           <th>编号</th>
           <th>姓名</th>
           <th>年龄</th>
       </tr>
       <c:forEach items="${list}" var="li">
           <tr>
               <td>${li.uid}</td>
               <td>${li.uname}</td>
               <td>${li.age}</td>
           </tr>
       </c:forEach>
   </table>
</body>
</html>
