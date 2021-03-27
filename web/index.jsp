<%--
  Created by IntelliJ IDEA.
  User: Admin
  Date: 07.03.2021
  Time: 17:24
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html; techarset=UTF-8" %>
<html>
<head>
    <title>Module-2.4</title>
    <link href="${pageContext.request.contextPath}/css/index.css" rel="stylesheet" type="text/css">
</head>
<body>
<%-- This is starting page for module 2.4!--%>
<!-- header -->

<div style="text-align: center; color: #0000ff; background-color: bisque">
    <div>
        <h2>First application with REST</h2>
    </div>
</div>
    <div class="main">
        <div class="container">
            <div class="row-1">
                <div style="text-align: center; background-color: bisque; width: 450px">
                    <div>
                        <h2>Work with Customers</h2>
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
                            <h5>Press "1" for setting AccountStatus as "ACTIVE", Press "2" - "BANNED", Press "3" -
                                "DELETED",</h5>
                            Specialities: <label>
                            <input name="specialities"/>
                        </label>
                            <br><br>
                            <input type="submit" value="Add Customer"/>
                            <br><br>
                        </form>
                    </div>
                </div>

                <div style="text-align: center; background-color: bisque; width: 450px">
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

                <div style="text-align: center; background-color: bisque; width: 450px">
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
                            AccountValue (+) or (-) change: <label>
                            <input name="accountValue"/>
                        </label>
                            <br><br>
                            <input type="submit" value="Update Customer"/>
                            <br><br>
                        </form>
                    </div>
                </div>

                <div style="text-align: center; background-color: bisque; width: 450px">
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
            </div>

            <div class="row-2">
                <div style="text-align: center; background-color: bisque;  width: 450px">
                    <div>
                        <h2>Work with Accounts</h2>
                        <h3>Adding account to database</h3>
                    </div>

                    <div>
                        <form action="${pageContext.request.contextPath}accounts" method="POST">
                            AccountValue: <label>
                            <input name="account"/>
                        </label>
                            <br><br>
                            AccountStatus: <label>
                            <input name="accountStatus"/>
                        </label>
                            <h5>Press "1" for setting AccountStatus as "ACTIVE", Press "2" - "BANNED", Press "3" -
                                "DELETED",</h5>
                            <input type="submit" value="Add Account"/>
                            <br><br>
                        </form>
                    </div>
                </div>

                <div style="text-align: center; background-color: bisque;  width: 450px">
                    <div>
                        <h3>Getting account from database</h3>
                    </div>

                    <div>
                        <form action="${pageContext.request.contextPath}accounts" method="GET">
                            AccountID: <label>
                            <input name="accountID"/>
                        </label>
                            <br><br>
                            <input type="submit" value="Get Account"/>
                            <br><br>
                        </form>
                    </div>
                </div>

                <div style="text-align: center; background-color: bisque;  width: 450px">
                    <div>
                        <h3>Updating account in database</h3>
                    </div>

                    <div>
                        <form action="${pageContext.request.contextPath}accounts" method="POST">
                            <input type="hidden" name="action" value="put"/>
                            AccountID: <label>
                            <input name="accountID"/>
                        </label>
                            <br><br>
                            AccountValue (+) or (-) change: <label>
                            <input name="accountValue"/>
                        </label>
                            <br><br>
                            NewAccountStatus: <label>
                            <input name="accountStatus"/>
                        </label>
                            <h5>Press "1" for setting AccountStatus as "ACTIVE", Press "2" - "BANNED", Press "3" -
                                "DELETED",</h5>
                            <input type="submit" value="Update Account"/>
                            <br><br>
                        </form>
                    </div>
                </div>

                <div style="text-align: center; background-color: bisque;  width: 450px">
                    <div>
                        <h3>Deleting account from database</h3>
                    </div>

                    <div>
                        <form action="${pageContext.request.contextPath}accounts" method="POST">
                            <input type="hidden" name="action" value="delete"/>
                            AccountID: <label>
                            <input name="accountID"/>
                        </label>
                            <br><br>
                            <input type="submit" value="Delete Account"/>
                            <br><br>
                        </form>
                    </div>
                </div>
            </div>

            <div class="row-3">
                <div style="text-align: center; background-color: bisque;  width: 450px">
                    <div>
                        <h2>Work with Specialties</h2>
                        <h3>Adding specialties to database</h3>
                    </div>

                    <div>
                        <form action="${pageContext.request.contextPath}specialties" method="POST">
                            Specialties: <label>
                            <input name="specialties"/>
                        </label>
                            <br><br>
                            <input type="submit" value="Add Specialties"/>
                            <br><br>
                        </form>
                    </div>
                </div>

                <div style="text-align: center;; background-color: bisque;  width: 450px">
                    <div>
                        <h3>Getting specialties from database</h3>
                    </div>

                    <div>
                        <form action="${pageContext.request.contextPath}specialties" method="GET">
                            SpecialtiesID: <label>
                            <input name="specialtiesID"/>
                        </label>
                            <br><br>
                            <input type="submit" value="Get Specialties"/>
                            <br><br>
                        </form>
                    </div>
                </div>

                <div style="text-align: center; background-color: bisque;  width: 450px">
                    <div>
                        <h3>Updating specialties in database</h3>
                    </div>

                    <div>
                        <form action="${pageContext.request.contextPath}specialties" method="POST">
                            <input type="hidden" name="action" value="put"/>
                            SpecialtiesID: <label>
                            <input name="specialtiesID"/>
                        </label>
                            <br><br>
                            NewSpecialties: <label>
                            <input name="newSpecialties"/>
                        </label>
                            <br><br>
                            <input type="submit" value="Update Specialties"/>
                            <br><br>
                        </form>
                    </div>
                </div>

                <div style="text-align: center; background-color: bisque;  width: 450px">
                    <div>
                        <h3>Deleting specialties from database</h3>
                    </div>

                    <div>
                        <form action="${pageContext.request.contextPath}specialties" method="POST">
                            <input type="hidden" name="action" value="delete"/>
                            SpecialtiesID: <label>
                            <input name="specialtiesID"/>
                        </label>
                            <br><br>
                            <input type="submit" value="Delete Specialties"/>
                            <br><br>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</body>
</html>

