<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07.03.2021
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Module-2.4</title>
</head>
<body>
<%-- This is starting page for module 2.4!--%>
<!-- header -->
<div style="text-align: center; color: blue">
    <div>
        <h2>First REST application</h2>
    </div>

    <div>       <!-- content -->
        <div>    <!-- buttons holder -->
            <button onclick="location.href='/list'">List users</button>
            <button onclick="location.href='/add'">Add user</button>
            <button onclick="location.href='/math?id=5'">Id</button>
        </div>
        <br><br>
        <form action="hello" method="POST">
            Name: <label>
            <input name="username"/>
        </label>
            <br><br>

            <input type="submit" value="Submit"/>
        </form>
    </div>
</div>


</body>
</html>
