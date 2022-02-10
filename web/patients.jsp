<%@ page import="java.util.ArrayList" %>
<%@ page import="com.aigulsharip.java_ee.lecture5.db.Medication" %>
<%@ page import="com.aigulsharip.java_ee.lecture5.db.Patient" %><%--
  Created by IntelliJ IDEA.
  User: Aigul
  Date: 24.01.2022
  Time: 00:47
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title> Patients</title>
    <link rel = "stylesheet" type = "text/css" href = "bootstrap/css/bootstrap.min.css">

</head>
<body>

<div class = "container-fluid">
    <div class = "row">
        <div class="col-12">
            <%@include file="navbar.jsp"%>
        </div>
    </div>

    <div class = "container-fluid">
        <div class = "row">
            <div class = "col mx-auto">
                <table class = "table" >
                    <thead>
                    <tr>
                        <td>ID</td>
                        <td>FULL NAME</td>
                        <td>BIRTH DATE</td>
                        <td>GENDER</td>
                        <td>EMAIL</td>
                        <td>CITY</td>
                        <%
                            if (currentUser != null){
                        %>

                        <td width="5%">DETAILS</td>
                        <%
                            }
                        %>


                    </tr>
                    </thead>
                    <tbody>
                    <%
                        ArrayList<Patient> patients = (ArrayList<Patient>) request.getAttribute("patients");
                        if (patients != null) {
                            for (Patient patient : patients) {


                    %>
                    <tr>
                        <td><%=patient.getId()%></td>
                        <td><%=patient.getFullName()%></td>
                        <td><%=patient.getBirthDate()%></td>
                        <td><%=patient.getGender()%></td>
                        <td><%=patient.getEmail()%></td>
                        <td><%=patient.getCity()%></td>
                        <%
                            if (currentUser != null){
                        %>
                        <td><a href="/readPatient?id=<%=patient.getId()%>" class="btn btn-primary btn-sm">DETAILS</a></td>
                        <%
                            }
                        %>
                    </tr>
                    <%
                            }
                        }
                    %>
                    </tbody>
                </table>
            </div>

        </div>
    </div>

</div>





</body>
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js" integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p" crossorigin="anonymous"></script>

</html>
