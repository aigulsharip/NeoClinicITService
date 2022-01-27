<%--
  Created by IntelliJ IDEA.
  User: Aigul
  Date: 18.01.2022
  Time: 22:25
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>ADD STUDENT FORM</title>
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
            <form action="/addMedication" method="post">
                <div class="row mt-2">
                    <div class="col-12">
                        <label>Name: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert Name" name="name">
                    </div>
                </div>
                <div class="row mt-3">
                    <div class="col-12">
                        <label>Dosage: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert Dosage" name="dosage">
                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <label>Form: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <select class="form-select" name="form">
                            <option>bottle</option>
                            <option>ampoules</option>
                            <option>tablets</option>
                            <option>candles</option>

                        </select>


                    </div>
                </div>

                <div class="row mt-3">
                    <div class="col-12">
                        <label>Price: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert Price" name="price">
                    </div>
                </div>


                <div class="row mt-3">
                    <div class="col-12">
                        <label>Quantity: </label>
                    </div>
                </div>
                <div class="row mt-2">
                    <div class="col-12">
                        <input type="text" class="form-control" required placeholder="Insert quantity" name="quantity">
                    </div>
                </div>



                <div class="row mt-3">
                    <div class="col-12">
                        <button class="btn btn-success">Add Medication</button>
                    </div>
                </div>
            </form>
        </div>
    </div>
</div>



</body>
</html>
