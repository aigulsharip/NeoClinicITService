<%@ page import="java.util.ArrayList" %><%--
  Created by IntelliJ IDEA.
  User: Aigul
  Date: 18.01.2022
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD NOTE FORM</title>
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
            <form action="/addNote" method="post">
                <div class="row mt-2">
                    <div class="col-12">
                        <label>Patient name: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert Patient name" name="patient_name">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>NOTE TYPE: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert Note Type" name="note_type">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>CONTENT: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <textarea name = "content" class = "form-control" required row = "10"></textarea>
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <button class="btn btn-success"> Add Note</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>



</body>
</html>
