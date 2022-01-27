<%--
  Created by IntelliJ IDEA.
  User: Aigul
  Date: 26.01.2022
  Time: 19:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Login Page</title>
    <link rel = "stylesheet" type = "text/css" href = "bootstrap/css/bootstrap.min.css">

</head>
<body>

<div class="container-fluid">
    <div class="row">
        <div class="col-12">
            <%@include file="navbar.jsp"%>
        </div>
    </div>
</div>
<div class="container mt-3">
    <div class="row">
        <div class="col-6 mx-auto">
            <form action="/checkLogin" method="post">
                <div class="row mt-2">
                    <div class="col-12">
                        <label>EMAIL: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="email" class="form-control" required placeholder="Insert email" name="email">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>PASSWORD: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="password" class="form-control" required placeholder="Insert password" name="password">
                    </div>
                </div>
                 <div class="row mt-3">
                    <div class="col-12">
                        <button type="submit" class="btn btn-success">Login</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>




</body>
</html>
