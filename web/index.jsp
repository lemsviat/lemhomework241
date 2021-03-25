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

<div style="text-align: center; color: blue; background-color: bisque">
    <div>
        <h2>First REST application</h2>
        <h3>Adding customers to database</h3>
    </div>

    <div>
        <form action="${pageContext.request.contextPath}customers" method="POST">
            Name: <label>
            <input name="username"/>
        </label>
            <br><br>
            Account: <label>
            <input name="account"/>
        </label>
            <br><br>
            AccountStatus: <label>
            <input name="accountStatus"/>
        </label>
            <h5>Press "1" for setting AccountStatus as "ACTIVE", Press "2" - "BANNED", Press "3" - "DELETED",</h5>
            Specialities: <label>
            <input name="specialities"/>
        </label>
            <br><br>
            <input type="submit" value="Add Customer"/>
            <br><br>
        </form>
    </div>
</div>

<div style="text-align: center; color: blue; background-color: bisque">
    <div>
        <h3>Getting customers from database</h3>
    </div>

    <div>
        <form action="${pageContext.request.contextPath}customers" method="GET">
            Name: <label>
            <input name="username"/>
        </label>
            <br><br>
            <input type="submit" value="Get Customer(s)"/>
            <br><br>
        </form>
    </div>
</div>

<div style="text-align: center; color: blue; background-color: bisque">
    <div>
        <h3>Updating customers in database</h3>
    </div>

    <div>
        <form action="${pageContext.request.contextPath}customers" method="POST">
            <input type="hidden" name="action" value="put"/>
            Name: <label>
            <input name="username"/>
        </label>
            <br><br>
            AccountValue: <label>
            <input name="accountValue"/>
        </label>
            <br><br>
            <input type="submit" value="Update Customer"/>
            <br><br>
        </form>
    </div>
</div>

<div style="text-align: center; color: blue; background-color: bisque">
    <div>
        <h3>Deleting customers from database</h3>
    </div>

    <div>
        <form action="${pageContext.request.contextPath}customers" method="POST">
            <input type="hidden" name="action" value="delete"/>
            Name: <label>
            <input name="username" id="userName"/>
        </label>
            <br><br>
            <input type="submit" value="Delete Customer"/>
            <br><br>
        </form>
    </div>
</div>

</body>
</html>

