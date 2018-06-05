<%--
  Created by IntelliJ IDEA.
  User: henshin
  Date: 2018/5/16
  Time: 10:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>giserhub</title>
  </head>
  <body>
    <form action="/loginServlet" method="post">
        姓名<input type="text" name="name">
        密码<input type="password" name="pwd">
        <input type="submit">
    </form>
  </body>
</html>
