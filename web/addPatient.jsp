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
    <title>ADD PATIENT FORM</title>
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
            <form action="/addPatient" method="post">
                <div class="row mt-2">
                    <div class="col-12">
                        <label>Full name: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert Full Name" name="full_name">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Birth Date: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="date" class="form-control" required placeholder="Insert Birth Date" name="birthdate">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <label>Gender: </label>
                    </div>
                </div>

                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert Gender" name="gender">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <label>Email: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert Email" name="email">
                    </div>
                </div>


                <div class="row mt-3">
                    <div class="col-12">
                        <label>City: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert City" name="city">
                    </div>
                </div>



                <div class="row mt-3">
                    <div class="col-12">
                        <button class="btn btn-success">Add Patient</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>



</body>
</html>
