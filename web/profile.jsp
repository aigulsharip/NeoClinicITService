<%@ page import="java.util.ArrayList" %>
<%@ page import="com.aigulsharip.java_ee.lecture5.db.MedicationForm" %><%--
  Created by IntelliJ IDEA.
  User: Aigul
  Date: 18.01.2022
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Profile</title>
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
            <h2>
                Hello
                <%
                    if (currentUser != null) {
                        out.print(currentUser.getFullName());

                    }

                %>
            </h2>

        </div>
    </div>
</div>



</body>
</html>
